/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.cchedataimport.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openmrs.Patient;
import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.module.cchedataimport.api.impl.FileMakerObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/${rootArtifactid}/${rootArtifactid}Link.form'.
 */
@Controller("${rootArtifactid}.CCHEDataImportController")
public class CCHEDataImportController {
	
	@Autowired
	private FileMakerObservationService fileMakerObservationService;
	
	@Autowired
	UserService userService;
	
	/** Success form view name */
	private final String VIEW = "/module/cchedataimport/cchedataimport";
	
	//Create Obs per form 
	
	@RequestMapping("/module/cchedataimport/createCleftLipPalateHistoryObs")
	public String createCleftLipPalateHistoryObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6815");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/createCleftLipPalateOperativeReportObs")
	public String createCleftLipPalateOperativeReportObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6827");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/createCleftLipPalatePhysicalExamObs")
	public String createCleftLipPalatePhysicalExamObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6817");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/createCleftLipPalatePlanObs")
	public String createCleftLipPalatePlanObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6821");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/createOrthopaedicFollowupObs")
	public String createOrthopaedicFollowupObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6842");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/createOrthopaedicHandPObs")
	public String createOrthopaedicHandPObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6834");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/createOrthopaedicOperativeReportObs")
	public String createOrthopaedicOperativeReportObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6843");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/createOrthopaedicPlanObs")
	public String createOrthopaedicPlanObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6823");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/createPhysicalTherapyObs")
	public String createPhysicalTherapyObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6841");
		return VIEW;
	}
	
	//Set form for encounters and corresponding obs
	
	@RequestMapping("/module/cchedataimport/setCleftLipPalateHistory")
	public String setCleftLipPalateHistory() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6815");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setCleftLipPalateOperativeReport")
	public String setCleftLipPalateOperativeReport() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6827");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setCleftLipPalatePhysicalExam")
	public String setCleftLipPalatePhysicalExam() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6817");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setCleftLipPalatePlan")
	public String setCleftLipPalatePlan() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6821");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setOrthopaedicFollowup")
	public String setOrthopaedicFollowup() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6842");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setOrthopaedicHP")
	public String setOrthopaedicHP() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6834");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setOrthopaedicOperativeReport")
	public String setOrthopaedicOperativeReport() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6843");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setPhysicalTherapy")
	public String setPhysicalTherapy() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6841");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setOrthopaedicPlan")
	public String setOrthopaedicPlan() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6823");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/importSkippedOrthopaedicFollowupObs")
	public String importSkippedOrthopaedicFollowupObs() throws APIException, IOException {
		fileMakerObservationService.createSkippedObsForForm("6842");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setSkippedOrthopaedicFollowupObs")
	public String setSkippedOrthopaedicFollowupObs() throws APIException, IOException {
		fileMakerObservationService.setSkippedEncounterObsForm("6842");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/importSkippedOrthopaedicOperativeReportObs")
	public String importSkippedOrthopaedicOperativeReportObs() throws APIException, IOException {
		fileMakerObservationService.createSkippedObsForForm("6843");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setSkippedOrthopaedicOperativeReportObs")
	public String setSkippedOrthopaedicOperativeReportObs() throws APIException, IOException {
		fileMakerObservationService.setSkippedEncounterObsForm("6843");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/importSkippedOrthopaedicHPObs")
	public String importSkippedOrthopaedicHPObs() throws APIException, IOException {
		fileMakerObservationService.createSkippedObsForForm("6834");
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/setSkippedOrthopaedicHPObs")
	public String setSkippedOrthopaedicHPObs() throws APIException, IOException {
		fileMakerObservationService.setSkippedEncounterObsForm("6834");
		return VIEW;
	}
	
	@RequestMapping("module/cchedataimport/setOrthopedicAuthorComment.form")
	public String setOrthopedicAuthorComment() throws APIException, IOException {
		fileMakerObservationService.setOrthopedicAuthorComment();
		return VIEW;
	}
	
	@RequestMapping("module/cchedataimport/setObsGroup.form")
	public String setObsGroup() throws APIException, IOException {
		fileMakerObservationService.setObsGroup();
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/saveAllPatients")
	public String saveAllPatients() throws APIException, IOException {
		List<Patient> allPatients = Context.getPatientService().getAllPatients();
		for (Patient patient : allPatients) {
			patient.setDateChanged(new Date());
			Context.getPatientService().savePatient(patient);
		}
		
		return VIEW;
	}
	
	@RequestMapping("/module/cchedataimport/addAnswersToCededConcept")
	public String addAnswersToCededConcept() throws APIException, IOException {
		fileMakerObservationService.addAnswers();
		return VIEW;
	}
	
}
