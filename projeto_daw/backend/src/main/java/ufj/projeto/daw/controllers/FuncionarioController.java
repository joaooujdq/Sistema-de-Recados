package ufj.projeto.daw.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Sort;

import ufj.projeto.daw.dtos.FuncionarioDTO;
import ufj.projeto.daw.models.Funcionario;
import ufj.projeto.daw.services.GestaoFuncionario;


@RestController
@RequestMapping("/v1/elx/funcionarios")
@Tag(name = "Endpoint de Funcionario") 
public class FuncionarioController {
	
	@Autowired
	private GestaoFuncionario service;
	
	@GetMapping
	@Operation(summary = "Busca todos os funcionarios")
	public ResponseEntity<CollectionModel<FuncionarioDTO>> buscarTodos(
				@RequestParam(value="page", defaultValue = "0") int page,
				@RequestParam(value="limit", defaultValue = "12") int limit,
				@RequestParam(value="direction", defaultValue = "asc") String direction) {


			Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
			
			Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));
			
			Page<FuncionarioDTO> pages = service.findAll(pageable);
			pages
				.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(FuncionarioController.class).buscarUm(p.getCodigo())).withSelfRel()
					)
				);
		  	
			return ResponseEntity.ok(CollectionModel.of(pages));
		}
	 
	@GetMapping("/{id}")
	@Operation(summary = "Busca um funcionario por id")
	public ResponseEntity<FuncionarioDTO> buscarUm(@PathVariable Integer id) {
		FuncionarioDTO objDTO = service.findById(id);
			objDTO.add(linkTo(methodOn(FuncionarioController.class).buscarUm(id)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	

	@GetMapping("/nome/{nome}")
	@Operation(summary = "Busca um funcionario por nome")
	public ResponseEntity<FuncionarioDTO> buscarNome(@PathVariable String nome) {
		FuncionarioDTO objDTO = service.findByNome(nome);
			objDTO.add(linkTo(methodOn(FuncionarioController.class).buscarNome(nome)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	

	@GetMapping("/login/{login}")
	@Operation(summary = "Busca um funcionario por login")
	public ResponseEntity<FuncionarioDTO> buscarLogin(@PathVariable String login) {
			FuncionarioDTO objDTO = service.findByLogin(login);
			objDTO.add(linkTo(methodOn(FuncionarioController.class).buscarLogin(login)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	
 
	
	@PostMapping
	@Operation(summary = "Insere um novo funcionario")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<FuncionarioDTO> incluir(@RequestBody @Valid Funcionario objBody) {
		FuncionarioDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(FuncionarioController.class).buscarUm(objDTO.getCodigo())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}

	@PutMapping
	@Operation(summary = "Atualiza um funcionario")
	public ResponseEntity<FuncionarioDTO> atualizar(@RequestBody Funcionario objBody) {

		FuncionarioDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(FuncionarioController.class).buscarUm(objDTO.getCodigo())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}		

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um funcionario por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(id);

		return ResponseEntity.noContent().build();

	}


	
	
}
 