/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import modelo.Usuario;

/**
 *
 * @author SONY
 */
public class DAO {

    EntityManager manager = HibernateUtil.getManager();

    public void excluirUsuario(Usuario user) {
        manager.getTransaction().begin();
        manager.remove(user);
        manager.getTransaction().commit();
        

    }
}
