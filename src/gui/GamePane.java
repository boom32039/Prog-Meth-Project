package gui;

import Drawing.GameScreen;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sharedObject.SimulationManager;

public class GamePane extends VBox {
	
	TimePane timepane;
	StackPane gameScreenStack;
	GameScreen gamescreen;
	PausePane pausepane;
	GameResult gameresult;
	
	public GamePane(int width , int height) {
		super(0);
		this.timepane = new TimePane(width , 60);
		this.gameScreenStack = new StackPane();
		this.pausepane = new PausePane(width , 45);
		
		this.gamescreen = new GameScreen(width , height-100);
		this.gameresult = new GameResult(width/2 , (height-100)/2);
		gameScreenStack.getChildren().add(gamescreen);
		this.getChildren().addAll(timepane , gameScreenStack, pausepane);
		this.gamescreen.setFocusTraversable(true);
		
	}
	
	public void paintComponent() {
		timepane.paintComponent();
		gamescreen.paintComponent();
		paintGameResult();
	}
	
	public void paintGameResult() {
		if (SimulationManager.isGameEnd()) {
			gameScreenStack.getChildren().setAll(gamescreen , gameresult);
		}
		
		
	}
	
}
