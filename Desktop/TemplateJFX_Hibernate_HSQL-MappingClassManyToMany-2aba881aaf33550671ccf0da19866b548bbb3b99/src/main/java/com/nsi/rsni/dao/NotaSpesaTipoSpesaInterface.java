package com.nsi.rsni.dao;

import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.NotaSpesaTipoSpesa;
import com.nsi.rsni.pojo.TipoSpesa;

/**
 * Created by acerioni on 13/12/2016.
 */
public interface NotaSpesaTipoSpesaInterface extends BaseDaoInterface<NotaSpesaTipoSpesa,String>{

    public String inserisciNotaSpesaTipoSpesa(NotaSpesa notaSpesa, TipoSpesa tipoSpesa, String importo, String iva);
}
