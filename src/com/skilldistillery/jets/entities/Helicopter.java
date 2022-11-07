package com.skilldistillery.jets.entities;

public class Helicopter extends Jet implements Rescue {

	public Helicopter(String model, int speed, int range, long cost) {
		super(model, speed, range, cost);
	}

	@Override
	public void rescue() {
		System.out.println(this.getModel() + " Getting downed pilot!!");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
}