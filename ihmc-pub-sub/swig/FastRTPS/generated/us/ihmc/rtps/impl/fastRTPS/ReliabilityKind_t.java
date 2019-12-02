/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class ReliabilityKind_t {
  public final static ReliabilityKind_t RELIABLE = new ReliabilityKind_t("RELIABLE");
  public final static ReliabilityKind_t BEST_EFFORT = new ReliabilityKind_t("BEST_EFFORT");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static ReliabilityKind_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + ReliabilityKind_t.class + " with value " + swigValue);
  }

  private ReliabilityKind_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private ReliabilityKind_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private ReliabilityKind_t(String swigName, ReliabilityKind_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static ReliabilityKind_t[] swigValues = { RELIABLE, BEST_EFFORT };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

