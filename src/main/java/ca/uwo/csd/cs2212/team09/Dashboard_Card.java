// import statements
package ca.uwo.csd.cs2212.team09;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author       
 * @version     
 * @since       
 */
public class Dashboard_Card extends JPanel {

	
	public final static int CARD_TYPE_DEFAULT = 0;

	public final static int CARD_TYPE_TIME = 1;

	public final static int CARD_TYPE_CALORIES = 2;
	
	private int currType;
	
	private boolean dateCardDisplayMode = false;
	
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	private final JLabel titleLabel = new JLabel("Title");
	private final JLabel contentLabel = new JLabel("content");
	String title, content;
	
	private final JPanel dateInputLayer = new JPanel();
	private final JLabel dateInputTitleLabel = new JLabel("Input date");
	private final JLabel dateInputInfoLabel = new JLabel("Format: yyyy-MM-dd");
	private final JTextField dateInputText = new JTextField();
	private final JButton dateConfirmBtn = new JButton("OK");
	private Timer uiTimer;

	private Date currentDate = new Date();
	
	private Dashboard_Panel parentView;

	/**
	 * Constructor
	 * 
	 * It would create a panel with input parameter, which include width, height
	 * type, title and content
	 * 
	 * Create the card.
	 * @param width - width of card
	 * @param height -height of card
	 * @param type -type of card
	 * @param lTitle -title of card
	 * @param lContent -content of card
	 * @param p - parent panel
	 */
	public Dashboard_Card(int width, int height, int type, String lTitle, String lContent, Dashboard_Panel p) {
		setSize(196, 196);
		hideDatePickUI();
		title = lTitle;
		content = lContent;
		currType = type;
		parentView = p;
		
		if (title != null)
			titleLabel.setText(title);
		if (content != null)
			contentLabel.setText(content);
		
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if (currType == CARD_TYPE_TIME) {
			contentLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!dateCardDisplayMode) {
						setDatePickMode();
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					titleLabel.setText(contentLabel.getText());
					contentLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
					contentLabel.setText("Click to change date!");
				}
				@Override
				public void mouseExited(MouseEvent e) {
					titleLabel.setText("Date");
					contentLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
					contentLabel.setText(df.format(currentDate));
				}
			});
		}
		
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
		
		//setSize(width, height);
		
		switch (currType) {
		case CARD_TYPE_DEFAULT:{
			//keep current layout
			break;
		}
		case CARD_TYPE_TIME:{
			content = df.format(new Date());
			contentLabel.setText(content);
			break;
		}
		default: {
			break;
		}
		}
	}
	
	/**
	 * the method would set date pick mode,
	 * true if load date pick UI
	 * false if hide date pick UI
	 * @param mode - boolean, true for load, false for hide
	 */
	private void setDatePickMode(boolean mode) {
		dateCardDisplayMode = mode;
		if (mode) {
			loadDatePickUI();
		}
		else {
			hideDatePickUI();
		}
	}
	/**
	 * private method, to load date pick UI
	 * will be called in setDatePickMode
	 */
	private void loadDatePickUI() {
		if (currType != CARD_TYPE_TIME) 
			return;
		
		dateInputLayer.setLayout(null);
		
		dateInputLayer.setLocation(0, getSize().height);
		dateInputLayer.setSize(getSize());
		dateInputLayer.setVisible(true);
		dateInputLayer.removeAll();
		
		dateInputLayer.add(dateInputTitleLabel);
		dateInputLayer.add(dateInputText);
		dateInputLayer.add(dateInputInfoLabel);
		dateInputLayer.add(dateConfirmBtn);
		
		dateInputTitleLabel.setLocation(0, 0);
		dateInputTitleLabel.setSize(getSize().width, 50);
		dateInputTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateInputTitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		dateInputTitleLabel.setVisible(true);
		
		dateInputInfoLabel.setLocation(0, dateInputTitleLabel.getSize().height);
		dateInputInfoLabel.setSize(getSize().width, 50);
		dateInputInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateInputInfoLabel.setText("<html><div style='text-align: center;'>" + dateInputInfoLabel.getText() + "<br>  (e.g. " + df.format(currentDate) + ")</HTML>");
		dateInputInfoLabel.setVisible(true);
		
		dateInputText.setLocation(0, dateInputInfoLabel.getLocation().y + dateInputInfoLabel.getSize().height);
		dateInputText.setSize(getSize().width, 35);
		dateInputText.setText(df.format(currentDate));
		dateInputText.setVisible(true);
		
		dateConfirmBtn.setLocation(getSize().width / 4, dateInputText.getLocation().y + dateInputText.getHeight() + 15);
		dateConfirmBtn.setSize(getSize().width / 2, 35);
		dateConfirmBtn.removeMouseListener(dateConfirmBtn.getMouseListeners()[0]);
		dateConfirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (setNewDate(dateInputText.getText())) {
					hideDatePickUI();
				}
				else {
					dateInputText.setText("Invalid date!");
				}
			}
		});
		dateConfirmBtn.setVisible(true);
		
		add(dateInputLayer, 0);
		
		ActionListener aniTimer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dateInputLayer.setLocation(0, dateInputLayer.getLocation().y - 2);
				if (dateInputLayer.getLocation().y <= 0) {
					uiTimer.stop();
					dateCardDisplayMode = true;
				}
			}
		};
		uiTimer = new Timer(1, aniTimer);
		uiTimer.start();
	}
	
	
	/**
	 * getter method for getDate
	 * 
	 * @return - String of the current date
	 */
	public String getDate() {
		if (currType == CARD_TYPE_TIME)
			return df.format(currentDate);
		else
			return df.format(new Date());
	}
	/**
	 * setter method to set a new date
	 * @param date - the new date we want to set
	 * @return true - if set successful
	 * 		   false - if get ParseException
	 */
	private boolean setNewDate(String date) {
		try {
			currentDate = df.parse(date);
			parentView.changeDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * private method, to hide date pick UI
	 * will be called in setDatePickMode
	 */
	private void hideDatePickUI() {
		if (currType == CARD_TYPE_TIME) {
			ActionListener aniTimer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					dateInputLayer.setLocation(0, dateInputLayer.getLocation().y + 2);
					if (dateInputLayer.getLocation().y >= getSize().height) {
						uiTimer.stop();
						dateInputLayer.setVisible(false);
						remove(dateInputLayer);
						dateCardDisplayMode = false;
						contentLabel.setText(df.format(currentDate));
						updateUI();
						setBackground(new Color(166, 171, 173));
					}
				}
			};
			uiTimer = new Timer(1, aniTimer);
			uiTimer.start();
		}
		
	}
	/**
	 * 
	 */
	private void setDatePickMode() {
		setDatePickMode(!dateCardDisplayMode);
	}
	
	/**
	 * setter method for Title
	 * 
	 * It will set the title of the card
	 * 
	 * @param lTitle - title of card 
	 */
	public void setTitle(String lTitle) {
		title = lTitle;
		updatePanel();
	}
	
	/**
	 * setter method for content
	 * 
	 * It will set the content of the card
	 * 
	 * @param lContent - content of the card
	 */
	public void setContent(String lContent) {
		content = lContent;
		updatePanel();
	}
	
	/**
	 * update the panel
	 * 
	 */
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
