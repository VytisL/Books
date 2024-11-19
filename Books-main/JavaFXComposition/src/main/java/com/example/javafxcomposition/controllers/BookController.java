package com.example.javafxcomposition.controllers;

import com.example.javafxcomposition.models.Author;
import com.example.javafxcomposition.models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class BookController {
    @FXML
    private TableView<Book> bookTableView;

    @FXML
    private TableColumn<Book, Integer> ISBNColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorNameColumn;

    @FXML
    private TableColumn<Book, Integer> amountColumn;

    @FXML
    private TableColumn<Book, Integer> priceColumn;

    private static ObservableList<Book> books = FXCollections.observableArrayList();

    public void initialize() {

        ISBNColumn.setCellValueFactory(cellData->cellData.getValue().ISBNProperty().asObject());
        titleColumn.setCellValueFactory(cellData->cellData.getValue().titleProperty());
        authorNameColumn.setCellValueFactory(cellData->cellData.getValue().getAuthor().surnameProperty());
        amountColumn.setCellValueFactory(cellData->cellData.getValue().amountProperty().length().asObject());
        priceColumn.setCellValueFactory(cellData->cellData.getValue().priceProperty().length().asObject());

        bookTableView.setItems(books);
    }

    @FXML
    public void handleAddBook(ActionEvent actionEvent) {


        if(AuthorController.getAuthor().isEmpty()){
            Alert noAuthor = new Alert(Alert.AlertType.ERROR);
            noAuthor.setTitle("Klaida");
            noAuthor.setHeaderText("No authors found");
            noAuthor.showAndWait();
            return;




        }

        Dialog<Book> dialog = new Dialog<>();

        dialog.setTitle("Prideti knyga");
        dialog.setHeaderText("Iveskite informacija apie knyga");

        TextField titleField = new TextField();
        ComboBox<Author> authorComboBox = new ComboBox<>(AuthorController.getAuthor());
        TextField amountField = new TextField();
        TextField priceField = new TextField();




        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Knygos pavadinimas:"), 0, 0);grid.add(titleField, 1, 0);
        grid.add(new Label("Autorius:"), 0, 1);grid.add(authorComboBox, 1, 1);
        grid.add(new Label("Kiekis:"), 0, 2);grid.add(amountField, 1, 2);
        grid.add(new Label("Kaina:"), 0, 3);grid.add(priceField, 1, 3);

        dialog.getDialogPane().setContent(grid);


        //buttons

        ButtonType addButtonType = new ButtonType("Pridėti", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        //handle result
        dialog.setResultConverter(dialogButton ->  {
            if (dialogButton == addButtonType){
                //create Book object
                Book newBook = new Book(titleField.getText(), amountField.getText(), priceField.getText(), authorComboBox.getValue());
                newBook.setPrice(priceField.getText());
                newBook.setISBN(books.size() + 1);
                return newBook;
            }
            return null;
        });

        Optional<Book> result = dialog.showAndWait();

        result.ifPresent(Book -> {
            books.add(Book);
        });

    }
}
