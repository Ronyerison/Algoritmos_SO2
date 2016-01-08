/**
 * 
 */
package br.ufpi.rony.algorithm;

import java.util.List;

import br.ufpi.rony.model.Process;


/**
 * @author Ronyerison
 *
 */
public abstract class Algorithm {
	protected Double AVGReturnTime;
	protected Double AVGResponseTime;
	protected Double AVGStandbyTime;
	protected Integer executionTime;
	
	protected void calculeAVGTime(List<Process> processes){
		Integer sumReturnTime = 0;
		Integer sumResponseTime = 0;
		Integer sumStandbyTime = 0;
		for (Process process : processes) {
			if (process.getReturnTime() != null) {
				sumReturnTime += process.getReturnTime();
			}
			if (process.getResponseTime() != null) {
				sumResponseTime += process.getResponseTime();
			}
			if (process.getStandbyTime() != null) {
				sumStandbyTime += process.getStandbyTime();
			}
		}
		AVGReturnTime = (Double)(sumReturnTime.doubleValue() / (double) processes.size());
		AVGResponseTime = (Double)(sumResponseTime.doubleValue() / (double) processes.size());
		AVGStandbyTime = (Double)(sumStandbyTime.doubleValue() / (double) processes.size());
	}
	
	public abstract void runAlgorithm(List<Process> processes);
}
