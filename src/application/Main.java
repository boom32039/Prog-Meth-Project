package application;

import Drawing.GameScreen;
import exception.UnselectedException;
import gui.GamePane;
import gui.HowToPlayPane;

import gui.HowToPlayPane;

import gui.MenuPane;
import gui.PausePane;
import gui.PreGamePane;
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
	private MenuPane menu;
	private PreGamePane pregame;
	private HowToPlayPane howToPlay;
	private Scene menuscene;
	private Scene HowToPlayScene;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage)  {
		// TODO Auto-generated method stub
		// Intialize main menu
		
		MenuPane menu = new MenuPane();
		menuscene = new Scene(menu, 800 ,600);
		howToPlay = new HowToPlayPane();
		HowToPlayScene = new Scene(howToPlay, 800 ,600);
		
		stage.setResizable(false);
		stage.setScene(menuscene);
		stage.setTitle("Animal Fight!!");
		stage.show();
		
		// set start button
		menu.getstartButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setPreGamePane(stage);
			}
		});

		//set HowToPlay button 
		menu.getHowToPlayButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setHowToPlayPane(stage);
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
	
	public void setHowtoPlayPane(Stage stage) {
		
		howToPlay.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
			//it detects once, when you release!
			@Override
			public void handle(ActionEvent event) {

				howToPlay.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						stage.setScene(menuscene);
					}
				});
				
			}
		});
	}
	
	public void setPreGamePane(Stage stage) {
		
		pregame =  new PreGamePane(800,600);
		Scene pregamescene = new Scene(pregame , 800 , 600);
		stage.setScene(pregamescene);
		pregame.getStartBtn().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if (pregame.isAllTick()) {
						setupGameplay(stage);
					}
				} catch (UnselectedException e) {
					// TODO Auto-generated catch block
					pregame.setMessage(e.message);
				} 
			}
		});
		pregame.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(menuscene);
			}
		});
		
	}
	
	public void setHowToPlayPane(Stage stage) {
		stage.setScene(HowToPlayScene);
		stage.setTitle("How To Play");
		howToPlay.getBackBtn().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(menuscene);
			}
		});
		
	}
	
	public void setupGameplay(Stage stage) {
		
		GameLogic logic = new GameLogic();
		SimulationManager.setBackToMenu(false);
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
				if (SimulationManager.isBackToMenu()) {
					stop();
					stage.setScene(menuscene);
				}
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
						SimulationManager.setCoins1(SimulationManager.getCoins1() + 2);
						SimulationManager.setCoins2(SimulationManager.getCoins2() + 2);
					}
					
					lastTimeTriggered = now;
				}
				if (SimulationManager.isGameEnd()) {
					
					stop();
					
				}
			}
		};
	
		animation.start();
		timer.start();
	}
	
	
}

