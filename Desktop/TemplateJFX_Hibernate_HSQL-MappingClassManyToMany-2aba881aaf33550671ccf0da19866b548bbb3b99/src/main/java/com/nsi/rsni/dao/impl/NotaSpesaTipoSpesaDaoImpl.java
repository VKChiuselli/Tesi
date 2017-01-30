package com.nsi.rsni.dao.impl;

import com.nsi.rsni.dao.NotaSpesaTipoSpesaInterface;
import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.NotaSpesaTipoSpesa;
import com.nsi.rsni.pojo.TipoSpesa;

import java.util.List;

/**
 * Created by acerioni on 13/12/2016.
 */
public class NotaSpesaTipoSpesaDaoImpl extends BaseDaoServiceImpl implements NotaSpesaTipoSpesaInterface{

    @Override
    public void persist(NotaSpesaTipoSpesa entity) throws Exception {

    }

    @Override
    public String save(NotaSpesaTipoSpesa entity) throws Exception {

        return (String) getCurrentSession().save(entity);
    }

    @Override
    public void update(NotaSpesaTipoSpesa entity) throws Exception {

    }

    @Override
    public NotaSpesaTipoSpesa findById(String s) throws Exception {
        return null;
    }

    @Override
    public void delete(NotaSpesaTipoSpesa entity) throws Exception {

    }

    @Override
    public List<NotaSpesaTipoSpesa> findAll() throws Exception {
        return null;
    }

    @Override
    public String inserisciNotaSpesaTipoSpesa(NotaSpesa notaSpesa, TipoSpesa tipoSpesa, String importo, String iva) {

        String id = null;
        NotaSpesaTipoSpesa notaSpesaTipoSpesa = new NotaSpesaTipoSpesa();
        notaSpesaTipoSpesa.setNotaSpesa(notaSpesa);
        notaSpesaTipoSpesa.setTipoSpesa(tipoSpesa);
        notaSpesaTipoSpesa.setImporto(importo);
        notaSpesaTipoSpesa.setIva(iva);
        try {
            id =save(notaSpesaTipoSpesa);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}
