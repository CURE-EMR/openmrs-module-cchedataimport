package org.openmrs.module.cchedataimport.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class should be replaced by a unit test class. This was only added to speed up the test when
 * reading the files containing CURE Ethiopia diagnosis and treatments terms
 * 
 * @author rubailly
 */
public class Test {
	
	public static void main(String[] args) {
		
		String csvFile = "/home/openmrs/Desktop/output.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\\|";
		ArrayList<String> diagnosis = new ArrayList<String>();
		String[] country = null;
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				
				// use comma as separator
				country = line.split(cvsSplitBy);
				
			}
			int i = 0;
			for (String string : country) {
				diagnosis.add(string.trim());
			}
			
			for (String string : diagnosis) {
				System.out.println(++i + "========" + string);
			}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
