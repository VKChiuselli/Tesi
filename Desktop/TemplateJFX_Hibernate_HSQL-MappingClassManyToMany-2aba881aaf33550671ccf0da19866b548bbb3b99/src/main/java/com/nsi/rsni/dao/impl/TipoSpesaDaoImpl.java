package com.nsi.rsni.dao.impl;

import com.nsi.rsni.dao.TipoSpesaDaoInterface;
import com.nsi.rsni.pojo.TipoSpesa;
import com.nsi.rsni.pojo.pojoFX.TipoSpesaFx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by v.chiuselli on 05/12/2016.
 */
public class TipoSpesaDaoImpl extends BaseDaoServiceImpl implements TipoSpesaDaoInterface {
    @Override
    public void persist(TipoSpesa entity) throws Exception {
        getCurrentSession().persist(entity);
        return;
    }

    @Override
    public String save(TipoSpesa entity) throws Exception {
        return (String) getCurrentSession().save(entity);
    }

    @Override
    public void update(TipoSpesa entity) throws Exception {
        getCurrentSession().update(entity);
        return;
    }

    @Override
    public TipoSpesa findById(String s) throws Exception {
        if (getCurrentSession() == null) {
            openCurrentSession();
        }
        return getCurrentSession().get(TipoSpesa.class, s);
    }

    @Override
    public void delete(TipoSpesa entity) throws Exception {
        getCurrentSession().delete(entity);
        return;
    }

    @Override
    public List<TipoSpesa> findAll() throws Exception {

        List<TipoSpesa> list = (List<TipoSpesa>) getCurrentSession().createQuery("from TIPI_SPESE").list();
        return list;
    }

    @Override
    public String inserisciTipoSpesa(String descrizione, String importo, String iva) {

        String risposta;

        TipoSpesa tipoSpesa = new TipoSpesa();
        tipoSpesa.setDescrizione(descrizione);
        tipoSpesa.setImporto(importo);
        tipoSpesa.setIva(iva);

        String id_tipo_spesa = null;
        try {

            id_tipo_spesa = save(tipoSpesa);

        } catch (Exception e) {
            System.out.println("errore dato  dall ainserisci tipo sppesa: " + e.getMessage());
            e.printStackTrace();
        }

        return id_tipo_spesa;

    }


    public ObservableList<String> getListaTipoSpesaDescrizioniFx() {

        ObservableList<String> result = FXCollections.observableArrayList();
        List<TipoSpesa> listaResult = getCurrentSession().createQuery("from TipoSpesa").list();
// potevo anche prendere con la query direttamente TUTTE le stringhe di descrizione from TipoSpesa where u descrizione
        for (TipoSpesa tipoSpesa : listaResult) {
            result.add(tipoSpesa.getDescrizione());
        }


        return result;
    }

    @Override
    public TipoSpesa getListaByDescrizioneImpl(String descrizione) throws Exception {


        List<TipoSpesa> listaResult = getCurrentSession().createQuery("from TipoSpesa").list();

        TipoSpesa result = null;
        for (int i = 0; i < listaResult.size(); i++) {
            if (listaResult.get(i).getDescrizione().equals(descrizione)) {
               return result= listaResult.get(i);
            }


        }


        return result;

    }


    private ObservableList<TipoSpesaFx> getListaTipoSpesaFxFromNotaSpesa(List<TipoSpesa> list){

        ObservableList<TipoSpesaFx> listNotaSpesaFX = FXCollections.observableArrayList();

        for(int i=0; i< list.size(); i++){

            TipoSpesaFx tipoSpesaFx = new TipoSpesaFx();
            TipoSpesa tipoSpesa = list.get(i);
            tipoSpesaFx.set_descrizione(tipoSpesa.getDescrizione());
            tipoSpesaFx.set_importo(tipoSpesa.getImporto());
            tipoSpesaFx.set_iva(tipoSpesa.getIva());
            listNotaSpesaFX.add(tipoSpesaFx);

        }

        return listNotaSpesaFX;

    }



}
