package ca.uwo.csd.cs2212.team09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * //TODO: This is for stage 3
 * @author Team 9
 */
public class SettingsView extends JDialog {
	
	private MainView parent;
	private JCheckBox chckbxNewCheckBox = new JCheckBox("Calories burned (out)");
	JPanel buttonPane = new JPanel();
	JButton okButton = new JButton("OK");
	JButton cancelButton = new JButton("Cancel");
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JPanel panel = new JPanel();
	
	JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Total distance");
	JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Floors climbed");
	JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Steps");
	JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Active minutes");
	JCheckBox chckbxSedentaryMinutes = new JCheckBox("Sedentary minutes");

	JLabel lblWhat = new JLabel("Elements shown on your daily dashboard:");
	
	boolean[] selectionArray = new boolean[6];



	/**
	 * Create the dialog.
	 * @param p
	 * @param modal
     */
	public SettingsView(MainView p, boolean modal, boolean[] checkMark) {
		selectionArray = checkMark;
		setTitle("Settings");
		setModal(modal);
		setAlwaysOnTop(true);
		parent = p;
		setBounds(100, 100, 560, 350);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		{
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//calories
						if(chckbxNewCheckBox.isSelected()){
							selectionArray[0] = true;
						}
						else{
							selectionArray[0] = false;
						}
						//total distance
						if(chckbxNewCheckBox_1.isSelected()){
							selectionArray[1] = true;
						}
						else{
							selectionArray[1] = false;
						}
						
						//floors climbed
						if(chckbxNewCheckBox_2.isSelected()){
							selectionArray[2] = true;
						}
						else{
							selectionArray[2] = false;
						}
						//steps
						if(chckbxNewCheckBox_3.isSelected()){
							selectionArray[3] = true;
						}
						else{
							selectionArray[3] = false;
						}
						//active minutes
						if(chckbxNewCheckBox_4.isSelected()){
							selectionArray[4] = true;
						}
						else{
							selectionArray[4] = false;
						}
						//sedentary minutes
						if(chckbxSedentaryMinutes.isSelected()){
							selectionArray[5] = true;
						}
						else{
							selectionArray[5] = false;
						}
						parent.customizeDashboard(selectionArray);
						
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton.setActionCommand("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				
				buttonPane.add(cancelButton);
			}
		}
		{
			getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				tabbedPane.addTab("Daily Dashboard", null, panel, null);
				{
					chckbxNewCheckBox.setSelected(true);
				}
				
				chckbxNewCheckBox_1.setSelected(true);
				
				chckbxNewCheckBox_2.setSelected(true);
				
				chckbxNewCheckBox_3.setSelected(true);
				
				chckbxNewCheckBox_4.setSelected(true);
				
				chckbxSedentaryMinutes.setSelected(true);
				
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxNewCheckBox)
								.addComponent(chckbxNewCheckBox_1)
								.addComponent(chckbxNewCheckBox_2)
								.addComponent(chckbxNewCheckBox_3)
								.addComponent(chckbxNewCheckBox_4)
								.addComponent(chckbxSedentaryMinutes)
								.addComponent(lblWhat))
							.addContainerGap(369, Short.MAX_VALUE))
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblWhat)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxNewCheckBox)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxNewCheckBox_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxNewCheckBox_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxNewCheckBox_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxNewCheckBox_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxSedentaryMinutes)
							.addContainerGap(33, Short.MAX_VALUE))
				);
				panel.setLayout(gl_panel);
			}
			{
				tabbedPane.addTab("About", null, panel, null);
			}
		}
		chckbxNewCheckBox.setSelected(selectionArray[0]);
		
		chckbxNewCheckBox_1.setSelected(selectionArray[1]);
		
		chckbxNewCheckBox_2.setSelected(selectionArray[2]);
		
		chckbxNewCheckBox_3.setSelected(selectionArray[3]);
		
		chckbxNewCheckBox_4.setSelected(selectionArray[4]);
		
		chckbxSedentaryMinutes.setSelected(selectionArray[5]);
		
	}
}
