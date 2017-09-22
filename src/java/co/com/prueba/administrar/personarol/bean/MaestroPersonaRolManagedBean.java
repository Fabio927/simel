/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personarol.bean;

import co.com.prueba.administrar.personas.delegate.PersonaRolDelegate;
import co.com.prueba.util.SessionUtil;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "maestroPersonaRolManagedBean")
@RequestScoped
@ManagedBean
public class MaestroPersonaRolManagedBean {

    public ArrayList getArregloPersonaRol() {
        return arregloPersonaRol;
    }

    public void setArregloPersonaRol(ArrayList arregloPersonaRol) {
        this.arregloPersonaRol = arregloPersonaRol;
    }
    
    private ArrayList arregloPersonaRol = new ArrayList();

    /**
     * Creates a new instance of MaestroPersonaRolManagedBean
     */
    public MaestroPersonaRolManagedBean() {
        arregloPersonaRol = PersonaRolDelegate.obtenerListadoPersonaRol();
    }
    
    public String irACrearPersonaRol(){
        SessionUtil.limpiar();
        return "crearPersonaRol";
    }
    
    public String irAEliminarPersonaRol(){
        return "eliminarPersonaRol";
    }
    
    public String irAEditarPersonaRol(){
        return "editarPersonaRol";
    }
    
    public String irAConsultarPersonaRol(){
        return "consultarPersonaRol";
    }
    
}
