/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personas.delegate;

import co.com.prueba.dao.CorreoDAO;
import co.com.prueba.dto.Correo;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class CorreoDelegate {
    
    public static ArrayList obtenerListadoCorreos(){
        CorreoDAO correoDao = new CorreoDAO();
        return correoDao.obtenerListadoCorreos();
    }
    
    public static void guardarCorreo(Correo correo){
        CorreoDAO correoDao = new CorreoDAO();
        correoDao.guardarCorreo(correo);
    }
    
     public static Correo consultarCorreo(int id){
        CorreoDAO correoDao = new CorreoDAO();
        return correoDao.consultarCorreo(id);
    }
     
     public static void actualizarCorreo(Correo correo){
        CorreoDAO correoDao = new CorreoDAO();
        correoDao.actualizarCorreo(correo);
    }
     
     public static void eliminarCorreo(int id){
        CorreoDAO correoDao = new CorreoDAO();
        correoDao.eliminarCorreo(id);
    }
    
}
