package edu.bsu.cs222;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.MenuBar;
import java.io.File;
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
            screenHeight = screenHeight *.9;
        double screenWidth = screenSize.getWidth();
            screenWidth = screenWidth *.9;
        //--------------------------------

        VBox MAINERWINDOW = new VBox();
        //Main Box
        HBox mainWindow = new HBox();

        javafx.scene.control.MenuBar menuBar = new javafx.scene.control.MenuBar();

        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        Menu menuHelp = new Menu("Help"); //Use this button to give info at some point

        menuBar.getMenus().addAll(menuFile,menuEdit,menuView,menuHelp);

        //User Side
        VBox userSide = new VBox(10);
        TextArea userText = new TextArea("User types here");
        userText.setPrefWidth(screenWidth*.4);
        userText.setPrefHeight(screenHeight- (screenHeight*.72));
        userText.setWrapText(true);
        userSide.setAlignment(Pos.TOP_LEFT);
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
        WebView comp1 = new WebView();
        WebEngine engine1 = comp1.getEngine();
        WebView comp2 = new WebView();
        WebEngine engine2 = comp2.getEngine();

        comp1.setStyle("-fx-background-color: rgba(255,255,255, .5);");

        comp1.setPrefSize(screenWidth*.5,screenHeight-(screenHeight*.8078));
        comp2.setPrefSize(screenWidth*.5,screenHeight-(screenHeight*.8078));



        compSide.getChildren().addAll(comp1,comp2);
        compSide.setAlignment(Pos.TOP_RIGHT);
        compSide.setPadding(new Insets(10,10,10,10));
        //END COMP SIDE



        //Line Seperator
        Line seperator = LineBuilder.create().startX(screenWidth/2).startY(0).endX(screenWidth/2).endY(screenHeight).fill(Color.BLACK).build();
        //----------------------

        mainWindow.getChildren().addAll(userSide,seperator,compSide);
        MAINERWINDOW.getChildren().addAll(menuBar,mainWindow);
        primaryStage.setScene(new Scene(MAINERWINDOW,screenWidth,screenHeight));


        //CSS Implement
        String css = this.getClass().getResource("style.css").toExternalForm();
        MAINERWINDOW.getStylesheets().add(css);
        //CSS end

        primaryStage.show();


        //Alert for closing window
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
        //END OF ALERT CODE




    }
}
