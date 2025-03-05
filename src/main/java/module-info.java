module com.example.intro_to_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.intro_to_javafx to javafx.fxml;
    exports com.example.intro_to_javafx;
}