package ca.uwo.csd.cs2212.team09;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;

public class MainView {
	static int BUTTON_ALPHA_NORMAL = 150;
	static int BUTTON_ALPHA_HIGHLIGHT = 254;
	static Boolean VE_DEV_MODE = false;  //change to false before any release
	
	static int CARD_SIZE = 196;
	static int CARD_GAP_SIZE = 8;
	
	class MainView_Frame_Resize_Adapter extends java.awt.event.ComponentAdapter {
		  MainView adaptee;

		  MainView_Frame_Resize_Adapter(MainView adaptee) {
		    this.adaptee = adaptee;
		  }
		  public void componentResized(ComponentEvent e) {
		    adaptee.frameResized(e);
		  }  
	}

	
	
	private JPanel createCards(int width, int height) {
		JPanel panel = new JPanel();
		Color backgroundColor = new Color(255, 255, 255, BUTTON_ALPHA_NORMAL);
		panel.setBackground(backgroundColor);
		panel.setSize(width, height);
		panel.setVisible(true);
		return panel;
	}
	
	
	private JFrame mainView;
	
	/* 
	 * 0 for dashboard
	 * 1 for mysummary
	 * 2 for timeseries
	 * 3 for heartzone
	 * 4 for goals
	 * 5 for accolodes
	 */
	private int currentPage;  
	private static String pageNames[] = {"name_1456030182851147000", "name_1456033158027647000", "name_1456030885832917000", "name_1456030906465778000", "name_1456030920510772000", ""};
	private Dimension currLayout;
	
	JLabel dashboardBtn = new JLabel("Dashboard");
	JLabel timeseriesBtn = new JLabel("TimeSeries");
	JLabel heartzoneBtn = new JLabel("HeartZone");
	JLabel userLbl = new JLabel("User01");
	JLabel lastupdatedLbl = new JLabel("Last updated: 12:50AM");
	JLabel goalsBtn = new JLabel("Goals");
	JLabel mainTitleLabel = new JLabel("Home");
	JLabel userBtn = new JLabel();
	JLabel refreshBtn = new JLabel();
	JLabel settingsBtn = new JLabel();
	private final JPanel mainPanel = new JPanel();
	private final JPanel dashboardPanel = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	private final JPanel timeseriesPanel = new JPanel();
	private final JPanel heartzonePanel = new JPanel();
	private final JPanel goalsPanel = new JPanel();
	private final JLabel mysummaryBtn = new JLabel("MySummary");
	private final JPanel mysummaryPanel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private final JLabel lblNewLabel_2 = new JLabel("New label");
	private final JLabel lblNewLabel_3 = new JLabel("New label");

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
		
		mainTitleLabel.setForeground(Color.WHITE);
		mainTitleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		this.mainView.addComponentListener(new MainView_Frame_Resize_Adapter(this));
		
		dashboardBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dashboardBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (currentPage != 0)
					dashboardBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_NORMAL));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentPage = 0;
				updateLeftSideButton();
			}
		});
		dashboardBtn.setHorizontalAlignment(SwingConstants.CENTER);
		dashboardBtn.setForeground(Color.WHITE);
		Utils.styleButton(dashboardBtn);
		currentPage = 0;
		dashboardBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
		
		mysummaryBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mysummaryBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (currentPage != 1)
					mysummaryBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_NORMAL));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentPage = 1;
				updateLeftSideButton();
			}
		});
		mysummaryBtn.setHorizontalAlignment(SwingConstants.CENTER);
		mysummaryBtn.setForeground(Color.WHITE);
		Utils.styleButton(mysummaryBtn);
		
		timeseriesBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				timeseriesBtn.setBackground(new Color(255, 255, 255,BUTTON_ALPHA_HIGHLIGHT));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (currentPage != 2)
					timeseriesBtn.setBackground(new Color(255, 255, 255,BUTTON_ALPHA_NORMAL));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentPage = 2;
				updateLeftSideButton();
			}
		});
		timeseriesBtn.setHorizontalAlignment(SwingConstants.CENTER);
		timeseriesBtn.setForeground(Color.WHITE);
		Utils.styleButton(timeseriesBtn);
		
		
		heartzoneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				heartzoneBtn.setBackground(new Color(255, 255, 255,BUTTON_ALPHA_HIGHLIGHT));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (currentPage != 3)
					heartzoneBtn.setBackground(new Color(255, 255, 255,BUTTON_ALPHA_NORMAL));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentPage = 3;
				updateLeftSideButton();
			}
		});
		heartzoneBtn.setHorizontalAlignment(SwingConstants.CENTER);
		heartzoneBtn.setForeground(Color.WHITE);
		Utils.styleButton(heartzoneBtn);
		
		userLbl.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		userLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		userLbl.setForeground(Color.WHITE);
		
		lastupdatedLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lastupdatedLbl.setForeground(Color.WHITE);
		
		
		goalsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goalsBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (currentPage != 4)
					goalsBtn.setBackground(new Color(255, 255, 255,BUTTON_ALPHA_NORMAL));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentPage = 4;
				updateLeftSideButton();
			}
		});
		goalsBtn.setForeground(Color.WHITE);
		goalsBtn.setHorizontalAlignment(SwingConstants.CENTER);
		Utils.styleButton(goalsBtn);

		
		GroupLayout groupLayout = new GroupLayout(mainView.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(mainTitleLabel, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(userLbl, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lastupdatedLbl, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(dashboardBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(mysummaryBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(timeseriesBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(heartzoneBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(goalsBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightSidePanel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(rightSidePanel, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(userLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lastupdatedLbl))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(mainTitleLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(dashboardBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(mysummaryBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(timeseriesBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(heartzoneBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(goalsBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		mainPanel.setLayout(cardLayout);
		mainPanel.setBackground(new Color(38, 50, 56));
		
		dashboardPanel.setBackground(new Color(38, 50, 56));
		
		mainPanel.add(dashboardPanel, "name_1456030182851147000");
		currLayout = getFitLayout();
		layoutDashboardPanel(currLayout);
	    
		mainPanel.add(mysummaryPanel, "name_1456033158027647000");
		
		mainPanel.add(timeseriesPanel, "name_1456030885832917000");
		
		mainPanel.add(heartzonePanel, "name_1456030906465778000");
		
		mainPanel.add(goalsPanel, "name_1456030920510772000");
		
		
		userBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 userLbl.setText("Click to logout");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				userLbl.setText("User01");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		int userBtnSide = 60;
		Utils.styleSquareImageButton(userBtn, new ImageIcon(getClass().getResource("/User_Default.png")).getImage(), userBtnSide);
		
		int sideBtnSize_Small = 40;
		
		
		Utils.styleSquareImageButton(refreshBtn, new ImageIcon(getClass().getResource("/Tools_Refresh.png")).getImage(), sideBtnSize_Small);
		
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
	
	private void updateLeftSideButton() {
		dashboardBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_NORMAL));
		mysummaryBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_NORMAL));
		timeseriesBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_NORMAL));
		heartzoneBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_NORMAL));
		goalsBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_NORMAL));
		cardLayout.show(mainPanel, pageNames[currentPage]);
		switch (currentPage) {
		case 0: {
			dashboardBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
			break;
		}
		case 1: {
			mysummaryBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
			break;
		}
		case 2: {
			timeseriesBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
			break;
		}
		case 3: {
			heartzoneBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
			break;
		}
		case 4: {
			goalsBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
			break;
		}
		case 5: {
			
			break;
		}
		default: {
			break;
		}
		}
	}
	
	Dimension getFitLayout() {
		//actually we don't need to care about the width
		int etcOpHeight = 148;  //148
		return new Dimension(3, (this.mainView.getHeight()-etcOpHeight) / CARD_SIZE);
	}
	
	void layoutAllPanels(Dimension layoutMode) {
		layoutDashboardPanel(layoutMode);
	}
	
	void layoutDashboardPanel(Dimension layoutMode) {
		JPanel t1 = createCards(196, 196);
		JPanel t2 = createCards(196, 196);
		JPanel t3 = createCards(196, 196);
		JPanel t4 = createCards(196, 196);
		JPanel t5 = createCards(196, 196);
		JPanel t6 = createCards(196, 196);
		JPanel panels[] = {t1, t2, t3, t4, t5};
		
		/*
		  if (!VE_DEV_MODE) {
			GroupLayout gl_dashboardPanel = new GroupLayout(dashboardPanel);
				gl_dashboardPanel.setHorizontalGroup(
					gl_dashboardPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_dashboardPanel.createSequentialGroup()
							.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(t2, Alignment.LEADING, CARD_SIZE, CARD_SIZE, Short.MAX_VALUE)
									.addComponent(t1, Alignment.LEADING, CARD_SIZE, CARD_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(t4, CARD_SIZE, CARD_SIZE, Short.MAX_VALUE)
									.addComponent(t3, CARD_SIZE, CARD_SIZE, Short.MAX_VALUE))
								.addContainerGap(345, Short.MAX_VALUE))
			);
			gl_dashboardPanel.setVerticalGroup(
					gl_dashboardPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_dashboardPanel.createSequentialGroup()
							.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(t3, Alignment.LEADING, CARD_SIZE, CARD_SIZE, Short.MAX_VALUE)
								.addComponent(t1, Alignment.LEADING, CARD_SIZE, CARD_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(t4, CARD_SIZE, CARD_SIZE, Short.MAX_VALUE)
								.addComponent(t2, CARD_SIZE, CARD_SIZE, Short.MAX_VALUE))
							.addGap(46))
			);
			dashboardPanel.setLayout(gl_dashboardPanel);
		
		}
		 */
		dashboardPanel.removeAll();
		dashboardPanel.setLayout(null);
		int x = 0;
		int y = 0;
		for (int i=0;i<panels.length/layoutMode.height+(panels.length%layoutMode.height==0?0:1);i++) {
			for (int j=0;j<layoutMode.height;j++) {
				if (i*layoutMode.height+j >= panels.length)
					break;
				panels[i*layoutMode.height+j].setLocation(x, y);
				dashboardPanel.add(panels[i*layoutMode.height+j]);
				y += CARD_SIZE + CARD_GAP_SIZE;
			}
			y = 0;
			x += CARD_SIZE + CARD_GAP_SIZE;
		}
		dashboardPanel.updateUI();
	}
	
	void frameResized(ComponentEvent e) {
		Dimension tLayout = getFitLayout();
	     if (currLayout.height != tLayout.getHeight()) {
	    	 System.out.println("Relayout needed." + currLayout + getFitLayout());
	    	 currLayout = getFitLayout();
	    	 layoutAllPanels(currLayout);
	     }
 }
}
