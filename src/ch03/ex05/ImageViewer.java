package ch03.ex05;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class ImageViewer extends Application {
    public void start(Stage stage) {
      Image image = new Image("queen-mary.png");
      Image brightenedImage = ImageUtils.transform(image, Color::brighter);
      Image image2 = ImageUtils.transform(image, (x, y, c) -> {
            if (x > 10 && x < image.getWidth() - 10)
                if (y > 10 && y < image.getHeight() - 10)
                    return c;
            return Color.GRAY;
        });
      
      stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2), new ImageView(brightenedImage))));
      stage.show();
   }
}