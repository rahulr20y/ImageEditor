package imageEditor;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class newCanvas extends JPanel implements MouseMotionListener, MouseListener {
	CustomImage img, copyImg;
	int imgMinX, imgMinY, imgMaxX, imgMaxY, imgWidth, imgHeight;
	int rectStartX, rectStartY, rectStopX, rectStopY;
	boolean flag = false;
	
	newCanvas(){
		//this.setBackground(Color.LIGHT_GRAY);
		addMouseListener(this);
		addMouseMotionListener(this);
		rectStartX = rectStartY = Integer.MAX_VALUE;
		rectStopX = rectStopY = Integer.MIN_VALUE;
	}

	public void paint(Graphics g) {
		if(img!=null) {
			imgHeight = Math.min(getHeight(), img.getHeight());
			imgWidth = Math.min(getWidth(), img.getWidth());
			imgMinX = (getWidth() - imgWidth) / 2;
			imgMinY = (getHeight() - imgHeight) / 2;
			imgMaxX = imgMinX + imgWidth;
			imgMaxY = imgMinY + imgHeight;
			g.drawImage(img, imgMinX, imgMinY, imgWidth, imgHeight, this);
		}
	}

	public void setImage(CustomImage img) {
		this.img = img;
		this.copyImg = img;
	}

	public void update(Graphics g) {
		//this.setBackground(Color.LIGHT_GRAY);
		paint(g);
	}
	
	public void update() {
		paint(this.getGraphics());
	}

	CustomImage getImage() {
		return img;
	}
	
	public void clearImg() {
		this.paintComponent(this.getGraphics());
	}
	
	@Override
	public void paintComponent(Graphics g) {   
		super.paintComponent(g);
		//this.setBackground(Color.LIGHT_GRAY);
	}
	
	public CustomImage deepCopy(CustomImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 BufferedImage copy = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
		 CustomImage cop = new CustomImage(copy);
		 return cop;
	}
	
	//Mouse Commands
	@Override
	public void mouseClicked(MouseEvent me) {
		img.getGraphics().draw3DRect(this.img.getMinX(), this.img.getMinY(), this.img.getWidth()-1, this.img.getHeight()-2, true);
		this.update();
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		//System.out.println("Pressed:"+me.getX()+" "+me.getY());
		
		rectStartX = rectStopX = me.getX();
		rectStartY = rectStopY = me.getY();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		
		rectStopX = me.getX();
		rectStopY = me.getY();

		int rectMinX = Math.min(rectStartX, rectStopX);
		int rectMaxX = Math.max(rectStartX, rectStopX);
		int rectMinY = Math.min(rectStartY, rectStopY);
		int rectMaxY = Math.max(rectStartY, rectStopY);
		
		if(rectMinX>=imgMinX && rectMinY>=imgMinY && rectMaxX<=imgMaxX && rectMaxY<=imgMaxY) {
			this.img = Interface.img;
			this.img.getGraphics().drawRect(rectMinX-imgMinX, rectMinY-imgMinY, rectMaxX-rectMinX, rectMaxY-rectMinY);
			update();
		}
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		rectStopX = me.getX();
		rectStopY = me.getY();
		
		int rectMinX = Math.min(rectStartX, rectStopX);
		int rectMaxX = Math.max(rectStartX, rectStopX);
		int rectMinY = Math.min(rectStartY, rectStopY);
		int rectMaxY = Math.max(rectStartY, rectStopY);
		
		if(rectMinX>=imgMinX && rectMinY>=imgMinY && rectMaxX<=imgMaxX && rectMaxY<=imgMaxY) {
			//this.img.setData(copyImg.getData());
			this.img = deepCopy(copyImg);
			//this.img.getGraphics().draw3DRect(rectMinX-imgMinX, rectMinY-imgMinY, rectMaxX-rectMinX, rectMaxY-rectMinY, true);
			this.img.getGraphics().drawRect(rectMinX-imgMinX, rectMinY-imgMinY, rectMaxX-rectMinX, rectMaxY-rectMinY);
			update();
			//repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	void cropImage(){
		int rectMinX = Math.min(rectStartX, rectStopX);
		int rectMaxX = Math.max(rectStartX, rectStopX);
		int rectMinY = Math.min(rectStartY, rectStopY);
		int rectMaxY = Math.max(rectStartY, rectStopY);
		
		//if(rectMinX>=imgMinX && rectMinY>=imgMinY && rectMaxX<=imgMaxX && rectMaxY<=imgMaxY) {
			//System.out.println("pressed");
			int x = rectMinX - imgMinX;
			int y = rectMinY - imgMinY;
			int w = rectMaxX - rectMinX;
			int h = rectMaxY - rectMinY;
			
			if(rectMinX>=imgMinX && rectMinY>=imgMinY && rectMaxX<=imgMaxX && rectMaxY<=imgMaxY) {
				this.clearImg();
				//System.out.println("x : "+x+", y : "+y+", w : "+w+", h : "+h);
				setImage(new CustomImage(copyImg.getSubimage(x, y, w, h)));
				update();
			}
		//}
	}

}
