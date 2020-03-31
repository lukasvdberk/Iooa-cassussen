package sample;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Ei extends AnchorPane {
    public Ei(double x, double y) {
        // Ei image
        Image eiImage = new Image("ei.png");
        ImageView eiView = new ImageView(eiImage);
        eiView.setFitHeight(20);
        eiView.setFitWidth(20);

        this.getChildren().add(eiView);
        this.setTranslateX(x);
        this.setTranslateY(y);
    }
}
