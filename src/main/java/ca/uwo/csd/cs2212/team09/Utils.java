package ca.uwo.csd.cs2212.team09;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Utils {
	
	public static void styleButton(JLabel btn) {
		btn.setOpaque(true);
		btn.setBackground(normalButtonColor());
		btn.setForeground(new Color(51, 51, 51));
	}
	
	public static void styleSquareImageButton(JLabel btn, Image image, int sideLength) {
		ImageIcon icon = new ImageIcon(image.getScaledInstance(sideLength, sideLength, java.awt.Image.SCALE_SMOOTH));
		btn.setIcon(icon);
	}
	
	public static Color normalButtonColor() {
		return new Color(166, 171, 173);
	}

}
