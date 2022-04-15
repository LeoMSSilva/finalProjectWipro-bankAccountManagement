package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Files {
	File dir = new File("./src/logs");

	public void read(String archive) {
		try {
			String pathFile = dir + "/" + archive;
			FileReader file = new FileReader(pathFile);
			BufferedReader readFromFile = new BufferedReader(file);
			String line, message = "";
			do {
				line = readFromFile.readLine();
				if (line != null) {
					message += line + "\n";
				}
			} while (line != null);
			System.out.println(message);
			readFromFile.close();
			file.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void write(String archive, String textForFile) {
		try {
			dir.mkdir();
			String pathFile = dir + "/" + archive;
			FileWriter fileWriter = new FileWriter(pathFile, true);
			PrintWriter printToFile = new PrintWriter(fileWriter);
			printToFile.print(textForFile);
			printToFile.close();
			fileWriter.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
