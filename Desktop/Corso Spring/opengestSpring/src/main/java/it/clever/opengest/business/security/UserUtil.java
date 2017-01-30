package it.clever.opengest.business.security;

import it.clever.opengest.business.domain.Authority;
import it.clever.opengest.business.domain.Company;
import it.clever.opengest.business.domain.User;
import it.clever.opengest.exceptions.SessionExpiredException;
import it.clever.opengest.exceptions.UserAlreadyExistsException;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {
	private static String VALID_USERNAME_REGEX = "[a-zA-Z][a-zA-Z0-9_]*";

	/**
	 * Checks if an user with the same username already exists.
	 * @param newuser
	 * @throws UserAlreadyExistsException
	 */
	public static void checkUsernameForNewUser(User newuser) throws UserAlreadyExistsException {
		if(User.findUser(newuser.getUsername()) != null) {
			throw new UserAlreadyExistsException(newuser.getUsername());
		}
	}
	
	public static boolean isValidUserName(String username) {
		return username.length() >= 3 && username.length() <= 20 && username.matches(VALID_USERNAME_REGEX);
	}
	
	public static boolean isCurrentUserSuperAdmin() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!(principal instanceof OpengestUserDetail))
			throw new SessionExpiredException("Session expired!");
		
		OpengestUserDetail cmsUserDetail = (OpengestUserDetail) principal;
    	Collection<GrantedAuthority> grantedAuthorities = cmsUserDetail.getAuthorities();
    	for (GrantedAuthority grantedAuthority : grantedAuthorities) {
			 if (Authority.ROLE_SUPERADMIN.equals(grantedAuthority.getAuthority())) {
				 return true;
			 }
		}
    	
    	return false;
	}
	
	public static boolean isCurrentUserCardWhareHouseEnabled() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!(principal instanceof OpengestUserDetail))
			throw new SessionExpiredException("Session expired!");
		
		OpengestUserDetail cmsUserDetail = (OpengestUserDetail) principal;
    	Collection<GrantedAuthority> grantedAuthorities = cmsUserDetail.getAuthorities();
    	for (GrantedAuthority grantedAuthority : grantedAuthorities) {
			 if (Authority.ROLE_BRANCH_CHOOSER.equals(grantedAuthority.getAuthority())) {
				 return true;
			 }
		}
    	return false;		
	}
	
	public static Integer retrieveCurrentUserIdCompany() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof OpengestUserDetail) {
			return ((OpengestUserDetail) principal).getIdCompany();
		} else {
			throw new SessionExpiredException("Session expired!");
		}
    }
	
	public static String retrieveCurrentUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof OpengestUserDetail) {
        	return ((OpengestUserDetail) principal).getUsername();
		} else {
			throw new SessionExpiredException("Session expired!");
		}
    }
	
	public static void changeCurrentUserIdCompany(Integer idCompany) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof OpengestUserDetail) {
			OpengestUserDetail cmsUserDetail = (OpengestUserDetail) principal;
			cmsUserDetail.setIdCompany(idCompany);
			User user = User.findUser(cmsUserDetail.getUsername());
			String descCompany = Company.findByIdCompany(idCompany).get(0).getDescription();
			if (!user.getCompany().getIdCompany().equals(idCompany)) {
				descCompany = descCompany + "(solo per questa sessione)";
			}
			cmsUserDetail.setCompanyDescr(descCompany);
		} else {
			throw new SessionExpiredException("Session expired!");
		}
    }
	
	public static String retrieveCurrentUserEncodedPassword() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof OpengestUserDetail) {
        	return ((OpengestUserDetail) principal).getPassword();
		} else {
			throw new SessionExpiredException("Session expired!");
		}
	}
}
