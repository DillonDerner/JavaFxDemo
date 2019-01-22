package tutorial_17_Making_Menus;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tutorial_16_TableView.Product;

public class Main extends Application {

    Stage window;
    BorderPane layout;


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


        //Home Menu
        Menu homeMenu = new Menu("_Menu");
        // Menu items
        MenuItem newHome = new MenuItem("_New...");
        newHome.setOnAction(e -> System.out.println("clicked new!"));
        homeMenu.getItems().add(newHome);
        homeMenu.getItems().add(new MenuItem("Home"));
        homeMenu.getItems().add(new MenuItem("Add Property"));
        homeMenu.getItems().add(new MenuItem("Add Tenant"));
        homeMenu.getItems().add(new SeparatorMenuItem());
        homeMenu.getItems().add(new MenuItem("Add Person"));

        // Edit Menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("_Hello"));
        editMenu.getItems().add(new MenuItem("World"));
        MenuItem world = new MenuItem("World...");
        world.setDisable(true);
        editMenu.getItems().add(world);

        //Help Menu - checkbox
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setSelected(true);
        showLines.setOnAction(e -> {
            if(showLines.isSelected()) System.out.println("Program will now display line numbers");
            else System.out.println("Hiding line numbers");
        });
        helpMenu.getItems().add(showLines);

        //Difficulty - Radio menu item
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("INSANE");

        easy.setToggleGroup(toggleGroup);
        medium.setToggleGroup(toggleGroup);
        hard.setToggleGroup(toggleGroup);

        easy.setSelected(true);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        // Main Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(homeMenu, editMenu, helpMenu, difficultyMenu);



        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 500, 300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean result = ConfirmBox.display("Close Program?", "Are you sure you want to Close the Application?");
        if (result) {
            window.close();
        }
    }

}
