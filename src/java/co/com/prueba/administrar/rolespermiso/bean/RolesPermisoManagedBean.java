/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.rolespermiso.bean;

import co.com.prueba.administrar.personas.delegate.PermisoDelegate;
import co.com.prueba.administrar.personas.delegate.RolDelegate;
import co.com.prueba.administrar.personas.delegate.RolesPermisoDelegate;
import co.com.prueba.dto.Permiso;
import co.com.prueba.dto.Rol;
import co.com.prueba.dto.RolesPermiso;
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
@Named(value = "rolesPermisoManagedBean")
@SessionScoped
@ManagedBean
public class RolesPermisoManagedBean {
    
    private RolesPermiso rolesPermiso;
    private List <SelectItem> rolList = new <SelectItem> ArrayList(); //Lista los Roles
    private List <SelectItem> permisoList = new <SelectItem> ArrayList(); //Lista los Permisos
    private String rolesSelect ="";
    private String permisosSelect ="";
    private String error ;

    /**
     * Creates a new instance of RolesPermisoManagedBean
     */
    public RolesPermisoManagedBean() {
        rolesPermiso = new RolesPermiso();
        
        List <Rol> arregloRol = RolDelegate.obtenerListadoRol(); //Obtiene listado de Rol
        rolList.add(new SelectItem("0", "Seleccione", "", false, false, true)); //Primera opcion del combo
        for (Rol rol : arregloRol) {
            rolList.add(new SelectItem(rol.getIdRol(), rol.getNombreRol())); //Agrega al combo las ARL que encuentra en la tabla ARL
        }
        
        List <Permiso> arregloPermiso = PermisoDelegate.obtenerListadoPermiso(); //Obtiene listado de Permiso
        permisoList.add(new SelectItem("0", "Seleccione", "", false, false, true)); //Primer opcion del combo
        for (Permiso permiso : arregloPermiso) {
            permisoList.add(new SelectItem(permiso.getIdPermiso(), permiso.getNombrePermiso()));
        }
    }

    public RolesPermiso getRolesPermiso() {
        return rolesPermiso;
    }

    public void setRolesPermiso(RolesPermiso rolesPermiso) {
        this.rolesPermiso = rolesPermiso;
    }

    public List<SelectItem> getRolList() {
        return rolList;
    }

    public void setRolList(List<SelectItem> rolList) {
        this.rolList = rolList;
    }

    public List<SelectItem> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<SelectItem> permisoList) {
        this.permisoList = permisoList;
    }

    public String getRolesSelect() {
        return rolesSelect;
    }

    public void setRolesSelect(String rolesSelect) {
        this.rolesSelect = rolesSelect;
    }

    public String getPermisosSelect() {
        return permisosSelect;
    }

    public void setPermisosSelect(String permisosSelect) {
        this.permisosSelect = permisosSelect;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public String guardarRolesPermiso(){
        String retorno = "";
        
        Rol rol = new Rol();
        rol = RolDelegate.consultarRol(Integer.parseInt(rolesSelect));
        rolesPermiso.setRol(rol);
        
        Permiso permiso = new Permiso();
        permiso = PermisoDelegate.consultarPermiso(Integer.parseInt(permisosSelect));
        rolesPermiso.setPermiso(permiso);
       
        RolesPermisoDelegate.guardarRolesPermiso(rolesPermiso);
        retorno = "maestroRolesPermiso";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se almacenó el Permiso asignado al Rol satisfactoriamente."));
        return retorno;
    }
    
    public String actualizarRolesPermiso(){
       Rol rol = new Rol();
       rol = RolDelegate.consultarRol(Integer.parseInt(rolesSelect));
       rolesPermiso.setRol(rol);
       
       Permiso permiso = new Permiso();
       permiso = PermisoDelegate.consultarPermiso(Integer.parseInt(permisosSelect));
       rolesPermiso.setPermiso(permiso);
       
       RolesPermisoDelegate.actualizarRolesPermiso(rolesPermiso);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizó el Permiso asignado al Rol satisfactoriamente."));
        return "maestroRolesPermiso";
    }
    
    public String eliminarRolesPermiso(){
        RolesPermisoDelegate.eliminarRolesPermiso(rolesPermiso.getIdRolesPermiso());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se eliminó el Permiso asignado al Rol satisfactoriamente."));
        return "maestroRolesPermiso";
    }    
    
}
