module algo3.HelloFX {
    requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires junit;
    exports controladores;
    opens controladores to javafx.fxml;
}
