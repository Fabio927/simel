/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.correos.bean;

import co.com.prueba.administrar.personas.delegate.CorreoDelegate;
import co.com.prueba.administrar.personas.delegate.PersonaDelegate;
import co.com.prueba.dto.Correo;
import co.com.prueba.dto.Persona;
import co.com.prueba.util.SessionUtil;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "correoManagedBean")
@SessionScoped
@ManagedBean
public class CorreoManagedBean implements Serializable {

    private Correo correo;
    private List <SelectItem> personaList = new <SelectItem> ArrayList(); //Lista las personas
    private String personaSelect =""; //Permite seleccionar las personas
    private String error;
    private String de;
    private int idPersona;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
    
    
    /**
     * Creates a new instance of CorreoManagedBean
     */
    public CorreoManagedBean() {
        correo = new Correo();
        List <Persona> arregloPersona = PersonaDelegate.obtenerListadoPersonas(); //Obtiene listado de Personas
        personaList.add(new SelectItem("0", "Seleccione", "", false, false, true)); //Primera opcion del combo
        for (Persona persona : arregloPersona) {
            personaList.add(new SelectItem(persona.getIdPersona(), persona.getCorreo())); //Agrega al combo las Personas que encuentra en la tabla Persona
        }
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public List<SelectItem> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<SelectItem> personaList) {
        this.personaList = personaList;
    }

    public String getPersonaSelect() {
        return personaSelect;
    }

    public void setPersonaSelect(String personaSelect) {
        this.personaSelect = personaSelect;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }
    
    
    
     public String enviarCorreo(String para, String asunto, String mensaje){
         Persona persona = new Persona();
         persona = PersonaDelegate.consultarPersona(Integer.parseInt(personaSelect));
         correo.setPersona(persona);
        Email email = new Email("gerenciasimel@gmail.com", "Simel1234", para);
        email.enviarSimple(asunto, mensaje);      
        correo.setAsunto(asunto);
        correo.setMensaje(mensaje);
        correo.setPara(para);
        CorreoDelegate.guardarCorreo(correo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El correo fue enviado satisfactoriamente."));
        SessionUtil.limpiar();
        return "/vista/correo/maestroCorreo";
    }
    
    public String guardarCorreo(){
            String retorno = "";
            Persona persona = new Persona();
            persona = PersonaDelegate.consultarPersona(Integer.parseInt(personaSelect));
            correo.setPersona(persona);
             CorreoDelegate.guardarCorreo(correo);
            
            retorno="maestroCorreo";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El correo fue almacenado satisfactoriamente."));		
        
        return retorno;
    }
    
    public String actualizarCorreo(){
            Persona persona = new Persona();
            persona = PersonaDelegate.consultarPersona(Integer.parseInt(personaSelect));
            correo.setPersona(persona);
             CorreoDelegate.actualizarCorreo(correo);                     
       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El correo fue actualizado satisfactoriamente."));
        return "maestroCorreo";        
    }
    
    public String eliminarCorreo(){
        CorreoDelegate.eliminarCorreo(correo.getIdCorreo());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El correo fue eliminado satisfactoriamente."));
        return "maestroCorreo";
    }
    
}
