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
package org.knowm.jspice.dcop;

import org.knowm.jspice.JSpice;
import org.knowm.jspice.netlist.Netlist;
import org.knowm.jspice.netlist.NetlistBuilder;

public class DCOPI1R3 {

  public static void main(String[] args) {

    // run via NetlistBuilder
    NetlistBuilder builder = new NetlistBuilder().addNetlistDCCurrent("a", 1.0, "0", "1").addNetlistResistor("R1", 10, "1", "0")
        .addNetlistResistor("R2", 1000, "1", "2").addNetlistResistor("R3", 1000, "2", "0");
    Netlist netlist = builder.build();
    JSpice.simulate(netlist);
  }
}
