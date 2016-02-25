package ca.uwo.csd.cs2212.team09;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.CardLayout;


public class MainView {
	public final static int BUTTON_ALPHA_NORMAL = 150;
	public final static int BUTTON_ALPHA_HIGHLIGHT = 254;
	public final static Boolean VE_DEV_MODE = false;  //change to false before any release
	
	public final static int CARD_SIZE = 196;
	public final static int CARD_GAP_SIZE = 8;

	UserData sessionData = new UserData();
	
	private int DATA_DAILY_CALORIES = 0;
	private int DATA_DAILY_DISTANCE = 1;
	private int DATA_DAILY_FLOORS = 2;
	private int DATA_DAILY_STEPS = 3;
	private int DATA_DAILY_ACTIVE_MINUTES = 4;
	private int DATA_DAILY_SEDENTARY_MINUTES = 5;
	
	private int dailyData[] = {0, 0, 0, 0, 0, 0};
	private String dailyDataMsg[] = {"Calories burned (out)", "Total distance", "Floors climbed", "Steps", "Active minutes", "Sedentary minutes"};
	private Boolean dailyDataCustomization[] = {true, true, true, true, true, true};
	
	class MainView_Frame_Resize_Adapter extends java.awt.event.ComponentAdapter {
		  MainView adaptee;

		  MainView_Frame_Resize_Adapter(MainView adaptee) {
		    this.adaptee = adaptee;
		  }
		  public void componentResized(ComponentEvent e) {
		    adaptee.frameResized(e);
		  }  
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
	JLabel lastupdatedLbl = new JLabel("Data outdated. Please refresh.");
	JLabel goalsBtn = new JLabel("Goals");
	JLabel mainTitleLabel = new JLabel("Home");
	JLabel userBtn = new JLabel();
	JLabel refreshBtn = new JLabel();
	JLabel settingsBtn = new JLabel();
	private final JPanel mainPanel = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	private final Dashboard_Panel dashboardPanel = new Dashboard_Panel();
	private final JPanel timeseriesPanel = new JPanel();
	private final JPanel heartzonePanel = new JPanel();
	private final JPanel goalsPanel = new JPanel();
	private final JLabel mysummaryBtn = new JLabel("MySummary");
	private final JPanel mysummaryPanel = new JPanel();

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
		mainView.setBounds(100, 100, 1025, 540);
		mainView.setBackground(new Color(38, 50, 56));
		mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainView.getContentPane().setBackground(new Color(38, 50, 56));
		mainView.setMinimumSize(new Dimension(1025, 540));
		
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
		
		mainPanel.add(mysummaryPanel, "name_1456033158027647000");
		
		mainPanel.add(timeseriesPanel, "name_1456030885832917000");
		
		mainPanel.add(heartzonePanel, "name_1456030906465778000");
		
		mainPanel.add(goalsPanel, "name_1456030920510772000");
		
		currLayout = getFitLayout();
		layoutAllPanels(currLayout);
		
		
		userBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 userLbl.setText("Click to change your avatar");
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
		refreshBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					refreshAllDataWithDate(null, false);
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				} finally {
	    					updateDataOnPanels();
	    				}
	    			}
	    		});
			}
		});
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
		//mainView.repaint();
	}
	
	Dimension getFitLayout() {
		//actually we don't need to care about the width
		int etcOpHeight = 148;  //148
		return new Dimension(3, (this.mainView.getHeight()-etcOpHeight) / CARD_SIZE);
	}
	
	void refreshAllDataWithDate(Date date, Boolean canned) {
		final Boolean canVar = canned;
		lastupdatedLbl.setText("Refreshing...");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
			            if (canVar) {
			                System.out.println("Returning canned data...");
			            }
						//TODO: Fill in the date as a string in this format: 2016-01-08
			            dailyData[DATA_DAILY_STEPS] = sessionData.getSteps(canVar, "");
			            dailyData[DATA_DAILY_FLOORS] = sessionData.getFloors(canVar, "");
			            dailyData[DATA_DAILY_CALORIES]= sessionData.getCalories(canVar, "");
			            dailyData[DATA_DAILY_DISTANCE] = sessionData.getDistance(canVar, "");
			            dailyData[DATA_DAILY_ACTIVE_MINUTES] = sessionData.getActiveMinutes(canVar, "");
			            dailyData[DATA_DAILY_SEDENTARY_MINUTES] = sessionData.getSedentaryMinutes(canVar, "");
			        } catch (Exception e) {
			            System.out.println("Something went horribly wrong, tell Michael about this: " + e);
			        }
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
				lastupdatedLbl.setText("Last updated: " + df.format(new Date()));
				
				System.out.println("Data updated.");
			}
		});
		
	}
	
	void updateDataOnPanels() {
		int j = 0;
		for (int i=0;i<dailyData.length;i++) {
			if (dailyDataCustomization[i]) {
				j++;
				Dashboard_Card panel = dashboardPanel.modifyAt(j);
				panel.setTitle(dailyDataMsg[i]);
				panel.setContent(dailyData[i]+"<-New");
				panel.updatePanel();
				dashboardPanel.updateUI();
			}
		}
	}
	
	void layoutAllPanels(Dimension layoutMode) {
		refreshAllDataWithDate(null, true);
		if (dashboardPanel.subviewCount() == 0) {
			Dashboard_Card dateCard = createCards(196, 196, Dashboard_Card.CARD_TYPE_TIME, "Date", "");
			dashboardPanel.add(dateCard, false);
			for (int i=0;i<dailyData.length;i++) {
				Dashboard_Card t = createCards(196, 196, Dashboard_Card.CARD_TYPE_DEFAULT, dailyDataMsg[i], dailyData[i]+"");
				dashboardPanel.add(t, false);
			}
		}
		
		dashboardPanel.layoutPanel(layoutMode);
	}
	
	private Dashboard_Card createCards(int width, int height) {
		return createCards(width, height, Dashboard_Card.CARD_TYPE_DEFAULT, "", "");
	}
	
	private Dashboard_Card createCards(int width, int height, int type, String title, String content) {
		Dashboard_Card panel = new Dashboard_Card(width, height, type, title, content);
		Color backgroundColor = new Color(255, 255, 255, MainView.BUTTON_ALPHA_NORMAL);
		panel.setBackground(backgroundColor);
		
		return panel;
	}
	
	void frameResized(ComponentEvent e) {
		Dimension tLayout = getFitLayout();
	     if (currLayout.height != tLayout.getHeight()) {
	    	 //System.out.println("Relayout needed." + currLayout + getFitLayout());
	    	 currLayout = getFitLayout();
	    	 layoutAllPanels(currLayout);
	     }
 }
}
