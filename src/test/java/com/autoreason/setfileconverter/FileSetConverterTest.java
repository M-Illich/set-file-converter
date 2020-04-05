package com.autoreason.setfileconverter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FileSetConverterTest {

	@Test
	public void testReadCollectionsFromFile() {
		// collection that represents sets for test file
		Collection<Set<Integer>> colTest = new HashSet<Set<Integer>>();
		colTest.add(Set.of(0, 1, 2, 3));
		colTest.add(Set.of(3, 1, 2));
		colTest.add(Set.of(5, 4, 3));
		colTest.add(Set.of(0, 3, 6));
		// list that contains every collection of test file (here twice the same)
		ArrayList<Collection<Set<Integer>>> expctCols = new ArrayList<Collection<Set<Integer>>>();
		expctCols.add(colTest);
		expctCols.add(colTest);
		
		// apply method on test file
		ArrayList<Collection<Set<Integer>>> readCols = FileSetConverter.readCollectionsFromFile("src\\test\\resources\\testSets.txt");

		assertEquals(expctCols, readCols);
	}

	@Test
	public void testReadSetsFromFile() {
		// collection that represents sets for test file
		Collection<Set<Integer>> colTest = new HashSet<Set<Integer>>();
		colTest.add(Set.of(0, 1, 2, 3));
		colTest.add(Set.of(3, 1, 2));
		colTest.add(Set.of(5, 4, 3));
		colTest.add(Set.of(0, 3, 6));
		// apply method on test file
		Collection<Set<Integer>> colRead = FileSetConverter.readSetsFromFile("src\\test\\resources\\testSets.txt");

		assertEquals(colTest, colRead);
	}

	@Test
	public void testStringToSet() {
		String str = "0 1 2 3 ";
		assertEquals(Set.of(0, 1, 2, 3), FileSetConverter.stringToSet(str));
	}

}
