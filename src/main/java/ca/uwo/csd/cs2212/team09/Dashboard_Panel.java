package ca.uwo.csd.cs2212.team09;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Dashboard_Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8925528422220724438L;
	private List<JPanel>panels = new ArrayList<JPanel>();
	private Dimension currLayout;

	public Dashboard_Panel() {
		
	}

	public void add(JPanel panel, Boolean layoutNow) {
		panels.add(panel);
		if (layoutNow)
			layoutPanel(currLayout);
	}
	
	public void remove(JPanel panel) {
		
	}
	
	public int subviewCount() {
		if (panels == null)
			return 0;
		return panels.size();
	}
	
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
