import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		NPC test = new NPC();
		test.firstName = "test";
		test.lastName = "Bloberts";
		test.countryOfOrigin = "Italy";
		test.age = 21;
		test.profession = "Geologist";
		
		menu();
		}
	
	public static void menu() {
		try {
			Scanner fileReader = new Scanner(new File("save.txt"));
			System.out.println("File Found.");
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No save files exist. Would you like to start a new game? (Y/N)");
			
			Scanner noSaveScanner = new Scanner(System.in);
			String noGameMenuChoice = noSaveScanner.nextLine();
			
			if (noGameMenuChoice.equalsIgnoreCase("y")) {
				prologue();
			} else if (noGameMenuChoice.equalsIgnoreCase("n")) {
				//noSaveScanner.close();
				quit();
			}else {
				System.out.println("Invalid input"); 
				menu();
			}
			noSaveScanner.close();
		}
	}
	
	public static void quit() {
		System.out.println("Quitting...");
		System.exit(0);
	}
	
	public static void prologue(){
		System.out.println();
		System.out.println("Our world is falling to pieces...");
		System.out.println();
		System.out.println("Tensions between East and West Terra have continued to rise ever since the war ended 100 years ago.");
		System.out.println();
		System.out.println("Both sides scramble to annex and amalgamate as many nations they can lay their hands on, in order to meet the increasing resource demands of their costly conflict");
		System.out.println();
		System.out.println("The threat of war between these two titans was once deemed impossible, when the destruction it would wreak was considered.");
		System.out.println();
		System.out.println("Now it is only a matter of time...");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The United Conglomeracy is a federation of nations that lie between the Eastern and Western coalitions.");
		System.out.println("So far, The Conglomeracy has managed to remain neutral in the eyes of both factions. Instead of desperately stockpiling arms and funding proxy wars the Conglomeracy spends its resources on scientific ventures.");
		System.out.println("The nations within this federation have all provided their best scientists into a project to take men beyond their homeworld in the event of an all-out war between the coalitions.");
		System.out.println("It is likely that a war between the two sides would destroy Terra. This project aims to give humanity a chance to survive, and to start afresh.");
		System.out.println("You have been carefully selected to be a crew member on the hurridly assembled U.C.S. Kariba due to your ability, hard work and dedication to your profession.");
		System.out.println("You and your team must work flawlessy in order to give mankind another chance, and to make sure this project was not in vain.");
		System.out.println("This is the story of project Dire Horizons.");
		System.out.println("A Java game by Benjamin McGregor-Lipman.");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		characterCreation();
	}
	
	public static void characterCreation() {
		System.out.println("You sit quietly on the transport, occasionally glancing out of the window to view the huge white monlith that will be taking you and your fellow crewmen to the stars.");
		System.out.println();
		System.out.println("The sound of distant bangs and the sudden change in weather indicates that a Maelstrom warhead has hit one of the Western nations. It won't be long before the world is blanketed by nuclear devasation.");
		System.out.println();
		System.out.println("The scale of your task is overwhelming. You sit forward and take a moment to reflect who you really are, and why you have been chosen.");
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		Player player = new Player();
		Scanner cc_input = new Scanner(System.in);
		player.perks = new ArrayList<String>();
		
		System.out.println("My first name is: ");
		
		player.firstName = cc_input.nextLine();
		
		System.out.println("My last name is: ");
		
		player.lastName = cc_input.nextLine();
		
		System.out.println("Thats right... " + "I'm " + player.getfullName() + ".");
		
		Boolean ageVerif = false;
		while(!ageVerif) {
			System.out.println("My age: ");
			String givenAge = cc_input.nextLine();
			
			if(Integer.parseInt(givenAge) >= 70 && Integer.parseInt(givenAge) <= 120) {
				player.age = Integer.parseInt(givenAge);
				System.out.println("I'm " + Integer.toString(player.age) + ". Who knew I'd live this long...");
				System.out.println("Thanks to Conglomerate scientific advances, people usually live to 120.");
				System.out.println("You have been awarded the 'Silver Fox' perk. You have a permanent +2 boost to Intelligence and Charm and will unlock some unique dialogue options.");
				player.intelligence = player.intelligence + 2;
				player.charm = player.charm + 2;
				player.perks.add("silverFox");
				//player.outputStats();
				ageVerif = true;
			} else if(Integer.parseInt(givenAge) > 120) {
				System.out.println("I can't be that old... Even if I was, why would the Conglomeracy send people my age into space.");
			} else if(Integer.parseInt(givenAge) < 70 && Integer.parseInt(givenAge) >= 50) {
				player.age = Integer.parseInt(givenAge);
				System.out.println("That's right, I'm " + Integer.toString(player.age) + ", with plenty of experience and I've still got plently of life in me. By Conglomercy standards at least.");
				System.out.println("To Conglomerate citizens you'd be considered middle age. Your generation are well-respected for their dedication and sensibility.");
				System.out.println("You've been awarded the 'Seasoned Boomer' perk. You have a permanent +2 boost to Strength and Leadership and will unlock some unique dialogue options.");
				player.strength = player.strength + 2;
				player.leadership = player.leadership + 2;
				player.perks.add("seasonedBoomer");
				//player.outputStats();
				ageVerif = true;
			} else if(Integer.parseInt(givenAge) < 50 && Integer.parseInt(givenAge) >= 30) {
				player.age = Integer.parseInt(givenAge);
				System.out.println("I'm only " + Integer.toString(player.age) + ". I might be young, but I'm fit and prepared for this mission. I'll make my family proud and prove to everyone I can do what's needed.");
				System.out.println("Your generation are seen by some as rash and reckless, though your generational fitness and technological understanding is highly-valued.");
				System.out.println("You've been awarded the 'Youthful Wiz' perk. You have a permanent +2 boost to Technology and Speed and will unlock some unique dialogue options.");
				player.technology = player.technology + 2;
				player.speed = player.speed + 2;
				player.perks.add("youthfulWiz");
				//player.outputStats();
				ageVerif = true;
			} else if(Integer.parseInt(givenAge) < 30 && Integer.parseInt(givenAge) >= 18){
				player.age = Integer.parseInt(givenAge);
				System.out.println(Integer.toString(player.age) + ". I'm very lucky to be selected for a mission like this at my age. I have so much to prove, and I must show that the youngest generation is capable of building this new civilisation.");
				System.out.println("Your generation have been trained intensley for survival, as it is your age group who will be forced to fight when one of the Coalitions inevitably declairs war.");
				System.out.println("You've been awarded the 'Child of Conflict' perk. You have a permanent +2 boost to Marksmanship and Survivability and will unlock some unique dialogue options.");
				player.marksmanship = player.marksmanship + 2;
				player.survivability = player.survivability + 2;
				player.perks.add("childOfConflict");
				//player.outputStats();
				ageVerif = true;
			} else if(Integer.parseInt(givenAge) < 18) {
				System.out.println("I'm definetly not that young. There'd be no sense in the Conglomeracy sending someone so young and inexperienced.");
			} else {
				System.out.println("Thats not even a number... I need to starting thinking straight.");
			}
		}
		
		System.out.println("You've escaped the while loop");
		
		 
		
		
		
		
		

		//String givenFirstName = "Bob";
		//player.firstName = givenFirstName;
		//System.out.println(player.firstName);
		//playerInput.close();
		
	}

}
