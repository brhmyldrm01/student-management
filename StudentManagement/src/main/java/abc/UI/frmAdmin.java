package abc.UI;

import abc.Dal.ICrud;
import abc.Dal.UserCrud;
import abc.Main.Exceptions;
import abc.Main.PasswordManager;
import abc.hibernate.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmAdmin {
    private JLabel lblIdF;
    private JTextField txtIdF;
    private JButton btnFind;
    private JTextField txrtId;
    private JTextField txtName;
    private JTextField txtEmail;
    private JLabel lblId;
    private JLabel lblEmail;
    private JLabel lblName;
    private JButton btnGetAll;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    JPanel pnlAdmin;
    private JTable tblUser;
    private JTextField txtPassword;
    private JButton btnDeleteSelected;
    ICrud crud=new UserCrud();

    User user;
    Exceptions exceptions;
    List<User> users;
    Object[]  object;





    DefaultTableModel model ;
    public DefaultTableModel cleanModel(){
        model=new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        return model;
    }

    public void cleanScreen(){
        txtName.setText("");
        txtEmail.setText("");
        txtIdF.setText("");
        txrtId.setText("");
        txtPassword.setText("");
    }

    public void getAll(){

        model=cleanModel();
        tblUser.setModel(model);
        users =crud.getAll();
        for(User temp:users){
            object= new Object[]{temp.getId(), temp.getName(), temp.getE_mail()};
            model.addRow(object);
        }
        tblUser.setModel(model);
    }

    public User setUser(int password,String name,String email,String id){
        user.setPassword(password);
        user.setName(name);
        user.setE_mail(email);
        user.setId(id);
        return user;
    }

    public User setUser(String name,String email,String id){
        user.setName(name);
        user.setE_mail(email);
        user.setId(id);
        return user;
    }


    public frmAdmin() {

        this.object =null;
        users=null;
        exceptions=new Exceptions();
        user=new User();


        btnFind.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
               model= cleanModel() ;
                tblUser.setModel(model);
           try{
               exceptions.voidObj(txtIdF.getText());
               users= (List<User>) crud.getById(txtIdF.getText());
               cleanScreen();
               exceptions.nullPerson(users);

               user=setUser(users.get(0).getName(),users.get(0).getE_mail(),users.get(0).getId());

                 txrtId.setText(user.getId());
                 txtEmail.setText(user.getE_mail());
                 txtName.setText(user.getName());

                object= new Object[]{user.getId(), user.getName(), user.getE_mail()};
                 model.addRow(object);
                 tblUser.setModel(model);

                }catch (Exception ex){ }

            }
        });

        btnGetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanScreen();
               getAll();
            }
        });


        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    exceptions.voidObj(txrtId.getText());
                    users = (List<User>) crud.getById(txrtId.getText());
                    //if the admin tries to add an exist user.Password won't be changing.
                    int pw = users.size() == 0 ? PasswordManager.Convert(txtPassword.getText().toCharArray()): users.get(0).getPassword();

                    user =setUser(pw,txtName.getText(),txtEmail.getText(),txrtId.getText());
                    crud.insert(user);

                    cleanScreen();
                    getAll();

                }catch (Exception ex){ }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    exceptions.voidObj(txrtId.getText());
                    users= (List<User>) crud.getById(txrtId.getText());
                    exceptions.nullPerson(users);

                    //if the admin has made some update on an user and hasn't changed the password.
                    // The password won't be changing.Otherwise it will change.
                    int pw=txtPassword.getText().length()==0?users.get(0).getPassword():
                            PasswordManager.Convert(txtPassword.getText().toCharArray());

                    user=setUser(pw,txtName.getText(),txtEmail.getText(),txrtId.getText());
                    crud.update(user);

                    cleanScreen();
                    getAll();

                }catch (Exception ex){ }

            }
        });

        btnDeleteSelected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                int selected =  tblUser.getSelectedRow();
                exceptions.Selected(selected);

                String id = (String) tblUser.getValueAt(selected,0);
                crud.delete(id);

                model.removeRow(selected);
                tblUser.setModel(model);

            }catch (Exception ex){}
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    exceptions.voidObj(txrtId.getText());
                    crud.delete(txrtId.getText());

                    getAll();
                    cleanScreen();
            }catch (Exception ex){}
            }
        });

    }
}
