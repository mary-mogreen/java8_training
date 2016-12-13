package ch03.ex12;
/**
 * Created by mary-mogreen.
 */


import ch03.ex11.ColorTransformer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Viewer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("img/queen-mary.png");
        Image image2 = LatentImage.from(image).transform(Color::brighter)
                .transform(Color::brighter).transform(Color::grayscale)
                .transform(ColorTransformer.frameColorTransformer(10, Color.PLUM, (int) image.getWidth(), (int) image.getHeight()))
                .toImage();

        primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
        primaryStage.show();
    }
}
