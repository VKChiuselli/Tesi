// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.clever.opengest.business.domain;

import it.clever.opengest.business.domain.Company;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

privileged aspect Company_Roo_Jpa_Entity {
    
    declare @type: Company: @Entity;
    
    @Version
    @Column(name = "version")
    private Integer Company.version;
    
    public Integer Company.getVersion() {
        return this.version;
    }
    
    public void Company.setVersion(Integer version) {
        this.version = version;
    }
    
}