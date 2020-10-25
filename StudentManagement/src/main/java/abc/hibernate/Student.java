package abc.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student extends Person{
    @Id
    @Column(name="ID")
    private String  id;
    @Column(name="Name")
    private String name;
    @Column(name="Email")
    private String e_mail;
    @Column(name="Lesson")
    private String lesson;
    @Column(name="Fee")
    private int fee;
    @Column(name="City")
    private String city;


    public Student() {
    }

    public Student(String ID, String Name, String City, String Email, String Lesson, int Fee ){
        this.id=ID;
        this.name=Name;
        this.city=City;
        this.e_mail=Email;
        this.lesson=Lesson;
        this.fee=Fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}