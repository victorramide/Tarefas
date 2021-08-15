package dev.ramide.tarefas.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.ramide.tarefas.modelo.BancoDeDados;
import dev.ramide.tarefas.modelo.Tarefa;
import dev.ramide.tarefas.modelo.Usuario;

public class ListaTarefas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Listando tarefas");
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		BancoDeDados banco = new BancoDeDados();
		
		List<Tarefa> listaTarefas = banco.buscaTarefaPeloUsuario(usuario.getId());
		
		request.setAttribute("tarefas", listaTarefas);
		
		return "forward:listaTarefas.jsp";
	}

}
