package com.nsi.rsni.controller;

import com.nsi.rsni.service.TipoSpesaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by v.chiuselli on 05/12/2016.
 */
public class DettaglioTipoSpesaController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane insTS;

    @FXML
    private Button salvaTS;

    @FXML
    private TextField ivaField;

    @FXML
    private TextField importoField;

    @FXML
    private TextField descField;

    @FXML
    private Label error1;

    @FXML
    private Label error2;

    @FXML
    private Label error3;


    private TipoSpesaService tipoSpesaService = new TipoSpesaService();

    public void SalvaNuovoTS(ActionEvent actionEvent) throws Exception {

        if (controllaCampi()) {

            tipoSpesaService.insertTipoSpesa(descField.getText(), importoField.getText(), ivaField.getText());


            error1.setText("");
            descField.clear();
            importoField.clear();
            ivaField.clear();

            //sto provando a refreschare la combo box della crud
             FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/DettaglioNotaSpesa.fxml"));
            AnchorPane frame = fxmlLoader.load();
            DettaglioNotaSpesaController c = fxmlLoader.getController();
        /*    TipoSpesa tipoSpesa = new TipoSpesa();
            tipoSpesa.setDescrizione(descField.getText());
            tipoSpesa.setImporto(importoField.getText());
            tipoSpesa.setDescrizione(ivaField.getText());
            c.tipoSpesaList.add(tipoSpesa);
       */

             c.TipiSpesecomboBoxMix.setItems(this.tipoSpesaService.getListTipoSpesaDescrizioniFx());

            Alert informaz = new Alert(Alert.AlertType.INFORMATION);
            informaz.setTitle("Inserimento Spesa");
            informaz.setHeaderText(null);
            informaz.setContentText("Inserimento avvenuto con successo!");

            informaz.showAndWait();
        }

         /*  URL fxmlpath = inserisciNuovoTSController.class.getResource("/fxml/mixTipiNoteController.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlpath);
            mixTipiNoteController controller = loader.getController();

            controller.TipiSpesecomboBoxMix.setItems(controller.dao.mostraDescrizioni());*/

    }

    public boolean controllaCampi() {
        boolean controllo = false;

        if (descField.getText().isEmpty()) {
            error1.setText("Campo obbligatorio!!");
            Alert allerta = new Alert(Alert.AlertType.WARNING);
            allerta.initOwner(insTS.getScene().getWindow());
            allerta.setTitle("Avvertenza");
            allerta.setHeaderText(null);
            allerta.setContentText("Correggere gli errori segnalati");

            allerta.showAndWait();

            return controllo;
        } else if (importoField.getText().isEmpty() || ivaField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sicuro?");
            alert.setHeaderText(null);
            alert.setContentText("Sei sicuro di voler inserire una spesa senza importo/iva?");

            Optional<ButtonType> risultato = alert.showAndWait();
            if (risultato.get() == ButtonType.OK) {
                controllo = true;
            } else {
                controllo = false;
            }

        } else {
            controllo = true;
        }

        return controllo;
    }
}
