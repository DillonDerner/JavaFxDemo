package tutorial_09_Extract_Input;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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


        TextField input = new TextField();
        input.setPromptText("Input Box!");

        Button button = new Button("Click Me");
        button.setOnAction(event -> isInt(input, input.getText()));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(input, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean result = ConfirmBox.display("Close Program?", "Are you sure you want to Close the Application?");
        if(result){
            window.close();
        }
    }


    private boolean isInt(TextField input, String message){
        try{
            int age = Integer.parseInt(message);
            System.out.println("User is age: " + age);
            input.setStyle("-fx-text-fill: black;");
            return true;
        } catch (NumberFormatException e){
            System.out.println("Error: " + message + " is not a number");
            input.setStyle("-fx-text-fill: red;");
            return false;
        }

    }

}
