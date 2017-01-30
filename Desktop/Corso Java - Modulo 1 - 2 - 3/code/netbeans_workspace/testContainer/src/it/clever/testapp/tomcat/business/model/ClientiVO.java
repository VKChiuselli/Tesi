/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.testapp.tomcat.business.model;

/**
 *
 * @author v.chiuselli
 */
public class ClientiVO {

    private long Id_cliente;
    private String codice;
    private String rag_soc;
    private String piva;
    private int version;

    
    public ClientiVO(){
    
}
    
    public long getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(long Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getRag_soc() {
        return rag_soc;
    }

    public void setRag_soc(String rag_soc) {
        this.rag_soc = rag_soc;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    
    
    
    
    
    
}