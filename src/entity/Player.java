package entity;

import java.util.Arrays;

import entity.base.Monster;
import input.InputUtility;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import logic.Deck;
import logic.PlayerField;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public abstract class Player extends Entity{
	
	protected int currentpos;
	protected int X,Y;
	protected boolean[] pos = {false , false , false ,false , false};
	protected boolean animalreleased;
	protected KeyCode up;
	protected KeyCode down;
	protected KeyCode releaseMonster;
	protected KeyCode choose0;
	protected KeyCode choose1;
	protected KeyCode choose2;
	protected int points;
	protected int coins;
	protected int cooldown; 
	protected Monster release;
	protected Deck deck;
	
	public Player(Monster ...monsters) {
		
		points = 0;
		cooldown = 0;
		coins = 100;
		deck = new Deck(monsters);
		currentpos = 2;
		pos[currentpos] = true;
		
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		//if (!InputUtility.getKeyPressed(up) && !InputUtility.getKeyPressed(down) && !InputUtility.getKeyPressed(KeyCode.SPACE)) {
			//isPressed = false;
		//}
		
		if (InputUtility.getKeyPressed(up) && !pos[0] ) {
			pos[currentpos - 1] = true ;
			pos[currentpos] = false;
			currentpos -= 1;
			
		} else if (InputUtility.getKeyPressed(down) && !pos[pos.length -1]  ) {
			pos[currentpos + 1] = true;
			pos[currentpos] = false;
			currentpos += 1;
		}
		
		if (InputUtility.getKeyPressed(releaseMonster)) {
			releaseMonster();
		}
		
		
		
		
	}
	
	public boolean isMonsterReady() {
		if (coins >= deck.getDeckList().get(SimulationManager.getIsSelected1()).getCost()) {
			
			return true;
		}
		return false;
	}
	
	public abstract void releaseMonster();
	
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

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return visibility;
	}


	
	
	
}
