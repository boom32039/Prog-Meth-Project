package logic;

import java.util.ArrayList;
import java.util.List;

import entity.Entity;
import entity.Player;
import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	
	private Player player;

	public GameLogic(){
		this.gameObjectContainer = new ArrayList<Entity>();
		Field field = new Field();
		PlayerField playerField = new PlayerField(800, 600);
		player = new Player();
		RenderableHolder.getInstance().add(field);
		RenderableHolder.getInstance().add(playerField);
		addNewObject(player);
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public void logicUpdate(){
		player.update();
	}

}
