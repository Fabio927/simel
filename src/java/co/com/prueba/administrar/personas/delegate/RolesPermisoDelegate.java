/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personas.delegate;

import co.com.prueba.dao.RolesPermisoDAO;
import co.com.prueba.dto.Permiso;
import co.com.prueba.dto.RolesPermiso;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class RolesPermisoDelegate {
    
    public static ArrayList obtenerListadoRolesPermiso(){
        RolesPermisoDAO rolesPermisoDao = new RolesPermisoDAO();
        return rolesPermisoDao.obtenerListadoRolesPermiso();
    }
    
    public static void guardarRolesPermiso(RolesPermiso rolesPermiso){
        RolesPermisoDAO rolesPermisoDao = new RolesPermisoDAO();
        rolesPermisoDao.guardarRolesPermiso(rolesPermiso);
    }
    
    public static void actualizarRolesPermiso(RolesPermiso rolesPermiso){
        RolesPermisoDAO rolesPermisoDao = new RolesPermisoDAO();
        rolesPermisoDao.actualizarRolesPermiso(rolesPermiso);
    }
    
    public static RolesPermiso consultarRolesPermiso(int id){
        RolesPermisoDAO rolesPermisoDao = new RolesPermisoDAO();
        return rolesPermisoDao.consultarRolesPermiso(id);
    }
    
    public static void eliminarRolesPermiso(int id){
        RolesPermisoDAO rolesPermisoDao = new RolesPermisoDAO();
        rolesPermisoDao.eliminarRolesPermiso(id);
    }
    
    //Para consultar el permiso que tiene un rol
    public static ArrayList<Permiso> consultarPermisosRol(int idRol){
        RolesPermisoDAO rolPermisos = new RolesPermisoDAO();
        return rolPermisos.consultarPermisoRol(idRol);
    }
}
