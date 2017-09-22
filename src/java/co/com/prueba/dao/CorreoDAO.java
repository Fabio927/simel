/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dao;

import co.com.prueba.administrar.correos.bean.CorreoManagedBean;
import co.com.prueba.administrar.personas.delegate.PersonaDelegate;
import co.com.prueba.autenticacion.bean.AutenticacionManagedBean;
import co.com.prueba.dto.Correo;
import co.com.prueba.dto.Persona;
import co.com.prueba.dto.PersonaRol;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fabio Fonseca
 */

public class CorreoDAO {
    
    private Persona persona;
    private String correo;
    
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    public ArrayList obtenerListadoCorreos(){
        Persona p = new Persona();
        p = PersonaDelegate.consultarPersona(correo);        
        ArrayList arregloCorreo = new ArrayList();        
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();                       
             ResultSet rs = stmt.executeQuery("select * from correo where idPersona = 10" );            
            // Ciclo para recorrer los resultados
            while (rs.next()) {              
               
                Correo correo = new Correo();                
                correo.setIdCorreo(rs.getInt("idCorreo"));
                correo.setAsunto(rs.getString("asunto"));
                correo.setPara(rs.getString("para"));
                correo.setMensaje(rs.getString("mensaje"));
                
                int idPersona = rs.getInt(5);
                Persona persona = new Persona();
                persona = PersonaDelegate.consultarPersona(idPersona);
                correo.setPersona(persona);                
                arregloCorreo.add(correo);                 
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arregloCorreo;
    }
    
    public void guardarCorreo(Correo correo){
        try {
            Connection conn = Conexion.getConnection();                     
            PreparedStatement ps = conn.prepareStatement("insert into correo (asunto, para, mensaje, idPersona) values (?,?,?,?)"); //PreparedStatemen se utiliza para pasar parámetros   
            ps.setString(1, correo.getAsunto());
            ps.setString(2, correo.getPara());
            ps.setString(3, correo.getMensaje());
            ps.setInt(4, correo.getPersona().getIdPersona());
                           
            ps.execute(); // ejecuta el query                        
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    public void actualizarCorreo(Correo correo) {
         try {
            Connection conn = Conexion.getConnection();            
            PreparedStatement ps = conn.prepareStatement("update correo set asunto= ?, para = ?, mensaje = ?, idPersona = ? where idCorreo = ?;");
            ps.setInt(5, correo.getIdCorreo());
            ps.setString(1, correo.getAsunto());
            ps.setString(2, correo.getPara());
            ps.setString(3, correo.getMensaje());
            ps.setInt(4, correo.getPersona().getIdPersona());
                 
            ps.execute(); // ejecuta el query            
            ps.close();
            conn.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
     public Correo consultarCorreo(int id) {
         Correo correo = new Correo();        
         try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from correo where idCorreo = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();                
                rs.next();
                correo.setIdCorreo(rs.getInt("idCorreo"));
                correo.setAsunto(rs.getString("asunto"));
                correo.setPara(rs.getString("para"));
                correo.setMensaje(rs.getString("mensaje"));
                
                Persona persona = new Persona();
                persona = PersonaDelegate.consultarPersona(rs.getInt("idPersona"));
                correo.setPersona(persona);
                
                ps.close();
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
         return correo;
    }
     
     public void eliminarCorreo(int id) {
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from correo where idCorreo = ?");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            conn.close();
            System.out.println(id);
        } catch (Exception ex){
            ex.printStackTrace();
        }
  }
     
     private String modificacion;
     private String prueba;

    public String getModificacion() {
        return modificacion;
    }

    public void setModificacion(String modificacion) {
        this.modificacion = modificacion;
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }
     
     
}
