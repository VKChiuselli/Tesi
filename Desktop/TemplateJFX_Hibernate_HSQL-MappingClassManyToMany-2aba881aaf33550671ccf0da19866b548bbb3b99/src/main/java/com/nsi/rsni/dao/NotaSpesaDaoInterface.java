package com.nsi.rsni.dao;

import com.nsi.rsni.exception.BusinessException;
import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.pojoFX.NotaSpesaFx;
import javafx.collections.ObservableList;

/**
 * Created by acerioni on 01/12/2016.
 */
public interface NotaSpesaDaoInterface extends BaseDaoInterface<NotaSpesa,String>{

    public String inserisciNotaSpesa(String agente, String matricola, String ufficio, String partenza, String ritorno, String viaggio);

    public void modificaNotaSpesaDao(String agente, String matricola, String ufficio, String partenza, String ritorno, String viaggio);

    public ObservableList<NotaSpesaFx> getListaNotaSpesaFX();

    public NotaSpesaFx getNotaSpesaFx(String id) throws BusinessException;

   // public ObservableList<String> getListaTipoSpesaDescrizioniFx();



}
