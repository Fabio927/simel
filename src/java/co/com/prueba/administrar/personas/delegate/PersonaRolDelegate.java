/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.administrar.personas.delegate;

import co.com.prueba.dao.PersonaRolDAO;
import co.com.prueba.dto.PersonaRol;
import co.com.prueba.dto.Rol;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class PersonaRolDelegate {
    
    public static ArrayList obtenerListadoPersonaRol(){
        PersonaRolDAO personaRolDao = new PersonaRolDAO();
        return personaRolDao.obtenerListadoPersonaRol();
    }
    
    public static void guardarPersonaRol(PersonaRol personaRol){
        PersonaRolDAO personaRolDao = new PersonaRolDAO();
        personaRolDao.guardarPersonaRol(personaRol);
    }
    
    public static void actualizarPersonaRol(PersonaRol personaRol){
        PersonaRolDAO personaRolDao = new PersonaRolDAO();
        personaRolDao.actualizarPersonaRol(personaRol);
    }
    
    public static PersonaRol consultarPersonaRol(int id){
        PersonaRolDAO personaRolDao = new PersonaRolDAO();
        return personaRolDao.consultarPersonaRol(id);
    }
    
    public static void eliminarPersonaRol(int id){
        PersonaRolDAO personaRolDao = new PersonaRolDAO();
        personaRolDao.eliminarPersonaRol(id);
    }
    
    //Para consultar el rol que le corresponde a la persona
    public static ArrayList<Rol> consultarRolesPersona(int idPersona){
        PersonaRolDAO personaRol = new PersonaRolDAO();
        return personaRol.consultarRolesPersona(idPersona);
    }
    
    
    
}
