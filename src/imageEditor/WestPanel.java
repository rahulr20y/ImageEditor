package imageEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.Box;

public class WestPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WestPanel(newCanvas canvas, JFrame frame) {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		frame.getContentPane().add(this, BorderLayout.WEST);
		

		Component verticalGlue_2 = Box.createVerticalGlue();
		this.add(verticalGlue_2);
		
		SliderPanel sliders = new SliderPanel(canvas);
		this.add(sliders);
		
		Component verticalGlue = Box.createVerticalGlue();
		this.add(verticalGlue);
		

		
		EffectsPanel effects = new EffectsPanel(canvas);
		this.add(effects);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		this.add(verticalGlue_1);
		
		
	}

}
