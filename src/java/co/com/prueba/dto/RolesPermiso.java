/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dto;

/**
 *
 * @author Fabio Fonseca
 */
public class RolesPermiso {
    
    private int idRolesPermiso;
    private Rol rol;
    private Permiso permiso;

    public int getIdRolesPermiso() {
        return idRolesPermiso;
    }

    public void setIdRolesPermiso(int idRolesPermiso) {
        this.idRolesPermiso = idRolesPermiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    
    
    
}
