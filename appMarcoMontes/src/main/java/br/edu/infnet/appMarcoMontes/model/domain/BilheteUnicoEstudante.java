package br.edu.infnet.appMarcoMontes.model.domain;

public class BilheteUnicoEstudante extends BilheteUnico {
	
	private int cota;
	private String instituicao;
	
	public String toString() {
		return String.format("%s;%d;%s", 
				super.toString(),
				cota,
				instituicao
				);
	}

	public int getCota() {
		return cota;
	}

	public void setCota(int cota) {
		this.cota = cota;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

}
