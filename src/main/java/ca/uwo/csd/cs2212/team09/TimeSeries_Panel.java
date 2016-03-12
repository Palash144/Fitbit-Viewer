package ca.uwo.csd.cs2212.team09;

import javax.swing.JPanel;
import org.jfree.chart.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import org.jfree.data.*;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TimeSeries_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JPanel chartPanel = new JPanel();
	private String currDate;
	private ChartPanel cPanel;
	private MainView parent;
	private JTextField textField;
	
	
	public TimeSeries_Panel(MainView p) {
		parent = p;
		chartPanel.setBackground(Color.LIGHT_GRAY);
		
		JComboBox<String> minIntBox = new JComboBox<String>();
		JComboBox<String> hourIntBox = new JComboBox<String>();
		String[] hL = getHourInterval();
		for (int i=0; i<hL.length;i++) {
			hourIntBox.addItem(hL[i]);
		}
		hourIntBox.setSelectedIndex(0);
		String[] mL = getMinuteInterval("Whole day");
		for (int i=0;i<mL.length;i++) {
			minIntBox.addItem(mL[i]);
		}
		minIntBox.setSelectedIndex(0);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk)
					.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
					.addComponent(hourIntBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(minIntBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOk)
								.addComponent(minIntBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(hourIntBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		drawData();
	}
	
	private String[] getHourInterval() {
		String[] rt = {"Whole day", "1AM", "2AM", "3AM", "4AM", "5AM", "6AM", "7AM", "8AM", "9AM", "10AM", "11AM", "12PM",
									"1PM", "2PM", "3PM", "4PM", "5PM", "6PM", "7PM", "8PM", "9PM", "10PM", "11PM", "12AM"};
		return rt;
	}
	
	private String[] getMinuteInterval(String hourStr) {
		if (hourStr == "Whole day") {
			String[] rt = {"15 mins", "30 mins", "45 mins", "1 hour"};
			return rt;
		}else {
			String[] rt = {"1 min", "5 min", "10 min", "15 min"};
			return rt;
		}
	}
	
	public void drawData() {
		final TimeSeries seriesSteps = new TimeSeries("Steps", Minute.class);
        final Hour hour = new Hour();
        seriesSteps.add(new Minute(1, hour), 1033.2);
        seriesSteps.add(new Minute(3, hour), 1234.3);
        seriesSteps.add(new Minute(9, hour), 143.6);
        seriesSteps.add(new Minute(11, hour), 113.9);
        seriesSteps.add(new Minute(15, hour), 133.5);
        seriesSteps.add(new Minute(19, hour), 10.9);
        
        final TimeSeries seriesCalories = new TimeSeries("Calories", Minute.class);
        seriesCalories.add(new Minute(1, hour), 15.2);
        seriesCalories.add(new Minute(3, hour), 1123.3);
        seriesCalories.add(new Minute(9, hour), 12.6);
        seriesCalories.add(new Minute(11, hour), 121.9);
        seriesCalories.add(new Minute(15, hour), 1353.5);
        seriesCalories.add(new Minute(19, hour), 10.9);
        
        final TimeSeriesCollection dataset = new TimeSeriesCollection(seriesSteps);
        dataset.addSeries(seriesCalories);
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Time Series on " + currDate,
            "Time", 
            "Value",
            dataset,
            true,
            true,
            false
        );
        if (cPanel != null) {
        	cPanel.setChart(chart);
        }
        else {
        	cPanel = new ChartPanel(chart);
        }
        cPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        GroupLayout gl_chartPanel = new GroupLayout(chartPanel);
        gl_chartPanel.setHorizontalGroup(
        	gl_chartPanel.createParallelGroup(Alignment.LEADING)
        		.addComponent(cPanel, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        gl_chartPanel.setVerticalGroup(
        	gl_chartPanel.createParallelGroup(Alignment.LEADING)
        		.addComponent(cPanel, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );
        chartPanel.setLayout(gl_chartPanel);
	}
}
