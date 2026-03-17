module sio.gestionrestaurant {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    opens sio.gestionrestaurant.Model;
    opens sio.gestionrestaurant to javafx.fxml;
    exports sio.gestionrestaurant;
}