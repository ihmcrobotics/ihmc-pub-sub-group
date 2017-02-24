package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.Locator.Kind;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;

public class FastRTPSCommonFunctions
{
   private static final int LOCATOR_KIND_RESERVED = 0;
   private static final int LOCATOR_KIND_UDPv4 = 1;
   private static final int LOCATOR_KIND_UDPv6 = 2;

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

}
