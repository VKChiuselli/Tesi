/**
 * <b>UserForm.java</b>
 * 
 * <br/>
 * 
 * Classe per la gestione del form utente.
 * 
 */
package com.opengest.crm.web.forms;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.opengest.core.business.dto.ProductDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.services.IProductSevice;
import com.opengest.crm.exception.ValidatorException;

/**
 * 
 * @author Roberto Giontella
 */
public class ProductForm extends Form {

	private static final String FIELD_RESULT 		= "result";
    private static final String FIELD_ID 			= "productid";
    private static final String FIELD_CODE	 		= "code";
    private static final String FIELD_PRICE 		= "price";
    private static final String FIELD_DESCRIPTION 	= "description";
    private static final String FIELD_CONFIRM 		= "confirm";

    private IProductSevice productSevice;

	public ProductForm(IProductSevice productSevice) {
		this.productSevice = productSevice;
	}
    
    
    public ProductDTO registerProductForCreate(HttpServletRequest request) {
    	ProductDTO prod = new ProductDTO();
        try {
            processCode(request, prod);
            processDescription(request, prod);
            processPrice(request, prod);

        } catch (Exception e) {
            setError(FIELD_RESULT, "Registrazione fallita per problemi con il database."
                + " Riprovare più tardi. Messaggio: " + e.getMessage());
            e.printStackTrace();
        }

        return prod;
    }
    
    public ProductDTO registerProductforUpdate(HttpServletRequest request) throws ValidatorException {
    	
		String id = FormUtil.getFieldValue(request, FIELD_ID);
		ProductDTO prod = null;
		try {
			prod = productSevice.findProductById(new Long(id));
			
			if(prod == null) {
				setError(FIELD_ID, "Nessun prodotto con l'ID specificato!");
				throw new ValidatorException("Validazione Fallita");
			}
			
			processCode(request, prod);
			processDescription(request, prod);
			processPrice(request, prod);
			
		} catch (Exception e) {
			setError(FIELD_ID, e.getMessage());
			e.printStackTrace();
		}
	
	return prod;
}    
    
    private void processCode(HttpServletRequest request, ProductDTO prod) throws ValidatorException {
        String code = FormUtil.getFieldValue(request, FIELD_CODE);

        if (code == null || FormUtil.isChanged(prod.getCode(), code)) {
            try {
                validateCode(code);
            } catch (ValidatorException e) {
                setError(FIELD_CODE, e.getMessage());
                throw e;
            }
            prod.setCode(code);
        }
    }
    
    private void processDescription(HttpServletRequest request, ProductDTO prod) throws ValidatorException {
    	String description = FormUtil.getFieldValue(request, FIELD_DESCRIPTION);
    	
    	if (description == null || FormUtil.isChanged(prod.getCode(), description)) {
    		try {
    			validateDescription(description);
    		} catch (ValidatorException e) {
    			setError(FIELD_DESCRIPTION, e.getMessage());
    			throw e;
    		}
    		prod.setDescription(description);
    	}
    }
    
    private void processPrice(HttpServletRequest request, ProductDTO prod) throws ValidatorException {
    	String price = FormUtil.getFieldValue(request, FIELD_PRICE);
    	
    	if (price == null || FormUtil.isChanged(prod.getCode(), price)) {
    		try {
    			validatePrice(price);
    		} catch (ValidatorException e) {
    			setError(FIELD_PRICE, e.getMessage());
    			throw e;
    		}
    		BigDecimal bd = FormUtil.trasformFromStringToBigDecimal(price);
    		prod.setPrice(bd);
    	}
    }
    
    private void validateCode(String code) throws ValidatorException {
        if (code != null) {
        	try {
					if (productSevice.existCode(code)) {
					    throw new ValidatorException("Codice già in uso.");
					}
				} catch (BusinessException e) {
					e.printStackTrace();
					throw new ValidatorException("Errore durante il controllo del codice prodotto.");
				} 
        } else {
            throw new ValidatorException("Codice non può essere vuoto.");
        }
    }
    
    private void validateDescription(String decr) throws ValidatorException {
    	if (decr == null) {
    		throw new ValidatorException("Codice non può essere vuoto.");
    	}
    }
    
    private void validatePrice(String price) throws ValidatorException {
    	if (price == null) {
    		throw new ValidatorException("Il costo non può essere nullo.");
    	} 
//    	else if(!FormUtil.isNumber(price)){
//    		throw new ValidatorException("Il valore non è valido.");
//    	} 
    	else {
    		try {
    			BigDecimal bd = FormUtil.trasformFromStringToBigDecimal(price);
    		} catch(Exception ex) {
    			throw new ValidatorException("Il valore non è valido.");
    		}
    	}
    }
}
