package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

//User Story #2
//Jets are found at an AirField. Create the AirField class, which has an empty List of Jets.
public class Airfield {
	private ArrayList<Jet> fleet = new ArrayList<>();
	//fleet.add("Cargo");
	
	
	public Airfield() {
		readFromFile("jets.txt", fleet);
		
	}

	public void readFromFile(String fn, Collection<Jet> namesColl) {

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] fields = line.split(",");
			String model = fields[1];
			int speed = Integer.parseInt (fields[2]);
			int range = Integer.parseInt (fields[3]);
			long cost = Long.parseLong (fields[4]);
			if(fields[0].equals( "Fighter")) {
		     fleet.add(new Fighter(model, speed, range, cost)); 
			}
			if(fields[0].equals( "Cargo")) {
			     fleet.add(new Cargo(model, speed, range, cost)); 
				}
			if(fields[0].equals( "Spy")) {
				     fleet.add(new Spy(model, speed, range, cost)); 
				}
			if(fields[0].equals( "Helicopter")) {
				     fleet.add(new Helicopter(model, speed, range, cost)); 
				}
			if(fields[0].equals( "Bomber")) {
				     fleet.add(new Bomber(model, speed, range, cost)); 
				}
			
			
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public ArrayList<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(ArrayList<Jet> fleet) {
		this.fleet = fleet;
		
	}
}