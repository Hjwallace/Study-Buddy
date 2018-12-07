package edu.bsu.cs222;

import javafx.scene.web.WebEngine;

public class WebViewChanger {
    static private String googleUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";
    static private String youtubeUserAgent = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-US; B1-710 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.1 Safari/534.30";

    public static void GoToYoutube(WebEngine engine) {
        engine.setUserAgent(youtubeUserAgent);
        engine.load("https://www.youtube.com");
    }
    public static void GoToGoogle(WebEngine engine) {
        engine.setUserAgent(youtubeUserAgent);
        engine.load("https://www.google.com");
    }
    public static void GoToBSU(WebEngine engine) {
        engine.setUserAgent(googleUserAgent);
        engine.load("https://my.bsu.edu");
    }
    public static void GoToOffidocs(WebEngine engine) {
        engine.setUserAgent(googleUserAgent);
        engine.load("https://www.offidocs.com/?service=lang-en-en");
    }
    public static void GoToWikipedia(WebEngine engine) {
        engine.setUserAgent(youtubeUserAgent);
        engine.load("https://www.wikipedia.org");
    }
}
