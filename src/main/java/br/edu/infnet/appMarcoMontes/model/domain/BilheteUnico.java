package br.edu.infnet.appMarcoMontes.model.domain;

public class BilheteUnico {
	
	private Integer id;
	private Integer numero;
	private String tipo;
	private String descricao;	
	private boolean gratuidade;
	private float saldo;	
		
	@Override
	public String toString() {
		
		return String.format("%d;%d;%s;%s;%s;%.2f",
				id,
				numero,
				tipo,				
				descricao,
				gratuidade ? "gratuidade=sim" : "gratuidade=não",
				saldo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isGratuidade() {
		return gratuidade;
	}

	public void setGratuidade(boolean gratuidade) {
		this.gratuidade = gratuidade;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	

	
}
