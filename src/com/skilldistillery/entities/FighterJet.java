package com.skilldistillery.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void dogFight() {
		System.out.println(this.getModel() + " is engaged in Dog Fight!");
	}

	@Override
	public void airSupport() {
		System.out.println(this.getModel() + " is enroute to support troops in contact");

	}

}