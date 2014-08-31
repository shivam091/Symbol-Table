package org.symboltable;

import java.lang.Math;

/**
 * Java class to create a model of the DC Metro System.
 * 
 * @author shivam
 * 
 */
public class MetroSystem {

	/**
	 * Name of the station.
	 */
	protected String stationName;

	/**
	 * Symbol table holding all the metro stations.
	 */
	SymbolTable stations;

	/**
	 * Graph of metro stations.
	 */
	Graph metro;

	/**
	 * Default constructor to initialize the class.
	 */
	public MetroSystem() {
		stations = new SymbolTable();
		metro = new Graph();
	}

	/**
	 * Constructor to initialize class with <i>stationName</i>.
	 * 
	 * @param stationName
	 *            Name of the metro station.
	 */
	public MetroSystem(String stationName) {
		this.stationName = stationName;
		stations = new SymbolTable();
		metro = new Graph();
	}

	/**
	 * Method to create metro Station objects.
	 */
	public void metroStations() {

		System.out.println("Creating metro stations...");

		// Create metro stations. (x,y) coordinates measured in miles from Union
		// Station.
		MetroStation gA = new MetroStation("Greenbelt", 5.0, 12.0);
		gA.setParking(true);
		MetroStation gB = new MetroStation("College Park", 5.0, 10.0);
		gB.setParking(true);
		MetroStation gC = new MetroStation("Silver Spring", -0.5, 10.0);
		gC.setParking(true);
		MetroStation gD = new MetroStation("Fort Totten", 0.0, 2.0);
		gD.setParking(true);
		MetroStation gE = new MetroStation("Union Station", 0.0, 0.0);
		gE.setParking(false);
		MetroStation gF = new MetroStation("DuPont Circle", -3.0, 1.0);
		gF.setParking(false);
		MetroStation gG = new MetroStation("Catholic University", 0.0, 1.0);
		gG.setParking(false);
		MetroStation gH = new MetroStation("Judiciary Sq", -1.0, 0.5);
		gH.setParking(false);
		MetroStation gI = new MetroStation("National Airport", -1.0, -2.0);
		gI.setParking(true);

		// Add metro stations along the "orange" line ....
		MetroStation oA = new MetroStation("New Carrollton", 5.0, 8.0);
		oA.setParking(true);
		MetroStation oB = new MetroStation("Stadium-Armory", 1.0, -1.0);
		oB.setParking(true);
		MetroStation oC = new MetroStation("L Enfant Plaza", -1.0, -1.0);
		oC.setParking(false);
		MetroStation oD = new MetroStation("Smithsonian", -1.5, -0.8);
		oD.setParking(false);
		MetroStation oE = new MetroStation("Metro Center", -1.5, 0.0);
		oE.setParking(false);
		MetroStation oF = new MetroStation("Rosalyn", -4.5, 0.0);
		oF.setParking(false);
		MetroStation oG = new MetroStation("Ballston-GMU", -6.5, 0.0);
		oG.setParking(false);
		MetroStation oH = new MetroStation("Vienna", -12.0, 0.0);
		oH.setParking(true);

		// Add metro stations to the metro system database/symbol table.
		stations.put("Greenbelt", gA);
		stations.put("College Park", gB);
		stations.put("Silver Spring", gC);
		stations.put("Fort Totten", gD);
		stations.put("Union Station", gE);
		stations.put("DuPont Circle", gF);
		stations.put("Catholic University", gG);
		stations.put("Judiciary Sq", gH);
		stations.put("National Airport", gI);

		// Add stations along the orange line ....
		stations.put("New Carrollton", oA);
		stations.put("Stadium-Armory", oB);
		stations.put("L Enfant Plaza", oC);
		stations.put("Smithsonian", oD);
		stations.put("Metro Center", oE);
		stations.put("Rosalyn", oF);
		stations.put("Ballston-GMU", oG);
		stations.put("Vienna", oH);

		// Define stations along the green and red lines ....
		String redLine[] = { "Silver Spring", "Fort Totten",
				"Catholic University", "Union Station", "Metro Center",
				"DuPont Circle" };
		String greenLine[] = { "Greenbelt", "College Park", "Fort Totten",
				"Judiciary Sq", "L Enfant Plaza" };
		String yellowLine[] = { "National Airport", "L Enfant Plaza",
				"Judiciary Sq" };
		String orangeLine[] = { "New Carrollton", "Stadium-Armory",
				"L Enfant Plaza", "Smithsonian", "Metro Center", "Rosalyn",
				"Ballston-GMU", "Vienna" };

		// Add track assignments to metro station descriptions ....
		for (int i = 0; i < redLine.length; i = i + 1) {
			MetroStation m = (MetroStation) stations.get(redLine[i]);
			m.add("Red");
		}

		for (int j = 0; j < greenLine.length; j = j + 1) {
			MetroStation m = (MetroStation) stations.get(greenLine[j]);
			m.add("Green");
		}

		for (int j = 0; j < yellowLine.length; j = j + 1) {
			MetroStation m = (MetroStation) stations.get(yellowLine[j]);
			m.add("Yellow");
		}

		for (int j = 0; j < orangeLine.length; j = j + 1) {
			MetroStation m = (MetroStation) stations.get(orangeLine[j]);
			m.add("Orange");
		}
	}

