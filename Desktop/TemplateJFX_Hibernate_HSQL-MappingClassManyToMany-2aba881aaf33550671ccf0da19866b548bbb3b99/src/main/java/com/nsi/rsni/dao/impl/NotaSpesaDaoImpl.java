package com.nsi.rsni.dao.impl;

import com.nsi.rsni.dao.NotaSpesaDaoInterface;

import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.pojo.TipoSpesa;
import com.nsi.rsni.pojo.pojoFX.NotaSpesaFx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.Collection;
import java.util.List;

/**
 * Created by acerioni on 01/12/2016.
 */
public class NotaSpesaDaoImpl extends BaseDaoServiceImpl implements NotaSpesaDaoInterface {


    @Override
    public void persist(NotaSpesa entity) throws Exception {

        getCurrentSession().persist(entity);
        return;
    }

    @Override
    public String save(NotaSpesa entity) throws Exception {

        return (String) getCurrentSession().save(entity);
    }

    @Override
    public void update(NotaSpesa entity) throws Exception {

        getCurrentSession().update(entity);
        return;
    }



    @Override
    public NotaSpesa findById(String s) throws Exception {

        if (getCurrentSession() == null) {
            openCurrentSession();
        }
        return getCurrentSession().get(NotaSpesa.class, s);
    }

    @Override
    public void delete(NotaSpesa entity) throws Exception {

        getCurrentSession().delete(entity);
        return;
    }

    @Override
    public List<NotaSpesa> findAll() throws Exception {

        List<NotaSpesa> list = (List<NotaSpesa>) getCurrentSession().createQuery("from NotaSpesa").list();
        return list;
    }

    @Override
    public String inserisciNotaSpesa(String agente, String matricola, String ufficio, String partenza, String ritorno, String viaggio) {
        NotaSpesa notaSpesa = new NotaSpesa();
        notaSpesa.setMatricola(matricola);
        notaSpesa.setUfficio(ufficio);
        notaSpesa.setPartenza(partenza);
        notaSpesa.setRitorno(ritorno);
        notaSpesa.setAgente(agente);
        notaSpesa.setViaggio(viaggio);

        String id_nota_spesa = null;
        try {

            id_nota_spesa = save(notaSpesa);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id_nota_spesa;
    }




    private ObservableList<NotaSpesaFx> getListaNotaSpesaFxFromNotaSpesa(List<NotaSpesa> list) {

        ObservableList<NotaSpesaFx> listNotaSpesaFX = FXCollections.observableArrayList();

        for (int i = 0; i < list.size(); i++) {

            NotaSpesaFx notaSpesaFx = new NotaSpesaFx();
            NotaSpesa notaSpesa = list.get(i);
            notaSpesaFx.set_matricola(notaSpesa.getMatricola());
            notaSpesaFx.set_viaggio(notaSpesa.getViaggio());
            notaSpesaFx.set_agente(notaSpesa.getAgente());
            notaSpesaFx.set_partenza(notaSpesa.getPartenza());
            notaSpesaFx.set_ritorno(notaSpesa.getRitorno());
            notaSpesaFx.set_viaggio(notaSpesa.getViaggio());
            notaSpesaFx.set_ufficio(notaSpesa.getUfficio());
            listNotaSpesaFX.add(notaSpesaFx);

        }

        return listNotaSpesaFX;

    }


    @Override
    public ObservableList<NotaSpesaFx> getListaNotaSpesaFX() {

        ObservableList<NotaSpesaFx> listNotaSpesaFX = FXCollections.observableArrayList();

        try {
            List<NotaSpesa> listNotaSpesa = findAll();
            listNotaSpesaFX = getListaNotaSpesaFxFromNotaSpesa(listNotaSpesa);
        } catch (Exception e) {
            System.out.println("Errore nella findAll(): " + e.getMessage());
        }


        return listNotaSpesaFX;
    }

    @Override
    public NotaSpesaFx getNotaSpesaFx(String id) {

        NotaSpesa notaSpesa = null;
        NotaSpesaFx notaSpesaFx = new NotaSpesaFx();

        try {
            notaSpesa = findById(id);
            if (notaSpesa != null) {
                notaSpesaFx.set_matricola(notaSpesa.getMatricola());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeCurrentSession();

        return notaSpesaFx;
    }

    public void modificaNotaSpesaDao(String agente, String matricola, String ufficio, String partenza, String ritorno, String viaggio) {
        NotaSpesa notaSpesa = new NotaSpesa();
        notaSpesa.setMatricola(matricola);
        notaSpesa.setUfficio(ufficio);
        notaSpesa.setPartenza(partenza);
        notaSpesa.setRitorno(ritorno);
        notaSpesa.setAgente(agente);
        notaSpesa.setViaggio(viaggio);
        String id_nota_spesa = null;
        try {

         update(notaSpesa);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
