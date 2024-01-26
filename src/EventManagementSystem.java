import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class EventManagementSystem extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;

    public EventManagementSystem() {

        setSize(1366, 430);          // setContentPane(300,300,1366,390);   frame size
        setLayout(null);
        setLocation(300, 300);

        l1 = new JLabel("");
        b1 = new JButton("Next");

        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);

        URL imageUrl = getClass().getResource("hotel/management/system/icons/first.jpg");
        if (imageUrl != null) {
            ImageIcon i1 = new ImageIcon(imageUrl);
            Image i3 = i1.getImage().getScaledInstance(1366, 390, Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            l1 = new JLabel(i2);

            JLabel lid = new JLabel("EVENT MANAGEMENT SYSTEM");
            lid.setBounds(30, 300, 1500, 100);
            lid.setFont(new Font("serif", Font.PLAIN, 70));
            lid.setForeground(Color.red);
            l1.add(lid);

            b1.setBounds(1170, 325, 150, 50);
            l1.setBounds(0, 0, 1366, 390);

            l1.add(b1);
            add(l1);

            b1.addActionListener(this);
            setVisible(true);

            while (true) {
                lid.setVisible(false); // lid =  j label
                try {
                    Thread.sleep(500); //1000 = 1 second
                } catch (Exception e) {
                }
                lid.setVisible(true);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
            }
        } else {
            System.err.println("Image resource not found.");
        }

    }
      /*  ImageIcon i1;
        i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));*/


        public void actionPerformed (ActionEvent ae){
            new Login().setVisible(true);
            this.setVisible(false);

        }

        public static void main (String[]args){
            EventManagementSystem window;
            window = new EventManagementSystem();
            window.setVisible(true);
        }
    }
