package pomodoro;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timer  extends JFrame implements ActionListener{

    private JButton start;
    private JButton reset;
    private JLabel time;
    private JLabel Title;
    private int sessionTime = 1200; // 1200 seconds = 20 minutes
    private int elapsedTime = sessionTime*1000;
    private int h = elapsedTime/3600000;
    private int m = elapsedTime/600000;

    @Override
    public void actionPerformed(ActionEvent e) {
      

    }

}
