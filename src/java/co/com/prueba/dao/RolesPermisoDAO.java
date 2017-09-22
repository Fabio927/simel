/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dao;

import co.com.prueba.administrar.personas.delegate.PermisoDelegate;
import co.com.prueba.administrar.personas.delegate.RolDelegate;
import co.com.prueba.dto.Permiso;
import co.com.prueba.dto.Rol;
import co.com.prueba.dto.RolesPermiso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fabio Fonseca
 */
public class RolesPermisoDAO {
    
    public ArrayList obtenerListadoRolesPermiso(){
        
        ArrayList arregloRP = new ArrayList();        
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rolespermiso");
            // Ciclo para recorrer los resultados
            while (rs.next()) {                
                RolesPermiso rolesPermiso = new RolesPermiso();
                rolesPermiso.setIdRolesPermiso(rs.getInt("idRolesPermiso"));
                
                int idRol = rs.getInt(2);
                Rol rol = new Rol();
                rol = RolDelegate.consultarRol(idRol);
                rolesPermiso.setRol(rol);
                
                int idPermiso = rs.getInt(3);
                Permiso permiso = new Permiso();
                permiso = PermisoDelegate.consultarPermiso(idPermiso);
                rolesPermiso.setPermiso(permiso);
                                
                arregloRP.add(rolesPermiso);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arregloRP;
    }
    
    public ArrayList <Permiso> consultarPermisoRol(int idRol){
        ArrayList arregloPermiso = new ArrayList();
         try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("select * from  rolespermiso where idrol= ?;");
            ps.setInt(1, idRol);             
             ResultSet rs = ps.executeQuery();
            // Ciclo para recorrer los resultados
            while (rs.next()) {                           
                
                int idPermiso = rs.getInt(3);
                Permiso permiso = new Permiso();
                permiso = PermisoDelegate.consultarPermiso(idPermiso);
                arregloPermiso.add(permiso);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arregloPermiso;
    }
    
    public void guardarRolesPermiso(RolesPermiso rolesPermiso){
        try {
            Connection conn = Conexion.getConnection();                     
            PreparedStatement ps = conn.prepareStatement("insert into rolespermiso (idRol, idPermiso) values (?,?)"); //PreparedStatemen se utiliza para pasar parámetros   
            ps.setInt(1, rolesPermiso.getRol().getIdRol());
            ps.setInt(2, rolesPermiso.getPermiso().getIdPermiso());
                
            ps.execute(); // ejecuta el query                        
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    public void actualizarRolesPermiso(RolesPermiso rolesPermiso) {
         try {
            Connection conn = Conexion.getConnection();            
            PreparedStatement ps = conn.prepareStatement("update rolespermiso set idRol= ?, idPermiso = ? where idRolesPermiso = ?;");
            ps.setInt(3, rolesPermiso.getIdRolesPermiso());
            ps.setInt(1, rolesPermiso.getRol().getIdRol());
            ps.setInt(2, rolesPermiso.getPermiso().getIdPermiso());
                 
            ps.execute(); // ejecuta el query            
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
     public RolesPermiso consultarRolesPermiso(int id) {
        RolesPermiso rolesPermiso = new RolesPermiso();
         try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from rolespermiso where idRolesPermiso = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();                
                rs.next();
                rolesPermiso.setIdRolesPermiso(rs.getInt("idRolesPermiso"));
                
                Rol rol = new Rol();
                rol = RolDelegate.consultarRol(rs.getInt("idRol"));
                rolesPermiso.setRol(rol);
                
                Permiso permiso = new Permiso();
                permiso = PermisoDelegate.consultarPermiso(rs.getInt("idPermiso"));
                rolesPermiso.setPermiso(permiso);
                
                ps.close();
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
         return rolesPermiso;
    }
     
     public void eliminarRolesPermiso(int id) {
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from rolespermiso where idRolesPermiso = ?");
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
