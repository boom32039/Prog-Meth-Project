package entity;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{
	
	protected int z;
	protected boolean visibility;
	
	public Entity() {
		visibility = true;
		z = 100;
	}
	
	public int getZ() {
		return z;
	}
	
	public boolean isVisible() {
		return visibility;
	}
	
	public abstract void update();
	
	
	
}
