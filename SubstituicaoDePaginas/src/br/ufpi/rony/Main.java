package br.ufpi.rony;

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
		dados.add(new Pagina(4));
		dados.add(new Pagina(1));
		dados.add(new Pagina(2));
		dados.add(new Pagina(3));
		dados.add(new Pagina(4));
		dados.add(new Pagina(1));
		dados.add(new Pagina(2));
		dados.add(new Pagina(5));
		dados.add(new Pagina(1));
		dados.add(new Pagina(2));
		dados.add(new Pagina(3));
		dados.add(new Pagina(4));
		dados.add(new Pagina(5));
		
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

}
