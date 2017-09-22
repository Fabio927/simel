/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.rol.bean;

import co.com.prueba.administrar.personas.delegate.RolDelegate;
import co.com.prueba.util.SessionUtil;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "maestroRolManagedBean")
@RequestScoped
@ManagedBean
public class MaestroRolManagedBean {

    public ArrayList getArregloRol() {
        return arregloRol;
    }

    public void setArregloRol(ArrayList arregloRol) {
        this.arregloRol = arregloRol;
    }
    
    
    
    private ArrayList arregloRol = new ArrayList();

    /**
     * Creates a new instance of MaestroRolManagedBean
     */
    public MaestroRolManagedBean() {
        arregloRol = RolDelegate.obtenerListadoRol();
    }
    
    public String irACrearRol() {
        SessionUtil.limpiar();
        return "crearRol";
    }
    
    public String irAEliminarRol() {
        return "eliminarRol";
    }
    
    public String irAEditarRol() {
        return "editarRol";
    }
    
    public String irAConsultarRol() {
        return "consultarRol";
    }
    
}
