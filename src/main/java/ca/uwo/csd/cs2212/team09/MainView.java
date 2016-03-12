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


/**
 * Implements the main dashboard, displaying panels and data
 *
 * @author Team 9
 */
public class MainView implements GeneralCallBack {
    public final static int BUTTON_ALPHA_NORMAL = 150;
    public final static int BUTTON_ALPHA_HIGHLIGHT = 254;
    public final static Boolean VE_DEV_MODE = false;  //change to false before any release

    public final static int CARD_SIZE = 196;
    public final static int CARD_GAP_SIZE = 8;

    public final static String CALLBACK_ID_LAYOUT_PANEL_AFTER_DATA_REFRESH = "1ad4321278ff123fe32";

    UserData sessionData = new UserData();

    private final static int DATA_DAILY_CALORIES = 0;
    private final static int DATA_DAILY_DISTANCE = 1;
    private final static int DATA_DAILY_FLOORS = 2;
    private final static int DATA_DAILY_STEPS = 3;
    private final static int DATA_DAILY_ACTIVE_MINUTES = 4;
    private final static int DATA_DAILY_SEDENTARY_MINUTES = 5;

    private final static int DATA_BEST_DISTANCE_DATE = 0;
    private final static int DATA_BEST_DISTANCE = 1;
    private final static int DATA_BEST_FLOORS_DATE = 2;
    private final static int DATA_BEST_FLOORS = 3;
    private final static int DATA_BEST_STEPS_DATE = 4;
    private final static int DATA_BEST_STEPS = 5;
    private final static int DATA_LT_DISTANCE = 6;
    private final static int DATA_LT_FLOORS = 7;
    private final static int DATA_LT_STEPS = 8;

    private final static int PAGE_DAILY_DASHBOARD = 0;
    private final static int PAGE_MY_SUMMARY = 1;
    private final static int PAGE_TIME_SERIES = 2;
    private final static int PAGE_HEART_ZONE = 3;
    private final static int PAGE_GOALS = 4;
    private final static int PAGE_ACCOLADES = 5;

    private double dailyData[] = {0, 0, 0, 0, 0, 0};
    private String bestnltDate[] = {" ", "0", " ", "0", " ", "0", "0", "0", "0"};
    private String dailyDataMsg[] = {"Calories burned (out)", "Total distance", "Floors climbed", "Steps", "Active minutes", "Sedentary minutes"};
    public Boolean dailyDataCustomization[] = {true, true, true, true, true, true};

    private HeartRateZones ohno = new HeartRateZones(0, "0", true);

    private HeartRateZones hrzoneData[] = {ohno, ohno, ohno, ohno};
    private int hrzoneData_Resting = 0;

    private Boolean testMode = true;
    public String currentDate;
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Adapter to capture the window resize event
     */
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

    private JLabel dashboardBtn = new JLabel("Dashboard");
    private JLabel timeseriesBtn = new JLabel("TimeSeries");
    private JLabel heartzoneBtn = new JLabel("HeartZone");
    private JLabel userLbl = new JLabel("Beth Locke");
    private JLabel lastupdatedLbl = new JLabel("Data outdated. Please refresh.");
    private JLabel goalsBtn = new JLabel("Goals");
    private JLabel mainTitleLabel = new JLabel("Home");
    private JLabel userBtn = new JLabel();
    private JLabel refreshBtn = new JLabel();
    private JLabel settingsBtn = new JLabel();
    private final JLabel fitbitLogo = new JLabel("");
    private JLabel accoladeBtn = new JLabel("Accolades");

    private final JPanel mainPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    private final Dashboard_Panel dashboardPanel = new Dashboard_Panel(this);
    private final JPanel timeseriesPanel = new JPanel();
    private final Dashboard_Panel heartzonePanel = new Dashboard_Panel(this);
    private final JPanel goalsPanel = new JPanel();
    private final JLabel mysummaryBtn = new JLabel("MySummary");
    private final SSheet_Panel mysummaryPanel = new SSheet_Panel();
    private final JLabel btnQuit = new JLabel("");


