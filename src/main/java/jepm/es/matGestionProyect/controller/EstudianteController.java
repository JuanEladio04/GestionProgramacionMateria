package jepm.es.matGestionProyect.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jepm.es.matGestionProyect.model.Estudiante;
import jepm.es.matGestionProyect.model.Profesor;

public class EstudianteController {
	
	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionProgramacionMateria");	
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Estudiante> query = em.createNamedQuery("Estudiante.findAll", Estudiante.class);
	    return query.getResultList();
	}
	

}
