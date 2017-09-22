/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.permiso.bean;

import co.com.prueba.administrar.personas.delegate.PermisoDelegate;
import co.com.prueba.dto.Permiso;
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
@Named(value = "permisoManagedBean")
@SessionScoped
@ManagedBean
public class PermisoManagedBean {
    
    private Permiso permiso;
    private String error;

    /**
     * Creates a new instance of PermisoManagedBean
     */
    public PermisoManagedBean() {
        permiso = new Permiso();
    }
    
    public String guardarPermiso(){
        PermisoDelegate.guardarPermiso(permiso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El permiso fue almacenado satisfactoriamente."));
        return  "maestroPermiso";
    }
    
    public String actualizarPermiso(){
        PermisoDelegate.actualizarPermiso(permiso);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El permiso fue actualizado satisfactoriamente."));
        return "maestroPermiso";
    }
    
    public String eliminarPermiso(){
        System.out.println(permiso.getIdPermiso());
        PermisoDelegate.eliminarPermiso(permiso.getIdPermiso());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El permiso fue eliminado satisfactoriamente."));
        return "maestroPermiso";
    }
    
    public String consultarPermiso(int id){
        PermisoDelegate.consultarPermiso(id);
        return "maestroPermiso";
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
