package dev.ramide.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ramide.tarefas.modelo.BancoDeDados;

public class RemoveTarefa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Removendo tarefas");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		BancoDeDados banco = new BancoDeDados();
		banco.removeTarefa(id);
		
		return "redirect:entrada?acao=ListaTarefas";
	}

}
