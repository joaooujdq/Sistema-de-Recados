package ufj.projeto.daw.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ufj.projeto.daw.models.Empresa;

public interface EmpresaDAO extends JpaRepository<Empresa, Integer> {
	
	 public Optional<Empresa> findByNome (String nome);
	 public Optional<Empresa> findByCnpj(String cnpj);

}
