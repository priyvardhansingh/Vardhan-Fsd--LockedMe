package com.locked.project;




public class Main {
	
public static void main(String[] args) {
		
		// Create "main" folder if not present in current folder structure
	    MenuOperation.createFileFolder("File");
		
		Menu.MainWelcomeScreen("LockedMe", "Priyvardhan Singh");
		
		
		
		HandleMenu.MainWelcomeScreen();
	}

}
