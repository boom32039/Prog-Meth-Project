package gui;

import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class AnimalChannel2 extends AnimalChannel {

	public AnimalChannel2(double width, double height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		editImage();
		coinschannel.setText(Integer.toString(SimulationManager.getCoins2()));
		deckchannel.getChildren().addAll(card2 , card1 ,card0);
		this.getChildren().addAll( coinschannel, deckchannel);
	}

	public void checkSelected(){
		switch (RenderableHolder.isSelected2) {
			case 0:
				highlight(card0);
				unhighlight(card1);
				unhighlight(card2);
				break;
			case 1:
				highlight(card1);
				unhighlight(card0);
				unhighlight(card2);
				break;
			case 2:
				highlight(card2);
				unhighlight(card0);
				unhighlight(card1);
				break;
		}
	}
	
	public void arrangeDeck() {
		if (SimulationManager.isReleased2()) {
			editImage();
		}
		SimulationManager.setReleased2(false);
	}
	
	public void editImage() {
		card0.getChildren().clear();
		card1.getChildren().clear();
		card2.getChildren().clear();
		card0.getChildren().add(RenderableHolder.getCurrentImage20());
		card1.getChildren().add(RenderableHolder.getCurrentImage21());
		card2.getChildren().add(RenderableHolder.getCurrentImage22());
	}
	@Override
	public void paintComponent() {
		// TODO Auto-generated method stub
		coinschannel.setText(Integer.toString(SimulationManager.getCoins2()));
		super.paintComponent();
	}

}