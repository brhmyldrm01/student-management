package abc.UI;

import abc.Dal.ICrud;
import abc.Dal.StudentCrud;
import abc.Main.Exceptions;
import abc.hibernate.Student;
import abc.hibernate.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.SplittableRandom;

public class frmUser<list1> {
    private JLabel lblIdF;
    private JTextField txtIdF;
    private JButton btnFind;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtCity;
    private JTextField txtEmail;
    private JTextField txtLesson;
    private JTextField txtFee;
    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblCity;
    private JLabel lblEmail;
    private JLabel lblLesson;
    private JLabel lblFee;
    private JButton btnGetAll;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    JPanel pnlUser;
    private JTable tblStudent;
    private JButton btnDeleteSelected;
    ICrud crud=new StudentCrud();

    Student student;
    List <Student> students;
    Exceptions exceptions;
    Object[] object;



    public Student setStudent(String id,String name,String email,String city,String lesson,int fee){
        student.setId(id);
        student.setE_mail(email);
        student.setName(name);
        student.setCity(city);
        student.setFee(fee);
        student.setLesson(lesson);
        return student;
    }

    DefaultTableModel tableModel;
    public DefaultTableModel cleanModel(){
       tableModel= new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("City");
        tableModel.addColumn("Lesson");
        tableModel.addColumn("Fee");
        return tableModel;
    }

    public void cleanScreen(){
        txtCity.setText("");
        txtEmail.setText("");
        txtFee.setText("");
        txtId.setText("");
        txtIdF.setText("");
        txtLesson.setText("");
        txtName.setText("");
    }



    public void getAll(){
        tableModel=cleanModel();
        tblStudent.setModel(tableModel);
        students= crud.getAll();
        for(Student stdnt:students){
             object=new Object[]{stdnt.getId(),stdnt.getName(),stdnt.getE_mail(),stdnt.getCity(),stdnt.getLesson(),stdnt.getFee()};
            tableModel.addRow(object);
        }
        tblStudent.setModel(tableModel);
    }

    public frmUser() {

        object=null;
        students=null;
        exceptions=new Exceptions();
        student=new Student();


        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tableModel=cleanModel();
                tblStudent.setModel(tableModel);

                try {
                    exceptions.voidObj(txtIdF.getText());
                    students= (List<Student>) crud.getById(txtIdF.getText());
                    cleanScreen();
                     exceptions.nullPerson(students);
                     student = students.get(0);

                    txtId.setText(student.getId());
                    txtEmail.setText(student.getE_mail());
                    txtName.setText(student.getName());
                    txtFee.setText(Integer.toString(student.getFee()));
                    txtLesson.setText(student.getLesson());
                    txtCity.setText(student.getCity());

                    object = new Object[]{student.getId(), student.getName(), student.getE_mail(), student.getCity(), student.getLesson(), student.getFee()};
                    tableModel.addRow(object);
                    tblStudent.setModel(tableModel);
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
                try{
                    exceptions.voidObj(txtId.getText());
                    exceptions.feeControl(txtFee.getText());
                    //Default fee is equal to zero
                    int fee=txtFee.getText().length()==0?0:Integer.parseInt(txtFee.getText());
                    
                    student=setStudent(txtId.getText(),txtName.getText(),txtEmail.getText(),txtCity.getText(),txtLesson.getText(),fee);
                    crud.insert(student);

                    cleanScreen();
                    getAll();
                } catch (Exception ex) { }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    exceptions.voidObj(txtId.getText());
                    exceptions.feeControl(txtFee.getText());
                     students= (List<Student>) crud.getById(txtId.getText());
                    exceptions.nullPerson(students);

                    //Default fee is equal to zero
                    int fee=txtFee.getText().length()==0?0:Integer.parseInt(txtFee.getText());
                    student=setStudent(txtId.getText(),txtName.getText(),txtEmail.getText(),txtCity.getText(),txtLesson.getText(),fee);
                    crud.update(student);

                    cleanScreen();
                    getAll();
                } catch (Exception ex){ }
            }
        });

        btnDeleteSelected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int selected =  tblStudent.getSelectedRow();
                     exceptions.Selected(selected);

                     String id = (String) tblStudent.getValueAt(selected,0);
                    crud.delete(id);

                    tableModel.removeRow(selected);
                    tblStudent.setModel(tableModel);
                  }catch (Exception ex){ }
            }

        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    exceptions.voidObj(txtId.getText());
                    crud.delete(txtId.getText());

                    getAll();
                    cleanScreen();
                } catch (Exception ex){ }
            }
        });
    }
}
