package org.openmrs.module.cchedataimport.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;

public class FileMakerObservationUtil {
	
	/* Logger for this class and subclasses*/
	protected final static Log log = LogFactory.getLog(FileMakerObservationUtil.class);
	
	/**
	 * Creates an observation for the given concept on the given encounter
	 * 
	 * @param oldEncounterUUID the encounter for which the observation should be created for
	 * @param obsConcept the observation value
	 * @param obsComment
	 * @param obsAnswer
	 * @return
	 */
	public static Obs createObs(String oldEncounterUUID, Concept question, String obsValue, String obsComment, Encounter e, String formTag) {
		Obs o = null;
		if (question.getDatatype().isText() && obsComment != null && obsComment.length() > 0) {
			o = new Obs();
			o.setConcept(question);
			o.setValueText(obsComment);
		}
		if (question.getDatatype().isCoded()) {
			try {
				Concept valueCoded = getConceptFormText(obsValue, formTag);
				if (valueCoded != null) {
					o = new Obs();
					o.setConcept(question);
					o.setValueCoded(valueCoded);
					if (obsComment != null && obsComment.length() > 0) {
						o.setComment(obsComment);
					}
				}
			}
			catch (Exception e2) {}
			
		}
		if (question.getDatatype().isDate()) {
			Date d = parseDate(obsValue);
			if (d != null) {
				o = new Obs();
				o.setConcept(question);
				o.setValueDate(d);
			}
		}
		if (question.getDatatype().isNumeric()) {
			double value = parseToDouble(obsValue);
			if (value != -1) {
				o = new Obs();
				o.setConcept(question);
				o.setValueNumeric(value);
			}
			
		}
		if (o != null) {
			o.setObsDatetime(e.getEncounterDatetime());
			o.setLocation(e.getLocation());
			e.addObs(o);
			Context.getEncounterService().saveEncounter(e);
		}
		return o;
	}
	
	public static Concept getConceptFormText(String text, String formTag) {
		Concept c = null;
		
		if (formTag.equalsIgnoreCase("6843")) {
			return ConceptNameToConceptIdMapping.getOrthopaedicOperativeReportMappings(text);
		}
		
		if (formTag.equalsIgnoreCase("6842")) {
			return ConceptNameToConceptIdMapping.getOrthopaedicFollowupMappings(text);
		}
		
		if (formTag.equalsIgnoreCase("6834")) {
			return ConceptNameToConceptIdMapping.getOrthopaedicHPMappings(text);
		}
		return c;
	}
	
