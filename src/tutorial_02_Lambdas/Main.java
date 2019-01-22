package tutorial_02_Lambdas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("First JavaFX App!");

        button = new Button();
        button.setText("My First Button!");

        button.setOnAction(e -> {
            System.out.println("OOOOOOOOOOOH NICEEEEEEEEEEEEE!");
            System.out.println("OOOOOOOOOOOH NICEEEEEEEEEEEEE!");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
