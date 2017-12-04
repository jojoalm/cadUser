/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import Beans.UsuarioBeans;
import util.DAO;

/**
 *
 * @author SONY
 */
public class TestaUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioBeans bean = new UsuarioBeans(); 
      
        DAO dao = new DAO(); 
        Usuario user = new Usuario(); 
        user.setId(1L);
        
        Long id = user.getId(); 
        System.out.println(id);
        
   
        //dao.excluirUsuario(user);
        //System.out.println("sucesso");

    }

}
