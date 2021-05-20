package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class HowToPlayPane extends StackPane {
	
	private VBox player;
	private HBox player1;
	private HBox player2;
	private Label instruction11;
	private Label instruction12;
	private Label instruction21;
	private Label instruction22;
	private ImageView playerOneImgv;
	private ImageView playerTwoImgv;
	private Button backBtn;
	

	public HowToPlayPane() {
		super();
		this.setStyle("-fx-background-image: url('woodbackground.jpg'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 800 600;");
		
		loadResource();
		initializePlayerOneBox();
		initializePlayerTwoBox();
		initializeBackButton();
		initializePlayerBox();
		
		this.getChildren().addAll(player);
	}

	public void loadResource(){
		playerOneImgv =  new ImageView(new Image(ClassLoader.getSystemResource("adventurerSprite/Idle (1).png").toString() , 80 , 600/8 , false , true)) ;
		playerTwoImgv =  new ImageView(new Image(ClassLoader.getSystemResource("adventurerSprite/Idle (1).png").toString() , 80 , 600/8 , false , true)) ;
		playerTwoImgv.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
	}
	
	public void initializePlayerBox() {
		player = new VBox(30);
		player.setPadding(new Insets(50,20, 50, 20));
		player.setAlignment(Pos.TOP_CENTER);
		player.getChildren().addAll(player1 , player2,backBtn);
	}
	
	public void initializePlayerOneBox(){
		player1 = new HBox(20);
		player1.setStyle("-fx-background-image: url('howtoplaypaper.png'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 700 200;");
		player1.setPrefSize(700, 200);
		player1.setAlignment(Pos.CENTER);
		
		instruction11 = new Label("Player1\nW : go up\nS : go down\nSPACE BAR : release monster");
		SimulationManager.setFont( (Label) instruction11 , 20);
		
		instruction12 = new Label("\n1 : select slot1\n2 : select slot2\n3 : select slot3");
		SimulationManager.setFont( (Label) instruction12 , 20);
		
		player1.getChildren().addAll(playerOneImgv , instruction11 , instruction12);
	}
	
	public void initializePlayerTwoBox(){
		
		player2 = new HBox(20);
		player2.setStyle("-fx-background-image: url('howtoplaypaper.png'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 700 200;");
		player2.setPrefSize(700, 200);
		player2.setAlignment(Pos.CENTER);
		
		instruction21 = new Label("Player2\nW : go up\nS : go down\nSPACE BAR : release monster");
		SimulationManager.setFont( (Label) instruction21 , 20);
		
		instruction22 = new Label("\n+ : select slot1\n- : select slot2\n0 : select slot3");
		SimulationManager.setFont( (Label) instruction22 , 20);
		
		player2.getChildren().addAll(instruction21 , instruction22 , playerTwoImgv);
	}
	
	public void initializeBackButton() {
		backBtn = new Button("Back");
		SimulationManager.setFont((Button) backBtn, 20);
	}
	
	public Button getBackBtn() {
		return backBtn;
	}
}


