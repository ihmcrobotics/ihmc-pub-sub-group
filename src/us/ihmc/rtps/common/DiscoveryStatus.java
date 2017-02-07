package us.ihmc.rtps.common;

public enum DiscoveryStatus
{
   DISCOVERED_RTPSPARTICIPANT, CHANGED_QOS_RTPSPARTICIPANT, REMOVED_RTPSPARTICIPANT;
   
   public static DiscoveryStatus[] values = values();
}
