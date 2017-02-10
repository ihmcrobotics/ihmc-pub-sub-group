package us.ihmc.rtps.common;

public enum ChangeKind
{
   ALIVE, NOT_ALIVE_DISPOSED, NOT_ALIVE_UNREGISTERED, NOT_ALIVE_DISPOSED_UNREGISTERED;
   
   public static ChangeKind[] values = values();
}
