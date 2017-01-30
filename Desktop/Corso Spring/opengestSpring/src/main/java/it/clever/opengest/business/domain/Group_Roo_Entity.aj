package it.clever.opengest.business.domain;

import javax.persistence.Column;
import javax.persistence.Version;

privileged aspect Group_Roo_Entity {
    
    @Version
    @Column(name = "version")
    private Integer Group.version;
    
    public Integer Group.getVersion() {
        return this.version;
    }
    
    public void Group.setVersion(Integer version) {
        this.version = version;
    }
    
}
