package com.autoreason.setfileconverter;

import static org.junit.Assert.assertEquals;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
//		SetFileConverter.writeSetToFile(Set.of(0,1,2,3), "sets.txt");
		SetFileConverter.writeSetToFile(Set.of(2,0,3,1,4,5), "src\\test\\resources\\sets.txt");
		
//		String str = "0 1 2 3 ";
//		String[] sep = str.split(" ");
//		for (int i = 0; i < sep.length; i++) {
//			System.out.println(sep[i]);
//		}			

	}

}
