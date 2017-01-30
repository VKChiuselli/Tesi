/**
 * JSONServlet
 * 
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.nxt.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.clever.nxt.business.model.Article;

/**
 * @author robgion
 *
 */
@WebServlet(description = "A simple Sample",urlPatterns = { "/jsonservlet" })
public class JSONServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// Lista per il salvataggio degli articoli
	List<Article> articles = new LinkedList<Article>();
	
	/***************************************************
	 * URL: /jsonservlet
	 * doPost(): riceve dati JSON, li parsa, li mappa e li restituisce indietro come JSON
	 ****************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException{
	    
		// 1. ricevimento dei dati JSON dalla request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		// 2. inizializzazione del jackson mapper
    	ObjectMapper mapper = new ObjectMapper();
    	
    	// 3. conversione dei dati JSON in un Article
    	Article article = mapper.readValue(json, Article.class);

		// 4. Setta il response type in JSON
		response.setContentType("application/json");		    
    	
    	// 5. aggiunge un articolo al List<Article>
		articles.add(article);

		// 6. Invia il List<Article> in formato JSON al client
    	mapper.writeValue(response.getOutputStream(), articles);
	}
}
