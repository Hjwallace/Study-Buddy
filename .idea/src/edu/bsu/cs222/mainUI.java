package edu.bsu.cs222;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;


public class mainUI extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Grabbing user screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenHeight = screenSize.getHeight();
        double screenWidth = screenSize.getWidth();
        //--------------------------------


        //Main Box
        HBox mainWindow = new HBox();

        //User Side
        VBox userSide = new VBox(10);
        TextArea userText = new TextArea("User types here");
        userText.setPrefWidth(screenWidth*.4);
        userText.setPrefHeight(screenHeight-200);
        userText.setWrapText(true);
        userSide.setAlignment(Pos.CENTER);
        userSide.setPadding(new Insets(10,10,10,10));

        //Music Box
        TextArea musicPlayer = new TextArea("Music box will be here");
        //---End Music Box---

        //Conection
        Connection connection = new Connection();
        boolean connectionStatus = connection.findConnection();
        Label networkConnectionLabel = new Label("I am a label");
        //------------Color Loop for Connection Label------------
        if (connectionStatus){
            networkConnectionLabel.setText("Connection is Present");
            networkConnectionLabel.setTextFill(Color.color(0.0,1.0,0.0));
        }
        else {
            networkConnectionLabel.setText("Connection is not Present");
            networkConnectionLabel.setTextFill(Color.color(1.0,0.0,0.0));
        }
        //-----End Connection-------

        userSide.getChildren().addAll(userText,musicPlayer,networkConnectionLabel);

        //END USER SIDE

        //Component Side
        VBox compSide = new VBox(10);
        TextArea comp1 = new TextArea("Component 1 area");
        TextArea comp2 = new TextArea("Componet 2 area");
        comp1.setPrefSize(screenWidth*.6,screenHeight-200);
        comp2.setPrefSize(screenWidth*.6,screenHeight-200);

        compSide.getChildren().addAll(comp1,comp2);
        compSide.setAlignment(Pos.CENTER);
        compSide.setPadding(new Insets(10,10,10,10));
        //END COMP SIDE



        //Line Seperator
        Line seperator = LineBuilder.create().startX(screenWidth/2).startY(0).endX(screenWidth/2).endY(screenHeight).fill(Color.BLACK).build();
        //----------------------

        mainWindow.getChildren().addAll(userSide,seperator,compSide);
        primaryStage.setScene(new Scene(mainWindow,screenWidth,screenHeight));

        primaryStage.show();

        primaryStage.setOnCloseRequest((WindowEvent event1) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("WAIT");
            alert.setHeaderText("Are you sure you want to close?");
            alert.setContentText("Make sure you have saved and finished everything you wanted :)");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                //Okay
                System.out.println("Closing");
            } else {
                //Cancel
                event1.consume();
            }
        });



    }
}
