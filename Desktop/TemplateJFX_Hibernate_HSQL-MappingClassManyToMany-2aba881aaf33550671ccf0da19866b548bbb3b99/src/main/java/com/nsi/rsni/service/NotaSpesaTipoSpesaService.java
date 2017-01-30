package com.nsi.rsni.service;

import com.nsi.rsni.dao.impl.DaoFactory;
import com.nsi.rsni.dao.impl.NotaSpesaTipoSpesaDaoImpl;
import com.nsi.rsni.exception.BusinessException;
import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.TipoSpesa;

/**
 * Created by acerioni on 13/12/2016.
 */
public class NotaSpesaTipoSpesaService {

    private NotaSpesaTipoSpesaDaoImpl notaSpesaTipoSpesaDao;

    public NotaSpesaTipoSpesaService(){

        notaSpesaTipoSpesaDao = new DaoFactory().getDaoNotaSpesaTipoSpesa();
    }

    public String inserisciNotaSpesaTipoSpesa(NotaSpesa notaSpesa, TipoSpesa tipoSpesa, String importo, String iva){

        String id = null;


        try {
            notaSpesaTipoSpesaDao.beginTransaction();
            id = notaSpesaTipoSpesaDao.inserisciNotaSpesaTipoSpesa(notaSpesa,tipoSpesa,importo,iva);
            notaSpesaTipoSpesaDao.endTransaction();
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        return id;
    }
}
