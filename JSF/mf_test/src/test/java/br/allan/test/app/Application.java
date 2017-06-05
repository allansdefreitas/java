/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allan.test.app;

/**
 *
 * @author Allan Santos
 */

import br.allan.entity.Usuario;
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
      
        Usuario usuario = new Usuario();
        preencherUsuario(usuario);
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //EntityManagerFactory realiza a leitura das informações relativas à "persistence-unit".
            emf = Persistence.createEntityManagerFactory("minhas_financas_pu");
            em = emf.createEntityManager(); //Criação do EntityManager.
            et = em.getTransaction(); //Recupera objeto responsável pelo gerenciamento de transação.
            et.begin();
            em.persist(usuario);
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
            
            
        }
        System.out.println("FIM -----------------------------");
    }

    private static void preencherUsuario(Usuario usuario) {
       usuario.setNome("Bruno");
       usuario.setCidade("Recife");
       usuario.setEmail("bruno_assis@gmail.com");
       usuario.setPais("Brazil");
       usuario.setSenha("bpassword");
       
       Calendar calendario = Calendar.getInstance();
       calendario.set(1995, 06, 02);
       
       usuario.setDataNascimento(calendario.getTime());
    }
}


