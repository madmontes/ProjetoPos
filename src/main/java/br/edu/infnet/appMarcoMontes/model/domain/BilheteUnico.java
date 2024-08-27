package br.edu.infnet.appMarcoMontes.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBBILHETEUNICO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BilheteUnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private String tipo;
	private String descricao;	
	private boolean gratuidade;
	private float saldo;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;	
	@Override
	public String toString() {
		
		return String.format("%d;%d;%s;%s;%s;%.2f;%s",
				id,
				numero,
				tipo,				
				descricao,
				gratuidade ? "gratuidade=sim" : "gratuidade=não",
				saldo,
				usuario);
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
