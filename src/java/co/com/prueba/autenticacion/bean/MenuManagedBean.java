/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.autenticacion.bean;

import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "menuManagedBean")
@SessionScoped
@ManagedBean
    public class MenuManagedBean {

    private boolean mostrarCrear;
    private boolean mostrarCorreo;
    private boolean mostrarUsuarios;
    private boolean mostrarRoles;
    private boolean mostrarRolesUsuarios;
    private boolean mostrarPermisos;
    private boolean mostrarRolesPermisos;
    private boolean mostrarEnviarCorreo;
    private boolean mostrarEditar;
    private boolean mostrarGerente;
    private boolean mostrarEliminar;
    private boolean mostrarAdministrar;

    public boolean isMostrarAdministrar() {
        return mostrarAdministrar;
    }

    public void setMostrarAdministrar(boolean mostrarAdministrar) {
        this.mostrarAdministrar = mostrarAdministrar;
    }
    

    public boolean isMostrarEliminar() {
        return mostrarEliminar;
    }

    public void setMostrarEliminar(boolean mostrarEliminar) {
        this.mostrarEliminar = mostrarEliminar;
    }
    

    public boolean isMostrarGerente() {
        return mostrarGerente;
    }

    public void setMostrarGerente(boolean mostrarGerente) {
        this.mostrarGerente = mostrarGerente;
    }
    

    public boolean isMostrarEditar() {
        return mostrarEditar;
    }

    public void setMostrarEditar(boolean mostrarEditar) {
        this.mostrarEditar = mostrarEditar;
    }
    
    

    public boolean isMostrarEnviarCorreo() {
        return mostrarEnviarCorreo;
    }

    public void setMostrarEnviarCorreo(boolean mostrarEnviarCorreo) {
        this.mostrarEnviarCorreo = mostrarEnviarCorreo;
    }
    

    public boolean isMostrarRoles() {
        return mostrarRoles;
    }

    public void setMostrarRoles(boolean mostrarRoles) {
        this.mostrarRoles = mostrarRoles;
    }

    public boolean isMostrarRolesUsuarios() {
        return mostrarRolesUsuarios;
    }

    public void setMostrarRolesUsuarios(boolean mostrarRolesUsuarios) {
        this.mostrarRolesUsuarios = mostrarRolesUsuarios;
    }

    public boolean isMostrarPermisos() {
        return mostrarPermisos;
    }

    public void setMostrarPermisos(boolean mostrarPermisos) {
        this.mostrarPermisos = mostrarPermisos;
    }

    public boolean isMostrarRolesPermisos() {
        return mostrarRolesPermisos;
    }

    public void setMostrarRolesPermisos(boolean mostrarRolesPermisos) {
        this.mostrarRolesPermisos = mostrarRolesPermisos;
    }
    

    public boolean isMostrarCorreo() {
        return mostrarCorreo;
    }

    public void setMostrarCorreo(boolean mostrarCorreo) {
        this.mostrarCorreo = mostrarCorreo;
    }

    
    
    public boolean isMostrarUsuarios() {
        return mostrarUsuarios;
    }

    public void setMostrarUsuarios(boolean mostrarUsuarios) {
        this.mostrarUsuarios = mostrarUsuarios;
    }
   
    
    public boolean isMostrarCrear() {
        return mostrarCrear;
    }

    public void setMostrarCrear(boolean mostrarCrear) {
        this.mostrarCrear = mostrarCrear;
    }

   

}

    

