package org.openmrs.module.cchedataimport.api.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.cchedataimport.api.dao.FilemakerObservationDAO;
import org.openmrs.module.cchedataimport.domain.FileMakerObservation;
import org.openmrs.module.cchedataimport.utils.CSVReader;
import org.openmrs.module.cchedataimport.utils.FileMakerObservationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("filemakerObsService")
public class FileMakerObservationService {

	/* Logger for this class and subclasses*/
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	FilemakerObservationDAO fileMakerObservationDAO;

	@Transactional
	public List<FileMakerObservation> getAllObs(String encounter) {
		return fileMakerObservationDAO.getAllObs(encounter);
	}

	@Transactional
	public FileMakerObservation getObs(int id) {
		return fileMakerObservationDAO.getObs(id);
	}

	@Transactional
	public void addObs(FileMakerObservation obs) {
		fileMakerObservationDAO.addObs(obs);
	}

	@Transactional
	public void updateObs(FileMakerObservation obs) {
		fileMakerObservationDAO.updateObs(obs);

	}

	@Transactional
	public void addAnswers() {
		ConceptService cs = Context.getConceptService();
		Concept concept = cs.getConcept(7318);
		String[] answers = new CSVReader().readFile();
		for (String string : answers) {
			Concept answer = cs.getConceptByName(string.trim());
			if (answer != null) {
				concept.addAnswer(new ConceptAnswer(answer));
			}
		}
		cs.saveConcept(concept);
	}

	@Transactional
	public void deleteObs(int id) {
		fileMakerObservationDAO.deleteObs(id);
	}

	@Transactional
	public void createObsForForm(String formTag, int oldEncounterUUIDConcept) {
		List<Obs> obs = Context.getObsService().getObservationsByPersonAndConcept(null,
				Context.getConceptService().getConcept("Form Id"));
		for (Obs obs2 : obs) {
			if (obs2.getValueText().equalsIgnoreCase(formTag)) { //Take the encounter if the tag is the for the form we want
				Encounter e = obs2.getEncounter();
				for (Obs obs3 : e.getObs()) {
					if (obs3.getConcept().getConceptId() == oldEncounterUUIDConcept && obs3.getValueText() != null
							&& obs3.getValueText().length() > 0) { //Take the tag that links the encounter to FileMaker Observations

						List<FileMakerObservation> encounterObs = getAllObs(obs3.getValueText()); //Get all Observations from FileMakerObs table for this encounter
						if (encounterObs.size() > 0) {
							for (FileMakerObservation f : encounterObs) {
								String oldEncounterUUID = f.getEncounter();
								String c = f.getConcept();
								String a = f.getAnswer();
								String co = f.getComment();
								if (oldEncounterUUID != null && oldEncounterUUID.length() > 0 && c != null && c.length() > 0
										&& FileMakerObservationUtil.getConceptFormText(c) != null) {
									FileMakerObservationUtil.createObs(oldEncounterUUID, FileMakerObservationUtil.getConceptFormText(c), a, co, e);

								}
							}
						}

					}
				}
			}
		}

	}

	public void setEncounterObsForm(String formId) {
		FileMakerObservationUtil.setEncounterObsForm(formId);

	}

}
