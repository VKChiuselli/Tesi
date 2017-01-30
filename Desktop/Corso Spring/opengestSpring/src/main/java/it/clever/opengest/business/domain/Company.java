package it.clever.opengest.business.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@Table(name = "company")
public class Company {

    @PersistenceContext
    transient EntityManager entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String description;

    private Integer idCompany;

    @Column(name = "extended_desc")
    @Size(max = 255)
    private String extendedDesc;


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdCompany() {
        return this.idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }


    public static final EntityManager entityManager() {
        EntityManager em = new Company().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

    @SuppressWarnings("unchecked")
    public static List<Company> findByIdCompany(Integer idCompany) {
        if (idCompany == null) throw new IllegalArgumentException("The idCompany argument is required");
        Query q = entityManager().createQuery("SELECT c FROM Company c WHERE c.idCompany = :idCompany");
        q.setParameter("idCompany", idCompany);
        return q.getResultList();
    }


}
