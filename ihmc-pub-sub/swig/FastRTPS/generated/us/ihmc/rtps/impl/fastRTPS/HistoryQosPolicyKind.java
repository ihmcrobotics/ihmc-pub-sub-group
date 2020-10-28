/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class HistoryQosPolicyKind {
  public final static HistoryQosPolicyKind KEEP_LAST_HISTORY_QOS = new HistoryQosPolicyKind("KEEP_LAST_HISTORY_QOS");
  public final static HistoryQosPolicyKind KEEP_ALL_HISTORY_QOS = new HistoryQosPolicyKind("KEEP_ALL_HISTORY_QOS");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static HistoryQosPolicyKind swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + HistoryQosPolicyKind.class + " with value " + swigValue);
  }

  private HistoryQosPolicyKind(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private HistoryQosPolicyKind(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private HistoryQosPolicyKind(String swigName, HistoryQosPolicyKind swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static HistoryQosPolicyKind[] swigValues = { KEEP_LAST_HISTORY_QOS, KEEP_ALL_HISTORY_QOS };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

