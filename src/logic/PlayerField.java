package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class PlayerField implements IRenderable{
	
	private int X ,Y ,width , height;
	
	public PlayerField(int width , int height) {
		
		X = width /20;
		Y = 3 * (height /15) + 2*(height/8);
		this.width = width ;
		this.height = height;
		
		for (int i = 0 ; i <5 ; i++) {
			RenderableHolder.getYP1().add((i+1)*(this.height/15) + i*(this.height/8) );
		}

		RenderableHolder.setXP1(X);
	}
	
	public int getZ() {
		return -5000;
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.YELLOW);
		
		double w = gc.getCanvas().getWidth();
		double h = gc.getCanvas().getHeight();
		
		for (int i = 0 ; i < 5 ; i++ ) {
			gc.fillRoundRect(w/20 , (i+1)*(h/15) + i*(h/8) , w/10 , h/8 , 30 , 30);
			
			gc.fillRoundRect( w - (w/20+ w/10), (i+1)*(h/15) + i*(h/8) , w/10, h/8, 30, 30);
		}

	}

	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return true;
	}
}
