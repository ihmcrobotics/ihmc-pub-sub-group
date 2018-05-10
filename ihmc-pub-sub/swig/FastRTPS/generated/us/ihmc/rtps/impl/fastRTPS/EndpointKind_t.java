/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class EndpointKind_t {
  public final static EndpointKind_t READER = new EndpointKind_t("READER");
  public final static EndpointKind_t WRITER = new EndpointKind_t("WRITER");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static EndpointKind_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + EndpointKind_t.class + " with value " + swigValue);
  }

  private EndpointKind_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private EndpointKind_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private EndpointKind_t(String swigName, EndpointKind_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static EndpointKind_t[] swigValues = { READER, WRITER };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

