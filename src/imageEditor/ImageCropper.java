package imageEditor;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ImageCropper{

	int minX, minY, maxX, maxY;
	newCanvas canvas;
	CustomImage oImg;
	Rectangle rect;
	
	ImageCropper(newCanvas canvas){
		//System.out.println("here");
		this.canvas = canvas;
		canvas.cropImage();
		
	}
	
}
