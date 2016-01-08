package br.ufpi.rony.model;

public class Pagina {
	
	private Integer numeroPagina;
	private Integer instanteUtilizacao;
	private Integer proximaUtilizacao;
	
	/**
	 * @param numeroPagina
	 */
	public Pagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	/**
	 * @param numeroPagina
	 * @param instanteUtilizacao
	 */
	public Pagina(Integer numeroPagina, Integer instanteUtilizacao) {
		this.numeroPagina = numeroPagina;
		this.instanteUtilizacao = instanteUtilizacao;
	}



	public Pagina clone(){
		Pagina pagina = new Pagina(this.numeroPagina);
		pagina.setInstanteUtilizacao(this.instanteUtilizacao);
		pagina.setProximaUtilizacao(this.proximaUtilizacao);

		return pagina;
	}
	
	/**
	 * @return the numeroPagina
	 */
	public Integer getNumeroPagina() {
		return numeroPagina;
	}

	/**
	 * @param numeroPagina the numeroPagina to set
	 */
	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	/**
	 * @return the instanteUtilizacao
	 */
	public Integer getInstanteUtilizacao() {
		return instanteUtilizacao;
	}

	/**
	 * @param instanteUtilizacao the instanteUtilizacao to set
	 */
	public void setInstanteUtilizacao(Integer instanteUtilizacao) {
		this.instanteUtilizacao = instanteUtilizacao;
	}

	/**
	 * @return the proximaUtilizacao
	 */
	public Integer getProximaUtilizacao() {
		return proximaUtilizacao;
	}

	/**
	 * @param proximaUtilizacao the proximaUtilizacao to set
	 */
	public void setProximaUtilizacao(Integer proximaUtilizacao) {
		this.proximaUtilizacao = proximaUtilizacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroPagina == null) ? 0 : numeroPagina.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagina other = (Pagina) obj;
		if (numeroPagina == null) {
			if (other.numeroPagina != null)
				return false;
		} else if (!numeroPagina.equals(other.numeroPagina))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pagina [numeroPagina=" + numeroPagina + ", instanteUtilizacao="
				+ instanteUtilizacao + ", proximaUtilizacao="
				+ proximaUtilizacao + "]";
	}

	
	
}
