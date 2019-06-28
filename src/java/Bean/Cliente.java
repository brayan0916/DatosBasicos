/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Model.Registro;
import dao.ClienteDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author pc
 */
@Named(value = "cliente")
@SessionScoped
public class Cliente implements Serializable {

    /**
     * Creates a new instance of Cliente
     */
    
     private Integer id;
     private String nombre;
     private String telefono;
     
     private Registro r;
    public Cliente() {
        r = new Registro();
    }
    
      public void allCliente() {
        Registro cliente = new Registro(getNombre(), getTelefono());
        ClienteDao clienteDaO = new ClienteDao();
        clienteDaO.addCliente(cliente);
       

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Registro getR() {
        return r;
    }

    public void setR(Registro r) {
        this.r = r;
    }
      
      
}
