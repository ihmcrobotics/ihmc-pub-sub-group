/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class MemoryManagementPolicy_t {
  public final static MemoryManagementPolicy_t PREALLOCATED_MEMORY_MODE = new MemoryManagementPolicy_t("PREALLOCATED_MEMORY_MODE");
  public final static MemoryManagementPolicy_t PREALLOCATED_WITH_REALLOC_MEMORY_MODE = new MemoryManagementPolicy_t("PREALLOCATED_WITH_REALLOC_MEMORY_MODE");
  public final static MemoryManagementPolicy_t DYNAMIC_RESERVE_MEMORY_MODE = new MemoryManagementPolicy_t("DYNAMIC_RESERVE_MEMORY_MODE");
  public final static MemoryManagementPolicy_t DYNAMIC_REUSABLE_MEMORY_MODE = new MemoryManagementPolicy_t("DYNAMIC_REUSABLE_MEMORY_MODE");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static MemoryManagementPolicy_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + MemoryManagementPolicy_t.class + " with value " + swigValue);
  }

  private MemoryManagementPolicy_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private MemoryManagementPolicy_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private MemoryManagementPolicy_t(String swigName, MemoryManagementPolicy_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static MemoryManagementPolicy_t[] swigValues = { PREALLOCATED_MEMORY_MODE, PREALLOCATED_WITH_REALLOC_MEMORY_MODE, DYNAMIC_RESERVE_MEMORY_MODE, DYNAMIC_REUSABLE_MEMORY_MODE };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

