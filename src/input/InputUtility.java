package input;

import java.util.ArrayList;
import javafx.scene.input.KeyCode;

public class InputUtility {
	
	private static ArrayList<KeyCode> keyPressed = new ArrayList<>(); 
	
	
	public static boolean getKeyPressed(KeyCode keycode) {
		boolean trigger = keyPressed.contains(keycode);
		keyPressed.remove(keycode);
		return trigger;
	}
	
	public static void setKeyPressed(KeyCode keycode,boolean pressed) {
		if(pressed){
			if(!keyPressed.contains(keycode) ){
				keyPressed.add(keycode);
				
			}
		}else{
			keyPressed.remove(keycode);
			
		}
	}
	
}
