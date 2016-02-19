package ca.uwo.csd.cs2212.team09;

/**
 * MainUI.java
 * 
 * Created by Haoyu Gu on 18/02/16.
 */

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class MainUI extends JFrame{
	
	public MainUI() {
		super("Team09_Fitbit_Project");
		setVisible(true);
		setSize(960, 540);
		setMinimumSize(new Dimension(960, 540));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layoutUI();
	}
	
	private void layoutUI() {
		JPanel bkgndPanel = new JPanel();
		//bkgndPanel.setLayout(new GridBagLayout());
		bkgndPanel.setBackground(new Color(38, 50, 56));
		//bkgndPanel.setPreferredSize(new Dimension(960, 540));
		
		//JPanel rightSidebarPanel = new JPanel();
		//rightSidebarPanel.setLayout(new BoxLayout(rightSidebarPanel, BoxLayout.X_AXIS));
		GroupLayout layout = new GroupLayout(bkgndPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
		
        bkgndPanel.setLayout(layout);
		
		//JScrollPane scrollPane = new JScrollPane(bkgndPanel);  
        //scrollPane.setPreferredSize(new Dimension(960, 540)); 
		getContentPane().add(bkgndPanel);
		pack();
	}
	
	public void refresh() {
		
	}

}
