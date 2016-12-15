package ch04.ex06;/**
 * Created by mary-mogreen.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BorderPaneDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        HBox top = new HBox(new Button("Top"));
        top.setAlignment(Pos.CENTER);
        pane.setTop(top);
        pane.setLeft(new Button("Left"));
        pane.setCenter(new Button("Center"));
        pane.setRight(new Button("Right"));
        HBox bottom = new HBox(new Button("Bottom"));
        bottom.setAlignment(Pos.CENTER);
        pane.setBottom(bottom);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

    }
}
