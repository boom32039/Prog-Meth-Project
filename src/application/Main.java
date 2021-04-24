package application;

import Drawing.GameScreen;
import gui.MenuPane;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage)  {
		// TODO Auto-generated method stub
		// Intialize main menu
		MenuPane menu = new MenuPane();
		Scene menuscene = new Scene(menu, 800 ,600);
		stage.setScene(menuscene);
		stage.setTitle("Animal Fight!!");
		stage.show();
		
		// set start button
		menu.getstartButton().setOnAction(new EventHandler<ActionEvent>() {
			//it detects once, when you release!
			@Override
			public void handle(ActionEvent event) {
				StackPane root =  new StackPane();
				Scene gamescene =  new Scene(root , 800 ,600);
				GameLogic logic = new GameLogic();
				GameScreen gameScreen = new GameScreen(800, 600);
				root.getChildren().add(gameScreen);
				gameScreen.requestFocus();
				stage.setScene(gamescene);
				stage.setTitle("In game");
				
				AnimationTimer animation = new AnimationTimer() {
					public void handle(long now) {
						gameScreen.paintComponent();
						logic.logicUpdate();
						//RenderableHolder.getInstance().update();
						//InputUtility.updateInputState();
						
					}
				};
				animation.start();
			}
		});
			//set option button
			menu.getoptionButton().setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
						
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
