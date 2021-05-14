package gui;

import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class AnimalChannel1 extends AnimalChannel {

	public AnimalChannel1(double width, double height) {
		
		super(width, height);
		
		// TODO Auto-generated constructor stub
		//System.out.println(RenderableHolder.currentImage1);
		editImage();
		coinschannel.setText(Integer.toString(SimulationManager.getCoins1()));
		deckchannel.getChildren().addAll(card0 , card1 ,card2);
		this.getChildren().addAll( deckchannel, coinschannel);
	}

	public void checkSelected(){
		switch (SimulationManager.getIsSelected1()) {
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
	 
	
	public void editImage() {
		
		card0.getChildren().setAll(RenderableHolder.getCurrentImage10());
		card1.getChildren().setAll(RenderableHolder.getCurrentImage11());
		card2.getChildren().setAll(RenderableHolder.getCurrentImage12());
	}
	
	@Override
	public void paintComponent() {
		// TODO Auto-generated method stub
		coinschannel.setText(Integer.toString(SimulationManager.getCoins1()));
		super.paintComponent();
	}

}
