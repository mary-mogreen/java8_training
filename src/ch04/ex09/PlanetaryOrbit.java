package ch04.ex09;/**
 * Created by mary-mogreen.
 */

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlanetaryOrbit extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        double width = 400;
        double height = 300;
        double centerX = width / 2;
        double centerY = height / 2;
        double radiusX = width / 2.2;
        double radiusY = height / 3.2;

        Ellipse orbit = new Ellipse();
        orbit.setCenterX(centerX);
        orbit.setCenterY(centerY);
        orbit.setRadiusX(radiusX);
        orbit.setRadiusY(radiusY);
        orbit.setFill(null);
        orbit.setStroke(Paint.valueOf("red"));

        double pRadius = 10.0;
        Circle planet = new Circle(centerX, radiusY / 2, pRadius);
        planet.setFill(Color.AQUA);

        PathTransition path = new PathTransition();
        path.setNode(planet);
        path.setPath(orbit);
        path.setDuration(Duration.millis(4_000));
        path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        path.setInterpolator(Interpolator.LINEAR);
        path.setCycleCount(Animation.INDEFINITE);
        path.play();

        Group group = new Group(orbit, planet);
        primaryStage.setScene(new Scene(group, 400, 300));
        primaryStage.show();

    }
}
