package org.openmrs.module.cchedataimport.api.csv.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.APIException;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;

public class SimpleExcelReader {
	
	/**
	 * Reads the "cchedataimport.fileNameConceptMap" global property value
	 * to know which file and concept to use when calling {@link #doImport(String, Concept)}
	 * Auto generated method comment
	 * 
	 * @throws APIException
	 * @throws IOException
	 */
	public void prepareObsImport() throws APIException, IOException {
		ConceptService cs = Context.getConceptService();
		String mapping = Context.getAdministrationService().getGlobalProperty("cchedataimport.fileNameConceptMap");
		String[] values = mapping.split("\\|");
		for (String s : values) {
			if (s.indexOf(":") > 0) {
				String fileName = s.substring(0, s.indexOf(":"));
				String columnConcept = s.substring(s.indexOf(":") + 1, s.length());
				doImport(fileName, cs.getConcept(columnConcept));
			}
		}
		
	}
	/**
	 * 
	 * Reads a file that contains observations and their corresponding 
	 * mappings with encounters. It calls {@link #createObs(String, String, Concept)}
	 * for the actual creation of the observation
	 * 
	 * @param fileName name of the file that contains the Observations to import
	 * @param columnConcept the concept for which Observations are going to be created
	 * @throws IOException
	 */
	public void doImport(String fileName, Concept columnConcept) throws IOException {
		String excelFilePath = "/opt/openmrs/modules/" + fileName + ".xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		
		while (iterator.hasNext()) {
			try {
				Row nextRow = iterator.next();
				String oldEncounterUUID = nextRow.getCell(0).getStringCellValue();
				Cell c = nextRow.getCell(1);
				c.setCellType(Cell.CELL_TYPE_STRING);
				String obsValue = c.getStringCellValue();
				if (obsValue != null && obsValue.length() > 0 && !obsValue.equalsIgnoreCase("NULL")
				        && !obsValue.equalsIgnoreCase("0000-00-00")) {
					createObs(oldEncounterUUID, obsValue, columnConcept);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		inputStream.close();
	}
	
	/**
	 * 
	 * Creates an observation for the given concept on the given encounter
	 * 
	 * @param oldEncounterUUID the encounter for which the observation should be created for
	 * @param obsValue the observation value
	 * @param columnConcept the concept for the observation 
	 * @return
	 */
	public Obs createObs(String oldEncounterUUID, String obsValue, Concept columnConcept) {
		ConceptService cs = Context.getConceptService();
		Concept c = cs.getConcept("Old Encounter UUID");
		List<Obs> obs = Context.getObsService().getObservationsByPersonAndConcept(null, c);
		Encounter e = null;
		for (Obs o : obs) {
			if (o.getValueText().equalsIgnoreCase(oldEncounterUUID)) {
				e = o.getEncounter();
			}
		}
		Obs o = new Obs();
		o.setConcept(columnConcept);
		if (columnConcept.getDatatype().isText()) {
			o.setValueText(obsValue);
		} else if (columnConcept.getDatatype().isCoded()) {
			Concept valueCoded = cs.getConcept(obsValue);
			if (valueCoded != null) {
				o.setValueCoded(valueCoded);
			}
			
		} else if (columnConcept.getDatatype().isDate()) {
			Date d = parseDate(obsValue);
			if (d != null) {
				o.setValueDate(d);
			}
		} else if (columnConcept.getDatatype().isNumeric()) {
			double value = parseToDouble(obsValue);
			if (value != -1) {
				o.setValueNumeric(value);
			}
			
		}
		int obsGroup = Integer.parseInt(Context.getAdministrationService().getGlobalProperty("cchuutils.obsGroupConcept"));
		for (Obs obs2 : e.getObs()) {			
			if(obs2.getConcept().getConceptId() == obsGroup){
				o.setObsGroup(obs2);
			}else{
				Obs group = new Obs(e.getPatient(), cs.getConcept(obsGroup), e.getEncounterDatetime(), e.getLocation());
				e.addObs(group);
				o.setObsGroup(group);
			}
			
		}
		o.setObsDatetime(e.getEncounterDatetime());
		o.setLocation(e.getLocation());
		e.addObs(o);
		Context.getEncounterService().saveEncounter(e);
		return o;
	}
	
	public Date parseDate(String givenDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(givenDate);
		}
		catch (ParseException e) {
			return null;
		}
		return date;
	}
	
	public double parseToDouble(String obsValue) {
		double value = -1;
		try {
			value = Double.parseDouble(obsValue);
		}
		catch (Exception e) {
			value = -1;
		}
		return value;
	}
	
}
