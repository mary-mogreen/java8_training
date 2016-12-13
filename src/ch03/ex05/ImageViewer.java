package ch03.ex05;
/**
 * Created by mary-mogreen.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageViewer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("img/queen-mary.png");
        Image brightenedImage = ImageUtils.transform(image, Color::brighter);
        Image image2 = ImageUtils.transform(image, (x, y, c) -> {
            if (x > 10 && x < image.getWidth() - 10)
                if (y > 10 && y < image.getHeight() - 10)
                    return c;
            return Color.GRAY;
        });

        primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2), new ImageView(brightenedImage))));
        primaryStage.show();
    }
}
