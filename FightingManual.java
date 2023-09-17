import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class FightingManual {

	static void InstructionManual() {
		System.out.println("Welcome to ___ instruction manual");
		System.out.println("Goal: Your goal is to defeat the computer player, Jack, by reducing his health to 0");
		System.out.println("Each player starts with the max health of 100, attack power of 8, and 60 energy points");
		System.out.println("Each player will take turns and the game will end when one of the player's health is 0");
		System.out.println("End of instruction manual");
	}
	
	static void FightOptions() {
                System.out.println("Options:");
                System.out.println("Attack        Skill");
                System.out.println("Escape");
                System.out.println(" ");
        }

	static void AttackMenu(Player p1, Player p2) {
		p2.HP = p2.HP - p1.AP;
		System.out.println(p2.name + " has lost " + p1.AP + " health");
		System.out.println(" ");
		p1.PrintStats(p1);
		System.out.println(" ");
		p2.PrintStats(p2);
	}

	static void SkillMenu(Player p1) {
		p1.EP = p1.EP - 10;
		if (p1.healing == true) {
			if ((p1.HP + 10) > 100) {
				p1.HP = 100;
			} else {
				p1.HP = p1.HP + 10;
			}
			System.out.println(p1.name + " has been healed");
		} else {
			System.out.println(p1.name + " has been granted 2 turns");
		}
	}

	static void EscapeMenu(Player p1) {
		final String[] options = {"yes", "no"};
		Random random = new Random();
		int index = random.nextInt(options.length);
		String answer = options[index];
		if (answer.equals("yes")) {
			System.out.println(p1.name + " has successfully escaped");
			System.out.println("Game over");
			System.exit(0);
		} else {
			System.out.println(p1.name + " has failed to escape");
		}
	}

	static void HasLost(Player p1, Player comp) {
                if (p1.HP <= 0) {
                        System.out.println(p1.name + " has lost and " + comp.name + " has won");
                        System.exit(0);
                } else if (comp.HP <= 0) {
                        System.out.println(comp.name + " has lost and " + p1.name + " has won");
                        System.exit(0);
                } else {
			System.out.println(" ");
		}
        }

	static void DoTurn(Player P1, String current, Player comp) {
		if (current.equals("user")) {
			Scanner input = new Scanner(System.in);
			FightOptions();
			String command = input.nextLine();
			if (command.equals("Attack")) {
				AttackMenu(P1, comp);
			} else if (command.equals("Skill")) {
				SkillMenu(P1);
				for (int i = 0; i < 2; i = i + 1) {
					command = input.nextLine();
					if (command.equals("Attack")) {
                                		AttackMenu(P1, comp);
						System.out.println("---------------------------------");
                        		} else if (command.equals("Escape")) {
                                		EscapeMenu(P1);
						System.out.println("---------------------------------");
                        		} else {
                                		while (!command.equals("Attack") && !command.equals("Escape")) {
                                        		System.out.println("Error: Please enter a valid option");
                                        		command = input.nextLine();
                                		}
					}
				}
			} else if (command.equals("Escape")) {
				EscapeMenu(P1);
			} else {
				while (!command.equals("Attack") && !command.equals("Skill") && !command.equals("Escape")) {
					System.out.println("Error: Please enter a valid option");
					command = input.nextLine();
				}
			}
		} else {
			final String[] option = {"Attack", "Skill", "Escape"};
			Random random = new Random();
			int index = random.nextInt(option.length);
			String answer = option[index];
			if (answer.equals("Attack")) {
				AttackMenu(comp, P1);
			} else if (answer.equals("Skill")) {
				SkillMenu(comp);
				final String[] newOption = {"Attack", "Escape"};
				index = random.nextInt(newOption.length);
				answer = newOption[index];
				for (int i = 0; i < 2; i = i + 1) {
					if (answer.equals("Attack")) {
                                		AttackMenu(comp, P1);
						System.out.println("---------------------------------");
                        		} else {
						EscapeMenu(comp);
						System.out.println("---------------------------------");
					}
				}
			} else {
				EscapeMenu(comp);
			}
		}
		System.out.println("---------------------------------");
		System.out.println(" ");	
	}
}
