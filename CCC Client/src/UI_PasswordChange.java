import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.UnknownHostException;


public class UI_PasswordChange extends JFrame {
	private JPasswordField passwordField_old;
	private JPasswordField passwordField_new1;
	private JPasswordField passwordField_new2;
	
	private static String userID;
	
	public UI_PasswordChange() {
		getContentPane().setLayout(null);
		
		JLabel lblPasswordChange = new JLabel("Password Change");
		lblPasswordChange.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblPasswordChange.setBounds(99, 19, 143, 28);
		getContentPane().add(lblPasswordChange);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setBounds(25, 65, 91, 16);
		getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(25, 105, 91, 16);
		getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(25, 139, 103, 16);
		getContentPane().add(lblConfirmPassword);
		
		passwordField_old = new JPasswordField();
		passwordField_old.setBounds(137, 59, 182, 28);
		getContentPane().add(passwordField_old);
		
		passwordField_new1 = new JPasswordField();
		passwordField_new1.setBounds(137, 99, 182, 28);
		getContentPane().add(passwordField_new1);
		
		passwordField_new2 = new JPasswordField();
		passwordField_new2.setBounds(137, 133, 182, 28);
		getContentPane().add(passwordField_new2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					String oldpass = new String(passwordField_old.getPassword());
					String newPass = new String(passwordField_new1.getPassword());
					String newPassConfirm = new String(passwordField_new2.getPassword());
					
					if( oldpass.equals("") || newPass.equals("") || newPassConfirm.equals("")){
						JOptionPane.showMessageDialog(UI_PasswordChange.this, "Empty fields!", "Fail", JOptionPane.ERROR_MESSAGE);
					}else if( !(newPass.equals(newPassConfirm)) ){
						JOptionPane.showMessageDialog(UI_PasswordChange.this, "Passwords do not match.", "Fail", JOptionPane.ERROR_MESSAGE);
					}else{
						DatabaseInterface database;
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						
					}
					
					
				} catch (UnknownHostException | LookupFailedException
						| EstablishConnectionFailed e1) {
					
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnSubmit.setBounds(140, 182, 90, 28);
		getContentPane().add(btnSubmit);
	}
}
