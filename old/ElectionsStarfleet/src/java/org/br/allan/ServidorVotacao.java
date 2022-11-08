 /* Diário ---------------------------------------++++++++++


    - colocar cands em lista (ok)
    - colocá-los na session (for) (ok)
    - Quem está ganhando?
        "Ele aponta como sendo o último votado. Vamos ajeitar"
           (12/03/17 - 01:24)
        "Consegui. observar diferença em relação às soluções de atributo de sessão
        anteriores" 
    - porcentagem dos votos
        "feito. falta ajeitar precisão das casas do double"
        (14/03/17 - 07:37)

    gráficos (google Charts):
        cand/total de votos (pizza)
        candidados (linha)

    - Ordenar por qtde. votos
    - Adicionar candidato (com foto, nome)

        */
package org.br.allan;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author allanfreitas
 */
public class ServidorVotacao extends HttpServlet {

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
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        
        HttpSession sessao = request.getSession();
        String voto = request.getParameter("nomeCandidato");
        ArrayList<Candidato> listaCandidatos = new ArrayList<Candidato>();
        int qtdCandidatos = 2;
        
        Candidato cand1 = new Candidato("James T. Kirk");
        Candidato cand2 = new Candidato("Spock");
        
        listaCandidatos.add(0, cand1);
        listaCandidatos.add(1, cand2);
        
        Candidato cand;
        Candidato candMaisVotado = new Candidato("temp");
        
        if(sessao.isNew()){
            System.out.println("NOVA SESSAO"); 
            for (int i = 0; i < qtdCandidatos; i++ ){       
                /* Os nomes dos atributos da sessão serão os próprios nomes dos candidatos */
                sessao.setAttribute(listaCandidatos.get(i).getNome(), listaCandidatos.get(i));
                sessao.setAttribute(listaCandidatos.get(i).getNome(), listaCandidatos.get(i));
            } 
           
            candMaisVotado.setVotos(0); // na primeira vez, o candidato mais votado tem 0 votos
            sessao.setAttribute("candMaisVotado", candMaisVotado);
            candMaisVotado = (Candidato)sessao.getAttribute("candMaisVotado"); // candMaisVotado aponta para o atributo da sessão
        }else{         
            System.out.println("MESMA SESSAO");
        }
   
        /* Percorre a lista para incrementar o voto do candidato votado */
       
        
        
        for (int i = 0; i < qtdCandidatos; i++ ){
            
            // se o voto for pra esse candidato
            if( voto.equals( listaCandidatos.get(i).getNome() ) ){
               // Mais um voto foi computado
               Candidato.setTotalDeVotos(Candidato.getTotalDeVotos() + 1);
                /* Pega a referência para esse candidato (atributo da sessao) */
                cand = (Candidato)sessao.getAttribute(listaCandidatos.get(i).getNome());
                // incrementa seu voto
                cand.setVotos( cand.getVotos() + 1);
                
                candMaisVotado = (Candidato)sessao.getAttribute("candMaisVotado");
                if(cand.getVotos() > candMaisVotado.getVotos() ){
                    candMaisVotado = cand;
                    sessao.setAttribute("candMaisVotado", candMaisVotado);
                }
                
                break;
            }
            
        }
      
        float porcentagem = 0; /* Armazena a porcentagem dos candidatos */
        /* Formatando o valor porcentual dos votos (float) para 2 casas decimais após o ponto */
        NumberFormat formatador = new DecimalFormat("#.##");
        
        porcentagem = candMaisVotado.calcularPorcentagem();
        response.getWriter().write("<p><b>Mais Votado: </b>"+candMaisVotado.getNome()+ " with "+ candMaisVotado.getVotos() + " votes "
                + "("+ formatador.format(porcentagem)+"% )</p><br /><br />");
        
      
        /* Imprimindo candidatos */ 
        for (int i = 0; i < qtdCandidatos; i++ ){
            /* Pega o objeto candidato (atributo da sessão) */
            cand = (Candidato)sessao.getAttribute( listaCandidatos.get(i).getNome() );
            porcentagem = cand.calcularPorcentagem();
            response.getWriter().write("<span><b>"+ cand.getNome() + "</b>: " + cand.getVotos() +" votes ("+ formatador.format(porcentagem) +"% )</span><br />");
        
            //response.getWriter().write("<span><b>"+ listaCandidatos.get(i).getNome()+ "</b>: " + listaCandidatos.get(i).getVotos() +" votes</span><br />");
        }
        
        //response.getWriter().write("<span><b>"+ cand2.getNome()+ "</b>: " + cand2.getVotos() + " votes</span><br />");
      
       
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
