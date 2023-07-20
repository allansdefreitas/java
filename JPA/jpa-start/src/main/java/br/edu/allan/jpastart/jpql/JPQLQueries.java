package br.edu.allan.jpastart.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.allan.jpastart.config.Config;
import br.edu.allan.jpastart.jpql.dto.UsuarioDTO;
import br.edu.allan.jpastart.model.Dominio;
import br.edu.allan.jpastart.model.Usuario;


public class JPQLQueries {

    public static final String PERSISTENCE_UNIT = Config.PERSISTENCE_UNIT;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        primeirasConsultas(entityManager);
//        escolhendoORetorno(entityManager);
//        fazendoProjecoes(entityManager);
        passandoParametros(entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void passandoParametros(EntityManager entityManager) {
        String jpql = "select u from Usuario u where u.id = :idUsuario";
        TypedQuery<Usuario> typedQuery = entityManager.
                createQuery(jpql, Usuario.class).
                setParameter("idUsuario", 1L);
        Usuario usuario = typedQuery.getSingleResult();
        System.out.println(usuario.getId() + ", " + usuario.getNome());


        String jpqlLog = "select u from Usuario u where u.login = :loginUsuario";
        TypedQuery<Usuario> typedQueryLog = entityManager.
                createQuery(jpqlLog, Usuario.class).
                setParameter("loginUsuario", "ria");
        Usuario usuarioLog = typedQueryLog.getSingleResult();
        System.out.println(usuarioLog.getId() + ", " + usuarioLog.getNome());


    }

    public static void fazendoProjecoes(EntityManager entityManager) {
        String jpqlArr = "select id, login, nome from Usuario";
        TypedQuery<Object[]> typedQueryArr = entityManager.createQuery(jpqlArr, Object[].class);
        List<Object[]> listaArr = typedQueryArr.getResultList();
        listaArr.forEach(arr -> System.out.println(String.format("%s, %s, %s", arr)));


        String jpqlDto = "select new com.algaworks.sistemausuarios.dto.UsuarioDTO(id, login, nome)" +
                "from Usuario";
        TypedQuery<UsuarioDTO> typedQueryDto = entityManager.createQuery(jpqlDto, UsuarioDTO.class);
        List<UsuarioDTO> listaDto = typedQueryDto.getResultList();
        listaDto.forEach(u -> System.out.println("DTO: " + u.getId() + ", " + u.getNome()));
    }

    public static void escolhendoORetorno(EntityManager entityManager) {
        String jpql = "select u.dominio from Usuario u where u.id = 1";
        TypedQuery<Dominio> typedQuery = entityManager.createQuery(jpql, Dominio.class);
        Dominio dominio = typedQuery.getSingleResult();
        System.out.println(dominio.getId() + ", " + dominio.getNome());

        String jpqlNom = "select u.nome from Usuario u";
        TypedQuery<String> typedQueryNom = entityManager.createQuery(jpqlNom, String.class);
        List<String> listaNom = typedQueryNom.getResultList();
        listaNom.forEach(nome -> System.out.println(nome));
    }

    public static void primeirasConsultas(EntityManager entityManager) {
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> lista = typedQuery.getResultList();
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome()));

        String jpqlSing = "select u from Usuario u where u.id = 1";
        TypedQuery<Usuario> typedQuerySing = entityManager.createQuery(jpqlSing, Usuario.class);
        Usuario usuario = typedQuerySing.getSingleResult();
        System.out.println(usuario.getId() + ", " + usuario.getNome());

        String jpqlCast = "select u from Usuario u where u.id = 1";
        Query query = entityManager.createQuery(jpqlCast);
        Usuario usuario2 = (Usuario) query.getSingleResult();
        System.out.println(usuario2.getId() + ", " + usuario2.getNome());
    }
}
