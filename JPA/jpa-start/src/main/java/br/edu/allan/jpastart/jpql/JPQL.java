package br.edu.allan.jpastart.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.edu.allan.jpastart.config.Config;
import br.edu.allan.jpastart.jpql.dto.UsuarioDTO;
import br.edu.allan.jpastart.model.Dominio;
import br.edu.allan.jpastart.model.Usuario;


public class JPQL {

	public static final String PERSISTENCE_UNIT = Config.PERSISTENCE_UNIT;

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager em = emf.createEntityManager();

		/* JPQL -------------------------------------------------------### */
//		typedQueryResultList(em);
//		typedDuerySingleEntity(em);
//		querySingleEntity(em);
//		typedQueryChoseReturnType(em);
//		typedQueryChoseReturnTypeString(em);
//		doProjections(em);
//		doProjectionsSpecificObjectReturn(em);
//		passParametersQuery(em);
		
		/* Criteria API -----------------------------------------------### */
//		criteriaAPIStart(em);
//		criteriaAPIOrderResults(em);
		
		

		em.close();
		emf.close();
	}

	private static void typedQueryResultList(EntityManager em) {

		String jpql = "SELECT u from Usuario u";
		TypedQuery<Usuario> typedQuery = em.createQuery(jpql, Usuario.class);
		
		List<Usuario> list = typedQuery.getResultList();
		
		list.forEach(u -> System.out.println(u.getId() + " " + u.getLogin()));
		
		System.out.println(list);
		
	}
	
	private static void typedDuerySingleEntity(EntityManager em) {

		String jpql = "SELECT u from Usuario u "
				+ "WHERE u.id = 1";
		TypedQuery<Usuario> typedQuery = em.createQuery(jpql, Usuario.class);
		
		Usuario user = typedQuery.getSingleResult();
		
		System.out.println(user);
		
	}
	
	private static void querySingleEntity(EntityManager em) { 
		
		String jpql = "SELECT u from Usuario u "
				+ "WHERE u.id = 1";
		Query query = em.createQuery(jpql);
		
		Usuario user = (Usuario) query.getSingleResult();
		
		System.out.println(user);
		
	}
	
	private static void typedQueryChoseReturnType(EntityManager em) { 
		
		String jpql = "SELECT u.dominio from Usuario u "
				+ "WHERE u.id = 1";
		TypedQuery<Dominio> typedQuery = em.createQuery(jpql, Dominio.class);
		
		Dominio domain = typedQuery.getSingleResult();
		
		System.out.println(domain);
		
	}
	private static void typedQueryChoseReturnTypeString(EntityManager em) { 
		
		String jpql = "SELECT u.nome from Usuario u";
		TypedQuery<String> typedQuery = em.createQuery(jpql, String.class);
		
		List<String> nameList = typedQuery.getResultList();
		
		System.out.println(nameList);
		
	}

	/**
	 * Get some atts of an entity
	 * @param em
	 */
	private static void doProjections(EntityManager em) { 
		
		String jpql = "SELECT id, login, nome from Usuario";
		
		TypedQuery<Object[]> typedQuery = em.createQuery(jpql, Object[].class);
		
		List<Object[]> resultList = typedQuery.getResultList();
		
		resultList.forEach(arr -> System.out.println(String.format("%d, %s, %s", arr)));
		
	}
	
	/**
	 * Get some atts of entity (User) and put the return in a specific object (UserDTO)
	 * @param em
	 */
	private static void doProjectionsSpecificObjectReturn(EntityManager em) { 
		
		String jpql = "SELECT new br.edu.allan.jpastart.jpql.dto.UsuarioDTO(id, login, nome) "
				+ "from Usuario";
		
		TypedQuery<UsuarioDTO> typedQuery = em
				.createQuery(jpql, UsuarioDTO.class);
		
		List<UsuarioDTO> resultListDTO = typedQuery.getResultList();
		
		resultListDTO.forEach(u -> System.out.println(u.getId() + " " + u.getNome()));		
	}

	private static void passParametersQuery(EntityManager em) { 
		
		Integer id = 1;
		String jpql = "SELECT u from Usuario u "
				+ "WHERE u.id = :userId";
		
		TypedQuery<Usuario> typedQuery = em
				.createQuery(jpql, Usuario.class)
				.setParameter("userId", id);
		
		Usuario user = typedQuery.getSingleResult();

		System.out.println(user);
		
	}
	
	
	public static void criteriaAPIStart(EntityManager em) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
		Root<Usuario> from = cq.from(Usuario.class);
		
		cq.select(from);
		TypedQuery<Usuario> q = em.createQuery(cq);
		List<Usuario> allUsers = q.getResultList();
		
		allUsers.forEach(u -> System.out.println(u));
		
	}
	
	public static void criteriaAPIOrderResults(EntityManager entityManager) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> from = criteriaQuery.from(Usuario.class);
		
		/* Select all objects */
		CriteriaQuery select = criteriaQuery.select(from);
		TypedQuery<Usuario> typedQuery = entityManager.createQuery(select);
		List<Usuario> resultList = typedQuery.getResultList();
		
//		resultList.forEach(u -> System.out.println(u));
		
		//THERE IS SOMETHING WRONG HERE!
		/* Order results */
		CriteriaQuery<Usuario> select1 = criteriaQuery.select(from);
		select1.orderBy(criteriaBuilder.asc(from.get("nome")));
		TypedQuery<Usuario> typedQuery1 = entityManager.createQuery(select);
		List<Usuario> resultList1 = typedQuery1.getResultList();
		
		resultList.forEach( u -> System.out.println(u.getNome()) ) ;
	
	}
}