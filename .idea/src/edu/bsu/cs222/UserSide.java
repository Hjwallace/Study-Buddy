package edu.bsu.cs222;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class UserSide {
    //String chromeUserAgent = "/Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";

    String chromeUserAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36";
    WebView textAreaMain;
    WebEngine textEngine;
    //TextArea userText;
    TextArea musicPlayer;
    public Node UserSideStartup(Label connectionLabel) {
        //User Side
        VBox userSide = new VBox(10);
        textAreaMain = new WebView();
        textEngine = textAreaMain.getEngine();
        textEngine.setJavaScriptEnabled(true);
        textEngine.setUserAgent(chromeUserAgent);
        textEngine.load("https://drive.google.com");
        userSide.setAlignment(Pos.TOP_LEFT);
        userSide.setPadding(new Insets(10,10,10,10));
        userSide.setFillWidth(true);
        musicPlayer = new TextArea("Music box will be here");

        userSide.getChildren().addAll(textAreaMain,musicPlayer,connectionLabel);

        return userSide;
    }
}
