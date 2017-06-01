/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allan.jsf.application;

import br.allan.jsf.entity.Carro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Allan Santos
 */
public class Application {

    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("sistema_carros_pu");

    public static void main(String[] args) {

        try {
            Carro carro = new Carro();
            carro.setModelo("Gol");
            carro.setFabricante("VW");
            carro.setCor("Azul");

            inserirCarro();
        } finally {
            EMF.close();
        }

    }

    public static void inserirCarro() {
        EntityManager em = null;
        EntityTransaction et = null;

        Carro carro = new Carro();
        carro.setModelo("Gol");
        carro.setFabricante("VW");
        carro.setCor("Azul");

        try {
            em = EMF.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(carro);
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

}
