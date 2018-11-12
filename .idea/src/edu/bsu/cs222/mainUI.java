package edu.bsu.cs222;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.util.Optional;


@SuppressWarnings("deprecation")
public class MainUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenHeight = screenSize.getHeight();
        double screenWidth = screenSize.getWidth();

        primaryStage.setTitle("Study Buddy v1");
        VBox mainWindow = new VBox();
        HBox componentWindow = new HBox();

        Connection connection = new Connection();
        Label networkConnectionLabel = new Label();
        mainWindow.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                connection.DisplayLabel(networkConnectionLabel);
            }
        });
        UserSide userComponents =new UserSide();
        Node userSide = userComponents.UserSideStartup(networkConnectionLabel);

        ComponentSide webComponents = new ComponentSide();
        Node componentSide = webComponents.ComponentSideStartup();

        Line seperator = LineBuilder.create().startX(screenWidth/2).startY(0).endX((screenWidth/2)+1).endY(screenHeight).fill(Color.BLACK).build();

        MenuBarComponent menus = new MenuBarComponent();
        Node menuBar = menus.MenuStartup(webComponents, userComponents);
        componentWindow.getChildren().addAll(userSide,seperator,componentSide);
        mainWindow.getChildren().addAll(menuBar,componentWindow);
        primaryStage.setScene(new Scene(mainWindow,screenWidth,screenHeight));
        String style = this.getClass().getResource("style.css").toExternalForm();
        mainWindow.getStylesheets().add(style);
        mainWindow.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double height = newValue.doubleValue();
                webComponents.componentTop.setPrefHeight(height/2.2);
                webComponents.componentBottom.setPrefHeight(height/2.2);
                userComponents.textAreaMain.setPrefHeight(height/1.5);
                userComponents.musicPlayer.setPrefHeight(height/5);
            }
        });

        mainWindow.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double width = newValue.doubleValue();
                webComponents.componentTop.setPrefWidth(width/1.7);
                webComponents.componentBottom.setPrefWidth(width/1.7);
                userComponents.textAreaMain.setPrefWidth(width/1.9);
                userComponents.musicPlayer.setPrefWidth(width/1.9);
            }
        });

        primaryStage.show();
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
    }
}
