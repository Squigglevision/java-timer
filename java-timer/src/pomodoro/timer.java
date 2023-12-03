package pomodoro;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timer  extends JFrame implements ActionListener{

    private JButton start;
    private JButton reset;
    private JLabel time;
    private JLabel Title;
    private int sessionTime = 1200; // 1200 seconds = 20 minutes
    private int elapsedTime = sessionTime*1000;
    private int hours = elapsedTime/3600000;
    private int minutes = (elapsedTime/600000)%60;
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
        this.start = new JButton("Start");
        this.reset = new JButton("reset");
        this.start.setBounds(100, 200, 100, 50);
        this.reset.setBounds(200, 200, 100, 50);

        this.add(this.start);
        this.add(this.reset);
        this.start.addActionListener(this);
        this.reset.addActionListener(this);

        this.time = new JLabel(hoursStr+" : "+minutesStr+" : "+secondsStr);
        this.time.setBounds(175, 100, 100, 100);


    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
      

    }

}
