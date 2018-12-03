package edu.bsu.cs222;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.atomic.AtomicBoolean;

class Connection {

    boolean findConnection(){
        AtomicBoolean connectionStatus = new AtomicBoolean(false);
        try
        {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            connectionStatus.set(true);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            connectionStatus.set(false);
        }
        return connectionStatus.get();
    }

    void DisplayLabel(Label networkConnectionLabel) {
        boolean connectionStatus = findConnection();
        if (connectionStatus){
            networkConnectionLabel.setText("Connection is Present");
            networkConnectionLabel.setTextFill(Color.color(0.0,1.0,0.0));
        }
        else {
            networkConnectionLabel.setText("Connection is not Present");
            networkConnectionLabel.setTextFill(Color.color(1.0,0.0,0.0));
        }
    }
}
