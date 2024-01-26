import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame{

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("EVENT MANAGEMENT SYSTEM");

        setForeground(Color.CYAN);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1950, 1000);
        add(NewLabel);

        JLabel AirlineManagementSystem = new JLabel("Welcome");
        AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
        AirlineManagementSystem.setBounds(600, 60, 1000, 85);
        NewLabel.add(AirlineManagementSystem);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu AirlineSystem = new JMenu("EVENT MANAGEMENT");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("RECEPTION");
        AirlineSystem.add(FlightDetails);

        JMenu AirlineSystemHello = new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.RED);
        menuBar.add(AirlineSystemHello);

        JMenuItem FlightDetailshello1 = new JMenuItem("ADD EVENT");
        AirlineSystemHello.add(FlightDetailshello1);

        FlightDetailshello1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEvent().setVisible(true);
                }catch(Exception e ){}
            }
        });


        JMenuItem FlightDetailshello2 = new JMenuItem("EDIT EVENT");
        AirlineSystemHello.add(FlightDetailshello2);

        FlightDetailshello2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new EditEvent().setVisible(true);
                }catch(Exception e ){}
            }
        });


        FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
        });





        setSize(1950,1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}