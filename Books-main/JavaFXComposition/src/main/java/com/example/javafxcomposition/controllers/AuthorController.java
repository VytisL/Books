package com.example.javafxcomposition.controllers;

import com.example.javafxcomposition.models.Author;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class AuthorController {
    @FXML
    private TableView<Author>  authorTableView;

    @FXML
    private TableColumn<Author, Integer> idColumn;

    @FXML
    private TableColumn<Author, String> nameColumn;

    @FXML
    private TableColumn<Author, String> surnameColumn;

    @FXML
    private TableColumn<Author, String> emailColumn;

    @FXML
    private TableColumn<Author, String> pennameColumn;

    private static ObservableList<Author> authors = FXCollections.observableArrayList();

    public static ObservableList<Author> getAuthor() {
        return authors;
    }


    public void initialize() {

        idColumn.setCellValueFactory(cellData->cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        surnameColumn.setCellValueFactory(cellData->cellData.getValue().surnameProperty());
        emailColumn.setCellValueFactory(cellData->cellData.getValue().emailProperty());
        pennameColumn.setCellValueFactory(cellData->cellData.getValue().pennameProperty());

        authorTableView.setItems(authors);
    }

    @FXML
    public void handleAddAuthor(ActionEvent event) {
        Dialog<Author> dialog = new Dialog<>();
        dialog.setTitle("Add author");
        dialog.setHeaderText("Add author information");

        TextField nameField = new TextField();
        TextField surnameField = new TextField();
        TextField emailField = new TextField();
        TextField pennameField = new TextField();




        GridPane grid = new GridPane();grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Label("Vardas:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Pavardė:"), 0, 1);
        grid.add(surnameField, 1, 1);
        grid.add(new Label("El. paštas:"), 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(new Label("Slapyvardis:"), 0, 3);
        grid.add(pennameField, 1, 3);
        dialog.getDialogPane().setContent(grid);


        //Buttons
        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL );


        //Handle result
        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == addButtonType){
                //Create author object
                Author newAuthor = new Author(nameField.getText(), surnameField.getText(), emailField.getText());
                newAuthor.setPenname(pennameField.getText());
                newAuthor.setId(authors.size() + 1);
                return newAuthor;
            }
            return null;
        });

        //Show dialog and get result

        Optional<Author> result = dialog.showAndWait();

        result.ifPresent((author -> {
            authors.add(author);
        }));

    }

}