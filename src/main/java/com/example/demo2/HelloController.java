package com.example.demo2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HelloController implements Initializable {
  @FXML
  TextField inputBox;
  @FXML
  VBox vBox = new VBox();
  @FXML
  ScrollPane scrollPane;
  boolean read = false;
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    scrollPane.vvalueProperty().bind(vBox.heightProperty());
    vBox.setSpacing(5);
  }

  void addMessage(String type) {
    if (inputBox.getText().isEmpty() && !type.equals("read")) {
      return;
    }
    if (read) {
      vBox.getChildren().remove(vBox.getChildren().size() - 1);
      read = false;
    }
    Label sentMessage;
    if (!type.equals("read")) {
      sentMessage = new Label(inputBox.getText());
    } else {
      sentMessage = new Label("Đã đọc");
    }
    sentMessage.getStyleClass().add(type);
    HBox hBox = new HBox();
    hBox.getChildren().add(sentMessage);
    if (!type.equals("friendMessage")) hBox.setAlignment(Pos.BOTTOM_RIGHT);
    inputBox.setText("");
    vBox.getChildren().add(hBox);
    scrollPane.setContent(vBox);
  }
  @FXML
  void sendMessage(MouseEvent event) {
    addMessage("friendMessage");
  }

  @FXML
  void checkEnter(KeyEvent event) {
    if (event.getCode() == KeyCode.ENTER) {
      addMessage("userMessage");
      addMessage("read");
      read = true;
    }
  }
}