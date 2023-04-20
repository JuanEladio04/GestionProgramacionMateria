package jepm.es.matGestionProyect.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jepm.es.matGestionProyect.model.Profesor;



public class ProfesorController {
	
	/**
	 * 
	 * @return
	 */
	public static List<Profesor> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionProgramacionMateria");	
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Profesor> query = em.createNamedQuery("Profesor.findAll", Profesor.class);
	    return query.getResultList();
	}

}
