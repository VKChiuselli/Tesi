package com.nsi.rsni.controller;

import com.nsi.rsni.pojo.NotaSpesa;
import com.nsi.rsni.service.NotaSpesaService;
import com.nsi.rsni.pojo.pojoFX.NotaSpesaFx;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by v.chiuselli on 02/12/2016.
 */

public class ListaNotaSpesaController {


    @FXML
    public AnchorPane anchorPane;
    @FXML
    public TableView tableView;
    @FXML
    public TableColumn agenteColumn;
    @FXML
    public TableColumn<NotaSpesa, String> matricolaColumn;
    @FXML
    public TableColumn ufficioColumn;
    @FXML
    public TableColumn viaggioColumn;
    @FXML
    public TableColumn prtenzaColumn;
    @FXML
    public TableColumn ritornoColumn;
    @FXML
    public TableColumn tipiSpeseColumn;
    @FXML
    public DettaglioNotaSpesaController DettaglioNotaSpesa;


    ObservableList<NotaSpesaFx> listaNotaSpese;
    NotaSpesaFx notaSpesa = new NotaSpesaFx();

    @FXML
    public void initialize() throws Exception {

        NotaSpesaService notaSpesaService = new NotaSpesaService();


        listaNotaSpese = notaSpesaService.getListNotaSpesaFx();


        matricolaColumn.setCellValueFactory(new PropertyValueFactory<>("_matricola"));
        agenteColumn.setCellValueFactory(new PropertyValueFactory<NotaSpesa, String>("_agente"));
        ufficioColumn.setCellValueFactory(new PropertyValueFactory<NotaSpesa, String>("_ufficio"));
        prtenzaColumn.setCellValueFactory(new PropertyValueFactory<NotaSpesa, String>("_partenza"));
        ritornoColumn.setCellValueFactory(new PropertyValueFactory<NotaSpesa, String>("_ritorno"));
        viaggioColumn.setCellValueFactory(new PropertyValueFactory<NotaSpesa, String>("_viaggio"));

        tableView.setItems(listaNotaSpese);


        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            notaSpesa = (NotaSpesaFx) newValue;

            try {


                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/DettaglioNotaSpesa.fxml"));
                AnchorPane frame = fxmlLoader.load();
                DettaglioNotaSpesaController c =  fxmlLoader.getController();

                c.setParametri(notaSpesa);
                //       System.out.println(notaSpesaSelezionato.getNumero() + " " + notaSpesaSelezionato.getPartenza());


                Stage window2 = new Stage();
                Scene ls = new Scene(frame);


                window2.setScene(ls);
                window2.show();







            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }


    @FXML
    void  creaNuovaNotaSpesa(ActionEvent event){

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/DettaglioNotaSpesa.fxml"));
            AnchorPane frame = fxmlLoader.load();
            //DettaglioNotaSpesa.apriDettagio(listaNotaSpese.get(0));

            Stage window2 = new Stage();
            Scene ls = new Scene(frame);

            window2.setScene(ls);
            window2.show();

        } catch (IOException e) {
            e.printStackTrace();
        }






    }

}








