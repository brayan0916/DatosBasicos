/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Registro;
import Util.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pc
 */
public class ClienteDao {
    
     public void addCliente(Registro cliente) {  
 
     Transaction tx = null;
     Session session = NewHibernateUtil.getSessionFactory().openSession();
     try {  
 tx = session.beginTransaction();
 session.save(cliente);
 session.getTransaction().commit();
 
 }catch(Exception e){ 
     e.printStackTrace();
     if(tx !=null){  
     tx.rollback();
     }
 }finally{  
         session.flush();
         session.close();
     }
 }
    
}
