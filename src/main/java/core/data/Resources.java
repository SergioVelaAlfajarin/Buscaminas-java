package core.data;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public abstract class Resources {
	private static final String RSC_PATH = "src/main/resources/";
	private static final int IMG_WIDTH = 35, IMG_HEIGHT = 35;
	private static final HashMap<String, ImageIcon> imagesCache = new HashMap<>();


	public static ImageIcon getCellImage(ImageTypes img, int type) {
		File path = new File(RSC_PATH + img.getFileName(type));
		if(!path.exists() || path.isDirectory()){
			throw new RuntimeException("Error getting image from rsc.");
		}
		ImageIcon image = imagesCache.get(path.getAbsolutePath());
		return (image == null) ?
				getResizedImage(path) :
				image;
	}

	public static ImageIcon getCellImage(int surrMines, int type) {
		ImageTypes imgType = ImageTypes.getBySurroundedMines(surrMines);
		File path = new File(RSC_PATH + imgType.getFileName(type));
		if(!path.exists() || path.isDirectory()){
			throw new RuntimeException("Error getting image from rsc.");
		}
		ImageIcon image = imagesCache.get(path.getAbsolutePath());
		return(image == null) ?
				getResizedImage(path) :
				image;
	}

	private static ImageIcon getResizedImage(File f){
		try{
			BufferedImage originalImage = ImageIO.read(f);
			BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = resizedImage.createGraphics();
			graphics2D.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
			graphics2D.dispose();
			ImageIcon imageIcon = new ImageIcon(resizedImage);
			imagesCache.put(f.getAbsolutePath(),imageIcon);
			return imageIcon;
		}catch (IOException e){
			e.printStackTrace();
			Main.endGame(-1);
			return null;
		}
	}
}
