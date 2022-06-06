package br.com.jkcontrol.gcead;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.jkcontrol.gcead.entity.Condominio;
import br.com.jkcontrol.gcead.entity.FuncionarioPortaria;
import br.com.jkcontrol.gcead.entity.Movimentacao;
import br.com.jkcontrol.gcead.entity.Portaria;
import br.com.jkcontrol.gcead.entity.Visitante;
import br.com.jkcontrol.gcead.service.CondominioServiceImpl;
import br.com.jkcontrol.gcead.service.FuncPortariaServiceImpl;
import br.com.jkcontrol.gcead.service.MovimentacaoServiceImpl;
import br.com.jkcontrol.gcead.service.PortariaServiceImpl;
import br.com.jkcontrol.gcead.service.VisitanteServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
		CondominioServiceImpl condominioService = CondominioServiceImpl.getInstance();
		FuncPortariaServiceImpl funcionarioService = FuncPortariaServiceImpl.getInstance();
		PortariaServiceImpl portariaService = PortariaServiceImpl.getInstance();
		VisitanteServiceImpl visitanteService = VisitanteServiceImpl.getInstance();
		MovimentacaoServiceImpl movimentacaoService = MovimentacaoServiceImpl.getInstance();
		
		Condominio condominio1 = new Condominio("8564782344343", "Granja Viana", "GL Condominios", LocalDate.of(2022, 1, 1));
		condominioService.inserir(condominio1);
		
		Condominio condominio2 = new Condominio("542658756", "Brecheret", "BR", LocalDate.of(2021, 1, 1));
		condominioService.inserir(condominio2);
		
		Portaria portaria1 = new Portaria(1, "Portaria Principal", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), condominio1);
        Portaria portaria2 = new Portaria(2, "Portaria de Serviço", LocalDate.of(2021, 1, 1), LocalDate.of(2024, 1, 1), condominio2);

        portariaService.inserir(portaria1);
        portariaService.inserir(portaria2);
        
        
        Visitante visitante1 = visitanteService.obter(1L);
        Visitante visitante2 = visitanteService.obter(2L);
        
        FuncionarioPortaria funcionario1 = funcionarioService.obter(1L);
        FuncionarioPortaria funcionario2 = funcionarioService.obter(2L);
        
        Movimentacao movimentacao1 = new Movimentacao("E", LocalDateTime.of(2022, 6, 1, 15, 00, 0), portaria1, funcionario1, visitante1);
        Movimentacao movimentacao2 = new Movimentacao("E", LocalDateTime.of(2022, 6, 1, 15, 30, 0), portaria1, funcionario1, visitante2);
        Movimentacao movimentacao3 = new Movimentacao("S", LocalDateTime.of(2022, 6, 1, 15, 45, 0), portaria1, funcionario2, visitante1);
        
        movimentacaoService.inserir(movimentacao1);
		movimentacaoService.inserir(movimentacao2);
		movimentacaoService.inserir(movimentacao3);
		
		
		movimentacaoService.listar().forEach(System.out::println);;

		System.out.println("============ Listar Visitante Por Nome ==============");
		visitanteService.listarComCriteriaNome("Anderson").forEach(System.out::println);
		
		System.out.println("============ Listar Visitante Por CPF ==============");
		visitanteService.listarComCriteriaCpf("12345678934").forEach(System.out::println);
		
		System.out.println("============ Listar Visitante Por Data de Cadastro ==============");
		visitanteService.listarComCriteriaDataCadastro(LocalDate.of(2022, 3, 1).atStartOfDay()).forEach(System.out::println);
		
	}
		
}


