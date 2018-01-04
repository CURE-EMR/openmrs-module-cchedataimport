package org.openmrs.module.cchedataimport.api.dao;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.cchedataimport.domain.FileMakerObservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FilemakerObservationDAO {
	
	/*Logger for this class and subclasses*/
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	public List<FileMakerObservation> getObsByEncounterTag(String encounter) {
		Session session = getCurrentSession();
		Criteria cr = session.createCriteria(FileMakerObservation.class);
		cr.add(Restrictions.like("encounter", encounter));
		List<FileMakerObservation> obsList = cr.list();
		return obsList;
	}
	
	public FileMakerObservation getObs(int id) {
		Session session = getCurrentSession();
		FileMakerObservation obs = (FileMakerObservation) session.get(FileMakerObservation.class, new Integer(id));
		return obs;
	}
	
	public FileMakerObservation addObs(FileMakerObservation obs) {
		Session session = getCurrentSession();
		try {
			session.save(obs);
		}
		catch (Exception e) {
			System.exit(1);
		}
		
		return obs;
	}
	
	public void updateObs(FileMakerObservation obs) {
		Session session = getCurrentSession();
		session.update(obs);
	}
	
	public void deleteObs(int id) {
		Session session = getCurrentSession();
		FileMakerObservation p = (FileMakerObservation) session.load(FileMakerObservation.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
	
	private org.hibernate.Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		}
		catch (NoSuchMethodError ex) {
			try {
				Method method = sessionFactory.getClass().getMethod("getCurrentSession", null);
				return (org.hibernate.Session) method.invoke(sessionFactory, null);
			}
			catch (Exception e) {
				throw new RuntimeException("Failed to get the current hibernate session", e);
			}
		}
	}
}
