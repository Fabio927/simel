/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dao;

import co.com.prueba.dto.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class PersonaDAO {
    
     public ArrayList obtenerListadoPersonas(){
        
        ArrayList arregloPersona = new ArrayList();        
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select  *  from persona");
            // Ciclo para recorrer los resultados
            while (rs.next()) {                
                Persona persona = new Persona();
                
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setCargo(rs.getString("cargo"));
                persona.setCorreo(rs.getString("correo"));
                persona.setClave(rs.getString("clave"));                
                
                arregloPersona.add(persona);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arregloPersona;
    }
    
    public void guardarPersona(Persona persona){
        try {
            Connection conn = Conexion.getConnection();                     
            PreparedStatement ps = conn.prepareStatement("insert into persona (nombre, apellido, cargo, correo, clave) values (?,?,?,?,?)"); //PreparedStatemen se utiliza para pasar parámetros   
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getCargo());
            ps.setString(4, persona.getCorreo());
            ps.setString(5, persona.getClave());
            
            ps.execute(); // ejecuta el query                        
            ps.close(); //cierra la instrucción
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
     public void actualizarPersona(Persona persona) {
         try {
            Connection conn = Conexion.getConnection();            
            PreparedStatement ps = conn.prepareStatement("update persona set nombre = ?, apellido = ?, cargo = ?, correo = ?, clave = ? where idPersona = ?;");
            ps.setInt(6, persona.getIdPersona());
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getCargo());
            ps.setString(4, persona.getCorreo());
            ps.setString(5, persona.getClave());
                  
            ps.execute(); // ejecuta el query            
            ps.close(); // cierra la instrucción
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    public Persona consultarPersona(int id) {
        Persona persona = new Persona();
         try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from persona where idPersona = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();                
                rs.next();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setCargo(rs.getString("cargo"));
                persona.setCorreo(rs.getString("correo"));
                persona.setClave(rs.getString("clave"));              
                
                ps.close();
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
         return persona;
    }
    
   public void eliminarPersona(int id) {
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from persona where idPersona = ?");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            conn.close();
            System.out.println(id);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
   
      
   
   
   
   
   
   
   
   public Persona consultarPersona(String correo) {
        Persona persona = new Persona();
         try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from persona where correo = ?");
            ps.setString(1, correo);
            //System.out.println(correo);
            ResultSet rs = ps.executeQuery();         
            
                rs.next();
                
                if (rs.first()) {
                  persona.setIdPersona(rs.getInt("idPersona"));
                  persona.setNombre(rs.getString("nombre"));
                  persona.setApellido(rs.getString("apellido"));
                  persona.setCargo(rs.getString("cargo"));                  
                  persona.setCorreo(rs.getString("correo"));                  
                  persona.setClave(rs.getString("clave"));
             }                
                ps.close();
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
         return persona;
    }
   
   public void almacenar(){
       System.out.println("almacenado");
   }
}
