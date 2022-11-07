package com.skilldistillery.jets.entities;



public class Fighter extends Jet implements LockNLoad {

	public Fighter(String model, int speed, int range, long cost) {
		super(model, speed, range, cost);
	}

	@Override
	public void fight(boolean initiator) {
		if (initiator){
			System.out.println(this.getModel() + " initiated a dogfight!");
		} else {
			System.out.println(this.getModel() + " has entered the fight!");
		}
	}

	@Override
	public void bombing(boolean initiator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
}