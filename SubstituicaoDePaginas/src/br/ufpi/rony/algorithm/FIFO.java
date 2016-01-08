package br.ufpi.rony.algorithm;

import java.util.List;

import br.ufpi.rony.model.Pagina;

public class FIFO extends Algorithm {

	public FIFO(List<Pagina> dados) {
		super(dados);
	}

	@Override
	public void runAlgorithm() {
		for (Pagina dado : dados) {
			if(!paginasRAM.contains(dado)){
				if (paginasRAM.size() == quantMolduras) {
					for (int i = 0; i < paginasRAM.size() - 1; i++) {
						paginasRAM.set(i, paginasRAM.get(i+1));
					}
					paginasRAM.set(quantMolduras-1, dado);
				}else{
					paginasRAM.add(dado);
				}
				quantFaltaDePaginas++;
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FIFO " + quantFaltaDePaginas;
	}

	
}
