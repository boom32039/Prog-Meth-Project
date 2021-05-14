package application;

import Drawing.GameScreen;

import gui.GamePane;
import gui.HowToPlayPane;

import gui.HowToPlayPane;

import gui.MenuPane;
import gui.PausePane;
import gui.TimePane;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class Main extends Application{
	
	private long lastTimeTriggered = -1;
	private int currentTime = 0;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage)  {
		// TODO Auto-generated method stub
		// Intialize main menu
		MenuPane menu = new MenuPane();
		HowToPlayPane howToPlay = new HowToPlayPane();
		Scene menuscene = new Scene(menu, 800 ,600);
		stage.setScene(menuscene);
		stage.setTitle("Animal Fight!!");
		stage.show();
		
		// set start button
		menu.getstartButton().setOnAction(new EventHandler<ActionEvent>() {
			
			

			//it detects once, when you release!
			@Override
			public void handle(ActionEvent event) {
				
				GameLogic logic = new GameLogic();
				
				GamePane gamepane = new GamePane(800,600);
				Scene gamescene = new Scene(gamepane,800,600);
				stage.setScene(gamescene);
				stage.setTitle("In game");
				
				
				AnimationTimer animation = new AnimationTimer() {
					public void handle(long now) {
						gamepane.paintComponent();
						logic.logicUpdate();
						//RenderableHolder.getInstance().update();
						//InputUtility.updateInputState();
					}
				};
				
				AnimationTimer timer = new AnimationTimer() {
					
					@Override
					public void handle(long now) {
						// TODO Auto-generated method stub
						
						lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);
						
						if (now - lastTimeTriggered >= 1000000000)
						{
							SimulationManager.setDecreaseIngametime();
							if (SimulationManager.getIngametime() % 2 == 0) {
								SimulationManager.setCoins1Increase();
								SimulationManager.setCoins2Increase();
							}
							
							lastTimeTriggered = now;
						}
					}
				};
				
			animation.start();
			timer.start();
			}
		});

		//set HowToPlay button 
		menu.getHowToPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HowToPlayPane howToPlay = new HowToPlayPane();
				Scene HowToPlayScene = new Scene(howToPlay, 800, 600);
				stage.setScene(HowToPlayScene);
				stage.setTitle("How To Play");
				stage.show();

				// set option button
				howToPlay.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						start(stage);
					}
				});


			}
		});
				
		//set quit button
		menu.getquitButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
		
	}
	
	
}

