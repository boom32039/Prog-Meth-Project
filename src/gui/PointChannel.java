package gui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class PointChannel extends StackPane {

	public PointChannel(double width ,double height) {
		super();
		// TODO Auto-generated constructor stub
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setAlignment(Pos.CENTER);
		//this.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE,null,null)));
	}
	
}
