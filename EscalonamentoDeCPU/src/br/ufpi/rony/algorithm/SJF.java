package br.ufpi.rony.algorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.ufpi.rony.model.Process;

public class SJF extends Algorithm {

	@Override
	public void runAlgorithm(List<Process> processes) {
		
		executionTime = 0;
		List<Process> procFin = new ArrayList<Process>();
		while (!processes.isEmpty()) {
			Process process = (Process) selectProcess(processes);
			if(process != null){
				process.setResponseTime(executionTime-process.getFinishTime());
				process.setStandbyTime(executionTime-process.getFinishTime());
				executionTime += process.getDurationTime();
				process.setReturnTime(executionTime-process.getFinishTime());
				procFin.add(process);
			}else{
				executionTime++;
			}
		}
		calculeAVGTime(procFin);
	}
	
	private Process selectProcess(List<Process> processes) {
		Integer min = Integer.MAX_VALUE;
		int indexBest = 0;
		Process best = null;
		int i = 0;
		for (Process process : processes) {
			if(process.getFinishTime() <= executionTime && process.getDurationTime() <= min){
				best = process.clone();
				indexBest = i;
				min = process.getDurationTime();
			}
			i++;
		}
		if(best != null){
			processes.remove(indexBest);
		}
		
		return best;
	}

	@Override
	public String toString() {
		DecimalFormat fmt = new DecimalFormat(".#");
		return ("SJF " + fmt.format(AVGReturnTime) + " " + fmt.format(AVGResponseTime) + " " + fmt.format(AVGStandbyTime));
	}

}
