package ca.uwo.csd.cs2212.team09;

public class TimeSeries_Record {
	private double myVal;
	private String myTime;
	
	public TimeSeries_Record(double value, String time) {
		myVal = value;
		myTime = time;
	}

	public double getValue() {
		return myVal;
	}
	
	public String getTime() {
		return myTime;
	}
	
}
