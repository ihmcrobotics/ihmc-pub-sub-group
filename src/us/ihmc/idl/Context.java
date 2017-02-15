package us.ihmc.idl;

import java.util.ArrayList;

public class Context extends com.eprosima.idl.context.Context  
{
   private String m_package;
   private String m_onlypackage;
   private String m_packageDir;
   
   public Context(String arg0, String arg1, ArrayList<String> arg2)
   {
      super(arg0, arg1, arg2);
      
      setPackage("us.ihmc.idl");
   }

   
   public void setPackage(String pack)
   {
       if(pack != null && !pack.isEmpty())
       {
           m_package = pack;
           m_onlypackage = pack;
           m_packageDir = m_package.replace('.', '/');
       }
   }

   public boolean isIsPackageEmpty()
   {
       return m_package.isEmpty();
   }

   public String getPackage()
   {
       return m_package;
   }

   public String getOnlyPackage()
   {
       return m_onlypackage;
   }

   public String getPackageDir()
   {
       return m_packageDir;
   }

   public String getPackageUnder()
   {
       return m_package.replace('.', '_');
   }
   
   @Override
   public StructTypeCode createStructTypeCode(String name)
   {
       return new StructTypeCode(getScope(), name);
   }

   public boolean isPrintexception()
   {
      return false;
   }

   public boolean isPrintoperation()
   {
      return false;
   }

   public String getProduct()
   {
      return "IHMC IDL Generator";
   }

   public String getNamespace()
   {
      return "fastcdr";
   }

   public boolean isCdr()
   {
      return true;
   }

   public boolean isFastcdr()
   {
      return false;
   }

}
