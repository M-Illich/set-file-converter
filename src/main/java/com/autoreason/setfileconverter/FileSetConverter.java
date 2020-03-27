package com.autoreason.setfileconverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Create a {@link Set} of {@link int} values based on a {@link String} given as
 * line of a text file written by the {@link SetFileConverter} class
 *
 */
public class FileSetConverter {

	/**
	 * Transform each of the named file's (non-empty) line, given as {@link int}
	 * values separated by space, into a {@link Set}
	 * 
	 * @param file A text file created by {@link SetFileConverter#writeSetToFile}
	 * @return A {@link Collection} containing the {@link Set} objects of
	 *         {@link Integer} values represented by the elements of each line from
	 *         the named file
	 */
	public static Collection<Set<Integer>> readSetsFromFile(String file) {
		// create collection to store sets read from file
		Collection<Set<Integer>> col = new TreeSet<Set<Integer>>();

		try {
			// create reader
			FileReader reader = new FileReader(file);
			BufferedReader buffReader = new BufferedReader(reader);

			// read each line from file
			String line;
			do {
				line = buffReader.readLine();
				// add converted set to collection
				col.add(stringToSet(line));
			} while (line != "" || line == null); // last line is empty

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return col;
	}

	/**
	 * Transform a {@link String} of {@link int} values separated by space to a
	 * {@link Set} of {@link Integer} values
	 * 
	 * @param str A {@link String} of {@link int} values separated by space
	 * @return A {@link Set} of {@link Integer} values stated in {@code str}
	 */
	static Set<Integer> stringToSet(String str) {
		// create set to store int values of given string
		Set<Integer> set = new HashSet<Integer>();

		// separate String by space
		String[] sep = str.split(" ");
		for (int i = 0; i < sep.length; i++) {
			// add Integer to Set
			set.add(Integer.decode(sep[i]));
		}

		return set;

	}

}
