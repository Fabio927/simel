/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dao;

import co.com.prueba.administrar.personas.delegate.PersonaDelegate;
import co.com.prueba.administrar.personas.delegate.RolDelegate;
import co.com.prueba.dto.Persona;
import co.com.prueba.dto.PersonaRol;
import co.com.prueba.dto.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class PersonaRolDAO {
    
    public ArrayList obtenerListadoPersonaRol(){
        
        ArrayList arregloRolPersona = new ArrayList();        
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select  *  from personarol");
            // Ciclo para recorrer los resultados
            while (rs.next()) {                
                PersonaRol personaRol = new PersonaRol();
                personaRol.setIdPersonaRol(rs.getInt("idPersonaRol"));
                                
                int idRol = rs.getInt(2);
                Rol rol = new Rol();
                rol = RolDelegate.consultarRol(idRol);
                personaRol.setRol(rol);
                
                int idPersona = rs.getInt(3);
                Persona persona = new Persona();
                persona = PersonaDelegate.consultarPersona(idPersona);
                personaRol.setPersona(persona);
                                
                arregloRolPersona.add(personaRol);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arregloRolPersona;
    }
    
     public ArrayList <Rol> consultarRolesPersona(int idPersona){
        ArrayList arregloRol = new ArrayList();
         try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("select * from  personarol where idPersona = ?;");
             ps.setInt(1, idPersona);                          
             ResultSet rs = ps.executeQuery();
            
            // Ciclo para recorrer los resultados
            while (rs.next()) {                                
                int idRol = rs.getInt(2);
                Rol rol = new Rol();
                rol = RolDelegate.consultarRol(idRol);
               arregloRol.add(rol);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arregloRol;
    }
     
     public void guardarPersonaRol(PersonaRol personaRol){
        try {
            Connection conn = Conexion.getConnection();                     
            PreparedStatement ps = conn.prepareStatement("insert into personarol (idRol, idPersona) values (?,?)"); //PreparedStatemen se utiliza para pasar parámetros   
            ps.setInt(1, personaRol.getRol().getIdRol());
            ps.setInt(2, personaRol.getPersona().getIdPersona());
                
            ps.execute(); // ejecuta el query                        
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
     
     public void actualizarPersonaRol(PersonaRol personaRol) {
         try {
            Connection conn = Conexion.getConnection();            
            PreparedStatement ps = conn.prepareStatement("update personarol set idRol= ?, idPersona = ? where idPersonaRol = ?;");
            ps.setInt(3, personaRol.getIdPersonaRol());
            ps.setInt(1, personaRol.getRol().getIdRol());
            ps.setInt(2, personaRol.getPersona().getIdPersona());
                 
            ps.execute(); // ejecuta el query            
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
     
      public PersonaRol consultarPersonaRol(int id) {
        PersonaRol personaRol = new PersonaRol();
         try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from personarol where idPersonaRol = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();                
                rs.next();
                personaRol.setIdPersonaRol(rs.getInt("idPersonaRol"));
                
                Rol rol = new Rol();
                rol = RolDelegate.consultarRol(rs.getInt("idRol"));
                personaRol.setRol(rol);
                
                Persona persona = new Persona();
                persona = PersonaDelegate.consultarPersona(rs.getInt("idPersona"));
                personaRol.setPersona(persona);
                
                ps.close();
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
         return personaRol;
    }
      
      public void eliminarPersonaRol(int id) {
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from personarol where idPersonaRol = ?");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            conn.close();
            System.out.println(id);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
      
      public String devolver(){
          System.out.println("Devolver");
          return "valor";
      }
    
}
