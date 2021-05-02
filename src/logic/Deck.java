package logic;

import java.util.ArrayList;
import java.util.Random;

import entity.base.Monster;
import sharedObject.RenderableHolder;

public class Deck {
	
	private ArrayList<Monster> monsterList = new ArrayList<>();
	private ArrayList<Monster> deckList = new ArrayList<>();
	
	public Deck(Monster[] monsters) {
		
		for (int i = 0 ; i<3 ; i++) {
			deckList.add(monsters[i]);
		}
		for (int j = 3;  j<monsters.length ; j++) {
			monsterList.add(monsters[j]);
		}
	}
	
	public Monster getMonsterinDeckList(int i) {
		return deckList.get(i);
	}
	
	public void addRandomMonster() {
		Random rand = new Random(); 
		int value = rand.nextInt(monsterList.size()); 
		deckList.add(monsterList.get(value));
		monsterList.remove(monsterList.get(value));
	}
	
	
	public Monster removeMonster(int i) {
	
		Monster removal = deckList.get(i);
		deckList.remove(i);
		return removal; 
		
	}

	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(ArrayList<Monster> MonsterList) {
		monsterList = monsterList;
	}

	public ArrayList<Monster> getDeckList() {
		return deckList;
	}

	public void setDeckList(ArrayList<Monster> deckList) {
		deckList = deckList;
	}
	
	
}
