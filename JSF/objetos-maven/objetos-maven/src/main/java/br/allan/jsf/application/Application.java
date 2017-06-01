/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allan.jsf.application;

import br.allan.jsf.entity.Carro;
import java.util.Calendar;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Allan Santos
 */
public class Application {

  public static void main(String[] args) {
      
        Carro carro = new Carro();
        preencherCarro(carro);
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //EntityManagerFactory realiza a leitura das informações relativas à "persistence-unit".
            emf = Persistence.createEntityManagerFactory("sistema_carros");
            em = emf.createEntityManager(); //Criação do EntityManager.
            et = em.getTransaction(); //Recupera objeto responsável pelo gerenciamento de transação.
            et.begin();
            em.persist(carro);
            et.commit();
            System.out.println("DEU COMMIT -----------------------------");
        } catch (Exception ex) {
            if (et != null)
                et.rollback();
            
            System.out.println("NAO DEU COMMIT -----------------------------");
        } finally {
            if (em != null)
                em.close();       
            if (emf != null)
                emf.close();
            
            System.out.println("NAO DEU COMMIT -----------------------------");
        }
    }

    private static void preencherCarro(Carro carro) {
        carro.setModelo("Hb20");
        carro.setCor("Azul");
        carro.setFabricante("Hyundai");
        
        Calendar calendario = Calendar.getInstance();
        calendario.set(2017, 7, 17);
        
        carro.setAno(calendario.getTime());
        System.err.println("Ano carro: "+ calendario.getTime()); 
    }
}

