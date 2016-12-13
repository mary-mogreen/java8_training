package ch03.ex13;
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
        Image image2 = LatentImage.from(image).transform(ColorTransformer.edge()).transform(ColorTransformer.blur())
                .toImage();

        primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
        primaryStage.show();
    }
}
