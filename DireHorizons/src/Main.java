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
			try {
				if(Integer.parseInt(givenAge) >= 70 && Integer.parseInt(givenAge) <= 120) {
					player.age = Integer.parseInt(givenAge);
					System.out.println("I'm " + Integer.toString(player.age) + ". Who knew I'd live this long...");
					System.out.println("Thanks to Conglomerate scientific advances, people usually live to 120.");
					System.out.println("You have been awarded the 'Silver Fox' perk. You have a permanent +2 boost to Intelligence and Charm and will unlock some unique dialogue options.");
					player.intelligence = player.intelligence + 2;
					player.charm = player.charm + 2;
					player.perks.add("silverFox");
					//player.outputStats();
					//cc_input.close();
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
					//cc_input.close();
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
					//cc_input.close();
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
					//cc_input.close();
					ageVerif = true;
				} else if(Integer.parseInt(givenAge) < 18) {
					System.out.println("I'm definetly not that young. There'd be no sense in the Conglomeracy sending someone so young and inexperienced.");
				} 
			} 
			catch(Exception e){
				System.out.println("Thats not even a number... I need to starting thinking straight.");
			}
		
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The Conglomeracy consists of 60 countries. Your crewmen will include people from each nation. You and your family are from one of the most advanced nations, something you are very proud of.");
		System.out.println();
		boolean countrySet = false;
		
		while (!countrySet){
			System.out.println("[1] The Regal Union - The founder of the Conglomeracy, with natural-born, charismatic leaders and explorers.  ");
			System.out.println("[2] The Exalted Raj - One of the oldest nations of the Conglomeracy, renowned for producing intellects and revolutionary technology.");
			System.out.println("[3] The Magnate Dominion - A nation of two great peoples who have worked together for centuries to produce strong soldiers who can survive almost anything.");
			System.out.println("[4] The Cape Ascendancy - A country where good fitness and reflexes are held in the highest regard. They say a Caper can shoot a target from 100 miles away.");
			
			Scanner countryInput = new Scanner(System.in);
			System.out.println();
			System.out.println("I musn't forget my roots. I'm from: ");
			
			String givenCountry = countryInput.nextLine();
			
			try {
				if(Integer.parseInt(givenCountry) == 1) {
					player.countryOfOrigin = "The Regal Union";
					System.out.println("I'm from " + player.countryOfOrigin + ". I've proved to myself that I can be a good and diplomatic leader, now it's time to make my country proud.");
					System.out.println("Due to your training in the Union, you have become a skilled leader and are trained in both diplomatic and aggressive approaches to problems.");
					System.out.println("You have recieved a permanent +2 bonus to Leadership and Charm.");
					player.leadership = player.leadership + 2;
					player.charm = player.charm + 2;
					player.perks.add("Reglish");
					//countryInput.close();
					countrySet = true;
				} else if(Integer.parseInt(givenCountry) == 2) {
					player.countryOfOrigin = "The Exalted Raj";
					System.out.println("I'm from " + player.countryOfOrigin + ". I've proved to myself that I am intelligent and well-versed in the many branches of technology, now it's time to make my country proud.");
					System.out.println("Due to your training in the Raj, you are incredibly intelligent and are proficient in the use of technology of all sorts.");
					System.out.println("You have recieved a permanent +2 bonus to Intelligence and Technology.");
					player.intelligence = player.intelligence + 2;
					player.technology = player.technology + 2;
					player.perks.add("Rajka");
					//countryInput.close();
					countrySet = true;
				} else if(Integer.parseInt(givenCountry) == 3) {
					player.countryOfOrigin = "The Magnate Dominion";
					System.out.println("I'm from " + player.countryOfOrigin + ". I've proved to myself that I am a strong and resourceful warrior who can survive any scenario, now it's time to make my country proud.");
					System.out.println("Due to your training in the Dominion, you are strong, resourceful and able to survive in harsh and hostile environments.");
					System.out.println("You have recieved a permanent +2 bonus to Strength and Survivability.");
					player.strength = player.strength + 2;
					player.survivability = player.survivability + 2;
					player.perks.add("Magnish");
					//countryInput.close();
					countrySet = true;
				} else if(Integer.parseInt(givenCountry) == 4) {
					player.countryOfOrigin = "The Cape Ascendancy";
					System.out.println("I'm from " + player.countryOfOrigin + ". I've proved to myself that I am fast, agile, and an excellent marksman, now it's time to make my country proud.");
					System.out.println("Due to your training in the Ascendancy, you are able to move faster for longer than your fellow Conglomeratis. You have a keen eye and are an excellent marksman.");
					System.out.println("You have recieved a permanent +2 bonus to Speed and Marksmanship.");
					player.speed = player.speed + 2;
					player.marksmanship = player.marksmanship + 2;
					player.perks.add("Caper");
					//countryInput.close();
					countrySet = true;
				}
			}
			catch(Exception e) {
				System.out.println("I'm definetly not from there. That's not even in the Conglomeracy.");
				System.out.println("Please choose a number 1-4 to select your country of origin.");
				System.out.println();
			}
			
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Across all of the Conglomeracy, each nation has its own vast pool of professionals of various trades and specialties.\n Everyone who is able has a speciality which they have honed, and this proficiency decides what role they will carry out for their country.");
		System.out.println("For the Dire Horizons program, only people of certain professions are chosen. Your job and speciality makes you a suitable candidate for the mission.");
		System.out.println();
		System.out.println("[1] Engineering Corps - Trained in everything from modifying systems to programming Conglomerate, engineers are the backbone of any Conglomerate program.");
		System.out.println("[2] Military Corps - Trained in both unarmed and armed combat, Conglomerate soldiers are fearless and reliable. They provide security and policing across the nations.");
		System.out.println("[3] Navigational Corps - Trained to fly the latest rockets and aeroplanes, Conglomerate navigators have learnt the ins and outs of the complex navigational systems of Dire Horizon's vessels.");
		System.out.println("[4] Diplomatic Corps - Trained in diplomacy and negociation, Conglomerate diplomats are experts in all matters social and politcial. They are responsible for communication and any possible first contact procedures. ");
		System.out.println("Lastly, why am I here? I'm part of the: ");
		System.out.println();
		
		Scanner jobInput = new Scanner(System.in);
		
		String givenJob = jobInput.nextLine();
		System.out.println(givenJob);
		
		boolean jobSet = false;
		while(!jobSet) {
			try {
				if(Integer.parseInt(givenJob) == 1) {
					player.profession = "Engineering Corps";
					System.out.println("I'm a member of the " + player.profession + ". I'm a damn good engineer and it's my duty to keep the ship and all its systems operational.");
					System.out.println("Due to your rigorous engineer training you are skilled in the use of technology and are an expert in teamwork and communication.");
					System.out.println("You have recieved a +2 bonus to Technology and Charm and  and will unlock some unique dialogue options.");
					player.technology = player.technology + 2;
					player.charm = player.charm + 2;
					player.perks.add("engineer");
					jobSet = true;
				} else if(Integer.parseInt(givenJob) == 2) {
					player.profession = "Military Corps";
					System.out.println("I'm a member of the " + player.profession + ". I'm a damn good soldier and it's my duty to keep the ship and its crew safe from any threats, internal or external.");
					System.out.println("Due to your rigorous miltary training you are a skilled marksman and a strong hand-to-hand combatant.");
					System.out.println("You have recieved a +2 bonus to Marksmanship and Strength and will unlock some unique dialogue options.");
					player.marksmanship = player.marksmanship + 2;
					player.strength = player.strength + 2;
					player.perks.add("soldier");
					jobSet = true;
				} else if(Integer.parseInt(givenJob) == 3) {
					player.profession = "Navigational Corps";
					System.out.println("I'm a member of the " + player.profession + ". I'm a damn good navigator and it's my duty to guide the ship and its crew to our destination and ensure that our crew survives whatever environments we end up in.");
					System.out.println("Due to your rigorous navigator training you are a skilled navigator and an expert at surviving and navigating harsh environments.");
					System.out.println("You have recieved a +2 bonus to Survivability and Leadership and will unlock some unique dialogue options.");
					player.survivability = player.survivability + 2;
					player.leadership = player.leadership + 2;
					player.perks.add("navigator");
					jobSet = true;
				} else if(Integer.parseInt(givenJob) == 4) {
					player.profession = "Diplomatic Corps";
					System.out.println("I'm a member of the " + player.profession + ". I'm a damn good diplomat and it's my duty to ensure the crew is functioning at optimum capacity and that any disputes are resolved. If we make any sort of contact with another civilisation, our corps will be put into action.");
					System.out.println("Due to your rigorous diplomat training you are a skilled diplomat and an expert sociologist and negociator. Your corps is renowned for its emphasis on both mental and physical health.");
					System.out.println("You have recieved a +2 bonus to Intelligence and Speed and will unlock some unique dialogue options.");
					player.survivability = player.intelligence + 2;
					player.leadership = player.speed + 2;
					player.perks.add("diplomat");
					jobSet = true;
					player.outputPerks();
					player.outputStats();
					
				}
			}
			catch(Exception e) {
				System.out.println("That's definetly not my profession.");
			}
		}
	}
		

		
		 
		
		
		
		
		

		//String givenFirstName = "Bob";
		//player.firstName = givenFirstName;
		//System.out.println(player.firstName);
		//playerInput.close();
		
}


