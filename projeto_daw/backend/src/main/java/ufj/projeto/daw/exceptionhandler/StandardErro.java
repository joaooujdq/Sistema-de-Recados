package ufj.projeto.daw.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
@Getter
@Setter
public class StandardErro {

	private Integer codigo;
	private LocalDateTime momento;
	private String decricao;
	private List<Fields> campos;
	
	


	public StandardErro(Integer codigo, LocalDateTime momento, String decricao, List<Fields> campos) {
		super();
		this.codigo = codigo;
		this.momento = momento;
		this.decricao = decricao;
		this.campos = campos;
	}




	@AllArgsConstructor
	@Setter
	@Getter
	public static class Fields {
	private String nome;
	private String mensagem;
	
	public Fields(String nome, String mensagem) {
		super();
		this.nome = nome;
		this.mensagem = mensagem;
	}
	
	
	
}
	
}
