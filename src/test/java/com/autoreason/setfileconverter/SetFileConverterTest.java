package com.autoreason.setfileconverter;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import org.junit.Test;

public class SetFileConverterTest {

	@Test
	public void testWriteSetToFile() {
		// reset hash table
		SetFileConverter.reset();
		// path to test file
		String file = "src\\test\\resources\\sets.txt";
		try {
			// reset text file
			new FileWriter(file, false).close();

			SetFileConverter.writeSetToFile(Set.of(0, 1, 2, 3), file);

			SetFileConverter.writeSetToFile(Set.of(4, 5, 6), file);

			SetFileConverter.writeSetToFile(Set.of(0, 1, 2, 3), file);

			// access file
			BufferedReader buffReader = new BufferedReader(
					new InputStreamReader(FileSetConverter.class.getResourceAsStream("/sets.txt")));
			assertEquals("0 1 2 3 ", buffReader.readLine());
			assertEquals("4 5 6 ", buffReader.readLine());
			assertEquals("0 1 2 3 ", buffReader.readLine());

			buffReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testSetToString() {
		// reset hash table
		SetFileConverter.hashtable.clear();
		SetFileConverter.currentNr = 0;

		String str1 = SetFileConverter.setToString(Set.of("a", "b", "c", "d"));
		assertEquals("0 1 2 3 ", str1);

	}

	@Test
	public void testGetID() {
		// reset hash table
		SetFileConverter.hashtable.clear();
		SetFileConverter.currentNr = 0;

		int a = SetFileConverter.getID("a");
		assertEquals(a, 0);
		int a2 = SetFileConverter.getID("a");
		assertEquals(a, a2);

		int b = SetFileConverter.getID("b");
		int c = SetFileConverter.getID("c");
		int d = SetFileConverter.getID("d");
		assertEquals(a, 0);
		assertEquals(b, 1);
		assertEquals(c, 2);
		assertEquals(d, 3);

		int b2 = SetFileConverter.getID("b");
		assertEquals(b, b2);

	}

}
