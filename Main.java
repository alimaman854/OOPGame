import java.util.Random;
import java.awt.*;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
		FightingManual fight = new FightingManual();
                Scanner input = new Scanner(System.in);
                System.out.println("Welcome to this new fighter game!");
                System.out.println("Here, your goal is to defeat the computer player, Jack, by attacking and defending yourself");
                System.out.println("Before we begin, please enter your name");
                String userName = input.nextLine();
                Player user = new Player();
                user.name = userName;
                System.out.println("Message: Player " +  user.name + " has been entered into the game");
		Player computerUser = new Player();
		String compName = "Jack";
		computerUser.name = compName;
		boolean begin = false;
		System.out.println("Enter 'start' to begin");
		String startCommand = input.nextLine();
		if(startCommand.equals("start")) {
			begin = true;
		} else {
			while (!startCommand.equals("start")) {
				System.out.println("Error: Please enter 'start' to begin");
				startCommand = input.nextLine();
			}
		}
		
		System.out.println("First choose one of the following two skills");
		System.out.println("Healing: heal 10% of your health");
	        System.out.println("Double turn: get two consecutive turns");
		System.out.println("Type 'healing' or 'double turn'");
		String skill = input.nextLine();
		if (skill.equals("healing")) {
			user.healing = true;
		} else if (skill.equals("double turn")) {
			user.doubleturn = true;
		} else {
			while((!skill.equals("healing")) && (!skill.equals("double turn"))) {
				System.out.println("Please enter one of the skills: 'healing' or 'double turn'");
				skill = input.nextLine();
			}
		}

		final String[] skillopt = {"healing", "double turn"};
		Random random = new Random();
		int index = random.nextInt(skillopt.length);
		String choosen = skillopt[index];
		if (skill.equals("healing")) {
                        computerUser.healing = true;
                } else {
			computerUser.doubleturn = true;
		}	
		System.out.println("Would you like to view the instructions? Type 'yes' if you would");
		String answer = input.nextLine();
		if (answer.equals("yes")) {
			fight.InstructionManual();
		}

		while(begin) {
			System.out.println(" ");
			user.PrintStats(user);
			System.out.println(" ");
			computerUser.PrintStats(computerUser);
			System.out.println(" ");
			fight.DoTurn(user, "user", computerUser);
			fight.HasLost(user, computerUser);
			fight.DoTurn(user, "computer", computerUser);
			fight.HasLost(user, computerUser);
		}			
        }
}
