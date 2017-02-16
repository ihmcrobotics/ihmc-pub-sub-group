package us.ihmc.idl;

public class IDLTools
{
   public static boolean equals(StringBuilder a, StringBuilder b)
   {
      if(a.length() == b.length())
      {
         for(int i = 0; i < a.length(); i++)
         {
            if(a.charAt(i) != b.charAt(i))
            {
               return false;
            }
         }
      }
      else
      {
         return false;
      }
      
      return true;
   }
}
