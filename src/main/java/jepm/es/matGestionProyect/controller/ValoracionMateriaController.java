package jepm.es.matGestionProyect.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jepm.es.matGestionProyect.model.Estudiante;
import jepm.es.matGestionProyect.model.Valoracionmateria;


public class ValoracionMateriaController {
	
	/**
	 * 
	 * @param string
	 */
	public static Valoracionmateria findCalification(int idProf, int idMat, int idStudent) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionProgramacionMateria");
		EntityManager em = entityManagerFactory.createEntityManager();
		Valoracionmateria vp = new Valoracionmateria();
				
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idProfesor = ? and idEstudiante = ? and idMateria = ?", Valoracionmateria.class);

		q.setParameter(1, idProf);
		q.setParameter(2, idStudent);
		q.setParameter(3, idMat);
		
		try {
			vp = (Valoracionmateria) q.getSingleResult();
		} catch (Exception e) {
			vp = null;
		}
		em.close();		
		return vp;
		
	}
	
	
	/**
	 * 
	 */
	public static void realizeUpdate (Valoracionmateria vm) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionProgramacionMateria");

		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(vm);
		em.getTransaction().commit();
		em.close();
	}
	
	
	/**
	 * 
	 */
	public static void realizeInsert (Valoracionmateria vm) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionProgramacionMateria");
		EntityManager em = entityManagerFactory.createEntityManager();	
		
		em.getTransaction().begin();
		em.persist(vm);
		em.getTransaction().commit();
		em.close();
	}
	

}
