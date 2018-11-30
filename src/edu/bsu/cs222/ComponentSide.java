package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ComponentSide {
    String googleUserAgent = "Mozilla/5.0 (X11; Linux x86_64; rv:99.0) Gecko/20200101 Firefox/99.0";
    String youtubeUserAgent = "Mozilla/5.0 (Linux; Android 6.0.1; SM-N9100 Build/LRX22C) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13F69 Safari/601.1";
    WebView componentTop;
    WebView componentBottom;
    WebEngine engineTop;
    WebEngine engineBottom;

    public Node ComponentSideStartup() {
        VBox componentSide = new VBox(10);
        componentTop = new WebView();
        componentBottom = new WebView();
        engineTop = componentTop.getEngine();
        engineBottom = componentBottom.getEngine();
        engineTop.setJavaScriptEnabled(true);
        engineBottom.setJavaScriptEnabled(true);
        componentSide.getChildren().addAll(componentTop,componentBottom);
        componentSide.setAlignment(Pos.TOP_RIGHT);
        componentSide.setPadding(new Insets(10,10,10,10));
        return componentSide;
    }
    public void GoToYoutubeTop() {
        engineTop.setUserAgent(youtubeUserAgent);
        engineTop.load("https://www.youtube.com");
    }
    public void GoToYoutubeBottom() {
        engineBottom.setUserAgent(youtubeUserAgent);
        engineBottom.load("https://www.youtube.com");
    }
    public void GoToGoogleTop() {
        engineTop.setUserAgent(googleUserAgent);
        engineTop.load("https://www.google.com");
    }
    public void GoToGoogleBottom() {
        engineBottom.setUserAgent(googleUserAgent);
        engineBottom.load("https://www.google.com");
    }

    public void GoToBsuTop() {
        engineTop.setUserAgent(googleUserAgent);
        engineTop.load("https://my.bsu.edu/");
    }
    public void GoToBsuBottom() {
        engineBottom.setUserAgent(googleUserAgent);
        engineBottom.load("https://my.bsu.edu/");
    }
    public void GoToESPNTop() {
        engineTop.setUserAgent(googleUserAgent);
        engineTop.load("https://www.espn.com");
    }
    public void GoToESPNBottom() {
        engineBottom.setUserAgent(googleUserAgent);
        engineBottom.load("https://www.espn.com");
    }

    public void GoToPandoraTop() {
        engineTop.setUserAgent(googleUserAgent);
        engineTop.load("https://www.last.fm/");
    }

}
