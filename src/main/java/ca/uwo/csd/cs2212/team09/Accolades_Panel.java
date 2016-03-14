package ca.uwo.csd.cs2212.team09;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;

public class Accolades_Panel extends JPanel {
	
	
	private class cellRenderer extends JLabel implements ListCellRenderer<Object> {  
		ArrayList<ImageIcon> icons;   
		 public cellRenderer(ArrayList<ImageIcon> icons) {  
			 this.icons = icons;  
		 }  
		 
		 public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {  
			 setText(value.toString());  
			 setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  
			 if (isSelected) {  
				 setBackground(new Color(0, 150, 136));  
				 setForeground(list.getSelectionForeground());  
			 } 
			 else {  
				 if (index % 2 == 1) {
					 setBackground(new Color(238, 238, 238)); 
				 }
				 else {
					 setBackground(list.getBackground()); 
				 }
				 setForeground(list.getForeground());  
			 }  
			
			 setIcon(Utils.getImageIconForList(icons.get(index).getImage()));  
			 setEnabled(list.isEnabled());  
			 setFont(list.getFont());  
			 setOpaque(true);  
			 return this;  
		 }  
		  
		}  

	private JList mainList = new JList();
	private JScrollPane scrollPane = new JScrollPane();
	
	private ArrayList<String> titles = new ArrayList<String>();
	private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
	
	private JLabel imageLbl = new JLabel("Click a goal to see detail!");
	private final JLabel lblTitle = new JLabel("-");
	private final JLabel lblDetail = new JLabel("-");
	
	/**
	 * Create the panel.
	 */
	public Accolades_Panel() {
		lblDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
		);
		
		
		imageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(imageLbl, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDetail, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(imageLbl, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, Short.MAX_VALUE)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblDetail, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		panel.setLayout(gl_panel);
		
		scrollPane.setViewportView(mainList);
		setLayout(groupLayout);
		
		mainList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					updatePriviewArea();
			    }
			}
        });
		
		//Demo only
		//TODO:dssdfsdfjioasdjfklajsdklfjalskdjfksajdfklasjdklfjasbkdvcliwl
		addItem("01", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("02", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("03", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("04", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("05", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("06", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("07", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("08", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("09", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("10", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("11", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("12", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("13", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("14", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("15", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("16", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("17", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("18", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("19", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		addItem("20", (new ImageIcon(getClass().getResource("/gold_cup.png"))), true);
		
		DefaultListModel listModel = new DefaultListModel();  
		for(int i=0;i<titles.size();i++){  
			listModel.add(i, titles.get(i));  
		}  
		mainList.setModel(listModel);
		mainList.setCellRenderer(new cellRenderer(images));  
		mainList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	}
	
	private void addItem(String title, ImageIcon image, boolean refreshNow) {
		titles.add(title);
		images.add(image);
		if (refreshNow) {
			SwingUtilities.updateComponentTreeUI(mainList);
		}
	}
	
	private void updatePriviewArea() {
		imageLbl.setText("");
		lblTitle.setText(titles.get(mainList.getSelectedIndex()));
		lblDetail.setText("100/1000 finished");
		Utils.styleSquareImageButton(imageLbl, images.get(mainList.getSelectedIndex()).getImage(), 150);
	}
}
