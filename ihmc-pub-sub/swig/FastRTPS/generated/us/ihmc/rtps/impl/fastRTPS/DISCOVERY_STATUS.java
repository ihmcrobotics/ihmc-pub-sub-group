/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class DISCOVERY_STATUS {
  public final static DISCOVERY_STATUS DISCOVERED_RTPSPARTICIPANT = new DISCOVERY_STATUS("DISCOVERED_RTPSPARTICIPANT");
  public final static DISCOVERY_STATUS CHANGED_QOS_RTPSPARTICIPANT = new DISCOVERY_STATUS("CHANGED_QOS_RTPSPARTICIPANT");
  public final static DISCOVERY_STATUS REMOVED_RTPSPARTICIPANT = new DISCOVERY_STATUS("REMOVED_RTPSPARTICIPANT");
  public final static DISCOVERY_STATUS DROPPED_RTPSPARTICIPANT = new DISCOVERY_STATUS("DROPPED_RTPSPARTICIPANT");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static DISCOVERY_STATUS swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + DISCOVERY_STATUS.class + " with value " + swigValue);
  }

  private DISCOVERY_STATUS(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private DISCOVERY_STATUS(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private DISCOVERY_STATUS(String swigName, DISCOVERY_STATUS swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static DISCOVERY_STATUS[] swigValues = { DISCOVERED_RTPSPARTICIPANT, CHANGED_QOS_RTPSPARTICIPANT, REMOVED_RTPSPARTICIPANT, DROPPED_RTPSPARTICIPANT };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

