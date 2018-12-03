package edu.bsu.cs222;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

class UserSide {
    WebView textAreaMain;
    WebView musicPlayer;

    Node UserSideStartup(Label connectionLabel) {
        //User Side
        VBox userSide = new VBox(10);
        textAreaMain = new WebView();
        WebEngine textEngine = textAreaMain.getEngine();
        textEngine.setJavaScriptEnabled(true);
        String googleUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";
        textEngine.setUserAgent(googleUserAgent);
        textEngine = textAreaMain.getEngine();
        textEngine.load("https://www.offidocs.com/?service=lang-en-en");
        musicPlayer = new WebView();
        musicPlayer.setZoom(.75);
        WebEngine musicEngine = musicPlayer.getEngine();
        textEngine.setJavaScriptEnabled(true);
        musicEngine.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
        musicEngine.load("https://www.last.fm");

        userSide.setAlignment(Pos.TOP_LEFT);
        userSide.setPadding(new Insets(10,10,10,10));
        userSide.setFillWidth(true);
        userSide.getChildren().addAll(textAreaMain,musicPlayer,connectionLabel);

        return userSide;
    }
}
