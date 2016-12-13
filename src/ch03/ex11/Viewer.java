package ch03.ex11;
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
        Image image = new Image("img/queen-mary.png");
        Image image2 = ImageUtils.transform(image,
                ColorTransformer.compose(
                        ColorTransformer.toTransformer(Color::brighter),
                        ColorTransformer.frameColorTransformer(10, Color.GRAY, (int) image.getWidth(), (int) image.getHeight())
                ));

        primaryStage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
        primaryStage.show();
    }
}
