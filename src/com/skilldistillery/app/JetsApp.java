package com.skilldistillery.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.CargoCarrier;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.FighterJet;
import com.skilldistillery.entities.Jet;

public class JetsApp {
	private List<String> jets = new ArrayList<>();
	private AirField airField = new AirField();
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String jetFile = "jets.txt";
		JetsApp jA = new JetsApp();
		jA.readJetFile(jetFile);
		jA.launch();
	}

	public void launch() {
		airField.printJets();
		jetMenu();
	}

	public void jetMenu() {
//		String italic = "\u001b[3m";
//		String endItal = "\u001b[23m";
		Boolean seeMenu = true;

		System.out.println("Welcome to the JetsApp. Please select an option: ");
		System.out.println("List Fleet ");
		System.out.println("Fly all Jets ");
		System.out.println("View fastest Jet ");
		System.out.println("View Jet with longest range ");
		System.out.println("Load all Cargo Jets ");
		System.out.println("DogFight! ");
		System.out.println("Add a Jet to Fleet ");
		System.out.println("Remove a Jet from Fleet ");
		System.out.println("Quit ");

		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			airField.printJets();
			break;
		case 2:
			airField.fly();
			break;
		case 3:
			airField.fastestJet();
			break;
		case 4:
			airField.mostRange();
			break;
		case 5:
			if (jets instanceof CargoCarrier) {
//				cargoCarrier.loadCargoJets();
				}
			break;
		case 6:

			break;
		case 7:

			break;
		case 8:

			break;
		case 9:
			System.out.println("Quiting JetsApp");
			seeMenu = false;
			return;

		default:
			System.out.println("Please select from options 1 - 9");
			break;
		}
	}

	public void readJetFile(String jetFile) {

		try (BufferedReader bufIn = new BufferedReader(new FileReader(jetFile))) {
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] splitJetData = line.split(",");
//			String model, double speed, int range, long price
				String model = splitJetData[0];
				double speed = Double.parseDouble(splitJetData[1]);
				int range = Integer.parseInt(splitJetData[2]);
				Long price = Long.parseLong(splitJetData[3]);
				String jetType = splitJetData[4];
				Jet j;
				if (jetType.equals("CargoPlane")) {
					j = new CargoPlane(model, speed, range, price);
					airField.addJet(j);
				} else if (jetType.equals("FighterJet")) {
					j = new FighterJet(model, speed, range, price);
					airField.addJet(j);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}

	}

}
