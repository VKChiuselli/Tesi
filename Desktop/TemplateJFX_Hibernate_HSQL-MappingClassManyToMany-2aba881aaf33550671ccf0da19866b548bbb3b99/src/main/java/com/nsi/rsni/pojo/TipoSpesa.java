package com.nsi.rsni.pojo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by v.chiuselli on 05/12/2016.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "TIPI_SPESE")
public class TipoSpesa implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_tipo_spesa", unique = true)
    private String id;



    @Column(name = "descrizione", nullable = false, length = 45)
    private String descrizione;
    @Column(name = "importo", nullable = false, length = 45)
    private String importo;
    @Column(name = "iva", nullable = false, length = 45)
    private String iva;


    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImporto() {
        return importo;
    }

    public void setImporto(String importo) {
        this.importo = importo;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}






