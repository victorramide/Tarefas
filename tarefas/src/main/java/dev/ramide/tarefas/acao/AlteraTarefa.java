package dev.ramide.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ramide.tarefas.modelo.BancoDeDados;
import dev.ramide.tarefas.modelo.Tarefa;

public class AlteraTarefa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Alterando tarefa");
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String status = request.getParameter("status");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		BancoDeDados banco = new BancoDeDados();
		Tarefa tarefa = banco.buscaTarefaPelaId(id);
		
		tarefa.setNome(nome);
		tarefa.setDescricao(descricao);
		tarefa.setStatus(status);
		
		
		return "redirect:entrada?acao=ListaTarefas";
	}

}
