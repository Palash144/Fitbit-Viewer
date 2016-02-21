package ca.uwo.csd.cs2212.team09;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView {

	private JFrame mainView;

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
		mainView.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainView = new JFrame();
		mainView.setTitle("Team09_Fitbit_Project_GUI");
		mainView.setBounds(100, 100, 960, 540);
		mainView.setBackground(new Color(38, 50, 56));
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.getContentPane().setBackground(new Color(38, 50, 56));
		mainView.setMinimumSize(new Dimension(960, 540));
		
		JPanel rightSidePanel = new JPanel();
		rightSidePanel.setBackground(new Color(0, 150, 136));
		
		JLabel mainTitleLabel = new JLabel("Home");
		mainTitleLabel.setForeground(Color.WHITE);
		mainTitleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		JLabel dashboardBtn = new JLabel("Dashboard");
		dashboardBtn.setHorizontalAlignment(SwingConstants.CENTER);
		dashboardBtn.setForeground(Color.WHITE);
		Utils.styleButton(dashboardBtn);
		
		
		JLabel timeseriesBtn = new JLabel("TimeSeries");
		timeseriesBtn.setHorizontalAlignment(SwingConstants.CENTER);
		timeseriesBtn.setForeground(Color.WHITE);
		Utils.styleButton(timeseriesBtn);
		
		JLabel heartzoneBtn = new JLabel("HeartZone");
		heartzoneBtn.setHorizontalAlignment(SwingConstants.CENTER);
		heartzoneBtn.setForeground(Color.WHITE);
		Utils.styleButton(heartzoneBtn);
		
		final JLabel userLbl = new JLabel("User01");
		userLbl.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		userLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		userLbl.setForeground(Color.WHITE);
		
		JLabel lastupdatedLbl = new JLabel("Last updated: 12:50AM");
		lastupdatedLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lastupdatedLbl.setForeground(Color.WHITE);
		
		GroupLayout groupLayout = new GroupLayout(mainView.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(dashboardBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(timeseriesBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(heartzoneBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(mainTitleLabel, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(userLbl, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lastupdatedLbl, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rightSidePanel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(rightSidePanel, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(userLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lastupdatedLbl))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(mainTitleLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addComponent(dashboardBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(timeseriesBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(heartzoneBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
		);
		
		JLabel userBtn = new JLabel();
		userBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 userLbl.setText("Click to logout");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				userLbl.setText("User01");
			}
		});
		int userBtnSide = 60;
		Utils.styleSquareImageButton(userBtn, new ImageIcon(getClass().getResource("/User_Default.png")).getImage(), userBtnSide);
		
		int sideBtnSize_Small = 40;
		
		JLabel refreshBtn = new JLabel();
		Utils.styleSquareImageButton(refreshBtn, new ImageIcon(getClass().getResource("/Tools_Refresh.png")).getImage(), sideBtnSize_Small);
		
		JLabel settingsBtn = new JLabel();
		Utils.styleSquareImageButton(settingsBtn, new ImageIcon(getClass().getResource("/Tools_Setting.png")).getImage(), sideBtnSize_Small);
		
		GroupLayout gl_rightSidePanel = new GroupLayout(rightSidePanel);
		gl_rightSidePanel.setHorizontalGroup(
			gl_rightSidePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_rightSidePanel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_rightSidePanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_rightSidePanel.createSequentialGroup()
							.addComponent(userBtn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(4))
						.addGroup(gl_rightSidePanel.createSequentialGroup()
							.addGroup(gl_rightSidePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(settingsBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(refreshBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(14))))
		);
		gl_rightSidePanel.setVerticalGroup(
			gl_rightSidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightSidePanel.createSequentialGroup()
					.addGap(14)
					.addComponent(userBtn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(refreshBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(settingsBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(334, Short.MAX_VALUE))
		);
		rightSidePanel.setLayout(gl_rightSidePanel);
		mainView.getContentPane().setLayout(groupLayout);
	}
}
