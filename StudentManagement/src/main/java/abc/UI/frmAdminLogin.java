package abc.UI;

import abc.ListenerManager.FrameOpener;
import abc.ListenerManager.IFrameManager;
import abc.Main.Exceptions;
import abc.Main.LoginCheck;
import abc.Main.PasswordManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.sql.SQLException;

public class frmAdminLogin {
    private JTextField txtId;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    JPanel pnlAdminLogin;
    private JLabel lblPassword;
    private JLabel lblId;
    String id;
    int password;
    IFrameManager frameOpener;
    LoginCheck loginCheck;
    Exceptions exceptions;




    public frmAdminLogin() {
        exceptions=new Exceptions();
        loginCheck=new LoginCheck();
        frameOpener=new FrameOpener();

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    exceptions.loginControl(txtId.getText(),txtPassword.getPassword());

                    password=PasswordManager.Convert(txtPassword.getPassword())==0?10000000:
                            PasswordManager.Convert(txtPassword.getPassword());

                  if(loginCheck.AdminLoginCheck(txtId.getText(),password)){
                      frameOpener.Action("Hoşgeldiniz", new frmAdmin().pnlAdmin);
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "Tekrar Deneyiniz");
                  }
                } catch (Exception ex) { }


            }
        });
    }
}
