/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.allan.elections.model;

/**
 *
 * @author Allan Santos
 */
public class Candidate {
    private String name;
    private Integer votes;
    private static Integer electionsTotalVotes;

    
    public Candidate(String name, Integer votes){
        this.name = name;
        this.votes = votes;
    }

    public Candidate(String name) {
          this.name = name;
          this.votes = 0;
    }

    public Candidate() {
        this.name = null;
        this.votes = null;
    }
    
    
    /* Increment vote */
    public void vote (){
        this.votes += 1; 
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public static Integer getElectionsTotalVotes() {
        return electionsTotalVotes;
    }

    public static void setElectionsTotalVotes(Integer electionsTotalVotes) {
        Candidate.electionsTotalVotes = electionsTotalVotes;
    }
    
}
