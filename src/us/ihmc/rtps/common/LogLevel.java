package us.ihmc.rtps.common;

public enum LogLevel
{
   ERROR(0), WARNING(1), INFO(2);

   private final int level;

   LogLevel(int level)
   {
      this.level = level;
   }

   public int getLevel()
   {
      return level;
   }
}
