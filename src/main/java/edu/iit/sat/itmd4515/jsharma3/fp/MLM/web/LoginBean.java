/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.web;

import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import static jdk.nashorn.internal.codegen.Compiler.LOG;

/**
 *
 * @author Jay
 */
@Named
@RequestScoped 
public class LoginBean extends AbstractJSFBean {

    @NotNull(message = "You shall not pass without a username!")
    private String username;    
    @NotNull(message = "You shall not pass without a password!")
    @Size(min = 5, message = "Password must be at least 5 characters in length.")
    private String password;

    
    public LoginBean(){
        
    }
    
    @PostConstruct
    private void postConstruct(){
        super.postContruct();
    }
    
    public boolean isAdmin() {
        return facesContext.getExternalContext().isUserInRole("admin");
    }
    public boolean isCustomer() {
        return facesContext.getExternalContext().isUserInRole("customer");
    }
    public boolean isMember() {
        return facesContext.getExternalContext().isUserInRole("member");
    }   
    // Fun: http://www.code-thrill.com/2012/08/stringbuilder-optimizations-demystified.html
    public String getPortalPathByRole(String path) {
        if (isAdmin()) {
            return "/admin" + path;
        } else if (isMember()) {
            return "/memberPortal" + path;
        } else if (isCustomer()) {
            return "/customerPortal" + path;
        } else {
            return path;
        }
}   
    public String doLogin(){
    
    HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    
    try {
        req.login(username, password);
    } catch (ServletException ex) {
        LOG.log(Level.SEVERE, null, ex);
        facesContext.addMessage(null, new FacesMessage("Bad Login", "Detail: You made a bad login!"));
        return "/login.xhtml";
    }
         return getPortalPathByRole("/welcome.xhtml");
    }
    
    public String getRemoteUser(){
    
        return facesContext.getExternalContext().getRemoteUser();
    }
    
    public String doLogout(){
        
    HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    
    try {
        req.logout();
    }catch (ServletException ex) {
        LOG.log(Level.SEVERE, null, ex);
        facesContext.addMessage(null, new FacesMessage("Bad Logout", "Detail: There was a problem with the logout!"));
        return "/login.xhtml";
    }
       return "/login.xhtml";
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    

}
