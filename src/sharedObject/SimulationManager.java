package sharedObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.text.Font;

public class SimulationManager {
	
	private static int ingametime ;
	private static boolean isReleased1 ;
	private static boolean isReleased2 ;
	private static boolean isGameEnd ;
	private static boolean isBackToMenu;
	private static int isSelected1;
	private static int isSelected2;
	private static int XP1;
	private static ArrayList<Integer> YP1 = new ArrayList<>();
	private static int XP2;
	private static ArrayList<Integer> YP2 = new ArrayList<>();
	private static int coins1 ;
	private static int coins2 ;
	private static int points1 ;
	private static int points2 ;
	private static String gameResult;
	
	public static String fonturl = "src/Font/EmotionEngine-8ynA.ttf";
	
	public static void setFont(Labeled label , int size) {
		try {
			label.setFont(Font.loadFont(new FileInputStream(fonturl) , size));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getGameresult() {
		return gameResult;
	}

	public static void setGameresult(String gameresult) {
		SimulationManager.gameResult = gameresult;
	}

	public static int getCoins1() {
		return coins1;
	}

	public static int getCoins2() {
		return coins2;
	}

	public static void setCoins1(int coins1) {
		SimulationManager.coins1 = coins1;
	}

	public static void setCoins2(int coins2) {
		SimulationManager.coins2 = coins2;
	}

	public static void setPoints1(int points1) {
		SimulationManager.points1 = points1;
	}

	public static void setPoints2(int points2) {
		SimulationManager.points2 = points2;
	}
	
	
	public static int getPoints1() {
		return points1;
	}

	public static int getPoints2() {
		return points2;
	}

	public static int getIngametime() {
		return ingametime;
	}
	
	
	public static void setIngametime(int ingametime) {
		SimulationManager.ingametime = ingametime;
	}

	public static void setDecreaseIngametime() {
		SimulationManager.ingametime -= 1;
	}
	public static boolean isReleased1() {
		return isReleased1;
	}
	
	public static boolean isGameEnd() {
		return isGameEnd;
	}

	
	public static boolean isBackToMenu() {
		return isBackToMenu;
	}

	public static void setBackToMenu(boolean isBackToMenu) {
		SimulationManager.isBackToMenu = isBackToMenu;
	}

	public static void setGameEnd(boolean isGameEnd) {
		SimulationManager.isGameEnd = isGameEnd;
	}

	public static void setReleased1(boolean isReleased1) {
		SimulationManager.isReleased1 = isReleased1;
	}
	public static boolean isReleased2() {
		return isReleased2;
	}
	public static void setReleased2(boolean isReleased2) {
		SimulationManager.isReleased2 = isReleased2;
	}
	public static int getIsSelected1() {
		return isSelected1;
	}
	public static void setIsSelected1(int isSelected1) {
		SimulationManager.isSelected1 = isSelected1;
	}
	public static int getIsSelected2() {
		return isSelected2;
	}
	public static void setIsSelected2(int isSelected2) {
		SimulationManager.isSelected2 = isSelected2;
	}
	public static int getXP1() {
		return XP1;
	}
	public static void setXP1(int xP1) {
		XP1 = xP1;
	}
	public static ArrayList<Integer> getYP1() {
		return YP1;
	}
	public static void setYP1(ArrayList<Integer> yP1) {
		YP1 = yP1;
	}
	public static int getXP2() {
		return XP2;
	}
	public static void setXP2(int xP2) {
		XP2 = xP2;
	}
	public static ArrayList<Integer> getYP2() {
		return YP2;
	}
	public static void setYP2(ArrayList<Integer> yP2) {
		YP2 = yP2;
	}
	
	
}
