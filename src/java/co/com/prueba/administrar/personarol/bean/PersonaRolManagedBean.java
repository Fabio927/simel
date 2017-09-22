/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personarol.bean;

import co.com.prueba.administrar.personas.delegate.PersonaDelegate;
import co.com.prueba.administrar.personas.delegate.PersonaRolDelegate;
import co.com.prueba.administrar.personas.delegate.RolDelegate;
import co.com.prueba.dto.Persona;
import co.com.prueba.dto.PersonaRol;
import co.com.prueba.dto.Rol;
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
@Named(value = "personaRolManagedBean")
@SessionScoped
@ManagedBean
public class PersonaRolManagedBean {
    
    private PersonaRol personaRol;
    private List <SelectItem> rolList = new <SelectItem> ArrayList(); //Lista los Roles
    private List <SelectItem> personaList = new <SelectItem> ArrayList(); //Lista las personas
    private String rolSelect ="";
    private String personaSelect ="";
    private String error ;

    /**
     * Creates a new instance of PersonaRolManagedBean
     */
    public PersonaRolManagedBean() {
        personaRol = new PersonaRol();
        
        List <Rol> arregloRol = RolDelegate.obtenerListadoRol(); //Obtiene listado de Rol
        rolList.add(new SelectItem("0", "Seleccione", "", false, false, true)); //Primera opcion del combo
        for (Rol rol : arregloRol) {
            rolList.add(new SelectItem(rol.getIdRol(), rol.getNombreRol())); //Agrega al combo los Roles que encuentra en la tabla Rol
        }
        
        List <Persona> arregloPersona = PersonaDelegate.obtenerListadoPersonas(); //Obtener listado de Personas
        personaList.add(new SelectItem("0", "Seleccione", "", false, false, true));
        for (Persona persona : arregloPersona) {
            personaList.add(new SelectItem(persona.getIdPersona(), persona.getNombre() + " " + persona.getApellido()));
        }        
    }

    public PersonaRol getPersonaRol() {
        return personaRol;
    }

    public void setPersonaRol(PersonaRol personaRol) {
        this.personaRol = personaRol;
    }

    public List<SelectItem> getRolList() {
        return rolList;
    }

    public void setRolList(List<SelectItem> rolList) {
        this.rolList = rolList;
    }

    public List<SelectItem> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<SelectItem> personaList) {
        this.personaList = personaList;
    }

    public String getRolSelect() {
        return rolSelect;
    }

    public void setRolSelect(String rolSelect) {
        this.rolSelect = rolSelect;
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
    
    public String guardarPersonaRol(){
        String retorno = "";
        
        Rol rol = new Rol();
        rol = RolDelegate.consultarRol(Integer.parseInt(rolSelect));
        personaRol.setRol(rol);
        
        Persona persona = new Persona();
        persona = PersonaDelegate.consultarPersona(Integer.parseInt(personaSelect));
        personaRol.setPersona(persona);
        
        PersonaRolDelegate.guardarPersonaRol(personaRol);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El rol del usuario fue almacenado satisfactoriamente."));
        retorno = "maestroPersonaRol";
        
        return retorno;
    }
    
    public String actualizarPersonaRol(){
       Rol rol = new Rol();
       rol = RolDelegate.consultarRol(Integer.parseInt(rolSelect));
       personaRol.setRol(rol);
       
       Persona persona = new Persona();
       persona = PersonaDelegate.consultarPersona(Integer.parseInt(personaSelect));
       personaRol.setPersona(persona);
       
       PersonaRolDelegate.actualizarPersonaRol(personaRol);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El rol del usuario fue actualizado satisfactoriamente."));
        return "maestroPersonaRol";
    }
    
     public String eliminarPersonaRol(){
         PersonaRolDelegate.eliminarPersonaRol(personaRol.getIdPersonaRol());        
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El rol del usuario fue eliminado satisfactoriamente."));
        return "maestroPersonaRol";
    }    
    
}
