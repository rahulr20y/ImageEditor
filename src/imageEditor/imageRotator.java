package imageEditor;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.image.Image;

public class imageRotator {
	CustomImage img;
	
	imageRotator(CustomImage img){
		this.img=img;
	}
	
	public CustomImage rotateLeft() {
		CustomImage newImg=new CustomImage( img.getHeight(), img.getWidth(), CustomImage.TYPE_INT_RGB);
		Graphics g = newImg.getGraphics();
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				Color tc = new Color(img.getRGB(x, y));
				g.setColor(tc);
				g.fillRect(img.getHeight()-y-1, x, 1, 1);
			}
		}
		return newImg;
	}
	
	public CustomImage rotateRight() {
		CustomImage newImg=new CustomImage( img.getHeight(), img.getWidth(), CustomImage.TYPE_INT_RGB);
		Graphics g = newImg.getGraphics();
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				Color tc = new Color(img.getRGB(x, y));
				g.setColor(tc);
				g.fillRect(y, img.getWidth()-x-1, 1, 1);
			}
		}
		return newImg;
	}
}
