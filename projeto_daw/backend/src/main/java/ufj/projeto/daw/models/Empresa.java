package ufj.projeto.daw.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "EMPRESAS")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_emp")
	private Integer codigo ;
	
	
	@Column(name = "nome_emp", nullable = false)
	private String nome;
	
	
	@Column(name = "razao_emp", nullable = false)
	private String razao;
	
	
	@Column(name = "cnpj_emp", nullable = false)
	private String cnpj;
	
	
	@Column(name = "endereco_emp", nullable = false)
	private String endereco;
	
	
	@Column(name = "telefone_emp", nullable = false)
	private String telefone;
	
	@OneToMany(mappedBy = "empresaCriadora")
	private List<Recado> recados = new ArrayList<>();
	
	public Empresa() {

	}

	public Empresa(Integer codigo, String nome, String razao, String cnpj, String endereco, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.razao = razao;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Recado> getRecados() {
		return recados;
	}

	public void setRecados(List<Recado> recados) {
		this.recados = recados;
	}
	
	
	
	
	

}
