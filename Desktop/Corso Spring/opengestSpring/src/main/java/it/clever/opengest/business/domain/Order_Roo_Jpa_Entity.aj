// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.clever.opengest.business.domain;

import it.clever.opengest.business.domain.Order;
import javax.persistence.Column;
import javax.persistence.Version;

privileged aspect Order_Roo_Jpa_Entity {
    
    @Version
    @Column(name = "version")
    private Integer Order.version;
    
    public Integer Order.getVersion() {
        return this.version;
    }
    
    public void Order.setVersion(Integer version) {
        this.version = version;
    }
    
}
