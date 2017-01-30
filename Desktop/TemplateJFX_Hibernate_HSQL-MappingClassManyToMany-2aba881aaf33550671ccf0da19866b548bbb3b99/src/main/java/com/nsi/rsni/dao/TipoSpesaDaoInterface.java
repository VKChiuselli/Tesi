package com.nsi.rsni.dao;


import com.nsi.rsni.pojo.TipoSpesa;
import javafx.collections.ObservableList;

/**
 * Created by v.chiuselli on 05/12/2016.
 */
public interface TipoSpesaDaoInterface extends  BaseDaoInterface<TipoSpesa, String> {

    public String inserisciTipoSpesa(String descrizione, String importo, String iva)throws Exception;
    public ObservableList<String> getListaTipoSpesaDescrizioniFx();
    public TipoSpesa getListaByDescrizioneImpl(String descrizione)throws Exception;

}
