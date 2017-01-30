package com.nsi.rsni.pojo.pojoFX;

import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.TipoSpesa;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;


import java.util.List;

/**
 * Created by acerioni on 02/12/2016.
 */
public class NotaSpesaFx extends NotaSpesa {



    public NotaSpesaFx() {
        super();
    }

    private StringProperty _matricola;
    private StringProperty _ufficio;
    private StringProperty _agente;
    private StringProperty _partenza;
    private StringProperty _ritorno;
    private StringProperty _viaggio;
    private ListProperty<TipoSpesa> _lista_tipi_spese;
    //get

//HO FATTO DEI CAST UN PO STRANI (STRANI== PERICOLOSI) ... se qualcosa non va, meglio togliere questa sezione o rifarla
    public List<TipoSpesa> get_lista_tipi_spese() {

        return _lista_tipi_spese.get();
    }



    public ListProperty _lista_tipi_speseProperty() {
        return _lista_tipi_spese;
    }




//matricola
    public String get_matricola() {

        return _matricola().get();
    }

    public StringProperty _matricola() {
        if (this._matricola == null) {
            String matricolaBase = getMatricola();
            this._matricola = new SimpleStringProperty(this, "_matricola", matricolaBase);
        }
        return this._matricola;
    }

    public StringProperty _matricolaProperty() {
        return _matricola;
    }

    public void set_matricola(String _matricola) {
        this._matricola().set(_matricola);
    }

    //_agente
    public String get_agente() {

        return _agente().get();
    }

    public StringProperty _agente() {
        if (this._agente == null) {
            String _agenteBase = getAgente();
            this._agente = new SimpleStringProperty(this, "_agente", _agenteBase);
        }
        return this._agente;
    }

    public StringProperty _agenteProperty() {
        return _agente;
    }

    public void set_agente(String _agente) {
        this._agente().set(_agente);
    }



    //partenza



    public String get_partenza() {

        return _partenza().get();
    }

    public StringProperty _partenza() {
        if (this._partenza == null) {
            String _partenzaBase = getPartenza();
            this._partenza = new SimpleStringProperty(this, "_partenza", _partenzaBase);
        }
        return this._partenza;
    }

    public StringProperty _partenzaProperty() {
        return _partenza;
    }

    public void set_partenza(String _partenza) {
        this._partenza().set(_partenza);
    }


// ritorno



    public String get_ritorno() {

        return _ritorno().get();
    }

    public StringProperty _ritorno() {
        if (this._ritorno == null) {
            String _ritornoBase = getRitorno();
            this._ritorno = new SimpleStringProperty(this, "_ritorno", _ritornoBase);
        }
        return this._ritorno;
    }

    public StringProperty _ritornoProperty() {
        return _ritorno;
    }

    public void set_ritorno(String _ritorno) {
        this._ritorno().set(_ritorno);
    }


// viaggio


    public String get_viaggio() {

        return _viaggio().get();
    }

    public StringProperty _viaggio() {
        if (this._viaggio == null) {

            this._viaggio = new SimpleStringProperty(this, "_viaggio", getViaggio());
        }
        return this._viaggio;
    }

    public StringProperty _viaggioProperty() {
        return _viaggio;
    }

    public void set_viaggio(String _viaggio) {
        this._viaggio().set(_viaggio);
    }

//          _ufficio


    public String get_ufficio() {

        return _ufficio().get();
    }

    public StringProperty _ufficio() {
        if (this._ufficio == null) {

            this._ufficio = new SimpleStringProperty(this, "_ufficio", getUfficio());
        }
        return this._ufficio;
    }

    public StringProperty _ufficioProperty() {
        return _ufficio;
    }

    public void set_ufficio(String _ufficio) {
        this._ufficio().set(_ufficio);
    }




}