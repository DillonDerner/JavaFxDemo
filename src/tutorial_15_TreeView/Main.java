package tutorial_15_TreeView;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TreeView<String> treeView;

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

        treeView = new TreeView<>();

        TreeItem<String> root, dillon, lesley;

        root = new TreeItem<>();
        root.setExpanded(true);

        dillon = makeBranch("Dillon", root);
        makeBranch("Runescape", dillon);
        makeBranch("Youtube", dillon);
        makeBranch("Programing", dillon);

        lesley = makeBranch("Lesley", root);
        makeBranch("Food", lesley);
        makeBranch("Bdubs", lesley);

        // make tree
        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue != null)
                System.out.println(newValue.getValue());

        });




        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(treeView);

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

    private TreeItem<String> makeBranch(String name, TreeItem<String> parent) {
        TreeItem<String> treeItem = new TreeItem<>(name);
        treeItem.setExpanded(true);
        parent.getChildren().add(treeItem);
        return treeItem;
    }
}
