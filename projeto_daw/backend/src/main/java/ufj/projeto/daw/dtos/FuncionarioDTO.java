package ufj.projeto.daw.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufj.projeto.daw.dtos.ValidationsGroups.FuncionarioId;
import ufj.projeto.daw.models.Funcionario;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonPropertyOrder({"codigo_func","nome_func","cargo_func","login_func","senha_func","tipo_func"})
public class FuncionarioDTO extends RepresentationModel<FuncionarioDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(groups = FuncionarioId.class)
	@EqualsAndHashCode.Include
	@JsonProperty("codigo_func")
	private Integer codigo ;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("nome_func")
	private String nome;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("cargo_func")
	private String cargo;
	
	@NotBlank
	@Size(max=20)
	@JsonProperty("login_func")
	private String login;
	
	@NotBlank
	@Size(max=20)
	@JsonProperty("senha_func")
	private String senha;
	
	@NotBlank
	@Size(max=14)
	@JsonProperty("tipo_func")
	private String tipo;
	
	public FuncionarioDTO (Funcionario obj) {
		this.codigo = obj.getCodigo();
		this.nome = obj.getNome();
		this.cargo = obj.getCargo();
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
		this.tipo = obj.getTipo();
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}