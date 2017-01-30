package com.nsi.rsni.pojo.pojoFX;
import com.nsi.rsni.pojo.TipoSpesa;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by v.chiuselli on 05/12/2016.
 */
public class TipoSpesaFx extends TipoSpesa {

    private StringProperty _descrizione;
    private StringProperty _iva;
    private StringProperty _importo;

    //descrizione


    public String get_descrizione() {

        return _descrizione().get();
    }

    public StringProperty _descrizione() {
        if (this._descrizione == null) {
            String _descrizioneBase = getDescrizione();
            this._descrizione = new SimpleStringProperty(this, "_descrizione", _descrizioneBase);
        }
        return this._descrizione;
    }

    public StringProperty _descrizioneProperty() {
        return _descrizione;
    }

    public void set_descrizione(String _descrizione) {
        this._descrizione.set(_descrizione);
    }

///iva

    public String get_iva() {

        return _iva().get();
    }

    public StringProperty _iva() {
        if (this._iva == null) {
            String _ivaBase = getIva();
            this._iva = new SimpleStringProperty(this, "_iva", _ivaBase);
        }
        return this._iva;
    }

    public StringProperty _ivaProperty() {
        return _descrizione;
    }

    public void set_iva(String _iva) {
        this._iva.set(_iva);
    }


    ///_importo

    public String get_importo() {

        return _importo().get();
    }

    public StringProperty _importo() {
        if (this._importo == null) {
            String _importoBase = getImporto();
            this._importo = new SimpleStringProperty(this, "_importo", _importoBase);
        }
        return this._importo;
    }

    public StringProperty _importoProperty() {
        return _importo;
    }

    public void set_importo(String _importo) {
        this._importo.set(_importo);
    }





}