    /**
     * Creates the application (dashboard)
     *
     * @param isTestMode true if running the application in test mode, otherwise false.
     */
    public MainView(boolean isTestMode) {
        testMode = isTestMode;
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

        currentDate = df.format(new Date());

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
                    dashboardBtn.setBackground(Utils.normalButtonColor());
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
                    mysummaryBtn.setBackground(Utils.normalButtonColor());
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
                timeseriesBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (currentPage != 2)
                    timeseriesBtn.setBackground(Utils.normalButtonColor());
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
                heartzoneBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (currentPage != 3)
                    heartzoneBtn.setBackground(Utils.normalButtonColor());
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
                    goalsBtn.setBackground(Utils.normalButtonColor());
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
        
        
        accoladeBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		accoladeBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if (currentPage != 5)
        			accoladeBtn.setBackground(Utils.normalButtonColor());
        	}
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		currentPage = 5;
                updateLeftSideButton();
        	}
        });
        accoladeBtn.setForeground(Color.WHITE);
        accoladeBtn.setHorizontalAlignment(SwingConstants.CENTER);
        Utils.styleButton(accoladeBtn);

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
        							.addComponent(userLbl, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lastupdatedLbl, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(dashboardBtn, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        						.addComponent(mysummaryBtn, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        						.addComponent(timeseriesBtn, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        						.addComponent(heartzoneBtn, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        						.addComponent(goalsBtn, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        						.addComponent(accoladeBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(18)
        					.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)))
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
        					.addComponent(goalsBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(accoladeBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        				.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        			.addContainerGap())
        );
        mainPanel.setLayout(cardLayout);
        mainPanel.setBackground(new Color(38, 50, 56));

        dashboardPanel.setBackground(new Color(38, 50, 56));
        heartzonePanel.setBackground(new Color(38, 50, 56));

        mainPanel.add(dashboardPanel, "name_1456030182851147000");

        mainPanel.add(mysummaryPanel, "name_1456033158027647000");

        mainPanel.add(timeseriesPanel, "name_1456030885832917000");

        mainPanel.add(heartzonePanel, "name_1456030906465778000");

        mainPanel.add(goalsPanel, "name_1456030920510772000");

        currLayout = getFitLayout();
        layoutPanels(currLayout, true);


        userBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                userLbl.setText("Hello");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                userLbl.setText("Beth Locke");
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

        Utils.styleImage(btnQuit, new ImageIcon(getClass().getResource("/App_Close.png")).getImage(), 40, 40);

        GroupLayout gl_rightSidePanel = new GroupLayout(rightSidePanel);
        gl_rightSidePanel.setHorizontalGroup(
                gl_rightSidePanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_rightSidePanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_rightSidePanel.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_rightSidePanel.createSequentialGroup()
                                                .addComponent(userBtn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addGap(4))
                                        .addGroup(gl_rightSidePanel.createSequentialGroup()
                                                .addGroup(gl_rightSidePanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(settingsBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(refreshBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                                .addGap(14))))
                        .addGroup(gl_rightSidePanel.createSequentialGroup()
                                .addGap(3)
                                .addComponent(fitbitLogo, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                .addContainerGap())
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
                                .addPreferredGap(ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                                .addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(fitbitLogo, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        refreshBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateTime(currentDate);
            }
        });

        settingsBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadSettingView();
            }
        });

        btnQuit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        rightSidePanel.setLayout(gl_rightSidePanel);

        Utils.styleImage(fitbitLogo, new ImageIcon(getClass().getResource("/FitbitLogo.png")).getImage(), 60, 15);

        mainView.getContentPane().setLayout(groupLayout);
    }

    /**
     * //TODO: Finish settings view
     */
    private void loadSettingView() {
        SettingsView sv = new SettingsView(this, true);
        sv.setVisible(true);
    }

    /**
     * Updates buttons on the left menu on mouse events
     */
    private void updateLeftSideButton() {
        dashboardBtn.setBackground(Utils.normalButtonColor());
        mysummaryBtn.setBackground(Utils.normalButtonColor());
        timeseriesBtn.setBackground(Utils.normalButtonColor());
        heartzoneBtn.setBackground(Utils.normalButtonColor());
        goalsBtn.setBackground(Utils.normalButtonColor());
        accoladeBtn.setBackground(Utils.normalButtonColor());
        cardLayout.show(mainPanel, pageNames[currentPage]);
        switch (currentPage) {
            case PAGE_DAILY_DASHBOARD: {
                dashboardBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
                break;
            }
            case PAGE_MY_SUMMARY: {
                mysummaryBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
                break;
            }
            case PAGE_TIME_SERIES: {
                timeseriesBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
                break;
            }
            case PAGE_HEART_ZONE: {
                heartzoneBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
                break;
            }
            case PAGE_GOALS: {
                goalsBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
                break;
            }
            case PAGE_ACCOLADES: {
            	accoladeBtn.setBackground(new Color(255, 255, 255, BUTTON_ALPHA_HIGHLIGHT));
                break;
            }
            default: {
                break;
            }
        }
        updateDataOnPanels();
        layoutPanels(getFitLayout(), false);
    }

    /**
     * Used to retrieve the dimensions of the dashboard
     *
     * @return Dimension of the dashboard
     */
    Dimension getFitLayout() {
        //actually we don't need to care about the width
        int etcOpHeight = 148;  //148
        return new Dimension(3, (this.mainView.getHeight() - etcOpHeight) / CARD_SIZE);
    }

    /**
     * Used to refresh all user data on the dashboard
     *
     * @param date   date of data to be retrieved as "yyyy-mm-dd"
     * @param canned true if retrieving canned (fake) data
     */
    void refreshAllDataWithDate(String date, Boolean canned) {
        currentDate = date;
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
                        dailyData = sessionData.refreshAll(canVar, currentDate);
                        bestnltDate = sessionData.refreshMySummary(canVar);

                        hrzoneData = sessionData.getHeartRateZones(currentDate, canVar);
                        hrzoneData_Resting = sessionData.getRestingHeartRate(canVar, currentDate);

                    } catch (Exception e) {
                        System.out.println("Something went horribly wrong, tell Michael about this: " + e);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
                lastupdatedLbl.setText("Last updated: " + df.format(new Date()));

                System.out.println("Data updated.");

                callback(CALLBACK_ID_LAYOUT_PANEL_AFTER_DATA_REFRESH);
            }
        });
    }

    /**
     * This is used for callback handling
     * @param id determines where to callback from
     */
    public void callback(String id) {
        if (id == CALLBACK_ID_LAYOUT_PANEL_AFTER_DATA_REFRESH) {
            updateDataOnPanels();
        }
    }

    /**
     * Used to update the date of the user data displayed on the dashboard
     * @param time the time to use for retrieving data
     */
    public void updateTime(String time) {
        System.out.println("Now will refresh data.");
        currentDate = time;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    refreshAllDataWithDate(currentDate, testMode);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    updateDataOnPanels();
                }
            }
        });
    }

    /**
     * Used to update the data on the panels displaying the user data
     */
    void updateDataOnPanels() {
        switch (currentPage) {
            case PAGE_DAILY_DASHBOARD: {
                ((Dashboard_Card) dashboardPanel.modifyAt(0)).setNewDate(currentDate, false);
                int j = 0;
                for (int i = 0; i < dailyData.length; i++) {
                    if (dailyDataCustomization[i]) {
                        j++;
                        Dashboard_Card panel = (Dashboard_Card) dashboardPanel.modifyAt(j);
                        panel.setTitle(dailyDataMsg[i]);
                        panel.setContent(dailyData[i] + "");
                        panel.updatePanel();
                        dashboardPanel.updateUI();
                    }
                }
                break;
            }
            case PAGE_MY_SUMMARY: {
                mysummaryPanel.setData("<html><div style='text-align: center;'>" + String.format("%.2f", Double.parseDouble(bestnltDate[DATA_BEST_DISTANCE])) + "<br>" + bestnltDate[DATA_BEST_DISTANCE_DATE] + "</HTML>",
                        bestnltDate[DATA_LT_DISTANCE] + "",
                        "<html><div style='text-align: center;'>" + String.format("%.0f", Double.parseDouble(bestnltDate[DATA_BEST_FLOORS])) + "<br>" + bestnltDate[DATA_BEST_FLOORS_DATE] + "</HTML>",
                        bestnltDate[DATA_LT_FLOORS] + "",
                        "<html><div style='text-align: center;'>" + String.format("%.0f", Double.parseDouble(bestnltDate[DATA_BEST_STEPS])) + "<br>" + bestnltDate[DATA_BEST_STEPS_DATE] + "</HTML>",
                        bestnltDate[DATA_LT_STEPS] + "");
                break;
            }
            case PAGE_TIME_SERIES: {

                break;
            }
            case PAGE_HEART_ZONE: {
                ((Dashboard_Card) heartzonePanel.modifyAt(0)).setNewDate(currentDate, false);
                for (int i = 0; i < 4; i++) {
                    Dashboard_HRCard panel = (Dashboard_HRCard) heartzonePanel.modifyAt(i + 1);
                    panel.setTitle(hrzoneData[i].getName());
                    panel.setCalories(hrzoneData[i].getCaloriesOut() + "");
                    panel.setTime(hrzoneData[i].getMinutes() + " Mins");
                }
                Dashboard_HRCard panel = (Dashboard_HRCard) heartzonePanel.modifyAt(5);
                panel.setCalories(hrzoneData_Resting + "");
                break;
            }
            case PAGE_GOALS: {

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

    /**
     * Determines the layout of the panels
     * @param layoutMode How many cards are on each row
     * @param updateData true refreshes all data on the card
     */
    void layoutPanels(Dimension layoutMode, boolean updateData) {
        if (updateData) {
            try {
                refreshAllDataWithDate(((Dashboard_Card) dashboardPanel.modifyAt(0)).getDate(), testMode);
            } catch (Exception e) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                refreshAllDataWithDate(df.format(new Date()), testMode);
            } finally {

            }
        }

        if (dashboardPanel.subviewCount() == 0) {
            Dashboard_Card dateCard = createCards(196, 196, Dashboard_Card.CARD_TYPE_TIME, "Date", "", dashboardPanel);
            dashboardPanel.add(dateCard, false);
            for (int i = 0; i < dailyData.length; i++) {
                if (dailyDataCustomization[i]) {
                    Dashboard_Card t = createCards(196, 196, Dashboard_Card.CARD_TYPE_DEFAULT, dailyDataMsg[i], dailyData[i] + "", dashboardPanel);
                    dashboardPanel.add(t, false);
                }
            }
        }

        dashboardPanel.layoutPanel(layoutMode);


        if (heartzonePanel.subviewCount() == 0) {
            Dashboard_Card dateCard = createCards(196, 196, Dashboard_Card.CARD_TYPE_TIME, "Date", "", dashboardPanel);
            dateCard.setNewDate(((Dashboard_Card) dashboardPanel.modifyAt(0)).getDate(), false);
            heartzonePanel.add(dateCard, false);
            for (int i = 0; i < 4; i++) {
                if (hrzoneData[i] != null) {
                    Dashboard_HRCard t = createHRCards(196, 196,
                            ((HeartRateZones) hrzoneData[i]).getName(),
                            ((HeartRateZones) hrzoneData[i]).getCaloriesOut() + "",
                            ((HeartRateZones) hrzoneData[i]).getMinutes() + " Mins",
                            heartzonePanel);
                    heartzonePanel.add(t, false);
                }
            }
            Dashboard_HRCard t = createHRCards(196, 196,
                    "Resting",
                    hrzoneData_Resting + "",
                    " ",
                    heartzonePanel);
            heartzonePanel.add(t, false);

        }

        heartzonePanel.layoutPanel(layoutMode);

    }


    /**
     * Create dashboard cards
     *
     * @param width   the width of the panel to be created
     * @param height  the height of the panel to be created
     * @param type    the type of the panel to be created
     * @param title   the title of the panel to be created
     * @param content the content to be displayed on the panel to be created
     * @param p       corresponding Dashboard_Panel
     * @return the dashboard card
     */
    private Dashboard_Card createCards(int width, int height, int type, String title, String content, Dashboard_Panel p) {
        Dashboard_Card panel = new Dashboard_Card(width, height, type, title, content, p);
        Color backgroundColor = Utils.normalButtonColor();
        panel.setBackground(backgroundColor);

        return panel;
    }

    /**
     * Create dashboard heart rate zone cards
     *
     * @param width    the width of the panel to be created
     * @param height   the height of the panel to be created
     * @param title    the title of the card
     * @param calories the calories of the card
     * @param time     the time of the card
     * @param p        corresponding Dashboard_Panel
     * @return         the dashboard card
     */
    private Dashboard_HRCard createHRCards(int width, int height, String title, String calories, String time, Dashboard_Panel p) {
        Dashboard_HRCard panel = new Dashboard_HRCard(title, calories, time);
        Color backgroundColor = Utils.normalButtonColor();
        panel.setBackground(backgroundColor);

        return panel;
    }

    /**
     * Handler for capturing event when resizing window
     *
     * @param e The window size change event
     */
    private void frameResized(ComponentEvent e) {
        Dimension tLayout = getFitLayout();
        if (currLayout.height != tLayout.getHeight()) {
            //System.out.println("Relayout needed." + currLayout + getFitLayout());
            currLayout = getFitLayout();
            layoutPanels(currLayout, false);
        }
    }
}
