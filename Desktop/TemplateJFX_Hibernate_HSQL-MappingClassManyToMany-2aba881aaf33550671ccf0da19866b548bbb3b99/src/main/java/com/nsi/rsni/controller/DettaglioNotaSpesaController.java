


package com.nsi.rsni.controller;


import java.io.IOException;

import com.nsi.rsni.dao.impl.TipoSpesaDaoImpl;
import com.nsi.rsni.exception.BusinessException;
import com.nsi.rsni.pojo.TipoSpesa;
import com.nsi.rsni.pojo.pojoFX.NotaSpesaFx;
import com.nsi.rsni.service.NotaSpesaService;
import com.nsi.rsni.service.TipoSpesaService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DettaglioNotaSpesaController {

    @FXML
    private AnchorPane mixPane;

    @FXML
    private Button buttonSalva;

    @FXML
    private TextField agenteField;

    @FXML
    private TextField ufficioField;

    @FXML
    private TextField partenzaField;

    @FXML
    private TextField matricolaField;

    @FXML
    private TextField viaggioField;

    @FXML
    private TextField ritornoField;

    @FXML
    private TextField idField;

    @FXML
    private Label error1;

    @FXML
    private Label error2;

    @FXML
    private Label error3;

    @FXML
    private Label error4;

    @FXML
    private Label error5;

    @FXML
    private Label error6;

    @FXML
    private Label error8;

    @FXML
    private Label error10;

    @FXML
    private Label error11;

    @FXML
    private Label error12;

    @FXML
    private Label error13;

    @FXML
    private Label error14;

    @FXML
    private Label error15;

    @FXML
    private Label error16;

    @FXML
    private Label error17;

    @FXML
    private Label error20;

    @FXML
    private Label error21;

    @FXML
    private Label error22;

    @FXML
    private TableView<TipoSpesa> tabelMix;

    @FXML
    private TableColumn<TipoSpesa, String> idColumn;

    @FXML
    private TableColumn<TipoSpesa, String> descrizioneColumn;

    @FXML
    private TableColumn<TipoSpesa, String> importoColumn;

    @FXML
    private TableColumn<TipoSpesa, String> ivaCollumn;

    @FXML
    private Button inserisciNuovoTipoSpesa;

    @FXML
    ComboBox<String> TipiSpesecomboBoxMix;

    @FXML
    private Button inserisciTS;

    //spostato tutto da initialite a sopra....

    ObservableList<TipoSpesa> tipoSpesaList = FXCollections.observableArrayList();

    NotaSpesaService notaSpesaService = new NotaSpesaService();
    private TipoSpesaDaoImpl dao = new TipoSpesaDaoImpl();
    TipoSpesaService tipoSpesaService = new TipoSpesaService();


    private boolean token = false;


    @FXML
    public void initialize() throws Exception {


        TipiSpesecomboBoxMix.setItems(tipoSpesaService.getListTipoSpesaDescrizioniFx());


    }


    //  public void apriDettagio(NotaSpesaFx notaSpesaFxPrm){

    //    notaSpesaFx = notaSpesaFxPrm;
    //     setNotaSpesa();
    //  }


    public void setParametri(NotaSpesaFx notaSpesa1) {

        System.out.println("setto i parametri PID: " + notaSpesa1.getPartenza() + notaSpesa1.getAgente());


        matricolaField.setText(notaSpesa1.get_matricola());
        agenteField.setText(notaSpesa1.get_agente());
        partenzaField.setText(notaSpesa1.get_partenza());
        viaggioField.setText(notaSpesa1.get_viaggio());
        ufficioField.setText(notaSpesa1.get_ufficio());
        ritornoField.setText(notaSpesa1.get_ritorno());
        //     tabelMix.setItems( notaSpesa1.get_lista_tipi_spese );
        tabelMix.setItems(tipoSpesaList);
        token = true;
    }


    @FXML
    void aggiungiTipoSpesa(ActionEvent event) throws Exception {
        TipoSpesaService tipoSpesaService = new TipoSpesaService();   //getbydrescerizione mi ritorna UN SOLO TIPO SPESA di quello selezionato

        TipoSpesa tipoSpesa = tipoSpesaService.getByDescrizione(TipiSpesecomboBoxMix.getValue());  //così permetto che multipli dello stesso tipo spesa si può inserire -vc


        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descrizioneColumn.setCellValueFactory(new PropertyValueFactory<>("descrizione"));
        importoColumn.setCellValueFactory(new PropertyValueFactory<>("importo"));
        ivaCollumn.setCellValueFactory(new PropertyValueFactory<>("iva"));


        tipoSpesaList.add(tipoSpesa);
        tabelMix.setItems(tipoSpesaList);


    }


/*
    private TipoSpesaFx convertTipoSpesaToTipoSpesaFx(TipoSpesa tipoSpesa) {
        TipoSpesaFx tsf = new TipoSpesaFx();


        tsf.set_descrizione(tipoSpesa.getDescrizione());
        tsf.set_importo(tipoSpesa.getImporto());
        tsf.set_iva(tipoSpesa.getIva());

        return tsf;
    }*/


    @FXML
    void inserisciNuovoTipoSpesa(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/DettaglioTipoSpesa.fxml"));
            AnchorPane frame = fxmlLoader.load();

            Stage window2 = new Stage();
            Scene ls = new Scene(frame);

            window2.setScene(ls);
            window2.show();

            window2.setOnHiding(new EventHandler<WindowEvent>() {

                @Override
                public void handle(WindowEvent event) {
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("inserisci TS (tipo spesa) è stato chiuso");
                            try {
                                TipiSpesecomboBoxMix.setItems(tipoSpesaService.getListTipoSpesaDescrizioniFx());
                            } catch (BusinessException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void salvaTutto(ActionEvent event) throws Exception {


        if (token) {

            notaSpesaService.inserisciNotaSpesa(agenteField.getText(), matricolaField.getText(), ufficioField.getText(),
                    partenzaField.getText(), ritornoField.getText(), viaggioField.getText());

        } else {
            notaSpesaService.modificaNotaSpesa(agenteField.getText(), matricolaField.getText(), ufficioField.getText(),
                    partenzaField.getText(), ritornoField.getText(), viaggioField.getText());

        }


        //agenteField.clear();
        //matricolaField.clear();
        //ufficioField.clear();
        //viaggioField.clear();
        //partenzaField.clear();
        //ritornoField.clear();
        //Platform.exit();

    }


}
