package entity.base;

import entity.Entity;
import sharedObject.RenderableHolder;

public abstract class Monster extends Entity {
	
	protected String name;
	protected int speed;
	protected int health;
	protected int cost;
	protected int attack;
	


	
	public Monster(String name , int health , int attack , int speed , int cost) {
		setName(name);
		sethealth(health);
		setAttack(attack);
		setSpeed(speed);
		setCost(cost);
	
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int gethealth() {
		return health;
	}


	public void sethealth(int health) {
		this.health = health;
	}
	
	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}
}
