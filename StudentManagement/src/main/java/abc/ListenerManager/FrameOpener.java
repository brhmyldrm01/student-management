package abc.ListenerManager;

import javax.swing.*;
import java.awt.*;

public class FrameOpener extends JFrame implements IFrameManager {

    JFrame frame;

    public FrameOpener() throws HeadlessException {
        this.frame = new JFrame();
    }

    @Override
    public void Action(String title, JPanel panel) {
        frame.setTitle(title);
        frame.setContentPane(panel);
        frame.setSize(1100, 600);
        frame.setLocation(200, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }


}
