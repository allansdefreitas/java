/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.i18n.controll;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Allan Santos
 */

@ManagedBean(name = "LanguageManagerMB")
@SessionScoped
public class LanguageManager implements Serializable {

    public LanguageManager() {
    }
    
    public void changeLanguage(Locale locale){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getViewRoot().setLocale(locale);
    }
    
    public String english(){
        Locale locale = new Locale("en", "US");
        changeLanguage(locale);
        return null;
    }
    
    public String portuguese(){
        Locale locale = new Locale("pt", "BR");
        changeLanguage(locale);
        return null;
    }
}