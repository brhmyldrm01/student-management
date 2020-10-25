package abc.Dal;

import abc.hibernate.Admin;
import abc.hibernate.Person;
import abc.hibernate.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AdminCrud implements ICrud {

    Admin admin;
    Connect connect;
    SessionFactory factory;
    Session session;

    public AdminCrud() {
            admin=new Admin();
            connect=new Connect(admin);
            factory=connect.getSessionFactory();
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getById(String id) {
        session=factory.getCurrentSession();
        session.beginTransaction();
        List<User> user =  session.createQuery("from Admin U where U.id='"+id+"'").getResultList();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public int delete(String Id) {
        return 0;
    }

    @Override
    public int insert(Person person) {
        return 0;
    }

    @Override
    public int update(Person person) {
        return 0;
    }
}
