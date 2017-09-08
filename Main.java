package main_package;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

/*
 * Main class where the program will loop infinitely so you can input locations
 */

public class Main {
	
	public static void main(String[] args) {
		Environment env = new Environment();  // Create Environment.
		env.generateEnvironment(); // Generate random Events and tickets
		Scanner scan = new Scanner(System.in);
		System.out.print("Please Input Coordinates:\n> ");
		Pattern p = Pattern.compile("-?[0-9]+,-?[0-9]+"); // Input pattern.
		while(true) {
			String in = scan.next();
			Matcher m = p.matcher(in);
			// If input is not correct, give error message and try again.
			if(!m.matches()) {
				System.out.print("Invalid input. Try again\n> ");
			} else {
				System.out.println(
						String.format("Closest Events to: (%s)", in));
				env.printClosestEvents(in);
				System.out.print("> ");
			}
		}
		
	}
	
}
