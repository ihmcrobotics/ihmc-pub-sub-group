package us.ihmc.idl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.eprosima.idl.generator.manager.TemplateGroup;
import com.eprosima.idl.generator.manager.TemplateManager;
import com.eprosima.idl.parser.grammar.IDLLexer;
import com.eprosima.idl.parser.grammar.IDLParser;
import com.eprosima.idl.parser.tree.AnnotationDeclaration;
import com.eprosima.idl.parser.tree.AnnotationMember;
import com.eprosima.idl.parser.tree.Definition;
import com.eprosima.idl.parser.tree.Specification;
import com.eprosima.idl.parser.typecode.PrimitiveTypeCode;
import com.eprosima.idl.parser.typecode.TypeCode;
import com.eprosima.idl.util.Util;
import com.eprosima.log.ColorMessage;

public class IDLGenerator
{
   private static final String pkg = "us.ihmc.idl.generated";
   private static final String idlFilename = "LaserScan.idl";

   
   public static void main(String[] args) throws IOException
   {
      System.out.println("Loading templates...");
      
      Field field;
      try
      {
         field = TemplateManager.class.getDeclaredField("m_loaderDirectories");
         field.setAccessible(true);
         field.set(null, "us/ihmc/idl/templates");
      }
      catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
      {
         throw new RuntimeException("API changed, fixme", e);
      }
      
      String onlyFileName = Util.getIDLFileNameOnly(idlFilename);

      Context ctx = new Context(onlyFileName, idlFilename, new ArrayList<>());
      

      // Create default @Key annotation.
      AnnotationDeclaration keyann = ctx.createAnnotationDeclaration("Key", null);
      keyann.addMember(new AnnotationMember("value", new PrimitiveTypeCode(TypeCode.KIND_BOOLEAN), "true"));

      // Create default @Topic annotation.
      AnnotationDeclaration topicann = ctx.createAnnotationDeclaration("Topic", null);
      topicann.addMember(new AnnotationMember("value", new PrimitiveTypeCode(TypeCode.KIND_BOOLEAN), "true"));

      // Create template manager
      TemplateManager tmanager = new TemplateManager("FastCdrCommon:Common");
      tmanager.addGroup("JavaSource");

      // Create main template
      TemplateGroup maintemplates = tmanager.createTemplateGroup("main");
      maintemplates.setAttribute("ctx", ctx);

      try
      {
         ANTLRFileStream input = new ANTLRFileStream(idlFilename);
         IDLLexer lexer = new IDLLexer(input);
         lexer.setContext(ctx);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         IDLParser parser = new IDLParser(tokens);
         // Pass the filename without the extension

         Specification specification = parser.specification(ctx, tmanager, maintemplates).spec;
         System.out.println(specification);

      }
      catch (FileNotFoundException ex)
      {
         System.out.println(ColorMessage.error("FileNotFounException") + "The File " + idlFilename + " was not found.");
      }

      File packageDir = new File(ctx.getPackageDir());
      if(packageDir.isDirectory() || packageDir.mkdirs())
      {
         TypesGenerator gen = new TypesGenerator(tmanager, ctx.getPackageDir() + "/", true);
         ArrayList<Definition> definitions = ctx.getDefinitions();
         gen.processDefinitions(ctx, definitions, ctx.getPackageDir() + "/", ctx.getPackage(), null);
      }
      else
      {
         System.out.println("Cannot create output dir " + packageDir);
      }
   }
 

}
