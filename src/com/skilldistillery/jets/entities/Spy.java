package com.skilldistillery.jets.entities;

public class Spy extends Jet implements Recon {

	public Spy(String model, int speed, int range, long cost) {
		super(model, speed, range, cost);
	}

	@Override
	public void takePicture() {
		System.out.println(this.getModel() + " spying on enemy!!");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

}