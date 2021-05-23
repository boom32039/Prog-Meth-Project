package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import sharedObject.SimulationManager;

public class MenuPane extends VBox {

	// ------------------------------ FIELD ------------------------------ //

	private ImageView gametitleview;
	private VBox buttonPane;
	private Button startBtn, HowToPlayBtn, quitBtn;

	// ------------------------------ CONSTRUCTOR ------------------------------ //

	public MenuPane() {
		// initialize all child node and add to parent
		super(30);
		setPadding(new Insets(120, 0, 80, 0));
		setAlignment(Pos.TOP_CENTER);
		this.setStyle(
				"-fx-background-image: url('menubackground.jpg'); -fx-background-repeat: stretch; -fx-background-position: center center; -fx-background-size: 800 600;");

		initGameTitle();
		initButtonPane();

		this.getChildren().addAll(gametitleview, buttonPane);
	}

	// ------------------------------ METHOD ------------------------------ //

	public void initButtonPane() {
		// initialize button pane , start button , how-to-play button and quit button
		buttonPane = new VBox(35);
		buttonPane.setAlignment(Pos.CENTER);
		
		startBtn = new Button("Start");
		startBtn.setPrefWidth(200);
		
		
		
		SimulationManager.setFont((Button) startBtn, 30);

		HowToPlayBtn = new Button("How to play");
		HowToPlayBtn.setPrefWidth(200);
		SimulationManager.setFont((Button) HowToPlayBtn, 30);

		quitBtn = new Button("Quit");
		quitBtn.setPrefWidth(200);
		SimulationManager.setFont((Button) quitBtn, 30);

		buttonPane.getChildren().addAll(startBtn, HowToPlayBtn, quitBtn);
	}

	public void initGameTitle() {
		// initialize gametitleview
		gametitleview = new ImageView(new Image("gameTitle.png"));
	}

	// ------------------------------ GETTER,SETTER ------------------------------ //
	
	public Button getstartButton() {
		return startBtn;
	}

	public Button getHowToPlayButton() {
		return HowToPlayBtn;
	}

	public Button getquitButton() {
		return quitBtn;
	}

}