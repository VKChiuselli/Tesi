package it.clever.opengest.business.security;

import it.clever.opengest.business.domain.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class OpengestJdbcUserDetailsManager extends JdbcUserDetailsManager {
	private static final Log LOGGER = LogFactory
			.getLog(OpengestJdbcUserDetailsManager.class);

	public static final String ID_COMPANY_BY_USERNAME_QUERY = "select c.id_company, c.description "
			+ "from utenti u, company c "
			+ "where u.username = ? and c.id = u.company";

	public static final String GROUPS_BY_USERNAME_QUERY = "select g.group_name "
			+ "from auth_group_members gm, auth_groups g "
			+ "where gm.username = ? and gm.group_id = g.id";

	public static final String USER_BY_USERNAME_QUERY = "select username,password,enabled from utenti where username = ?";
    
	public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
            "select username,authority " +
            "from auth_authorities " +
            "where username = ?";
    
    public static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY =
            "select g.id, g.group_name, ga.authority " +
            "from auth_groups g, auth_group_members gm, auth_group_authorities ga " +
            "where gm.username = ? " +
            "and g.id = ga.group_id " +
            "and g.id = gm.group_id";
 /*
    "select g.id, g.group_name, ga.role_name as authority  " +
	 " from auth_groups g, auth_user_groups gm, auth_groups_authorities ga, auth_users  u " +
	 " where g.id = ga.group_id and g.id = gm.group_id  and (gm.id_user = u.id and u.username = ?)";
 */   
	private String usersByUsernameQuery;

	private boolean enableAuthorities = true;
	private boolean enableGroups;

	public OpengestJdbcUserDetailsManager() {

		super.setUsersByUsernameQuery(USER_BY_USERNAME_QUERY);
		super.setAuthoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY);
		super.setGroupAuthoritiesByUsernameQuery(DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY);
	}

	@Override
	protected UserDetails createUserDetails(String username,
			UserDetails userFromUserQuery,
			List<GrantedAuthority> combinedAuthorities) {
		UserDetails userDetails = super.createUserDetails(username,
				userFromUserQuery, combinedAuthorities);
		Company company = loadCompaniesByUsername(userDetails.getUsername())
				.get(0);
		List<String> groups = loadGroupsByUsername(username);

		LOGGER.info("Logged username=[" + username + "]");
		return new OpengestUserDetail(userDetails, company.getIdCompany(),
				company.getDescription(), groups);
	}

	protected List<Company> loadCompaniesByUsername(String username) {
		return getJdbcTemplate().query(ID_COMPANY_BY_USERNAME_QUERY,
				new String[] { username }, new RowMapper<Company>() {
					public Company mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Company company = new Company();
						company.setIdCompany(rs.getInt(1));
						company.setDescription(rs.getString(2));
						return company;
					}
				});
	}

	protected List<String> loadGroupsByUsername(String username) {
		return getJdbcTemplate().query(GROUPS_BY_USERNAME_QUERY,
				new String[] { username }, new RowMapper<String>() {
					public String mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return rs.getString(1);
					}
				});
	}

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		LOGGER.info("Try login for username=[" + username + "] ...");
//			if (!UserUtil.isValidUserName(username))
//			return new ArrayList<UserDetails>();

		List<UserDetails> users = super.loadUsersByUsername(username);
		return users;

	}

	@SuppressWarnings("deprecation")
	@Override
	public UserDetails loadUserByUsername(String username) {
		List<UserDetails> users = loadUsersByUsername(username);

		if (users.size() == 0) {
			throw new UsernameNotFoundException(messages.getMessage(
					"JdbcDaoImpl.notFound", new Object[] { username },
					"Username {0} not found"), username);
		}

		UserDetails user = users.get(0); // contains no GrantedAuthority[]

		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();

		if (enableAuthorities) {
			dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));
		}

		if (enableGroups) {
			dbAuthsSet.addAll(loadGroupAuthorities(user.getUsername()));
		}

		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(
				dbAuthsSet);
		
		addCustomAuthorities(user.getUsername(), dbAuths);

		if (dbAuths.size() == 0) {
			throw new UsernameNotFoundException(messages.getMessage(
					"JdbcDaoImpl.noAuthority", new Object[] { username },
					"User {0} has no GrantedAuthority"), username);
		}

		return createUserDetails(username, user, dbAuths);
	}

	public boolean isEnableAuthorities() {
		return enableAuthorities;
	}

	public void setEnableAuthorities(boolean enableAuthorities) {
		this.enableAuthorities = enableAuthorities;
	}

	public boolean isEnableGroups() {
		return enableGroups;
	}

	public void setEnableGroups(boolean enableGroups) {
		this.enableGroups = enableGroups;
	}

}
