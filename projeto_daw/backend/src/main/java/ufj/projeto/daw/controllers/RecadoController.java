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

import ufj.projeto.daw.dtos.RecadoDTO;
import ufj.projeto.daw.models.Recado;
import ufj.projeto.daw.services.GestaoRecado;


@RestController
@RequestMapping("/v1/elx/recados")
@Tag(name = "Endpoint de Recado") 
public class RecadoController {
	
	@Autowired
	private GestaoRecado service;
	
	@GetMapping
	@Operation(summary = "Busca todos os Recados")
	public ResponseEntity<CollectionModel<RecadoDTO>> buscarTodos(
				@RequestParam(value="page", defaultValue = "0") int page,
				@RequestParam(value="limit", defaultValue = "12") int limit,
				@RequestParam(value="direction", defaultValue = "asc") String direction) {


			Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
			
			Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "prioridade"));
			
			Page<RecadoDTO> pages = service.findAll(pageable);
			pages
				.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(RecadoController.class).buscarUm(p.getCodigo())).withSelfRel()
					)
				);
		  	
			return ResponseEntity.ok(CollectionModel.of(pages));
		}
	 
	@GetMapping("/{id}")
	@Operation(summary = "Busca um Recado por id")
	public ResponseEntity<RecadoDTO> buscarUm(@PathVariable Integer id) {
		RecadoDTO objDTO = service.findById(id);
			objDTO.add(linkTo(methodOn(RecadoController.class).buscarUm(id)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	

	
	@PostMapping
	@Operation(summary = "Insere um novo Recado")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RecadoDTO> incluir(@RequestBody @Valid RecadoDTO objBody) {
		RecadoDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(RecadoController.class).buscarUm(objDTO.getCodigo())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}

	@PutMapping
	@Operation(summary = "Atualiza um Recado")
	public ResponseEntity<RecadoDTO> atualizar(@RequestBody RecadoDTO objBody) {

		RecadoDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(RecadoController.class).buscarUm(objDTO.getCodigo())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}		

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Recado por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(id);

		return ResponseEntity.noContent().build();

	}


	
	
}
 