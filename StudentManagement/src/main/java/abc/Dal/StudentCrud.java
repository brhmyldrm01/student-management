package abc.Dal;

import abc.hibernate.Person;
import abc.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.util.List;

public class StudentCrud implements ICrud{

    Connect connect;
    Student student;
    SessionFactory factory;
    Session session;
    List<Student> students;

    public StudentCrud() {
        student=new Student();
        this.connect = new Connect(student);
        this.factory= connect.getSessionFactory();
         students=null;
    }

    @Override
    public List getAll() {
        session=factory.getCurrentSession();
        session.beginTransaction();
        students =session.createQuery("from Student").getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }


    @Override
    public List getById(String  id) {
        session=factory.getCurrentSession();
        session.beginTransaction();
        students =  session.createQuery("from Student S where S.id='"+id+"'").getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }

    @Override
    public int delete(String Id) {
        try{
        session=factory.getCurrentSession();
        session.beginTransaction();
        students =  session.createQuery("from Student S where S.id='"+Id+"'").getResultList();
        session.delete(students.get(0));
        session.getTransaction().commit();
       }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Silinecek Öğrenci Bulunamadı.");
        }finally {
            session.close();
        }
        return 0;
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
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.update("ID", person);
            session.getTransaction().commit();
            session.close();
        return 0;

    }
}
