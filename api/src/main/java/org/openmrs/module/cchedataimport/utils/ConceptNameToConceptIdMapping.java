package org.openmrs.module.cchedataimport.utils;

import org.openmrs.Concept;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;

public class ConceptNameToConceptIdMapping {
	
	public ConceptNameToConceptIdMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Orthopaedic Followup concept names to concept Id mappings
	public static Concept getOrthopaedicFollowupMappings(String text) {
		ConceptService cs = Context.getConceptService();
		Concept c = null;
		
		if (text.equalsIgnoreCase("Dr. Eric Gokcen")) {
			c = cs.getConcept(3640);
		} else if (text.equalsIgnoreCase("Dr. Mesfin Etsub")) {
			c = cs.getConcept(3641);
		} else if (text.equalsIgnoreCase("Dr. Tewodros Tilahun")) {
			c = cs.getConcept(3643);
		} else if (text.equalsIgnoreCase("Dr. Biruk Wamisho")) {
			c = cs.getConcept(3642);
		} else if (text.equalsIgnoreCase("Dr Tim Nunn")) {
			c = cs.getConcept(17106);
		} else if (text.equalsIgnoreCase("Other:")) {
			c = cs.getConcept(3644);
		} else if (text.equalsIgnoreCase("Author")) {
			c = cs.getConcept(3645);
		} else if (text.equalsIgnoreCase("Subjective")) {
			c = cs.getConcept(3745);
		} else if (text.equalsIgnoreCase("Objective")) {
			c = cs.getConcept(3746);
		} else if (text.equalsIgnoreCase("Assessment")) {
			c = cs.getConcept(3747);
		} else if (text.equalsIgnoreCase("Plan")) {
			c = cs.getConcept(3748);
		} else if (text.equalsIgnoreCase("Comment")) {
			c = cs.getConcept(116);
		} else {
			c = null;
		}
		return c;
	}
	
	// Orthopaedic H&P concept names to concept Id mappings
	public static Concept getOrthopaedicHPMappings(String text) {
		ConceptService cs = Context.getConceptService();
		Concept c = null;
		
		if (text.equalsIgnoreCase("Dr. Eric Gokcen")) {
			c = cs.getConcept(3640);
		} else if (text.equalsIgnoreCase("Dr. Mesfin Etsub")) {
			c = cs.getConcept(3641);
		} else if (text.equalsIgnoreCase("Dr. Tewodros Tilahun")) {
			c = cs.getConcept(3643);
		} else if (text.equalsIgnoreCase("Dr. Biruk Wamisho")) {
			c = cs.getConcept(3642);
		} else if (text.equalsIgnoreCase("Dr Tim Nunn")) {
			c = cs.getConcept(17106);
		} else if (text.equalsIgnoreCase("Other:")) {
			c = cs.getConcept(3644);
		} else if (text.equalsIgnoreCase("Author")) {
			c = cs.getConcept(3645);
		} else if (text.equalsIgnoreCase("HPI")) {
			c = cs.getConcept(3631);
		} else if (text.equalsIgnoreCase("PMH")) {
			c = cs.getConcept(3646);
		} else if (text.equalsIgnoreCase("Exam")) {
			c = cs.getConcept(3647);
		} else if (text.equalsIgnoreCase("Xray")) {
			c = cs.getConcept(3648);
		} else if (text.equalsIgnoreCase("Lab")) {
			c = cs.getConcept(3649);
		} else if (text.equalsIgnoreCase("Impression:")) {
			c = cs.getConcept(95);
		} else if (text.equalsIgnoreCase("Comments")) {
			c = cs.getConcept(116);
		} else {
			c = null;
		}
		return c;
	}
	
	// Orthopaedic Operative Report concept names to concept Id mappings
	public static Concept getOrthopaedicOperativeReportMappings(String text) {
		ConceptService cs = Context.getConceptService();
		Concept c = null;
		
		if (text.equalsIgnoreCase("Preop Diagnosis")) {
			c = cs.getConcept(3651);
		} else if (text.equalsIgnoreCase("Postop Diagnosis")) {
			c = cs.getConcept(3652);
		} else if (text.equalsIgnoreCase("Procedure")) {
			c = cs.getConcept(3653);
		} else if (text.equalsIgnoreCase("Surgeon")) {
			c = cs.getConcept(3654);
		} else if (text.equalsIgnoreCase("Assistant")) {
			c = cs.getConcept(3655);
		} else if (text.equalsIgnoreCase("Anesthesia")) {
			c = cs.getConcept(3660);
		} else if (text.equalsIgnoreCase("Detailed Report")) {
			c = cs.getConcept(3661);
		} else if (text.equalsIgnoreCase("Comments")) {
			c = cs.getConcept(116);
		} else {
			c = null;
		}
		return c;
	}
	
}
