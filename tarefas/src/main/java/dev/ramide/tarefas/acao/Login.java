package dev.ramide.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.ramide.tarefas.modelo.BancoDeDados;
import dev.ramide.tarefas.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Login");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		Usuario usuario = bancoDeDados.existeUsuario(login, senha);
		
		if(usuario != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaTarefas";
		}else {
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
