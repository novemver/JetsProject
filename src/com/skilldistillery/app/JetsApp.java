package com.skilldistillery.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.Bomber;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.FighterJet;
import com.skilldistillery.entities.Jet;

public class JetsApp {
	private AirField airField = new AirField();
	Scanner scanData = new Scanner(System.in);
	public static void main(String[] args) {
		String jetFile = "jets.txt";
		JetsApp jA = new JetsApp();
		jA.readJetFile(jetFile);
		jA.launch();
	}

	public void launch() {
		this.airField.printJets();
		jetMenu();
		inputJetData();
	}

	public void readJetFile(String jetFile) {

		try (BufferedReader bufIn = new BufferedReader(new FileReader(jetFile))) {
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] splitJetData = line.split(",");
				String model = splitJetData[0];
				double speed = Double.parseDouble(splitJetData[1]);
				int range = Integer.parseInt(splitJetData[2]);
				Long price = Long.parseLong(splitJetData[3]);
				String jetType = splitJetData[4];
				Jet j;
				if (jetType.equalsIgnoreCase("CargoPlane")) {
					j = new CargoPlane(model, speed, range, price);
					airField.addJet(j);
				} else if (jetType.equalsIgnoreCase("FighterJet")) {
					j = new FighterJet(model, speed, range, price);
					airField.addJet(j);
				} else if (jetType.equalsIgnoreCase("Bomber")) {
					j = new Bomber(model, speed, range, price);
					airField.addJet(j);
				}

			}
			bufIn.close();

		} catch (IOException e) {
			System.err.println(e);
		}

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
			airField.addJet(userFighter);

		} else if (inJetType == 2) {
			CargoPlane userCarrier = new CargoPlane(inModel, inSpeed, inRange, inPrice);
			airField.addJet(userCarrier);

		} else if (inJetType == 3) {
			Bomber userBomber = new Bomber(inModel, inSpeed, inRange, inPrice);
			airField.addJet(userBomber);

		} else {
			System.out.println("Please Try Again");
		}
	}
	
	
	public void jetMenu() {
		Boolean seeMenu = true;

		System.out.println("\nWelcome to the JetsApp. Please select an option: ");
		System.out.println("1. List Fleet ");
		System.out.println("2. Fly all Jets ");
		System.out.println("3. View Fastest Jet ");
		System.out.println("4. View Jet with longest range ");
		System.out.println("5. Load Cargo Jets ");
		System.out.println("6. Unload Cargo Jets ");
		System.out.println("7. Dog Fight! ");
		System.out.println("8. Air Support ");
		System.out.println("9. Bombing Mission ");
		System.out.println("10. Add a Jet to Fleet ");
		System.out.println("11. Remove a Jet from Fleet ");
		System.out.println("12. Quit ");

		int choice = scanData.nextInt();
		switch (choice) {
		case 1:
			airField.printJets();
			jetMenu();
			break;
		case 2:
			airField.fly();
			jetMenu();
			break;
		case 3:
			airField.fastestJet();
			jetMenu();
			break;
		case 4:
			airField.mostRange();
			jetMenu();
			break;
		case 5:
			airField.loadCargo();

			jetMenu();
			break;
		case 6:
			airField.unLoadCargo();
			jetMenu();
			break;
		case 7:
			airField.dogFight();
			jetMenu();
			break;
		case 8:
			airField.airSupport();
			jetMenu();
			break;
		case 9:
			airField.bombingMission();
			jetMenu();
			break;
		case 10:
			inputJetData();
			jetMenu();
			break;
		case 11:
			airField.jetRemoval();
			jetMenu();
			break;
		case 12:
			System.out.println("Quiting JetsApp");
			scanData.close();

			seeMenu = false;
			return;

		default:
			System.out.println("Please select from options 1 - 12");
			jetMenu();
			break;
		}
	}

}