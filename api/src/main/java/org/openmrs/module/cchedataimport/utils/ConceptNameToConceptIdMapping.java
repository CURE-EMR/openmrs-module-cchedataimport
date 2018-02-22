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
		
		if (text.equalsIgnoreCase("Dr. Eric Gokcen") || text.equalsIgnoreCase("Eric Gokcen, MD")) {
			c = cs.getConcept(3640);
		} else if (text.equalsIgnoreCase("Dr. Mesfin Etsub") || text.equalsIgnoreCase("Mesfin Etsub, MD")) {
			c = cs.getConcept(3641);
		} else if (text.equalsIgnoreCase("Dr. Tewodros Tilahun") || text.equalsIgnoreCase("Tewodros Tilahun, MD")) {
			c = cs.getConcept(3643);
		} else if (text.equalsIgnoreCase("Dr. Francis Nyirro") || text.equalsIgnoreCase("Francis Nyirro, MD")) {
			c = cs.getConcept(17107);
		} else if (text.equalsIgnoreCase("Dr. Biruk Wamisho") || text.equalsIgnoreCase("Biruk Wamisho, MD")) {
			c = cs.getConcept(3642);
		} else if (text.equalsIgnoreCase("Dr Tim Nunn") || text.equalsIgnoreCase("Tim Nunn, MD")) {
			c = cs.getConcept(17106);
		} else if (text.equalsIgnoreCase("Other:") || text.equalsIgnoreCase("Other")) {
			c = cs.getConcept(3644);
		} else if (text.equalsIgnoreCase("Preop Diagnosis")) {
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
		} else if (text.equalsIgnoreCase("GA")) {
			c = cs.getConcept(3656);
		} else if (text.equalsIgnoreCase("MAC")) {
			c = cs.getConcept(3657);
		} else if (text.equalsIgnoreCase("Other")) {
			c = cs.getConcept(1033);
		} else if (text.equalsIgnoreCase("Regional")) {
			c = cs.getConcept(3658);
		} else if (text.equalsIgnoreCase("Spinal")) {
			c = cs.getConcept(3659);
		} else if (text.equalsIgnoreCase("Local")) {
			c = cs.getConcept(3683);
		} else if (text.equalsIgnoreCase("Block (enter in comments)")) {
			c = cs.getConcept(3726);
		} else if (text.equalsIgnoreCase("Detailed Report")) {
			c = cs.getConcept(3661);
		} else if (text.equalsIgnoreCase("Comments")) {
			c = cs.getConcept(116);
		} else {
			c = null;
		}
		return c;
	}
	
	// Orthopaedic Plan concept names to concept Id mappings
	public static Concept getOrthopaedicPlanMappings(String text) {
		ConceptService cs = Context.getConceptService();
		Concept c = null;
		
		if (text.equalsIgnoreCase("Dr. Eric Gokcen") || text.equalsIgnoreCase("Eric Gokcen, MD")) {
			c = cs.getConcept(3640);
		} else if (text.equalsIgnoreCase("Dr. Mesfin Etsub") || text.equalsIgnoreCase("Mesfin Etsub, MD")) {
			c = cs.getConcept(3641);
		} else if (text.equalsIgnoreCase("Dr. Tewodros Tilahun") || text.equalsIgnoreCase("Tewodros Tilahun, MD")) {
			c = cs.getConcept(3643);
		} else if (text.equalsIgnoreCase("Dr. Francis Nyirro") || text.equalsIgnoreCase("Francis Nyirro, MD")) {
			c = cs.getConcept(17107);
		} else if (text.equalsIgnoreCase("Dr. Biruk Wamisho") || text.equalsIgnoreCase("Biruk Wamisho, MD")) {
			c = cs.getConcept(3642);
		} else if (text.equalsIgnoreCase("Dr Tim Nunn") || text.equalsIgnoreCase("Tim Nunn, MD")) {
			c = cs.getConcept(17106);
		} else if (text.equalsIgnoreCase("Other:") || text.equalsIgnoreCase("Other")) {
			c = cs.getConcept(3644);
		} else if (text.equalsIgnoreCase("Author")) {
			c = cs.getConcept(3645);
		} else if (text.equalsIgnoreCase("Assessment and Plan")) {
			c = cs.getConcept(3723);
		} else if (text.equalsIgnoreCase("Date of Admission")) {
			c = cs.getConcept(3724);
		} else if (text.equalsIgnoreCase("Procedure and Date of Procedure")) {
			c = cs.getConcept(3725);
		} else if (text.equalsIgnoreCase("Operative Time")) {
			c = cs.getConcept(3701);
		} else if (text.equalsIgnoreCase("Anesthesia") || text.equalsIgnoreCase("Anesth")) {
			c = cs.getConcept(3660);
		} else if (text.equalsIgnoreCase("GA")) {
			c = cs.getConcept(3656);
		} else if (text.equalsIgnoreCase("MAC")) {
			c = cs.getConcept(3657);
		} else if (text.equalsIgnoreCase("Other")) {
			c = cs.getConcept(1033);
		} else if (text.equalsIgnoreCase("Regional")) {
			c = cs.getConcept(3658);
		} else if (text.equalsIgnoreCase("Spinal")) {
			c = cs.getConcept(3659);
		} else if (text.equalsIgnoreCase("Local")) {
			c = cs.getConcept(3683);
		} else if (text.equalsIgnoreCase("Block (enter in comments)")) {
			c = cs.getConcept(3726);
		} else if (text.equalsIgnoreCase("Instrument Tray")) {
			c = cs.getConcept(3741);
		} else if (text.equalsIgnoreCase("#11 blade")) {
			c = cs.getConcept(3730);
		} else if (text.equalsIgnoreCase("C-arm")) {
			c = cs.getConcept(3740);
		} else if (text.equalsIgnoreCase("Fracture table")) {
			c = cs.getConcept(3739);
		} else if (text.equalsIgnoreCase("General Ortho (Large)")) {
			c = cs.getConcept(3727);
		} else if (text.equalsIgnoreCase("General Ortho (Small)")) {
			c = cs.getConcept(3728);
		} else if (text.equalsIgnoreCase("Hip Replacement")) {
			c = cs.getConcept(3734);
		} else if (text.equalsIgnoreCase("K-wires")) {
			c = cs.getConcept(3737);
		} else if (text.equalsIgnoreCase("Minor tray")) {
			c = cs.getConcept(3729);
		} else if (text.equalsIgnoreCase("Osteotomy")) {
			c = cs.getConcept(3733);
		} else if (text.equalsIgnoreCase("PMR")) {
			c = cs.getConcept(3731);
		} else if (text.equalsIgnoreCase("Small fragment set")) {
			c = cs.getConcept(3738);
		} else if (text.equalsIgnoreCase("Small Power tools")) {
			c = cs.getConcept(3736);
		} else if (text.equalsIgnoreCase("Stryker Power tools")) {
			c = cs.getConcept(3735);
		} else if (text.equalsIgnoreCase("Triple")) {
			c = cs.getConcept(3732);
		} else if (text.equalsIgnoreCase("Stryker Power tools")) {
			c = cs.getConcept(3735);
		} else if (text.equalsIgnoreCase("Consults")) {
			c = cs.getConcept(3713);
		} else if (text.equalsIgnoreCase("Lactation")) {
			c = cs.getConcept(3711);
		} else if (text.equalsIgnoreCase("Other")) {
			c = cs.getConcept(1033);
		} else if (text.equalsIgnoreCase("Pediatrics")) {
			c = cs.getConcept(3710);
		} else if (text.equalsIgnoreCase("Social Work")) {
			c = cs.getConcept(3712);
		} else if (text.equalsIgnoreCase("PT")) {
			c = cs.getConcept(1176);
		} else if (text.equalsIgnoreCase("Plastic")) {
			c = cs.getConcept(3742);
		} else if (text.equalsIgnoreCase("Labs")) {
			c = cs.getConcept(3720);
		} else if (text.equalsIgnoreCase("Drug Level (comment)")) {
			c = cs.getConcept(3719);
		} else if (text.equalsIgnoreCase("HBV")) {
			c = cs.getConcept(3715);
		} else if (text.equalsIgnoreCase("Hgb/Hct/Plt")) {
			c = cs.getConcept(3714);
		} else if (text.equalsIgnoreCase("HIV")) {
			c = cs.getConcept(1047);
		} else if (text.equalsIgnoreCase("Malaria Smear (q12h x 3 if from endemic region)")) {
			c = cs.getConcept(3716);
		} else if (text.equalsIgnoreCase("Other Answer")) {
			c = cs.getConcept(1033);
		} else if (text.equalsIgnoreCase("Pregnancy")) {
			c = cs.getConcept(2141);
		} else if (text.equalsIgnoreCase("Sickle Cell Test")) {
			c = cs.getConcept(3717);
		} else if (text.equalsIgnoreCase("U/A")) {
			c = cs.getConcept(3718);
		} else if (text.equalsIgnoreCase("T&C for blood ____ units")) {
			c = cs.getConcept(3743);
		} else if (text.equalsIgnoreCase("General Comments")) {
			c = cs.getConcept(116);
		} else {
			c = null;
		}
		return c;
	}
	
	// Orthopaedic H&P concept names to concept Id mappings
	public static Concept getPhysicalTherapyMappings(String text) {
		ConceptService cs = Context.getConceptService();
		Concept c = null;
		
		if (text.equalsIgnoreCase("Physical Therapy")) {
			c = cs.getConcept(3762);
		} else if (text.equalsIgnoreCase("History & Examination:")) {
			c = cs.getConcept(3761);
		} else if (text.equalsIgnoreCase("Plan:")) {
			c = cs.getConcept(3748);
		} else if (text.equalsIgnoreCase("Comments")) {
			c = cs.getConcept(116);
		} else {
			c = null;
		}
		return c;
	}
	
}
