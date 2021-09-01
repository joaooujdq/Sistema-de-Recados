package ufj.projeto.daw.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import ufj.projeto.daw.dtos.RecadoDTO;
import ufj.projeto.daw.models.Empresa;
import ufj.projeto.daw.models.Funcionario;
import ufj.projeto.daw.models.Recado;
import ufj.projeto.daw.repositories.EmpresaDAO;
import ufj.projeto.daw.repositories.FuncionarioDAO;
import ufj.projeto.daw.repositories.RecadoDAO;
import ufj.projeto.daw.services.exception.BusinessException;


@AllArgsConstructor
@Service
public class GestaoRecado {

	private RecadoDAO dao;
	
	private FuncionarioDAO funDAO; 
	
	private EmpresaDAO empDAO; 
	
	@Transactional(readOnly = true)
	public Page<RecadoDTO> findAll(Pageable pageable) {	
		
		Page<Recado> result = dao.findAll(pageable);
		 
		return result.map(obj -> new RecadoDTO(obj));
		
		}
	

	@Transactional(readOnly = true)
	public RecadoDTO findById(Integer id) {
		Recado result = dao.findById(id).
				orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		return new RecadoDTO(result);
			
	}
	
	@Transactional
	public RecadoDTO update(RecadoDTO obj) {
		Recado entity = dao.findById(obj.getCodigo())
				.orElseThrow(() -> new BusinessException("Registros não encontrados!!!"));
		
		
		entity.setEmpresaNome(obj.getEmpresaNome());
		entity.setStatus(obj.getStatus());
		entity.setPrioridade(obj.getPrioridade());
		entity.setSetor(obj.getSetor());
		entity.setMensagem(obj.getMensagem());
		entity.setTipo(obj.getTipo());
		
		
		return new RecadoDTO(dao.save(entity));
		
		
	}
	
	@Transactional
	public RecadoDTO save(RecadoDTO obj) {
		Recado entity = new Recado(obj.getCodigo(), obj.getEmpresaNome(), obj.getStatus(), 
				obj.getPrioridade(), obj.getSetor(), obj.getMensagem(), obj.getTipo(),
				
				new Funcionario(
						obj.getFuncionario().getCodigo(),
						obj.getFuncionario().getNome(),
						obj.getFuncionario().getCargo(),
						obj.getFuncionario().getLogin(),
						obj.getFuncionario().getSenha(),
						obj.getFuncionario().getTipo()
				),
				
				new Empresa(
						obj.getEmpresa().getCodigo(),
						obj.getEmpresa().getNome(),
						obj.getEmpresa().getRazao(),
						obj.getEmpresa().getCnpj(),
						obj.getEmpresa().getEndereco(),
						obj.getEmpresa().getTelefone())
				);
		
		Optional<Funcionario> func = funDAO.findById(obj.getFuncionario().getCodigo());  
		
		entity.setFuncionario(func.orElse(null));
		
		Optional<Empresa> emp = empDAO.findById(obj.getEmpresa().getCodigo());  
		
		entity.setEmpresaCriadora(emp.orElse(null));
		
		
		return new RecadoDTO(dao.save(entity));
	}
	
	
	@Transactional
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
	
	
	
	
	
	
}
