package com.nsi.rsni;


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
public class MainDettaglioTipoSpesa extends Application{

    private static Stage primaryStage;



    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Hello Vittorio!");





        try {


            URL fxmlpath = this.getClass().getResource("/fxml/DettaglioTipoSpesa.fxml");


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
