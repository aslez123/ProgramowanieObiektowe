package agh.ics.oop.gui;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class GuiElementBox extends Node {

    int size = 20;
    public final VBox verticalBox = new VBox();

    public GuiElementBox(IMapElement obj){
        try {
            ImageView img = new ImageView(new Image(new FileInputStream(obj.getImagePath())));
            img.setFitWidth(size);
            img.setFitHeight(size);

            verticalBox.setAlignment(Pos.BASELINE_CENTER);
            verticalBox.getChildren().add(ElementKind.Image.value, img);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Label label = new Label(obj.getName());
//        verticalBox.getChildren().add(ElementKind.Name.value, (Node)label);
    }

    private enum ElementKind {
        Image(0),
        Name(1);

        public final int value;

        ElementKind(int value) {
            this.value = value;
        }
    }
}

