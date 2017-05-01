/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.allan.elections.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.allan.elections.model.Candidate;

/**
 *
 * @author Allan Santos
 */
public class ElectionSystem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            ArrayList<Candidate> candidatesList = new ArrayList<>();
            HttpSession session = request.getSession();
            int numberOfCandidates = 3;
            
            /* Actual candidate. This is the selected candidate */
            Candidate actualCandidate = new Candidate();
            actualCandidate.setName(request.getParameter("candidateName"));

            Candidate cand1 = new Candidate("James T. Kirk");
            Candidate cand2 = new Candidate("James T. Kirk (2009)");
            Candidate cand3 = new Candidate("Jean Picard");

            /* Coloca os candidatos na lista */
            candidatesList.add(cand1);
            candidatesList.add(cand2);
            candidatesList.add(cand3);

            if( session.isNew()){
                session.setAttribute("candidatesList", candidatesList);
 
            }else{
                 /* candidateList aponta para o atributo da sessão que tem o mesmo nome*/
                candidatesList = (ArrayList<Candidate>)session.getAttribute("candidatesList");
            
            }
           
            
            /* Verifica pra quem vai o voto */
            for ( int i = 0; i < numberOfCandidates; i++ ){
                
                if ( candidatesList.get(i).getName().equals( actualCandidate.getName() ) ){
                    
                    candidatesList.get(i).vote(); /* Increments him vote */
                    //request.setAttribute("candidatesList", candidatesList);
                }
            }
            
            /* Enviado os dados para o cliente como JSON */
            Gson gson = new Gson();
            String retorno = gson.toJson(candidatesList);
            response.getWriter().write(retorno);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
