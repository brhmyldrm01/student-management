package abc.UI;

import abc.ListenerManager.FrameOpener;
import abc.ListenerManager.IFrameManager;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;

public class frmMain {
    private JButton btnAdmin;
    private JButton btnUser;
    public JPanel pnlMain;
    IFrameManager frameOpener=new FrameOpener();



    public frmMain() {
        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameOpener.Action("Yönetici Giriş Ekranı",new frmAdminLogin().pnlAdminLogin);


            }
        });
        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameOpener.Action("Kullanıcı Giriş Ekranı",new frmUserLogin().pnlUserLogin);
            }
        });

    }
}
