/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dao;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 *
 * @author Fabio Fonseca
 */
public class Conexion {
    private static Connection conn = null;
    private static Conexion INSTANCIA = null;

    private Conexion() {
    }

    private static Conexion getInstance() throws Exception {
        String nombre = "jdbc/__default";
        try {
            if (INSTANCIA == null) {
                INSTANCIA = new Conexion();
                InitialContext context = new InitialContext();
                DataSource ds = (DataSource)context.lookup(nombre);
                conn = ds.getConnection();
            } else if (conn == null) {
                InitialContext context = new InitialContext();
                DataSource ds = (DataSource)context.lookup(nombre);
                conn = ds.getConnection();
            } else if (conn.isClosed()) {
                InitialContext context = new InitialContext();
                DataSource ds = (DataSource)context.lookup(nombre);
                conn = ds.getConnection();
            }
        } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("Problemas con la conexión");
        }
        return INSTANCIA;
    }


    /**
     * Establece conexión con la base de datos
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Conexion conexion = Conexion.getInstance();
        return conexion.conn;
    }
}