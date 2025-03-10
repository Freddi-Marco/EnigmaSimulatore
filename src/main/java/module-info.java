module com.iiscastelli.enigmasimulatore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.iiscastelli.enigmasimulatore to javafx.fxml;
    exports com.iiscastelli.enigmasimulatore;
}