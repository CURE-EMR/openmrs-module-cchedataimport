/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.cchedataimport.extension.html;

import java.util.HashMap;
import java.util.Map;

import org.openmrs.module.Extension;
import org.openmrs.module.web.extension.AdministrationSectionExt;

/**
 * This class defines the links that will appear on the administration page under the
 * "cchedataimport.title" heading. This extension is enabled by defining (uncommenting) it in the
 * config.xml file.
 */
public class AdminList extends AdministrationSectionExt {
	
	/**
	 * @see org.openmrs.module.web.extension.AdministrationSectionExt#getMediaType()
	 */
	public Extension.MEDIA_TYPE getMediaType() {
		return Extension.MEDIA_TYPE.html;
	}
	
	/**
	 * @see org.openmrs.module.web.extension.AdministrationSectionExt#getTitle()
	 */
	public String getTitle() {
		return "cchedataimport.title";
	}
	
	/**
	 * @see org.openmrs.module.web.extension.AdministrationSectionExt#getLinks()
	 */
	public Map<String, String> getLinks() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		//This is to help migrate diagnosis and treatment terms
		
		map.put("module/cchedataimport/addAnswersToCededConcept.form", "cchedataimport.addAnswersToCededConcept");
		
		//This is to help trigger sync for patients to the OpenELIS and OpenERP/Odoo
		
		map.put("module/cchedataimport/saveAllPatients.form", "cchedataimport.saveAllPatients");
		
		//Create obs by form
		
		map.put("module/cchedataimport/createCleftLipPalateHistoryObs.form", "cchedataimport.createCleftLipPalateHistoryObs");
		map.put("module/cchedataimport/createCleftLipPalateOperativeReportObs.form",
		    "cchedataimport.createCleftLipPalateOperativeReportObs");
		map.put("module/cchedataimport/createCleftLipPalatePhysicalExamObs.form",
		    "cchedataimport.createCleftLipPalatePhysicalExamObs");
		map.put("module/cchedataimport/createCleftLipPalatePlanObs.form", "cchedataimport.createCleftLipPalatePlanObs");
		
		map.put("module/cchedataimport/createOrthopaedicFollowupObs.form", "cchedataimport.createOrthopaedicFollowupObs");
		map.put("module/cchedataimport/createOrthopaedicHandPObs.form", "cchedataimport.createOrthopaedicHandPObs");
		map.put("module/cchedataimport/createOrthopaedicOperativeReportObs.form",
		    "cchedataimport.createOrthopaedicOperativeReportObs");
		map.put("module/cchedataimport/createOrthopaedicPlanObs.form", "cchedataimport.createOrthopaedicPlanObs");
		
		//Adding obs grouping by form (forms on encounters)
		
		map.put("module/cchedataimport/setCleftLipPalateHistory.form", "cchedataimport.setCleftLipPalateHistory");
		map.put("module/cchedataimport/setCleftLipPalateOperativeReport.form",
		    "cchedataimport.setCleftLipPalateOperativeReport");
		map.put("module/cchedataimport/setCleftLipPalatePhysicalExam.form", "cchedataimport.setCleftLipPalatePhysicalExam");
		map.put("module/cchedataimport/setCleftLipPalatePlan.form", "cchedataimport.setCleftLipPalatePlan");
		
		map.put("module/cchedataimport/setOrthopaedicFollowup.form", "cchedataimport.setOrthopaedicFollowup");
		map.put("module/cchedataimport/setOrthopaedicHP.form", "cchedataimport.setOrthopaedicHP");
		map.put("module/cchedataimport/setOrthopaedicOperativeReport.form", "cchedataimport.setOrthopaedicOperativeReport");
		map.put("module/cchedataimport/setOrthopaedicPlan.form", "cchedataimport.setOrthopaedicPlan");
		
		return map;
	}
	
}
