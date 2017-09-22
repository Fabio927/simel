/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.rol.bean;

import co.com.prueba.administrar.personas.delegate.RolDelegate;
import co.com.prueba.dto.Rol;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "rolManagedBean")
@SessionScoped
@ManagedBean
public class RolManagedBean {
    
    private Rol rol;
    private String error;

    /**
     * Creates a new instance of RolManagedBean
     */
    public RolManagedBean() {
        rol = new Rol();
    }
    
    public String guardarRol() {
        RolDelegate.guardarRol(rol);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El Rol fue almacenado satisfactoriamente."));
        return "maestroRol";
    }
    
    public String actualizarRol() {
        RolDelegate.actualizarRol(rol);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El Rol fue actualizado satisfactoriamente."));
        return "maestroRol";
    }
    
    public String eliminarRol() {
        RolDelegate.eliminarRol(rol.getIdRol());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El Rol fue eliminado satisfactoriamente."));
        return "maestroRol";
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
       
}
