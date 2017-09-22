/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dao;

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
public class RolDAO {
    
    public ArrayList obtenerListadoRol(){
        ArrayList arregloRol = new ArrayList();        
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select  *  from rol");
            // Ciclo para recorrer los resultados
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));          
                rol.setDescripcionRol(rs.getString("descripcionRol"));
                arregloRol.add(rol);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arregloRol;
    }
    
    public void guardarRol(Rol rol){
        try {
            Connection conn = Conexion.getConnection();            
            PreparedStatement ps = conn.prepareStatement("insert into rol (nombreRol, descripcionRol) values (?,?)"); //PreparedStatemen se utiliza para pasar parámetros   
            ps.setString(1, rol.getNombreRol());
            ps.setString(2, rol.getDescripcionRol());
            ps.execute(); // ejecuta el query            
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    public void actualizarRol(Rol rol){
        try {
            Connection conn = Conexion.getConnection();            
            PreparedStatement ps = conn.prepareStatement("update rol set nombreRol = ?, descripcionRol = ? where idRol = ?;");            
            ps.setString(1, rol.getNombreRol());
            ps.setString(2, rol.getDescripcionRol());
            ps.setInt(3, rol.getIdRol());
            ps.execute(); // ejecuta el query            
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    public Rol consultarRol(int id){
        Rol rol = new Rol();
         try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from rol where idRol = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();                
                rs.next();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));
                rol.setDescripcionRol(rs.getString("descripcionRol"));
                ps.close();
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
         return rol;
    }
    
    public void eliminarRol(int id){
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from rol where idRol = ?");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            conn.close();
            System.out.println(id);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
}
