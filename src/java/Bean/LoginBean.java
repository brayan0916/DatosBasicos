/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Model.Login;
import dao.UsuarioDao;
import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

/**
 *
 * @author pc
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String NombredeUsuario;
    private String password;
    private Login Usuario; 

    public LoginBean() {
        this.Usuario= new Login();
    }

    public Login getUsuario() {
        return Usuario;
    }

    public void setUsuario(Login Usuario) {
        this.Usuario = Usuario;
    }
    
    

    public String getNombredeUsuario() {
        return NombredeUsuario;
    }

    public void setNombredeUsuario(String NombredeUsuario) {
        this.NombredeUsuario = NombredeUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta="";
        
        UsuarioDao uDao = new UsuarioDao();
        this.Usuario =uDao.logeando(this.Usuario);

        if (this.Usuario != null ) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.Usuario.getUsername());
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.Usuario.getUsername());
            ruta="DatosBasicos/index.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            this.Usuario= new Login();
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        //PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        //PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
          context.addCallbackParam("loggedIn", loggedIn);
           context.addCallbackParam("ruta", ruta);
    }
}


