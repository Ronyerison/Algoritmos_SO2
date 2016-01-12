/**
 * 
 */
package br.ufpi.rony.algorithm;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import br.ufpi.rony.model.Process;


/**
 * @author Ronyerison
 *
 */
public class FCFS extends Algorithm {

	@Override
	public void runAlgorithm(List<Process> processes) {
		processes.sort(new Comparator<Process>() {
			@Override
			public int compare(Process o1, Process o2) {
				return o1.getFinishTime().compareTo(o2.getFinishTime());
			}
		});
		executionTime = processes.get(0).getFinishTime();
		Iterator<Process> it = processes.iterator();
		while (it.hasNext()) {
			Process process = (Process) it.next();
			process.setResponseTime(executionTime-process.getFinishTime());
			process.setStandbyTime(executionTime-process.getFinishTime());
			executionTime += process.getDurationTime();
			process.setReturnTime(executionTime-process.getFinishTime());
		}
		calculeAVGTime(processes);
	}

	@Override
	public String toString() {
		DecimalFormat fmt = new DecimalFormat(".#");
		return ("FCFS " + fmt.format(AVGReturnTime) + " " + fmt.format(AVGResponseTime) + " " + fmt.format(AVGStandbyTime));
	}
	
	

}
