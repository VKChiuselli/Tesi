/**
 * <b>UserForm.java</b>
 * 
 * <br/>
 * 
 * Classe per la gestione del form utente.
 * 
 */
package com.opengest.crm.web.forms;

import javax.servlet.http.HttpServletRequest;

import com.opengest.core.business.dto.UserDTO;
import com.opengest.core.business.exception.BusinessException;
import com.opengest.core.business.services.IUserSevice;
import com.opengest.crm.exception.ValidatorException;


/**
 * 
 * @author Roberto Giontella
 */
public final class UserForm extends Form {

    // Constants ----------------------------------------------------------------------------------

	private static final String FIELD_RESULT 	= "result";
    private static final String FIELD_ID 		= "userid";
    private static final String FIELD_USERNAME 	= "username";
    private static final String FIELD_PASSWORD 	= "password";
    private static final String FIELD_CONFIRM 	= "confirm";
    private static final String FIELD_EMAIL 	= "email";
    private static final String FIELD_NAME 		= "nome";
    private static final String FIELD_LASTNAME 	= "cognome";

    // Variables ----------------------------------------------------------------------------------

    private IUserSevice userService;

    // Constructors -------------------------------------------------------------------------------

    /**
     * Construct an User Form associated with the given UserDao.
     * @param userDAO The User DAO to be associated with the User Form.
     */
    public UserForm(IUserSevice userService) {
        this.userService = userService;
    }

    // Form actions -------------------------------------------------------------------------------

    /**
     * Returns the registered User based on the given request. It will gather all form fields,
     * process and validate the fields and save the created User using the User DAO associated with
     * this form.
     * @param request The request to register an User for.
     * @return The registered User based on the given request.
     */
    public UserDTO registerUserForCreate(HttpServletRequest request) {
    	UserDTO user = new UserDTO();
        try {
            processUsername(request, user);
            processPassword(request, user);
            processEmail(request, user);
            processName(request, user);
            processLastName(request, user);

        } catch (Exception e) {
            setError(FIELD_RESULT, "Registrazione fallita per problemi con il database."
                + " Riprovare pi� tardi. Messaggio: " + e.getMessage());
            e.printStackTrace();
        }

        return user;
    }
    
    /**
     * Returns the registered User based on the given request. It will gather all form fields,
     * process and validate the fields and save the created User using the User DAO associated with
     * this form.
     * @param request The request to register an User for.
     * @return The registered User based on the given request.
     * @throws ValidatorException 
     */
    public UserDTO registerUserforUpdate(HttpServletRequest request) throws ValidatorException {
    	
    		String id = FormUtil.getFieldValue(request, FIELD_ID);
    		UserDTO user = null;
			try {
				user = userService.findUserById(new Long(id));
				
				if(user == null) {
					setError(FIELD_ID, "Nessun utente con l'ID specificato!");
					throw new ValidatorException("Validazione Fallita");
				}
				
				processUsername(request, user);
				processPassword(request, user);
				processEmail(request, user);
				
//				if (!isSucces()) {
//					throw new ValidatorException("Validazione Fallita");
//				}
			} catch (NumberFormatException e) {
				setError(FIELD_ID, e.getMessage());
				e.printStackTrace();
			} catch (BusinessException e) {
				setError(FIELD_ID, e.getMessage());
				e.printStackTrace();
			}
    	
    	return user;
    }

    // Field processors ---------------------------------------------------------------------------

    /**
     * Process and validate the username which is to be associated with the given User.
     * If the username is null or if it is changed in the given user, then it will be validated.
     * The new username will be set in the given user regardless of the outcome of the validation.
     * @param request The request to get the username from.
     * @param user The User to be associated with the username.
     * @throws DAOException If something fails at DAO level.
     */
    private void processUsername(HttpServletRequest request, UserDTO user) throws ValidatorException {
        String username = FormUtil.getFieldValue(request, FIELD_USERNAME);

        if (username == null || FormUtil.isChanged(user.getUsername(), username)) {
            try {
                validateUsername(username);
            } catch (ValidatorException e) {
                setError(FIELD_USERNAME, e.getMessage());
                throw e;
            }
            user.setUsername(username);
        }
    }

    /**
     * Process and validate the passwords which is to be associated with the given User.
     * The passwords will be validated regardless of the current password of the given user.
     * The password will be set in the given user only if validation succeeds.
     * @param request The request to get the passwords from.
     * @param user The User to be associated with the passwords.
     */
    private void processPasswords(HttpServletRequest request, UserDTO user) {
        String password = FormUtil.getFieldValue(request, FIELD_PASSWORD);
        String confirm = FormUtil.getFieldValue(request, FIELD_CONFIRM);

        try {
            validatePasswords(password, confirm);
            user.setPassword(password);
        } catch (ValidatorException e) {
            setError(FIELD_PASSWORD, e.getMessage());
            setError(FIELD_CONFIRM, null);
        }
    }

    /**
     * Process and validate the password which is to be associated with the given User.
     * The password will be validated regardless of the current password of the given user.
     * The password will be set in the given user only if validation succeeds.
     * @param request The request to get the passwords from.
     * @param user The User to be associated with the passwords.
     */
    private void processPassword(HttpServletRequest request, UserDTO user) {
        String password = FormUtil.getFieldValue(request, FIELD_PASSWORD);

        try {
            validatePassword(password);
            user.setPassword(password);
        } catch (ValidatorException e) {
            setError(FIELD_PASSWORD, e.getMessage());
        }
    }

