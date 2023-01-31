package com.skilldistillery.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, Long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(this.getModel() + " is being loaded now");
	}

	@Override
	public void unLoadCargo() {
		System.out.println(this.getModel() + " is being unloaded now");

	}

}