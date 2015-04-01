import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Desktop;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Locale;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UI_Registration extends JFrame {
	private JTextField textField_name;
	private JTextField textField_Street;
	private JTextField textField_City;
	private JTextField textField_postcode;
	private JTextField textField_email;
	private JTextField textField_phone;
	private JTextField textField_username;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private CustomerInterface c;
	public UI_Registration() {
		setSize(new Dimension(530, 535));
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);
		
		JLabel lblNewCustomerRegistration = new JLabel("New Customer Registration");
		lblNewCustomerRegistration.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewCustomerRegistration.setBounds(139, 26, 257, 23);
		getContentPane().add(lblNewCustomerRegistration);
		
		JPanel panel_personal = new JPanel();
		panel_personal.setBackground(Color.WHITE);
		panel_personal.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Personal Details", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel_personal.setBounds(18, 61, 479, 225);
		getContentPane().add(panel_personal);
		panel_personal.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(130, 28, 39, 16);
		panel_personal.add(lblName);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(16, 28, 39, 16);
		panel_personal.add(lblTitle);
		
		textField_name = new JTextField();
		textField_name.setBounds(165, 22, 271, 28);
		panel_personal.add(textField_name);
		textField_name.setColumns(10);
		
		JComboBox comboBox_title = new JComboBox();
		comboBox_title.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Ms.", "Mrs."}));
		comboBox_title.setBounds(67, 23, 61, 26);
		panel_personal.add(comboBox_title);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(16, 61, 55, 16);
		panel_personal.add(lblStreet);
		
		textField_Street = new JTextField();
		textField_Street.setBounds(64, 56, 372, 28);
		panel_personal.add(textField_Street);
		textField_Street.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(16, 95, 55, 16);
		panel_personal.add(lblCity);
		
		textField_City = new JTextField();
		textField_City.setBounds(64, 89, 183, 28);
		panel_personal.add(textField_City);
		textField_City.setColumns(10);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setBounds(259, 96, 55, 16);
		panel_personal.add(lblPostcode);
		
		textField_postcode = new JTextField();
		textField_postcode.setBounds(314, 89, 122, 28);
		panel_personal.add(textField_postcode);
		textField_postcode.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(16, 123, 55, 16);
		panel_personal.add(lblCountry);
		
		String[] countries = Locale.getISOCountries();
		String[] countryName = new String[countries.length];
		
		for(int i =0; i<countries.length;i++){
			String country = countries[i];
            Locale locale = new Locale("FR", country);
            countryName[i] = locale.getDisplayCountry();
		}
			
		
		JComboBox comboBox_country = new JComboBox(countryName);
		comboBox_country.setBounds(64, 118, 183, 26);
		panel_personal.add(comboBox_country);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(16, 157, 55, 16);
		panel_personal.add(lblEmail);
		
		textField_email = new JTextField();
		textField_email.setBounds(64, 151, 183, 28);
		panel_personal.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblAge = new JLabel("D.O.B");
		lblAge.setBounds(259, 157, 39, 16);
		panel_personal.add(lblAge);
		
		JDateChooser dateChooser_dob = new JDateChooser();
		dateChooser_dob.setDateFormatString("dd/MM/yyyy");
		dateChooser_dob.setBounds(298, 151, 135, 28);
		panel_personal.add(dateChooser_dob);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(16, 191, 55, 16);
		panel_personal.add(lblGender);
		
		JComboBox comboBox_gender = new JComboBox();
		comboBox_gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_gender.setBounds(64, 185, 91, 26);
		panel_personal.add(comboBox_gender);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setBounds(169, 191, 55, 16);
		panel_personal.add(lblPhoneNo);
		
		textField_phone = new JTextField();
		textField_phone.setBounds(236, 185, 200, 28);
		panel_personal.add(textField_phone);
		textField_phone.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(18, 306, 479, 125);
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "User Account", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(59, 59, 59)));
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(16, 35, 66, 16);
		panel.add(lblUsername);
		
		textField_username = new JTextField();
		textField_username.setEditable(false);
		textField_username.setBounds(122, 29, 142, 28);
		panel.add(textField_username);
		textField_username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(16, 63, 66, 16);
		panel.add(lblPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(122, 57, 200, 28);
		panel.add(passwordField_1);
		
		JLabel lblVerifyPass = new JLabel("Verify Password");
		lblVerifyPass.setBounds(16, 91, 107, 16);
		panel.add(lblVerifyPass);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(122, 85, 200, 28);
		panel.add(passwordField_2);
		
		JLabel lblUsernameWillBe = new JLabel("*Username will be generated.");
		lblUsernameWillBe.setBounds(276, 29, 181, 16);
		panel.add(lblUsernameWillBe);
		
		JCheckBox chckbxIAcceptThe = new JCheckBox("I accept the");
		chckbxIAcceptThe.setBounds(18, 437, 104, 18);
		getContentPane().add(chckbxIAcceptThe);
		
		JLabel lblTermsAndConditions = new JLabel("<html>\r\n<a href=\"\">terms and conditions.</a>\r\n</html>");
		lblTermsAndConditions.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTermsAndConditions.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://sites.google.com/site/cryocellcorporation/terms-conditions"));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblTermsAndConditions.setBounds(106, 438, 130, 17);
		getContentPane().add(lblTermsAndConditions);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = String.valueOf( comboBox_title.getSelectedItem() );
				String name = textField_name.getText();
				String street = textField_Street.getText();
				String city = textField_City.getText();
				String postcode = textField_postcode.getText();
				String country = String.valueOf( comboBox_country.getSelectedItem() );
				String email = textField_email.getText();
				Date dob = dateChooser_dob.getDate();
				String gender = String.valueOf( comboBox_gender.getSelectedItem() );
				String phoneNo = textField_phone.getText();
				String username = textField_username.getText();
				String salt = null;
				try {
					salt = getSalt();
				} catch (NoSuchAlgorithmException e2) {
					e2.printStackTrace();
				}
		        String password = get_SHA_256_SecurePassword(new String(passwordField_1.getPassword()), salt);
				
				
				try {
					RegistrationInterface registration = (RegistrationInterface)Client.getLookup().lookup("registration");
					registration = registration.newRegistration();
					
					registration.setCustomer(title, name, street, city, postcode, country, email, dob, gender, phoneNo);
					registration.setUser(username, password, salt, "customer");
					String result = registration.execute();
					if( result.equals(null) )
						JOptionPane.showMessageDialog(UI_Registration.this, "Registration could not completed.", "Registration failed", JOptionPane.ERROR_MESSAGE);
					else
						textField_username.setText(result);
						JOptionPane.showMessageDialog(UI_Registration.this, "Registration completed! Your UserID is " + result, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
					
					Client.getLookup().release(registration);
				} catch (LookupFailedException | EstablishConnectionFailed | UnknownHostException e1) {
					e1.printStackTrace();
				}
						}
		});
		btnRegister.setBounds(398, 459, 75, 28);
		getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(329, 459, 67, 28);
		getContentPane().add(btnCancel);
		
	}
	
	public static void run(){
		new UI_Registration().setVisible(true);
	}
	
	 public String get_SHA_256_SecurePassword(String enteredPass, String salt){
			
			String generatedPass = null;
			try{
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(salt.getBytes());
				byte[] bytes = md.digest(enteredPass.getBytes());
				StringBuilder sb = new StringBuilder();
				
				for(int i=0;i<bytes.length;i++)
					sb.append(Integer.toString( (bytes[i] & 0xff) + 0x100, 16).substring(1) );
				
				generatedPass = sb.toString();
				
			}catch(NoSuchAlgorithmException e){
				e.printStackTrace();
			}
			
			return generatedPass;
		}
	    
	 public String getSalt() throws NoSuchAlgorithmException{
	    	SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	    	byte[] salt = new byte[16];
	    	sr.nextBytes(salt);
	    	return salt.toString();
	 }
}