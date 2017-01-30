package com.opengest.crm.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opengest.crm.web.utils.IAppCostants;

public class FrontControllerFilter implements Filter {

	private ServletContext context;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*
		 * Filtro per la gestione del pattern FrontController.
		 * 
		 * 1. controllo sull'autenticazione utente;
		 * 2. logging dell'utente;
		 * 4. selezione del locale.
		 */
		
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		System.out.println("Richiesta provenente da: " + request.getRemoteAddr());
		String referer = httpRequest.getHeader("Referer");
		if (referer != null) {
			System.out.println("Referer: " + referer);
		}
		System.out.println("Locale: " + request.getLocale());
		System.out.println("Canale sicuro: " + request.isSecure());
		
		String servletPath = httpRequest.getServletPath();
		HttpServletResponse httpResponse = ((HttpServletResponse)response);
		
		String errorMSG = (String)httpRequest.getAttribute(IAppCostants.REQUEST_PARAM_ERROR_MESSAGE);
		if(errorMSG != null) {
			System.err.println("Messaggio di errore: " + errorMSG);
		}
		
		if(!servletPath.isEmpty() 
				&& !servletPath.contains("/login")				
				&& !servletPath.contains("/logininit")				
				&& !servletPath.contains("/resources/")) {
			
				// Invio della navigazione verso aree differenti da quelle della registrazione o login.
				if(!checkAuthorization(httpRequest)) {
					servletPath = IAppCostants.CONTEXT_PATH_INIT_LOGIN;
					context.getRequestDispatcher(servletPath).forward(httpRequest, httpResponse);
				} else {
					chain.doFilter(request, response);
				}
		}  else {
			chain.doFilter(request, response);
		} 
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Il filtro è stato inizializzato");
		context = config.getServletContext();
	}

	/**
	 * Metodo per il controllo dell'esistenza dei dati utente in sessione.
	 * @param request
	 * @return
	 */
	private boolean checkAuthorization(HttpServletRequest request) {
		
		if(request.getSession(false) != null
				&& request.getSession(false).getAttribute(IAppCostants.SESSION_PARAM_LOGGED_USER) != null){
			return true;
		} else {
			return false;
		}
	}


}
