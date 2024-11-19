package com.example.javafxcomposition.controllers;

import com.example.javafxcomposition.utils.SceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {

    public void handleMainWindow(ActionEvent event) throws IOException {
        SceneLoader.loadScene(event, "main.fxml");
    }
    public void handleAuthorsWindow(ActionEvent event) throws IOException {
        SceneLoader.loadScene(event, "authors.fxml");
    }
    public void handleBooksWindow(ActionEvent event) throws IOException {
        SceneLoader.loadScene(event, "books.fxml");
    }


}