package abc.Main;

import abc.Dal.ICrud;
import abc.Dal.StudentCrud;
import abc.Dal.UserCrud;
import abc.ListenerManager.FrameOpener;
import abc.ListenerManager.IFrameManager;
import abc.UI.frmAdminLogin;
import abc.UI.frmMain;
import abc.hibernate.Person;
import abc.hibernate.Student;
import abc.hibernate.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {

            IFrameManager frameOpener=new FrameOpener();
            frameOpener.Action("Hoşgeldiniz",new frmMain().pnlMain);

    }

}
