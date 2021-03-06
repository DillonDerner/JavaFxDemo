package tutorial_11_Dropdown_Menu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
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



        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Bacon", "Cheese", "Eggs", "Soda");
        choiceBox.getSelectionModel().select(0); // default

        button.setOnAction(event -> getChoice(choiceBox));


        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(choiceBox, button);

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

    private void getChoice(ChoiceBox<String> choiceBox) {
        System.out.println(choiceBox.getValue());
    }

}
