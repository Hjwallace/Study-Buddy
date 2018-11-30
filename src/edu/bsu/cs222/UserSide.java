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

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class UserSide {
    String googleUserAgent = "Mozilla/5.0 (X11; Linux x86_64; rv:99.0) Gecko/20200101 Firefox/99.0";
    WebView textAreaMain;
    WebEngine textEngine;
    //TextArea userText;
    WebView musicPlayer;
    WebEngine musicEngine;
    public Node UserSideStartup(Label connectionLabel) throws IOException {
        //User Side
        VBox userSide = new VBox(10);
        textAreaMain = new WebView();
        textEngine = textAreaMain.getEngine();
        textEngine.setJavaScriptEnabled(true);
        textEngine.setUserAgent(googleUserAgent);
        textEngine = textAreaMain.getEngine();
        textEngine.load("https://www.offidocs.com/?service=lang-en-en");
        userSide.setAlignment(Pos.TOP_LEFT);
        userSide.setPadding(new Insets(10,10,10,10));
        userSide.setFillWidth(true);
        musicPlayer = new WebView();
        musicEngine = musicPlayer.getEngine();
        textEngine.setJavaScriptEnabled(true);
        musicEngine.setUserAgent("Mozilla/5.0 (X11; Linux x86_64; rv:99.0) Gecko/20200101 Firefox/99.0");
        musicEngine.load("https://www.last.fm");

        userSide.getChildren().addAll(textAreaMain,musicPlayer,connectionLabel);

        return userSide;
    }
}
