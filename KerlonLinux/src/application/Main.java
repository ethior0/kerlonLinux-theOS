package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Image icon = new Image("logo.png");
			stage.getIcons().add(icon);
			
			stage.setResizable(false);
			stage.setTitle("Kerlon Linux: The OS");
			stage.setScene(scene);
			stage.show();
			
			// tela de cancelar pro X da janela
			stage.setOnCloseRequest(event -> {
				event.consume();
				logout(stage);
			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// botao de cancelar
	public void logout (Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.initOwner(stage);
		alert.setTitle("Kerlon Linux: The OS");
		alert.setHeaderText("Cancelar a instalação de Kerlon Linux?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("Cancelou...");
			stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
