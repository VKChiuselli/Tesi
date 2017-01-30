/**
 * <b>UserForm.java</b>
 * 
 * <br/>
 * 
 * Classe per la gestione del form utente.
 * 
 */
package com.opengest.crm.web.forms;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.opengest.core.business.dto.OrderDTO;
import com.opengest.core.business.services.IOrderSevice;
import com.opengest.core.business.vo.CustomerVO;
import com.opengest.core.business.vo.ProductVO;
import com.opengest.crm.exception.ValidatorException;

/**
 * 
 * @author Roberto Giontella
 */
public class OrderForm extends Form {

	private static final String FIELD_RESULT 		= "result";
    private static final String FIELD_ID 			= "orderid";
    private static final String FIELD_AMOUNT	 	= "amount";
    private static final String FIELD_QUANTITY 		= "quantity";
    private static final String FIELD_DATE		 	= "date";
    private static final String FIELD_CUSTOMER 		= "customer";
    private static final String FIELD_PRODUCT 		= "product";

    private IOrderSevice orderSevice;

	public OrderForm(IOrderSevice oSevice) {
		this.orderSevice = oSevice;
	}
    
    
    public OrderDTO registerOrderForCreate(HttpServletRequest request) {
    	OrderDTO order = new OrderDTO();
        try {
            processQuantity(request, order);
            
            String date = FormUtil.getFieldValue(request, FIELD_DATE);
            Date formattedDate = FormUtil.fromStringToDate_ddMMyyyy(date);
            order.setDate(formattedDate);
            
            String customerid = FormUtil.getFieldValue(request, FIELD_CUSTOMER);
            CustomerVO cust = new CustomerVO();
            cust.setId(new Long(customerid));
            order.setCustomer(cust);
            
            String productid = FormUtil.getFieldValue(request, FIELD_PRODUCT);
            ProductVO prod = new ProductVO();
            prod.setId(new Long(productid));
            order.setProduct(prod);
            
            
        } catch (Exception e) {
            setError(FIELD_RESULT, "Registrazione fallita per problemi con il database."
                + " Riprovare più tardi. Messaggio: " + e.getMessage());
            e.printStackTrace();
        }

        return order;
    }
    
    public OrderDTO registerOrderforUpdate(HttpServletRequest request) throws ValidatorException {
    	
			String id = FormUtil.getFieldValue(request, FIELD_ID);
			OrderDTO prod = null;
			try {
				prod = orderSevice.findOrderById(new Long(id));
				
				if(prod == null) {
					setError(FIELD_ID, "Nessun prodotto con l'ID specificato!");
					throw new ValidatorException("Validazione Fallita");
				}
				
				processQuantity(request, prod);
				
			} catch (Exception e) {
				setError(FIELD_ID, e.getMessage());
				e.printStackTrace();
			}
		
		return prod;
	}    
    
  
    private void processQuantity(HttpServletRequest request, OrderDTO prod) throws ValidatorException {
    	String quantity = FormUtil.getFieldValue(request, FIELD_QUANTITY);
    	
    	if (quantity == null || FormUtil.isChanged(prod.getQuantity(), quantity)) {
    		try {
    			validateQuantity(quantity);
    		} catch (ValidatorException e) {
    			setError(FIELD_QUANTITY, e.getMessage());
    			throw e;
    		}
    		Integer q = FormUtil.trasformFromStringToInteger(quantity);
    		prod.setQuantity(q);
    	}
    }
    
    
    
    private void validateQuantity(String quantity) throws ValidatorException {
    	if (quantity == null) {
    	} 
    	else {
    		try {
    			Integer q = FormUtil.trasformFromStringToInteger(quantity);
    		} catch(Exception ex) {
    			throw new ValidatorException("Il valore non è valido.");
    		}
    	}
    }
}
