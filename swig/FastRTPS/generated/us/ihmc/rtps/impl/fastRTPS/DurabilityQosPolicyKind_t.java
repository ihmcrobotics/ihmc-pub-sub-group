/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class DurabilityQosPolicyKind_t {
  public final static DurabilityQosPolicyKind_t VOLATILE_DURABILITY_QOS = new DurabilityQosPolicyKind_t("VOLATILE_DURABILITY_QOS");
  public final static DurabilityQosPolicyKind_t TRANSIENT_LOCAL_DURABILITY_QOS = new DurabilityQosPolicyKind_t("TRANSIENT_LOCAL_DURABILITY_QOS");
  public final static DurabilityQosPolicyKind_t TRANSIENT_DURABILITY_QOS = new DurabilityQosPolicyKind_t("TRANSIENT_DURABILITY_QOS");
  public final static DurabilityQosPolicyKind_t PERSISTENT_DURABILITY_QOS = new DurabilityQosPolicyKind_t("PERSISTENT_DURABILITY_QOS");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static DurabilityQosPolicyKind_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + DurabilityQosPolicyKind_t.class + " with value " + swigValue);
  }

  private DurabilityQosPolicyKind_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private DurabilityQosPolicyKind_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private DurabilityQosPolicyKind_t(String swigName, DurabilityQosPolicyKind_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static DurabilityQosPolicyKind_t[] swigValues = { VOLATILE_DURABILITY_QOS, TRANSIENT_LOCAL_DURABILITY_QOS, TRANSIENT_DURABILITY_QOS, PERSISTENT_DURABILITY_QOS };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

