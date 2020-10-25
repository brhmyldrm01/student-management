package abc.Dal;

import abc.hibernate.Person;
import com.mysql.cj.Session;

import java.util.List;

public interface ICrud {
    public List getAll();
    public  Object getById(String  id);
    public  int delete(String  Id);
    public  int insert(Person person);
    public  int update( Person person);



}
