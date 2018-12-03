package edu.bsu.cs222;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

class MenuBarComponent {

    Node MenuStartup(ComponentSide webComponents, VBox mainWindow){
        MenuBar menuBar = new MenuBar();
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        MenuItem bobRossButton = new MenuItem("Bob Ross");
        bobRossButton.setOnAction(event -> setCssFile("bobRoss.css", mainWindow));
        MenuItem colorfulButton = new MenuItem("Colorful");
        colorfulButton.setOnAction(event -> setCssFile("colorful.css", mainWindow));
        menuView.getItems().addAll(bobRossButton, colorfulButton);

        Menu menuWindowTop = new Menu("Top Window");
        MenuItem youtubeButtonTop = new MenuItem("Youtube");
        youtubeButtonTop.setOnAction(event -> webComponents.GoToYoutubeTop());
        MenuItem googleButtonTop = new MenuItem("Google");
        googleButtonTop.setOnAction(event -> webComponents.GoToGoogleTop());
        MenuItem bsuButtonTop = new MenuItem("myBSU");
        bsuButtonTop.setOnAction(event -> webComponents.GoToBsuTop());
        MenuItem espnButtonTop = new MenuItem("ESPN");
        espnButtonTop.setOnAction(event -> webComponents.GoToESPNTop());
        MenuItem pandoraButtonTop = new MenuItem("Pandora");
        pandoraButtonTop.setOnAction(event -> webComponents.GoToPandoraTop());
        menuWindowTop.getItems().addAll(youtubeButtonTop, googleButtonTop, bsuButtonTop, espnButtonTop, pandoraButtonTop);

        Menu menuWindowBottom = new Menu("Bottom Window");
        MenuItem youtubeButtonBottom = new MenuItem("Youtube");
        youtubeButtonBottom.setOnAction(event -> webComponents.GoToYoutubeBottom());

        MenuItem googleButtonBottom = new MenuItem("Google");
        googleButtonBottom.setOnAction(event -> webComponents.GoToGoogleBottom());

        MenuItem bsuButtonBottom = new MenuItem("myBSU");
        bsuButtonBottom.setOnAction(event -> webComponents.GoToBsuBottom());
        MenuItem espnButtonBottom = new MenuItem("ESPN");
        espnButtonBottom.setOnAction(event -> webComponents.GoToESPNBottom());
        menuWindowBottom.getItems().addAll(youtubeButtonBottom, googleButtonBottom, bsuButtonBottom, espnButtonBottom);

        Menu menuHelp = new Menu("Help");
        MenuItem getHelpButton = new MenuItem("Get Help");
        getHelpButton.setOnAction(event -> System.out.println("The get help button works"));
        menuHelp.getItems().add(getHelpButton);

        Menu menuFile = new Menu("File");
        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(t -> System.out.println("The open file button works"));
        MenuItem saveFile = new MenuItem("Save File");
        saveFile.setOnAction(t -> System.out.println("The save file button works"));
        menuFile.getItems().addAll(openFile,saveFile);

        menuBar.getMenus().addAll(menuFile,menuEdit,menuView,menuWindowTop,menuWindowBottom,menuHelp);
        return menuBar;
    }
    private void setCssFile(String file, VBox mainWindow) {
        mainWindow.getStylesheets().clear();
        String style = this.getClass().getResource(file).toExternalForm();
        mainWindow.getStylesheets().add(style);
    }
}
