package ufj.projeto.daw.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "RECADOS")

public class Recado implements Serializable {
	
	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_rec")
	private Integer codigo ;
	
	
	@Column(name = "empresa_rec", nullable = false)
	private String empresaNome;
	
	
	@Column(name = "status_rec", nullable = false)
	private String status;
	
	
	@Column(name = "prioridade_rec", nullable = false)
	private String prioridade;
	
	
	@Column(name = "setor_rec", nullable = false)
	private String setor;
	
	
	@Column(name = "mensagem_rec", nullable = false)
	private String mensagem;
	
	@Column(name = "tipo_rec", nullable = false)
	private String tipo;
	
	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToOne
	private Empresa empresaCriadora;

	public Recado() {

	}

	public Recado(int i, String string, String string2, String string3, String string4, String string5, String string6,
			Funcionario funcionario, Empresa empresa) {
		this.codigo = i;
		this.empresaNome = string;
		this.status = string2;
		this.prioridade = string3;
		this.setor = string4;
		this.mensagem = string5;
		this.tipo = string6;
		this.funcionario = funcionario;
		this.empresaCriadora = empresa;
		
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getEmpresaNome() {
		return empresaNome;
	}

	public void setEmpresaNome(String empresaNome) {
		this.empresaNome = empresaNome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Empresa getEmpresaCriadora() {
		return empresaCriadora;
	}

	public void setEmpresaCriadora(Empresa empresaCriadora) {
		this.empresaCriadora = empresaCriadora;
	}

	private static final long serialVersionUID = 1L;
	
	
	

}
