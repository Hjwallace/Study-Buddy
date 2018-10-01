package edu.bsu.cs222;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
        VBox userSide = new VBox();
        TextField userText = new TextField("Quack here");
        userSide.setPrefWidth(screenWidth*.4);
        userSide.setPrefHeight(screenHeight-200);
        userSide.getChildren().addAll(userText);
        //----------------------

        mainWindow.getChildren().add(userSide);

        primaryStage.setScene(new Scene(mainWindow,screenWidth,screenHeight));
        primaryStage.show();

    }
}
