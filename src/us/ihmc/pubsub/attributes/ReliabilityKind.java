package us.ihmc.pubsub.attributes;

/**
 * Definition of the reliability QoS kind.
 * 
 * Note that subscribers and publishers needs to match reliability kind
 * 
 * @author Jesper Smith
 *
 */
public enum ReliabilityKind
{
   /**
    * Use reliable communication
    */
   RELIABLE,
   /**
    * Use best-effort communication 
    */
   BEST_EFFORT
}
