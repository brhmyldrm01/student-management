package abc.Main;

import abc.Dal.AdminCrud;
import abc.Dal.UserCrud;
import abc.hibernate.Admin;
import abc.hibernate.Person;
import abc.hibernate.User;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginCheck {

    Boolean check=false;
    int passwordDB;
    Exceptions exceptions;

    public LoginCheck() {
        this.check = check;
         passwordDB=000;
         exceptions =new Exceptions();

    }

    public boolean AdminLoginCheck(String idU, int passwordU) throws Exception {
        AdminCrud getFromDB = new AdminCrud();
        List<Admin> object;
        object = (List<Admin>) getFromDB.getById(idU);

            try{
                exceptions.nullPerson(object);
            passwordDB = Integer.parseInt(object.get(0).getPassword());

        if (passwordU == passwordDB) {
            check = true;
        } else {
            check = false;
        }
            }catch (Exception ex){

            }
        return check;
    }


    public boolean UserLoginCheck(String idU, int passwordU) throws Exception {
        UserCrud getFromDB = new UserCrud();
        List<User> object;
        object = (List<User>) getFromDB.getById(idU);
        try{
            exceptions.nullPerson(object);
        passwordDB = object.get(0).getPassword();

        if (passwordU == passwordDB) {
            check = true;
        } else {
            check = false;
        }}catch (Exception ex){

        }
        return check;
    }


}
