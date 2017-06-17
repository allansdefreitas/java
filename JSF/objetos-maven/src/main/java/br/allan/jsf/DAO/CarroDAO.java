/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allan.jsf.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import br.allan.jsf.entity.Carro;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Allan Santos
 */
public class CarroDAO {

    public static void main(String[] args) {

        List<Carro> listaCarros = null;
        listaCarros = consultarCarros();

    }

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("sistema_carros_pu");

    public static void inserirCarro(Carro carro) {
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(carro);
            et.commit();
            System.err.println("DEU COMMIT -----------------------------------------------------");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            System.err.println("NÃO NAO DEU COMMIT -----------------------------------------------------");
        } finally {
            if (em != null) {
                em.close();
            }
        }
        System.err.println("FIM -----------------------------------------------------");
    }

    public static List<Carro> getAll() {
        EntityManager em = EMF.createEntityManager();
        return em.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
    }

    public static List<Carro> consultarCarros() {

       EntityManager em = EMF.createEntityManager();
       
        Query query = null;

        try {
            String jpql = "SELECT c FROM Carro c";
            query = em.createQuery(jpql, Carro.class);

        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }

        if (query != null) {
            return (List<Carro>) query.getResultList();
        }

        return null;
    }

}
