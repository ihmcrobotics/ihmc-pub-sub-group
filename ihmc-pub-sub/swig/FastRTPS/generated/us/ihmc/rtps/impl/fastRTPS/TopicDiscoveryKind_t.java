/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class TopicDiscoveryKind_t {
  public final static TopicDiscoveryKind_t NO_CHECK = new TopicDiscoveryKind_t("NO_CHECK");
  public final static TopicDiscoveryKind_t MINIMAL = new TopicDiscoveryKind_t("MINIMAL");
  public final static TopicDiscoveryKind_t COMPLETE = new TopicDiscoveryKind_t("COMPLETE");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static TopicDiscoveryKind_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + TopicDiscoveryKind_t.class + " with value " + swigValue);
  }

  private TopicDiscoveryKind_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private TopicDiscoveryKind_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private TopicDiscoveryKind_t(String swigName, TopicDiscoveryKind_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static TopicDiscoveryKind_t[] swigValues = { NO_CHECK, MINIMAL, COMPLETE };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
