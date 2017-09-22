/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.dto;

/**
 *
 * @author Fabio Fonseca
 */
public class PersonaRol {
    
    private int idPersonaRol;
    private Rol rol;
    private Persona persona;

    public int getIdPersonaRol() {
        return idPersonaRol;
    }

    public void setIdPersonaRol(int idPersonaRol) {
        this.idPersonaRol = idPersonaRol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
}
