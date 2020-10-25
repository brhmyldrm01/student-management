package abc.Main;

import abc.Dal.UserCrud;
import abc.hibernate.Person;
import abc.hibernate.User;

import javax.swing.*;
import java.util.List;

public class Exceptions  extends Exception{

    public  void nullPerson(List list) throws Exception {
        if(list.size()==0){
            JOptionPane.showMessageDialog(null,"Kayıt Bulunamadı.");
            throw new Exception("");
        }
        return;

    }




    public  boolean alphabetControl(String text){
        boolean control=true;
        char[] array=text.toCharArray();

        for(int i=0;i<text.length();i++){
            char c=array[i];

            if ((c >= '0' && c <= '9')){

            }else{
                control=false;
                break;
            }
        }
        return control;

    }
    public  void loginControl(String id,char[] pass) throws Exception {
         voidObj(id);

        if (pass.length==0){
            JOptionPane.showMessageDialog(null,"Parola Girilmelidir.");
            throw  new  Exception("");
        }


    }


    public  void voidObj(String id) throws Exception {
        if (id.length()==0){
            JOptionPane.showMessageDialog(null,"TC Kimlik Numarası Girilmelidir.");
            throw new Exception("");
        }
        if (id.length()!=11){
            JOptionPane.showMessageDialog(null,"TC Kimlik Numarası 11 haneli olmalıdır.");
            throw new Exception("");
        }
        if(!alphabetControl(id)){
            JOptionPane.showMessageDialog(null,"TC Kimlik Numarası Rakamlardan Oluşmalıdır.");
            throw new Exception("");
        }
        else{
           return;
        }
    }

    public  void feeControl(String fee) throws Exception {
        boolean control=alphabetControl(fee);

        if (control==false||fee==""){
            JOptionPane.showMessageDialog(null,"Ücret Yanlış girildi.");
           throw new Exception("");
        }
        else{

            return;
        }

    }

    public  void Selected(int selected) throws Exception {
        if(selected==-1){
            JOptionPane.showMessageDialog(null,"Tablodan Kayıt Seçerek Tekrar Deneyiniz.");
            throw new Exception("");
        }

    }


    }
