package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sharedObject.SimulationManager;

public class MenuPane extends StackPane{
	
	private Button startBtn , HowToPlayBtn , quitBtn;
	
	public MenuPane() {
		
		super();
		Image background = new Image("menubackground.jpg");
		ImageView backgroundview = new ImageView(background);
		this.setStyle("-fx-background-image: url('menubackground.jpg'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 800 600;");
		
		VBox menu = new VBox(50);
		menu.setPadding(new Insets(120,0,80,0));
		menu.setAlignment(Pos.TOP_CENTER);
		
		Image gametitle = new Image("gametitle.png");
		ImageView gametitleview = new ImageView(gametitle);
		
		/*Text gametitle = new Text("Animal Fight!!");

		Text gametitle = new Text("Animal Fight!!");

		Text gametitle = new Text("Animal Fight!!!");

		gametitle.setFont(Font.font("Verdana", FontWeight.BOLD , FontPosture.ITALIC, 80));
		gametitle.setFill(Color.WHITESMOKE);
		gametitle.setStroke(Color.BLACK);

		gametitle.setStrokeWidth(5);
		gametitle.setTextAlignment(TextAlignment.CENTER);*/

		VBox buttons = new VBox(35);
		buttons.setAlignment(Pos.CENTER);
		
		startBtn = new Button("Start");
		startBtn.setPrefWidth(200);
		//startBtn.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE,CornerRadii.EMPTY,null )));
		
		setFont(startBtn);
		
		
		HowToPlayBtn = new Button("How to play");
		HowToPlayBtn.setPrefWidth(200);
		setFont(HowToPlayBtn);
		
		quitBtn = new Button("Quit");
		quitBtn.setPrefWidth(200);
		setFont(quitBtn);
		
		buttons.getChildren().addAll(startBtn , HowToPlayBtn , quitBtn);
		
		menu.getChildren().addAll( gametitleview ,buttons);
		
		this.getChildren().addAll( menu);
		
	}
	
	public void setFont(Button button) {
		try {
			button.setFont(Font.loadFont(new FileInputStream(SimulationManager.fonturl) , 30));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Button getstartButton(){ 
		return startBtn;
	}

	public Button getHowToPlayButton(){ 
		return HowToPlayBtn;
	}
	
	public Button getquitButton(){ 
		return quitBtn;
	}
	
}
