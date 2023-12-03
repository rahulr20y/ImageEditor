package imageEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NorthPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public NorthPanel(newCanvas canvas, JFrame frame) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		this.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(this, BorderLayout.NORTH);
		
		JButton newImgbtn = new JButton("New");
		newImgbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// canvas.update(canvas.getGraphics());
				BufferedImage newImg = null;
				try {
					newImg = ImageIO.read(FileChooser.selectImg(frame));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}
				if (newImg != null) {
					canvas.clearImg();
					CustomImage cImg = new CustomImage(newImg);
					Interface.img = cImg;
				}
				canvas.setImage(Interface.img);
				canvas.update(canvas.getGraphics());
			}
		});
		this.add(newImgbtn);
		
		JButton addImgbtn = new JButton("Add");
		addImgbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage newImg = null;
				try {
					newImg = ImageIO.read(FileChooser.selectImg(frame));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}
				if (newImg != null) {
					CustomImage cImg = new CustomImage(newImg);
					Interface.img = cImg;
				}
				canvas.setImage(Interface.img);
				canvas.update(canvas.getGraphics());
			}
		});
		this.add(addImgbtn);

		JButton undobtn = new JButton("Undo");
		undobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.add(undobtn);
		
		JButton resetbtn = new JButton("Reset");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.add(resetbtn);
		
		JButton savebtn = new JButton("Save");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.add(savebtn);

	}

}
