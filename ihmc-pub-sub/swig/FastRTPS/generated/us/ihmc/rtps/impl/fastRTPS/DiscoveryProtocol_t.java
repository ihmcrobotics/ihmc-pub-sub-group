/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.rtps.impl.fastRTPS;

public final class DiscoveryProtocol_t {
  public final static DiscoveryProtocol_t NONE = new DiscoveryProtocol_t("NONE");
  public final static DiscoveryProtocol_t SIMPLE = new DiscoveryProtocol_t("SIMPLE");
  public final static DiscoveryProtocol_t EXTERNAL = new DiscoveryProtocol_t("EXTERNAL");
  public final static DiscoveryProtocol_t CLIENT = new DiscoveryProtocol_t("CLIENT");
  public final static DiscoveryProtocol_t SERVER = new DiscoveryProtocol_t("SERVER");
  public final static DiscoveryProtocol_t BACKUP = new DiscoveryProtocol_t("BACKUP");
  public final static DiscoveryProtocol_t SUPER_CLIENT = new DiscoveryProtocol_t("SUPER_CLIENT");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static DiscoveryProtocol_t swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + DiscoveryProtocol_t.class + " with value " + swigValue);
  }

  private DiscoveryProtocol_t(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private DiscoveryProtocol_t(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private DiscoveryProtocol_t(String swigName, DiscoveryProtocol_t swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static DiscoveryProtocol_t[] swigValues = { NONE, SIMPLE, EXTERNAL, CLIENT, SERVER, BACKUP, SUPER_CLIENT };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

