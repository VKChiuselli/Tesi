// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.clever.opengest.business.domain;

import it.clever.opengest.business.domain.Customer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

privileged aspect Customer_Roo_Jpa_Entity {
    
    declare @type: Customer: @Entity;
    
    @Version
    @Column(name = "version")
    private Integer Customer.version;
    
    public Integer Customer.getVersion() {
        return this.version;
    }
    
    public void Customer.setVersion(Integer version) {
        this.version = version;
    }
    
}
