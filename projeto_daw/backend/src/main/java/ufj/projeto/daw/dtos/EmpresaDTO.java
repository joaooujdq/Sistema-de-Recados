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
import ufj.projeto.daw.dtos.ValidationsGroups.EmpresaId;
import ufj.projeto.daw.models.Empresa;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonPropertyOrder({"codigo_emp","nome_emp","razao_emp","cnpj_emp","endereco_emp","telefone_emp"})
public class EmpresaDTO extends RepresentationModel<EmpresaDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(groups = EmpresaId.class)
	@EqualsAndHashCode.Include
	@JsonProperty("codigo_emp")
	private Integer codigo ;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("nome_emp")
	private String nome;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("razao_emp")
	private String razao;
	
	@NotBlank
	@Size(max=14)
	@JsonProperty("cnpj_emp")
	private String cnpj;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("endereco_emp")
	private String endereco;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("telefone_emp")
	private String telefone;
	
	public EmpresaDTO (Empresa obj) {
		this.codigo = obj.getCodigo();
		this.nome = obj.getNome();
		this.razao = obj.getRazao();
		this.cnpj = obj.getCnpj();
		this.endereco = obj.getEndereco();
		this.telefone = obj.getTelefone();
	}
	
	
	
}