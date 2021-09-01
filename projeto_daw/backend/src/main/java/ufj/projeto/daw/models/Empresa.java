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

	public Empresa(Integer codigo, @NotBlank @Size(max = 60) String nome, @NotBlank @Size(max = 60) String razao,
			@NotBlank @Size(max = 14) String cnpj, @NotBlank @Size(max = 60) String endereco,
			@NotBlank @Size(max = 60) String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.razao = razao;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	
	
	
	

}
