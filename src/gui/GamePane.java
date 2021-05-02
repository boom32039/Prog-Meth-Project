package gui;

import Drawing.GameScreen;
import javafx.scene.layout.VBox;

public class GamePane extends VBox {
	
	TimePane timepane;
	GameScreen gamescreen;
	PausePane pausepane;
	
	public GamePane(int width , int height) {
		
		this.timepane = new TimePane(width , 60);
		this.gamescreen = new GameScreen(width , height-100);
		this.pausepane = new PausePane();
		this.getChildren().addAll(timepane , gamescreen , pausepane);
		this.gamescreen.setFocusTraversable(true);
		
	}
	
	public void paintComponent() {
		timepane.paintComponent();
		gamescreen.paintComponent();
		pausepane.paintComponent();
	}
	
	
	
}
