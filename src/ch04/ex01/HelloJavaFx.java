package ch04.ex01;/**
 * Created by mary-mogreen.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJavaFx extends Application {

    private final String DEFAULT_MESSAGE = "Hello, Java FX!!";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField field = new TextField(DEFAULT_MESSAGE);

        Label message = new Label(DEFAULT_MESSAGE);
        message.setFont(new Font(100));
        message.textProperty().bindBidirectional(field.textProperty());

        primaryStage.setScene(new Scene(new VBox(field, message)));
        primaryStage.setTitle("ch04.ex01: HelloJavaFX");
        primaryStage.show();

    }
}
