package imageEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class EffectApplier {
	public static CustomImage getGrayscale(CustomImage img) {
		CustomImage newImg=new CustomImage(img.getWidth(), img.getHeight(), CustomImage.TYPE_INT_RGB);;
		Graphics g = newImg.getGraphics();
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				Color tc = new Color(img.getRGB(x, y));
				int avg = (tc.getRed()+tc.getBlue()+tc.getGreen())/3;
				Color newc = new Color(avg, avg, avg);;
				g.setColor(newc);
				g.fillRect(x, y, 1, 1);
			}
		}
		return newImg;
	}
	
	public static CustomImage getNegative(CustomImage img) {
		CustomImage newImg=new CustomImage(img.getWidth(), img.getHeight(), CustomImage.TYPE_INT_RGB);;
		Graphics g = newImg.getGraphics();
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				Color tc = new Color(img.getRGB(x, y));
				Color newc = new Color(255-tc.getRed(), 255-tc.getGreen(), 255-tc.getBlue());
				g.setColor(newc);
				g.fillRect(x, y, 1, 1);
			}
		}
		return newImg;
	}
	
	public static CustomImage getSepia(CustomImage img) {
		CustomImage newImg=new CustomImage(img.getWidth(), img.getHeight(), CustomImage.TYPE_INT_RGB);;
		Graphics g = newImg.getGraphics();
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				Color tc = new Color(img.getRGB(x, y));
				Color newc = sepiaColor(tc);
				g.setColor(newc);
				g.fillRect(x, y, 1, 1);
			}
		}
		return newImg;
	}
	
	public static Color sepiaColor(Color tc) {
		int red = (int) (0.393*tc.getRed() + 0.769*tc.getGreen() + 0.189*tc.getBlue());
		int green = (int) (0.349*tc.getRed() + 0.686*tc.getGreen() + 0.168*tc.getBlue());
		int blue = (int) (0.272*tc.getRed() + 0.534*tc.getGreen() + 0.131*tc.getBlue());
		red = (red>255?255:red);
		green = (green>255?255:green);
		blue = (blue>255?255:blue);
		return new Color(red, green, blue);
	}
}
