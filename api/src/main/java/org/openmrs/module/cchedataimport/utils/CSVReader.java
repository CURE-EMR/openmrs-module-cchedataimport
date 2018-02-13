package org.openmrs.module.cchedataimport.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utility class that reads diagnosis and treatment terms for CURE Ethiopia
 * 
 * @author rubailly
 */
public class CSVReader {
	
	/* Logger for this class and subclasses*/
	protected final Log log = LogFactory.getLog(getClass());
	
	public CSVReader() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String[] readFile() {
		
		String csvFile = "/opt/openmrs/modules/output.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\\|";
		String[] diagnosis = null;
		
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				diagnosis = line.split(cvsSplitBy);
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
		return diagnosis;
		
	}
	
	public ArrayList<String> readSkippedVisits() {
		
		String csvFile = "/opt/openmrs/modules/skippedVisits.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\\|";
		String[] untrimed = null;
		ArrayList<String> diagnosis = new ArrayList<String>();
		
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				untrimed = line.split(cvsSplitBy);
			}
			
			for (String string : untrimed) {
				diagnosis.add(string.trim());
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
		return diagnosis;
		
	}
	
}
