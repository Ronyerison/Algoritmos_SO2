package br.ufpi.rony.algorithm;

import java.util.List;

import br.ufpi.rony.model.Pagina;

public class OTM extends Algorithm {

	public OTM(List<Pagina> dados) {
		super(dados);
	}

	@Override
	public void runAlgorithm() {
		Integer instante = 0;
		for (Pagina pagina : dados) {
			pagina.setProximaUtilizacao(-1);
		}
		for (Pagina dado : dados) {
			//verifica se a página não está na memoria
			if (!paginasRAM.contains(dado)) {
				/**
				 * Verifica se a memória já está cheia
				 * Se sim, substitui a página que irá demorar mais a ser referenciada
				 * Se não adciona a página na memória atualizando a sua próxima utilização
				 */
				if (paginasRAM.size() == quantMolduras) {
					changePage(dado, instante);
				} else {
					dado.setInstanteUtilizacao(instante);
					dado.setProximaUtilizacao(getProximaUtilizacao(dado,
							instante));
					paginasRAM.add(dado.clone());
				}
				quantFaltaDePaginas++;
				instante++;
			}else{
				//se a página estiver na memória será atualizada a próxima utilização
				int index = paginasRAM.indexOf(dado);
				paginasRAM.get(index).setInstanteUtilizacao(instante);
				paginasRAM.get(index).setProximaUtilizacao(getProximaUtilizacao(dado,
						instante));
				instante++;
			}
		}
	}

	/**
	 * @param dado
	 * @param instante
	 * @return index - O Índice da próxima utilização de uma página
	 */
	private Integer getProximaUtilizacao(Pagina dado, Integer instante) {
		for (int i = instante+1; i < dados.size(); i++) {
			if (dados.get(i).equals(dado)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para substituir uma página na memória
	 * @param dado
	 * @param instante
	 */
	private void changePage(Pagina dado, Integer instante) {
		Integer max = Integer.MIN_VALUE;
		Integer index = null;
		//Atualizando o instante de utilização do dado que será inserido na memória
		dado.setInstanteUtilizacao(instante);
		//Atualizando a próxima utilização do dado que será inserido na memória
		dado.setProximaUtilizacao(getProximaUtilizacao(dado, instante));

		for (int i = 0; i < paginasRAM.size(); i++) {
			//Busca um indice que uma página que não será mais referenciada
			if(paginasRAM.get(i).getProximaUtilizacao() == -1){
				index = i;
				break;
			}
			//Busca o indice da página que será a ultima a ser referenciada
			if (paginasRAM.get(i).getProximaUtilizacao() > max) {
				max = paginasRAM.get(i).getInstanteUtilizacao();
				index = i;
			}
		}
		paginasRAM.set(index, dado);
	}

	@Override
	public String toString() {
		return "OTM " + quantFaltaDePaginas;
	}
}
