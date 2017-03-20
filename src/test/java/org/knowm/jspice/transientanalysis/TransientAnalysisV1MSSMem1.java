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
package org.knowm.jspice.transientanalysis;

import org.knowm.jspice.circuit.Circuit;
import org.knowm.jspice.circuits.V1MSSMemV1;
import org.knowm.jspice.simulate.SimulationPlotter;
import org.knowm.jspice.simulate.SimulationResult;
import org.knowm.jspice.simulate.transientanalysis.TransientAnalysis;
import org.knowm.jspice.simulate.transientanalysis.TransientAnalysisDefinition;
import org.knowm.jspice.simulate.transientanalysis.driver.Driver;
import org.knowm.jspice.simulate.transientanalysis.driver.Sine;

/**
 * @author timmolter
 */
public class TransientAnalysisV1MSSMem1 {

  public static void main(String[] args) {

    // Circuit
    Circuit circuit = new V1MSSMemV1();

    Driver driver = new Sine("Vdd", 0.0, 0, 0.5, 100.0);
    Driver[] drivers = new Driver[]{driver};
    double stopTime = .04;
    double timeStep = .00001;

    // TransientAnalysisDefinition
    TransientAnalysisDefinition transientAnalysisDefinition = new TransientAnalysisDefinition(drivers, stopTime, timeStep);

    // run TransientAnalysis
    TransientAnalysis transientAnalysis = new TransientAnalysis(circuit, transientAnalysisDefinition);
    SimulationResult simulationResult = transientAnalysis.run();

    // plot
    // SimulationPlotter.plotAllSeparate(simulationResult);
    // SimulationPlotter.plotSeparate(simulationResult, new String[] { "V(VDD)", "I(M1)" });
    SimulationPlotter.plotTransientInOutCurve("I/V Curve", simulationResult, new String[]{"V(VDD)", "I(M1)"});

    // export data
    // SimulationPlotter.printTransientInOut(simulationResult);
  }
}
