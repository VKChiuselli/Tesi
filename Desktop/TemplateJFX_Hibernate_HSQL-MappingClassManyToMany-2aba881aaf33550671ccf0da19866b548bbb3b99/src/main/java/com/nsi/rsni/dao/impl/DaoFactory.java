package com.nsi.rsni.dao.impl;

import com.nsi.rsni.pojo.TipoSpesa;

/**
 * Created by acerioni on 02/12/2016.
 */
public class DaoFactory {

    public NotaSpesaDaoImpl getDaoNotaSpesa() {
        return new NotaSpesaDaoImpl();
    }

    public TipoSpesaDaoImpl getDaoTipoSpesa() { return new TipoSpesaDaoImpl(); }

    public NotaSpesaTipoSpesaDaoImpl getDaoNotaSpesaTipoSpesa() { return new NotaSpesaTipoSpesaDaoImpl();}


}
