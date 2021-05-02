package logic;

import java.util.ArrayList;
import java.util.List;

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

public class GameLogic {
	
	private List<Entity> gameObjectContainer;
	private PlayerOne playerOne;
	private Field field1;
	private PlayerField playerField1;
	
	private PlayerTwo playerTwo;
	private Field field2;
	private PlayerField playerField2;
	
	private Monster adventurer, knight , ninja , santa  , robot  ;
	

	public GameLogic(){
		
		gameObjectContainer = new ArrayList<Entity>();
		
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
		
		
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public void logicUpdate(){
		playerOne.update();
		playerTwo.update();
	}

}
