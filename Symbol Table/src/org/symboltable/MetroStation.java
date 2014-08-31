package org.symboltable;

import java.util.ArrayList;
import java.util.List;

/**
 * Java class to construct details of Metro stations.
 * 
 * @author shivam
 * 
 */
public class MetroStation extends Node {

	/**
	 * Name of the metro station.
	 */
	protected String stationName;

	/**
	 * List of name of metro stations which are on track.
	 */
	protected List<String> onTrack;

	/**
	 * Check whether the particular metro station has parking facility.
	 */
	protected boolean parking;

	/**
	 * constructor to initial class with <i>stationName</i>, <i>dX</i>, and
	 * <i>dY</i>.
	 * 
	 * @param stationName
	 *            Name of the metro station.
	 * @param dX
	 *            X coordinate of metro station.
	 * @param dY
	 *            Y coordinate of metro station.
	 */
	public MetroStation(String stationName, double dX, double dY) {
		super(dX, dY);
		this.stationName = stationName;
		onTrack = new ArrayList<String>();
		parking = false;
	}

	/**
	 * Method to set parking node.
	 * 
	 * @param parking
	 *            true or false.
	 */
	public void setParking(boolean parking) {
		this.parking = parking;
	}

	/**
	 * Method to assign metro station to a track
	 * 
	 * @param track
	 *            Name of station to be added to track.
	 */
	public void add(String track) {
		onTrack.add(track);
	}

	/**
	 * Method to convert description of metro station to a string.
	 */
	@Override
	public String toString() {
		String s = "MetroStation(\"" + stationName + "\")\n"
				+ "   Coordinates = (" + dX + ", " + dY + ")\n"
				+ "   Parking = " + parking + "\n";

		if (onTrack.size() > 0) {
			s = s.concat("   Track   = { ");
			for (int i = 0; i < onTrack.size(); i = i + 1)
				s = s.concat(onTrack.get(i) + " ");
			s = s.concat("}\n");
		}

		return s;
	}

	public static void main(String args[]) {

		// Create "Versova" station at coordinate (80,80)...

		MetroStation stationA = new MetroStation("Versova", 80.0, 80.0);
		stationA.setParking(true);
		stationA.add("Green");
		System.out.println(stationA.toString());

		// Create "D.N. Nagar" station at coordinate (70,70)...
		MetroStation stationB = new MetroStation("D.N. Nagar", 70.0, 70.0);
		stationB.setParking(true);
		stationB.add("Green");
		stationB.add("Red");
		System.out.println(stationB.toString());
	}
}