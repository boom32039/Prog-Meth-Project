package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Field;

public class RenderableHolder {
	
	private static final RenderableHolder instance = new RenderableHolder();
	public static Image playerSprite;
	private static int XP1;
	private static ArrayList<Integer> YP1 = new ArrayList<>();
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	
	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	
	public static void loadResource() {
		playerSprite = new Image(ClassLoader.getSystemResource("player.png").toString() , 80 , 600/8 , false , true);
	}
	
	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
		
	}
	
	public static void setXP1(int X) {
		XP1 = X;
	}
	
	public static int getXP1() {
		return XP1;
	}
	
	public static ArrayList<Integer> getYP1() {
		return YP1;
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
	
	

}
