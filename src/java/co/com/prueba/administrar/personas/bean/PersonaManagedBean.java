/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personas.bean;

import co.com.prueba.administrar.personas.delegate.PersonaDelegate;
import co.com.prueba.dto.Persona;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "personaManagedBean")
@SessionScoped
@ManagedBean
public class PersonaManagedBean implements Serializable {
    
    private Persona persona;
    private String error;
    /**
     * Creates a new instance of PersonaManagedBean
     */
    public PersonaManagedBean() {
        persona = new Persona();
    }
    
    public String guardarPersona(){
        PersonaDelegate.guardarPersona(persona);       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El usuario fue almacenado satisfactoriamente."));
        return "enviarCorreoUsuario";
    }
    
     public String actualizarPersona(){
        PersonaDelegate.actualizarPersona(persona);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El usuario fue actualizado satisfactoriamente."));
        return "maestroPersona";
    }
     
      public String eliminarPersona(){
          PersonaDelegate.eliminarPersona(persona.getIdPersona());        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El usuario fue eliminado satisfactoriamente."));
        return "maestroPersona";
    }  
      
       public String consultarPersona(int id){
       PersonaDelegate.consultarPersona(id);
        return "maestroPersona";
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
       
       
    
}
