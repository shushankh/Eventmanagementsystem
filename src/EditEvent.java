import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEvent extends JFrame {

    JTextField textField,textField_1,textField_2;
    JComboBox c1;





    public EditEvent(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("EDIT EVENT DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel Passportno = new JLabel("ID");
        Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno.setBounds(60, 30, 150, 27);
        add(Passportno);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        JButton Next = new JButton("SAVE");
        Next.setBounds(200, 420, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);

        JLabel Pnrno = new JLabel("NAME");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 100, 150, 27);
        add(Pnrno);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 100, 150, 27);
        add(textField_1);

        JLabel time1= new JLabel("DATE");
        time1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        time1.setBounds(60, 200, 150, 27);
        add(time1);

        textField_2= new JTextField();
        textField_2.setBounds(200, 200, 150, 27);
        add(textField_2);


        JLabel Address = new JLabel("LOCATION");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 250, 150, 27);
        add(Address);

        String course[] = {"Pokhara","Kathmandu","Lalitpur"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,250,150,30);
        add(c1);










        setVisible(true);

        JLabel AddPassengers = new JLabel("EDIT");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410,80,480,410);
        add(image);


        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String id = textField.getText();
                String name= textField_1.getText();
                String date= textField_2.getText();





                String s6 = (String)c1.getSelectedItem();

                try {
                    conn c = new conn();
                    String str = "UPDATE Event SET name ='"+name+"' , date_time ='"+date+"' , location ='"+s6+"' WHERE id ='"+id+"'";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Event Edited");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900,600);
        setVisible(true);
        setLocation(530,200);

    }

    public static void main(String[] args){
        new EditEvent();
    }
}
