package com.skilldistillery.entities;

public class Bomber extends Jet implements BombsAway {

	public Bomber(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void bombingMission() {
		System.out.println(this.getModel() + " enroute to Bombing Mission Objective");
	}

}
