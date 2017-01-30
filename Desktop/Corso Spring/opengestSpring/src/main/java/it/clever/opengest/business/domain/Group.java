package it.clever.opengest.business.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.transaction.annotation.Transactional;

@Entity
@RooJavaBean
@Table(name = "auth_groups")
public class Group {

    @PersistenceContext
    transient EntityManager entityManager;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "group_name")
    private String name;

    @ManyToMany()
    @JoinTable(name = "auth_group_authorities", joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "AUTHORITY", referencedColumnName = "ROLE_NAME"))
    private Set<Authority> authorities = new java.util.HashSet<Authority>();

    private String description;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return name;
    }

    @Transactional
    public void persist() {
        if (this.entityManager == null) {
            this.entityManager = entityManager();
        }
        this.entityManager.persist(this);
    }

    @Transactional
    public void remove() {
        if (this.entityManager == null) {
            this.entityManager = entityManager();
        }
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Group attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }

    @Transactional
    public void flush() {
        if (this.entityManager == null) {
            this.entityManager = entityManager();
        }
        this.entityManager.flush();
    }

    @Transactional
    public Group merge() {
        if (this.entityManager == null) {
            this.entityManager = entityManager();
        }
        Group merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

    public static long countGroups() {
        return ((Number) entityManager().createQuery("select count(o) from Group o").getSingleResult()).longValue();
    }

    public static final EntityManager entityManager() {
        EntityManager em = new Group().entityManager;
        if (em == null) {
            throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        }
        return em;
    }

    public static Group findGroup(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager().find(Group.class, id);
    }

    @SuppressWarnings("unchecked")
    public static List<Group> findGroupEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Group o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @SuppressWarnings("unchecked")
    public static List<Group> findAllGroups() {
        return entityManager().createQuery("select o from Group o").getResultList();
    }

    @SuppressWarnings("unchecked")
    public static List<Group> findGroupWithoutSuperAdminEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT group FROM Group group WHERE group NOT IN(SELECT DISTINCT g FROM Group g, IN (g.authorities) a WHERE a.roleName = 'ROLE_SUPERADMIN')").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @SuppressWarnings("unchecked")
    public static List<Group> findAllGroupsWithoutSuperAdmin() {
        return entityManager().createQuery("SELECT group FROM Group group WHERE group NOT IN(SELECT DISTINCT g FROM Group g, IN (g.authorities) a WHERE a.roleName = 'ROLE_SUPERADMIN')").getResultList();
    }

    @SuppressWarnings("unchecked")
    public static List<Group> findGroupsByName(String name) {
        return entityManager().createQuery("SELECT group FROM Group group WHERE group.name = :name").
                setParameter("name", name).getResultList();
    }
}
