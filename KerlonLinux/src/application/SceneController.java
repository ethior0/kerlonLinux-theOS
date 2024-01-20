package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneController {

	@FXML
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private CheckBox checkBoxTop;
	@FXML
	private AnchorPane scenePane;
	@FXML
	private Button logoutButton;
	@FXML
	private TextField textFieldFolder;
	
	// trocar pra cena 1
	public void switchToScene1(ActionEvent e) throws IOException {
		setRoot( FXMLLoader.load( getClass().getResource("Main.fxml") ) );
		setStage( (Stage) ( (Node) e.getSource() ).getScene().getWindow() );
		setScene( new Scene( getRoot() ) );
		getScene().getStylesheets().add( getClass().getResource("application.css").toExternalForm() );
		
		System.out.println("Passou pra cena 1");
		getStage().setScene( getScene() );
		getStage().show();
	}
	
	// trocar pra cena 2
	public void switchToScene2(ActionEvent e) throws IOException {
		setRoot( FXMLLoader.load( getClass().getResource("Scene2.fxml") ) );
		setStage( (Stage) ( (Node) e.getSource() ).getScene().getWindow() );
		setScene( new Scene( getRoot() ) );
		getScene().getStylesheets().add( getClass().getResource("application.css").toExternalForm() );
		
		System.out.println("Passou pra cena 2");
		getStage().setScene( getScene() );
		getStage().show();
	}
	
	// trocar pra cena 3
	public void switchToScene3(ActionEvent e) throws IOException {
		if ( checkBoxTop.isSelected() ) {
			setRoot( FXMLLoader.load( getClass().getResource("Scene3.fxml") ) );
			setStage( (Stage) ( (Node) e.getSource() ).getScene().getWindow() );
			setScene( new Scene ( getRoot() ) );
			getScene().getStylesheets().add( getClass().getResource("application.css").toExternalForm() );
			
			System.out.println("Passou pra cena 3");
			getStage().setScene( getScene() );
			getStage().show();
		} 
		else {
			
			Alert alertCheckBox = new Alert(AlertType.WARNING);
			alertCheckBox.setTitle("Kerlon Linux: The OS");
			alertCheckBox.setHeaderText("Você precisa concordar com os termos para avançar!");
//			alertCheckBox.setContentText();
			
			setStage( (Stage) alertCheckBox.getDialogPane().getScene().getWindow() );
			Image icon = new Image("logo.png");
			getStage().getIcons().add(icon);
			
			System.out.println("Campo não preenchido");
			alertCheckBox.showAndWait();
		}
	}
	
	public void switchToScene4(ActionEvent e) throws IOException {
		if ( getTextFieldFolder().getText().equals("") ) {
			
			Alert alertTextField = new Alert(AlertType.WARNING);
			alertTextField.setTitle("Kerlon Linux: The OS");
			alertTextField.setHeaderText("Você precisa preencher o campo para avançar!");
//			alertTextField.setContentText("");
			
			setStage( (Stage) alertTextField.getDialogPane().getScene().getWindow() );
			Image icon = new Image("logo.png");
			getStage().getIcons().add(icon);
			
			System.out.println("Campo não preenchido");
			alertTextField.showAndWait();
			
//			JOptionPane.showMessageDialog(null, "Preencha o campo da pasta para avançar!");
		} else {
			setRoot( FXMLLoader.load( getClass().getResource("Scene4.fxml")) );
			setStage( (Stage) ( (Node) e.getSource() ).getScene().getWindow() );
			setScene( new Scene ( getRoot() ) );
			getScene().getStylesheets().add( getClass().getResource("application.css").toExternalForm() );
			
			System.out.println("Passou pra cena 4");
			getStage().setScene( getScene() );
			getStage().show();
		}
	}
	
	// botao de cancelar
	public void logout (ActionEvent e) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Kerlon Linux: The OS");
		alert.setHeaderText("Cancelar a instalação de Kerlon Linux?");
		
		setStage( (Stage) alert.getDialogPane().getScene().getWindow() );
		Image icon = new Image("logo.png");
		getStage().getIcons().add(icon);
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("Cancelou...");
			setStage((Stage) scenePane.getScene().getWindow());
			getStage().close();
		}
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Parent getRoot() {
		return root;
	}

	public void setRoot(Parent root) {
		this.root = root;
	}

	public CheckBox getCheckBoxTop() {
		return checkBoxTop;
	}

	public void setCheckBoxTop(CheckBox checkBoxTop) {
		this.checkBoxTop = checkBoxTop;
	}

	public AnchorPane getScenePane() {
		return scenePane;
	}

	public void setScenePane(AnchorPane scenePane) {
		this.scenePane = scenePane;
	}

	public Button getLogoutButton() {
		return logoutButton;
	}

	public void setLogoutButton(Button logoutButton) {
		this.logoutButton = logoutButton;
	}

	public TextField getTextFieldFolder() {
		return textFieldFolder;
	}

	public void setTextFieldFolder(TextField textFieldFolder) {
		this.textFieldFolder = textFieldFolder;
	}

}
