/**
 * 
 */
package br.ufpi.rony;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufpi.rony.algorithm.FCFS;
import br.ufpi.rony.algorithm.RR;
import br.ufpi.rony.algorithm.SJF;
import br.ufpi.rony.model.Process;

/**
 * @author Ronyerison
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Process> processes = new ArrayList<Process>();
		
		processes = readProcessesFile(args[0]);
		
		List<Process> clone1 = cloneList(processes);
		List<Process> clone2 = cloneList(processes);
		
		FCFS fcfs = new FCFS();
		fcfs.runAlgorithm(processes);
		SJF sjf = new SJF();
		sjf.runAlgorithm(clone1);
		RR rr = new RR();
		rr.runAlgorithm(clone2);
		
		System.out.println(fcfs.toString());
		System.out.println(sjf.toString());
		System.out.println(rr.toString());
		

	}

	private static List<Process> cloneList(List<Process> processes){
		List<Process> cloneList = new ArrayList<Process>();
		for (Process process : processes) {
			Process clone = process.clone();
			cloneList.add(clone);
		}
		return cloneList;
	}
	
	private static List<Process> readProcessesFile(String nome){
//		Scanner ler = new Scanner(System.in);
//		System.out.printf("Informe o nome de arquivo texto:\n"); 
//		String nome = ler.nextLine(); 
		
		try { 
			FileReader arq = new FileReader(nome); 
			BufferedReader lerArq = new BufferedReader(arq); 
			String linha = lerArq.readLine();
			// lê a primeira linha 
			// a variável "linha" recebe o valor "null" quando o processo 
			// de repetição atingir o final do arquivo texto
			List<Process> processes = new ArrayList<Process>();
			while (linha != null) { 
				String[] values = linha.split(" ");
				processes.add(new Process(Integer.valueOf(values[0]), Integer.valueOf(values[1])));
				linha = lerArq.readLine(); 
				// lê da segunda até a última linha 
			}
			arq.close();
//			ler.close();
			return processes;
		}catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			return null;
		} 
		
	}
	

		
	
}
