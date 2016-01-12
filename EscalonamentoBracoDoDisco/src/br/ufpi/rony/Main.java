package br.ufpi.rony;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufpi.rony.algorithm.Elevador;
import br.ufpi.rony.algorithm.FCFS;
import br.ufpi.rony.algorithm.SSTF;

public class Main {
	public static void main(String[] args) {
		List<Integer> dados = new ArrayList<Integer>();
		dados = readFile(args[0]);
//		dados.add(199);
//		dados.add(53);
//		dados.add(98);
//		dados.add(183);
//		dados.add(37);
//		dados.add(122);
//		dados.add(14);
//		dados.add(124);
//		dados.add(65);
//		dados.add(67);
		
		List<Integer> clone1 = cloneList(dados);
		List<Integer> clone2 = cloneList(dados);
		
		FCFS fcfs = new FCFS(dados);
		fcfs.runAlgorithm();
		System.out.println(fcfs.toString());
		
		SSTF sstf = new SSTF(clone1);
		sstf.runAlgorithm();
		System.out.println(sstf.toString());
		
		Elevador elevador = new Elevador(clone2);
		elevador.runAlgorithm();
		System.out.println(elevador.toString());
	}
	
	private static List<Integer> cloneList(List<Integer> cilindros){
		List<Integer> cloneList = new ArrayList<Integer>();
		for (Integer cilindro : cilindros) {
			Integer clone = new Integer(cilindro);
			cloneList.add(clone);
		}
		return cloneList;
	}
	
	private static List<Integer> readFile(String nome){
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
			List<Integer> dados = new ArrayList<Integer>();
			while (linha != null) { 
				dados.add(Integer.valueOf(linha));
				linha = lerArq.readLine(); 
				// lê da segunda até a última linha 
			}
			arq.close();
//			ler.close();
			return dados;
		}catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			return null;
		}
	}
}
