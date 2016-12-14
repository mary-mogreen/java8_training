package ch04.ex04;/**
 * Created by mary-mogreen.
 */

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.beans.binding.Bindings.*;

public class CircleDemoEx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 100, 100);
        circle.setFill(Color.AQUAMARINE);
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane);
        circle.centerXProperty().bind(divide(scene.widthProperty(), 2));
        circle.centerYProperty().bind(divide(scene.heightProperty(), 2));
        circle.radiusProperty().bind(min(scene.widthProperty(), scene.heightProperty()).divide(2));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
