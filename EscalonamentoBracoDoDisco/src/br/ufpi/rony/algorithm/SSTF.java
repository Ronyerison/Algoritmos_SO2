package br.ufpi.rony.algorithm;

import java.util.List;

public class SSTF extends Algorithm{

	public SSTF(List<Integer> dados) {
		super(dados);
	}

	@Override
	public void runAlgorithm() {
		while(!cilindros.isEmpty()){
			Integer index = proximoCilindro();
			totalPercorrido += Math.abs(cilidroAtual - cilindros.get(index));
			cilidroAtual = cilindros.get(index);
			cilindros.remove(cilidroAtual);
		}
	}
	
	public Integer proximoCilindro(){
		Integer min = Integer.MAX_VALUE;
		Integer index = null;
		for (int i = 0; i < cilindros.size(); i++) {
			if (Math.abs(cilidroAtual - cilindros.get(i)) <= min) {
				index = i;
				min = Math.abs(cilidroAtual - cilindros.get(i));
			}
		}
		
		return index;
	}

	@Override
	public String toString() {
		return "SSTF " + totalPercorrido;
	}
	
}
