package entity;

import java.util.Arrays;

import entity.base.Monster;
import input.InputUtility;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import logic.Deck;
import logic.PlayerOneField;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class PlayerOne extends Player{
	

	public PlayerOne(Monster ...monsters) {
		
		super(monsters);
		setX(SimulationManager.getXP1());
		setY(SimulationManager.getYP1().get(currentpos));
		up = KeyCode.W;
		down = KeyCode.S;
		choose0 = KeyCode.DIGIT1;
		choose1 = KeyCode.DIGIT2;
		choose2 = KeyCode.DIGIT3;
		releaseMonster = KeyCode.SPACE;
		/*System.out.println("start coins = " + coins);
		System.out.println("deck has " + deck.getDeckList().get(0).getName() 
				+" " + deck.getDeckList().get(1).getName() +" " + deck.getDeckList().get(2).getName());
		System.out.println(deck.getMonsterList().toString());*/
	}
	
	@Override
	public void draw(GraphicsContext gc ) {
		
		for (int i = 0 ; i < pos.length ; i++) {
			if (pos[i]) {
				setY(SimulationManager.getYP1().get(i));
				break;
			}
		}
		gc.drawImage(RenderableHolder.playerOneSprite, X ,Y );
	}
	
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		if (InputUtility.getKeyPressed(choose0)) {
			SimulationManager.setIsSelected1(0); 
		} else if (InputUtility.getKeyPressed(choose1)){
			SimulationManager.setIsSelected1(1); 
		} else if (InputUtility.getKeyPressed(choose2)) {
			SimulationManager.setIsSelected1(2); 
		}
		
	}

	@Override
	public boolean isMonsterReady() {
		// TODO Auto-generated method stub
		return super.isMonsterReady();
	}

	@Override
	public void releaseMonster() {
		// TODO Auto-generated method stub
		if (isMonsterReady()) {
			
			release = deck.removeMonster(SimulationManager.getIsSelected1());
			coins -= release.getCost();
			deck.addRandomMonster();
			deck.getMonsterList().add(release);
			checkDeck();
		}
	}

	public void checkDeck() {
		
		RenderableHolder.setCurrentImage10(RenderableHolder.getAnimalImage1(deck.getDeckList().get(0).getName()));
		RenderableHolder.setCurrentImage11(RenderableHolder.getAnimalImage1(deck.getDeckList().get(1).getName()));
		RenderableHolder.setCurrentImage12(RenderableHolder.getAnimalImage1(deck.getDeckList().get(2).getName()));
	}
	
	


	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return visibility;
	}


	
	
	
}
