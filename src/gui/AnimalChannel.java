package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public abstract class AnimalChannel extends HBox {
	
	protected HBox deckchannel;
	protected Label coinschannel;
	protected StackPane card0 , card1 ,card2 ;
	protected boolean change = false;
	
	
	public AnimalChannel(double width, double height) {

		this.setWidth(width);
		//this.setHeight(height);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setAlignment(Pos.CENTER);
		//this.setBackground(new Background(new BackgroundFill(Color.AQUA,null,null)));
		
		deckchannel = new HBox();
		coinschannel = new Label();
		
		card0 = new StackPane();
		card1 = new StackPane();
		card2 = new StackPane();
		
		deckchannel.setPrefWidth(width * 0.7);
		deckchannel.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
		
		card0.setPrefWidth(width*0.7/3);
		card0.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
		card0.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderStroke.MEDIUM)));
		
		
		card1.setPrefWidth(width*0.7/3);
		card1.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
		card1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderStroke.MEDIUM)));
		
		card2.setPrefWidth(width*0.7/3);
		card2.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
		card2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderStroke.MEDIUM)));
		
		
		coinschannel.setPrefWidth(width * 0.3);
		//coinschannel.setBackground(new Background(new BackgroundFill(Color.BISQUE,null,null)));
		SimulationManager.setFont(coinschannel, 30);
		coinschannel.setAlignment(Pos.CENTER);
		
	}
	
	public void highlight(StackPane card) {
		card.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN,null,null)));
	}
	
	public void unhighlight(StackPane card) {
		card.setBackground(new Background(new BackgroundFill(Color.GRAY,null,null)));
	}
	 
	public abstract void checkSelected();
	
	public abstract void editImage();
	
	public void paintComponent() {
		editImage();
		checkSelected();
		
	}
	
}
