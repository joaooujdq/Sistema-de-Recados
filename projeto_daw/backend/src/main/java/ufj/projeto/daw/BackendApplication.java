package ufj.projeto.daw;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ufj.projeto.daw.models.Empresa;
import ufj.projeto.daw.models.Funcionario;
import ufj.projeto.daw.models.Recado;
import ufj.projeto.daw.repositories.EmpresaDAO;
import ufj.projeto.daw.repositories.FuncionarioDAO;
import ufj.projeto.daw.repositories.RecadoDAO;


@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private FuncionarioDAO funcDAO;
	
	@Autowired
	private RecadoDAO recDAO;
	
	@Autowired
	private EmpresaDAO empDAO;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
	}
	
	
	public void run(String... args) throws Exception{
		
		Funcionario f1 = new Funcionario(1, "Fabricio", "Gerente", "loginFa", "senhaFa", "tipo1");
		Funcionario f2 = new Funcionario(2, "Isabele", "CEO", "lo ginISa", "senhaIsa", "tipo2");
		Funcionario f3 = new Funcionario(3, "Flavia", "tecnico", "loginFla", "senhaFla", "tipo3");
		
		Empresa e1 = new Empresa(1, "UFJ", "Universidade Federal de Jatai", "35754479000136", "Jatai", "40028922");
		Empresa e2 = new Empresa(2, "UFG", "Universidade Federal de Goias", "35754479111111", "Jatai", "40028922");
		Empresa e3 = new Empresa(3, "Mercadinho", "Mercadinho do Joao", "35754479999999", "Jatai", "40028922");
		
		Recado r1 = new Recado(1, "Indexis", "Pendente", "Alta", "Comercial", "Atualizar os produtos no site","Externo",f1, e1);
		Recado r2 = new Recado(2, "Google", "Completa", "Media", "Marketing", "Aumentar a quantidade de anuncios no Youtube","Externo",f2, e2);
		Recado r3 = new Recado(3, "UFJ", "Progresso", "Alta", "Academico", "Aprovar todos os alunos do NL de DAW","Externo",f3, e3);
		
		
		
		empDAO.saveAll(Arrays.asList(e1,e2,e3));
		funcDAO.saveAll(Arrays.asList(f1,f2,f3));
		recDAO.saveAll(Arrays.asList(r1,r2,r3));
		
	}

}
