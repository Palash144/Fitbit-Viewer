package ca.uwo.csd.cs2212.team09;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Dashboard_Card extends JPanel {
	
	public final static int CARD_TYPE_DEFAULT = 0;
	public final static int CARD_TYPE_TIME = 1;
	public final static int CARD_TYPE_CALORIES = 2;
	
	private int currType;
	
	private final JLabel titleLabel = new JLabel("Title");
	private final JLabel contentLabel = new JLabel("content");
	String title, content;

	/**
	 * Create the panel.
	 */
	public Dashboard_Card(int width, int height, int type, String lTitle, String lContent) {
		setSize(196, 196);
		
		title = lTitle;
		content = lContent;
		if (title != null)
			titleLabel.setText(title);
		if (content != null)
			contentLabel.setText(content);
		
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		contentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(contentLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
						.addComponent(titleLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(contentLabel, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		currType = type;
		
		//setSize(width, height);
		
		switch (currType) {
		case CARD_TYPE_DEFAULT:{
			//keep current layout
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
	
	public void setTitle(String lTitle) {
		title = lTitle;
		updatePanel();
	}
	
	public void setContent(String lContent) {
		content = lContent;
		updatePanel();
	}
	
	public void updatePanel() {
		if (title != null)
			titleLabel.setText(title);
		else
			titleLabel.setText("");
		if (content != null)
			contentLabel.setText(content);
		else
			contentLabel.setText("");
		updateUI();
	}
}
