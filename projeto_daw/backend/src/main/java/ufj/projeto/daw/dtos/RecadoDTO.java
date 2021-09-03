package ufj.projeto.daw.dtos;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufj.projeto.daw.models.Recado;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonPropertyOrder({"codigo_rec","empresa_rec","status_rec","prioridade_rec","setor_rec","mensagem_rec"})
public class RecadoDTO extends RepresentationModel<RecadoDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@JsonProperty("codigo_rec")
	private Integer codigo ;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("empresa_rec")
	private String empresaNome;
	
	@NotBlank
	@Size(max=20)
	@JsonProperty("status_rec")	
	private String status;
	
	@NotBlank
	@Size(max=14)
	@JsonProperty("prioridade_rec")
	private String prioridade;
	
	@NotBlank
	@Size(max=60)
	@JsonProperty("setor_rec")
	private String setor;
	
	@NotBlank
	@JsonProperty("mensagem_rec")
	private String mensagem;
	
	@NotBlank
	@JsonProperty("tipo_rec")
	private String tipo;
	
	@ConvertGroup(from = Default.class, to = ValidationsGroups.FuncionarioId.class)
	@NotNull
	@Valid
	private FuncionarioDTO funcionario;


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




	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}




	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}




	public EmpresaDTO getEmpresa() {
		return empresa;
	}




	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}




	@ConvertGroup(from = Default.class, to = ValidationsGroups.EmpresaId.class)
	@NotNull
	@Valid
	private EmpresaDTO empresa;
	
	
	
	
	public RecadoDTO (Recado obj) {
		codigo = obj.getCodigo();
		empresaNome = obj.getEmpresaNome();
		status = obj.getStatus();
		prioridade = obj.getPrioridade();
		setor = obj.getSetor();
		mensagem = obj.getMensagem();
		tipo = obj.getTipo();
		funcionario = new FuncionarioDTO(obj.getFuncionario());
		empresa = new EmpresaDTO(obj.getEmpresaCriadora());
	}
	
	
	
}