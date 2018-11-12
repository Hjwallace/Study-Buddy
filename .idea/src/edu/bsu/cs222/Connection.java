package edu.bsu.cs222;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connection {

    public boolean findConnection(){
        boolean connectionStatus;
        try
        {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            connectionStatus = true;
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            connectionStatus = false;
        }
        return connectionStatus;
    }

    public Label DisplayLabel(Label networkConnectionLabel) {
        boolean connectionStatus = findConnection();
        if (connectionStatus){
            networkConnectionLabel.setText("Connection is Present");
            networkConnectionLabel.setTextFill(Color.color(0.0,1.0,0.0));
        }
        else {
            networkConnectionLabel.setText("Connection is not Present");
            networkConnectionLabel.setTextFill(Color.color(1.0,0.0,0.0));
        }
        return networkConnectionLabel;
    }
}
