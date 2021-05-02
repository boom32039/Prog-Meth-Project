package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public abstract class PlayerField implements IRenderable {

	protected int X, Y, Z = -5000, width, height;

	public PlayerField(int width , int height) {
		this.width = width;
		this.height = height;
	}

	public int getZ() {
		return Z;
	}

	public abstract void draw(GraphicsContext gc);

	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return true;
	}
}
