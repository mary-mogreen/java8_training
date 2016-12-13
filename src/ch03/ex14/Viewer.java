package ch03.ex14;
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

public class Viewer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("img/eiffel-tower.jpg");
        Image image2 = LatentImage.from(image).transform(
                (x, y, reader) -> reader.getColor((int) image.getWidth() - (x + 1), y)
        ).toImage();
        Image image3 = LatentImage.from(image).transform(Color::grayscale).toImage();
        Image image4 = LatentImage.from(image).transform(Color::grayscale).transform(
                (x, y, reader) -> reader.getColor(x, (int) image.getHeight() - (y + 1))
        ).toImage();

        primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2),
                new ImageView(image3), new ImageView(image4))));
        primaryStage.show();
    }
}
