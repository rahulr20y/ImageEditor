package imageEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EffectsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EffectsPanel(newCanvas canvas) {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		

		JLabel lblEffects = new JLabel("Effects");
		//lblEffects.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEffects.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEffects.setForeground(Color.ORANGE);
		this.add(lblEffects);
		
		ButtonGroup effectsRbg = new ButtonGroup();
		
		JRadioButton originalRb=new JRadioButton("Original"); 
		originalRb.setBackground(Color.DARK_GRAY);
		originalRb.setForeground(Color.WHITE);
		effectsRbg.add(originalRb);
		this.add(originalRb);
		JRadioButton grayscaleRb=new JRadioButton("Gray Scale");
		grayscaleRb.setBackground(Color.DARK_GRAY);
		grayscaleRb.setForeground(Color.WHITE);
		effectsRbg.add(grayscaleRb);
		this.add(grayscaleRb);
		JRadioButton negativeRb=new JRadioButton("Negative");
		negativeRb.setBackground(Color.DARK_GRAY);
		negativeRb.setForeground(Color.WHITE);
		effectsRbg.add(negativeRb);
		this.add(negativeRb);
		JRadioButton sepiaRb=new JRadioButton("Sepia");
		sepiaRb.setBackground(Color.DARK_GRAY);
		sepiaRb.setForeground(Color.WHITE);
		effectsRbg.add(sepiaRb);
		this.add(sepiaRb);
		effectsRbg.setSelected(originalRb.getModel(), true);
		
		originalRb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setImage(Interface.img);
				canvas.update(canvas.getGraphics());
			}
		});
		
		grayscaleRb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setImage(EffectApplier.getGrayscale(Interface.img));
				canvas.update(canvas.getGraphics());
			}
		});
		
		negativeRb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setImage(EffectApplier.getNegative(Interface.img));
				canvas.update(canvas.getGraphics());
			}
		});
		
		sepiaRb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.setImage(EffectApplier.getSepia(Interface.img));
				canvas.update(canvas.getGraphics());
			}
		});


	}

}
