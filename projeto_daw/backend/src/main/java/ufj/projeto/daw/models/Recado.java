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
	private static final long serialVersionUID = 1L;
	
	
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

}
