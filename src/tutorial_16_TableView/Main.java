package tutorial_16_TableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

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

        //Columns
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Inputs
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(150);

        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(50);

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(50);

        // Button
        Button addButton = new Button("Add");
        addButton.setMinWidth(50);
        addButton.setOnAction(event -> addButtonClicked());
        Button delButton = new Button("Delete");
        delButton.setMinWidth(75);
        delButton.setOnAction(event -> delButtonClicked());

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        //Layout
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, delButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox, 500, 300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean result = ConfirmBox.display("Close Program?", "Are you sure you want to Close the Application?");
        if(result){
            window.close();
        }
    }

    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        // This would usually be your DB call
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Phone", 450.00, 56));
        products.add(new Product("Cup", 3.00, 200));
        products.add(new Product("Mouse", 20.00, 40));
        return products;
    }

    public void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void delButtonClicked() {
        ObservableList<Product> productsSelected, allProducts;
        allProducts = table.getItems();
        productsSelected = table.getSelectionModel().getSelectedItems();
        productsSelected.forEach(allProducts::remove);
    }

}
