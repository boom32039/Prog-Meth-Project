package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.media.AudioClip;
import logic.Field;

public class RenderableHolder {
	
	private static final RenderableHolder instance = new RenderableHolder();
	
	private static Map<String,ImageView> map1 = new HashMap<String,ImageView>(); 
	private static Map<String,ImageView> map2 = new HashMap<String,ImageView>(); 
	public static Image playerOneSprite;
	public static Image playerTwoSprite;
	public static Image backgroundimg;
	public static Image wallbackground;
	
	private static Image adventurericon;
	private static Image knighticon;
	private static Image ninjaicon;
	private static Image santaicon;
	private static Image roboticon;
	
	public static WritableImage background;
	
	private static ImageView currentImage10;
	private static ImageView currentImage11;
	private static ImageView currentImage12;
	private static ImageView currentImage20;
	private static ImageView currentImage21;
	private static ImageView currentImage22;

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
		
		playerOneSprite = new Image(ClassLoader.getSystemResource("knightSprite/Idle (1).png").toString() , 80 , 600/8 , false , true);
		playerTwoSprite = new Image(ClassLoader.getSystemResource("knightSprite/Idle (1).png").toString() , 80 , 600/8 , true , true);
		
		adventurericon = new Image(ClassLoader.getSystemResource("adventurerSprite/Idle (1).png").toString() , 56 , 65 , false , true);
		knighticon = new Image(ClassLoader.getSystemResource("knightSprite/Idle (1).png").toString() , 56 , 65 , false , true);
		ninjaicon = new Image(ClassLoader.getSystemResource("ninjaSprite/Idle__000.png").toString() , 56 , 65 , false , true);
		santaicon = new Image(ClassLoader.getSystemResource("santaSprite/Idle (1).png").toString() , 56 , 65 , false , true);
		roboticon = new Image(ClassLoader.getSystemResource("robotSprite/Idle (1).png").toString() , 56 , 65 , false , true);
		
		backgroundimg = new Image(ClassLoader.getSystemResource("background.jpg").toString() );
		PixelReader croppedBackground = backgroundimg.getPixelReader();
		background = new WritableImage(croppedBackground, 0, (int) backgroundimg.getHeight()/5+100 , 800, 500);
		
		wallbackground = new Image(ClassLoader.getSystemResource("wallbackground.jpg").toString() , 800 , 65 , false , true);
	}
	
	public static void loadMap() {
		
		map1.put("Adventurer", new ImageView(adventurericon));
		map1.put("Knight", new ImageView(knighticon));
		map1.put("Ninja", new ImageView(ninjaicon));
		map1.put("Robot", new ImageView(roboticon));
		map1.put("Santa", new ImageView(santaicon));
		
		map2.put("Adventurer", new ImageView(adventurericon));
		map2.put("Knight", new ImageView(knighticon));
		map2.put("Ninja", new ImageView(ninjaicon));
		map2.put("Robot", new ImageView(roboticon));
		map2.put("Santa", new ImageView(santaicon));
		
	}
	
	public static ImageView getAnimalImage1(String name) {
		return map1.get(name);
	}
	
	public static ImageView getAnimalImage2(String name) {
		return map2.get(name);
	}
	
	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
		
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}

	public List<IRenderable> getEntities() {
		return entities;
	}

	public static ImageView getCurrentImage10() {
		return currentImage10;
	}

	public static void setCurrentImage10(ImageView currentImage10) {
		RenderableHolder.currentImage10 = currentImage10;
	}

	public static ImageView getCurrentImage11() {
		return currentImage11;
	}

	public static void setCurrentImage11(ImageView currentImage11) {
		RenderableHolder.currentImage11 = currentImage11;
	}

	public static ImageView getCurrentImage12() {
		return currentImage12;
	}

	public static void setCurrentImage12(ImageView currentImage12) {
		RenderableHolder.currentImage12 = currentImage12;
	}

	public static ImageView getCurrentImage20() {
		return currentImage20;
	}

	public static void setCurrentImage20(ImageView currentImage20) {
		RenderableHolder.currentImage20 = currentImage20;
	}

	public static ImageView getCurrentImage21() {
		return currentImage21;
	}

	public static void setCurrentImage21(ImageView currentImage21) {
		RenderableHolder.currentImage21 = currentImage21;
	}

	public static ImageView getCurrentImage22() {
		return currentImage22;
	}

	public static void setCurrentImage22(ImageView currentImage22) {
		RenderableHolder.currentImage22 = currentImage22;
	}
	
	

}
