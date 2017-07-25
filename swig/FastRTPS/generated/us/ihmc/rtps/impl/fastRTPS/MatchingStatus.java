/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class MatchingStatus {
  public final static MatchingStatus MATCHED_MATCHING = new MatchingStatus("MATCHED_MATCHING");
  public final static MatchingStatus REMOVED_MATCHING = new MatchingStatus("REMOVED_MATCHING");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static MatchingStatus swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + MatchingStatus.class + " with value " + swigValue);
  }

  private MatchingStatus(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private MatchingStatus(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private MatchingStatus(String swigName, MatchingStatus swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static MatchingStatus[] swigValues = { MATCHED_MATCHING, REMOVED_MATCHING };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

