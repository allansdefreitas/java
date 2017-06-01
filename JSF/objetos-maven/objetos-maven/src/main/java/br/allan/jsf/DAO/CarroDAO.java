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

/**
 *
 * @author Allan Santos
 */
public class CarroDAO {
    
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
    
}
