package it.clever.opengest.business.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import org.springframework.roo.addon.javabean.RooJavaBean;

@Entity
@RooJavaBean
@Table(name = "auth_authorities")
public class Authority {
	public static final String ROLE_SUPERADMIN = "ROLE_SUPERADMIN";
	public static final String ROLE_BRANCH_CHOOSER = "ROLE_BRANCH_CHOOSER";
	
	@PersistenceContext
    transient EntityManager entityManager;

    @Column(name = "role_desc")
    private String roleDesc;
    
    @Id
    @Column(name = "role_name")
    private String roleName;
    
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String id) {
        this.roleName = id;
    }
    
    public String getRoleDesc() {
        return this.roleDesc;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    
    public String toString() {
        return roleDesc;
    }
    
    @SuppressWarnings("unchecked")
    public static List<Authority> findAllAuthoritys() {
        return entityManager().createQuery("select o from Authority o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Authority> findAllAuthoritysWithoutSuperAdmin() {
        return entityManager().createQuery("select o from Authority o where o.roleName <> 'ROLE_SUPERADMIN'").getResultList();
    }
    
    public static final EntityManager entityManager() {
        EntityManager em = new Authority().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
}
