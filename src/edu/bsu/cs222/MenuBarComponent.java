package edu.bsu.cs222;

import javafx.scene.Node;
import javafx.scene.control.Alert;
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

        //Nature
        Menu natureButton = new Menu("Nature");

        MenuItem forrestTheme = new MenuItem("Forrest");
        forrestTheme.setOnAction(event -> setCssFile("forrest.css", mainWindow));

        MenuItem oceanTheme = new MenuItem("Ocean");
        oceanTheme.setOnAction(event -> setCssFile("ocean.css", mainWindow));

        MenuItem mountainTheme = new MenuItem("Mountain");
        mountainTheme.setOnAction(event -> setCssFile("mountains.css", mainWindow));

        natureButton.getItems().addAll(forrestTheme,oceanTheme,mountainTheme);
        //Nature end

        //Flags
        Menu flagButton = new Menu("Flags");
        MenuItem americanFlag = new MenuItem("America");
        americanFlag.setOnAction(event -> setCssFile("america.css", mainWindow));

        MenuItem mexicanFlag = new MenuItem("Mexico");
        mexicanFlag.setOnAction(event -> setCssFile("mexico.css", mainWindow));

        MenuItem canadianFlag = new MenuItem("Canada");
        canadianFlag.setOnAction(event -> setCssFile("canada.css", mainWindow));

        MenuItem chineseFlag = new MenuItem("China");
        chineseFlag.setOnAction(event -> setCssFile("china.css", mainWindow));

        MenuItem russianFlag = new MenuItem("Russia");
        russianFlag.setOnAction(event -> setCssFile("russia.css", mainWindow));
        flagButton.getItems().addAll(americanFlag,mexicanFlag,canadianFlag,chineseFlag,russianFlag);
        //end Flags


        menuView.getItems().addAll(bobRossButton,colorfulButton,natureButton,flagButton);

        Menu menuWindowTop = new Menu("Top Window");
        MenuItem youtubeButtonTop = new MenuItem("Youtube");
        youtubeButtonTop.setOnAction(event -> webComponents.GoToYoutubeTop());
        MenuItem googleButtonTop = new MenuItem("Google");
        googleButtonTop.setOnAction(event -> webComponents.GoToGoogleTop());
        MenuItem bsuButtonTop = new MenuItem("myBSU");
        bsuButtonTop.setOnAction(event -> webComponents.GoToBsuTop());
        MenuItem espnButtonTop = new MenuItem("ESPN");
        espnButtonTop.setOnAction(event -> webComponents.GoToESPNTop());
        MenuItem musicButtonTop = new MenuItem("LastFM");
        musicButtonTop.setOnAction(event -> webComponents.GoToPandoraTop());
        menuWindowTop.getItems().addAll(youtubeButtonTop, googleButtonTop, bsuButtonTop, espnButtonTop, musicButtonTop);

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
        MenuItem supportEmailButton = new MenuItem("Get Support Email");
        supportEmailButton.setOnAction(event -> {
            Alert email = new Alert(Alert.AlertType.INFORMATION);
            email.show();
            email.setTitle("Support Email");
            email.setHeaderText("StudyBuddyHelp@hotmail.com");
            email.setContentText("A member of our team will respond to you ASAP");
        });
        MenuItem instructionsButton = new MenuItem("Instructions");
        instructionsButton.setOnAction(event -> {
            Alert instructions = new Alert(Alert.AlertType.INFORMATION);
            instructions.show();
            instructions.setContentText("This application uses WebViews.\n To go back a page, click in white space and press BACKSPACE." +
                    " \nThe text editor is an online editor that requires either a DropBox account or an account through their site to access files." +
                    "\nThis is to save space on computers.");
            instructions.setHeight(400);
            instructions.setWidth(400);
        });
        menuHelp.getItems().addAll(supportEmailButton, instructionsButton);
        menuBar.getMenus().addAll(menuEdit,menuView,menuWindowTop,menuWindowBottom,menuHelp);
        return menuBar;
    }
    private void setCssFile(String file, VBox mainWindow) {
        mainWindow.getStylesheets().clear();
        String style = this.getClass().getResource(file).toExternalForm();
        mainWindow.getStylesheets().add(style);
    }
}
