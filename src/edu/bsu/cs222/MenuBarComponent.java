package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

class MenuBarComponent {

    Node MenuStartup(ComponentSide webComponents,UserSide userComponents, VBox mainWindow){
        MenuBar menuBar = new MenuBar();
        Menu menuVisibilityButton = new Menu("Visibility");
        MenuItem textAreaVisibility = new MenuItem("Toggle Text Area");
        textAreaVisibility.setOnAction(event -> {
            if (userComponents.leftWebView.isVisible() == true) {
                userComponents.leftWebView.setVisible(false);
            } else {
                userComponents.leftWebView.setVisible(true);
            }
        });
        MenuItem musicAreaVisibility = new MenuItem("Toggle Music Area");
        musicAreaVisibility.setOnAction(event -> {
            if (userComponents.musicPlayer.isVisible() == true){
                userComponents.musicPlayer.setVisible(false);
            }
            else{
                userComponents.musicPlayer.setVisible(true);
            }
        });
        MenuItem topWebViewBoxVisibility = new MenuItem("Toggle Top Web Area");
        topWebViewBoxVisibility.setOnAction(event -> {
            if (webComponents.componentTop.isVisible() == true){
                webComponents.componentTop.setVisible(false);
            }
            else{
                webComponents.componentTop.setVisible(true);
            }
        });
        MenuItem bottomWebViewBoxVisibility = new MenuItem("Toggle Bottom Web Area");
        bottomWebViewBoxVisibility.setOnAction(event -> {
            if (webComponents.componentBottom.isVisible() == true){
                webComponents.componentBottom.setVisible(false);
            }
            else{
                webComponents.componentBottom.setVisible(true);
            }
        });
        menuVisibilityButton.getItems().addAll(textAreaVisibility,musicAreaVisibility,topWebViewBoxVisibility,bottomWebViewBoxVisibility);

        Menu menuBackground = new Menu("Backgrounds");
        MenuItem bobRossButton = new MenuItem("Bob Ross");
        bobRossButton.setOnAction(event -> setCssFile("bobRoss.css", mainWindow));
        MenuItem colorfulButton = new MenuItem("Colorful");
        colorfulButton.setOnAction(event -> setCssFile("colorful.css", mainWindow));

        Menu natureButton = new Menu("Nature");
        MenuItem forrestTheme = new MenuItem("Forest");
        forrestTheme.setOnAction(event -> setCssFile("forest.css", mainWindow));
        MenuItem oceanTheme = new MenuItem("Ocean");
        oceanTheme.setOnAction(event -> setCssFile("ocean.css", mainWindow));
        MenuItem mountainTheme = new MenuItem("Mountain");
        mountainTheme.setOnAction(event -> setCssFile("mountains.css", mainWindow));
        natureButton.getItems().addAll(forrestTheme,oceanTheme,mountainTheme);

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
        menuBackground.getItems().addAll(bobRossButton,colorfulButton,natureButton,flagButton);

        Menu menuWindowTop = new Menu("Top Window");
        MenuItem youtubeButtonTop = new MenuItem("Youtube");
        youtubeButtonTop.setOnAction(event -> WebViewChanger.GoToYoutube(webComponents.engineTop));
        MenuItem googleButtonTop = new MenuItem("Google");
        googleButtonTop.setOnAction(event -> WebViewChanger.GoToGoogle(webComponents.engineTop));
        MenuItem bsuButtonTop = new MenuItem("myBSU");
        bsuButtonTop.setOnAction(event -> WebViewChanger.GoToBSU(webComponents.engineTop));
        MenuItem offidocButtonTop = new MenuItem("Offidocs");
        offidocButtonTop.setOnAction(event -> WebViewChanger.GoToOffidocs(webComponents.engineTop));
        MenuItem wikipediaButtonTop = new MenuItem("Wikipedia");
        wikipediaButtonTop.setOnAction(event -> WebViewChanger.GoToWikipedia(webComponents.engineTop));
        menuWindowTop.getItems().addAll(youtubeButtonTop, googleButtonTop, bsuButtonTop, offidocButtonTop, wikipediaButtonTop);

        Menu menuWindowBottom = new Menu("Bottom Window");
        MenuItem youtubeButtonBottom = new MenuItem("Youtube");
        youtubeButtonBottom.setOnAction(event -> WebViewChanger.GoToYoutube(webComponents.engineBottom));
        MenuItem googleButtonBottom = new MenuItem("Google");
        googleButtonBottom.setOnAction(event -> WebViewChanger.GoToGoogle(webComponents.engineBottom));
        MenuItem bsuButtonBottom = new MenuItem("myBSU");
        bsuButtonBottom.setOnAction(event -> WebViewChanger.GoToBSU(webComponents.engineBottom));
        MenuItem offidocButtonBottom = new MenuItem("Offidocs");
        offidocButtonBottom.setOnAction(event -> WebViewChanger.GoToOffidocs(webComponents.engineBottom));
        MenuItem wikipediaButtonBottom = new MenuItem("Wikipedia");
        wikipediaButtonBottom.setOnAction(event -> WebViewChanger.GoToWikipedia(webComponents.engineBottom));
        menuWindowBottom.getItems().addAll(youtubeButtonBottom, googleButtonBottom, bsuButtonBottom, offidocButtonBottom, wikipediaButtonBottom);

        Menu menuWindowLeft = new Menu("Left Window");
        MenuItem youtubeButtonLeft = new MenuItem("Youtube");
        youtubeButtonLeft.setOnAction(event -> WebViewChanger.GoToYoutube(userComponents.engineLeft));
        MenuItem googleButtonLeft = new MenuItem("Google");
        googleButtonLeft.setOnAction(event -> WebViewChanger.GoToGoogle(userComponents.engineLeft));
        MenuItem bsuButtonLeft = new MenuItem("myBSU");
        bsuButtonLeft.setOnAction(event -> WebViewChanger.GoToBSU(userComponents.engineLeft));
        MenuItem offidocButtonLeft = new MenuItem("Offidocs");
        offidocButtonLeft.setOnAction(event -> WebViewChanger.GoToOffidocs(userComponents.engineLeft));
        MenuItem wikipediaButtonLeft = new MenuItem("Wikipedia");
        wikipediaButtonLeft.setOnAction(event -> WebViewChanger.GoToWikipedia(userComponents.engineLeft));
        menuWindowLeft.getItems().addAll(youtubeButtonLeft, googleButtonLeft, bsuButtonLeft, offidocButtonLeft, wikipediaButtonLeft);

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
            instructions.setContentText("This application uses WebViews. To go back a page, click on the WebView and press BACKSPACE." +
                    " \nThe text editor is an online editor that requires either a DropBox account or an account through their site to access files." +
                    "\nThis is to save space on computers.");
            instructions.setHeight(400);
            instructions.setWidth(400);
        });
        menuHelp.getItems().addAll(supportEmailButton, instructionsButton);
        menuBar.getMenus().addAll(menuBackground,menuWindowTop,menuWindowBottom,menuWindowLeft, menuVisibilityButton,menuHelp);
        return menuBar;
    }
    private void setCssFile(String file, VBox mainWindow) {
        mainWindow.getStylesheets().clear();
        String style = this.getClass().getResource(file).toExternalForm();
        mainWindow.getStylesheets().add(style);
    }
}
