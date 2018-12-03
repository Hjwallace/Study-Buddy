package edu.bsu.cs222;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

class ComponentSide {
    private String googleUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";
    private String youtubeUserAgent = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-US; B1-710 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.1 Safari/534.30";
    WebView componentTop;
    WebView componentBottom;
    private WebEngine engineTop;
    private WebEngine engineBottom;

    Node ComponentSideStartup() {
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
    void GoToYoutubeTop() {
        engineTop.setUserAgent(youtubeUserAgent);
        engineTop.load("https://www.youtube.com");
    }
    void GoToYoutubeBottom() {
        engineBottom.setUserAgent(youtubeUserAgent);
        engineBottom.load("https://www.youtube.com");
    }
    void GoToGoogleTop() {
        engineTop.setUserAgent(googleUserAgent);
        engineTop.load("https://www.google.com");
    }
    void GoToGoogleBottom() {
        engineBottom.setUserAgent(googleUserAgent);
        engineBottom.load("https://www.google.com");
    }

    void GoToBsuTop() {
        engineTop.setUserAgent(googleUserAgent);
        engineTop.load("https://my.bsu.edu/");
    }
    void GoToBsuBottom() {
        engineBottom.setUserAgent(googleUserAgent);
        engineBottom.load("https://my.bsu.edu/");
    }
    void GoToESPNTop() {
        engineTop.setUserAgent(googleUserAgent);
        engineTop.load("https://www.espn.com");
    }
    void GoToESPNBottom() {
        engineBottom.setUserAgent(googleUserAgent);
        engineBottom.load("https://www.espn.com");
    }

    void GoToPandoraTop() {
        engineTop.setUserAgent(googleUserAgent);
        engineTop.load("https://www.last.fm/");
    }

}
