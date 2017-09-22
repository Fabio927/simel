/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personas.delegate;

import co.com.prueba.dao.PermisoDAO;
import co.com.prueba.dto.Permiso;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class PermisoDelegate {
    
    public static ArrayList obtenerListadoPermiso(){
        PermisoDAO permisoDao = new PermisoDAO();
        return permisoDao.obtenerListadoPermiso();
    }
    
    public static void guardarPermiso(Permiso permiso){
        PermisoDAO permisoDao = new PermisoDAO();
        permisoDao.guardarPermiso(permiso);
    }
    
    public static void actualizarPermiso(Permiso permiso){
        PermisoDAO permisoDao = new PermisoDAO();
        permisoDao.actualizarPermiso(permiso);
    }
    
    public static Permiso consultarPermiso(int id){
        PermisoDAO permisoDao = new PermisoDAO();
        return permisoDao.consultarPermiso(id);
    }
    
    public static void eliminarPermiso(int id){
        PermisoDAO permisoDao = new PermisoDAO();
        permisoDao.eliminarPermiso(id);
    }
    
}
