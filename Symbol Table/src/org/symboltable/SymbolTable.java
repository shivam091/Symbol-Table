package org.symboltable;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

/**
 * Symbol table implementation using Java's HashMap library. If you add a
 * key-value pair and the key is already present, the new key-value pair
 * replaces the old one.
 * 
 * @author shivam
 * 
 */
public class SymbolTable {

	private HashMap<String, Object> st = new HashMap<String, Object>();

	/**
	 * Method to add new <i>key</i> and <i>value</i> pair to the HashMap.
	 * 
	 * @param key
	 *            Key.
	 * @param value
	 *            Value.
	 */
	public void put(String key, Object value) {
		st.put(key, value);
	}

	/**
	 * Method to return value for the <i>key</i>.
	 * 
	 * @param key
	 *            Key of which value is to be returned.
	 * @return Returned value.
	 */
	public Object get(String key) {
		return st.get(key);
	}

	/**
	 * Method to convert HashMap to string.
	 */
	@Override
	public String toString() {
		return st.toString();
	}

	/**
	 * Method to return an array contains all of the keys.
	 * 
	 * @return Array of keys.
	 */
	public String[] keys() {
		Set<?> keyvalues = st.entrySet();
		String[] keys = new String[st.size()];
		Iterator<?> it = keyvalues.iterator();
		for (int i = 0; i < st.size(); i++) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) it.next();
			keys[i] = (String) entry.getKey();
		}
		return keys;
	}

	public static void main(String[] args) {

		SymbolTable symbolTable = new SymbolTable();

		// Create metro stations ....
		MetroStation gA = new MetroStation("Greenbelt", 100.0, 100.0);
		gA.setParking(true);
		MetroStation gB = new MetroStation("College Park", 100.0, 80.0);
		gB.setParking(true);
		MetroStation gC = new MetroStation("Silver Spring", 70.0, 90.0);
		gC.setParking(true);
		MetroStation gD = new MetroStation("Fort Totten", 70.0, 70.0);
		gD.setParking(false);
		MetroStation gE = new MetroStation("Union Station", 50.0, 50.0);
		gE.setParking(false);
		MetroStation gF = new MetroStation("DuPont Circle", 20.0, 60.0);
		gF.setParking(false);
		MetroStation gG = new MetroStation("Catholic University", 60.0, 60.0);
		gG.setParking(false);

		// Insert some (key, value pairs)
		symbolTable.put("Greenbelt", gA);
		symbolTable.put("College Park", gB);
		symbolTable.put("Silver Spring", gC);
		symbolTable.put("Fort Totten", gD);
		symbolTable.put("Union Station", gE);
		symbolTable.put("DuPont Circle", gF);
		symbolTable.put("Catholic University", gG);

		// Define stations along the green and red lines ....
		String redLine[] = { "Silver Spring", "Fort Totten",
				"Catholic University", "Union Station", "DuPont Circle" };
		String greenLine[] = { "Greenbelt", "College Park", "Fort Totten" };

		// Add track assignments to Metro Station Descriptions ....
		for (int i = 0; i < redLine.length; i = i + 1) {
			MetroStation m = (MetroStation) symbolTable.get(redLine[i]);
			m.add("Red");
		}

		for (int j = 0; j < greenLine.length; j = j + 1) {
			MetroStation m = (MetroStation) symbolTable.get(greenLine[j]);
			m.add("Green");
		}

		// Ride along track and retrieve station information.
		System.out.println(symbolTable.get("Greenbelt").toString());
		System.out.println(symbolTable.get("College Park").toString());
		System.out.println(symbolTable.get("Fort Totten").toString());
		System.out.println(symbolTable.get("DuPont Circle").toString());
	}
}