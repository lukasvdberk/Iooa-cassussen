package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class Kip extends AnchorPane {
    private final double WALK_SPEED = 25;
    private final double KIP_HEIGHT = 50;
    private final double KIP_WIDTH = 50;
    private Ren ren;
    private Pane mainPane;
    private AnchorPane eierenPane = new AnchorPane();
    public static int AANTAL_EIEREN = 0;
    private ArrayList<EiToegevoegdEvent> eiToegevoegdEventsListeners = new ArrayList<EiToegevoegdEvent>();


    public Kip(double x, double y, Ren ren, Pane mainPane) {
        this.ren = ren;
        this.mainPane = mainPane;

        // Our kip image
        Image kipImage = new Image("mrschicken2.png");
        ImageView kipView = new ImageView(kipImage);
        kipView.setFitHeight(KIP_HEIGHT);
        kipView.setFitWidth(KIP_WIDTH);
        this.getChildren().add(kipView);
        this.setTranslateX(x);
        this.setTranslateY(y);
    }


    public void beweegKip(KeyEvent pressedKey) {
        double currentX = this.getTranslateX();
        double currentY = this.getTranslateY();

        KeyCode pressedKeyCode = pressedKey.getCode();
        if(pressedKeyCode == KeyCode.LEFT) {
            // Check of hij met de huidige width van het pane binnen valt
            if(currentX >= 0) {
                this.setTranslateX(currentX - WALK_SPEED);
            }
        }

        if(pressedKeyCode == KeyCode.RIGHT) {
            // Check of hij met de huidige width van het pane binnen valt
            if(currentX <= mainPane.getWidth() - KIP_HEIGHT) {
                this.setTranslateX(currentX + WALK_SPEED);
            }
        }

        if(pressedKeyCode == KeyCode.UP) {
            // Check of hij met de huidige height van het pane binnen valt
            if(currentY >= 0) {
                this.setTranslateY(currentY - WALK_SPEED);
            }
        }

        if(pressedKeyCode == KeyCode.DOWN) {
            if(currentY <= mainPane.getHeight() - KIP_HEIGHT) {
                this.setTranslateY(currentY + WALK_SPEED);
            }
        }
    }

    public boolean isKipInRen() {
        double renStartX = ren.posX - (KIP_WIDTH / 2);
        // Waar de ren dus eindigt op de x en de breede van de kip afgehaald (die deling is voor dat we niet de hele breedte willen aanzien het ei eronder word gelegt)
        double renEndX = ren.posX + ren.width - (KIP_WIDTH / 1.4);


        double renStartY = ren.posY - KIP_HEIGHT;
        // Waar de ren dus eindigt op de y
        double renEndY = ren.posY + ren.height - KIP_HEIGHT;

        // Posities van de kip
        double kipX = this.getTranslateX();
        double kipY = this.getTranslateY();

        // Kijken of de kip in de range valt van het ren op x en de y
        return kipX >= renStartX && kipX <= renEndX && kipY >= renStartY && renEndY >= kipY;
    }

    public void legEi(KeyEvent pressedKey) {
        KeyCode pressedKeyCode = pressedKey.getCode();
        if(pressedKeyCode == KeyCode.SPACE && this.isKipInRen()) {
            Ei ei = new Ei(this.getTranslateX() + 20, this.getTranslateY() + 50);
            mainPane.getChildren().add(ei);
            AANTAL_EIEREN += 1;

            for(EiToegevoegdEvent event: eiToegevoegdEventsListeners) {
                // Roept alle event listeners aan dat er een ei toegevoegd is met het ei object
                event.onAdd(ei);
            }
        }
    }

    public void addEiToegevoegdEvent(EiToegevoegdEvent event) {
        this.eiToegevoegdEventsListeners.add(event);
    }
}
