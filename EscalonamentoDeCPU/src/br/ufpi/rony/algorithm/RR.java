package br.ufpi.rony.algorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.ufpi.rony.model.Process;

public class RR extends Algorithm {

	@Override
	public void runAlgorithm(List<Process> processes) {
		executionTime = 0;
		List<Process> procFin = new ArrayList<Process>();
		List<Process> procReady = new ArrayList<Process>();
		while(procReady.isEmpty()){
			addProcessesReady(processes, procReady);
			if (procReady.isEmpty()) {
				executionTime+=2;
			}
		}
		int i = 0;
		while (!procReady.isEmpty() || !processes.isEmpty()) {
			//Verificar na lista de processos e adicionar os processos que estiverem prontos
			if(!processes.isEmpty()){
				addProcessesReady(processes, procReady);
			}
			
			Process process = procReady.get(i);
			//Calculando o tempo de resposta do processo
			if(process.getExecutedTime() == 0){
				process.setResponseTime(executionTime-process.getFinishTime());
			}
			//Incrementando o tempo de execução do processo
			executionTime += 2;
			process.setExecutedTime(process.getExecutedTime()+2);
			
			//Verificando se o processo terminou sua execução
			if(process.isExecuted()){
				//Calculo do tempo de retorno do processo
				process.setReturnTime(executionTime-process.getFinishTime());
				//Calculo do tempo de espera do processo
				process.setStandbyTime((executionTime-process.getFinishTime()) - process.getDurationTime());
				//Adicionando à lista de processos finalizados e removendo dos processos prontos
				Process clone = process.clone();
				procFin.add(clone);
				procReady.remove(process);
				i--;
			}

			//Verificando o ponteiro para lista circular
			if(i == procReady.size() - 1){
				i = 0;
			}else{
				i++;
			}
		}
		
		//Cálculo das médias de tempo de retorno, espera e resposta
		calculeAVGTime(procFin);
	}

	
	/**
	 * Método que verifica se os processos estão prontos e adciona à lista
	 * de processos prontos
	 * @param processes
	 * @param procReady
	 */
	private void addProcessesReady(List<Process> processes,
			List<Process> procReady) {
		List<Process> aux = new ArrayList<Process>();
		for (Process process : processes) {
			if(process.getFinishTime() <= executionTime){
				Process clone = process.clone();
				procReady.add(clone);
				aux.add(process);
			}
		}
		for (Process process : aux) {
			processes.remove(process);
		}
	}

	@Override
	public String toString() {
		DecimalFormat fmt = new DecimalFormat(".#");
		return ("RR " + fmt.format(AVGReturnTime) + " " + fmt.format(AVGResponseTime) + " " + fmt.format(AVGStandbyTime));
	}

}
