package Beans;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Usuario;
import org.hibernate.Session;
import util.DAO;
import util.HibernateUtil;

@ManagedBean //gera os new
@SessionScoped
public class UsuarioBeans {

    EntityManager manager = HibernateUtil.getManager();
    private Usuario user = new Usuario();
    private DAO dao = new DAO();
    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
    private Long id;
    List<Usuario> lista;
    private String nome; //gerar o get/set

    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TimeZone getTz() {
        return tz;
    }

    public void setTz(TimeZone tz) {
        this.tz = tz;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
        if (id != null) {
            user = manager.find(Usuario.class, id);
        }
    }

    public Long getId() {
        return id;
    }

    public void newInstance() {
        user = new Usuario();
    }

    public void inserirUsuario() {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();

        newInstance();
    }

    public List listarTodosUsuarios() {
        Query query = manager.createQuery("select u from Usuario u");
        lista = (List<Usuario>) query.getResultList();
        if (lista.isEmpty()) {
        }
        return lista;

    }

    public List getUsuarios() {
        return listarTodosUsuarios();

    }

    public String remove() {

        try {
            manager.getTransaction().begin();
            manager.remove(user);
            manager.getTransaction().commit();

            newInstance();
            lista = null;

            return "remover";
        } catch (Exception e) {
            e.printStackTrace();
            return "falhou";
        }
    }

    public String update() {

        try {

            manager.getTransaction().begin();
            manager.merge(user);
            manager.clear();
            manager.flush();
            manager.getTransaction().commit();

            //newInstance();

            return "atualizar";
        } catch (Exception e) {
            e.printStackTrace();
            return "falhou";
        }

    }

    public List buscarClientePorNome() {
        Query query = manager.createQuery("select u from Usuario u where nome like :nome");
        query.setParameter("nome", nome+"%");
        lista = (List<Usuario>) query.getResultList();
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    public List getBuscaUsuarios() {
        return buscarClientePorNome();

    }
}
