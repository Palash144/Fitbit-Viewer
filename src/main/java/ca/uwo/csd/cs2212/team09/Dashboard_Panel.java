package ca.uwo.csd.cs2212.team09;

import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/** This class implements the panel that will be on the dashboard
 * and will display various data.
 * @author Team 9
 *
 */
public class Dashboard_Panel extends JPanel {
	
	
	private static final long serialVersionUID = 8925528422220724438L;
	private List<JPanel>panels = new ArrayList<JPanel>();
	private Dimension currLayout;

	private MainView parentView;
	
	/** Constructs a panel for the dashboard
	 * @param p the main dashboard for which the panel is on
	 */
	public Dashboard_Panel(MainView p) {
		parentView = p;
	}

	
	/** Adds a panel to the dashboard
	 * @param panel
	 * @param layoutNow
	 */
	public void add(JPanel panel, Boolean layoutNow) {
		panels.add(panel);
		if (layoutNow)
			layoutPanel(currLayout);
	}
	
	/** 
	 * @param cardIndex
	 * @return
	 */
	public JPanel modifyAt(int cardIndex) {
		if (cardIndex >= panels.size()) {
			return null;
		}
		return (JPanel) panels.get(cardIndex);
	}
	
	/** Removes a panel from the dashboard
	 * @param panel the panel to be removed
	 */
	public void remove(JPanel panel) {
		
	}
	
	/**
	 * Updates the date of the panel
	 */
	public void changeDate(String date) {
		parentView.updateTime(date);
	}
	
	/**
	 * @return
	 */
	public int subviewCount() {
		if (panels == null)
			return 0;
		return panels.size();
	}
	
	/**
	 * @param layoutMode
	 */
	public void layoutPanel(Dimension layoutMode) {
		if (layoutMode == null)
			return;
		currLayout = layoutMode;

		removeAll();
		setLayout(null);
		int x = 0;
		int y = 0;
		for (int i=0;i<panels.size()/currLayout.height+(panels.size()%currLayout.height==0?0:1);i++) {
			for (int j=0;j<currLayout.height;j++) {
				if (i*currLayout.height+j >= panels.size())
					break;
				panels.get(i*currLayout.height+j).setLocation(x, y);
				add(panels.get(i*currLayout.height+j));
				y += MainView.CARD_SIZE + MainView.CARD_GAP_SIZE;
			}
			y = 0;
			x += MainView.CARD_SIZE + MainView.CARD_GAP_SIZE;
		}
		updateUI();
	}
	
}
