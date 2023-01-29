package com.skilldistillery.entities;

public class CargoCarrier extends CargoPlane {

	public CargoCarrier(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
//	public void loadCargoJets() {
//		for (Jet jets : jets) {
//			if (jets instanceof CargoPlane) {
//			System.out.println(((Jet) jets).getModel() + " is being loaded with cargo.");
//			}
//		}
//	}
	
public void unLoadCargo() {
	System.out.println("Unloading cargo now");
}
}
