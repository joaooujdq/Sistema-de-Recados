package ufj.projeto.daw.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ufj.projeto.daw.models.Funcionario;

public interface FuncionarioDAO extends JpaRepository<Funcionario, Integer> {
	
	 public Optional<Funcionario> findByNome (String nome);
	 public Optional<Funcionario> findByLogin(String login);

}
