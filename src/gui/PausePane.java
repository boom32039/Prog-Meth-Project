package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import sharedObject.SimulationManager;

public class PausePane extends HBox{
	
	private Button menuBtn;
	
	public PausePane(int width , int height) {
		setPrefSize(width, height);
		setBackground(new Background(new BackgroundFill(Color.CHOCOLATE,null,null)));
		setPadding(new Insets(1,5,1,5));
		this.setStyle("-fx-background-image: url('woodbackground.jpg');");
		initializeMenuButton();
		
		this.getChildren().add(menuBtn);
		
	}
	
	public void initializeMenuButton() {
		menuBtn = new Button("MENU");
		//menuBtn.setBackground(new Background(new BackgroundFill(Color.BROWN,null,null)));
		menuBtn.setAlignment(Pos.BASELINE_LEFT);
		SimulationManager.setFont((Button) menuBtn, 14);
		menuBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SimulationManager.setBackToMenu(true);
			}
		});
	}
}
