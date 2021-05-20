package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class GameResult extends VBox {

	private Label winner;
	private Button menuBtn;
	

	public GameResult(int width , int height) {
		
		super(10);
		setMaxSize(width, height);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-image: url('scrollbackground.png'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 400 300;");
		
		winner = new Label("Player1" + " win!!");
		winner.setAlignment(Pos.CENTER);
		SimulationManager.setFont((Label) winner , 40);
		
		menuBtn = new Button("Main Menu");
		menuBtn.setPrefSize(100, 40);
		SimulationManager.setFont(((Button) menuBtn) , 16);
		
		menuBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SimulationManager.setBackToMenu(true);
			}
		});
		
		this.getChildren().addAll(winner , menuBtn);
		
		
	}
	
	
	
	
	
	
	
}
