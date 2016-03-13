package ca.uwo.csd.cs2212.team09;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Goals_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Goals_Panel() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 547, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 340, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}

}