    /**
     * Process and validate the email which is to be associated with the given User.
     * If the email is changed in the given user, then it will be validated.
     * The email will be set in the given user regardless of the outcome of the validation.
     * @param request The request to get the email from.
     * @param user The User to be associated with the email.
     * @throws DAOException If something fails at DAO level.
     */
    private void processEmail(HttpServletRequest request, UserDTO user) throws ValidatorException {
        String email = FormUtil.getFieldValue(request, FIELD_EMAIL);

        if (FormUtil.isChanged(user.getEmail(), email)) {
            try {
                validateEmail(email);
            } catch (ValidatorException e) {
                setError(FIELD_EMAIL, e.getMessage());
                throw e;
            }
            user.setEmail(email);
        }
    }
    
    
    private void processName(HttpServletRequest request, UserDTO user) throws ValidatorException {
        String name = FormUtil.getFieldValue(request, FIELD_NAME);

        if (name == null || FormUtil.isChanged(user.getNome(), name)) {
            try {
                validateName(name);
            } catch (ValidatorException e) {
                setError(FIELD_NAME, e.getMessage());
                throw e;
            }
            user.setNome(name);
        }
    }
    
    private void processLastName(HttpServletRequest request, UserDTO user) throws ValidatorException {
    	String lastName = FormUtil.getFieldValue(request, FIELD_LASTNAME);
    	
    	if (lastName == null || FormUtil.isChanged(user.getNome(), lastName)) {
    		try {
    			validateLastName(lastName);
    		} catch (ValidatorException e) {
    			setError(FIELD_LASTNAME, e.getMessage());
    			throw e;
    		}
    		user.setCognome(lastName);
    	}
    }
    

    // Field validators ---------------------------------------------------------------------------

    /**
     * Validate the given username. It will check if it is not null, is at least 3 characters long 
     * and is not already in use according to the User DAO associated with this form.
     * @param username The username to be validated.
     * @throws ValidatorException If the username is invalid.
     * @throws DAOException If something fails at DAO level.
     */
    private void validateUsername(String username) throws ValidatorException {
        if (username != null) {
            if (username.length() < 3) {
                throw new ValidatorException("Username deve essere lungo minimo 3 caratteri.");
            } else
				try {
					if (userService.existUsername(username)) {
					    throw new ValidatorException("Username gi� in uso.");
					}
				} catch (BusinessException e) {
					e.printStackTrace();
					throw new ValidatorException("Errore durante il controllo dello username.");
				} 
        } else {
            throw new ValidatorException("Username non pu� essere vuoto.");
        }
    }

    /**
     * Validate the given passwords. It will check if the password and the password confirmation are
     * not null, are equal and are at least 3 characters long. 
     * @param password The password to be validated.
     * @param confirm The password confirmation to be validated.
     * @throws ValidatorException If the password is invalid.
     */
    private void validatePasswords(String password, String confirm) throws ValidatorException {
        if (password != null && confirm != null) {
            if (!password.equals(confirm)) {
                throw new ValidatorException("Passwords are not equal, please retype passwords.");
            } else if (password.length() < 3) {
                throw new ValidatorException("Passwords should be at least 3 characters long.");
            }
        } else {
            throw new ValidatorException("Please enter both password and confirm password.");
        }
    }

    /**
     * Validate the given password. It will check if the password is not null and is at least 3
     * characters long.
     * @param password The password to be validated.
     * @throws ValidatorException If the password is invalid.
     */
    private void validatePassword(String password) throws ValidatorException {
        if (password != null) {
            if (password.length() < 3) {
                throw new ValidatorException("Password should be at least 3 characters long.");
            }
        } else {
            throw new ValidatorException("Please enter password.");
        }
    }

    /**
     * Validate the given email. It will check if it confirms the email address requirements and is
     * not already in use according to the User DAO associated with this form. 
     * @param email The email to be validated.
     * @throws ValidatorException If the email is invalid.
     * @throws DAOException If something fails at DAO level.
     */
    private void validateEmail(String email) throws ValidatorException {
        if (email != null) {
            if (!FormUtil.isEmail(email)) {
                throw new ValidatorException("Please enter valid email address.");
            }
        }
    }
    
    /**
     * Validate the given name. It will check if it confirms the name  requirements and is
     * present according to the User DAO associated with this form. 
     * @param name The email to be validated.
     * @throws ValidatorException If the email is invalid.
     * @throws DAOException If something fails at DAO level.
     */
    private void validateName(String name) throws ValidatorException {
    	if (name == null) {
    			throw new ValidatorException("Please enter a value for field name.");
    	}
    }
    
    /**
     * Validate the given name. It will check if it confirms the name  requirements and is
     * present according to the User DAO associated with this form. 
     * @param LastName The email to be validated.
     * @throws ValidatorException If the email is invalid.
     * @throws DAOException If something fails at DAO level.
     */
    private void validateLastName(String LastName) throws ValidatorException {
    	if (LastName == null) {
    		throw new ValidatorException("Please enter a value for field last name.");
    	}
    }

}