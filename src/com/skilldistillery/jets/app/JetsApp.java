package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Bomber;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetSimp;
import com.skilldistillery.jets.entities.LockNLoad;
import com.skilldistillery.jets.entities.Recon;
import com.skilldistillery.jets.entities.Rescue;

//User Story #1
//Create a JetsApplication with a main method to launch your program.
public class JetsApp {

		
		public static void main(String[] args ) {
			JetsApp jet= new JetsApp();
			jet.takeoff();
		}
				
private void takeoff() {			
	Scanner scan = new Scanner(System.in);
	String selection;

	do {
		displayMenu();
		selection = scan.nextLine();
		
		switch (selection) {
		case "1":
			listJets();
			break;
		case "2":
			flyJets();
			break;
		case "3":
			displayRange();
			break;
			case "4":
				viewFastest();
				break;
		case "5":
			loadCargo();
			break;
		case "6":
			bombing();
			break;
		case "7":
			recon();
			break;
		case "8":
			rescue();
			break;
		case "9":
			dogfight();
			break;
		case "10":
			addPlane();
			break;
		case "11":
			removePlane();
			break;
		case "12":
			System.out.println("thanks for using this program.");
			break;
		default:
			System.out.print("\nNot Valid. Enter any key to return to main menu: ");
			scan.nextLine();
		}
	} while (!selection.equals("12"));
	scan.close();
	}

private void displayMenu() {
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("^                              ^");
	System.out.println("^   1 : List the Fleet         ^");
	System.out.println("^   2 : Fly all the Jets       ^");
	System.out.println("^   3 : Longest Range record   ^");
	System.out.println("^   4 : Fastest record         ^");
	System.out.println("^   5 : Load the cargo         ^");
	System.out.println("^   6 : Bombs Away!            ^");
	System.out.println("^   7 : Take a Look(spy)       ^");
	System.out.println("^   8 : Rescue                 ^");
	System.out.println("^   9 : Dogfight               ^");
	System.out.println("^  10 : Add to the fleet       ^");
	System.out.println("^  11 : Remove from the fleet  ^");
	System.out.println("^  12 : Quit                   ^");
	System.out.println("^                              ^");
	System.out.println("********************************");
	
}


Airfield af = new Airfield();
public void launch() {
}
public void listJets() {
	List<Jet> jets = af.getFleet();
	for(Jet jet: jets) {
		System.out.println(jet);
	}
}

public void flyJets() {
	for(Jet jet : af.getFleet()){
		System.out.println(jet);
		jet.fly();
	}
}

public void viewFastest() {
	Jet fastest = null;
	for(Jet jet: af.getFleet()){
		if (fastest == null) {
			fastest = jet;
		} else if (jet.getSpeed() > fastest.getSpeed()){
			fastest = jet;
		}
	}
	System.out.println("Fastest: " + fastest);
}

public void displayRange() {
	Jet longestRange = null;
	for(Jet jet: af.getFleet()) {
		if(longestRange == null) {
			longestRange = jet;
		} else if (jet.getRange() > longestRange.getRange()) {
			longestRange = jet;
		}
	}
	System.out.println("Longest Range: " + longestRange);
}

public void loadCargo(){
	for(Jet jet : af.getFleet()){
		if(jet instanceof CargoCarrier){
			((CargoCarrier) jet).loadCargo();
			
			
		}
	}
}
public void bombing(){
	for(Jet jet : af.getFleet()){
		if(jet instanceof Bomber){
			((Bomber) jet).bombing(false);
			
			
		}
	}
}
public void recon(){
	for(Jet jet : af.getFleet()){
		if(jet instanceof Recon){
			((Recon) jet).takePicture();	
		}
	}
}
public void rescue(){
	for(Jet jet : af.getFleet()){
		if(jet instanceof Rescue){
			((Rescue) jet).rescue();
		}
	}
}

public void dogfight(){
	boolean initialJet = true;
	int combatants = 0;
	for(Jet jet : af.getFleet()){
		if(jet instanceof LockNLoad){
			((LockNLoad) jet).fight(initialJet);
			combatants ++;
			initialJet = false;
		}
	}
	if (combatants == 1){
		System.out.println("Looks like there are no other combatants...");
	} else if (combatants == 0){
		System.out.println("No jets with combat capability");
	}
}

public void addPlane(){
	Scanner scan = new Scanner(System.in);
	try {
		System.out.print("Enter the model: ");
		String model = scan.next();
		System.out.print("Enter the speed: ");
		int speed = scan.nextInt();
		System.out.print("Enter the range: ");
		int range = scan.nextInt();
		System.out.print("Enter the price: ");
		long cost = scan.nextLong();

		af.getFleet().add(new JetSimp(model, speed, range, cost));
		System.out.println("\nJet added\n");
	} catch (InputMismatchException e){
		System.out.println("Invalid input");
		scan.nextLine();
	}

}


public void removePlane(){
	Scanner scan = new Scanner(System.in);
	List<Jet> jets = af.getFleet();

	for(int i = 0; i < jets.size(); i++){
		System.out.println(i + 1 + ". " + jets.get(i));
	}

	System.out.print("\nSelect the number of the jet to delete: ");
	try{
		int choice = scan.nextInt();
		if(choice < jets.size() + 1 && choice > 0){
			System.out.println("\n" + jets.get(choice - 1).getModel() + " deleted\n");
			jets.remove(choice - 1);
		} else{
			System.out.println("Not a valid choice");
		}

	} catch (InputMismatchException e){
		System.out.println("Invalid input");
		scan.nextLine();
	}
	
}


}

