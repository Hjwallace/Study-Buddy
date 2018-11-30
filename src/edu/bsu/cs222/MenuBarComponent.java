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

        Menu menuWindowTop = new Menu("Top Window");
        MenuItem youtubeButtonTop = new MenuItem("Youtube");
        youtubeButtonTop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToYoutubeTop();
            }
        });
        MenuItem googleButtonTop = new MenuItem("Google");
        googleButtonTop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToGoogleTop();
            }
        });
        MenuItem bsuButtonTop = new MenuItem("myBSU");
        bsuButtonTop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToBsuTop();
            }
        });
        MenuItem espnButtonTop = new MenuItem("ESPN");
        espnButtonTop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToESPNTop();
            }
        });
        MenuItem pandoraButtonTop = new MenuItem("Pandora");
        pandoraButtonTop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {webComponents.GoToPandoraTop();}
        });
        menuWindowTop.getItems().addAll(youtubeButtonTop, googleButtonTop, bsuButtonTop, espnButtonTop, pandoraButtonTop);

        Menu menuWindowBottom = new Menu("Bottom Window");
        MenuItem youtubeButtonBottom = new MenuItem("Youtube");
        youtubeButtonBottom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToYoutubeBottom();
            }
        });

        MenuItem googleButtonBottom = new MenuItem("Google");
        googleButtonBottom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToGoogleBottom();
            }
        });

        MenuItem bsuButtonBottom = new MenuItem("myBSU");
        bsuButtonBottom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToBsuBottom();
            }
        });
        MenuItem espnButtonBottom = new MenuItem("ESPN");
        espnButtonBottom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webComponents.GoToESPNBottom();
            }
        });
        menuWindowBottom.getItems().addAll(youtubeButtonBottom, googleButtonBottom, bsuButtonBottom, espnButtonBottom);

        Menu menuHelp = new Menu("Help");
        MenuItem getHelpButton = new MenuItem("Get Help");
        getHelpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("The get help button works");
            }
        });
        menuHelp.getItems().add(getHelpButton);

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

        menuBar.getMenus().addAll(menuFile,menuEdit,menuView,menuWindowTop,menuWindowBottom,menuHelp);
        return menuBar;
    }
}
