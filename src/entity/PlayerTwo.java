//à¸¢à¸±à¸‡à¹„à¸¡à¹ˆà¹„à¸”à¹‰à¹�à¸�à¹‰à¹„à¸£à¹€à¸¥à¸¢
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

public class PlayerTwo extends Player {
	
	public PlayerTwo(Monster ...monsters) {
		
		super(monsters);
		up = KeyCode.UP;
		down = KeyCode.DOWN;
		choose0 = KeyCode.EQUALS;
		choose1 = KeyCode.MINUS;
		choose2 = KeyCode.DIGIT0;
		releaseMonster = KeyCode.LEFT;
		setX(RenderableHolder.getXP2());
		setY(RenderableHolder.getYP2().get(currentpos));
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
				setY(RenderableHolder.getYP2().get(i));
				break;
			}
		}
		gc.drawImage(RenderableHolder.playerTwoSprite ,X ,Y);
	}
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		if (InputUtility.getKeyPressed(choose0)) {
			RenderableHolder.isSelected2 = 0 ;
		} else if (InputUtility.getKeyPressed(choose1)){
			RenderableHolder.isSelected2 = 1 ;
		} else if (InputUtility.getKeyPressed(choose2)) {
			RenderableHolder.isSelected2 = 2 ;
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
			release = deck.removeMonster(RenderableHolder.isSelected2);
			//System.out.println(release.getName());
			coins -= release.getCost();
			System.out.println("coins" + coins +" "+ "left");
			deck.addRandomMonster(); 
			//System.out.println(deck.getMonsterinDeckList(0).getName());
			//System.out.println(deck.getMonsterinDeckList(1).getName());
			//System.out.println(deck.getMonsterinDeckList(2).getName());
			deck.getMonsterList().add(release);
			//System.out.println(deck.getMonsterList().toString());
			//System.out.println("==========================");
			checkDeck();
			SimulationManager.setReleased2(true);
		}
	}

	public void checkDeck() {
		RenderableHolder.setCurrentImage20(RenderableHolder.getAnimalImage2(deck.getDeckList().get(0).getName()));
		RenderableHolder.setCurrentImage21(RenderableHolder.getAnimalImage2(deck.getDeckList().get(1).getName()));
		RenderableHolder.setCurrentImage22(RenderableHolder.getAnimalImage2(deck.getDeckList().get(2).getName()));
	}
	@Override
	public void startCooldownCount() {
		Thread thread = new Thread(() -> {
			
			for (int i = 0 ; i < 3; i++) {
				try {
					Thread.sleep(1000);
					cooldown--;
					RenderableHolder.progress2 += 100/3.0;
					
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			} 
		
		RenderableHolder.animalReady2 = true;
		});
		thread.start();
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
