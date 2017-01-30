package com.nsi.rsni.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import java.security.Timestamp;

/**
 * Created by acerioni on 01/12/2016.
 */

public abstract class Base {

        @Version
        @Column(name = "last_update")
        private Timestamp lastUpdate;


        public Timestamp getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(Timestamp lastUpdate) {
            this.lastUpdate = lastUpdate;
        }


}
