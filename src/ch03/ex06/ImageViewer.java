package ch03.ex06;


import java.util.function.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

import ch03.ex05.ColorTransformer;



public class ImageViewer extends Application {
    public void start(Stage stage) {
      Image image = new Image("../ex05/queen-mary.png");
      Image brightenedImage = ImageUtils.transform(image, 
        (color, factor) -> {
            color.deriveColor(0, 1, factor, 1);
        }, 1.2);
      
      
      stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(brightenedImage))));
      stage.show();
   }
}