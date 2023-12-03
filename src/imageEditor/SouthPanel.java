package imageEditor;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SouthPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SouthPanel(newCanvas canvas, JFrame frame) {
		this.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(this, BorderLayout.SOUTH);
	}

}
