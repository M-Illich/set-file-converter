package com.autoreason.setfileconverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Create a {@link Set} of {@link int} values based on a {@link String} given as
 * line of a text file written by the {@link SetFileConverter} class
 *
 */
public class FileSetConverter {

	/**
	 * Get all the collections of sets given by the lines of a file
	 * 
	 * @param file A text file created by means of
	 *             {@link SetFileConverter#writeSetToFile}
	 * @return An {@link ArrayList} of {@link Collection} elements that contain the
	 *         {@link Set} objects of {@link Integer} values represented by the
	 *         elements of each line from the named file
	 */
	public static ArrayList<Collection<Set<Integer>>> readCollectionsFromFile(String file) {
		// create ArrayList to store read collections
		ArrayList<Collection<Set<Integer>>> collections = new ArrayList<Collection<Set<Integer>>>();

		try {
			// create reader
//			FileReader reader = new FileReader(file);
//			BufferedReader buffReader = new BufferedReader(reader);		
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(FileSetConverter.class.getResourceAsStream(file)));

			// read each line from file
			String line = buffReader.readLine();
			// create collection to store sets read from file
			Collection<Set<Integer>> sets;

			while (line != null) {
				// define new collection for sets
				sets = new HashSet<Set<Integer>>();

				while (!line.isEmpty()) {
					// add converted set to collection
					sets.add(stringToSet(line));
					// read next line
					line = buffReader.readLine();
				}
				// skip empty line
				line = buffReader.readLine();
				// add collection to list
				collections.add(sets);

			}
			buffReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return collections;
	}

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
		Collection<Set<Integer>> col = new HashSet<Set<Integer>>();

		try {
			// create reader
//			FileReader reader = new FileReader(file);
//			BufferedReader buffReader = new BufferedReader(reader);
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(FileSetConverter.class.getResourceAsStream(file)));

			// read each line from file
			String line = buffReader.readLine();
			while (line != null && !line.isBlank()) {
				// add converted set to collection
				col.add(stringToSet(line));
				// read next line
				line = buffReader.readLine();
			}

			buffReader.close();

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
			try {
				// add Integer to Set
				set.add(Integer.decode(sep[i]));
			} catch (NumberFormatException e) {
				// return empty set if no integer in string
				return Set.of();
			}
		}

		return set;

	}

}
