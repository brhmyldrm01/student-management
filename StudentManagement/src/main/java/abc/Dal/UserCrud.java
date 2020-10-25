package abc.Dal;

import abc.hibernate.Person;
import abc.hibernate.Student;
import abc.hibernate.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.util.List;

public class UserCrud implements ICrud {


    Connect connect;
    User user;
    SessionFactory factory;
    Session session;
    List<User> users;
    public UserCrud() {
        user=new User();
        connect=new Connect(user);
        factory=connect.getSessionFactory();
        users=null;
    }

    @Override
    public List getAll() {
        session =factory.getCurrentSession();
        session.beginTransaction();
        users =session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        session.close();
        return users;

    }

    @Override
    public Object getById(String id) {
        session=factory.getCurrentSession();
        session.beginTransaction();
        users =  session.createQuery("from User U where U.id='"+id+"'").getResultList();
        session.getTransaction().commit();
        session.close();
        return users;

    }

    @Override
    public int delete(String Id) {
        try{
        session=factory.getCurrentSession();
        session.beginTransaction();
        users =  session.createQuery("from User U where U.id='"+Id+"'").getResultList();
        session.delete(users.get(0));
        session.getTransaction().commit();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Silinecek Kullanıcı Bulunamdı.");
        }
        finally {
            session.close();
            return 0;
        }
    }

    @Override
    public int insert(Person person) {
        session=factory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate("ID",person);
        session.getTransaction().commit();
        session.close();
        return 0;
    }

    @Override
    public int update(Person person) {

        session=factory.getCurrentSession();
        session.beginTransaction();
        session.update("ID",person);
        session.getTransaction().commit();
        session.close();
        return 0;
    }
}
