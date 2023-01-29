package com.skilldistillery.entities;

public class CombatReady extends FighterJet {

	public CombatReady(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void dogFight() {
		System.out.println("Jet now engaged in Dog Fight. ");
	}

	public void airSupport() {
		System.out.println("Jet engaged in close air support. ");
	}
}
