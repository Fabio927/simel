/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.correos.bean;

import co.com.prueba.administrar.personas.delegate.CorreoDelegate;
import co.com.prueba.dto.Correo;
import co.com.prueba.util.SessionUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "maestroCorreoManagedBean")
@RequestScoped
@ManagedBean
public class MaestroCorreoManagedBean {
    
public ArrayList getArregloCorreos() {
        return arregloCorreos;
    }

    public void setArregloUsuarios(ArrayList arregloCorreos) {
        this.arregloCorreos = arregloCorreos;
    }

    public List<Correo> getDatosFiltrados() {
        return datosFiltrados;
    }

    public void setDatosFiltrados(List<Correo> datosFiltrados) {
        this.datosFiltrados = datosFiltrados;
    }
    
    private ArrayList arregloCorreos = new ArrayList();
    private List<Correo> datosFiltrados; //Creada para actualizar el listado de la tabla Usuario después de utilizar filtros multicriterio
    
    public MaestroCorreoManagedBean() {
        arregloCorreos = CorreoDelegate.obtenerListadoCorreos();
    }
    
    public String irACrearCorreo(){
        SessionUtil.limpiar();
        return "crearCorreo";
    }
    
    public String irAEliminarCorreo(){
        return "eliminarCorreo";
    }
    
    public String irAEditarCorreo(){
        return "editarCorreo";
    }
    
    public String irAConsultarCorreo(){
        return "consultarCorreo";
    }
    
}
