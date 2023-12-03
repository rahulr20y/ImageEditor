package imageEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JSlider;

public class rgbAmplifier {
	JSlider rSlider;
	JSlider gSlider;
	JSlider bSlider;
	JSlider tSlider;
	CustomImage img;
	
	rgbAmplifier(JSlider rSlider, JSlider gSlider, JSlider bSlider,CustomImage img){
		this.rSlider = rSlider;
		this.gSlider = gSlider;
		this.bSlider = bSlider;
		this.img = img;
	}
	
	rgbAmplifier(JSlider tSlider,CustomImage img2){
		this.tSlider = tSlider;
		this.img = img2;
	}
	
	public CustomImage transRender() {
		CustomImage img2 = new CustomImage(img.getWidth(), img.getHeight(), CustomImage.TYPE_INT_RGB);
		Graphics g = img2.getGraphics();
		for (int y = 0; y < img2.getHeight(); y++) {
			for (int x = 0; x < img2.getWidth(); x++) {
				Color tc = new Color(img.getRGB(x, y));
				int newalpha = (int)maxLock((float)(tSlider.getValue()/100f) * (tc.getAlpha()/255f));
	            int newcolor = (newalpha<<24) | (tc.getRed()<<16) | (tc.getBlue()<<8) | tc.getBlue();
	            img2.setRGB(x, y, newcolor);  
			}
		}
		return img2;
	}
	
	public float maxLock(float val) {
		if(val>1) return 1f;
		return val;
	}
	
	
	public CustomImage rgbRender() {
		CustomImage img2 = new CustomImage(img.getWidth(), img.getHeight(), CustomImage.TYPE_INT_RGB);
		Graphics g = img2.getGraphics();
		for (int y = 0; y < img2.getHeight(); y++) {
			for (int x = 0; x < img2.getWidth(); x++) {
				Color tc = new Color(img.getRGB(x, y));
				float tr = maxLock((float)(rSlider.getValue()/100f) * (tc.getRed()/255f));
				float tg = maxLock((float)(gSlider.getValue()/100f) * (tc.getGreen()/255f));
				float tb = maxLock((float)(bSlider.getValue()/100f) * (tc.getBlue()/255f));
				float[] vals = Color.RGBtoHSB(tc.getRed(), tc.getGreen(), tc.getBlue(), null);
				boolean rgb = true;
				Color newc = null;
				if (rgb == true) {
					newc = new Color((int) (tr * 255f), (int) (tg * 255f), (int) (tb * 255f));
				} else {
					//newc = new Color(
						//	Color.HSBtoRGB(gd1.evaluate(vals[0]), gd2.evaluate(vals[1]), gd3.evaluate(vals[2])));
				}
				g.setColor(newc);
				g.fillRect(x, y, 1, 1);
			}
		}
		return img2;
	}
}
