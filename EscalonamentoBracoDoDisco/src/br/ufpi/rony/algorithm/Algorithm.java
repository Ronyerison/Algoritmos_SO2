/**
 * 
 */
package br.ufpi.rony.algorithm;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Ronyerison
 *
 */
public abstract class Algorithm {
	protected Integer quantCilindros;
	protected Integer cilidroAtual;
	protected List<Integer> cilindros;
	protected Integer totalPercorrido;
	
	public Algorithm(List<Integer> dados) {
		this.quantCilindros = dados.get(0);
		this.cilidroAtual = dados.get(1);
		cilindros = new ArrayList<Integer>();
		dados.remove(0);
		dados.remove(0);
		this.cilindros = dados;
		this.totalPercorrido = 0;
	}
	
	public abstract void runAlgorithm();
}
