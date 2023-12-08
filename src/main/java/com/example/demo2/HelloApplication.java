package com.example.demo2;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

  //Su dung mui ten de them tin nhan tu phia Dr. Eggman
  //hoac Enter de gui tin nhan tu phia nguoi dung
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    stage.setTitle("Messenger");
    stage.setScene(scene);
    stage.getIcons().add(new Image(
        new File(
            "src/main/resources/com/example/demo2/messenger.png").toURI().toString()));
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}