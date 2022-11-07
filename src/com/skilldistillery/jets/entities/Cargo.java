package com.skilldistillery.jets.entities;

	public class Cargo extends Jet implements CargoCarrier{

		public Cargo(String model, int speed, int range, long cost) {
			super(model, speed, range, cost);
		}

		@Override
		public void loadCargo() {
			System.out.println("Cargo loaded for " + this.getModel());
		}

		@Override
		public void fly() {
			// TODO Auto-generated method stub
			
		}
}
