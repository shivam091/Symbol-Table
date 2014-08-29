package org.symboltable;

import java.util.ArrayList;
import java.util.List;

/**
 * Stations along a rail track in the Washington DC Metro.
 * 
 * @author shivam
 * 
 */
public class Track {

	/**
	 * Name of the track.
	 */
	protected String trackName;

	/**
	 * List of stations on the track.
	 */
	protected List<String> stations;

	/**
	 * Default constructor.
	 */
	public Track() {
		stations = new ArrayList<String>();
	}

	/**
	 * Constructor to <i>trackName</i>.
	 * 
	 * @param trackName
	 *            Name of the track.
	 */
	public Track(String trackName) {
		this.trackName = trackName;
		stations = new ArrayList<String>();
	}

	/**
	 * Constructor to <i>trackName</i> along with list of stations of that
	 * track.
	 * 
	 * @param trackName
	 *            Name of the track.
	 * @param stationNames
	 *            Name of stations of that track.
	 */
	public Track(String trackName, String stationNames[]) {
		this.trackName = trackName;
		stations = new ArrayList<String>();
		for (int i = 0; i < stationNames.length; i = i + 1)
			stations.add(stationNames[i]);
	}

	/**
	 * Method to set name of track.
	 * 
	 * @param trackName
	 *            Name of the track to be set.
	 */
	public void setName(String trackName) {
		this.trackName = trackName;
	}

	/**
	 * Method to add station to track.
	 * 
	 * @param trackName
	 *            Name of the station to be added to the track.
	 */
	public void add(String trackName) {
		stations.add(trackName);
	}

	/**
	 * Method to convert node to a string
	 * 
	 * @return Node details in string format.
	 */
	@Override
	public String toString() {
		String s = "Track(\"" + trackName + "\")\n";
		for (int i = 0; i < stations.size(); i = i + 1)
			s = s.concat("  " + stations.get(i) + "\n");

		return s;

	}

	public static void main(String args[]) {

		System.out.println("Exercise methods in Track class");
		System.out.println("===============================");

		// Create list of stations of "green" track ....
		Track tA = new Track("Green");
		tA.add("Greenbelt");
		tA.add("College Park");
		tA.add("PG Plaza");
		tA.add("Fort Totten");
		tA.add("L Enfant Plaza");

		// Create list of stations along "red" track ....
		String redTrack[] = { "Silver Spring", "Fort Totten",
				"Catholic University", "Union Station", "DuPont Circle" };
		Track tB = new Track("Red", redTrack);

		// Print details of "Green" and "Red" tracks ....
		System.out.println(tA.toString());
		System.out.println(tB.toString());
	}
}