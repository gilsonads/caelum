package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/AdicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email2 = request.getParameter("email");
		System.out.println("O email é dfdedd : " + email2);
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		try{
			Date date =  new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		}catch (ParseException e){
			out.println("Erro de conversão da data");
			return;
		} 
		
		//monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email2);
		contato.setDataNascimento(dataNascimento);
		
		//salva contato
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		//imprime o nome do contato 
		
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adiciona.jsp");
		rd.forward(request, response);
	/*	out.println("<html>");
		out.println("<body>");
		out.println("Contato: "+ contato.getNome() + "Adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
		*/
	}
	
   
	
}
