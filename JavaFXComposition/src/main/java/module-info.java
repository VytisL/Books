module com.example.javafxcomposition {
    requires javafx.controls;
    requires javafx.fxml;




    exports com.example.javafxcomposition;
    exports com.example.javafxcomposition.controllers to javafx.fxml;
    opens com.example.javafxcomposition.controllers to javafx.fxml;

}