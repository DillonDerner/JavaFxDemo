package tutorial_10_Checkbox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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


        //Checkboxes
        CheckBox checkBox1 = new CheckBox("Bacon");
        CheckBox checkBox2 = new CheckBox("Lettuce");
        checkBox2.setSelected(true);
        CheckBox checkBox3 = new CheckBox("Mayo");
        CheckBox checkBox4 = new CheckBox("Tomato");
        CheckBox checkBox5 = new CheckBox("Onions");

        Button button = new Button("Order Now!");
        button.setOnAction(event -> handleOptions(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, button);

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

    private void handleOptions(CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5) {
        String message = "Users order:\n";

        if(checkBox1.isSelected()){
            message += "Bacon\n";
        }
        if(checkBox2.isSelected()){
            message += "Lettuce\n";
        }
        if(checkBox3.isSelected()){
            message += "Mayo\n";
        }
        if(checkBox4.isSelected()){
            message += "Tomato\n";
        }
        if(checkBox5.isSelected()){
            message += "Onions\n";
        }
        System.out.println(message);


    }

}
