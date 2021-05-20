package logic;

import java.util.ArrayList;
import java.util.List;

import entity.Barrel;
import entity.Entity;
import entity.PlayerOne;
import entity.PlayerTwo;
import entity.base.Monster;
import entity.base.Ninja;
import entity.base.Robot;
import entity.base.Santa;
import entity.base.Adventurer;
import entity.base.Knight;
import sharedObject.RenderableHolder;
import sharedObject.SimulationManager;

public class GameLogic {
	
	private List<Entity> gameObjectContainer;
	private PlayerOne playerOne;
	private Field field1;
	private PlayerField playerField1;
	
	private PlayerTwo playerTwo;
	private Field field2;
	private PlayerField playerField2;
	
	private Monster adventurer, knight , ninja , santa  , robot ;
	
	private Barrel barrel;
	
	public GameLogic() {
		
		gameObjectContainer = new ArrayList<Entity>();
		setupSharedField();
		
		adventurer = new Adventurer("Adventurer" , 300 , 100 , 400 , 5);
		knight = new Knight("Knight" ,400 , 80 , 50 , 10 );
		ninja = new Ninja("Ninja", 200 , 20 , 30 ,1 );
		santa = new Santa("Santa" , 100 , 20 , 40 ,7);
		robot = new Robot("Robot" , 50 , 20 , 60 , 10);
		
		RenderableHolder.loadMap();
		
		playerField1 = new PlayerOneField(800, 500);
		playerField2 = new PlayerTwoField(800, 500);
		playerOne = new PlayerOne(knight , adventurer , ninja ,santa , robot );
		playerTwo = new PlayerTwo(knight , adventurer , ninja ,santa , robot );
		
		
		
		RenderableHolder.setCurrentImage10(RenderableHolder.getAnimalImage1(knight.getName()));
		RenderableHolder.setCurrentImage11(RenderableHolder.getAnimalImage1(adventurer.getName()));
		RenderableHolder.setCurrentImage12(RenderableHolder.getAnimalImage1(ninja.getName()));
		
		RenderableHolder.setCurrentImage20(RenderableHolder.getAnimalImage2(knight.getName()));
		RenderableHolder.setCurrentImage21(RenderableHolder.getAnimalImage2(adventurer.getName()));
		RenderableHolder.setCurrentImage22(RenderableHolder.getAnimalImage2(ninja.getName()));
		
		field1 = new Field();
		
		RenderableHolder.getInstance().add(field1);
		RenderableHolder.getInstance().add(playerField1);
		addNewObject(playerOne);
		
		field2 = new Field();
		
		RenderableHolder.getInstance().add(field2);
		RenderableHolder.getInstance().add(playerField2);
		addNewObject(playerTwo);
		
		barrel = new Barrel();
		RenderableHolder.getInstance().add(barrel);
		
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public void setupSharedField(){
		RenderableHolder.getInstance().getEntities().clear();
		SimulationManager.setGameEnd(false);
		SimulationManager.setBackToMenu(false);
	
		SimulationManager.setIsSelected1(0);
		SimulationManager.setPoints1(0);
		
		SimulationManager.setIsSelected2(0);
		SimulationManager.setPoints2(0);
	}
	
	public void logicUpdate(){
		checkGameEnd();
		if (!SimulationManager.isGameEnd()) {
			playerOne.update();
			playerTwo.update();
		} 
		
		barrel.update();
	}
	
	public void checkGameEnd() {
		// ingametime = 0
		if (SimulationManager.getIngametime() == 0) {
			SimulationManager.setGameEnd(true);
			if (SimulationManager.getPoints1() == SimulationManager.getPoints2()) {
				SimulationManager.setGameresult("DRAW!!");
			} else if (SimulationManager.getPoints1() > SimulationManager.getPoints2()) {
				SimulationManager.setGameresult("PLAYER 1 WIN!!");
			} else if (SimulationManager.getPoints1() < SimulationManager.getPoints2()) {
				SimulationManager.setGameresult("PLAYER 2 WIN!!");
			}
			SimulationManager.setGameEnd(true);
		// player 1 win
		} else if (SimulationManager.getPoints1() == 3) {
			SimulationManager.setGameresult("PLAYER 1 WIN!!");
			SimulationManager.setGameEnd(true);
		// player 2 win
		} else if (SimulationManager.getPoints2() == 3) {
			SimulationManager.setGameresult("PLAYER 2 WIN!!");
			SimulationManager.setGameEnd(true);
		}
		
	}

}
