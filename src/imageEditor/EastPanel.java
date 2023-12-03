package imageEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EastPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EastPanel(newCanvas canvas, JFrame frame) {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		frame.getContentPane().add(this, BorderLayout.EAST);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		this.add(verticalGlue_1);
		
		JPanel rotatePanel = new JPanel();
		rotatePanel.setLayout(new FlowLayout());
		rotatePanel.setBackground(Color.DARK_GRAY);
		
		JButton leftRotate = new JButton("Rotate Left");
		leftRotate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imageRotator imgRotate = new imageRotator(Interface.img);
				canvas.clearImg();
				Interface.img = imgRotate.rotateLeft();
				canvas.setImage(Interface.img);
				canvas.update(canvas.getGraphics());
			}
		});
		rotatePanel.add(leftRotate);
		
		JButton rightRotate = new JButton("Rotate Right");
		rightRotate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imageRotator imgRotate = new imageRotator(Interface.img);
				canvas.clearImg();
				Interface.img = imgRotate.rotateRight();
				canvas.setImage(Interface.img);
				canvas.update(canvas.getGraphics());
			}
		});
		rotatePanel.add(rightRotate);

		rotatePanel.setSize(100, 40);
		this.add(rotatePanel);
		
		
		JPanel cropPanel = new JPanel();
		cropPanel.setLayout(new FlowLayout());
		cropPanel.setBackground(Color.DARK_GRAY);
		
		JButton cropButton = new JButton("Crop");
		cropButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ImageCropper imageCropper = new ImageCropper(canvas);
				canvas.cropImage();
			}
		});
		cropPanel.add(cropButton);
		
		this.add(cropPanel);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		this.add(verticalGlue_2);
		
	}

}
