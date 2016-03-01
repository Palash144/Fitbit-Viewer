package ca.uwo.csd.cs2212.team09;

import java.awt.Color;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 * Implements the utility of the panels including buttons and style
 * @author Team 9
 *
 */
public class Utils {
	
	/** Sets the style/colouring of the button
	 * @param btn button to be adjusted
	 */
	public static void styleButton(JLabel btn) {
		btn.setOpaque(true);
		btn.setBackground(normalButtonColor());
		btn.setForeground(new Color(51, 51, 51));
	}
	
	/** Sets the style/background of the panel
	 * @param panel the panel to be adjusted
	 */
	public static void stylePanel(JPanel panel) {
		panel.setBackground(normalButtonColor());
	}
	
	/** Create a square style button
	 * @param btn
	 * @param image
	 * @param sideLength
	 */
	public static void styleSquareImageButton(JLabel btn, Image image, int sideLength) {
		ImageIcon icon = new ImageIcon(image.getScaledInstance(sideLength, sideLength, java.awt.Image.SCALE_SMOOTH));
		btn.setIcon(icon);
	}
	
	/**
	 * Stores the colour of default buttons
	 * @return the colour of the normal buttons
	 */
	public static Color normalButtonColor() {
		return new Color(166, 171, 173);
	}

}
