package dev.ramide.tarefas.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoDeDados {
	
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static List<Tarefa> listaTarefas = new ArrayList<>();
	private static Integer chaveSequencialTarefa = 1;
	private static Integer chaveSequencialUsuario = 1;
	
	
	static {
		
		Usuario ramide = new Usuario();
		ramide.setId(chaveSequencialUsuario++);
		ramide.setPrimeiroNome("Victor");
		ramide.setUltimoNome("Ramide");
		ramide.setUsuario("ramide");
		ramide.setSenha("54321");
		
		Usuario joao = new Usuario();
		joao.setId(chaveSequencialUsuario++);
		joao.setPrimeiroNome("João");
		joao.setUltimoNome("de Paula");
		joao.setUsuario("joao");
		joao.setSenha("12345");
		
		Tarefa tarefa1 = new Tarefa();
		tarefa1.setId(chaveSequencialTarefa++);
		tarefa1.setNome("Desenvolver Página");
		tarefa1.setDescricao("Fazer este site funcionar perfeitamente");
		tarefa1.setStatus("Em andamento");
		tarefa1.setUsuario(ramide.getId());
		
		Tarefa tarefa2 = new Tarefa();
		tarefa2.setId(chaveSequencialTarefa++);
		tarefa2.setNome("Desenvolver o back-end");
		tarefa2.setDescricao("Preparar o Servlet, páginas e ações");
		tarefa2.setStatus("Em andamento");
		tarefa2.setUsuario(ramide.getId());
		
		Tarefa tarefa3 = new Tarefa();
		tarefa3.setId(chaveSequencialTarefa++);
		tarefa3.setNome("Passear com o cachorro");
		tarefa3.setDescricao("Não esquecer o saco plástico para recolher a bosta");
		tarefa3.setStatus("Não iniciado");
		tarefa3.setUsuario(joao.getId());
		
		listaUsuarios.add(ramide);
		listaUsuarios.add(joao);
		
		listaTarefas.add(tarefa1);
		listaTarefas.add(tarefa2);
		listaTarefas.add(tarefa3);
		
	}
	
	
	public void adicionaTarefa(Tarefa tarefa) {
		tarefa.setId(chaveSequencialTarefa++);
		BancoDeDados.listaTarefas.add(tarefa);
	}
	
	
	public void removeTarefa(Integer id) {
		Iterator<Tarefa> iterator = listaTarefas.iterator();
		while(iterator.hasNext()) {
			Tarefa tarefa = iterator.next();
			if(tarefa.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Tarefa buscaTarefaPelaId(Integer id) {
		for (Tarefa tarefa : listaTarefas) {
			if(tarefa.getId() == id) {
				return tarefa;
			}
		}
		return null;
	}
	
	
	public List<Tarefa> buscaTarefaPeloUsuario(Integer usuario) {
		List<Tarefa> tarefasUsuario = new ArrayList<>();
		for(Tarefa tarefa : listaTarefas) {
			if(usuario == tarefa.getUsuario()) {
				tarefasUsuario.add(tarefa);
			}
		}
		return tarefasUsuario;
	}
	
	
	public Usuario existeUsuario(String login, String senha) {
		
		for(Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}
	
	public void adicionaUsuario(Usuario usuario) {
		usuario.setId(chaveSequencialTarefa++);
		BancoDeDados.listaUsuarios.add(usuario);
	}

}
