/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personas.bean;

import co.com.prueba.administrar.personas.delegate.PersonaDelegate;
import co.com.prueba.dto.Persona;
import co.com.prueba.util.SessionUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "maestroPersonaManagedBean")
@RequestScoped
@ManagedBean
public class MaestroPersonaManagedBean {

    public ArrayList getArregloPersona() {
        return arregloPersona;
    }

    public void setArregloPersona(ArrayList arregloPersona) {
        this.arregloPersona = arregloPersona;
    }

    public List<Persona> getDatosFiltrados() {
        return datosFiltrados;
    }

    public void setDatosFiltrados(List<Persona> datosFiltrados) {
        this.datosFiltrados = datosFiltrados;
    }
    
        
    private ArrayList arregloPersona = new ArrayList();
     private List<Persona> datosFiltrados; //Creada para actualizar el listado de la tabla Usuario después de utilizar filtros multicriterio

    /**
     * Creates a new instance of MaestroPersonaManagedBean
     */
    public MaestroPersonaManagedBean() {
        arregloPersona = PersonaDelegate.obtenerListadoPersonas();
    }
    
    public String irACrearPersona(){
        SessionUtil.limpiar();
        return "crearPersona";
    }
    
    public String irAEliminarPersona(){
        return "eliminarPersona";
    }
    
    public String irAEditarPersona(){
        return "editarPersona";
    }
    
    public String irAConsultarPersona(){
        return "consultarPersona";
    }
    
}
