package com.skilldistillery.jets.entities;

public class Bomber extends Jet implements LockNLoad {

	public Bomber(String model, int speed, int range, long cost) {
		super(model, speed, range, cost);
	}

	@Override
	public void bombing(boolean initiator) {
		if (initiator){
			System.out.println(this.getModel() + " Stay on target!!");
		} else {
			System.out.println(this.getModel() + " Bombs Away!!!");
		}
	}

	@Override
	public void fight(boolean c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
}