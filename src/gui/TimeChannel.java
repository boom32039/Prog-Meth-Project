package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class TimeChannel extends Label {

	public TimeChannel(String time , double  width, double height) {
		super(time);
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER);
		this.setFont(new Font("Latin", 50));
		SimulationManager.setFont(((Label) this) , 60);
		
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		//this.setBackground(new Background(new BackgroundFill(Color.DARKMAGENTA,null,null)));
	}
	
}
