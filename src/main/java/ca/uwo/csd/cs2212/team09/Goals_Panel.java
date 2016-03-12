package ca.uwo.csd.cs2212.team09;

import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;


public class Goals_Panel extends JPanel{
	private JList goalList;
	private DefaultListModel listModel;
	
	/**
	 * Create the panel.
	 */

	public Goals_Panel() {
		super(new BorderLayout());
		
		JList list = new JList();
		add(list, BorderLayout.SOUTH);
		
		Panel panel = new Panel();
		panel.setName("goal1");
		Color c = new Color();
		panel.setBackground();
		list.add(panel);
		
		
		Panel panel1 = new Panel();

		list.add(panel1);
		
		
	
		
		
		listModel = new DefaultListModel();
        listModel.addElement("goal1");
        listModel.addElement("goal2");
        listModel.addElement("goal3");
        
        //create the list and put it in scroll panel
        goalList = new JList(listModel);
        
        goalList.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(goalList);
	
		
		
		
	}
	
	private Dashboard_Card createCards(int width, int height, int type, String title, String content, Dashboard_Panel p) {
        Dashboard_Card panel = new Dashboard_Card(width, height, type, title, content, p);
        Color backgroundColor = Utils.normalButtonColor();
        panel.setBackground(backgroundColor);

        return panel;
    }

	


	
	
}
