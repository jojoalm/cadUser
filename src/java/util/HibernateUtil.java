/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SONY
 */
public class HibernateUtil {
    private static EntityManagerFactory factory =null;

    public static EntityManager getManager(){
        try{
        if (factory == null){
            factory = Persistence.createEntityManagerFactory("CadastroUsuarioPU");
        }
        return factory.createEntityManager();

    } catch(Exception e){
            System.out.println("Erro"+e);
            return null;
    }

}
}
