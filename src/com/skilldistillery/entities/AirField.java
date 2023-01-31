package com.skilldistillery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.skilldistillery.app.JetsApp;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.FighterJet;

public class AirField {
	private List<Jet> jets = new ArrayList<>();
	Scanner scanData = new Scanner(System.in);
	public void addJet(Jet jet) {
		jets.add(jet);
	}


	public void jetRemoval() {
		System.out.println("Please select from 1 - " + jets.size() + " to remove Jet");
		int count = 1;
		for (Jet jet : jets) {
			System.out.println(count + ". " + jet);
			count++;
		}
		int selectJet = scanData.nextInt();
		Jet jetGone = jets.remove(selectJet - 1);
		System.out.println(jetGone.getModel() + " has been reomved from the Air Field.");

	}
	public void inputJetData() {
		Jet inputJet;
		System.out.println("Please select type of Jet to add: \n1. Fighter Jet \n2. Cargo Plane \n3. Bomber");
		int inJetType = scanData.nextInt();

		System.out.println("Enter Jet Model Name: ");

		String inModel = scanData.next();
		scanData.nextLine();

		System.out.println("Enter Jet Top Speed: ");

		double inSpeed = scanData.nextDouble();
		scanData.nextLine();
		System.out.println("Enter Jet Range: ");

		int inRange = scanData.nextInt();
		scanData.nextLine();

		System.out.println("Enter Jet Price: ");

		long inPrice = scanData.nextLong();
		scanData.nextLine();

		if (inJetType == 1) {
			FighterJet userFighter = new FighterJet(inModel, inSpeed, inRange, inPrice);
			jets.add(userFighter);

		} else if (inJetType == 2) {
			CargoPlane userCarrier = new CargoPlane(inModel, inSpeed, inRange, inPrice);
			jets.add(userCarrier);

		} else if (inJetType == 3) {
			Bomber userBomber = new Bomber(inModel, inSpeed, inRange, inPrice);
			jets.add(userBomber);

		} else {
			System.out.println("Please Try Again");
		}
	}
	public void fastestJet() {
		double fastest = 0.0;
		double mach = 0.0;
		String goFaster = null;
		for (Jet jets : jets) {
			if (((Jet) jets).getSpeed() > fastest) {
				fastest = ((Jet) jets).getSpeed();

				goFaster = ((Jet) jets).toString();
				mach = ((Jet) jets).getSpeedInMach();
			}

		}
		System.out.println("Fastest Jet: " + goFaster + ", Mach Speed: " + String.format("%.2f", mach));
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
			System.out.println(jets + ", Flight Time: " + String.format("%.2f", flightTime) + " Hours at Mach "
					+ String.format("%.2f", ((Jet) jets).getSpeedInMach()));
		}
	}

	public void printJets() {
		System.out.println("Jets in AirField: ");
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}

	public void loadCargo() {
		for (Jet js : jets) {
			if (js instanceof CargoPlane) {
				((CargoPlane) js).loadCargo();
			}
		}
	}
	
	public void unLoadCargo() {
		for (Jet js : jets) {
			if (js instanceof CargoPlane) {
				((CargoPlane) js).unLoadCargo();
			}
		}
	}

	public void bombingMission() {
		for (Jet js : jets) {
			if (js instanceof Bomber) {
				((Bomber) js).bombingMission();
			}
		}
	}

	public void dogFight() {
		for (Jet js : jets) {
			if (js instanceof FighterJet) {
				((FighterJet) js).dogFight();
			}
		}
	}
	
	public void airSupport() {
		for (Jet js : jets) {
			if (js instanceof FighterJet) {
				((FighterJet) js).airSupport();
			}
		}
	}

}