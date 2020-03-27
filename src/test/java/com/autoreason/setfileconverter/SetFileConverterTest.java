package com.autoreason.setfileconverter;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class SetFileConverterTest {
	
	private static final Random SEED_GENERATOR = new Random();
	
	@Test
	public void runTests() {
		// generate random seed
		long seed = SEED_GENERATOR.nextLong();
		// conduct tests
		try {
			// create random set TODO
			
			// TODO call method
			
			// read file src\\test\\resources\\sets.txt

		} catch (Throwable e) {
			throw new RuntimeException("seed: " + seed, e);
		}
	}
	
	public void testWriteSetToFile(Set<Integer> set) {
		SetFileConverter.writeSetToFile(set,"src\\test\\resources\\sets.txt");
		
	}
	
	@Test
	public void testSetToString() {
		String str1 = SetFileConverter.setToString(Set.of("a","b","c","d"));
		// check if correctly converted
		assertEquals("0 1 2 3 ",str1);
		
		// repeat computation
		String str2 = SetFileConverter.setToString(Set.of("a","b","c","d"));
		// new String must contain same IDs, i.e., be equal
		assertEquals(str1,str2);		
		
	}
	
	@Test
	public void testGetID() {
		int a = SetFileConverter.getID("a"); 
		assertEquals(a,0);
		int a2 = SetFileConverter.getID("a"); 
		assertEquals(a,a2);
		
		int b = SetFileConverter.getID("b"); 
		int c = SetFileConverter.getID("c"); 
		int d = SetFileConverter.getID("d"); 
		assertEquals(a,0);
		assertEquals(b,1);
		assertEquals(c,2);
		assertEquals(d,3);
		
		int b2 = SetFileConverter.getID("b"); 
		assertEquals(b,b2);
		
		
	}

}
