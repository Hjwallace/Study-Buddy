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

public class UserSide {
    TextArea userText;
    TextArea musicPlayer;
    public Node UserSideStartup(Label connectionLabel) {
        //User Side
        VBox userSide = new VBox(10);
        userText = new TextArea("User types here");
        userText.setWrapText(true);
        userSide.setAlignment(Pos.TOP_LEFT);
        userSide.setPadding(new Insets(10,10,10,10));
        userSide.setFillWidth(true);
        musicPlayer = new TextArea("Music box will be here");

        userSide.getChildren().addAll(userText,musicPlayer,connectionLabel);
        return userSide;
    }

}
