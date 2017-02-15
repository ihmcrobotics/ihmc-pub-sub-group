package us.ihmc.idl.generator;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.eprosima.idl.generator.manager.TemplateGroup;
import com.eprosima.idl.generator.manager.TemplateManager;
import com.eprosima.idl.parser.grammar.IDLLexer;
import com.eprosima.idl.parser.grammar.IDLParser;
import com.eprosima.idl.parser.tree.AnnotationDeclaration;
import com.eprosima.idl.parser.tree.AnnotationMember;
import com.eprosima.idl.parser.typecode.PrimitiveTypeCode;
import com.eprosima.idl.parser.typecode.TypeCode;
import com.eprosima.idl.util.Util;
import com.eprosima.log.ColorMessage;

/**
 * The IDL file parser and code generator. 
 * 
 * @author Jesper Smith
 *
 */
public class IDLGenerator
{

   public static void main(String[] args) throws IOException
   {
      FileDialog dialog = new FileDialog((Frame) null, "Select idl file", FileDialog.LOAD);
      dialog.setFile("*.idl");
      dialog.setVisible(true);
      String filename = dialog.getFile();
      if (filename == null)
      {
         return;
      }

      String res = JOptionPane.showInputDialog("Desired package path");

      if (res == null)
      {
         JOptionPane.showMessageDialog(null, "No package path given");
         return;
      }
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      fileChooser.setCurrentDirectory(new File("."));
      if (!(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION))
      {
         return;
      }

      execute(filename, res, fileChooser.getSelectedFile());
   }

   private static void execute(String idlFilename, String packageName, File targetDirectory) throws IOException
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
      ctx.setPackage(packageName);
      TypeCode.javapackage = ctx.getPackage() + ".";

      // Create default @Key annotation.
      AnnotationDeclaration keyann = ctx.createAnnotationDeclaration("Key", null);
      keyann.addMember(new AnnotationMember("value", new PrimitiveTypeCode(TypeCode.KIND_BOOLEAN), "true"));

      // Create default @Topic annotation.
      AnnotationDeclaration topicann = ctx.createAnnotationDeclaration("Topic", null);
      topicann.addMember(new AnnotationMember("value", new PrimitiveTypeCode(TypeCode.KIND_BOOLEAN), "true"));

      // Create template manager
      TemplateManager tmanager = new TemplateManager("FastCdrCommon:Common");

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

         parser.specification(ctx, tmanager, maintemplates);

      }
      catch (FileNotFoundException ex)
      {
         System.out.println(ColorMessage.error("FileNotFounException") + "The File " + idlFilename + " was not found.");
      }

      File packageDir = new File(targetDirectory, ctx.getPackageDir());
      if (packageDir.isDirectory() || packageDir.mkdirs())
      {
         TypesGenerator gen = new TypesGenerator(tmanager, ctx.getPackageDir() + "/", true);
         gen.generate(ctx, packageDir.getPath() + "/", ctx.getPackage(), null);
      }
      else
      {
         System.out.println("Cannot create output dir " + packageDir);
      }
   }

}
