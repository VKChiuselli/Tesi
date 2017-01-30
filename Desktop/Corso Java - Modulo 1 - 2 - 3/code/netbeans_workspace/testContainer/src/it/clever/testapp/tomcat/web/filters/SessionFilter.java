/**
 * SessionFilter.java
 *
 * robgion
 * www.2clever.it
 * 
 * 19 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.testapp.tomcat.web.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author robgion
 *
 * Classe che implementa il filtro sulla presenza della sessione.
 * avoid-urls: lista di tutti gli URL permessi senza essere sottoposti 
 * a check sull'esistenza della sessione.
 */
public class SessionFilter implements Filter {
private ArrayList<String> urlList;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getServletPath();	
		boolean allowedRequest = false;
		
		if(urlList.contains(url) || url.contains("/resources/") || url.contains("login")) {
			allowedRequest = true;
		}
			
		if (!allowedRequest) {
			HttpSession session = request.getSession(false);
			if (null == session) {
				response.sendRedirect(request.getContextPath() + "/pages/login.html");
			}
		}
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");

		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());

		}
	}
}
