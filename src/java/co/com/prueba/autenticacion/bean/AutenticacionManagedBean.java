/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.autenticacion.bean;

import co.com.prueba.administrar.personas.delegate.PersonaDelegate;
import co.com.prueba.administrar.personas.delegate.PersonaRolDelegate;
import co.com.prueba.administrar.personas.delegate.RolesPermisoDelegate;
import co.com.prueba.dao.PersonaDAO;
import co.com.prueba.dto.Permiso;
import co.com.prueba.dto.Persona;
import co.com.prueba.dto.Rol;
import co.com.prueba.dto.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fabio Fonseca
 */
@Named(value = "autenticacionManagedBean")
@ManagedBean
@SessionScoped
public class AutenticacionManagedBean {
    
    private String correo;
    private String clave;
    private String error;      
    private int id;    
    public int a;

    /**
     * Creates a new instance of AutenticacionManagedBean
     */
    public AutenticacionManagedBean() {
        
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
    public String autenticar(){
        String retorno = "login";
        try {
        Persona persona = new Persona();
        persona = PersonaDelegate.consultarPersona(correo);      
        a = persona.getIdPersona();
            System.out.println("valor de a " + a);
            System.out.println(persona.getIdPersona());
            System.out.println(persona.getCorreo());
            System.out.println(persona.getNombre());
            System.out.println(persona.getApellido());
            System.out.println(persona.getClave());
        
        if (persona.getCorreo() == null) {
            error = "Nombre de usuario y/o clave invalidos";
        } else if (persona.getClave().equals(clave)) {
            
            ArrayList<Permiso> arregloPermisos = new <Permiso> ArrayList();
                ArrayList<Rol> arregloRol = PersonaRolDelegate.consultarRolesPersona(persona.getIdPersona());
                for (Iterator<Rol> iterator = arregloRol.iterator(); iterator.hasNext();) {
                    Rol rol = (Rol)iterator.next();
                    ArrayList arreglo = RolesPermisoDelegate.consultarPermisosRol(rol.getIdRol());
                    System.out.println("Rol: " + rol.getIdRol() + " " + rol.getNombreRol());
                    for (Iterator iterator1 = arreglo.iterator(); iterator1.hasNext();) {
                        Permiso permiso = (Permiso)iterator1.next();
                        System.out.println("Permisos: " + permiso.getIdPermiso() + " " + permiso.getNombrePermiso());
                        if(!validarExistenciaPermiso(arregloPermisos, permiso))
                            arregloPermisos.add(permiso);
                    }
                }
                establecerMostrar(arregloPermisos);
            
            retorno = "principal";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + persona.getCargo() + " " + persona.getNombre() + " " + persona.getApellido()));
        } else {
            error = "Nombre de usuario y/o clave invalidos";
        } 
        }catch (Exception e){
                error ="Error en el servidor de aplicaciones";
                }       
        return retorno;
    }
    
    private void establecerMostrar(ArrayList arreglo){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
        MenuManagedBean menu = new MenuManagedBean();
        for (Iterator iterator = arreglo.iterator(); iterator.hasNext();) {
            Permiso permiso = (Permiso)iterator.next();
            
            if(permiso.getIdPermiso()==1) //Crear
               // menu.setMostrarUsuariosGeneral(true);
               menu.setMostrarCrear(true);
            if (permiso.getIdPermiso()==2) //Mostrar Correo
                menu.setMostrarCorreo(true);
            if (permiso.getIdPermiso()==3) //Mostrar Usuarios
                menu.setMostrarUsuarios(true);
            if(permiso.getIdPermiso()==4)//Mostrar Roles
                menu.setMostrarRoles(true);
            if(permiso.getIdPermiso()==5)//Mostrar RolesUsuario
                menu.setMostrarRolesUsuarios(true);
            if(permiso.getIdPermiso()==6)//MostrarPermisos
                menu.setMostrarPermisos(true);
            if(permiso.getIdPermiso()==7)//MostrarRolesPermisos
                menu.setMostrarRolesPermisos(true);
            if(permiso.getIdPermiso()==8) // Mostrar Envio a correo
                menu.setMostrarEnviarCorreo(true);
            if(permiso.getIdPermiso()==9)//Mostrar Gerente
                menu.setMostrarGerente(true);
            if(permiso.getIdPermiso()==10)//Mostrar Eliminar
                menu.setMostrarEliminar(true);
            if(permiso.getIdPermiso()==11)//MostrarAdministrar
                menu.setMostrarAdministrar(true);    
            imprimeA();
        }
        request.getSession().setAttribute("menuManagedBean", menu);
    }
    
    private boolean validarExistenciaPermiso(ArrayList arreglo, Permiso permiso){
        boolean retorno = false;
        for (Iterator iterator = arreglo.iterator(); iterator.hasNext();) {
            Permiso per = (Permiso)iterator.next();
            if(per.getIdPermiso()==permiso.getIdPermiso())
                retorno=true;
        }        
        return retorno;
    }
    
    public void imprimeA(){
        Persona pe = new Persona();
        pe = PersonaDelegate.consultarPersona(correo);
        System.out.println("valor de AAAAAA " + pe.getIdPersona());        
    }
    
        public String logout() throws IOException{
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("userLogged", "false");
        session.invalidate();
        return "/login";
    }
        
        public static Persona consultarPersona(String correo){
         PersonaDAO personaDao = new PersonaDAO();
         return personaDao.consultarPersona(correo);
    }
}

