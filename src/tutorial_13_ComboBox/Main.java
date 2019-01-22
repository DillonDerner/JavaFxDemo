package tutorial_13_ComboBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title here");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Button button = new Button("Click me");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "St. Vincent",
                "Blackhat"
        );

        comboBox.setPromptText("What is your favorite movie?");

        comboBox.setEditable(true); // allows user to enter their own input

        button.setOnAction(e -> printMovie(comboBox.getValue()));
        comboBox.setOnAction(e -> printMovie(comboBox.getValue())); // comboBox can use the func setOnAction!
                                                                    // no need for a button!



        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean result = ConfirmBox.display("Close Program?", "Are you sure you want to Close the Application?");
        if(result){
            window.close();
        }
    }

    private void printMovie(String value) {
        System.out.println(value);

    }

}
