// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.clever.opengest.business.domain;

import it.clever.opengest.business.domain.Authority;
import it.clever.opengest.business.domain.Group;
import java.util.Set;

privileged aspect Group_Roo_JavaBean {
    
    public Set<Authority> Group.getAuthorities() {
        return this.authorities;
    }
    
    public void Group.setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
    
}