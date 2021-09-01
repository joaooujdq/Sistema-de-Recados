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

import ufj.projeto.daw.dtos.EmpresaDTO;
import ufj.projeto.daw.models.Empresa;
import ufj.projeto.daw.services.GestaoEmpresa;


@RestController
@RequestMapping("/v1/elx/Empresas")
@Tag(name = "Endpoint de Empresa") 
public class EmpresaController {
	
	@Autowired
	private GestaoEmpresa service;
	
	@GetMapping
	@Operation(summary = "Busca todos os Empresas")
	public ResponseEntity<CollectionModel<EmpresaDTO>> buscarTodos(
				@RequestParam(value="page", defaultValue = "0") int page,
				@RequestParam(value="limit", defaultValue = "12") int limit,
				@RequestParam(value="direction", defaultValue = "asc") String direction) {


			Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
			
			Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));
			
			Page<EmpresaDTO> pages = service.findAll(pageable);
			pages
				.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(EmpresaController.class).buscarUm(p.getCodigo())).withSelfRel()
					)
				);
		  	
			return ResponseEntity.ok(CollectionModel.of(pages));
		}
	 
	@GetMapping("/{id}")
	@Operation(summary = "Busca um Empresa por id")
	public ResponseEntity<EmpresaDTO> buscarUm(@PathVariable Integer id) {
		EmpresaDTO objDTO = service.findById(id);
			objDTO.add(linkTo(methodOn(EmpresaController.class).buscarUm(id)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	

	@GetMapping("/nome/{nome}")
	@Operation(summary = "Busca uma Empresa por nome")
	public ResponseEntity<EmpresaDTO> buscarNome(@PathVariable String nome) {
		EmpresaDTO objDTO = service.findByNome(nome);
			objDTO.add(linkTo(methodOn(EmpresaController.class).buscarNome(nome)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	

	@GetMapping("/login/{login}")
	@Operation(summary = "Busca um Empresa por CNPJ")
	public ResponseEntity<EmpresaDTO> buscarCnpj(@PathVariable String cnpj) {
			EmpresaDTO objDTO = service.findByCnpj(cnpj);
			objDTO.add(linkTo(methodOn(EmpresaController.class).buscarCnpj(cnpj)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	
 
	
	@PostMapping
	@Operation(summary = "Insere uma nova Empresa")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EmpresaDTO> incluir(@RequestBody @Valid Empresa objBody) {
		EmpresaDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(EmpresaController.class).buscarUm(objDTO.getCodigo())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}

	@PutMapping
	@Operation(summary = "Atualiza uma Empresa")
	public ResponseEntity<EmpresaDTO> atualizar(@RequestBody Empresa objBody) {

		EmpresaDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(EmpresaController.class).buscarUm(objDTO.getCodigo())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}		

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui uma Empresa por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(id);

		return ResponseEntity.noContent().build();

	}


	
	
}
 