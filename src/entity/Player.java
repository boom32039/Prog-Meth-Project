package entity;

import java.util.Arrays;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import logic.PlayerField;
import sharedObject.RenderableHolder;

public class Player extends Entity{
	
	private int currentpos ;
	private int X,Y;
	private boolean[] pos = {false , false , false ,false , false};
	private boolean isPressed;
	
	public Player() {
		currentpos = 2;
		pos[currentpos] = true;
		isPressed = false;
		X = RenderableHolder.getXP1();
		Y = RenderableHolder.getYP1().get(currentpos);
		
	}
	
	@Override
	public void draw(GraphicsContext gc ) {
		// TODO Auto-generated method stub
		
		//WritableImage croppedImage = new WritableImage(RenderableHolder.playerSprite.getPixelReader(),50, 0, 
				//70, 60);
		// press -> released -> change pos
		/*for (int i = 0 ; i< pos.length ; i++) {
			if (pos[i] && isPressed) {
				setY(RenderableHolder.getYP1().get(i));
				isPressed = false;
				break;
			}
		}*/
		// press -> change pos -> release
		for (int i = 0 ; i < pos.length ; i++) {
			if (pos[i]) {
				setY(RenderableHolder.getYP1().get(i));
				break;
			}
		}
		gc.drawImage(RenderableHolder.playerSprite, X ,Y );
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		// press -> released -> change pos
		/*if (InputUtility.getKeyPressed(KeyCode.W) && !pos[0] ) {
			WPressed = true;
		} else if (InputUtility.getKeyPressed(KeyCode.S) && !pos[pos.length -1] ) {
			SPressed = true;
		}
		if (!InputUtility.getKeyPressed(KeyCode.W) && WPressed ) {
			pos[currentpos - 1] = true ;
			pos[currentpos] = false;
			currentpos -= 1;
			isPressed = true;
			WPressed = false;
		} else if (!InputUtility.getKeyPressed(KeyCode.S) && SPressed) {
			pos[currentpos + 1] = true;
			pos[currentpos] = false;
			currentpos += 1;
			isPressed = true;
			SPressed = false;
		}*/
		// press -> change pos -> release
		
		if (!InputUtility.getKeyPressed(KeyCode.W) && !InputUtility.getKeyPressed(KeyCode.S)) {
			isPressed = false;
		}
		if (InputUtility.getKeyPressed(KeyCode.W) && !pos[0] && !isPressed) {
			pos[currentpos - 1] = true ;
			pos[currentpos] = false;
			currentpos -= 1;
			isPressed = true;
		} else if (InputUtility.getKeyPressed(KeyCode.S) && !pos[pos.length -1] && !isPressed ) {
			pos[currentpos + 1] = true;
			pos[currentpos] = false;
			currentpos += 1;
			isPressed = true;
		}
	}
	
	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}


	public int getY() {
		return Y;
	}


	public void setY(int y) {
		Y = y;
	}

	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return visibility;
	}


	
	
	
}
