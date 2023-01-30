package com.skilldistillery.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.Bomber;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.FighterJet;
import com.skilldistillery.entities.Jet;

public class JetsApp {
	private AirField airField = new AirField();

	public static void main(String[] args) {
		String jetFile = "jets.txt";
		JetsApp jA = new JetsApp();
		jA.readJetFile(jetFile);
		jA.launch();
	}

	public void launch() {
		airField.printJets();
		airField.jetMenu();
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
		} catch (IOException e) {
			System.err.println(e);
		}

	}

}