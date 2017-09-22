/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dao;

import co.com.prueba.dto.Permiso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class PermisoDAO {
    
    public ArrayList obtenerListadoPermiso() {
        ArrayList arregloPermiso = new ArrayList();        
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select  *  from permiso");
            // Ciclo para recorrer los resultados
            while (rs.next()) {
                Permiso permiso = new Permiso();
                permiso.setIdPermiso(rs.getInt("idPermiso"));
                permiso.setNombrePermiso(rs.getString("nombrePermiso"));                
                permiso.setDescripcionPermiso(rs.getString("descripcionPermiso"));                
                arregloPermiso.add(permiso);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arregloPermiso;
    }
    
    public void guardarPermiso(Permiso permiso) {
        try {
            Connection conn = Conexion.getConnection();            
            PreparedStatement ps = conn.prepareStatement("insert into permiso (nombrePermiso, descripcionPermiso) values (?,?)"); //PreparedStatemen se utiliza para pasar parámetros   
            ps.setString(1, permiso.getNombrePermiso());
            ps.setString(2, permiso.getDescripcionPermiso());            
            ps.execute(); // ejecuta el query            
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    public void actualizarPermiso(Permiso permiso) {
         try {
            Connection conn = Conexion.getConnection();            
            PreparedStatement ps = conn.prepareStatement("update permiso set nombrePermiso = ?, descripcionPermiso = ? where idPermiso = ?;");
            ps.setInt(3, permiso.getIdPermiso());
            ps.setString(1, permiso.getNombrePermiso());
            ps.setString(2, permiso.getDescripcionPermiso());
            ps.execute(); // ejecuta el query            
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    public Permiso consultarPermiso(int id) {
        Permiso permiso = new Permiso();
         try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from permiso where idPermiso = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();                
                rs.next();
                permiso.setIdPermiso(rs.getInt("idPermiso"));
                permiso.setNombrePermiso(rs.getString("nombrePermiso"));
                permiso.setDescripcionPermiso(rs.getString("descripcionPermiso"));
                ps.close();
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
         return permiso;
    }
    
    public void eliminarPermiso(int id) {
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from permiso where idPermiso = ?");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            conn.close();            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    private int idRol;
    private String hola;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getHola() {
        return hola;
    }

    public void setHola(String hola) {
        this.hola = hola;
    }
    
    public String nuevoCampo;
    
    public int nuevoValor;
    
    
}
