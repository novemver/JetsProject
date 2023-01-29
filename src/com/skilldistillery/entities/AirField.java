package com.skilldistillery.entities;

import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.FighterJet;

public class AirField {
	List<Jet> jets = new ArrayList<>();

	public void addJet(Jet jet) {
		jets.add(jet);
	}

	public void showFastestJet() {

	}

	public void fastestJet() {
		double fastest = 0;
		String goFaster = null;
		for (Jet jets : jets) {
			if (((Jet) jets).getSpeed() > fastest) {
				fastest = ((Jet) jets).getSpeed();

				goFaster = ((Jet) jets).toString();
			}
		}
		System.out.println("Fastest Jet: " + goFaster);
	}

	public void mostRange() {
		int goFar = 0;
		String bigRange = null;
		for (Jet jets : jets) {
			if (((Jet) jets).getRange() > goFar) {
				goFar = ((Jet) jets).getRange();
				bigRange = ((Jet) jets).toString();
			}

		}
		System.out.println(bigRange);
	}

	public void fly() {
		double flightTime = 0;
		for (Jet jets : jets) {
			flightTime = ((Jet) jets).getRange() / ((Jet) jets).getSpeed();
			System.out.println(jets + " Flight Time: " + String.format("%.2f", flightTime) + " Hours");
		}
	}

	public void printJets() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}
	
//	public void loadCargoJets() {
//		for (Jet jets : jets) {
//			if (jets instanceof CargoPlane) {
//			System.out.println(((Jet) jets).getModel() + " is being loaded with cargo.");
//			}
//		}
//	}

}