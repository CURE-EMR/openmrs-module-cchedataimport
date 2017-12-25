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
	FileMakerObservationService fileMakerObservationService;

	@Autowired
	UserService userService;

	/** Success form view name */
	private final String VIEW = "/module/cchedataimport/cchedataimport";

	/**
	 * Initially called after the getUsers method to get the landing form name
	 * 
	 * @return String form view name
	 * @throws IOException
	 * @throws APIException
	 */
	@RequestMapping("/module/cchedataimport/setObsGroup")
	public String setObsGroup() throws APIException, IOException {
		fileMakerObservationService.setEncounterObsForm("6842");
		return VIEW;
	}

	/**
	 * Initially called after the getUsers method to get the landing form name
	 * 
	 * @return String form view name
	 * @throws IOException
	 * @throws APIException
	 */
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
	

	//Add Obs per form 
	
	@RequestMapping("/module/cchedataimport/CleftLipPalateHistoryObs")
	public String CleftLipPalateHistoryObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6815",3764);
		return VIEW;
	}

	@RequestMapping("/module/cchedataimport/CleftLipPalateOperativeReportObs")
	public String CleftLipPalateOperativeReportObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6827",3764);
		return VIEW;
	}

	@RequestMapping("/module/cchedataimport/CleftLipPalatePhysicalExamObs")
	public String CleftLipPalatePhysicalExamObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6817",3764);
		return VIEW;
	}

	@RequestMapping("/module/cchedataimport/CleftLipPalatePlanObs")
	public String CleftLipPalatePlanObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6821",3764);
		return VIEW;
	}

	@RequestMapping("/module/cchedataimport/createOrthopaedicFollowupObs")
	public String createOrthopaedicFollowupObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6842",3764);
		return VIEW;
	}

	@RequestMapping("/module/cchedataimport/createOrthopaedicHandPObs")
	public String createOrthopaedicHandPObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6834",3764);
		return VIEW;
	}

	@RequestMapping("/module/cchedataimport/createOrthopaedicOperativeReportObs")
	public String createOrthopaedicOperativeReportObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6843",3764);
		return VIEW;
	}

	@RequestMapping("/module/cchedataimport/createOrthopaedicPlanObs")
	public String createOrthopaedicPlanObs() throws APIException, IOException {
		fileMakerObservationService.createObsForForm("6823",3764);
		return VIEW;
	}

}
