package br.ufpi.rony;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufpi.rony.algorithm.FIFO;
import br.ufpi.rony.algorithm.LRU;
import br.ufpi.rony.algorithm.OTM;
import br.ufpi.rony.model.Pagina;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pagina> dados = new ArrayList<Pagina>();
		dados = readFile(args[0]);
//		dados.add(new Pagina(4));
//		dados.add(new Pagina(1));
//		dados.add(new Pagina(2));
//		dados.add(new Pagina(3));
//		dados.add(new Pagina(4));
//		dados.add(new Pagina(1));
//		dados.add(new Pagina(2));
//		dados.add(new Pagina(5));
//		dados.add(new Pagina(1));
//		dados.add(new Pagina(2));
//		dados.add(new Pagina(3));
//		dados.add(new Pagina(4));
//		dados.add(new Pagina(5));
		
		List<Pagina> clone1 = cloneList(dados);
		List<Pagina> clone2 = cloneList(dados);
		
		FIFO fifo = new FIFO(dados);
		fifo.runAlgorithm();
		LRU lru = new LRU(clone1);
		lru.runAlgorithm();
		OTM otm = new OTM(clone2);
		otm.runAlgorithm();
		
		System.out.println(fifo.toString());
		System.out.println(lru.toString());
		System.out.println(otm.toString());
	}
	
	private static List<Pagina> cloneList(List<Pagina> pages){
		List<Pagina> cloneList = new ArrayList<Pagina>();
		for (Pagina pagina : pages) {
			Pagina clone = pagina.clone();
			cloneList.add(clone);
		}
		return cloneList;
	}
	
	private static List<Pagina> readFile(String nome){
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
			List<Pagina> dados = new ArrayList<Pagina>();
			while (linha != null) { 
				dados.add(new Pagina(Integer.valueOf(linha)));
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
