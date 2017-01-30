package com.nsi.rsni.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by acerioni on 13/12/2016.
 */
@Entity
@Table(name = "NOTE_SPESE_TIPI_SPESE")

public class NotaSpesaTipoSpesa implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_nota_spesa_tipo_spesa", unique = true)
    private String id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nota_spesa")
    private NotaSpesa notaSpesa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_spesa")
    private TipoSpesa tipoSpesa;

    @Column(name = "importo")
    private String importo;
    @Column(name = "iva")
    private String iva;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NotaSpesa getNotaSpesa() {
        return notaSpesa;
    }

    public void setNotaSpesa(NotaSpesa notaSpesa) {
        this.notaSpesa = notaSpesa;
    }

    public TipoSpesa getTipoSpesa() {
        return tipoSpesa;
    }

    public void setTipoSpesa(TipoSpesa tipoSpesa) {
        this.tipoSpesa = tipoSpesa;
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
}
