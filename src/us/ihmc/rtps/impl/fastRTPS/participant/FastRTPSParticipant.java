package us.ihmc.rtps.impl.fastRTPS.participant;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import us.ihmc.rtps.TopicDataType;
import us.ihmc.rtps.attributes.ParticipantAttributes;
import us.ihmc.rtps.common.Guid;
import us.ihmc.rtps.impl.fastRTPS.DISCOVERY_STATUS;
import us.ihmc.rtps.impl.fastRTPS.NativeParticipantImpl;
import us.ihmc.rtps.impl.fastRTPS.NativeParticipantListener;
import us.ihmc.rtps.impl.fastRTPS.attributes.FastRTPSParticipantAttributes;
import us.ihmc.rtps.participant.Participant;
import us.ihmc.rtps.participant.ParticipantListener;

public class FastRTPSParticipant implements Participant
{
   private final NativeParticipantImpl impl;

   private final ArrayList<TopicDataType<?>> types = new ArrayList<>();
   
   private final FastRTPSParticipantAttributes attributes;
   private final ParticipantListener participantListener;

   private final Guid guid = new Guid();
   private final FastRTPSParticipantDiscoveryInfo discoveryInfo = new FastRTPSParticipantDiscoveryInfo();

   private class NativeParticipantListenerImpl extends NativeParticipantListener
   {

      @Override
      public void onParticipantDiscovery(long infoPtr, DISCOVERY_STATUS status)
      {
         if (participantListener != null)
         {
            discoveryInfo.updateInfo(status, this, infoPtr);
            participantListener.onParticipantDiscovery(FastRTPSParticipant.this, discoveryInfo);
         }
      }
   }

   public FastRTPSParticipant(ParticipantAttributes<?> att, ParticipantListener participantListener) throws IOException
   {
      if (att instanceof FastRTPSParticipantAttributes)
      {
         this.attributes = (FastRTPSParticipantAttributes) att;
         impl = new NativeParticipantImpl(attributes.rtps(), new NativeParticipantListenerImpl());
      }
      else
      {
         throw new IOException("ParticipantAttributes<?> is not of base class FastRTPSParticipantAttributes");
      }

      this.participantListener = participantListener;
      getGuid(guid);

   }

   public void delete()
   {
      impl.delete();
   }

   private void getGuid(Guid guid)
   {
      ByteBuffer guidBuffer = ByteBuffer.allocateDirect(Guid.GuidPrefix.size + Guid.Entity.size);
      impl.getGuid(guidBuffer);
      guidBuffer.clear();
      guid.fromByteBuffer(guidBuffer);
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public FastRTPSParticipantAttributes getAttributes()
   {
      return attributes;
   }

   @Override
   public int get_no_publisher(String target_topic)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int get_no_subscribers(String target_topic)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   public boolean registerType(TopicDataType<?> topicDataType)
   {
      if(topicDataType.getTypeSize() <= 0)
      {
         
      }
      return false;
   }
}
