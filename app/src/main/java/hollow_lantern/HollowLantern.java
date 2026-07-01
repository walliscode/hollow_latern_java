package hollow_lantern;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HollowLantern extends Application {

  @Override
  public void start(Stage stage) {
    Label l = new Label("Hollow Lantern");
    Scene scene = new Scene(new StackPane(l), 1200, 900);
    stage.setTitle("Hollow Lantern");
    stage.setScene(scene);
    stage.show();

  }

  public static void main(String[] args) {
    launch();
  }

}
