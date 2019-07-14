/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ClasesAuxiliares.EncriptarPass;
import Model.Login;
import Util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pc
 */
public class UsuarioDao {
    
    public Login obtenerdatosporusuario(Login Usuario){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String hql="FROM login WHERE username=username";
        Query q = session.createQuery(hql);
        q.setParameter("username", Usuario.getUsername());
        
          
        
        return (Login) q.uniqueResult();
        
    }
    public Login logeando(Login usuario){
        
        Login user=this.obtenerdatosporusuario(usuario);
        
        if(user!=null){
            if(!user.getPass().equals(EncriptarPass.sha512(usuario.getPass()))){
                user=null;
            }
        }
        return user;
        
    }
    
}
