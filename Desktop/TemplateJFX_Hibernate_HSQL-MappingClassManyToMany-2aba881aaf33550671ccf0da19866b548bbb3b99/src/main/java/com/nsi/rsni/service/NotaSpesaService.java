package com.nsi.rsni.service;

import com.nsi.rsni.exception.BusinessException;

import com.nsi.rsni.dao.impl.DaoFactory;
import com.nsi.rsni.dao.impl.NotaSpesaDaoImpl;
import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.TipoSpesa;
import com.nsi.rsni.pojo.pojoFX.NotaSpesaFx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by acerioni on 02/12/2016.
 */
public class NotaSpesaService {

    private NotaSpesaDaoImpl notaSpesaDao;

    public NotaSpesaService(){

        notaSpesaDao = new DaoFactory().getDaoNotaSpesa();
    }

    public String inserisciNotaSpesa(String agente, String matricola, String ufficio, String partenza, String ritorno, String viaggio){

        String id = null;

        try {
            notaSpesaDao.beginTransaction();
            id = notaSpesaDao.inserisciNotaSpesa(agente, matricola, ufficio, partenza, ritorno, viaggio);
            notaSpesaDao.endTransaction();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return id;
    }






    public NotaSpesaFx getNotaSpesaFx(String id_nota_spesa)throws Exception{


        this.notaSpesaDao.beginTransaction();
        NotaSpesaFx notaSpesaFx=  notaSpesaDao.getNotaSpesaFx(id_nota_spesa);
        this.notaSpesaDao.endTransaction();
        return notaSpesaFx;
    }

    public ObservableList<NotaSpesaFx> getListNotaSpesaFx() throws BusinessException {
        this.notaSpesaDao.beginTransaction();
        ObservableList<NotaSpesaFx> list =notaSpesaDao.getListaNotaSpesaFX();
        this.notaSpesaDao.endTransaction();
        return list;
    }


    public void modificaNotaSpesa(String agente, String matricola, String ufficio, String partenza, String ritorno, String viaggio){



        try {
            notaSpesaDao.beginTransaction();
            notaSpesaDao.modificaNotaSpesaDao(agente, matricola, ufficio, partenza, ritorno, viaggio);
            notaSpesaDao.endTransaction();
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }


    public  NotaSpesa getById(String id){

        NotaSpesa notaSpesa
                = new NotaSpesa();
        try {
            this.notaSpesaDao.beginTransaction();
            notaSpesa=notaSpesaDao.findById(id);
            this.notaSpesaDao.endTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notaSpesa;


    }
}
