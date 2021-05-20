package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;
import javafx.scene.paint.Color;

public class Field implements IRenderable {
	
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		
		gc.drawImage(RenderableHolder.background, 0 , 0 ,gc.getCanvas().getWidth() , gc.getCanvas().getHeight());
		
	}

	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return true;
	}
}
