package entity.base;

import javafx.scene.canvas.GraphicsContext;

public class Knight extends Monster {
	
	
	public Knight(String name , int health , int attack , int speed , int cost) {
		super(name , health , attack , speed , cost);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
