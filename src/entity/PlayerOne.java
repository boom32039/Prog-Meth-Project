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
		setX(RenderableHolder.getXP1());
		setY(RenderableHolder.getYP1().get(currentpos));
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
				setY(RenderableHolder.getYP1().get(i));
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
			RenderableHolder.isSelected1 = 0 ;
		} else if (InputUtility.getKeyPressed(choose1)){
			RenderableHolder.isSelected1 = 1 ;
		} else if (InputUtility.getKeyPressed(choose2)) {
			RenderableHolder.isSelected1 = 2 ;
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
			release = deck.removeMonster(RenderableHolder.isSelected1);
			//System.out.println(release.getName());
			coins -= release.getCost();
			//System.out.println("coins" + coins +" "+ "left");
			deck.addRandomMonster(); 
			//System.out.println(deck.getMonsterinDeckList(0).getName());
			//System.out.println(deck.getMonsterinDeckList(1).getName());
			//System.out.println(deck.getMonsterinDeckList(2).getName());
			deck.getMonsterList().add(release);
			//System.out.println(deck.getMonsterList().toString());
			//System.out.println("==========================");
			checkDeck();
			SimulationManager.setReleased1(true);

		}
	}

	public void checkDeck() {
		
		RenderableHolder.setCurrentImage10(RenderableHolder.getAnimalImage1(deck.getDeckList().get(0).getName()));
		RenderableHolder.setCurrentImage11(RenderableHolder.getAnimalImage1(deck.getDeckList().get(1).getName()));
		RenderableHolder.setCurrentImage12(RenderableHolder.getAnimalImage1(deck.getDeckList().get(2).getName()));
		
	}
	
	public void startCooldownCount() {
		
		Thread thread = new Thread(() -> {
			
			for (int i = 0 ; i < 3; i++) {
				try {
					Thread.sleep(1000);
					cooldown--;
					RenderableHolder.progress1 += 100/3.0;
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			} 
		
		RenderableHolder.animalReady1 = true;
		

		});
		thread.start();
	}


	@Override
	public boolean isVisble() {
		// TODO Auto-generated method stub
		return visibility;
	}


	
	
	
}
