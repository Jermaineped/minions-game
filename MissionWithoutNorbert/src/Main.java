import java.util.Scanner;

public class Main {

	public static void main (String []  args) {
		
		// Scanner für Eingaben
		Scanner scanner = new Scanner(System.in);
	
		// Deklaration & Initalisierung von Variablen
		final int minions = 11;
		int tempMinionsLeft = 0;
		int tempMinionsRight = 0;
		int norbert = (int) (Math.floor(Math.random() * 11));
		boolean play = true; 
		int sideRand = 0;
		int number = 0;
		char side = '0';
		int game;
		int team1 = 0;
		int team2 = 0;		
		int tempLeft = 0;
		int tempRight = 0;
		int leftSide = norbert % minions;
		int rightSide = (minions - norbert) - 1;
		tempMinionsLeft = leftSide;
		tempMinionsRight = rightSide;
		
		// Beggin Spiel + Erklaerung
		System.out.println("Willkommen bei Mission without Norbert.");
		System.out.println("Ziel ist es, sich ein Starkes Team zusammen zu stellen ohne Norbert, da norbert sich immer äußerst ungeschickt anstellt. ");
		System.out.println("Die 'M' sind Minions und 'O' ist Norbert.");
		System.out.println("Ziehen Sie links und rechts bis keine Minions mehr übrig sind.");
		System.out.println("Viel spaß beim Spielen!");
		System.out.println("\n");
		
		// Aufstellung von Minions
		for (int y = 0; y < minions; y++) {
			if (y == norbert) {
				System.out.print("O ");
			} else {
				System.out.print("M ");	
			}
		}
		
		// Beginn des Spiels
		System.out.println("\n");
		System.out.println("\n Wer beginnt das Spiel? Drücke 1 für dich und 0 für Computer");
		game = scanner.nextInt();
		
		if (game != 0 || game != 1) {
			System.out.println("\n Bitte geben Sie 1 für dich oder 0 für Computer ein");
			game = scanner.nextInt();	
		}
		
		while(play != false) {
			// Abwechslung der Spieler nach jedem Zug
	        switch(game) {
	        case 0:
	        	if (rightSide <= 2 || leftSide <= 2) {
					number = (int)(Math.random() * 1) + 1;
				} else {
					System.out.println("Wie viel Minions möchtest du ziehen?");
					number = (int)(Math.random() * 3) + 1;
					if (number > 3) {
						System.out.println("Sie dürfen maximal 3 Minions ziehen.");
						System.out.println("Ziehen Sie bitte nochmal: ");
						number = (int)(Math.random() * 3) + 1;
					} else if (number < 1) {
						System.out.println("Sie müssen mindestens 1 Minion ziehen.");
						System.out.println("Ziehen Sie bitte nochmal: ");
						number = (int)(Math.random() * 3) + 1;
					}
				}
	        	if (rightSide <= 1) {
					side = 'l';
				} else if(leftSide <= 1) {
					side = 'r';
					} else {
						System.out.println("Möchtest du von Links (L) oder Rechts (R) ziehen?");
						sideRand = (int) Math.round(Math.random());
						if (sideRand == 0) {
							side = 'l';
						} else {
							side = 'r';
						}
					}
	            break; 
	        case 1:
					System.out.println("Wie viel Minions möchtest du ziehen?");
					number = scanner.nextInt();
					if (number > 3) {
						System.out.println("Sie dürfen maximal 3 Minions ziehen.");
						System.out.println("Ziehen Sie bitte nochmal: ");
						number = scanner.nextInt();
					} else if (number < 1) {
						System.out.println("Sie müssen mindestens 1 Minion ziehen.");
						System.out.println("Ziehen Sie bitte nochmal: ");
						number = scanner.nextInt();
					}
					System.out.println("Möchtest du von Links (L) oder Rechts (R) ziehen?");
					side = scanner.next().charAt(0);
	            break;
	       default:
	    	   	break;
	        	 	
	        }
			
			// Berechnung Linke Seite
			if (side == 'l') {
				leftSide = leftSide - number;  
				tempLeft = tempLeft + number;

				if (game == 0) {
					if (leftSide < 0) {
						team1 = (team1 + number + leftSide) + 1;
					} else {
						team1 = team1 + number;
					}
				} else if (game == 1) {
					if (leftSide < 0) {
						team2 = (team2 + number + leftSide) + 1;
					} else {
						team2 = team2 + number;
					}
				}
			}
			
			// Anzeigen von gezogenen Minions Linke Seite
			for(int a = 0; a < tempLeft; a++) {
				if (a < tempMinionsLeft) {	
					System.out.print("- ");
				} 
			}
			
			// Anzeigen Minions Linke Seite
			for (int y = 0; y < leftSide; y++) {
				System.out.print("M ");	
			}
			
			// Anzeigen von Norbert
			System.out.print("O ");

			// Berechnung Rechte Seite
			if (side == 'r') {
				rightSide = rightSide - number; // 1 Minions - 3 ziehen =  - 2 Minions 
				tempRight = tempRight + number;// 0 + 7 = 7 Minions

				if (game == 0) {
					if (rightSide < 0) {
						team1 = (team1 + number + rightSide) + 1; // 6 
					} else {
						team1 = team1 + number;
					}
				} else if (game == 1) {
					if (rightSide < 0) {
						team2 = (team2 + number + rightSide) + 1;
					} else {
						team2 = team2 + number;
					}
				}
			}
			
			// Anzeigen Minions Rechte Seite
			for (int z = 0; z < rightSide; z++) {
				System.out.print("M ");		
			}
			
			// Anzeigen von gezogenen Minions Rechte Seite
			for(int a = 0; a < tempRight; a++) {
				if (a < tempMinionsRight) {	
					System.out.print("- ");
				} 	
			}
			
			System.out.println("\n\n Auf der Linken Seite sind noch: " + leftSide +  " Minions übrig");
			System.out.println("\n Auf der Rechten Seite sind noch: " + rightSide + " Minions übrig");
			System.out.println("\n Spieler: " + game + " hat gezogen");
			
			System.out.println("\n Team 1: " + team1);
			System.out.println("\n Team 2: " + team2);
			
			// Entscheidung wer gewonnen hat
			if (leftSide < 0 || rightSide < 0) {
				if (game == 0) {
				System.out.println("\n Team 1: Sie haben Norbert im Team - erfülle deine Mission mit Norbert.");
				play = false;
				
				} else {
				System.out.println("\n Team 2: Sie haben Norbert im Team - erfülle deine Mission mit Norbert.");
				play = false;
				}
				
			}
			
			// Spielerwechsel
			if (game == 0) {
				game = 1; 
			} else {
				game = 0;
			}
		}			
		System.out.println("\n Game is Over.");	
	}
}

