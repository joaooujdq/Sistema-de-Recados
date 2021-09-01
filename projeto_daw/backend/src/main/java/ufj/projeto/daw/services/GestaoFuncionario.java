package ufj.projeto.daw.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import ufj.projeto.daw.dtos.FuncionarioDTO;
import ufj.projeto.daw.models.Funcionario;
import ufj.projeto.daw.repositories.FuncionarioDAO;
import ufj.projeto.daw.services.exception.BusinessException;


@AllArgsConstructor
@Service
public class GestaoFuncionario {

	private FuncionarioDAO dao;
	
	@Transactional(readOnly = true)
	public Page<FuncionarioDTO> findAll(Pageable pageable) {	
		
		Page<Funcionario> result = dao.findAll(pageable);
		 
		return result.map(obj -> new FuncionarioDTO(obj));
		
		}
	

	@Transactional(readOnly = true)
	public FuncionarioDTO findById(Integer id) {
		Funcionario result = dao.findById(id).
				orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		return new FuncionarioDTO(result);
			
	}
	
	@Transactional(readOnly = true)
	public FuncionarioDTO findByNome(String nome) {
		Funcionario result = dao.findByNome(nome).
				orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		return new FuncionarioDTO(result);
		
    	}
	
	@Transactional(readOnly = true)
	public FuncionarioDTO findByLogin(String login) {
		Funcionario result = dao.findByLogin(login).
				orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		return new FuncionarioDTO(result);
		
    }
	

	
	@Transactional
	public FuncionarioDTO save(Funcionario obj) {	
		
		boolean loginExists = dao.findByLogin(obj.getLogin())
				.stream()
				.anyMatch(objResult -> !objResult.equals(obj));
		
		if(loginExists) {
			throw new BusinessException("Login ja existe");
		}
		
		return new FuncionarioDTO(dao.save(obj));
	}
	
	@Transactional
	public void deleteById(Integer id) {	
		dao.deleteById(id);
	}

	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
	
	
	
	
	
	
}
