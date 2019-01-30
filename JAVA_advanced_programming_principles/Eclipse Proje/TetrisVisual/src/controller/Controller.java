package controller;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.xml.soap.Node;

import com.sun.org.apache.xml.internal.security.keys.content.KeyValue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import model.BoardManager;
import model.Nod;
import model.Piesa;

public class Controller implements Initializable {


	private int tablaSize =8;
	private BoardManager boardManager = new BoardManager(tablaSize, Arrays.asList(1, 2, 3, 4));
	private List<Integer> intPieseList = Arrays.asList(1, 2, 3, 4);
	private List<Piesa> pieseList;
	
	@FXML
	GridPane grid = new GridPane();
	

	@FXML
	GridPane stP = new GridPane();
	
	public Controller(){
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		drawTabla(boardManager.getRadacina());
		
		stP.getStyleClass().add("button-container");
		Button nextStep = new Button();
		nextStep.setText("Genereaza Tabla");
		nextStep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	boardManager = new BoardManager(tablaSize, intPieseList);
            	drawTabla(boardManager.getRadacina());
            }
        });
		nextStep.getStyleClass().add("userButton");
		stP.add(nextStep,0,0);
		Button startGame = new Button();
		startGame.setText("Start dfs");
		startGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				useDfs();
			}
		});
		startGame.getStyleClass().add("userButton");
		stP.add(startGame,1,0);
		
		Button stopGame = new Button();
		stopGame.setText("Start gbfs");
		stopGame.getStyleClass().add("userButton");
		stopGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				usegbfs();
			}
		});
		stP.add(stopGame,2,0);
		
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your name:");

	    AnchorPane.setRightAnchor(stP, 0.0);
	}

	public void updateLabel() {
		
	}
	
	
	public void addPiesa(int piesaNr) {
		this.intPieseList.add(piesaNr);
	}
	
	public void drawTabla(Nod nod) {
		grid.getChildren().clear();
		int size = nod.getTabla().getSizeX();
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				Rectangle r = new Rectangle(35,35);
				
				r.getStyleClass().add("square");
				if(nod.getTabla().getPawnAt(i, j)!=0) {

					r.getStyleClass().add("square-alive");
					
            	}
				grid.add(r,j,i);
			}
		}
		for(Entry<List<Integer>, Piesa> entry : nod.getTabla().getPieseList().entrySet()) {
			List<Integer> coords = entry.getKey();
			Piesa piesa = entry.getValue();
			int i2=0;int j2=0;
			for(int i=coords.get(0);i<coords.get(0)+piesa.getLength();i++) {
				for(int j=coords.get(1);j<coords.get(1)+piesa.getWidth();j++) {
					//tablaCurrent[i][j]+=piesaMat[i2][j2];
					List<javafx.scene.Node> nodeList = grid.getChildren();
					for(javafx.scene.Node nodd : nodeList) {
						Bounds boundsInScreen = nodd.getBoundsInLocal();
						if(boundsInScreen.getHeight()==i && boundsInScreen.getWidth()==j) {
							nodd.getStyleClass().add("sqare-"+piesa.getTip());
							System.out.println("Added square");
						};
					}
					j2++;
				}
				i2++;
				j2=0;
			}
		}
	}
	
	public void useDfs() {
		boardManager = new BoardManager(tablaSize, intPieseList);
		Nod nCastig= boardManager.dfsUsingStack();
		drawTabla(nCastig);
	}
	
	public void usegbfs() {
		boardManager = new BoardManager(tablaSize, intPieseList);
		Nod nCastig= boardManager.gbfs();
		drawTabla(nCastig);
	}
	public BoardManager getBoardManager() {
		return boardManager;
	}
	public void setBoardManager(BoardManager boardManager) {
		this.boardManager = boardManager;
	}
	
	public List<Integer> getIntPieseList() {
		return intPieseList;
	}
	public void setIntPieseList(List<Integer> intPieseList) {
		this.intPieseList = intPieseList;
	}
	public List<Piesa> getPieseList() {
		return pieseList;
	}
	public void setPieseList(List<Piesa> pieseList) {
		this.pieseList = pieseList;
	}
	
	
	
}
