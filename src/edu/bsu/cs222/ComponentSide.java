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
    String googleUserAgent = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    String chromeUserAgent = "Mozilla/5.0 (Linux; Android 7.0; SM-G892A Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/60.0.3112.107 Mobile Safari/537.36";
    String youtubeUserAgent = "Mozilla/5.0 (Linux; Android 4.4.4; One Build/KTU84L.H4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Mobile Safari/537.36";
    String chromiumUserAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.21 (KHTML, like Gecko) Mwendo/1.1.5 Safari/537.21";
    String desktopUserAgent = "Mozilla/5.0 (Linux x86_64) AppleWebKit/538.19 (KHTML, like Gecko) JavaFX/8.0 Safari/538.19";
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
        engineBottom.setUserAgent(youtubeUserAgent);
        engineBottom.load("https://www.espn.com");
    }

    public void GoToPandoraTop() {
        engineTop.setUserAgent(desktopUserAgent);
        engineTop.load("https://www.last.fm/");
    }

}
