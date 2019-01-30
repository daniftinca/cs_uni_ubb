package controller;



import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.BoardManager;

public class Controller implements Initializable {

	@FXML
	GridPane grid = new GridPane();
	
	@FXML
	GridPane stP = new GridPane();
	KeyFrame keyframe = new KeyFrame(Duration.millis(500),ae-> {getNextStep();})  ;
	
	private Timeline timeline = new Timeline(keyframe);

	private BoardManager boardManager = new BoardManager(20,20);


	public Controller() {
		super();
		
	}

	/**
	 * Updates the square grid to correspond to the BoardManager State.
	 */
	private void updateGrid() {
		grid.getChildren().clear();
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				Rectangle r = new Rectangle(35,35);
				r.setOnMouseClicked(new EventHandler<MouseEvent>()
		        {
		            @Override
		            public void handle(MouseEvent t) {
		            	int i = GridPane.getRowIndex(r);
		            	int j = GridPane.getColumnIndex(r);
		            	if(boardManager.getSpielTafel().getPawnAt(i, j)==0) {
		            		
		            		

		            		r.getStyleClass().add("square-alive");
		            		boardManager.togglePawn(i, j);
		            	}
		            	else {
		            		r.getStyleClass().remove("square-alive");
		            		boardManager.togglePawn(i, j);
		            	}
		            }
		        });
				r.getStyleClass().add("square");
				if(boardManager.getSpielTafel().getPawnAt(i, j)==0) {
					
					
            	}
            	else {
            		r.getStyleClass().add("square-alive");
            	}
				grid.add(r,j,i);
			}
		}
	}
	
	/**
	 * Bringt den Tafel zu dem naechsten Schritt.
	 */
	private void getNextStep() {
		boardManager.getNextBoardState();
		updateGrid();
	}
	
	/**
	 * Startet den Spiel, macht einen Schritt jede 0.5 Sekunden.
	 */
	public void startGame() {
		timeline.play();
		
		String ssound = "song.mp3";
	    Media sound =new Media(new File(ssound).toURI().toString());
	    MediaPlayer mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
	    
	}

	/**
	 * Stoppt das Spiel.
	 */
	public void stopGame() {
		timeline.stop();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		timeline.setCycleCount(Animation.INDEFINITE);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				Rectangle r = new Rectangle(35,35);
				r.getStyleClass().add("square"); 
				r.setOnMouseClicked(new EventHandler<MouseEvent>()
		        {
		            @Override
		            public void handle(MouseEvent t) {
		            	int i = GridPane.getRowIndex(r);
		            	int j = GridPane.getColumnIndex(r);
		            	if(boardManager.getSpielTafel().getPawnAt(i, j)==0) {

		            		r.getStyleClass().add("square-alive");
		            		boardManager.togglePawn(i, j);
		            	}
		            	else {
		            		r.getStyleClass().remove("square-alive");
		            		boardManager.togglePawn(i, j);
		            	}
		            }
		        });
				grid.add(r,i,j);
			}
		}
		stP.getStyleClass().add("button-container");
		Button nextStep = new Button();
		nextStep.setText("Next Step");
		nextStep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	getNextStep();
            }
        });
		nextStep.getStyleClass().add("userButton");
		stP.add(nextStep,0,0);
		Button startGame = new Button();
		startGame.setText("Start");
		startGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				startGame();
			}
		});
		startGame.getStyleClass().add("userButton");
		stP.add(startGame,1,0);
		
		Button stopGame = new Button();
		stopGame.setText("Stop");
		stopGame.getStyleClass().add("userButton");
		stopGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stopGame();
			}
		});
		stP.add(stopGame,2,0);
	    //AnchorPane.setBottomAnchor(stP, 20.0);
	    AnchorPane.setRightAnchor(stP, 0.0);
	}
}
