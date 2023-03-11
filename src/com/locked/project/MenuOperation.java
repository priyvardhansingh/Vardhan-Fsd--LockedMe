package com.locked.project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.locked.project.MenuOperation;

public class MenuOperation {


	public static void createFileFolder(String folderName) {
		File file = new File(folderName);

		// If file doesn't exist, create the File folder
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static void displayAllFiles(String path) {
		MenuOperation.createFileFolder("File");
	
		System.out.println("Displaying all files inside directory  in ascending order\n");

		// listFilesInDirectory 
		//It displeay inside file and structure of folder
		List<String> filesListNames = MenuOperation.listFilesInDirectory(path, 0, new ArrayList<String>());

		System.out.println("Displaying all files in ascending order\n");
		Collections.sort(filesListNames);

		filesListNames.stream().forEach(System.out::println);
	}

	public static List<String> listFilesInDirectory(String path, int spaceCount, List<String> fileInList) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		Collections.sort(filesList);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				System.out.print(" ".repeat(spaceCount * 2));

				if (file.isDirectory()) {
					System.out.println("`-- " + file.getName());
                     //Displaying the file
					//Recursively
					
					fileInList.add(file.getName());
					listFilesInDirectory(file.getAbsolutePath(), spaceCount + 1, fileInList);
				} else {
					System.out.println("|-- " + file.getName());
					fileInList.add(file.getName());
				}
			}
		} else {
			System.out.print(" ".repeat(spaceCount * 2));
			System.out.println("|--Directory is empty----|");
		}
		System.out.println();
		return fileInList;
	}

	public static void createFile(String addFile, Scanner sc) {
		MenuOperation.createFileFolder("File");
		Path pathToFile = Paths.get("./File/" + addFile);
		try {
			Files.createDirectories(pathToFile.getParent());
			Files.createFile(pathToFile);
			System.out.println(addFile + "  file entered by you created successfully and saved in directory");

			System.out.println("Would you like to add data to the file? (Y/N)");
			String choice = sc.next().toLowerCase();

			sc.nextLine();
			if (choice.equals("y")) {
				System.out.println("\n\nInput  data and press enter\n");
				String content = sc.nextLine();
				Files.write(pathToFile, content.getBytes());
				System.out.println("\nData written to file " + addFile);
				System.out.println("Data can be read using Notepad or Notepad++ or Vscode");
			}

		} catch (IOException e) {
			System.out.println("Failed to create file " + addFile);
			System.out.println(e.getClass().getName());
		}
	}

	public static List<String> displayFileLocations(String fName, String path) {
		List<String> fileInList = new ArrayList<>();
		MenuOperation.searchFileRecursively(path, fName, fileInList);

		if (fileInList.isEmpty()) {
			System.out.println("\n\n***** Unable to find file which you are input in the folder with name \"" + fName + "\" *****\n\n");
		} else {
			System.out.println("\n\n Found file at below location(s):");

			List<String> files = IntStream.range(0, fileInList.size())
					.mapToObj(index -> (index + 1) + ": " + fileInList.get(index)).collect(Collectors.toList());

			files.forEach(System.out::println);
		}

		return fileInList;
	}

	public static void searchFileRecursively(String path, String fName, List<String> fileInList) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				if (file.getName().startsWith(fName)) {
					fileInList.add(file.getAbsolutePath());
				}

		
				if (file.isDirectory()) {
					searchFileRecursively(file.getAbsolutePath(), fName, fileInList);
				}
			}
		}
	}

	public static void deleteRecursiveFile(String path) {

		File currFile = new File(path);
		File[] files = currFile.listFiles();

		if (files != null && files.length > 0) {
			for (File file : files) {

				String fName = file.getName() + " at " + file.getParent();
				if (file.isDirectory()) {
					deleteRecursiveFile(file.getAbsolutePath());
				}

				if (file.delete()) {
					System.out.println(fName + " :File deleted successfully");
				} else {
					System.out.println("Failed to delete File:" + fName);
				}
			}
		}

		String currFileName = currFile.getName() + " at " + currFile.getParent();
		if (currFile.delete()) {
			System.out.println(currFileName + " :deleted successfully");
		} else {
			System.out.println("Failed to delete File:" + currFileName);
		}
	}


}
