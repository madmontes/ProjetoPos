package br.edu.infnet.appMarcoMontes.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TBUSUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String cpf;
	private String email;
	
	@Transient
	private List<BilheteUnico> bilhetes;
	
	public Usuario() {
		bilhetes = new ArrayList<BilheteUnico>();		
	}
	
	@Override
	public String toString() {
		return id + ";" + nome + ";" + cpf + ";" + email + ";" + bilhetes.size();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BilheteUnico> getBilhetes() {
		return bilhetes;
	}

	public void setBilhetes(List<BilheteUnico> bilhetes) {
		this.bilhetes = bilhetes;
	}

	
	
	
}
