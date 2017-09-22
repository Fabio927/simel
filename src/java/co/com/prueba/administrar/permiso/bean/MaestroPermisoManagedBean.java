/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.permiso.bean;

import co.com.prueba.administrar.personas.delegate.PermisoDelegate;
import co.com.prueba.util.SessionUtil;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "maestroPermisoManagedBean")
@RequestScoped
@ManagedBean
public class MaestroPermisoManagedBean {

    public ArrayList getArregloPermiso() {
        return arregloPermiso;
    }

    public void setArregloPermiso(ArrayList arregloPermiso) {
        this.arregloPermiso = arregloPermiso;
    }
    
    private ArrayList arregloPermiso = new ArrayList();

    /**
     * Creates a new instance of MaestroPermisoManagedBean
     */
    public MaestroPermisoManagedBean() {
        arregloPermiso = PermisoDelegate.obtenerListadoPermiso();
    }
    
    public String irACrearPermiso(){
        SessionUtil.limpiar();
        return "crearPermiso";
    }
    
    public String irAEliminarPermiso(){
        return "eliminarPermiso";
    }
    
    public String irAEditarPermiso(){
        return "editarPermiso";        
    }
    
    public String irAConsultarPermiso(){
        return "consultarPermiso";
    }
    
}
