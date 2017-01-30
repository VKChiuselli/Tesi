package com.nsi.rsni;


import com.nsi.rsni.service.NotaSpesaService;
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
public class Main extends Application{

    private static Stage primaryStage;



    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Hello Vittorio!");

        NotaSpesaService notaSpesaService = new NotaSpesaService();


        String id = notaSpesaService.inserisciNotaSpesa("Agente","Matricola","NSI Ufficio","Bologna","Falconara","Trasferta");
        String id1 = notaSpesaService.inserisciNotaSpesa("Agente1","Matricola1","NSI Ufficio1","Bologna1","Falconara1","Trasferta1");
        String id2 = notaSpesaService.inserisciNotaSpesa("Agente2","Matricola2","NSI Ufficio2","Bologna2","Falconara2","Trasferta2");

        TipoSpesaService tipoSpesaService = new TipoSpesaService();


        tipoSpesaService.insertTipoSpesa("uffa", "1.000", "22%");
        tipoSpesaService.insertTipoSpesa("altro", "87", "12%");
        tipoSpesaService.insertTipoSpesa("dai", "a000", "sdsa%");


        try {


            URL fxmlpath = this.getClass().getResource("/fxml/ListaNotaSpesa.fxml");


            FXMLLoader loader = new FXMLLoader();
            AnchorPane insertINS = loader.load(fxmlpath);


            Scene scene = new Scene(insertINS);

            primaryStage.setTitle("Inserisci Note Spese");
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static void main(){

        Application.launch();
    }


}
