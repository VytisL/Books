package com.example.javafxcomposition.utils;

import com.example.javafxcomposition.BooksApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class SceneLoader {
    public static void loadScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(BooksApplication.class.getResource(fxmlFile)));

        Window window = (event.getSource() instanceof MenuItem)
                ?((MenuItem) event.getSource()).getParentPopup().getOwnerWindow()
                :((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Stage stage = (Stage) window;
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
        stage.setMaximized(true);
    }
}
