package us.ihmc.rtps.impl.fastRTPS;

import java.util.ArrayList;
import java.util.List;

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.Locator.Kind;
import us.ihmc.pubsub.attributes.OwnerShipPolicyKind;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;

public class FastRTPSCommonFunctions
{
   private static final int LOCATOR_KIND_RESERVED = 0;
   private static final int LOCATOR_KIND_UDPv4 = 1;
   private static final int LOCATOR_KIND_UDPv6 = 2;

   public static LocatorList_t convertToCPPLocatorList(List<Locator> in, LocatorList_t out)
   {
      out.clear();
      for (int i = 0; i < in.size(); i++)
      {
         Locator_t cLocator = new Locator_t();
         convertToCPPLocator(in.get(i), cLocator);
         out.push_back(cLocator);
         cLocator.delete();
      }
      return out;
   }

   public static void convertToJavaLocatorList(LocatorList_t in, ArrayList<Locator> out)
   {
      for (int i = 0; i < in.size(); i++)
      {
         Locator javaLocator = new Locator();
         convertToJavaLocator(FastRTPS.getLocator(in, i), javaLocator);

         out.add(javaLocator);
      }
   }

   public static void convertToJavaLocator(Locator_t in, Locator out)
   {
      switch (in.getKind())
      {
      case LOCATOR_KIND_UDPv4:
         out.setKind(Kind.LOCATOR_KIND_UDPv4);

         break;
      case LOCATOR_KIND_UDPv6:
         out.setKind(Kind.LOCATOR_KIND_UDPv6);
         break;
      case LOCATOR_KIND_RESERVED:
      default:
         out.setKind(Kind.LOCATOR_KIND_RESERVED);
         return;
      }

      for (int i = 0; i < 16; i++)
      {
         out.setOctet(i, (byte) FastRTPS.getLocatorOctet(i, in));
      }

      out.setPort((int) in.getPort());
   }

   public static void convertToCPPLocator(Locator in, Locator_t out)
   {
      switch (in.getKind())
      {
      case LOCATOR_KIND_UDPv4:
         out.setKind(LOCATOR_KIND_UDPv4);

         break;
      case LOCATOR_KIND_UDPv6:
         out.setKind(LOCATOR_KIND_UDPv6);
         break;
      case LOCATOR_KIND_RESERVED:
      default:
         out.setKind(LOCATOR_KIND_RESERVED);
         return;
      }

      for (int i = 0; i < 16; i++)
      {
         FastRTPS.setLocatorOctet(out, i, in.getOctet(i));
      }

      out.setPort((int) in.getPort());
   }

   public static TopicKind toJavaTopicKind(TopicKind_t topicKind)
   {
      if (topicKind == TopicKind_t.WITH_KEY)
      {
         return TopicKind.WITH_KEY;
      }
      else
      {
         return TopicKind.NO_KEY;
      }
   }

   public static TopicKind_t toCPPTopicKind_t(TopicKind topicKind)
   {
      if (topicKind == TopicKind.WITH_KEY)
      {
         return TopicKind_t.WITH_KEY;
      }
      else
      {
         return TopicKind_t.NO_KEY;
      }
   }

   public static ReliabilityQosPolicyKind toCppReliabilityQosPolicyKind(ReliabilityKind reliabilityKind)
   {
      switch(reliabilityKind)
      {
      case BEST_EFFORT:
         return ReliabilityQosPolicyKind.BEST_EFFORT_RELIABILITY_QOS;
      case RELIABLE:
         return ReliabilityQosPolicyKind.RELIABLE_RELIABILITY_QOS;
      }
      return null;
   }
   
   public static ReliabilityKind toJavaReliabilityKind(ReliabilityQosPolicyKind reliabilityKind_t)
   {
      if(reliabilityKind_t == ReliabilityQosPolicyKind.BEST_EFFORT_RELIABILITY_QOS)
      {
         return ReliabilityKind.BEST_EFFORT;
      }
      else
      {
         return ReliabilityKind.RELIABLE;
      }
   }
   
   public static ReliabilityKind_t toCppReliabilityKind(ReliabilityKind reliabilityKind)
   {
      switch(reliabilityKind)
      {
      case BEST_EFFORT:
         return ReliabilityKind_t.BEST_EFFORT;
      case RELIABLE:
         return ReliabilityKind_t.RELIABLE;
      }
      return null;
   }
   
   public static ReliabilityKind toJavaReliabilityKind(ReliabilityKind_t reliabilityKind_t)
   {
      if(reliabilityKind_t == ReliabilityKind_t.BEST_EFFORT)
      {
         return ReliabilityKind.BEST_EFFORT;
      }
      else
      {
         return ReliabilityKind.RELIABLE;
      }
   }
   
   public static DurabilityKind toJavaDurabilityKind(DurabilityQosPolicyKind_t kind)
   {
      if(kind == DurabilityQosPolicyKind_t.PERSISTENT_DURABILITY_QOS)
      {
         return DurabilityKind.PERSISTENT_DURABILITY_QOS;
      }
      else if (kind == DurabilityQosPolicyKind_t.TRANSIENT_DURABILITY_QOS)
      {
         return DurabilityKind.TRANSIENT_DURABILITY_QOS;
      }
      else if (kind == DurabilityQosPolicyKind_t.TRANSIENT_LOCAL_DURABILITY_QOS)
      {
         return DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS;
      }
      else if (kind == DurabilityQosPolicyKind_t.VOLATILE_DURABILITY_QOS)
      {
         return DurabilityKind.VOLATILE_DURABILITY_QOS;
      }
      return null;
   }
   
   public static DurabilityQosPolicyKind_t toCppDurabilityKind(DurabilityKind kind)
   {
      if(kind == DurabilityKind.PERSISTENT_DURABILITY_QOS)
      {
         return DurabilityQosPolicyKind_t.PERSISTENT_DURABILITY_QOS;
      }
      else if (kind == DurabilityKind.TRANSIENT_DURABILITY_QOS)
      {
         return DurabilityQosPolicyKind_t.TRANSIENT_DURABILITY_QOS;
      }
      else if (kind == DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS)
      {
         return DurabilityQosPolicyKind_t.TRANSIENT_LOCAL_DURABILITY_QOS;
      }
      else if (kind == DurabilityKind.VOLATILE_DURABILITY_QOS)
      {
         return DurabilityQosPolicyKind_t.VOLATILE_DURABILITY_QOS;
      }
      return null;
   }
   
   public static OwnerShipPolicyKind toJavaOwnershipQosPolicyKind(OwnershipQosPolicyKind kind)
   {
      if(kind == OwnershipQosPolicyKind.EXCLUSIVE_OWNERSHIP_QOS)
      {
         return OwnerShipPolicyKind.EXCLUSIVE_OWNERSHIP_QOS;
      }
      else
      {
         return OwnerShipPolicyKind.SHARED_OWNERSHIP_QOS;
      }
   }
   
   public static OwnershipQosPolicyKind toCppOwnershipQosPolicyKind(OwnerShipPolicyKind kind)
   {
      if(kind == OwnerShipPolicyKind.EXCLUSIVE_OWNERSHIP_QOS)
      {
         return OwnershipQosPolicyKind.EXCLUSIVE_OWNERSHIP_QOS;
      }
      else
      {
         return OwnershipQosPolicyKind.SHARED_OWNERSHIP_QOS;
      }
   }
}
