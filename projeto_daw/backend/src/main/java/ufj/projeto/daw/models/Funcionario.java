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
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_func")
	private Integer codigo ;
	
	
	@Column(name = "nome_func", nullable = false)
	private String nome;
	
	
	@Column(name = "cargo_func", nullable = false)
	private String cargo;
	
	
	@Column(name = "login_func", nullable = false)
	private String login;
	
	
	@Column(name = "senha_func", nullable = false)
	private String senha;
		
	@Column(name = "tipo_func", nullable = false)
	private String tipo;
	
	@OneToMany(mappedBy = "funcionario")
	private List<Recado> recados = new ArrayList<>();
	

	public Funcionario(Integer codigo, @NotBlank @Size(max = 60) String nome, @NotBlank @Size(max = 60) String cargo,
			@NotBlank @Size(max = 20) String login, @NotBlank @Size(max = 20) String senha,
			@NotBlank @Size(max = 14) String tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.cargo = cargo;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}

}
