package br.edu.ifpe.jsfobjetos.bean;

import br.edu.ifpe.jsfobjetos.entity.Carro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author allanfreitas
 */

@ManagedBean(name = "carroManagedBean")
@SessionScoped
public class CarroBean {
    
    private Carro carro;
    private List<Carro> listaCarro = new ArrayList<>();
    
    public void adicionar(){
        listaCarro.add(carro);
        carro = new Carro();
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getListaCarro() {
        return listaCarro;
    }

    public void setListaCarro(List<Carro> listaCarro) {
        this.listaCarro = listaCarro;
    }
    
    
    
    
}
