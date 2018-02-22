package org.openmrs.module.cchedataimport.api.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	/* Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	FilemakerObservationDAO fileMakerObservationDAO;
	
	@Transactional
	public List<FileMakerObservation> getObsByEncounterTag(String encounter) {
		return fileMakerObservationDAO.getObsByEncounterTag(encounter);
	}
	
	@Transactional
	public FileMakerObservation getAuthorObsByEncounterTag(String encounter) {
		return fileMakerObservationDAO.getAuthorObsByEncounterTag(encounter);
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
	public void createObsForForm(String formTag) {
		List<Obs> obs = Context.getObsService().getObservationsByPersonAndConcept(null, Context.getConceptService().getConcept("Form Id"));
		int i = 0;
		for (Obs obs2 : obs) {
			// Take the encounter if the tag is for the form we want
			if (obs2.getValueText().equalsIgnoreCase(formTag)) {
				Encounter e = obs2.getEncounter();
				for (Obs obs3 : e.getObs()) {
					
					//Take the tag that links the encounter to FileMaker Observations
					
					if (obs3.getConcept().getConceptId() == 3764 && obs3.getValueText() != null && obs3.getValueText().length() > 0) {
						
						//Get all Observations from FileMakerObs table for this encounter
						
						List<FileMakerObservation> fileMakerObservations = getObsByEncounterTag(obs3.getValueText());
						if (fileMakerObservations.size() > 0) {
							for (FileMakerObservation fileMakerObs : fileMakerObservations) {
								String encounterTag = fileMakerObs.getEncounter();
								String fileMakerObsConcept = fileMakerObs.getConcept();
								String fileMakerObsAnswer = fileMakerObs.getAnswer();
								String fileMakerObsComment = fileMakerObs.getComment();
								if (encounterTag != null && encounterTag.length() > 0 && fileMakerObsConcept != null && fileMakerObsConcept.length() > 0 && FileMakerObservationUtil.getConceptFormText(fileMakerObsConcept, formTag) != null) {
									
									FileMakerObservationUtil.createObs(encounterTag, FileMakerObservationUtil.getConceptFormText(fileMakerObsConcept, formTag), fileMakerObsAnswer, fileMakerObsComment, e, formTag);
									
								}
							}
						}
						
					}
				}
				log.error(++i + ".===Turangije encounter " + e.getId());
			}
		}
		
	}
	
	@Transactional
	public void createSkippedObsForForm(String formTag) {
		List<Obs> toIterate = new ArrayList<Obs>();
		List<String> skippedVisits = new CSVReader().readSkippedVisits();
		
		ConceptService cs = Context.getConceptService();
		Concept c = cs.getConcept("Old Encounter UUID");
		List<Obs> obs = Context.getObsService().getObservationsByPersonAndConcept(null, c);
		
		for (Obs obs2 : obs) {
			if (!obs2.isVoided() && obs2.getValueText() != null && obs2.getValueText().length() > 1 && skippedVisits.contains(obs2.getValueText().trim())) {
				toIterate.add(obs2);
			}
		}
		int i = 0;
		
		try {
			
			for (Obs obs2 : toIterate) {
				Encounter e = obs2.getEncounter();
				
				log.error("==============Encounter tugezeho====================" + obs2.getValueText());
				//Get all Observations from FileMakerObs table for this encounter
				
				List<FileMakerObservation> fileMakerObservations = getObsByEncounterTag(obs2.getValueText());
				if (fileMakerObservations.size() > 0) {
					for (FileMakerObservation fileMakerObs : fileMakerObservations) {
						String encounterTag = fileMakerObs.getEncounter();
						String fileMakerObsConcept = fileMakerObs.getConcept();
						String fileMakerObsAnswer = fileMakerObs.getAnswer();
						String fileMakerObsComment = fileMakerObs.getComment();
						if (encounterTag != null && encounterTag.length() > 0 && fileMakerObsConcept != null && fileMakerObsConcept.length() > 0 && FileMakerObservationUtil.getConceptFormText(fileMakerObsConcept, formTag) != null) {
							
							FileMakerObservationUtil.createObs(encounterTag, FileMakerObservationUtil.getConceptFormText(fileMakerObsConcept, formTag), fileMakerObsAnswer, fileMakerObsComment, e, formTag);
							
						}
					}
				}
				
				log.error(++i + ".===Turangije encounter " + e.getId());
				
			}
			
		}
		catch (Exception e) {
			log.error("===========Habaye ikibazo", e);
		}
		
	}
	
	@Transactional
	public void setOrthopedicAuthorComment() {
		Map<String, Encounter> toIterate = new HashMap<String, Encounter>();
		List<String> encountersRead = new CSVReader().readAllEncountersFromForm();
		
		ConceptService cs = Context.getConceptService();
		Concept c = cs.getConcept("Old Encounter UUID");
		List<Obs> obs = Context.getObsService().getObservationsByPersonAndConcept(null, c);
		
		for (Obs obs2 : obs) {
			if (!obs2.isVoided() && obs2.getValueText() != null && obs2.getValueText().length() > 1 && encountersRead.contains(obs2.getValueText().trim())) {
				toIterate.put(obs2.getValueText(), obs2.getEncounter());
			}
		}
		
		Encounter e = null;
		Obs author = null;
		
		for (Entry<String, Encounter> entry : toIterate.entrySet()) {
			e = entry.getValue();
			FileMakerObservation filemakerObs = getAuthorObsByEncounterTag(entry.getKey());
			String comment = filemakerObs.getComment();
			
			for (Obs o : e.getObs()) {
				if (o.getConcept().getConceptId() == 3645) {
					author = o;
					
					if (comment != null && comment.length() > 1) {
						author.setComment(comment);
					}
				}
				
				if (author == null) {
					Obs otherAuthor = new Obs();
					otherAuthor.setConcept(cs.getConcept(3644));
					otherAuthor.setPerson(e.getPatient().getPerson());
					otherAuthor.setObsDatetime(e.getEncounterDatetime());
					otherAuthor.setDateCreated(e.getDateCreated());
					otherAuthor.setCreator(e.getCreator());
					otherAuthor.setLocation(e.getLocation());
					otherAuthor.setEncounter(e);
				}
			}
			
			Context.getObsService().saveObs(author, "Adding Author comment");
		}
		
	}
	
	public void setEncounterObsForm(String formId) {
		FileMakerObservationUtil.setEncounterObsForm(formId);
		
	}
	
	public void setSkippedEncounterObsForm(String formId) {
		FileMakerObservationUtil.setSkippedEncounterObsForm(formId);
		
	}
	
}
