import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.Icon;

public class UI_Employee extends JFrame {
	private JTextField textField;
	private JTable table_clients;
	private JTextField textField_ua_empID;
	private JPasswordField passwordField_ua_pass;
	private JPasswordField passwordField_ua_cpass;
	
	private DatabaseInterface database;
	private CustomerInterface customer;
	private PaymentInterface payment;
	private InvoiceInterface invoice;
	private CollectionPointInterface collectionPoint;
	private AddressInterface address;
	private SampleInterface sample;
	private JTextField textField_client_aclientID;
	private JTextField textField_sample_rcscNo;
	
	public static String userID;
	public static String role;
	
	private JTextField textField_client_name;
	private JTextField textField_client_street;
	private JTextField textField_client_city;
	private JTextField textField_client_postcode;
	private JTextField textField_client_email;
	private JTextField textField_client_phone;
	
	public UI_Employee() {
		setTitle("Employee - Cryo Cell Coporation " + "[ID:" + userID + "]");
		setSize(new Dimension(906, 586));
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane_main = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_main.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane_main.setBounds(0, 6, 890, 542);
		getContentPane().add(tabbedPane_main);
		
		JPanel panel_dashboard = new JPanel();
		panel_dashboard.addMouseListener(new MouseAdapter() {
			
		});
		tabbedPane_main.addTab("Dashboard", new ImageIcon(UI_Employee.class.getResource("/img/dashboard.png")), panel_dashboard, null);
		
		JPanel panel_client = new JPanel();
		tabbedPane_main.addTab("Client", new ImageIcon(UI_Employee.class.getResource("/img/1211811783.png")), panel_client, null);
		panel_client.setLayout(null);
		
		JTabbedPane tabbedPane_client = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_client.setBounds(6, 6, 878, 456);
		panel_client.add(tabbedPane_client);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane_client.addTab("Approve Clients", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_3 = new JLabel("Approve Sample");
		label_3.setFont(new Font("SansSerif", Font.BOLD, 17));
		label_3.setBounds(26, 19, 156, 28);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Approve samples from clients using client ID.");
		label_4.setBounds(25, 53, 287, 16);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Client ID");
		label_5.setBounds(48, 87, 55, 16);
		panel_1.add(label_5);
		
		textField_client_aclientID = new JTextField();
		textField_client_aclientID.setColumns(10);
		textField_client_aclientID.setBounds(104, 81, 148, 28);
		panel_1.add(textField_client_aclientID);
		
		JButton button_client_aaprove = new JButton("Approve");
		button_client_aaprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clientID = textField_client_aclientID.getText();
				int result = 0;
				
				try {
					database = (DatabaseInterface) Client.getLookup().lookup("database");
					database = database.newDatabase();
					
					result = database.insertTempSample(clientID, 1);
					
					Client.getLookup().release(database);
					
				} catch (UnknownHostException | LookupFailedException
						| EstablishConnectionFailed e1) {
					e1.printStackTrace();
				}
				if(result ==1)
					JOptionPane.showMessageDialog(UI_Employee.this, "Client ID:" + clientID + " is approved from sample submission." , "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_client_aaprove.setBounds(104, 124, 90, 28);
		panel_1.add(button_client_aaprove);
		
		JPanel panel_viewclient = new JPanel();
		tabbedPane_client.addTab("View Clients", null, panel_viewclient, null);
		panel_viewclient.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 775, 107);
		panel.setBackground(Color.WHITE);
		panel_viewclient.add(panel);
		panel.setLayout(null);
		
		JLabel lblClients = new JLabel("Clients");
		lblClients.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblClients.setBounds(21, 6, 88, 28);
		panel.add(lblClients);
		
		JLabel lblViewEditSearch = new JLabel("View, Edit Search records of clients registered with CCC.");
		lblViewEditSearch.setBounds(21, 30, 575, 39);
		panel.add(lblViewEditSearch);
		
		JLabel lblViewAll = new JLabel("<html><a href=\"#\">View All</a></html>");
		
		lblViewAll.setBounds(302, 75, 55, 16);
		panel.add(lblViewAll);
		
		JLabel lblUsername = new JLabel("User ID");
		lblUsername.setBounds(21, 75, 72, 16);
		panel.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(84, 69, 122, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch_client = new JButton("Search");
		btnSearch_client.setBounds(218, 69, 72, 28);
		panel.add(btnSearch_client);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 125, 757, 145);
		panel_viewclient.add(scrollPane);
		
		table_clients = new JTable();
		
		
		table_clients.setShowVerticalLines(true);
		table_clients.setShowHorizontalLines(true);
		scrollPane.setViewportView(table_clients);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Personal Details", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(6, 282, 757, 168);
		panel_viewclient.add(panel_7);
		
		JLabel label_6 = new JLabel("Name");
		label_6.setBounds(130, 28, 39, 16);
		panel_7.add(label_6);
		
		JLabel label_7 = new JLabel("Title");
		label_7.setBounds(16, 28, 39, 16);
		panel_7.add(label_7);
		
		textField_client_name = new JTextField();
		textField_client_name.setColumns(10);
		textField_client_name.setBounds(165, 22, 271, 28);
		panel_7.add(textField_client_name);
		
		JComboBox comboBox_client_title = new JComboBox();
		comboBox_client_title.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Ms.", "Mrs."}));
		comboBox_client_title.setBounds(67, 23, 61, 26);
		panel_7.add(comboBox_client_title);
		
		JLabel label_8 = new JLabel("Street");
		label_8.setBounds(16, 61, 55, 16);
		panel_7.add(label_8);
		
		textField_client_street = new JTextField();
		textField_client_street.setColumns(10);
		textField_client_street.setBounds(64, 56, 372, 28);
		panel_7.add(textField_client_street);
		
		JLabel label_9 = new JLabel("City");
		label_9.setBounds(16, 95, 55, 16);
		panel_7.add(label_9);
		
		textField_client_city = new JTextField();
		textField_client_city.setColumns(10);
		textField_client_city.setBounds(64, 89, 183, 28);
		panel_7.add(textField_client_city);
		
		JLabel label_10 = new JLabel("Postcode");
		label_10.setBounds(259, 96, 55, 16);
		panel_7.add(label_10);
		
		textField_client_postcode = new JTextField();
		textField_client_postcode.setColumns(10);
		textField_client_postcode.setBounds(314, 89, 122, 28);
		panel_7.add(textField_client_postcode);
		
		JLabel label_11 = new JLabel("Country");
		label_11.setBounds(448, 61, 55, 16);
		panel_7.add(label_11);
		
		String[] countries = Locale.getISOCountries();
		String[] countryName = new String[countries.length];
		
		for(int i =0; i<countries.length;i++){
			String country = countries[i];
            Locale locale = new Locale("FR", country);
            countryName[i] = locale.getDisplayCountry();
		}
		
		JComboBox comboBox_client_country = new JComboBox(countryName);
		comboBox_client_country.setBounds(505, 56, 135, 26);
		panel_7.add(comboBox_client_country);
		
		JLabel label_12 = new JLabel("Email");
		label_12.setBounds(16, 129, 55, 16);
		panel_7.add(label_12);
		
		textField_client_email = new JTextField();
		textField_client_email.setColumns(10);
		textField_client_email.setBounds(64, 123, 183, 28);
		panel_7.add(textField_client_email);
		
		JLabel label_13 = new JLabel("D.O.B");
		label_13.setBounds(259, 129, 39, 16);
		panel_7.add(label_13);
		
		JDateChooser dateChooser_client_dob = new JDateChooser();
		dateChooser_client_dob.setDateFormatString("dd/MM/yyyy");
		dateChooser_client_dob.setBounds(298, 123, 135, 28);
		panel_7.add(dateChooser_client_dob);
		
		JLabel label_14 = new JLabel("Gender");
		label_14.setBounds(448, 28, 55, 16);
		panel_7.add(label_14);
		
		JComboBox comboBox_client_gender = new JComboBox();
		comboBox_client_gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_client_gender.setBounds(505, 23, 91, 26);
		panel_7.add(comboBox_client_gender);
		
		JLabel label_15 = new JLabel("Phone No");
		label_15.setBounds(448, 95, 55, 16);
		panel_7.add(label_15);
		
		textField_client_phone = new JTextField();
		textField_client_phone.setColumns(10);
		textField_client_phone.setBounds(505, 89, 200, 28);
		panel_7.add(textField_client_phone);
		
		JButton btn_client_edit = new JButton("Edit");
		
		btn_client_edit.setBounds(505, 129, 90, 28);
		panel_7.add(btn_client_edit);
		
		JButton btnDelete_client = new JButton("Delete");
		
		btnDelete_client.setBounds(603, 129, 90, 28);
		panel_7.add(btnDelete_client);
		
		JPanel panel_sample = new JPanel();
		tabbedPane_main.addTab("Sample", new ImageIcon(UI_Employee.class.getResource("/img/SampleVial-Full.png")), panel_sample, null);
		panel_sample.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(6, 6, 878, 456);
		panel_sample.add(tabbedPane);
		
		JPanel panel_sample_approve = new JPanel();
		panel_sample_approve.setBackground(Color.WHITE);
		tabbedPane.addTab("Record Location", null, panel_sample_approve, null);
		panel_sample_approve.setLayout(null);
		
		JLabel lblRecordSampleLocation = new JLabel("Record Sample Location");
		lblRecordSampleLocation.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblRecordSampleLocation.setBounds(21, 18, 204, 23);
		panel_sample_approve.add(lblRecordSampleLocation);
		
		JLabel lblStoreTheThe = new JLabel("Store the the location of both first and second samples.");
		lblStoreTheThe.setBounds(21, 47, 367, 16);
		panel_sample_approve.add(lblStoreTheThe);
		
		JLabel lblSampleType = new JLabel("Sample Type");
		lblSampleType.setBounds(41, 89, 100, 16);
		panel_sample_approve.add(lblSampleType);
		
		JComboBox comboBox_sample_sampleType = new JComboBox();
		
		comboBox_sample_sampleType.setModel(new DefaultComboBoxModel(new String[] {"1st Sample", "2nd Sample"}));
		comboBox_sample_sampleType.setBounds(130, 84, 120, 26);
		panel_sample_approve.add(comboBox_sample_sampleType);
		
		JLabel lblNewLabel = new JLabel("Sample ID");
		lblNewLabel.setBounds(41, 121, 81, 16);
		panel_sample_approve.add(lblNewLabel);
		
		JComboBox comboBox_sample_rsampleID = new JComboBox();
		comboBox_sample_rsampleID.setBounds(130, 116, 192, 26);
		panel_sample_approve.add(comboBox_sample_rsampleID);
		
		JLabel lblDate = new JLabel("Storage Date");
		lblDate.setBounds(41, 161, 87, 16);
		panel_sample_approve.add(lblDate);
		
		JDateChooser dateChooser_sample_rstorDate = new JDateChooser();
		dateChooser_sample_rstorDate.setBounds(130, 151, 192, 28);
		panel_sample_approve.add(dateChooser_sample_rstorDate);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(41, 196, 55, 16);
		panel_sample_approve.add(lblLocation);
		
		JComboBox comboBox_sample_rlocation = new JComboBox();
		comboBox_sample_rlocation.setModel(new DefaultComboBoxModel(new String[] {"Perth"}));
		comboBox_sample_rlocation.setBounds(130, 191, 120, 26);
		panel_sample_approve.add(comboBox_sample_rlocation);
		
		JLabel lblNewLabel_1 = new JLabel("Fridge No");
		lblNewLabel_1.setBounds(41, 232, 55, 16);
		panel_sample_approve.add(lblNewLabel_1);
		
		JComboBox comboBox_sample_rfridge = new JComboBox();
		comboBox_sample_rfridge.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"}));
		comboBox_sample_rfridge.setBounds(130, 227, 120, 26);
		panel_sample_approve.add(comboBox_sample_rfridge);
		
		JLabel lblCscNo = new JLabel("CSC No");
		lblCscNo.setBounds(41, 271, 55, 16);
		panel_sample_approve.add(lblCscNo);
		
		textField_sample_rcscNo = new JTextField();
		textField_sample_rcscNo.setBounds(128, 265, 122, 28);
		panel_sample_approve.add(textField_sample_rcscNo);
		textField_sample_rcscNo.setColumns(10);
		
		JLabel lblCscM = new JLabel("<html>CSC Matrix <br/>Position</html>");
		lblCscM.setBounds(41, 308, 81, 28);
		panel_sample_approve.add(lblCscM);
		
		JComboBox comboBox_sample_rcscmatrix = new JComboBox();
		comboBox_sample_rcscmatrix.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}));
		comboBox_sample_rcscmatrix.setBounds(130, 305, 120, 26);
		panel_sample_approve.add(comboBox_sample_rcscmatrix);
		
		JButton btnSubmit_sample_rsubmit = new JButton("Submit");
		
		btnSubmit_sample_rsubmit.setBounds(130, 362, 90, 28);
		panel_sample_approve.add(btnSubmit_sample_rsubmit);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("View Samples", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		
		JPanel panel_tests = new JPanel();
		tabbedPane_main.addTab("Tests", new ImageIcon(UI_Employee.class.getResource("/img/options-icon.png")), panel_tests, null);
		panel_tests.setLayout(null);
		
		JTabbedPane tabbedPane_test_sub = new JTabbedPane(JTabbedPane.LEFT);
		
		tabbedPane_test_sub.setBounds(6, 6, 878, 456);
		panel_tests.add(tabbedPane_test_sub);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		tabbedPane_test_sub.addTab("Record Test Results", null, panel_8, null);
		panel_8.setLayout(null);
		
		JLabel lblRecordTestResults = new JLabel("Record Test Results");
		lblRecordTestResults.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblRecordTestResults.setBounds(34, 22, 175, 21);
		panel_8.add(lblRecordTestResults);
		
		JLabel lblSampleId = new JLabel("Sample ID");
		lblSampleId.setBounds(44, 65, 97, 16);
		panel_8.add(lblSampleId);
		
		JComboBox comboBox_test_sampleid = new JComboBox();
		comboBox_test_sampleid.setBounds(123, 60, 279, 26);
		panel_8.add(comboBox_test_sampleid);
		
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setBounds(44, 93, 55, 16);
		panel_8.add(lblDate_1);
		
		JDateChooser dateChooser_test_date = new JDateChooser();
		dateChooser_test_date.setBounds(123, 93, 175, 28);
		panel_8.add(dateChooser_test_date);
		
		JTextArea textArea_test_desc = new JTextArea();
		textArea_test_desc.setBounds(123, 133, 279, 71);
		panel_8.add(textArea_test_desc);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(44, 139, 67, 16);
		panel_8.add(lblDescription);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(44, 217, 55, 16);
		panel_8.add(lblResult);
		
		JComboBox comboBox_test_result = new JComboBox();
		comboBox_test_result.setModel(new DefaultComboBoxModel(new String[] {"Pass", "Fail"}));
		comboBox_test_result.setBounds(123, 216, 97, 26);
		panel_8.add(comboBox_test_result);
		
		JButton btnSubmit_test = new JButton("Submit");
		btnSubmit_test.setBounds(123, 271, 90, 28);
		panel_8.add(btnSubmit_test);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_test_sub.addTab("New tab", null, panel_9, null);
		
		JPanel panel_userAcc = new JPanel();
		tabbedPane_main.addTab("User Accounts", new ImageIcon(UI_Employee.class.getResource("/img/users_folder_black.png")), panel_userAcc, null);
		panel_userAcc.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_1.setBounds(6, 6, 878, 456);
		panel_userAcc.add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPane_1.addTab("New Staff", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblCreateNewStaff = new JLabel("Create New Staff Users");
		lblCreateNewStaff.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblCreateNewStaff.setBounds(22, 17, 203, 23);
		panel_4.add(lblCreateNewStaff);
		
		JLabel lblEmployeeid = new JLabel("Employee ID");
		lblEmployeeid.setBounds(32, 58, 88, 16);
		panel_4.add(lblEmployeeid);
		
		textField_ua_empID = new JTextField();
		textField_ua_empID.setBounds(147, 52, 99, 28);
		panel_4.add(textField_ua_empID);
		textField_ua_empID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(32, 98, 71, 16);
		panel_4.add(lblPassword);
		
		passwordField_ua_pass = new JPasswordField();
		passwordField_ua_pass.setBounds(147, 92, 152, 28);
		panel_4.add(passwordField_ua_pass);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(32, 138, 103, 16);
		panel_4.add(lblConfirmPassword);
		
		passwordField_ua_cpass = new JPasswordField();
		passwordField_ua_cpass.setBounds(147, 132, 152, 28);
		panel_4.add(passwordField_ua_cpass);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(32, 177, 55, 16);
		panel_4.add(lblRole);
		
		JComboBox comboBox_ua_role = new JComboBox();
		comboBox_ua_role.setModel(new DefaultComboBoxModel(new String[] {"Client Account Manager", "Lab Technician", "Lab Manager"}));
		comboBox_ua_role.setBounds(147, 172, 162, 26);
		panel_4.add(comboBox_ua_role);
		
		JButton btnRegister_ua = new JButton("Create User");
		btnRegister_ua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String salt = null;
				int result = 0;
				String role = String.valueOf(comboBox_ua_role.getSelectedItem());
				try {
					salt = getSalt();
				} catch (NoSuchAlgorithmException e2) {
					e2.printStackTrace();
				}
		        String password = get_SHA_256_SecurePassword(new String(passwordField_ua_pass.getPassword()), salt);
		        
		        try{
		        	database = (DatabaseInterface) Client.getLookup().lookup("database");
		        	database = database.newDatabase();
		        	
		        	result = database.userRegister(password, salt, role);
		        	
		        	if( result == 1)
			        	JOptionPane.showMessageDialog(UI_Employee.this, "New staff user is created! User ID:" + database.getLastUserID() , "Success", JOptionPane.INFORMATION_MESSAGE);
		        	
		        	Client.getLookup().release(database);
		        } catch (LookupFailedException | EstablishConnectionFailed | UnknownHostException e1) {
					e1.printStackTrace();
				}
		        	
			}
		});
		btnRegister_ua.setBounds(147, 223, 99, 28);
		panel_4.add(btnRegister_ua);
		
		JPanel panel_myAcc = new JPanel();
		tabbedPane_main.addTab("My Account", null, panel_myAcc, null);
		panel_myAcc.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 22, 850, 117);
		panel_myAcc.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UI_Employee.class.getResource("/img/avatarn.png")));
		label.setBounds(17, 6, 100, 100);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Account Details");
		label_1.setFont(new Font("SansSerif", Font.BOLD, 17));
		label_1.setBounds(145, 17, 152, 29);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("You current account details are listed below.");
		label_2.setBounds(145, 46, 282, 16);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(20, 141, 850, 265);
		panel_myAcc.add(panel_3);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseAll();
				UI_Login.run();
			}
		});
		btnNewButton.setBounds(780, 418, 90, 28);
		panel_myAcc.add(btnNewButton);
		
		btnSubmit_sample_rsubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sampleID;
				String sampleNo = "S1";
				String storageDate;
				String location;
				String fridgeNo;
				String cscNo;
				String cscMatrixNo;
				SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
				Date endDate;
				if( comboBox_sample_sampleType.getSelectedIndex() == 0 && comboBox_sample_rsampleID.getSelectedItem() == null )
					JOptionPane.showMessageDialog(UI_Employee.this, "Please select a sample ID" , "Error", JOptionPane.ERROR_MESSAGE);
				else if( comboBox_sample_sampleType.getSelectedIndex() == 1 && comboBox_sample_rsampleID.getSelectedItem() == null )
					JOptionPane.showMessageDialog(UI_Employee.this, "Please select a sample ID" , "Error", JOptionPane.ERROR_MESSAGE);
				else {
					storageDate = f.format(dateChooser_sample_rstorDate.getDate());
					location = "PER";
					fridgeNo = "F" + String.valueOf(comboBox_sample_rfridge.getSelectedItem());
					cscNo = "CSC" + textField_sample_rcscNo.getText();
					cscMatrixNo = String.valueOf(comboBox_sample_rcscmatrix.getSelectedItem());
					
					if( comboBox_sample_sampleType.getSelectedIndex() == 1)
						sampleNo = "S2";
					
					sampleID = sampleNo + "-" + storageDate + "-" + location + "-" + fridgeNo + "-" + cscNo + "-" + cscMatrixNo;
					
					endDate = addDays(dateChooser_sample_rstorDate.getDate(), 365);
					
					try {
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						sample = (SampleInterface) Client.getLookup().lookup("sample");
						sample = sample.newSample();
						
						sample.setSampleID(sampleID);
						sample.setStorageDate(dateChooser_sample_rstorDate.getDate());
						sample.setEndDate(endDate);
						sample.setStatus("storage");
						sample.setCertifiedBy(userID);
						
						sample.updateSampleID(String.valueOf(comboBox_sample_rsampleID.getSelectedItem()));
						
						database.updateCollectionPointSampleID(sampleID, String.valueOf(comboBox_sample_rsampleID.getSelectedItem()));
						
						
						invoice =  (InvoiceInterface) Client.getLookup().lookup("invoice");
						invoice = invoice.newInvoice();
						
						invoice.setInovoiceDate(dateChooser_sample_rstorDate.getDate());
						invoice.setDueDate(addDays(dateChooser_sample_rstorDate.getDate(), 30));
						invoice.setTotal(225.00);
						invoice.setStatus("unpaid");
						invoice.savetoDB( String.valueOf(comboBox_sample_rsampleID.getSelectedItem()).substring(4), sampleID );
						
						Client.getLookup().release(invoice);
						Client.getLookup().release(database);
						Client.getLookup().release(sample);
						
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		
		comboBox_sample_sampleType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( comboBox_sample_sampleType.getSelectedIndex() == 0){
					try {
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						if( comboBox_sample_rsampleID.getItemCount() == 0)
							for(String s : database.getSampleStatus("transit", 1))
								comboBox_sample_rsampleID.addItem(s);
						
						Client.getLookup().release(database);
						
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						
						e1.printStackTrace();
					}
					
					
					
				}
				
				
				
				if( comboBox_sample_sampleType.getSelectedIndex() == 1){
					try {
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						if( comboBox_sample_rsampleID.getItemCount() == 0)
							for(String s : database.getSampleStatus("transit", 2))
								comboBox_sample_rsampleID.addItem(s);
						
						Client.getLookup().release(database);
						
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						
						e1.printStackTrace();
					}
					
					
					
				}
				
			}
		});
		
		lblViewAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					database = (DatabaseInterface) Client.getLookup().lookup("database");
					database = database.newDatabase();
				
					table_clients.setModel(database.getAllCustomers());
					
					Client.getLookup().release(database);
				} catch (UnknownHostException | LookupFailedException
						| EstablishConnectionFailed e1) {
					e1.printStackTrace();
				}
			}
		});
		
		table_clients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{
					int row = table_clients.getSelectedRow();
					String table_click =  table_clients.getModel().getValueAt(row, 0).toString();
					
					database = (DatabaseInterface) Client.getLookup().lookup("database");
					database = database.newDatabase();
					customer = (CustomerInterface) Client.getLookup().lookup("customer");
					customer = customer.newCustomer();
					address = (AddressInterface) Client.getLookup().lookup("address");
					address = address.newAdddress();
					
					customer = database.getCustomer(table_click);
					address = customer.getAddress();
					
					comboBox_client_title.setSelectedItem(customer.getTitle());
					textField_client_name.setText(customer.getName());
					comboBox_client_gender.setSelectedItem(customer.getGender());
					comboBox_client_country.setSelectedItem(address.getCountry());
					textField_client_street.setText(address.getStreet());
					textField_client_city.setText(address.getCity());
					textField_client_postcode.setText(address.getPostcode());
					textField_client_phone.setText( customer.getPhoneNo() );
					textField_client_email.setText(customer.getEmail());
					dateChooser_client_dob.setDate( customer.getDob() );
					
					Client.getLookup().release(database);
					Client.getLookup().release(customer);
					Client.getLookup().release(address);
			
				} catch (UnknownHostException | LookupFailedException
						| EstablishConnectionFailed e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnDelete_client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedOption = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to delete this record?", 
                        "Confirm", 
                        JOptionPane.YES_NO_OPTION); 
				
				if (selectedOption == JOptionPane.YES_OPTION) {
				    
					try {
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						int row = table_clients.getSelectedRow();
						String table_click =  table_clients.getModel().getValueAt(row, 0).toString();
						
						int result = database.deleteCustomer(table_click);
						
						if( result == 1)
							JOptionPane.showMessageDialog(UI_Employee.this, 
			                        "Record clientID:" +table_click+ " deleted from database.", 
			                        "Success", 
			                        JOptionPane.INFORMATION_MESSAGE); 
						
						Client.getLookup().release(database);
						
						Client.getLookup().release(database);
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		btn_client_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = String.valueOf( comboBox_client_title.getSelectedItem() );
				String name = textField_client_name.getText();
				String street = textField_client_street.getText();
				String city = textField_client_city.getText();
				String postcode = textField_client_postcode.getText();
				String country = String.valueOf( comboBox_client_country.getSelectedItem() );
				String email = textField_client_email.getText();
				Date dob = dateChooser_client_dob.getDate();
				String gender = String.valueOf( comboBox_client_gender.getSelectedItem() );
				String phoneNo = textField_client_phone.getText();
				
				try{
					customer = (CustomerInterface) Client.getLookup().lookup("customer");
					customer = customer.newCustomer();
					
					customer.setTitle(title);
					customer.setName(name);
					customer.setAddress(street, city, postcode, country);
					customer.setEmail(email);
					customer.setDob(dob);
					customer.setGender(gender);
					customer.setPhoneNo(phoneNo);
					
					int row = table_clients.getSelectedRow();
					String table_click =  table_clients.getModel().getValueAt(row, 0).toString();
					
					int result = customer.editCustomerDB(table_click);
					
					if( result == 1)
						JOptionPane.showMessageDialog(UI_Employee.this, 
		                        "Record clientID:" +table_click+ " updated.", 
		                        "Success", 
		                        JOptionPane.INFORMATION_MESSAGE); 
					
					Client.getLookup().release(customer);
					
				} catch (UnknownHostException | LookupFailedException
						| EstablishConnectionFailed e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		tabbedPane_test_sub.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				if( tabbedPane_test_sub.getSelectedIndex() == 1){
					
					String[] sampleID = null;
					try{
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						sampleID = database.getSampleByStatus("storage");
						
						if( comboBox_test_sampleid.getItemCount() == 0)
							for(String s : sampleID)
								comboBox_test_sampleid.addItem(s);
						
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						e1.printStackTrace();
					}
				}
			}});
		
		if( role.equalsIgnoreCase("Client Account Manager")){
			tabbedPane_main.setEnabledAt(2, false);
			tabbedPane_main.setEnabledAt(3, false);
			tabbedPane_main.setEnabledAt(4, false);
		}
	}
	
	
	
	
	
	public static void run(){
		new UI_Employee().setVisible(true);
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
	 
	 public Date addDays(Date date, int days)
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days);
	        return cal.getTime();
	    }
	 
	public void CloseAll()
	{
			System.gc();  
			java.awt.Window win[] = java.awt.Window.getWindows();   
			for(int i=0;i<win.length;i++){   
			    win[i].dispose();   
			    win[i]=null; 
			}
	}
}
