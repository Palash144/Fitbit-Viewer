package ca.uwo.csd.cs2212.team09;

public class TimeSeries_Record {
	private int steps;
	private double calories;
	private double distance;
	private int hr;
	private String time;
	
	
	/**
	 * 
	 * @param stepV
	 * @param calV
	 * @param disV
	 * @param hrV
	 * @param timeV
	 */
	public TimeSeries_Record(int stepV, double calV, double disV, int hrV, String timeV) {
		steps = stepV;
		calories = calV;
		distance = disV;
		hr = hrV;
		time = timeV;
	}

	public int getSteps() {
		return steps;
	}
	
	public double getCalories() {
		return calories;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public int getHr() {
		return hr;
	}
	
	public String getTime() {
		return time;
	}
	
}
