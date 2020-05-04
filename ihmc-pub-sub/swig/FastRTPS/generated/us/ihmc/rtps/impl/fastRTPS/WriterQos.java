/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class WriterQos {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected WriterQos(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(WriterQos obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_WriterQos(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public WriterQos() {
    this(FastRTPSJNI.new_WriterQos(), true);
  }

  public void setM_durability(DurabilityQosPolicy value) {
    FastRTPSJNI.WriterQos_m_durability_set(swigCPtr, this, DurabilityQosPolicy.getCPtr(value), value);
  }

  public DurabilityQosPolicy getM_durability() {
    long cPtr = FastRTPSJNI.WriterQos_m_durability_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DurabilityQosPolicy(cPtr, false);
  }

  public void setM_durabilityService(DurabilityServiceQosPolicy value) {
    FastRTPSJNI.WriterQos_m_durabilityService_set(swigCPtr, this, DurabilityServiceQosPolicy.getCPtr(value), value);
  }

  public DurabilityServiceQosPolicy getM_durabilityService() {
    long cPtr = FastRTPSJNI.WriterQos_m_durabilityService_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DurabilityServiceQosPolicy(cPtr, false);
  }

  public void setM_deadline(DeadlineQosPolicy value) {
    FastRTPSJNI.WriterQos_m_deadline_set(swigCPtr, this, DeadlineQosPolicy.getCPtr(value), value);
  }

  public DeadlineQosPolicy getM_deadline() {
    long cPtr = FastRTPSJNI.WriterQos_m_deadline_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DeadlineQosPolicy(cPtr, false);
  }

  public void setM_latencyBudget(LatencyBudgetQosPolicy value) {
    FastRTPSJNI.WriterQos_m_latencyBudget_set(swigCPtr, this, LatencyBudgetQosPolicy.getCPtr(value), value);
  }

  public LatencyBudgetQosPolicy getM_latencyBudget() {
    long cPtr = FastRTPSJNI.WriterQos_m_latencyBudget_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LatencyBudgetQosPolicy(cPtr, false);
  }

  public void setM_liveliness(LivelinessQosPolicy value) {
    FastRTPSJNI.WriterQos_m_liveliness_set(swigCPtr, this, LivelinessQosPolicy.getCPtr(value), value);
  }

  public LivelinessQosPolicy getM_liveliness() {
    long cPtr = FastRTPSJNI.WriterQos_m_liveliness_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LivelinessQosPolicy(cPtr, false);
  }

  public void setM_reliability(ReliabilityQosPolicy value) {
    FastRTPSJNI.WriterQos_m_reliability_set(swigCPtr, this, ReliabilityQosPolicy.getCPtr(value), value);
  }

  public ReliabilityQosPolicy getM_reliability() {
    long cPtr = FastRTPSJNI.WriterQos_m_reliability_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ReliabilityQosPolicy(cPtr, false);
  }

  public void setM_lifespan(LifespanQosPolicy value) {
    FastRTPSJNI.WriterQos_m_lifespan_set(swigCPtr, this, LifespanQosPolicy.getCPtr(value), value);
  }

  public LifespanQosPolicy getM_lifespan() {
    long cPtr = FastRTPSJNI.WriterQos_m_lifespan_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LifespanQosPolicy(cPtr, false);
  }

  public void setM_userData(UserDataQosPolicy value) {
    FastRTPSJNI.WriterQos_m_userData_set(swigCPtr, this, UserDataQosPolicy.getCPtr(value), value);
  }

  public UserDataQosPolicy getM_userData() {
    long cPtr = FastRTPSJNI.WriterQos_m_userData_get(swigCPtr, this);
    return (cPtr == 0) ? null : new UserDataQosPolicy(cPtr, false);
  }

  public void setM_timeBasedFilter(TimeBasedFilterQosPolicy value) {
    FastRTPSJNI.WriterQos_m_timeBasedFilter_set(swigCPtr, this, TimeBasedFilterQosPolicy.getCPtr(value), value);
  }

  public TimeBasedFilterQosPolicy getM_timeBasedFilter() {
    long cPtr = FastRTPSJNI.WriterQos_m_timeBasedFilter_get(swigCPtr, this);
    return (cPtr == 0) ? null : new TimeBasedFilterQosPolicy(cPtr, false);
  }

  public void setM_ownership(OwnershipQosPolicy value) {
    FastRTPSJNI.WriterQos_m_ownership_set(swigCPtr, this, OwnershipQosPolicy.getCPtr(value), value);
  }

  public OwnershipQosPolicy getM_ownership() {
    long cPtr = FastRTPSJNI.WriterQos_m_ownership_get(swigCPtr, this);
    return (cPtr == 0) ? null : new OwnershipQosPolicy(cPtr, false);
  }

  public void setM_ownershipStrength(OwnershipStrengthQosPolicy value) {
    FastRTPSJNI.WriterQos_m_ownershipStrength_set(swigCPtr, this, OwnershipStrengthQosPolicy.getCPtr(value), value);
  }

  public OwnershipStrengthQosPolicy getM_ownershipStrength() {
    long cPtr = FastRTPSJNI.WriterQos_m_ownershipStrength_get(swigCPtr, this);
    return (cPtr == 0) ? null : new OwnershipStrengthQosPolicy(cPtr, false);
  }

  public void setM_destinationOrder(DestinationOrderQosPolicy value) {
    FastRTPSJNI.WriterQos_m_destinationOrder_set(swigCPtr, this, DestinationOrderQosPolicy.getCPtr(value), value);
  }

  public DestinationOrderQosPolicy getM_destinationOrder() {
    long cPtr = FastRTPSJNI.WriterQos_m_destinationOrder_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DestinationOrderQosPolicy(cPtr, false);
  }

  public void setM_presentation(PresentationQosPolicy value) {
    FastRTPSJNI.WriterQos_m_presentation_set(swigCPtr, this, PresentationQosPolicy.getCPtr(value), value);
  }

  public PresentationQosPolicy getM_presentation() {
    long cPtr = FastRTPSJNI.WriterQos_m_presentation_get(swigCPtr, this);
    return (cPtr == 0) ? null : new PresentationQosPolicy(cPtr, false);
  }

  public void setM_partition(PartitionQosPolicy value) {
    FastRTPSJNI.WriterQos_m_partition_set(swigCPtr, this, PartitionQosPolicy.getCPtr(value), value);
  }

  public PartitionQosPolicy getM_partition() {
    long cPtr = FastRTPSJNI.WriterQos_m_partition_get(swigCPtr, this);
    return (cPtr == 0) ? null : new PartitionQosPolicy(cPtr, false);
  }

  public void setM_topicData(TopicDataQosPolicy value) {
    FastRTPSJNI.WriterQos_m_topicData_set(swigCPtr, this, TopicDataQosPolicy.getCPtr(value), value);
  }

  public TopicDataQosPolicy getM_topicData() {
    long cPtr = FastRTPSJNI.WriterQos_m_topicData_get(swigCPtr, this);
    return (cPtr == 0) ? null : new TopicDataQosPolicy(cPtr, false);
  }

  public void setM_groupData(GroupDataQosPolicy value) {
    FastRTPSJNI.WriterQos_m_groupData_set(swigCPtr, this, GroupDataQosPolicy.getCPtr(value), value);
  }

  public GroupDataQosPolicy getM_groupData() {
    long cPtr = FastRTPSJNI.WriterQos_m_groupData_get(swigCPtr, this);
    return (cPtr == 0) ? null : new GroupDataQosPolicy(cPtr, false);
  }

  public void setM_publishMode(PublishModeQosPolicy value) {
    FastRTPSJNI.WriterQos_m_publishMode_set(swigCPtr, this, PublishModeQosPolicy.getCPtr(value), value);
  }

  public PublishModeQosPolicy getM_publishMode() {
    long cPtr = FastRTPSJNI.WriterQos_m_publishMode_get(swigCPtr, this);
    return (cPtr == 0) ? null : new PublishModeQosPolicy(cPtr, false);
  }

  public void setM_disablePositiveACKs(DisablePositiveACKsQosPolicy value) {
    FastRTPSJNI.WriterQos_m_disablePositiveACKs_set(swigCPtr, this, DisablePositiveACKsQosPolicy.getCPtr(value), value);
  }

  public DisablePositiveACKsQosPolicy getM_disablePositiveACKs() {
    long cPtr = FastRTPSJNI.WriterQos_m_disablePositiveACKs_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DisablePositiveACKsQosPolicy(cPtr, false);
  }

  public void setQos(WriterQos qos, boolean first_time) {
    FastRTPSJNI.WriterQos_setQos(swigCPtr, this, WriterQos.getCPtr(qos), qos, first_time);
  }

  public boolean checkQos() {
    return FastRTPSJNI.WriterQos_checkQos(swigCPtr, this);
  }

  public boolean canQosBeUpdated(WriterQos qos) {
    return FastRTPSJNI.WriterQos_canQosBeUpdated(swigCPtr, this, WriterQos.getCPtr(qos), qos);
  }

}
