/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class WireProtocolConfigQos extends QosPolicy {
  private transient long swigCPtr;

  protected WireProtocolConfigQos(long cPtr, boolean cMemoryOwn) {
    super(FastRTPSJNI.WireProtocolConfigQos_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(WireProtocolConfigQos obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FastRTPSJNI.delete_WireProtocolConfigQos(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public WireProtocolConfigQos() {
    this(FastRTPSJNI.new_WireProtocolConfigQos(), true);
  }

  public void clear() {
    FastRTPSJNI.WireProtocolConfigQos_clear(swigCPtr, this);
  }

  public void setPrefix(SWIGTYPE_p_eprosima__fastrtps__rtps__GuidPrefix_t value) {
    FastRTPSJNI.WireProtocolConfigQos_prefix_set(swigCPtr, this, SWIGTYPE_p_eprosima__fastrtps__rtps__GuidPrefix_t.getCPtr(value));
  }

  public SWIGTYPE_p_eprosima__fastrtps__rtps__GuidPrefix_t getPrefix() {
    return new SWIGTYPE_p_eprosima__fastrtps__rtps__GuidPrefix_t(FastRTPSJNI.WireProtocolConfigQos_prefix_get(swigCPtr, this), true);
  }

  public void setParticipant_id(int value) {
    FastRTPSJNI.WireProtocolConfigQos_participant_id_set(swigCPtr, this, value);
  }

  public int getParticipant_id() {
    return FastRTPSJNI.WireProtocolConfigQos_participant_id_get(swigCPtr, this);
  }

  public void setBuiltin(BuiltinAttributes value) {
    FastRTPSJNI.WireProtocolConfigQos_builtin_set(swigCPtr, this, BuiltinAttributes.getCPtr(value), value);
  }

  public BuiltinAttributes getBuiltin() {
    long cPtr = FastRTPSJNI.WireProtocolConfigQos_builtin_get(swigCPtr, this);
    return (cPtr == 0) ? null : new BuiltinAttributes(cPtr, false);
  }

  public void setPort(SWIGTYPE_p_eprosima__fastrtps__rtps__PortParameters value) {
    FastRTPSJNI.WireProtocolConfigQos_port_set(swigCPtr, this, SWIGTYPE_p_eprosima__fastrtps__rtps__PortParameters.getCPtr(value));
  }

  public SWIGTYPE_p_eprosima__fastrtps__rtps__PortParameters getPort() {
    return new SWIGTYPE_p_eprosima__fastrtps__rtps__PortParameters(FastRTPSJNI.WireProtocolConfigQos_port_get(swigCPtr, this), true);
  }

  public void setThroughput_controller(ThroughputControllerDescriptor value) {
    FastRTPSJNI.WireProtocolConfigQos_throughput_controller_set(swigCPtr, this, ThroughputControllerDescriptor.getCPtr(value), value);
  }

  public ThroughputControllerDescriptor getThroughput_controller() {
    long cPtr = FastRTPSJNI.WireProtocolConfigQos_throughput_controller_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ThroughputControllerDescriptor(cPtr, false);
  }

  public void setDefault_unicast_locator_list(LocatorList value) {
    FastRTPSJNI.WireProtocolConfigQos_default_unicast_locator_list_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getDefault_unicast_locator_list() {
    long cPtr = FastRTPSJNI.WireProtocolConfigQos_default_unicast_locator_list_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

  public void setDefault_multicast_locator_list(LocatorList value) {
    FastRTPSJNI.WireProtocolConfigQos_default_multicast_locator_list_set(swigCPtr, this, LocatorList.getCPtr(value), value);
  }

  public LocatorList getDefault_multicast_locator_list() {
    long cPtr = FastRTPSJNI.WireProtocolConfigQos_default_multicast_locator_list_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LocatorList(cPtr, false);
  }

}
