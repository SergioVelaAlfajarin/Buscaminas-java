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

	/**
	 * Retrieves an img.
	 * @param img the type of image to retrieve.
	 * @param type the type of cell to choose. a number between 1 or 2
	 * @return a resized image
	 */
	public static ImageIcon getCellImage(ImageTypes img, int type) {
		File path = new File(RSC_PATH + img.getFileName(type));
		if(!path.exists() || path.isDirectory()){
			Main.forceExit("No se han encontrado las imagenes requeridas.");
		}
		ImageIcon image = imagesCache.get(path.getAbsolutePath());
		return (image == null) ?
				getResizedImage(path) :
				image;
	}

	/**
	 * Retrieves an img.
	 * @param surrMines used to get the image type required.
	 * @param type the type of cell to choose. a number between 1 or 2
	 * @return a resized image
	 */
	public static ImageIcon getCellImage(int surrMines, int type) {
		ImageTypes imgType = ImageTypes.getBySurroundedMines(surrMines);
		return getCellImage(imgType,type);
	}

	/**
	 * Retrieves a image, and then resizes it to the required size.
	 * @param f file pointing to the required image.
	 * @return a resized image based on location of f.
	 */
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
			Main.forceExit();
			return null;
		}
	}
}
