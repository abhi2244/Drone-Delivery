package version_1;

import java.io.*;
import java.net.*;
import java.util.*;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author Abhishek
 *
 */

public class Drone {

	private String Name;
	private Double Speed = 100.00;

	/**
	 * @return drone name
	 */
	public String getDroneName() {
		return Name;
	}
	/**
	 * @param set drone name
	 */
	public void setDroneName(String CarName) {
		this.Name = CarName;
	}
	/**
	 * @return drone speed
	 */
	public double getDroneSpeed() {
		return Speed;
	}
	/**
	 * @param set drone speed
	 */
	public void setDroneSpeed(double Speed) {
		this.Speed = Speed;
	}
	
	public double getDistance (String origin, String destination) throws IOException, JSONException {
		String new_string="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origin+"&destinations="+destination;
		//System.out.println(new_string);
		URL url = new URL(new_string);
		
		
		//URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=713+D+S+N+College+Road+A+B+Nagar+Unnao&destinations=Z+Square+16/113+MG+Marg+Kanpur");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		String line, outputString = "";
		BufferedReader reader = new BufferedReader(
		new InputStreamReader(conn.getInputStream()));
		while ((line = reader.readLine()) != null) {
		     outputString += line;
		}
		//System.out.println(outputString);
		
		JSONObject jObject  = new JSONObject(outputString); // json
		JSONArray j1=jObject.getJSONArray("rows");
		JSONObject j2= (JSONObject) j1.get(0);		
		JSONArray j3=j2.getJSONArray("elements");
		JSONObject j4= (JSONObject) j3.get(0);
		JSONObject j5=j4.getJSONObject("distance");
		String dur=j5.getString("text");
		
		String[] s=dur.split(" ");
		double duration =Double.parseDouble(s[0]);
		//System.out.println(duration +" (in K.M.)");
		return duration;
	}

}
