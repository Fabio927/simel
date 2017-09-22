/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.rolespermiso.bean;

import co.com.prueba.administrar.personas.delegate.RolesPermisoDelegate;
import co.com.prueba.util.SessionUtil;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "maestroRolesPermisoManagedBean")
@RequestScoped
@ManagedBean
public class MaestroRolesPermisoManagedBean {

    public ArrayList getArregloRP() {
        return arregloRP;
    }

    public void setArregloRP(ArrayList arregloRP) {
        this.arregloRP = arregloRP;
    }
            
    private ArrayList arregloRP = new ArrayList();

    /**
     * Creates a new instance of MaestroRolesPermisoManagedBean
     */
    public MaestroRolesPermisoManagedBean() {
        arregloRP = RolesPermisoDelegate.obtenerListadoRolesPermiso();
    }
    
    public String irACrearRolesPermiso(){
        SessionUtil.limpiar();
        return "crearRolesPermiso";
    }
    
    public String irAEliminarRolesPermiso(){
        return "eliminarRolesPermiso";
    }
    
    public String irAEditarRolesPermiso(){
        return "editarRolesPermiso";
    }
    
    public String irAConsultarRolesPermiso(){
        return "consultarRolesPermiso";
    }
    
}
