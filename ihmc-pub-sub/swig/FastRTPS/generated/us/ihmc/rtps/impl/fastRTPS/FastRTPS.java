/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public class FastRTPS implements FastRTPSConstants {
  public static SWIGTYPE_p_unsigned_char new_charArray(int nelements) {
    long cPtr = FastRTPSJNI.new_charArray(nelements);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public static void delete_charArray(SWIGTYPE_p_unsigned_char ary) {
    FastRTPSJNI.delete_charArray(SWIGTYPE_p_unsigned_char.getCPtr(ary));
  }

  public static short charArray_getitem(SWIGTYPE_p_unsigned_char ary, int index) {
    return FastRTPSJNI.charArray_getitem(SWIGTYPE_p_unsigned_char.getCPtr(ary), index);
  }

  public static void charArray_setitem(SWIGTYPE_p_unsigned_char ary, int index, short value) {
    FastRTPSJNI.charArray_setitem(SWIGTYPE_p_unsigned_char.getCPtr(ary), index, value);
  }

  public static java.nio.ByteBuffer new_octetArray(int nelements) {  
  return FastRTPSJNI.new_octetArray(nelements);  
}

  public static void delete_octetArray(java.nio.ByteBuffer ary) {
  assert ary.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.delete_octetArray(ary);
    }
  }

  public static short octetArray_getitem(java.nio.ByteBuffer ary, int index) {
  assert ary.isDirect() : "Buffer must be allocated direct.";
    {
      return FastRTPSJNI.octetArray_getitem(ary, index);
    }
  }

  public static void octetArray_setitem(java.nio.ByteBuffer ary, int index, short value) {
  assert ary.isDirect() : "Buffer must be allocated direct.";
    {
      FastRTPSJNI.octetArray_setitem(ary, index, value);
    }
  }

  public static boolean IsAddressDefined(Locator_t loc) {
    return FastRTPSJNI.IsAddressDefined(Locator_t.getCPtr(loc), loc);
  }

  public static boolean IsLocatorValid(Locator_t loc) {
    return FastRTPSJNI.IsLocatorValid(Locator_t.getCPtr(loc), loc);
  }

  public static int getDEFAULT_ROS2_SERVER_PORT() {
    return FastRTPSJNI.DEFAULT_ROS2_SERVER_PORT_get();
  }

  public static String getDEFAULT_ROS2_SERVER_GUIDPREFIX() {
    return FastRTPSJNI.DEFAULT_ROS2_SERVER_GUIDPREFIX_get();
  }

  public static String getDEFAULT_ROS2_MASTER_URI() {
    return FastRTPSJNI.DEFAULT_ROS2_MASTER_URI_get();
  }

  public static boolean load_environment_server_info(String list, SWIGTYPE_p_std__listT_eprosima__fastdds__rtps__RemoteServerAttributes_t attributes) {
    return FastRTPSJNI.load_environment_server_info__SWIG_0(list, SWIGTYPE_p_std__listT_eprosima__fastdds__rtps__RemoteServerAttributes_t.getCPtr(attributes));
  }

  public static boolean load_environment_server_info(SWIGTYPE_p_std__listT_eprosima__fastdds__rtps__RemoteServerAttributes_t attributes) {
    return FastRTPSJNI.load_environment_server_info__SWIG_1(SWIGTYPE_p_std__listT_eprosima__fastdds__rtps__RemoteServerAttributes_t.getCPtr(attributes));
  }

  public static String ros_discovery_server_env() {
    return FastRTPSJNI.ros_discovery_server_env();
  }

  public static boolean get_server_client_default_guidPrefix(int id, SWIGTYPE_p_eprosima__fastrtps__rtps__GuidPrefix_t guid) {
    return FastRTPSJNI.get_server_client_default_guidPrefix(id, SWIGTYPE_p_eprosima__fastrtps__rtps__GuidPrefix_t.getCPtr(guid));
  }

  public static DurabilityQosPolicyKind_t getVOLATILE_DURABILITY_QOS() {
    return DurabilityQosPolicyKind_t.swigToEnum(FastRTPSJNI.VOLATILE_DURABILITY_QOS_get());
  }

  public static DurabilityQosPolicyKind_t getTRANSIENT_LOCAL_DURABILITY_QOS() {
    return DurabilityQosPolicyKind_t.swigToEnum(FastRTPSJNI.TRANSIENT_LOCAL_DURABILITY_QOS_get());
  }

  public static DurabilityQosPolicyKind_t getTRANSIENT_DURABILITY_QOS() {
    return DurabilityQosPolicyKind_t.swigToEnum(FastRTPSJNI.TRANSIENT_DURABILITY_QOS_get());
  }

  public static DurabilityQosPolicyKind_t getPERSISTENT_DURABILITY_QOS() {
    return DurabilityQosPolicyKind_t.swigToEnum(FastRTPSJNI.PERSISTENT_DURABILITY_QOS_get());
  }

  public static LivelinessQosPolicyKind getAUTOMATIC_LIVELINESS_QOS() {
    return LivelinessQosPolicyKind.swigToEnum(FastRTPSJNI.AUTOMATIC_LIVELINESS_QOS_get());
  }

  public static LivelinessQosPolicyKind getMANUAL_BY_PARTICIPANT_LIVELINESS_QOS() {
    return LivelinessQosPolicyKind.swigToEnum(FastRTPSJNI.MANUAL_BY_PARTICIPANT_LIVELINESS_QOS_get());
  }

  public static LivelinessQosPolicyKind getMANUAL_BY_TOPIC_LIVELINESS_QOS() {
    return LivelinessQosPolicyKind.swigToEnum(FastRTPSJNI.MANUAL_BY_TOPIC_LIVELINESS_QOS_get());
  }

  public static ReliabilityQosPolicyKind getBEST_EFFORT_RELIABILITY_QOS() {
    return ReliabilityQosPolicyKind.swigToEnum(FastRTPSJNI.BEST_EFFORT_RELIABILITY_QOS_get());
  }

  public static ReliabilityQosPolicyKind getRELIABLE_RELIABILITY_QOS() {
    return ReliabilityQosPolicyKind.swigToEnum(FastRTPSJNI.RELIABLE_RELIABILITY_QOS_get());
  }

  public static OwnershipQosPolicyKind getSHARED_OWNERSHIP_QOS() {
    return OwnershipQosPolicyKind.swigToEnum(FastRTPSJNI.SHARED_OWNERSHIP_QOS_get());
  }

  public static OwnershipQosPolicyKind getEXCLUSIVE_OWNERSHIP_QOS() {
    return OwnershipQosPolicyKind.swigToEnum(FastRTPSJNI.EXCLUSIVE_OWNERSHIP_QOS_get());
  }

  public static DestinationOrderQosPolicyKind getBY_RECEPTION_TIMESTAMP_DESTINATIONORDER_QOS() {
    return DestinationOrderQosPolicyKind.swigToEnum(FastRTPSJNI.BY_RECEPTION_TIMESTAMP_DESTINATIONORDER_QOS_get());
  }

  public static DestinationOrderQosPolicyKind getBY_SOURCE_TIMESTAMP_DESTINATIONORDER_QOS() {
    return DestinationOrderQosPolicyKind.swigToEnum(FastRTPSJNI.BY_SOURCE_TIMESTAMP_DESTINATIONORDER_QOS_get());
  }

  public static PresentationQosPolicyAccessScopeKind getINSTANCE_PRESENTATION_QOS() {
    return PresentationQosPolicyAccessScopeKind.swigToEnum(FastRTPSJNI.INSTANCE_PRESENTATION_QOS_get());
  }

  public static PresentationQosPolicyAccessScopeKind getTOPIC_PRESENTATION_QOS() {
    return PresentationQosPolicyAccessScopeKind.swigToEnum(FastRTPSJNI.TOPIC_PRESENTATION_QOS_get());
  }

  public static PresentationQosPolicyAccessScopeKind getGROUP_PRESENTATION_QOS() {
    return PresentationQosPolicyAccessScopeKind.swigToEnum(FastRTPSJNI.GROUP_PRESENTATION_QOS_get());
  }

  public static HistoryQosPolicyKind getKEEP_LAST_HISTORY_QOS() {
    return HistoryQosPolicyKind.swigToEnum(FastRTPSJNI.KEEP_LAST_HISTORY_QOS_get());
  }

  public static HistoryQosPolicyKind getKEEP_ALL_HISTORY_QOS() {
    return HistoryQosPolicyKind.swigToEnum(FastRTPSJNI.KEEP_ALL_HISTORY_QOS_get());
  }

  public static PublishModeQosPolicyKind_t getSYNCHRONOUS_PUBLISH_MODE() {
    return PublishModeQosPolicyKind_t.swigToEnum(FastRTPSJNI.SYNCHRONOUS_PUBLISH_MODE_get());
  }

  public static PublishModeQosPolicyKind_t getASYNCHRONOUS_PUBLISH_MODE() {
    return PublishModeQosPolicyKind_t.swigToEnum(FastRTPSJNI.ASYNCHRONOUS_PUBLISH_MODE_get());
  }

  public static TypeConsistencyKind getDISALLOW_TYPE_COERCION() {
    return TypeConsistencyKind.swigToEnum(FastRTPSJNI.DISALLOW_TYPE_COERCION_get());
  }

  public static TypeConsistencyKind getALLOW_TYPE_COERCION() {
    return TypeConsistencyKind.swigToEnum(FastRTPSJNI.ALLOW_TYPE_COERCION_get());
  }

  public static DataSharingKind getAUTO() {
    return DataSharingKind.swigToEnum(FastRTPSJNI.AUTO_get());
  }

  public static DataSharingKind getON() {
    return DataSharingKind.swigToEnum(FastRTPSJNI.ON_get());
  }

  public static DataSharingKind getOFF() {
    return DataSharingKind.swigToEnum(FastRTPSJNI.OFF_get());
  }

  public static int getLENGTH_UNLIMITED() {
    return FastRTPSJNI.LENGTH_UNLIMITED_get();
  }

  public static short getLocatorOctet(int octet, Locator_t locator) {
    return FastRTPSJNI.getLocatorOctet(octet, Locator_t.getCPtr(locator), locator);
  }

  public static void setLocatorOctet(Locator_t locator, int oct, short value) {
    FastRTPSJNI.setLocatorOctet(Locator_t.getCPtr(locator), locator, oct, value);
  }

  public static Locator_t getLocator(LocatorList list, int index) {
    long cPtr = FastRTPSJNI.getLocator(LocatorList.getCPtr(list), list, index);
    return (cPtr == 0) ? null : new Locator_t(cPtr, false);
  }

  public static Locator_t getRemoteUnicastLocator(RemoteLocatorList list, int index) {
    long cPtr = FastRTPSJNI.getRemoteUnicastLocator(RemoteLocatorList.getCPtr(list), list, index);
    return (cPtr == 0) ? null : new Locator_t(cPtr, false);
  }

  public static Locator_t getRemoteMulticastLocator(RemoteLocatorList list, int index) {
    long cPtr = FastRTPSJNI.getRemoteMulticastLocator(RemoteLocatorList.getCPtr(list), list, index);
    return (cPtr == 0) ? null : new Locator_t(cPtr, false);
  }

  public static int getRemoteMulticastLocatorSize(RemoteLocatorList list) {
    return FastRTPSJNI.getRemoteMulticastLocatorSize(RemoteLocatorList.getCPtr(list), list);
  }

  public static int getRemoteUnicastLocatorSize(RemoteLocatorList list) {
    return FastRTPSJNI.getRemoteUnicastLocatorSize(RemoteLocatorList.getCPtr(list), list);
  }

  public static void setRemoteServerAttributesDefaultGUIDPrefix(RemoteServerAttributes attributes, int serverId) {
    FastRTPSJNI.setRemoteServerAttributesDefaultGUIDPrefix(RemoteServerAttributes.getCPtr(attributes), attributes, serverId);
  }

  public static void pushRemoteServerAttributes(SWIGTYPE_p_std__listT_eprosima__fastdds__rtps__RemoteServerAttributes_t list, RemoteServerAttributes attributes) {
    FastRTPSJNI.pushRemoteServerAttributes(SWIGTYPE_p_std__listT_eprosima__fastdds__rtps__RemoteServerAttributes_t.getCPtr(list), RemoteServerAttributes.getCPtr(attributes), attributes);
  }

}
