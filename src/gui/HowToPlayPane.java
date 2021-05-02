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

public class HowToPlayPane extends StackPane {
	private Button backBtn;

	public HowToPlayPane() {
		super();
		Image background = new Image("forest.jpg");
		ImageView backgroundview = new ImageView(background);

		VBox howToPlay = new VBox(100);
		howToPlay.setPadding(new Insets(120, 0, 80, 0));
		howToPlay.setAlignment(Pos.TOP_CENTER);

		Text howToPlayTitle = new Text("How to play this game ?");
		howToPlayTitle.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 45));
		howToPlayTitle.setFill(Color.WHITESMOKE);
		howToPlayTitle.setStroke(Color.BLACK);
		howToPlayTitle.setStrokeWidth(2);
		howToPlayTitle.setTextAlignment(TextAlignment.CENTER);

		Text howToPlayTitle01 = new Text("W --> go up\nS --> go down\nSpace Bar --> release the animal.");
		howToPlayTitle01.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 30));
		howToPlayTitle01.setFill(Color.WHITESMOKE);
		howToPlayTitle01.setStroke(Color.BLACK);
		howToPlayTitle01.setStrokeWidth(1);
		howToPlayTitle01.setTextAlignment(TextAlignment.CENTER);

		VBox buttons = new VBox(35);
		buttons.setAlignment(Pos.CENTER);

		backBtn = new Button("Back");
		backBtn.setFont(Font.font(24));
		backBtn.setPrefWidth(200);

		buttons.getChildren().add(backBtn);

		howToPlay.getChildren().addAll(howToPlayTitle, howToPlayTitle01, buttons);

		this.getChildren().addAll(backgroundview, howToPlay);
	}

	public Button getBackButton() {
		return backBtn;
	}
}