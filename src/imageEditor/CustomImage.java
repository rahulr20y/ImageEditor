package imageEditor;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class CustomImage extends BufferedImage implements MouseMotionListener, MouseListener {

	public CustomImage(int width, int height, int imageType) {
		super(width, height, imageType);
		//addMouseListener(this);
		this.setData(super.getData());
		// TODO Auto-generated constructor stub
	}
	
	public CustomImage(BufferedImage bImg) {
		super(bImg.getWidth(), bImg.getHeight(), bImg.getType());
		this.setData(bImg.getData());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseDragged");
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseMoved");
	}
	

}
