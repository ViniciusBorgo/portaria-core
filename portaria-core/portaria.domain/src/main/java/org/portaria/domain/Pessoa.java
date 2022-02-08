package org.portaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cpf" }) }) // CPF campo Ãºnico

//Statement - define as querys de SQL
@NamedQueries({ @NamedQuery(name = "Pessoa.pessoaListar", query = "SELECT t FROM Pessoa t"),
		@NamedQuery(name = "Pessoa.buscarPorId", query = "SELECT t FROM Pessoa t WHERE t.id = :id"),
		@NamedQuery(name = "Pessoa.buscaPorNome", query = "SELECT t FROM Pessoa t WHERE t.nome = :nome"),
		@NamedQuery(name = "Pessoa.buscarPorCPF", query = "SELECT t FROM Pessoa t WHERE t.cpf = :cpf") })

@XmlRootElement
public class Pessoa implements Serializable {

	/**
	 * @Marcelo
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 100, nullable = false)
	private String nome;

	@NotNull
	@Column(length = 11, nullable = false)
	private String cpf;

	@NotNull
	@Column(length = 11, nullable = false)
	private String telefone;

	@ManyToOne
	private Empresa empresa;

	public Long getId() {
		return id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setId(Long id) {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + "]";
	}

}
