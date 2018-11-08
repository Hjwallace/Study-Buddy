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
    String chromiumUserAgent = "/Mozilla5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.21 (KHTML, like Gecko) Mwendo/1.1.5 Safari/537.21";
    WebView component1;
    WebView component2;
    WebEngine engine1;
    WebEngine engine2;

    public Node ComponentSideStartup() {
        VBox componentSide = new VBox(10);
        component1 = new WebView();
        engine1 = component1.getEngine();
        component2 = new WebView();
        engine2 = component2.getEngine();
        engine1.setJavaScriptEnabled(true);
        engine2.setJavaScriptEnabled(true);
        componentSide.getChildren().addAll(component1,component2);
        componentSide.setAlignment(Pos.TOP_RIGHT);
        componentSide.setPadding(new Insets(10,10,10,10));
        return componentSide;
    }
    public void GoToYoutube1() {
        engine1.setUserAgent(youtubeUserAgent);
        engine1.load("https://www.youtube.com");
    }
    public void GoToYoutube2() {
        engine2.setUserAgent(youtubeUserAgent);
        engine2.load("https://www.youtube.com");
    }
    public void GoToGoogle1() {
        engine1.setUserAgent(googleUserAgent);
        engine1.load("https://www.google.com");
    }
    public void GoToGoogle2() {
        engine2.setUserAgent(googleUserAgent);
        engine2.load("https://www.google.com");
    }

    public void GoToBsu1() {
        engine1.setUserAgent(googleUserAgent);
        engine1.load("https://my.bsu.edu/");
    }
    public void GoToBsu2() {
        engine2.setUserAgent(googleUserAgent);
        engine2.load("https://my.bsu.edu/");
    }
    public void GoToESPN1() {
        engine1.setUserAgent(googleUserAgent);
        engine1.load("https://www.espn.com");
    }
    public void GoToESPN2() {
        engine2.setUserAgent(youtubeUserAgent);
        engine2.load("https://www.espn.com");
    }
    public void GoToTwitch1() {
        engine1.setUserAgent(chromiumUserAgent);
        engine1.load("https://www.twitch.tv");

    }
}
