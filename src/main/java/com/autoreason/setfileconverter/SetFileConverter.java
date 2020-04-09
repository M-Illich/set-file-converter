package com.autoreason.setfileconverter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

/**
 * Store a {@link Set} of arbitrary elements as a line in a text file by
 * assigning an unique {@link int} ID to each set element, such that the set can
 * be represented by a {@link String} that contains these IDs separated by space
 *
 */
public class SetFileConverter {
	// current number that can be used as unique ID for an object
	static int currentNr = 0;
	// hash table to store IDs for objects
	static Hashtable<Object, Integer> hashtable = new Hashtable<Object, Integer>();

	/**
	 * Write a {@link Collection} to a given file by representing its contained
	 * {@link Set} elements as {@link String} objects
	 * @param <C>
	 * 
	 * @param col  A {@link Collection} of {@link Set} objects
	 * @param file A {@link String} that defines the path to the file where the
	 *             transformed collection is stored
	 */
	public static <C> void writeCollectionToFile(Collection<Set<C>> col, String file) {
		try {
			// create writer
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter buffWriter = new BufferedWriter(writer);

			// write each set to collection
			for (Set<C> set : col) {
				// convert set to string containing its elements' IDs
				String setIDs = setToString(set);
				// write string to file
				buffWriter.write(setIDs);
				buffWriter.newLine();
			}
			buffWriter.newLine();
			buffWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Represent a {@link Set} by a {@link String} that contains a unique ID of each
	 * set element, separated by space, and write this string as new line to a named
	 * file
	 * 
	 * @param set  A {@link Set}
	 * @param file A {@link String} that defines the path to the file where the
	 *             created set-string is stored
	 */
	public static void writeSetToFile(Set<?> set, String file) {
		try {
			// create writer
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter buffWriter = new BufferedWriter(writer);

			// convert set to string containing its elements' IDs
			String setIDs = setToString(set);
			// write string to file
			buffWriter.write(setIDs);
			buffWriter.newLine();

			buffWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a {@link String} that contains the IDs of each element, separated by
	 * space, from the given {@link Set}
	 * 
	 * @param set A {@link Set}
	 * @return A {@link String} of {@link int} values separated by space
	 */
	static String setToString(Set<?> set) {
		StringBuilder str = new StringBuilder();
		// go through elements of set
		for (Object o : set) {
			// add ID of element to string
			str.append(getID(o) + " ");
		}
		return str.toString();
	}

	/**
	 * Get the ID of an object
	 * 
	 * @param o An object
	 * @return An {@code int} value that serves as unique identifier for the object
	 *         {@code o}
	 */
	static int getID(Object o) {
		// look for ID number in hash table
		Integer id = hashtable.get(o);
		if (id == null) {
			// use current number as ID for object
			id = currentNr;
			// store ID in hash table
			hashtable.put(o, id);
			// update current number
			currentNr++;

		}
		return id;
	}

	/**
	 * Reset the hash table. Can be used to process a new collection of sets.
	 */
	public static void reset() {
		SetFileConverter.hashtable.clear();
		SetFileConverter.currentNr = 0;
	}

}
