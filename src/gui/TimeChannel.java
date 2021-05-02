package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.RenderableHolder;

public class TimeChannel extends Label {

	public TimeChannel(String time , double  width, double height) {
		super(time);
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER);
		this.setFont(new Font("Verdana", 50));
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		//this.setBackground(new Background(new BackgroundFill(Color.DARKMAGENTA,null,null)));
	}
	
}
