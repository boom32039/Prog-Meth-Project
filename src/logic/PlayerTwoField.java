package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class PlayerTwoField extends PlayerField{
	
	public PlayerTwoField(int width , int height) {
		super(width , height);
		X = width - (width/20+ width/10);
		Y = 3 * (height /15) + 2*(height/8);
		
		for (int i = 0 ; i <5 ; i++) {
			RenderableHolder.getYP2().add((i+1)*(this.height/15) + i*(this.height/8) );
		}
		
		RenderableHolder.setXP2(X);
	}
	
	public int getZ() {
		return Z;
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.YELLOW);
		
		double w = gc.getCanvas().getWidth();
		double h = gc.getCanvas().getHeight();
		
		for (int i = 0 ; i < 5 ; i++ ) {			
			gc.fillRoundRect( w - (w/20+ w/10), (i+1)*(h/15) + i*(h/8) , w/10, h/8, 30, 30);
		}

	}

	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return true;
	}
}
