package ca.uwo.csd.cs2212.team09;

import javax.swing.JPanel;

public class Dashboard_Card extends JPanel {
	
	public final static int CARD_TYPE_DEFAULT = 0;
	public final static int CARD_TYPE_TIME = 1;
	public final static int CARD_TYPE_CALORIES = 2;
	
	private int currType;

	/**
	 * Create the panel.
	 */
	public Dashboard_Card(int width, int height, int type) {
		setSize(196, 196);
		currType = type;
		
		//setSize(width, height);
		
		switch (currType) {
		case CARD_TYPE_DEFAULT:{
			//empty card
			break;
		}
		case CARD_TYPE_TIME:{
			
			break;
		}
		default: {
			break;
		}
		}
	}

}
