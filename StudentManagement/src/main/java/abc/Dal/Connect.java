package abc.Dal;

import abc.hibernate.Person;
import abc.hibernate.Student;
import com.mysql.cj.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Connect {



    private Person person;

    public Connect(Person person) {
        this.person = person;
    }

    public SessionFactory getSessionFactory(){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(person.getClass())
                .buildSessionFactory();
        return factory ;
    }

}