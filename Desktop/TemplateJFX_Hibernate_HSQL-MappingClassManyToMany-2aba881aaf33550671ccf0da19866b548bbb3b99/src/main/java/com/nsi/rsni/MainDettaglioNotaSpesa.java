package com.nsi.rsni;


import com.nsi.rsni.service.TipoSpesaService;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Created by acerioni on 06/09/2016.
 */
public class MainDettaglioNotaSpesa extends Application {

    private static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Hello Vittorio!");

        try {


            URL fxmlpath = this.getClass().getResource("/fxml/DettaglioNotaSpesa.fxml");


            FXMLLoader loader = new FXMLLoader();
            AnchorPane insertCrud = loader.load(fxmlpath);


            Scene scene = new Scene(insertCrud);

            primaryStage.setTitle("Inserisci Note Spese");
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main() throws Exception {


        System.out.println("entro qui");
        TipoSpesaService tipoSpesaService = new TipoSpesaService();
        tipoSpesaService.insertTipoSpesa("desc1", "importo1", "iva1");
        tipoSpesaService.insertTipoSpesa("desc2", "importo2", "iva2");
        Application.launch();


    }


}
