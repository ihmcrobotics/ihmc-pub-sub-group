package us.ihmc.pubsub.common;

/**
 * Enum DISCOVERY_STATUS, three different status for discovered participants
 *
 * @author Jesper Smith
 */
public enum DiscoveryStatus
{
   DISCOVERED_RTPSPARTICIPANT, CHANGED_QOS_RTPSPARTICIPANT, REMOVED_RTPSPARTICIPANT;
   
   public static DiscoveryStatus[] values = values();
}
