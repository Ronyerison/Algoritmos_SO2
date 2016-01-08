/**
 * 
 */
package br.ufpi.rony.algorithm;

import java.util.ArrayList;
import java.util.List;

import br.ufpi.rony.model.Pagina;


/**
 * @author Ronyerison
 *
 */
public abstract class Algorithm {
	protected Integer quantFaltaDePaginas;
	protected Integer quantMolduras;
	protected List<Pagina> paginasRAM;
	protected List<Pagina> dados;
	
	public Algorithm(List<Pagina> dados) {
		this.quantMolduras = dados.get(0).getNumeroPagina();
		this.quantFaltaDePaginas = 0;
		paginasRAM = new ArrayList<Pagina>(quantMolduras);
		dados.remove(0);
		this.dados = dados;
	}
	
	public abstract void runAlgorithm();
}
