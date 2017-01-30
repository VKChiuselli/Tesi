package com.nsi.rsni.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NOTE_SPESE")
public class NotaSpesa extends Base implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_nota_spesa", unique = true)
    private String id;


    @Column(name = "agente", nullable = false, length = 45)
    private String agente;


    @Column(name = "matricola", nullable = false, length = 45)
    private String matricola;

    @Column(name = "ufficio", nullable = false, length = 45)
    private String ufficio;


    @Column(name = "viaggio", nullable = false, length = 100)
    private String viaggio;

    @Column(name = "partenza", nullable = false, length = 100)
    private String partenza;

    @Column(name = "ritorno", nullable = false, length = 100)
    private String ritorno;


   /* @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "NOTE_SPESE_TIPI_SPESE_OLD", joinColumns = @JoinColumn(name = "id_nota_spese",
            referencedColumnName = "id_nota_spesa"),
            inverseJoinColumns = @JoinColumn(name = "id_tipo_spesa", referencedColumnName = "id_tipo_spesa"))
    private List<TipoSpesa> tipoSpesaList = new ArrayList<TipoSpesa>();
*/
    @OneToMany(mappedBy = "notaSpesa")
    private Set<NotaSpesaTipoSpesa> tipiSpeseSet = new HashSet<NotaSpesaTipoSpesa>();

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getViaggio() {
        return viaggio;
    }

    public void setViaggio(String viaggio) {
        this.viaggio = viaggio;
    }

    //costruttore
    public NotaSpesa() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getUfficio() {
        return ufficio;
    }

    public void setUfficio(String ufficio) {
        this.ufficio = ufficio;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getRitorno() {
        return ritorno;
    }

    public void setRitorno(String ritorno) {
        this.ritorno = ritorno;
    }


    public Set<NotaSpesaTipoSpesa> getTipiSpeseSet() {
        return tipiSpeseSet;
    }

    public void setTipiSpeseSet(Set<NotaSpesaTipoSpesa> tipiSpeseSet) {
        this.tipiSpeseSet = tipiSpeseSet;
    }
}









