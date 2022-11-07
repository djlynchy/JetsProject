package com.skilldistillery.jets.entities;


public abstract class Jet {
	private String model;
	private int speed;
	private int range;
	private long cost;
	
	public Jet(String model, int speed, int range, long cost) {
		this.model= model;
		this.speed= speed;
		this.range= range;
		this.cost= cost;
	}
	
	public abstract void fly();{ 
	if (range == 0 || speed == 0){
		System.out.println("Aircraft is grounded.");
		
	} else{
		int flightTime = range / speed;
		System.out.print( flightTime);
	}
}


public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public double getSpeed() {
	return speed;
}

public void setSpeed(int speed) {
	this.speed = speed;
}

public int getRange() {
	return range;
}

public void setRange(int range) {
	this.range = range;
}

public long getCost() {
	return cost;
}

public void setcost(long cost) {
	this.cost = cost;
}

@Override
public String toString() {
	return "Jet [model = " + model + ", speed = " + speed + ", range = " + range + ", cost = " + cost + "]";
}
}



	
	

    


		

