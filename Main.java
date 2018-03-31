package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Button startButton = new Button();

    public static void main(String[] args) {
        launch(args);
        WordMan wordman = new WordMan();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Word Man");
        startButton.setText("Start");

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                StackPane gameLayout = new StackPane();
                if (event.getSource() == startButton) {
                    Scene game = new Scene(gameLayout, 800, 800);


                }
            }
        });


        StackPane layout = new StackPane();
        layout.getChildren().add(startButton);
        Scene scene = new Scene(layout, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
