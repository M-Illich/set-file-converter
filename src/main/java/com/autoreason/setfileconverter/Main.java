package com.autoreason.setfileconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	/**
	 * Read a text file located in {@code src/main/resources} and exchange its words
	 * by unique integers to allow its usage with {@link FileSetConverter}
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// collection for lines in text file
		Collection<Set<String>> text = new ArrayList<>();
		// count number of words
		int numWords = 0;

		try {
			BufferedReader buffReader = new BufferedReader(
					new InputStreamReader(Main.class.getResourceAsStream("/sampleACAD.txt")));
			// read each line from file
			String line = buffReader.readLine();
			while (line != null) {
				// convert line to set of words
				String[] words = line.split(" ");
				numWords += words.length;
				Set<String> set = new LinkedHashSet<>();
				for (String w : words) {
					set.add(w);
				}
				text.add(set);
				// read next line
				line = buffReader.readLine();
			}
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// write collection to new file where every word is replaced by a unique integer
		SetFileConverter.writeCollectionToFile(text,
				"academic-1x" + text.size() + "x" + (numWords / text.size()) + ".txt");

	}
}
