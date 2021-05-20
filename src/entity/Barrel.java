package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.SimulationManager;

public class Barrel extends Entity {

	int damagedfrom1  ;
	int damagedfrom2 = 0;
	int X1;
	int width1;
	int X2;
	int width2;
	int breakvalue = 100;
	
	public Barrel() {
		// TODO Auto-generated constructor stub
		width1 = 100;
		X2 = 400;
		width2 = 100;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		gc.setFill(Color.GREEN);
		//gc.fillRect(300,200, width1, 20);
		gc.setFill(Color.RED);
		//gc.fillRect(X2, 200, width2, 20);
	}

	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		damagedfrom1 = 120 - SimulationManager.getIngametime();
		int dif = damagedfrom1 - damagedfrom2;
		width1 = 100 + ((dif*100) / breakvalue);
		X2 = 300 + width1;
		width2 = 200 - width1;
	}

}
