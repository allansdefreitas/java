package br.edu.allan.jpastart.jpql.joins;

import br.edu.allan.jpastart.config.Config;
import br.edu.allan.jpastart.model.Configuracao;
import br.edu.allan.jpastart.model.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JPQLJoinsQueries {

    public static final String PERSISTENCE_UNIT = Config.PERSISTENCE_UNIT;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        doInnerJoins(entityManager);
//        doLeftJoin(entityManager);
//        doJoinFetch(entityManager);
//        FilterEntities(entityManager);
//        useLogicalOperators(entityManager);
//        useInOperator(entityManager);
//        doOrdering(entityManager);
        doPagination(entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void doInnerJoins(EntityManager entityManager) {
        String jpql = "select u " +
                "from Usuario u " +
                "join u.dominio d " + // The same of INNER JOIN
                "WHERE d.id = 1";

        TypedQuery<Usuario> typedQuery = entityManager
                .createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = typedQuery.getResultList();

        usuarios.forEach(u -> System.out.println(u.getId() + " " + u.getNome()) );

    }

    public static void doLeftJoin(EntityManager entityManager){
        String jpql = "select u, c " +
                "from Usuario u " +
                "left join " + // The same of LEFT OUTER JOIN
                "u.configuracao c";

        TypedQuery<Object[]> typedQuery = entityManager
                .createQuery(jpql, Object[].class);

        List<Object[]> usuariosLeftDominios = typedQuery.getResultList();

        usuariosLeftDominios.forEach(arr -> {

            String out =( ( (Usuario) arr[0]).getNome() ) ;

            if(arr[1] == null){
                out += ", NULL";
            }else{
                out += ", " + ( ((Configuracao) arr[1]).getId() );
            }

            System.out.println(out);

        });
    }

    public static void doJoinFetch(EntityManager entityManager){
        String jpql = "select u " +
                "from Usuario u " +
                "join fetch u.configuracao " + // Já traz configuracao na mesma query
                "join fetch u.dominio"; // Já traz domínio na mesma query
        TypedQuery typedQuery = entityManager
                .createQuery(jpql, Usuario.class);

        // LEFT JOIN FETCH
//        String jpql = "select u " +
//                "from Usuario u " +
//                "left join fetch u.configuracao " + // Já traz configuracao na mesma query
//                "left join fetch u.dominio"; // Já traz domínio na mesma query
//        TypedQuery typedQuery = entityManager
//                .createQuery(jpql, Usuario.class);

        List<Usuario> usuarios = typedQuery.getResultList();

        usuarios.forEach(u ->{
            System.out.println(u.getId() + " " + u.getNome());
        });

    }
    public static void FilterEntities(EntityManager entityManager){
        //LIKE, IS NULL, IS EMPTY, BETWEEN, >, <, >=, <=, =, <>

//        String jpql = "select u " +
//                "from Usuario u " +
//                "WHERE u.nome LIKE :userName";
//        TypedQuery typedQuery = entityManager
//                .createQuery(jpql, Usuario.class)
//                .setParameter("userName", "%ll%");

//        String jpql = "select u " +
//                "from Usuario u " +
//                "WHERE u.nome LIKE concat('%', :userName, '%')";
//        TypedQuery typedQuery = entityManager
//                .createQuery(jpql, Usuario.class)
//                .setParameter("userName", "ll");

//
//        String jpql = "select u " +
//                "from Usuario u " +
//                "WHERE u.nome = :userName";
//        TypedQuery typedQuery = entityManager
//                .createQuery(jpql, Usuario.class)
//                .setParameter("userName", "Gillian Foster");
//
//        List<Usuario> usuarios = typedQuery.getResultList();



//        String jpql = "select u " +
//                "from Usuario u " +
//                "WHERE u.id >= :id";
//        TypedQuery typedQuery = entityManager
//                .createQuery(jpql, Usuario.class)
//                .setParameter("id", 3L);


//        String jpql = "select u " +
//                "from Usuario u " +
//                "WHERE u.id BETWEEN :idStart AND :idEnd";
//        TypedQuery typedQuery = entityManager
//                .createQuery(jpql, Usuario.class)
//                .setParameter("idStart", 3L)
//                .setParameter("idEnd", 4L);


//        String jpql = "select d " +
//                "from Dominio d " +
//                "WHERE d.usuarios IS EMPTY";
//
//        TypedQuery typedQuery = entityManager
//                .createQuery(jpql, Usuario.class);
//
//        List<Dominio> dominios = typedQuery.getResultList();
//        dominios.forEach(d ->{
//            System.out.println(d.getId() + " " + d.getNome());
//        });

        String jpql = "select u " +
                "from Usuario u " +
                "WHERE u.ultimoAcesso " +
                    "BETWEEN :startDate AND :endDate";

        TypedQuery typedQuery = entityManager
                .createQuery(jpql, Usuario.class)
                .setParameter("startDate", LocalDateTime.now().minusDays(1L))
                .setParameter("endDate", LocalDateTime.now() );


        List<Usuario> usuarios = typedQuery.getResultList();
        usuarios.forEach(u ->{
            System.out.println(u.getId() + " " + u.getNome() + " " + u.getUltimoAcesso());
        });
    }

    public static void useLogicalOperators(EntityManager entityManager){
        String jpql = "select u " +
                "from Usuario u " +
                "WHERE u.ultimoAcesso >= :startDate AND " +
                "u.ultimoAcesso <= :endDate";

        TypedQuery typedQuery = entityManager
                .createQuery(jpql, Usuario.class)
                .setParameter("startDate", LocalDateTime.now().minusDays(1L))
                .setParameter("endDate", LocalDateTime.now().plusDays(2) );


        List<Usuario> usuarios = typedQuery.getResultList();
        usuarios.forEach(u ->{
            System.out.println(u.getId() + " " + u.getNome() + " " + u.getUltimoAcesso());
        });


    }

    public static void useInOperator(EntityManager entityManager){
        String jpql = "select u " +
                "from Usuario u " +
                "WHERE u.id in (:ids)";

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);

        TypedQuery typedQuery = entityManager
                .createQuery(jpql, Usuario.class)
                .setParameter("ids", Arrays.asList(1L,2L,3L)); //It could be an array of objects



        List<Usuario> usuarios = typedQuery.getResultList();
        usuarios.forEach(u ->{
            System.out.println(u.getId() + " " + u.getNome() + " " + u.getUltimoAcesso());
        });
    }

    public static void doOrdering(EntityManager entityManager){
        String jpql = "select u " +
                "from Usuario u " +
                "ORDER BY u.nome";


        TypedQuery typedQuery = entityManager
                .createQuery(jpql, Usuario.class);

        List<Usuario> usuarios = typedQuery.getResultList();
        usuarios.forEach(u ->{
            System.out.println(u.getId() + " " + u.getNome() + " " + u.getUltimoAcesso());
        });
    }

    public static void doPagination(EntityManager entityManager){
        String jpql = "select u " +
                "from Usuario u";

        TypedQuery typedQuery = entityManager
                .createQuery(jpql, Usuario.class)
                .setFirstResult(4) // the index of row
                .setMaxResults(2); //Quantity of rows by page

        List<Usuario> usuarios = typedQuery.getResultList();
        usuarios.forEach(u ->{
            System.out.println(u.getId() + " " + u.getNome() + " " + u.getUltimoAcesso());
        });
    }

}
