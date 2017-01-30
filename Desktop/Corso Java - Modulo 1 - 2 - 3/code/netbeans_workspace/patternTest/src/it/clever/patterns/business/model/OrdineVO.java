/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.clever.patterns.business.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author v.chiuselli
 */
public class OrdineVO extends BaseVO implements Serializable {

    /**
     * @return the id_cliente
     */
    public CustomerVO getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(CustomerVO id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_prodotto
     */
    public ProdottoVO getId_prodotto() {
        return id_prodotto;
    }

    /**
     * @param id_prodotto the id_prodotto to set
     */
    public void setId_prodotto(ProdottoVO id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    @Override
    public String toString() {
        return "OrdineVO{"  + ", id_cliente=" + getId_cliente() + ", id_prodotto=" + getId_prodotto() + ", ammontare=" + ammontare + ", data_ordine=" + data_ordine + ", quantita=" + quantita + ", version=" + version + '}';
    }

    private CustomerVO id_cliente;
    private ProdottoVO id_prodotto;
    private int ammontare;
    private Date data_ordine;

    private int quantita;
    private int version;



    /**
     * @return the ammontare
     */
    public int getAmmontare() {
        return ammontare;
    }

    /**
     * @param ammontare the ammontare to set
     */
    public void setAmmontare(int ammontare) {
        this.ammontare = ammontare;
    }

    /**
     * @return the data_ordine
     */
    public Date getData_ordine() {
        return data_ordine;
    }

    /**
     * @param data_ordine the data_ordine to set
     */
    public void setData_ordine(Date data_ordine) {
        this.data_ordine = data_ordine;
    }

    /**
     * @return the quantita
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * @param quantita the quantita to set
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }

    public void setId_cliente(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_prodotto(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
