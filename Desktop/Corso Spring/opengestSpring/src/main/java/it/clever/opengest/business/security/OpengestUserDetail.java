package it.clever.opengest.business.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class OpengestUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final UserDetails userDetail;
	private int idCompany;
	private String companyDescr;
	private final List<String> groups;

	
	public OpengestUserDetail(UserDetails userDetail, int idCompany, String companyDescr, List<String> groups) {
		this.userDetail = userDetail;
		this.setIdCompany(idCompany);
		this.setCompanyDescr(companyDescr);
		this.groups = groups;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return (Collection<GrantedAuthority>) userDetail.getAuthorities();
	}

	@Override
	public String getPassword() {
		return userDetail.getPassword();
	}

	@Override
	public String getUsername() {
		return userDetail.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return userDetail.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return userDetail.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return userDetail.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return userDetail.isEnabled();
	}

	public int getIdCompany() {
		return idCompany;
	}
	
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getCompanyDescr() {
		return companyDescr;
	}
	
	public void setCompanyDescr(String companyDescr) {
		this.companyDescr = companyDescr;
	}

	public List<String> getGroups() {
		return groups;
	}

}
