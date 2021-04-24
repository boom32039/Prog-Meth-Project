package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MenuPane extends StackPane{
	private Button startBtn , optionBtn , quitBtn;
	
	public MenuPane() {
		super();
		Image background = new Image("forest.jpg");
		ImageView backgroundview = new ImageView(background);
		
		VBox menu = new VBox(100);
		menu.setPadding(new Insets(120,0,80,0));
		menu.setAlignment(Pos.TOP_CENTER);
		
		Text gametitle = new Text("Animal Fight!!");
		gametitle.setFont(Font.font("Verdana", FontWeight.BOLD , FontPosture.ITALIC, 80));
		gametitle.setFill(Color.CRIMSON);
		gametitle.setStroke(Color.BLACK);
		gametitle.setStrokeWidth(5);
		gametitle.setTextAlignment(TextAlignment.CENTER);
		
		VBox buttons = new VBox(35);
		buttons.setAlignment(Pos.CENTER);
		
		startBtn = new Button("Start");
		startBtn.setFont(Font.font(24));
		startBtn.setPrefWidth(200);
		
		optionBtn = new Button("Option");
		optionBtn.setFont(Font.font(24));
		optionBtn.setPrefWidth(200);
		
		quitBtn = new Button("Quit");
		quitBtn.setFont(Font.font(24));
		quitBtn.setPrefWidth(200);
		
		buttons.getChildren().addAll(startBtn , optionBtn , quitBtn);
		
		menu.getChildren().addAll(gametitle , buttons);
		
		this.getChildren().addAll(backgroundview , menu);
		
		
	}
	
	public Button getstartButton(){ 
		return startBtn;
	}

	public Button getoptionButton(){ 
		return optionBtn;
	}
	
	public Button getquitButton(){ 
		return quitBtn;
	}
	
}
