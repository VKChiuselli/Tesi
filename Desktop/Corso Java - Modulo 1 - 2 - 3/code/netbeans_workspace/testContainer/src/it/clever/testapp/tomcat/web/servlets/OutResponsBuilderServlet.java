package it.clever.testapp.tomcat.web.servlets;

import it.clever.testapp.tomcat.business.model.ClientiVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.clever.testapp.tomcat.business.model.UserVO;

/**
 * Servlet implementation class OutResponsBuilderServlet
 */
public class OutResponsBuilderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see GenericServlet#GenericServlet()
	 */
	public OutResponsBuilderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = (String) request.getAttribute(IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION);
		String outputContent = "";
		if (IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_LOGIN_SUCCESS.equals(action)) {

			outputContent = createUserListOutput(request);

		} else if (IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_LOGIN_FAIL.equals(action)) {

			outputContent = createAuthErrorOutput();

		} else if (IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_USERLIST.equals(action)) {

			outputContent = createUserListTableOutput(request);
		}
                else if (IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_CLIENTILIST.equals(action)) {

			outputContent = createClientiListTableOutput(request);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(outputContent);
		out.flush();
		out.close();
	}

	/**
	 * Metodo per la creazione della pagina di output contenente la lista
	 * utenti.
	 * 
	 * @return
	 */
	private String createUserListOutput(HttpServletRequest request) {

		String contextPath = request.getServletContext().getContextPath();
		String outPage = "<html><body><div><a href=\"" + contextPath
				+ "/loadAllUsers\">Elenco utenti</a><div><a href=\"" + contextPath
				+ "/loadAllClienti\">Elenco CLIENTI</a></div></div></body></html>";
		return outPage;
	}

	private String createAuthErrorOutput() {
		String outPage = "<html> <body> <div> <h1> Error - Unauthorized Access </h1> </div> </body> </html>";
		return outPage;
	}

	private String createUserListTableOutput(HttpServletRequest request) {

		List<UserVO> userList = (List<UserVO>) request
				.getAttribute(IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_USERLIST);

		
		StringBuilder sb = new StringBuilder();
		sb.append("<html> <body> <div>");
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th>");
		sb.append("ID");
		sb.append("</th>");
		sb.append("<th>");
		sb.append("NOME");
		sb.append("</th>");
		sb.append("<th>");
		sb.append("COGNOME");
		sb.append("</th>");
		sb.append("</tr>");

		// Costruzione della tabella dei dati
		sb.append("<tbody>");
		for(UserVO u : userList){
			sb.append("<tr>");
			
			sb.append("<td>");
			sb.append(u.getId());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(u.getNome());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(u.getCognome());
			sb.append("</td>");
			
			sb.append("</tr>");
		}
		sb.append("</tbody>");

		sb.append("</table>");
		sb.append("</body> </html>");

		return sb.toString();
	}

        
        
        private String createClientiListTableOutput(HttpServletRequest request) {

		List<ClientiVO> clientiList = (List<ClientiVO>) request
				.getAttribute(IWebParameters.REQUEST_OUTPUT_BUILDER_ACTION_CLIENTILIST);

		
		StringBuilder sb = new StringBuilder();
		sb.append("<html> <body> <div>");
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th>");
		sb.append("ID");
		sb.append("</th>");
		sb.append("<th>");
		sb.append("CODICE");
		sb.append("</th>");
		sb.append("<th>");
		sb.append("RAG_SOC");
		sb.append("</th>");
                sb.append("<blink><th></blink>");
		sb.append("PIVA");
		sb.append("</th>");
                sb.append("<th>");
		sb.append("<body style=\"background:#80BFFF\">VERSION</blink>");
		sb.append("</th>"); 
		sb.append("</tr>");

		// Costruzione della tabella dei dati
		sb.append("<tbody>");
		for(ClientiVO u : clientiList){
			sb.append("<tr>");
			
			sb.append("<td>");
			sb.append(u.getId_cliente());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(u.getCodice());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(u.getRag_soc());
			sb.append("</td>");
                        sb.append("<td>");
			sb.append(u.getPiva());
			sb.append("</td>");
                        sb.append("<td>");
                        sb.append(u.getVersion());
			sb.append("</td>");
                        
			sb.append("</tr>");
		}
		sb.append("</tbody>");

		sb.append("</table>");
		sb.append("</body> </html>");

		return sb.toString();
	}

}
