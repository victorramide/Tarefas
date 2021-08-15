package dev.ramide.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ramide.tarefas.modelo.BancoDeDados;
import dev.ramide.tarefas.modelo.Tarefa;

public class MostraTarefa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		BancoDeDados banco = new BancoDeDados();
		
		Tarefa tarefa = banco.buscaTarefaPelaId(id);
		
		request.setAttribute("tarefa", tarefa);
		
		
		return "forward:formAlteraTarefa.jsp";
	}

}
