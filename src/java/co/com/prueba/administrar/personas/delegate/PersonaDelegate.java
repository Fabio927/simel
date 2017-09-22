/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personas.delegate;

import co.com.prueba.dao.PersonaDAO;
import co.com.prueba.dto.Persona;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class PersonaDelegate {
    
     public static ArrayList obtenerListadoPersonas(){
        PersonaDAO personaDao = new PersonaDAO();
        return personaDao.obtenerListadoPersonas();
    }
     
     public static void guardarPersona(Persona persona){
        PersonaDAO personaDao = new PersonaDAO();
        personaDao.guardarPersona(persona);
    }
     
     public static void actualizarPersona(Persona persona){
        PersonaDAO personaDao = new PersonaDAO();
        personaDao.actualizarPersona(persona);
    }
     
     public static Persona consultarPersona(int id){
        PersonaDAO personaDao = new PersonaDAO();
        return personaDao.consultarPersona(id);
    }
     
     public static void eliminarPersona(int id){
        PersonaDAO personaDao = new PersonaDAO();
        personaDao.eliminarPersona(id);
    }
     
      public static Persona consultarPersona(String correo){
         PersonaDAO personaDao = new PersonaDAO();
         return personaDao.consultarPersona(correo);
    }
    
}
