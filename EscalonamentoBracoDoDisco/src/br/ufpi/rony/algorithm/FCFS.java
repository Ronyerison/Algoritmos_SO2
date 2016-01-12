package br.ufpi.rony.algorithm;

import java.util.List;

public class FCFS extends Algorithm {

	public FCFS(List<Integer> dados) {
		super(dados);
	}

	@Override
	public void runAlgorithm() {
		for (Integer cilindro : cilindros) {
			totalPercorrido += Math.abs(cilidroAtual - cilindro);
			cilidroAtual = cilindro;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FCFS " + totalPercorrido;
	}

	
}
