/**
 * jspice is distributed under the GNU General Public License version 3
 * and is also available under alternative licenses negotiated directly
 * with Knowm, Inc.
 *
 * Copyright (c) 2016-2017 Knowm Inc. www.knowm.org
 *
 * Knowm, Inc. holds copyright
 * and/or sufficient licenses to all components of the jspice
 * package, and therefore can grant, at its sole discretion, the ability
 * for companies, individuals, or organizations to create proprietary or
 * open source (even if not GPL) modules which may be dynamically linked at
 * runtime with the portions of jspice which fall under our
 * copyright/license umbrella, or are distributed under more flexible
 * licenses than GPL.
 *
 * The 'Knowm' name and logos are trademarks owned by Knowm, Inc.
 *
 * If you have any questions regarding our licensing policy, please
 * contact us at `contact@knowm.org`.
 */
package org.knowm.jspice.memristor;

import org.knowm.jspice.netlist.Netlist;
import org.knowm.jspice.netlist.NetlistDCVoltage;
import org.knowm.jspice.netlist.NetlistMMSSMemristor;

/**
 * @author timmolter
 */
public class V1MMSSMemristor1 extends Netlist {

  /**
   * characteristic time scale of the device
   */
  private static final double TAU = 0.0001;

  /**
   * the number of MSS's
   */
  private static final double R_OFF = 1500;
  private static final double R_ON = 500;
  private static final double R_INIT = 1500;

  /**
   * barrier potentials
   */
  private static final double V_OFF = .27;
  private static final double V_ON = .27;

  private final static double schottkeyAlpha = 0; // N/A
  private final static double schottkeyBeta = 0; // N/A
  private final static double phi = 1;

  /**
   * Constructor
   */
  public V1MMSSMemristor1() {

    // build netlist, the nodes can be named anything except for ground whose node ..................
    addNetListComponent(new NetlistDCVoltage("Vdd", 1.0, "VDD", "0"));
    addNetListComponent(new NetlistMMSSMemristor("M1", R_INIT, R_ON, R_OFF, TAU, V_ON, V_OFF, phi, schottkeyAlpha, schottkeyBeta, schottkeyAlpha,
        schottkeyBeta, "VDD", "0"));
  }
}
