package ufj.projeto.daw.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import ufj.projeto.daw.dtos.EmpresaDTO;
import ufj.projeto.daw.models.Empresa;
import ufj.projeto.daw.repositories.EmpresaDAO;
import ufj.projeto.daw.services.exception.BusinessException;


@AllArgsConstructor
@Service
public class GestaoEmpresa {

	private EmpresaDAO dao;
	
	@Transactional(readOnly = true)
	public Page<EmpresaDTO> findAll(Pageable pageable) {	
		
		Page<Empresa> result = dao.findAll(pageable);
		 
		return result.map(obj -> new EmpresaDTO(obj));
		
		}
	

	@Transactional(readOnly = true)
	public EmpresaDTO findById(Integer id) {
		Empresa result = dao.findById(id).
				orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		return new EmpresaDTO(result);
			
	}
	
	@Transactional(readOnly = true)
	public EmpresaDTO findByNome(String nome) {
		Empresa result = dao.findByNome(nome).
				orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		return new EmpresaDTO(result);
		
    	}
	
	@Transactional(readOnly = true)
	public EmpresaDTO findByCnpj(String Cnpj) {
		Empresa result = dao.findByCnpj(Cnpj).
				orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		return new EmpresaDTO(result);
		
    }
	

	
	@Transactional
	public EmpresaDTO save(Empresa obj) {	
		
		boolean CnpjExists = dao.findByCnpj(obj.getCnpj())
				.stream()
				.anyMatch(objResult -> !objResult.equals(obj));
		
		if(CnpjExists) {
			throw new BusinessException("Cnpj ja existe");
		}
		
		return new EmpresaDTO(dao.save(obj));
	}
	
	@Transactional
	public void deleteById(Integer id) {	
		dao.deleteById(id);
	}

	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
	
	
	
	
	
	
}
