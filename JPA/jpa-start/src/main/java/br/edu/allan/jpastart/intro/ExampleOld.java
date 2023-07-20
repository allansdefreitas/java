package br.edu.allan.jpastart.intro;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.allan.jpastart.config.Config;
import br.edu.allan.jpastart.model.Questionario;

public class ExampleOld {
	
	public static final String PERSISTENCE_UNIT = Config.PERSISTENCE_UNIT;
	
//	public static void main(String[] args) {

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
//		EntityManager em = emf.createEntityManager();
//
////		Long codigoQuestionario = insert();
////		remove(codigoQuestionario);
//
////		updateMerge(codigoQuestionario);
////		insertMerge();
//
//
//		em.close();
//		emf.close();
		
		
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		
//		CriteriaQuery<Questionario> cq = cb.createQuery(Questionario.class);
//		Root<Questionario> from = cq.from(Questionario.class);
//
//		cq.select(Questionario);
//		TypedQuery<Questionario> q = em.createQuery(cq);
//		List<Questionario> allitems = q.getResultList();
//	}
	
	public static Long insert() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager em = emf.createEntityManager();
		
		Questionario questionario = em.find(Questionario.class, 1L);
		System.out.println(questionario);
		
		Questionario questInsert = new Questionario();
		questInsert.setIdentificacaoQuestionario("QUEST JPA");
		questInsert.setDataUltimaModificacao(new Date());
		questInsert.setCpfUsuarioModificacao(0L);
		questInsert.setUltimaAtualizacao(new Date());
		questInsert.setSituacao("CRIANDO");
		questInsert.setCodigoCategoriaNota("EST");
		
		em.getTransaction().begin();
		em.persist(questInsert);
		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	
		return questInsert.getCodigoQuestionario();
	}
	
	public static void remove(Long codigoQuestionario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager em = emf.createEntityManager();
		
		Questionario questionario = em.find(Questionario.class, codigoQuestionario);

		em.getTransaction().begin();
		
		em.remove(questionario);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
	
	public static void update(Long codigoQuestionario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager em = emf.createEntityManager();

		Questionario questionarioUpdate = em.find(Questionario.class, codigoQuestionario);
		
		em.getTransaction().begin();

		questionarioUpdate.setIdentificacaoQuestionario("QUEST JPA UPDATED");

		em.getTransaction().commit();
		em.close();
		emf.close();

	}
	
	
	public static void updateMerge(Long codigoQuestionario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager em = emf.createEntityManager();

		//Fill a not managed object and merge it after
		Questionario questionarioUpdate = new Questionario();
		questionarioUpdate.setCodigoQuestionario(codigoQuestionario);
		questionarioUpdate.setIdentificacaoQuestionario("QUEST UPDATED");
		questionarioUpdate.setDataUltimaModificacao(new Date());
		questionarioUpdate.setCpfUsuarioModificacao(0L);
		questionarioUpdate.setUltimaAtualizacao(new Date());
		questionarioUpdate.setSituacao("CRIANDO");
		questionarioUpdate.setCodigoCategoriaNota("EST");
		
		
		em.getTransaction().begin();
		
		em.merge(questionarioUpdate);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
	
	public static void insertMerge() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager em = emf.createEntityManager();

		//Fill a not managed object and merge it after
		Questionario questionarioUpdate = new Questionario();
		questionarioUpdate.setIdentificacaoQuestionario("QUEST INSERTED MERGE");
		questionarioUpdate.setDataUltimaModificacao(new Date());
		questionarioUpdate.setCpfUsuarioModificacao(0L);
		questionarioUpdate.setUltimaAtualizacao(new Date());
		questionarioUpdate.setSituacao("CRIANDO");
		questionarioUpdate.setCodigoCategoriaNota("EST");
		
		
		em.getTransaction().begin();
		
		em.merge(questionarioUpdate);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
