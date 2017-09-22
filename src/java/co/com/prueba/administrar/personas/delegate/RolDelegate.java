/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personas.delegate;

import co.com.prueba.dao.RolDAO;
import co.com.prueba.dto.Rol;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class RolDelegate {
    
    public static ArrayList obtenerListadoRol(){
        RolDAO rolDao = new RolDAO();
        return rolDao.obtenerListadoRol();        
    }
    
    public static void guardarRol(Rol rol) {
        RolDAO rolDao = new RolDAO();
        rolDao.guardarRol(rol);
    }
    
    public static void actualizarRol(Rol rol){
        RolDAO rolDao = new RolDAO();
        rolDao.actualizarRol(rol);
    }
    
    public static Rol consultarRol(int id){
        RolDAO rolDao = new RolDAO();
        return rolDao.consultarRol(id);
    }
    
    public static void eliminarRol(int id){
        RolDAO rolDao = new RolDAO();
        rolDao.eliminarRol(id);
    }
    
}
