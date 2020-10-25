package abc.hibernate;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User extends Person{
    @Id
    @Column(name="ID")
    private String id;
    @Column(name="Name")
    private String name;
    @Column(name="Email")
    private String e_mail;
    @Column(name="Password")
    private int password;



    public User() {

    }

    public User(String id, String name, String e_mail,int password) {
        this.name=name;
        this.e_mail=e_mail;
        this.id=id;
        this.password=password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}
