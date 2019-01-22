package tutorial_08_GridPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10)); // edge padding
        gridPane.setVgap(8);  // Vertical   cell spacing
        gridPane.setHgap(10); // Horizontal cell spacing

        // Login Screen

        // Name Field
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField("Dillon");
        GridPane.setConstraints(nameInput, 1, 0);

        // Password Field
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);
        TextField passInput = new TextField();
        passInput.setPromptText("Enter your Password"); //This line is cool!
        GridPane.setConstraints(passInput, 1, 1);

        // Login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        gridPane.getChildren().addAll(nameLabel, nameInput, passInput, passLabel, loginButton);
        Scene scene = new Scene(gridPane, 300, 200);
        window.setScene(scene);
        window.show();

    }

    private void closeProgram() {
        boolean result = ConfirmBox.display("Close Program?", "Are you sure you want to Close the Application?");
        if(result){
            window.close();
        }
    }


}
