package dev.ramide.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.ramide.tarefas.modelo.BancoDeDados;
import dev.ramide.tarefas.modelo.Usuario;

public class NovoUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Cadastrando Usuario");
		
		
		
		String primeiroNome = request.getParameter("primeiroNome");
		String ultimoNome = request.getParameter("ultimoNome");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario novoUsuario = new Usuario();
		novoUsuario.setPrimeiroNome(primeiroNome);
		novoUsuario.setUltimoNome(ultimoNome);
		novoUsuario.setUsuario(usuario);
		novoUsuario.setSenha(senha);
		
		BancoDeDados banco = new BancoDeDados();
		banco.adicionaUsuario(novoUsuario);
		
		request.setAttribute("tarefa", novoUsuario.getUsuario());
		
		
		return "redirect:entrada?acao=LoginForm";
	}

}
