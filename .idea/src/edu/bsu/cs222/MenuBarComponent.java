package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarComponent {
    ComponentSide webComponents;
    UserSide userComponents;

    public Node MenuStartup(ComponentSide webComponents, UserSide userComponents){
        MenuBar menuBar = new MenuBar();

        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");

        Menu menuWindowOne = new Menu("Window 1");
        MenuItem youtubeButton1 = new MenuItem("Youtube");
        youtubeButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToYoutube1();
            }
        });
        MenuItem googleButton1 = new MenuItem("Google");
        googleButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToGoogle1();
            }
        });
        MenuItem bsuButton1 = new MenuItem("myBSU");
        bsuButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToBsu1();
            }
        });
        MenuItem espnButton1 = new MenuItem("ESPN");
        espnButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToESPN1();
            }
        });
        MenuItem twitchButton1 = new MenuItem("Twitch");
        twitchButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToTwitch1();
            }
        });
        menuWindowOne.getItems().addAll(youtubeButton1, googleButton1, bsuButton1, espnButton1, twitchButton1);

        Menu menuWindowTwo = new Menu("Window 2");
        MenuItem youtubeButton2 = new MenuItem("Youtube");
        youtubeButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToYoutube2();
            }
        });

        MenuItem googleButton2 = new MenuItem("Google");
        googleButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToGoogle2();
            }
        });

        MenuItem bsuButton2 = new MenuItem("myBSU");
        bsuButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToBsu2();
            }
        });
        MenuItem espnButton2 = new MenuItem("ESPN");
        espnButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToESPN2();
            }
        });
        menuWindowTwo.getItems().addAll(youtubeButton2, googleButton2, bsuButton2, espnButton2);

        Menu menuHelp = new Menu("Help");

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
        menuBar.getMenus().addAll(menuFile,menuEdit,menuView,menuWindowOne,menuWindowTwo,menuHelp);
        return menuBar;
    }
}
