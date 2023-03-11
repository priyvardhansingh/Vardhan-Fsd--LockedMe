package com.locked.project;

import java.util.List;
import java.util.Scanner;


import com.locked.project.HandleMenu;


public class HandleMenu {
	

	public static void MainWelcomeScreen() {
		boolean progrun = true;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				Menu.displayMenu();
				int enter = scan.nextInt();

				switch (enter) {
				case 1:
					MenuOperation.displayAllFiles("File");
					break;
				case 2:
					HandleMenu.handleMenuOptions();
					break;
				case 3:
					System.out.println("You exit from lockedMe");
					progrun = false;
					scan.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select option from above mention list.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				MainWelcomeScreen();
			} 
		} while (progrun == true);
	}
	
	public static void handleMenuOptions() {
		boolean progrun = true;
		Scanner scan = new Scanner(System.in);
		do {
			try {
				Menu.displayFileMenuOptions();
				MenuOperation.createFileFolder("File");
				
				int enter = scan.nextInt();
				switch (enter) {
				case 1:
					// File Add
					System.out.println("Enter file added to folder \"File\" folder");
					String addFile = scan.next();
					
					MenuOperation.createFile(addFile, scan);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"File\" folder");
					String fileDeleted = scan.next();
					
					MenuOperation.createFileFolder("File");
					List<String> filesToDelete = MenuOperation.displayFileLocations(fileDeleted, "File");
					
					String deleteScreen = "\nSelect list of which file to delete?"
							+ "\n(Enter 0 if you want to delete all file)";
					System.out.println(deleteScreen);
				
					int pvs = scan.nextInt();
					
					if (pvs != 0) {
						MenuOperation.deleteRecursiveFile(filesToDelete.get(pvs - 1));
					} else {
						
						// If pvs == 0, delete all files displayed for the name
						for (String path : filesToDelete) {
							MenuOperation.deleteRecursiveFile(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"File\" folder");
					String fName = scan.next();
					
					MenuOperation.createFileFolder("File");
					MenuOperation.displayFileLocations(fName, "File");

					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("You exit from lockedMe");
					progrun = false;
					scan.close();
					System.exit(0);
				default:
					System.out.println("Please select option from above mention list.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleMenuOptions();
			}
		} while (progrun == true);
	}


}
