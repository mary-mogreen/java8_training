package ch04.ex10;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by mary-mogreen.
 */
public class BrowserDemo  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        WebHistory history = engine.getHistory();

        String location = "http://horstmann.com";
        TextField urlField = new TextField(location);
        urlField.setOnAction(event -> engine.load(urlField.getText()));
//        urlField.textProperty().bind(
//                Bindings.createStringBinding(
//                        () -> {
//                            if (history.getCurrentIndex() < 1)
//                                return location;
//                            return history.getEntries().get(history.getCurrentIndex()).getUrl();
//                        },
//                        history.currentIndexProperty()
//                )
//        );


        Button back = new Button("back");
        back.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> history.getCurrentIndex() < 1,
                        history.currentIndexProperty()
                )
        );
        back.setOnAction(event -> {
            history.go(-1);
        });
        engine.load(location);

        BorderPane pane = new BorderPane();
        pane.setCenter(browser);
        pane.setTop(urlField);
        pane.setLeft(back);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

}
