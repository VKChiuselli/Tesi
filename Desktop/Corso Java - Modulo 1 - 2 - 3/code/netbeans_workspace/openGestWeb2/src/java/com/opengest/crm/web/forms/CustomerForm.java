/**
 * <b>CustomerForm.java</b>
 * 
 * <br/>
 * 
 * Classe per la gestione del form cliente.
 * 
 */
package com.opengest.crm.web.forms;

import javax.servlet.http.HttpServletRequest;

import com.opengest.core.business.dto.CustomerDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.services.ICustomerSevice;
import com.opengest.crm.exception.ValidatorException;

/**
 * 
 * @author Roberto Giontella
 */
public class CustomerForm extends Form {

	private static final String FIELD_RESULT 		= "result";
    private static final String FIELD_ID 			= "customerid";
    private static final String FIELD_CODE	 		= "code";
    private static final String FIELD_RAGSOC 		= "ragsoc";
    private static final String FIELD_PIVA		 	= "piva";
    private static final String FIELD_CONFIRM 		= "confirm";

    private ICustomerSevice customerSevice;

	public CustomerForm(ICustomerSevice customerSevice) {
		this.customerSevice = customerSevice;
	}
    
    
    public CustomerDTO registerCustomerForCreate(HttpServletRequest request) {
    	CustomerDTO cust = new CustomerDTO();
        try {
            processCode(request, cust);
            processRagSoc(request, cust);
            processPiva(request, cust);

        } catch (Exception e) {
            setError(FIELD_RESULT, "Registrazione fallita per problemi con il database."
                + " Riprovare più tardi. Messaggio: " + e.getMessage());
            e.printStackTrace();
        }

        return cust;
    }
    
    public CustomerDTO registerCustomerforUpdate(HttpServletRequest request) throws ValidatorException {
    	
		String id = FormUtil.getFieldValue(request, FIELD_ID);
		CustomerDTO cust = null;
		try {
			cust = customerSevice.findCustomerById(new Long(id));
			
			if(cust == null) {
				setError(FIELD_ID, "Nessun cliente con l'ID specificato!");
				throw new ValidatorException("Validazione Fallita");
			}
			
			processCode(request, cust);
			processRagSoc(request, cust);
			processPiva(request, cust);
			
		} catch (Exception e) {
			setError(FIELD_ID, e.getMessage());
			e.printStackTrace();
		}
	
	return cust;
}    
    
    private void processCode(HttpServletRequest request, CustomerDTO cust) throws ValidatorException {
        String code = FormUtil.getFieldValue(request, FIELD_CODE);

        if (code == null || FormUtil.isChanged(cust.getCode(), code)) {
            try {
                validateCode(code);
            } catch (ValidatorException e) {
                setError(FIELD_CODE, e.getMessage());
                throw e;
            }
            cust.setCode(code);
        }
    }
    
    private void processRagSoc(HttpServletRequest request, CustomerDTO cust) throws ValidatorException {
    	String ragSoc = FormUtil.getFieldValue(request, FIELD_RAGSOC);
    	
    	if (ragSoc == null || FormUtil.isChanged(cust.getCode(), ragSoc)) {
    		try {
    			validateRagSoc(ragSoc);
    		} catch (ValidatorException e) {
    			setError(FIELD_RAGSOC, e.getMessage());
    			throw e;
    		}
    		cust.setRagsoc(ragSoc);
    	}
    }
    
    private void processPiva(HttpServletRequest request, CustomerDTO prod) throws ValidatorException {
    	String piva = FormUtil.getFieldValue(request, FIELD_PIVA);
    	
    	if (piva == null || FormUtil.isChanged(prod.getCode(), piva)) {
    		try {
    			validatePiva(piva);
    		} catch (ValidatorException e) {
    			setError(FIELD_PIVA, e.getMessage());
    			throw e;
    		}
    		Long bd = new Long(piva);
    		prod.setPiva(bd);
    	}
    }
    
    private void validateCode(String code) throws ValidatorException {
        if (code != null) {
        	try {
					if (customerSevice.existCode(code)) {
					    throw new ValidatorException("Codice già in uso.");
					}
				} catch (BusinessException e) {
					e.printStackTrace();
					throw new ValidatorException("Errore durante il controllo del codice cliente.");
				} 
        } else {
            throw new ValidatorException("Codice non può essere vuoto.");
        }
    }
    
    private void validateRagSoc(String ragsoc) throws ValidatorException {
    	if (ragsoc == null) {
    		throw new ValidatorException("La ragione sociale non può essere vuota.");
    	}
    }
    
    private void validatePiva(String piva) throws ValidatorException {
    	if (piva == null) {
    		throw new ValidatorException("La partita iva non può essere nulla.");
    	} 
    	else {
    		if(piva.length() != 11) {
    			throw new ValidatorException("Il valore non è valido.");
    		}
    		try {
    				new Long(piva);
    		} catch(Exception ex) {
    			throw new ValidatorException("Il valore non è valido.");
    		}
    	}
    }
}
