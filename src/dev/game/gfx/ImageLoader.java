package dev.game.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.awt.GraphicsConfiguration;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;

public class ImageLoader {
	private static final GraphicsConfiguration GFX_CONFIG = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

	private static BufferedImage toOptimisedImage(final BufferedImage image) {
		// if image is already compatible and optimized for current system settings, simply return it
		if (image.getColorModel().equals(GFX_CONFIG.getColorModel())) {
			return image;
		}

		// image is not optimized
		// createCompatibleImage: "The returned BufferedImage has a layout and color model that is closest to this native device configuration and can therefore be optimally blitted to this device."
		final BufferedImage new_image = GFX_CONFIG.createCompatibleImage(image.getWidth(), image.getHeight(), image.getTransparency());

		// get the graphics context of the new image to draw the old image on
		final Graphics2D g2d = (Graphics2D) new_image.getGraphics();

		// Drawing the old image and then disposing of it - I'm not sure why this helps.
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return new_image;
	}

	public static BufferedImage loadImage(String path) {
		BufferedImage bufimg;
		try {
			bufimg = ImageIO.read(ImageLoader.class.getResource(path));
			bufimg = toOptimisedImage(bufimg);
			return bufimg;
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	private static String index(int n){
		if (n < 0) {
			System.out.println("Error in animationHandler. Can't handle negative index.");
		}
		if (n >= 100) {
			return Integer.toString(n);
		} else if (n >= 10) {
			return "0" + n;
		} else {
			return "00" + n;
		}
	}

	public static BufferedImage[] loadImageArray(String folderLocation, String namePrefix, int numberOfImages) {
		//load all frames
		BufferedImage[] assets = new BufferedImage[numberOfImages];
		for (int i = 0; i < numberOfImages; i++) {
			assets[i] = ImageLoader.loadImage(folderLocation + "/" + namePrefix + index(i) + ".png");
		}
		return assets;
	}
}
