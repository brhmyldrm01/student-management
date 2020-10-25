package abc.UI;

import abc.ListenerManager.FrameOpener;
import abc.ListenerManager.IFrameManager;
import abc.Main.Exceptions;
import abc.Main.LoginCheck;
import abc.Main.PasswordManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmUserLogin {
    private JTextField txtId;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblId;
    private JLabel lblPassword;
    JPanel pnlUserLogin;
    String id;
    int password;


    FrameOpener frameOpener;
    Exceptions exceptions;
    LoginCheck loginCheck;



    public frmUserLogin() {
            exceptions=new Exceptions();
            loginCheck=new LoginCheck();
            frameOpener=new FrameOpener();

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    exceptions.loginControl(txtId.getText(),txtPassword.getPassword());

                    password= PasswordManager.Convert(txtPassword.getPassword())==0?10000000:
                            PasswordManager.Convert(txtPassword.getPassword());

                    if (loginCheck.UserLoginCheck(txtId.getText(),password)) {
                         frameOpener.Action("Hoşgeldiniz",new frmUser().pnlUser);
                    }
                    else { JOptionPane.showMessageDialog(null, "Tekrar Deneyiniz");
                        }

                } catch (Exception ex) { }
            }
        });
    }
}
