import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewEvent extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
        Choice c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEvent frame = new ViewEvent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}


	public ViewEvent() throws SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPickUpService = new JLabel("View Events");
		lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPickUpService.setBounds(90, 11, 158, 25);
		contentPane.add(lblPickUpService);
		
		JLabel lblTypeOfCar = new JLabel("Events");
		lblTypeOfCar.setBounds(32, 97, 89, 14);
		contentPane.add(lblTypeOfCar);

		
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from event");
                    while(rs.next()){
                        c1.add(rs.getString("id"));
                    }
                }catch(Exception e){ }
                c1.setBounds(123, 94, 150, 25);
		contentPane.add(c1);

                
		
		JLabel lblInfo = new JLabel("ID");
		lblInfo.setBounds(25, 208, 100, 14);
		contentPane.add(lblInfo);
		
		JButton btnRegister = new JButton("Display");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = "select * from event where id = '"+c1.getSelectedItem()+"'";
				try{
				
					conn c = new conn();
					rs = c.s.executeQuery(SQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
				}catch (SQLException ss)
				{
					ss.printStackTrace();
				}
				
				
			}
		});
		btnRegister.setBounds(200, 500, 120, 30);
                btnRegister.setBackground(Color.BLACK);
                btnRegister.setForeground(Color.WHITE);
		contentPane.add(btnRegister);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(420, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(0, 233, 800, 250);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setBounds(225, 208, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("DATE-TIME");
		lblGender.setBounds(425, 208, 100, 14);
		contentPane.add(lblGender);
		
		JLabel lblTypeOfDriver = new JLabel("LOCATION");
		lblTypeOfDriver.setBounds(625, 208, 100, 14);
		contentPane.add(lblTypeOfDriver);
		

                
                
                getContentPane().setBackground(Color.WHITE);
	}
}