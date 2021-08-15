package dev.ramide.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.ramide.tarefas.modelo.BancoDeDados;
import dev.ramide.tarefas.modelo.Tarefa;
import dev.ramide.tarefas.modelo.Usuario;

public class NovaTarefa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Cadastrando tarefas");
		
		HttpSession sessao = request.getSession();
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String status = request.getParameter("status");
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		tarefa.setStatus(status);
		tarefa.setUsuario(usuario.getId());
		
		BancoDeDados banco = new BancoDeDados();
		banco.adicionaTarefa(tarefa);
		
		request.setAttribute("tarefa", tarefa.getNome());
		
		
		return "redirect:entrada?acao=ListaTarefas";
	}

}
