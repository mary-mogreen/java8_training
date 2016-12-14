package ch04.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by mary-mogreen.
 */
public class GaugeDemoEx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button smaller = new Button("Smaller");
        Button larger = new Button("Larger");
        Rectangle gauge = new Rectangle(0, 5, 50, 15);
        Rectangle outline = new Rectangle(0, 5, 100, 15);
        outline.setFill(null);
        outline.setStroke(Color.BLACK);
        gauge.setFill(Color.YELLOW);
        Pane pane = new Pane();
        pane.getChildren().addAll(gauge, outline);

        smaller.setOnAction(event -> {
            gauge.setWidth(gauge.getWidth() - 10);
        });
        larger.setOnAction(event -> {
            gauge.setWidth(gauge.getWidth() + 10);
        });

        // observe を使用する。
        smaller.disableProperty().bind(
                ObservableValueUtils.observe(o -> o.doubleValue() <= 0, gauge.widthProperty())
        );

        larger.disableProperty().bind(
                ObservableValueUtils.observe(o -> o.doubleValue() >= 100, gauge.widthProperty())
        );

        HBox box = new HBox(10);
        box.getChildren().addAll(smaller, pane, larger);
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}