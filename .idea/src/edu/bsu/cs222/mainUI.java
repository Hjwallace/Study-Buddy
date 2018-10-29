package edu.bsu.cs222;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.util.Optional;

@SuppressWarnings("deprecation")
public class mainUI extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenHeight = screenSize.getHeight();
        double screenWidth = screenSize.getWidth();
        String googleUserAgent = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
        String chromeUserAgent = "Mozilla/5.0 (Linux; Android 7.0; SM-G892A Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/60.0.3112.107 Mobile Safari/537.36";
        String youtubeUserAgent = "Mozilla/5.0 (Linux; Android 4.4.4; One Build/KTU84L.H4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Mobile Safari/537.36";

        primaryStage.setTitle("Study Buddy v1");
        VBox mainWindow = new VBox();
        HBox componentWindow = new HBox();



        //User Side
        VBox userSide = new VBox(10);
        TextArea userText = new TextArea("User types here");
        userText.setWrapText(true);
        userSide.setAlignment(Pos.TOP_LEFT);
        userSide.setPadding(new Insets(10,10,10,10));

        //Music Box
        TextArea musicPlayer = new TextArea("Music box will be here");
        //---End Music Box---

        //Conection
        Connection connection = new Connection();
        Label networkConnectionLabel = new Label();
        //------------Color Loop for Connection Label------------
        mainWindow.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean connectionStatus = connection.findConnection();
                if (connectionStatus){
                    networkConnectionLabel.setText("Connection is Present");
                    networkConnectionLabel.setTextFill(Color.color(0.0,1.0,0.0));
                }
                else {
                    networkConnectionLabel.setText("Connection is not Present");
                    networkConnectionLabel.setTextFill(Color.color(1.0,0.0,0.0));
                }
            }
        });
        //-----End Connection-------

        userSide.getChildren().addAll(userText,musicPlayer,networkConnectionLabel);
        //END USER SIDE

        //Component Side
        VBox componentSide = new VBox(10);
        WebView component1 = new WebView();
        WebEngine engine1 = component1.getEngine();
        WebView component2 = new WebView();
        WebEngine engine2 = component2.getEngine();
        engine1.setJavaScriptEnabled(true);
        engine2.setJavaScriptEnabled(true);
        //engine1.setUserAgent("Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        //engine2.setUserAgent("Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        componentSide.getChildren().addAll(component1,component2);
        componentSide.setAlignment(Pos.TOP_RIGHT);
        componentSide.setPadding(new Insets(10,10,10,10));
        //END COMP SIDE

        //Line Seperator
        Line seperator = LineBuilder.create().startX(screenWidth/2).startY(0).endX((screenWidth/2)+1).endY(screenHeight).fill(Color.BLACK).build();
        //----------------------

        userSide.setFillWidth(true);

        javafx.scene.control.MenuBar menuBar = new javafx.scene.control.MenuBar();

        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");

        //Window One menu options-------------------------
        Menu menuWindowOne = new Menu("Window 1");
        MenuItem youtubeButton1 = new MenuItem("Youtube");
        youtubeButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine1.setUserAgent(youtubeUserAgent);
                engine1.load("https://www.youtube.com");
            }
        });
        MenuItem googleButton1 = new MenuItem("Google");
        googleButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine1.setUserAgent(googleUserAgent);
                engine1.load("https://www.google.com");
            }
        });
        MenuItem bsuButton1 = new MenuItem("myBSU");
        bsuButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine1.setUserAgent(googleUserAgent);
                engine1.load("https://my.bsu.edu/");
            }
        });

        menuWindowOne.getItems().addAll(youtubeButton1, googleButton1, bsuButton1);
        //end of Window One menu options------------------

        //Window Two menu options-------------------------
        Menu menuWindowTwo = new Menu("Window 2");
        MenuItem youtubeButton2 = new MenuItem("Youtube");
        youtubeButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine2.setUserAgent(youtubeUserAgent);
                engine2.load("https://www.youtube.com");
            }
        });
        MenuItem googleButton2 = new MenuItem("Google");
        googleButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine2.setUserAgent(googleUserAgent);
                engine2.load("https://www.google.com");
            }
        });
        menuWindowTwo.getItems().addAll(youtubeButton2, googleButton2);
        //end of Window Two menu options------------------
        Menu menuHelp = new Menu("Help");

        //File Options--------------------------
        Menu menuFile = new Menu("File");
        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("The open file button works");
            }
        });
        MenuItem saveFile = new MenuItem("Save File");
        saveFile.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("The save file button works");
            }
        });
        menuFile.getItems().addAll(openFile,saveFile);
        //End File options------------------------

        componentWindow.getChildren().addAll(userSide,seperator,componentSide);
        menuBar.getMenus().addAll(menuFile,menuEdit,menuView,menuWindowOne,menuWindowTwo,menuHelp);
        mainWindow.getChildren().addAll(menuBar,componentWindow);
        primaryStage.setScene(new Scene(mainWindow,screenWidth,screenHeight));

        //CSS Implement
        String style = this.getClass().getResource("style.css").toExternalForm();
        mainWindow.getStylesheets().add(style);
        //CSS end

        mainWindow.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double height = newValue.doubleValue();
                component1.setPrefHeight(height/2.3);
                component2.setPrefHeight(height/2.3);
                userText.setPrefHeight(height/2);
                musicPlayer.setPrefHeight(height/5);
            }
        });

        mainWindow.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double width = newValue.doubleValue();
                component1.setPrefWidth(width/1.5);
                component2.setPrefWidth(width/1.5);
                userText.setPrefWidth(width/1.9);
                musicPlayer.setPrefWidth(width/1.9);
            }
        });

        primaryStage.show();


        //Alert for closing window
        primaryStage.setOnCloseRequest((WindowEvent event1) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("WAIT");
            alert.setHeaderText("Are you sure you want to close?");
            alert.setContentText("Make sure you have saved and finished everything you wanted!");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                System.out.println("Closing");
            } else {
                event1.consume();
            }
        });
        //END OF ALERT CODE




    }
}
