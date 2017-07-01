/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allan.jsf.bean;


import br.allan.jsf.DAO.CarroDAO;
import  br.allan.jsf.entity.Carro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CarroBean {
    
    private Carro carro = new Carro();
    private List<Carro> carros = new ArrayList<>();
    
    public void adicionar(){
        
        //carros.add(carro);
        CarroDAO.inserirCarro(carro);
        carro = new Carro();
    }
    
    public void editar(Carro carro){
        carro = carro;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        
        return CarroDAO.consultarCarros();
//        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

}
