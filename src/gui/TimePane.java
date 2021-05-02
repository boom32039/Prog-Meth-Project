package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class TimePane extends HBox {
	
	private TimeChannel timechannel;
	private AnimalChannel1 animalchannel1;
	private AnimalChannel2 animalchannel2;
	private PointChannel pointchannel1;
	private PointChannel pointchannel2;
	
	public TimePane(int width , int height){
		
		this.setWidth(width);
		//this.setHeight(height);
		this.setPrefHeight(height);
		//this.setBackground(new Background(new BackgroundFill(Color.BLUE,null,null)));
		this.setStyle("-fx-background-image: url('wallbackground.jpg');");

		animalchannel1 = new AnimalChannel1(width*3/10 , height);
		animalchannel2 = new AnimalChannel2(width*3/10, height);
		pointchannel1 = new PointChannel(width/10, height);
		pointchannel2 = new PointChannel(width/10, height);
		timechannel = new TimeChannel(Integer.toString(SimulationManager.getIngametime()), width/5, height);
		
		this.getChildren().addAll(animalchannel1 , pointchannel1, timechannel,pointchannel2, animalchannel2);
		
	}
	
	public void paintComponent() {
		timechannel.setText(Integer.toString(SimulationManager.getIngametime()));
		animalchannel1.paintComponent();
		animalchannel2.paintComponent();
	}
	
}
