package application;
	
import com.test.snake.controller.GameController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
		
	public static Scene sceneMenu;
	
	public static Scene scene;
	
	public static Stage stage;
	
	public static boolean onMenu = true;
		
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			FXMLLoader loaderMenu = new FXMLLoader();
			
			loader.setLocation(Main.class.getResource("../com/test/snake/views/Snake.fxml"));
			loaderMenu.setLocation(Main.class.getResource("../com/test/snake/views/Menu.fxml"));

			scene = new Scene(loader.load(),600,480);
			sceneMenu = new Scene(loaderMenu.load());
			
			primaryStage.setScene(sceneMenu);
			primaryStage.show();
			stage = primaryStage;
			
			//Receives user commands to control snakes direction
			scene.setOnKeyPressed(event -> {
				if (event.getCode() == KeyCode.W && GameController.snake.getDirection() != "s")
					GameController.snake.setDirection("w");
				
				if (event.getCode() == KeyCode.S && GameController.snake.getDirection() != "w")
					GameController.snake.setDirection("s");

				if (event.getCode() == KeyCode.A  && GameController.snake.getDirection() != "d")
					GameController.snake.setDirection("a");

				if (event.getCode() == KeyCode.D  && GameController.snake.getDirection() != "a")
					GameController.snake.setDirection("d");
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**Changes the Scene of the Stage
	 * 
	 */
	public static void changeScene() {
		if (onMenu) {
			stage.setScene(scene);
			onMenu = false;
		} else {
			stage.setScene(sceneMenu);
			onMenu = true;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
