package com.locked.project;

import com.locked.project.Main;

public class Menu {
	
	public static void MainWelcomeScreen(String appName, String developerName) {
	
		
		System.out.println();
		System.out.println("*************************************************");
		System.out.println("*           Welcome To LockedMe.Com             *");
		System.out.println("*************************************************");
		System.out.println("*        Developed By Priyvardhan SIngh         *");
		System.out.println("*************************************************");
		System.out.println("\n");
		
		String featurse = "*****************************************************\n"
					+ "You can use this application to \n"
						+ "---> Retrieve all file names in the \"File\" folder\n"
						+ "---> Search, add, or delete files in \"File\" folder.\n"
						+ "*****************************************************\n";

				System.out.println(featurse); 
		
	}

	public static void displayMenu() {
		System.out.println("                                     ");
		System.out.println("                                     ");
		System.out.println("=====================================");
		System.out.println("|            MAIN MENU              |");
		System.out.println("=====================================");
		System.out.println("| Select any one of the following:  |");
	    System.out.println("|   1 - List All Files              |");
	    System.out.println("|   2 - More Options                |");
	    System.out.println("|   3 - Exit                        |");
	    System.out.println("=====================================");
	    System.out.println("                                     ");
	    System.out.println("Enter your choice : ");

	}

	public static void displayFileMenuOptions() {
		System.out.println("=====================================");
		System.out.println("|            SUB MENU               |");
		System.out.println("=====================================");
		System.out.println("| Select any one of the following:  |");
	    System.out.println("|   1 - Add a file                  |");
	    System.out.println("|   2 - Delete a file               |");
	    System.out.println("|   3 - Search a file               |");
	    System.out.println("|   4 - Show Previous Menu          |");
	    System.out.println("|   5 - Exit                        |");
	    System.out.println("=====================================");
	    System.out.println("Enter your choice : ");
	}
	
	

}
