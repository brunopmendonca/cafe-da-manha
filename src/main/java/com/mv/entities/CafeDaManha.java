package com.mv.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cafe_da_manha")
public class CafeDaManha {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@javax.persistence.JoinTable(name = "colaboradores", joinColumns = @JoinColumn(name = "cpf"))
	private String colaboradorCpf;

	public CafeDaManha() {
	}

	public CafeDaManha(String nome, String colaboradorCpf) {
		super();
		this.nome = nome;
		this.colaboradorCpf = colaboradorCpf;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setColaboradorCpf(String colaboradorCpf) {
		this.colaboradorCpf = colaboradorCpf;
	}

	public String getColaboradorCpf() {
		return colaboradorCpf;
	}
}