	/**
	 * Method to define details of the DC Metro System Network.
	 */
	public void metroNetwork() {

		System.out.println("Creating metro network...");

		// Create links along green line .....
		metro.addEdge("Greenbelt", "College Park");
		metro.addEdge("College Park", "Fort Totten");
		metro.addEdge("Fort Totten", "Judiciary Sq");
		metro.addEdge("Judiciary Sq", "L Enfant Plaza");

		// Create links along red line .....
		metro.addEdge("Fort Totten", "Silver Spring");
		metro.addEdge("Fort Totten", "Catholic University");
		metro.addEdge("Catholic University", "Union Station");
		metro.addEdge("Judiciary Sq", "Union Station");
		metro.addEdge("Judiciary Sq", "Metro Center");
		metro.addEdge("DuPont Circle", "Metro Center");

		// Create links along yellow line .....
		metro.addEdge("Judiciary Sq", "L Enfant Plaza");
		metro.addEdge("L Enfant Plaza", "National Airport");

		// Create links along orange line .....
		metro.addEdge("New Carrollton", "Stadium-Armory");
		metro.addEdge("Stadium-Armory", "L Enfant Plaza");
		metro.addEdge("L Enfant Plaza", "Smithsonian");
		metro.addEdge("Smithsonian", "Metro Center");
		metro.addEdge("Metro Center", "Rosalyn");
		metro.addEdge("Rosalyn", "Ballston-GMU");
		metro.addEdge("Ballston-GMU", "Vienna");

	}

	/**
	 * Method to print details of the Metro System.
	 */
	public void print() {

		System.out.println("DC Metro System");
		System.out.println("===============");
		System.out.println(stations.toString());
	}

	public static void main(String args[]) {

		// Build model of metro stations and rail network ...
		MetroSystem ms = new MetroSystem("DC Metro");
		ms.metroStations();
		ms.metroNetwork();
		ms.print();

		// Retrieve and print details of individual metro stations ....
		System.out.println("");
		System.out.println("Metro Station Details");
		System.out.println("=====================");

		System.out.println(ms.stations.get("Greenbelt").toString());
		System.out.println(ms.stations.get("Fort Totten").toString());
		System.out.println(ms.stations.get("L Enfant Plaza").toString());

		// Rail trip: Leg 1. Travel from "College Park" to
		// "National Airport"....
		System.out.println();
		System.out.println("Source: College Park");
		System.out.println("Destination: National Airport");
		System.out.println("==========================================");

		BFSearcher bfs1 = new BFSearcher(ms.metro, "National Airport");
		bfs1.showPath("College Park");

		// Travel distance from "College Park" to "National Airport"....
		String travelPath[] = bfs1.path("Silver Spring");
		double travelDistance = 0.0;
		for (int i = 1; i < travelPath.length; i = i + 1) {
			MetroStation m = (MetroStation) ms.stations.get(travelPath[i]);
			MetroStation n = (MetroStation) ms.stations.get(travelPath[i - 1]);
			travelDistance = travelDistance
					+ Math.sqrt((m.dX - n.dX) * (m.dX - n.dX) + (m.dY - n.dY)
							* (m.dY - n.dY));
		}

		System.out.println();
		System.out.println("Leg 1. Travel Distance = " + travelDistance);
		System.out.println("==========================================");

		// Rail trip: Leg 2. Travel from "National Airport" to
		// "New Carrollton"....
		System.out.println();
		System.out.println("Source: National Airport");
		System.out.println("Destination: New Carrollton");
		System.out.println("==========================================");

		bfs1 = new BFSearcher(ms.metro, "New Carrollton");
		bfs1.showPath("National Airport");

		// Travel distance from "National Airport" to "New Carrollton"....
		String travelPath2[] = bfs1.path("National Airport");
		for (int i = 1; i < travelPath2.length; i = i + 1) {
			MetroStation m = (MetroStation) ms.stations.get(travelPath2[i]);
			MetroStation n = (MetroStation) ms.stations.get(travelPath2[i - 1]);
			travelDistance = travelDistance
					+ Math.sqrt((m.dX - n.dX) * (m.dX - n.dX) + (m.dY - n.dY)
							* (m.dY - n.dY));
		}

		System.out.println();
		System.out.println("Total Travel Distance = " + travelDistance);
		System.out.println("==========================================");
	}
}