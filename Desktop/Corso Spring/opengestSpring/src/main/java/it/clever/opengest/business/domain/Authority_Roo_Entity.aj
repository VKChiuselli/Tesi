package it.clever.opengest.business.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Version;

import org.springframework.transaction.annotation.Transactional;

privileged aspect Authority_Roo_Entity {
    
    @Version
    @Column(name = "version")
    private Integer Authority.version;
    
    public Integer Authority.getVersion() {
        return this.version;
    }
    
    public void Authority.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Authority.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Authority.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Authority attached = this.entityManager.find(this.getClass(), this.roleName);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Authority.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Authority Authority.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Authority merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static long Authority.countAuthoritys() {
        return ((Number) entityManager().createQuery("select count(o) from Authority o").getSingleResult()).longValue();
    }
    
    public static Authority Authority.findAuthority(String id) {
        if (id == null || 0 == id.length()) return null;
        return entityManager().find(Authority.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Authority> Authority.findAuthorityEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Authority o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
