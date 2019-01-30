package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	public App() {
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
		stage.setScene(new Scene(root));
	    stage.show();
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}
