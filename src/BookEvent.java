import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookEvent extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Ava;
	private JTextField txt_Status;
	private JTextField txt_Room;

	Choice c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookEvent frame = new BookEvent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}


	public BookEvent() throws SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
		Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(400,80,600,250);
		add(l1);

		JLabel lblUpdateRoomStatus = new JLabel("Book Events");
		lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
		contentPane.add(lblUpdateRoomStatus);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);

		c1 = new Choice();
		try{
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from venue");
			while(rs.next()){
				c1.add(rs.getString("id"));
			}
		}catch(Exception e){ }
		c1.setBounds(160, 84, 140, 20);
		contentPane.add(c1);

		JLabel lblAvailability = new JLabel("Date_Time:");
		lblAvailability.setBounds(27, 187, 90, 14);
		contentPane.add(lblAvailability);

		JLabel lblCleanStatus = new JLabel("Location:");
		lblCleanStatus.setBounds(27, 240, 90, 14);
		contentPane.add(lblCleanStatus);


		txt_Ava = new JTextField();
		txt_Ava.setBounds(160, 184, 140, 20);
		contentPane.add(txt_Ava);
		txt_Ava.setColumns(10);

		txt_Status = new JTextField();
		txt_Status.setBounds(160, 237, 140, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);

		txt_Room = new JTextField();
		txt_Room.setBounds(160, 130, 140, 20);
		contentPane.add(txt_Room);
		txt_Room.setColumns(10);




		JButton btnUpdate = new JButton("Request");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				String s6 = txt_Status.getText();
				String name= txt_Room.getText();
				String date= txt_Ava.getText();
				String id = (String)c1.getSelectedItem();
				try{
					conn c = new conn();
					String str = "UPDATE venue SET name ='"+name+"' , date_time ='"+date+"' , location ='"+s6+"' WHERE id ='"+id+"'";
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Request Sucessful");

					new Reception().setVisible(true);
					setVisible(false);
				}catch (Exception ee){
					ee.printStackTrace();
				}


			}
		});
		btnUpdate.setBounds(60, 355, 89, 23);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(180, 355, 89, 23);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		JLabel lblRoomId = new JLabel("Name:");
		lblRoomId.setBounds(27, 133, 100, 14);
		contentPane.add(lblRoomId);

		getContentPane().setBackground(Color.WHITE);
	}

}