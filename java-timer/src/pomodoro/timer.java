package pomodoro;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class timer  extends JFrame implements ActionListener{

    private JButton start;
    private JButton reset;
    private JLabel time;
    private JLabel Title;
    private JTextField textField;
    private int sessionTime;
    // private int sessionTime = 5;
    private int elapsedTime = sessionTime*1000;
    private int hours = elapsedTime/3600000;
    private int minutes = (elapsedTime/60000)%60;
    private int seconds = (elapsedTime/1000)%60;

    boolean startClicked = false;
    String hoursStr = String.format("%02d", hours);
    String minutesStr = String.format("%02d", minutes);
    String secondsStr = String.format("%02d", seconds);

    public timer() {
        this.setSize(420,420);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.Title = new JLabel("POMODORO TIMER");
        this.Title.setBounds(120, 50, 250, 100);
        this.Title.setFont(new Font("Sans-serif", Font.BOLD, 18));
        this.add(this.Title);

        this.textField = new JTextField(20);
        this.textField.setBounds(180, 125, 50, 20);
        this.add(this.textField);

        this.time = new JLabel(hoursStr + " : " + minutesStr + " : " + secondsStr);
        this.time.setBounds(175, 120, 100, 100);
        this.add(this.time);

        this.start = new JButton("Start");
        this.start.setBounds(100, 200, 100, 50);
        this.add(this.start);
        this.start.addActionListener(this);

        this.reset = new JButton("reset");
        this.reset.setBounds(200, 200, 100, 50);
        this.add(this.reset);
        this.reset.addActionListener(this);
    }
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(elapsedTime != 0) {
                elapsedTime = elapsedTime - 1000;
                hours = (elapsedTime/3600000);
                minutes = (elapsedTime/60000) % 60;
                seconds = (elapsedTime/1000) % 60;
                String hoursStr = String.format("%02d", hours);
                String minutesStr = String.format("%02d", minutes);
                String secondsStr = String.format("%02d", seconds);
                time.setText(hoursStr + " : " + minutesStr + " : " + secondsStr );
            }
            else {
                stoptimerinzero();
            } 
        }
    }
    );

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start){
            if (startClicked == false) {
                start.setText("STOP");
                startClicked = true;
                timer.start();
            }
            else {
                start.setText("start");
                startClicked = false;
                timer.stop();
            }
        }
        else if (e.getSource() == reset) {
            timer.stop();
            elapsedTime = sessionTime * 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            String hoursStr = String.format("%02d", hours);
            String minutesStr = String.format("%02d", minutes);
            String secondsStr = String.format("%02d", seconds);
            this.time.setBounds(175, 100, 100, 100);
            this.time.setText(hoursStr + " : " + minutesStr + " : " + secondsStr );
            this.start.setText("Start");
            startClicked = false;
        }
    }

    public void stoptimerinzero() {
            timer.stop();
            Toolkit.getDefaultToolkit().beep();
            elapsedTime = sessionTime * 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            String hoursStr = String.format("%02d", hours);
            String minutesStr = String.format("%02d", minutes);
            String secondsStr = String.format("%02d", seconds);
            this.time.setText(hoursStr + " : " + minutesStr + " : " + secondsStr );
            this.start.setText("Start");
            startClicked = false;
            int choice = JOptionPane.showConfirmDialog(null, "Great Job! Want to keep going? ", "The session has ended.", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "The session has ended. Good luck in the next one!");
            }
    }
}
