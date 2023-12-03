package imageEditor;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import java.awt.Component;

public class SliderPanel extends JPanel {

	/**
	 * Create the panel.
	 ***/
	
	public SliderPanel(newCanvas canvas) {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		this.add(verticalGlue_1);
		
		//Heading
		JLabel slidersHeader = new JLabel("Adjust Colours ");
		slidersHeader.setForeground(Color.ORANGE);
		slidersHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
		this.add(slidersHeader);
		
		//Transparency Panel
		JPanel tPanel = new JPanel();
		tPanel.setBackground(Color.DARK_GRAY);
		tPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel tLabel = new JLabel("Transparency");
		tLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		tLabel.setForeground(Color.WHITE);
		tPanel.add(tLabel);
		JSlider tSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 100);
		tSlider.setName("transparencySlider");
		tSlider.setBackground(Color.DARK_GRAY);
		tPanel.add(tSlider);
		
		this.add(tPanel);
				
				
		//Red Panel
		JPanel rPanel = new JPanel();
		rPanel.setBackground(Color.DARK_GRAY);
		rPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		tPanel.add(new JSeparator());
		JLabel rLabel = new JLabel("Red");
		rLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		rLabel.setForeground(Color.RED);
		rPanel.add(rLabel);
		JSlider rSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 100);
		rSlider.setName("redSlider");
		rSlider.setBackground(Color.DARK_GRAY);
		rPanel.add(rSlider);
		
		this.add(rPanel);
		
		//Green Panel
		JPanel gPanel = new JPanel();
		gPanel.setBackground(Color.DARK_GRAY);
		gPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel gLabel = new JLabel("Green");
		gLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		gLabel.setForeground(Color.GREEN);
		gPanel.add(gLabel);
		JSlider gSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 100);
		gSlider.setName("greenSlider");
		gSlider.setBackground(Color.DARK_GRAY);
		gPanel.add(gSlider);
		
		this.add(gPanel);
		
		//Blue Panel
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.DARK_GRAY);
		bPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel bLabel = new JLabel("Blue");
		bLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		bLabel.setForeground(new Color(51, 102, 255));
		bPanel.add(bLabel);
		JSlider bSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 100);
		bSlider.setName("blueSlider");
		bSlider.setBackground(Color.DARK_GRAY);
		bPanel.add(bSlider);
		
		this.add(bPanel);
		
		//Actions
		tSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				rgbAmplifier amplifier = new rgbAmplifier(tSlider, Interface.img);
				CustomImage newimg = amplifier.transRender();
				canvas.setImage(newimg);
				canvas.update(canvas.getGraphics());
			}
		});
		
		rSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				rgbAmplifier amplifier = new rgbAmplifier(rSlider, bSlider, gSlider, Interface.img);
				CustomImage newimg = amplifier.rgbRender();
				canvas.setImage(newimg);
				canvas.update(canvas.getGraphics());
			}
		});
		
		gSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				rgbAmplifier amplifier = new rgbAmplifier(rSlider, bSlider, gSlider, Interface.img);
				CustomImage newimg = amplifier.rgbRender();
				canvas.setImage(newimg);
				canvas.update(canvas.getGraphics());
			}
		});
		
		bSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				rgbAmplifier amplifier = new rgbAmplifier(rSlider, bSlider, gSlider, Interface.img);
				CustomImage newimg = amplifier.rgbRender();
				canvas.setImage(newimg);
				canvas.update(canvas.getGraphics());
			}
		});
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		this.add(verticalGlue_2);

	}

}
