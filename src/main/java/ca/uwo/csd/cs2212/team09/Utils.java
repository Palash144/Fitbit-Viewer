package ca.uwo.csd.cs2212.team09;

import java.awt.Color;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author 
 *
 */
public class Utils {
	
	/**
	 * @param btn
	 */
	public static void styleButton(JLabel btn) {
		btn.setOpaque(true);
		btn.setBackground(normalButtonColor());
		btn.setForeground(new Color(51, 51, 51));
	}
	
	public static void stylePanel(JPanel panel) {
		panel.setBackground(normalButtonColor());
	}
	
	/**
	 * @param btn
	 * @param image
	 * @param sideLength
	 */
	public static void styleSquareImageButton(JLabel btn, Image image, int sideLength) {
		ImageIcon icon = new ImageIcon(image.getScaledInstance(sideLength, sideLength, java.awt.Image.SCALE_SMOOTH));
		btn.setIcon(icon);
	}
	
	public static void styleImage(JLabel btn, Image image, int width, int height) {
		ImageIcon icon = new ImageIcon(image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
		btn.setIcon(icon);
	}
	
	public static Color normalButtonColor() {
		return new Color(166, 171, 173);
	}

}
