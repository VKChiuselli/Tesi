package it.clever.opengest.business.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@Table(name = "utenti")
public class User {
	
	   @PersistenceContext
	    transient EntityManager entityManager;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id_utente")
	    private Long id;
	    
	    @Column(name = "username")
	    @Size(max = 20)
	    private String username;

	    @NotNull
	    @Column(name = "password")
	    private String password;

	    @Column(name = "enabled")
	    private Boolean enabled;
	    
	    @ManyToOne(targetEntity = Company.class)
	    @JoinColumn
	    private Company company;

	    @ManyToMany()
	    @JoinTable(name = "auth_group_members", joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"), inverseJoinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"))
	    private Set<Group> groups = new java.util.HashSet<Group>();


		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}

		public Set<Group> getGroups() {
			return groups;
		}

		public void setGroups(Set<Group> groups) {
			this.groups = groups;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		  public static User findUser(String id) {
		        if (id == null || 0 == id.length()) return null;
		        return entityManager().find(User.class, id);
		    }

		    public static final EntityManager entityManager() {
		        EntityManager em = new User().entityManager;
		        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
		        return em;
		    }

		    @SuppressWarnings("unchecked")
		    public static List<User> findAllUsers() {
		        return entityManager().createQuery("select o from User o").getResultList();
		    }

		    public static long countUsersByIdCompany(Integer idCompany) {
		    	if (idCompany == null) throw new IllegalArgumentException("The idCompany argument is required");
		    	return ((Number) entityManager().createQuery("select count(o) from User o where o.company.idCompany = :idCompany").setParameter("idCompany", idCompany).getSingleResult()).longValue();
		    }


		    public static Query findUsersByIdCompany(Integer idCompany) {
		        if (idCompany == null) throw new IllegalArgumentException("The idCompany argument is required");
		        EntityManager em = entityManager();
		        Query q = em.createQuery("SELECT u FROM User AS u WHERE u.company.idCompany = :idCompany");
		        q.setParameter("idCompany", idCompany);
		        return q;
		    }
		    
		    public static Query findUsersByIdCompanyAndBranchCode(Integer idCompany, String branchCode) {
		        if (idCompany == null) throw new IllegalArgumentException("The idCompany argument is required");
		        if (branchCode == null || branchCode.isEmpty()) throw new IllegalArgumentException("The branchCode argument is required");
		        EntityManager em = entityManager();
		        Query q = em.createQuery("SELECT u FROM User AS u WHERE u.company.idCompany = :idCompany and u.branch = :branchCode");
		        q.setParameter("idCompany", idCompany);
		        q.setParameter("branchCode", branchCode);
		        return q;
		    }

		    public static Query findUsersByIdCompanyEntries(Integer idCompany, int firstResult, int maxResults) {
		        return findUsersByIdCompany(idCompany).setFirstResult(firstResult).setMaxResults(maxResults);
		    }

}
