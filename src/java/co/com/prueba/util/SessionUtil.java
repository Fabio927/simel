/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.prueba.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Fabio Fonseca
 */
public class SessionUtil {
    
    public static void limpiar() {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    request.getSession().removeAttribute("personaManagedBean");
    request.getSession().removeAttribute("correoManagedBean");
    request.getSession().removeAttribute("rolManagedBean");
    request.getSession().removeAttribute("permisoManagedBean");
    request.getSession().removeAttribute("rolesPermisoManagedBean");
    request.getSession().removeAttribute("personaRolManagedBean");
    request.getSession().removeAttribute("correoRolManagedBean");
    
}
    
}

