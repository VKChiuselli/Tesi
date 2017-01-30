package com.nsi.rsni.service;

import com.nsi.rsni.dao.impl.DaoFactory;
import com.nsi.rsni.dao.impl.TipoSpesaDaoImpl;
import com.nsi.rsni.exception.BusinessException;
import com.nsi.rsni.pojo.TipoSpesa;
import com.nsi.rsni.pojo.pojoFX.TipoSpesaFx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by v.chiuselli on 05/12/2016.
 */
public class TipoSpesaService {


    private TipoSpesaDaoImpl tipoSpesaDao;


    public TipoSpesaService() {

        tipoSpesaDao = new DaoFactory().getDaoTipoSpesa();
    }


    public String insertTipoSpesa(String descrizione, String iva, String importo)  {
        String id_tipo_spesa = null;
        try {
            this.tipoSpesaDao.beginTransaction();
             id_tipo_spesa = tipoSpesaDao.inserisciTipoSpesa(descrizione, iva, importo);
            this.tipoSpesaDao.endTransaction();

        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return id_tipo_spesa;
    }





    public ObservableList<String> getListTipoSpesaDescrizioniFx() throws BusinessException {
        this.tipoSpesaDao.beginTransaction();
        ObservableList<String> list = tipoSpesaDao.getListaTipoSpesaDescrizioniFx();
        this.tipoSpesaDao.endTransaction();
        return list;


    }

    public TipoSpesa getById(String id){

        TipoSpesa tipoSpesa = new TipoSpesa();
        try {
            this.tipoSpesaDao.beginTransaction();
            tipoSpesa=tipoSpesaDao.findById(id);
            this.tipoSpesaDao.endTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoSpesa;


    }
    public TipoSpesa getByDescrizione(String descrizione) throws Exception {
        this.tipoSpesaDao.beginTransaction();
        TipoSpesa result= tipoSpesaDao.getListaByDescrizioneImpl(descrizione);
        this.tipoSpesaDao.endTransaction();
        return result;
    }
}
