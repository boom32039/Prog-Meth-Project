package gui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.SimulationManager;

public class PointChannel extends Label {
	
	public PointChannel(double width ,double height) {
		super();
		// TODO Auto-generated constructor stub
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setAlignment(Pos.CENTER);
		SimulationManager.setFont( ((Label) this),  50);
		this.setText("a");
		this.setTextFill(Color.LINEN);
		//this.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE,null,null)));
	}
	
}
