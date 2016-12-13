package ch03.ex06;/**
 * Created by mary-mogreen.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("img/queen-mary.png");
        Image brightenedImage = ImageUtils.transform(image,
                (color, factor) -> color.deriveColor(0, 1, factor, 1), 2.0);


        primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(brightenedImage))));
        primaryStage.show();
    }
}
