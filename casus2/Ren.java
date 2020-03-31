package sample;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ren extends Rectangle {
    double width;
    double height;
    double posX;
    double posY;

    public Ren(double width, double height, double posX, double posY) {
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(Color.SANDYBROWN);
    }
}
