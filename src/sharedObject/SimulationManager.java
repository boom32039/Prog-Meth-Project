package sharedObject;

import java.util.ArrayList;

public class SimulationManager {
	
	private static int ingametime = 180;
	private static boolean isReleased1 = false;
	private static boolean isReleased2 = false;
	private static int isSelected1;
	private static int isSelected2;
	private static int XP1;
	private static ArrayList<Integer> YP1 = new ArrayList<>();
	private static int XP2;
	private static ArrayList<Integer> YP2 = new ArrayList<>();
	private static int coins1 = 0;
	private static int coins2 = 0;
	private static int points1 = 0;
	private static int points2 = 0;
	
	public static int getCoins1() {
		return coins1;
	}

	public static int getCoins2() {
		return coins2;
	}

	public static void setCoins1Increase() {
		coins1 += 2;
	}
	
	public static void setCoins2Increase() {
		coins2 += 2;
	}
	
	public static void setPoints1Increase() {
		points1++;
	}
	
	public static void setPoints2Increase() {
		points2++;
	}
	
	public static int getIngametime() {
		return ingametime;
	}
	
	public static void setDecreaseIngametime() {
		SimulationManager.ingametime -= 1;
	}
	public static boolean isReleased1() {
		return isReleased1;
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