	public static Date parseDate(String givenDate) {
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
	
	public static double parseToDouble(String obsValue) {
		double value = -1;
		try {
			value = Double.parseDouble(obsValue);
		}
		catch (Exception e) {
			value = -1;
		}
		return value;
	}
	
	/**
	 * Creates an observation for the given concept on the given encounter
	 * 
	 * @param oldEncounterUUID the encounter for which the observation should be created for
	 * @param obsValue the observation value
	 * @param columnConcept the concept for the observation
	 * @return
	 */
	public static void setEncounterObsForm(String formId) {
		List<Encounter> encountersToUpdate = new ArrayList<Encounter>();
		
		Concept formConcept = getConceptFromFormId(Integer.valueOf(formId));
		ConceptService cs = Context.getConceptService();
		Concept c = cs.getConcept("Form Id");
		List<Obs> obs = Context.getObsService().getObservationsByPersonAndConcept(null, c);
		
		for (Obs o : obs) {
			if (o.getValueText().equalsIgnoreCase(formId)) {
				encountersToUpdate.add(o.getEncounter());
			}
		}
		
		if (formConcept != null) {
			String voidReason = formConcept.getDisplayString();
			int i = 0;
			for (Encounter e : encountersToUpdate) {
				Obs o = new Obs();
				o.setConcept(formConcept);
				o.setPerson(e.getPatient().getPerson());
				o.setObsDatetime(e.getEncounterDatetime());
				o.setDateCreated(e.getDateCreated());
				o.setCreator(e.getCreator());
				o.setLocation(e.getLocation());
				o.setEncounter(e);
				
				for (Obs obs2 : e.getAllObs()) {
					if (!obs2.getConcept().equals(formConcept)) {
						o.addGroupMember(obs2);
					}
					
				}
				
				Context.getObsService().saveObs(o, "Adding Form Id -" + voidReason);
				log.error(++i + ".===Turangije encounter " + e.getId());
			}
			
		}
	}
	
	public static void setSkippedEncounterObsForm(String formId) {
		List<String> skippedVisits = new CSVReader().readSkippedVisits();
		List<Encounter> encountersToUpdate = new ArrayList<Encounter>();
		
		Concept formConcept = getConceptFromFormId(Integer.valueOf(formId));
		ConceptService cs = Context.getConceptService();
		Concept c = cs.getConcept("Old Encounter UUID");
		List<Obs> obs = Context.getObsService().getObservationsByPersonAndConcept(null, c);
		
		for (Obs o : obs) {
			if (skippedVisits.contains(o.getValueText().trim()) && !o.isVoided()) {
				encountersToUpdate.add(o.getEncounter());
			}
		}
		
		if (formConcept != null) {
			String voidReason = formConcept.getDisplayString();
			int i = 0;
			for (Encounter e : encountersToUpdate) {
				Obs o = new Obs();
				o.setConcept(formConcept);
				o.setPerson(e.getPatient().getPerson());
				o.setObsDatetime(e.getEncounterDatetime());
				o.setDateCreated(e.getDateCreated());
				o.setCreator(e.getCreator());
				o.setLocation(e.getLocation());
				o.setEncounter(e);
				
				for (Obs obs2 : e.getAllObs()) {
					if (!obs2.getConcept().equals(formConcept)) {
						o.addGroupMember(obs2);
					}
					
				}
				
				Context.getObsService().saveObs(o, "Adding Form Id -" + voidReason);
				log.error(++i + ".===Turangije encounter " + e.getId());
			}
			
		}
	}
	
	public static Concept getConceptFromFormId(int formId) {
		ConceptService cs = Context.getConceptService();
		Concept c = null;
		switch (formId) {
			case 6815:
				c = cs.getConcept("Cleft Lip/Palate - History");
				break;
			case 6827:
				c = cs.getConcept("Cleft Lip/Palate - Operative Report");
				break;
			case 6817:
				c = cs.getConcept("Cleft Lip/Palate - Physical Exam");
				break;
			case 6821:
				c = cs.getConcept("Cleft Lip/Palate - Plan");
				break;
			case 6826:
				c = cs.getConcept("General - Operative Report");
				break;
			case 6816:
				c = cs.getConcept("General - Physical Exam");
				break;
			case 6835:
				c = cs.getConcept("General - Hystory");
				break;
			case 6842:
				c = cs.getConcept("Orthopaedic Followup");
				break;
			case 6834:
				c = cs.getConcept("Orthopaedic H&P");
				break;
			case 6843:
				c = cs.getConcept("Orthopaedic Operative Report");
				break;
			case 6823:
				c = cs.getConcept("Orthopaedic Plan");
				break;
			case 6841:
				c = cs.getConcept("Physical Therapy");
				break;
			case 6838:
				c = cs.getConcept("Pre-Anesthesia1 - Evaluation");
				break;
			case 6836:
				c = cs.getConcept("Pre-Anesthesia2 - System Assessment");
				break;
			case 6837:
				c = cs.getConcept("Pre-Anesthesia3 - Plan");
				break;
			case 6831:
				c = cs.getConcept("Vital Measures");
				break;
			case -1:
				System.out.println("Could not find the concept id");
				break;
			default:
				System.out.println("Invalid conceptId");
		}
		return c;
		
	}
	
}
