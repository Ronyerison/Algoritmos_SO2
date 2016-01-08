package br.ufpi.rony.algorithm;

import java.util.List;

import br.ufpi.rony.model.Pagina;

public class LRU extends Algorithm {

	public LRU(List<Pagina> dados) {
		super(dados);
	}

	@Override
	public void runAlgorithm() {
		Integer instante = 0;
		for (Pagina dado : dados) {
			if(!paginasRAM.contains(dado)){
				if (paginasRAM.size() == quantMolduras) {
					changePage(dado, instante);
				}else{
					dado.setInstanteUtilizacao(instante);
					paginasRAM.add(dado);
				}
				quantFaltaDePaginas++;
			}
			int index = paginasRAM.indexOf(dado);
			paginasRAM.get(index).setInstanteUtilizacao(instante);
			instante++;
		}
	}
	
	private void changePage(Pagina dado, Integer instante){
		Integer min = Integer.MAX_VALUE;
		Integer index = null;
		for (int i = 0; i < paginasRAM.size(); i++) {
			if(paginasRAM.get(i).getInstanteUtilizacao() < min){
				min = paginasRAM.get(i).getInstanteUtilizacao();
				index = i;
			}
		}
		dado.setInstanteUtilizacao(instante);
		paginasRAM.set(index, dado);
	}
	
	@Override
	public String toString() {
		return "LRU " + quantFaltaDePaginas;
	}
}
