

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.Component;

import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.net.UnknownHostException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerDateModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;

import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class UI_Customer extends JFrame {
	private JTextField txt_new_sup_name;
	private JTextField txt_new_sup_email;
	private JTextField txt_new_sup_subject;
	
	public static String userID;
	private JTextField textField_sample_cname;
	private JTextField textField_sample_cstreet;
	private JTextField textField_sample_city;
	private JTextField textField_sample_cpostcode;
	private JTextField textField_sample_ccourierfirm;
	private JTextField textField_sample_2name;
	private JTextField textField_sample_2street;
	private JTextField textField_sample_2city;
	private JTextField textField_sample_2postcode;
	private JTextField textField_sample_2cfirm;
	private JPanel panel_2;
	private JTextField textField_sample_cardNo;
	
	private CustomerInterface customer;
	private DatabaseInterface database;
	private CollectionPointInterface collectionPoint;
	private PaymentInterface payment;
	private SampleInterface sample;
	private AddressInterface address;
	private JTable table_paymentDetails;
	private JTable table_allSamples;
	
	public UI_Customer() {
		setForeground(Color.GRAY);
		setFocusable(false);
		setTitle("Customer - Cryo Cell Coporation [id:" + userID + "]");
		setVisible(true);
		setSize(new Dimension(906, 586));
		setBackground(SystemColor.desktop);
		
		JLabel lbl_ad_title = new JLabel("Title");
		JLabel lbl_ad_name = new JLabel("Name");
		JLabel lbl_ad_userID = new JLabel("Username");
		JLabel lbl_ad_phone = new JLabel("Phone");
		JLabel lbl_ad_address = new JLabel("Address");
		JLabel lbl_ad_city = new JLabel("City");
		JLabel lbl_ad_postcode = new JLabel("Postcode");
		JLabel lbl_ad_country = new JLabel("Country");
		JLabel lbl_ad_email = new JLabel("Email");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBackground(Color.DARK_GRAY);
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel panel_dashboard = new JPanel();
		panel_dashboard.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		panel_dashboard.setSize(new Dimension(10, 10));
		panel_dashboard.setMinimumSize(new Dimension(5, 5));
		panel_dashboard.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_dashboard.setFocusable(false);
		panel_dashboard.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_dashboard.setForeground(SystemColor.desktop);
		tabbedPane.addTab("Dashboard", new ImageIcon(UI_Customer.class.getResource("/img/dashboard.png")), panel_dashboard, null);
		panel_dashboard.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_11.setBackground(SystemColor.textHighlight);
		panel_11.setBounds(24, 30, 838, 75);
		panel_dashboard.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblYouHaveSubmitted = new JLabel("You have submitted 2 Sample to CCC.");
		lblYouHaveSubmitted.setForeground(SystemColor.text);
		lblYouHaveSubmitted.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblYouHaveSubmitted.setBounds(29, 16, 382, 35);
		panel_11.add(lblYouHaveSubmitted);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_12.setBackground(SystemColor.textHighlight);
		panel_12.setBounds(24, 145, 838, 75);
		panel_dashboard.add(panel_12);
		
		JLabel label_7 = new JLabel("You have submitted 2 Sample to CCC.");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("SansSerif", Font.BOLD, 20));
		label_7.setBounds(29, 16, 382, 35);
		panel_12.add(label_7);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_13.setBackground(SystemColor.textHighlight);
		panel_13.setBounds(24, 256, 838, 75);
		panel_dashboard.add(panel_13);
		
		JLabel label_8 = new JLabel("You have submitted 2 Sample to CCC.");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("SansSerif", Font.BOLD, 20));
		label_8.setBounds(29, 16, 382, 35);
		panel_13.add(label_8);
		tabbedPane.setForegroundAt(0, SystemColor.textHighlight);
		tabbedPane.setBackgroundAt(0, SystemColor.desktop);
		
		JPanel panel_sample = new JPanel();
		tabbedPane.addTab("Sample", null, panel_sample, null);
		panel_sample.setLayout(null);
		
		JTabbedPane tabbedPane_sample_new = new JTabbedPane(JTabbedPane.LEFT);
		
		tabbedPane_sample_new.setBackground(SystemColor.inactiveCaption);
		tabbedPane_sample_new.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane_sample_new.setBounds(0, 13, 873, 454);
		panel_sample.add(tabbedPane_sample_new);
		
		JPanel panel_sample_new = new JPanel();
		panel_sample_new.setBackground(Color.WHITE);
		tabbedPane_sample_new.addTab("New Sample", null, panel_sample_new, null);
		panel_sample_new.setLayout(null);
		
		JLabel label_27 = new JLabel("<html><p>Cryo Cell Corporation wants their customers to take an on-line questionaire whether the sample to be stored is at risk from various infectious diseases.</p><br/><p>Please take a look at our <a href=\"http:google.com/\">terms and condtions</a> before taking the questionaire.</p>\r\n<br />\r\nOnline Questionaire - <a href=\"http://bit.ly/cccquestionaire\">http://bit.ly/cccquestionaire</a>\r\n\r\n</html>");
		label_27.setBounds(6, 36, 699, 119);
		panel_sample_new.add(label_27);
		
		JLabel label_28 = new JLabel("New Sample");
		label_28.setFont(new Font("SansSerif", Font.BOLD, 17));
		label_28.setBounds(6, 6, 114, 30);
		panel_sample_new.add(label_28);
		
		JPanel panel_sample_first = new JPanel();
		panel_sample_first.setBackground(Color.WHITE);
		tabbedPane_sample_new.addTab("Submit 1st \r\nSample", null, panel_sample_first, null);
		panel_sample_first.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New Sample");
		lblNewLabel_3.setBounds(21, 6, 114, 30);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 17));
		panel_sample_first.add(lblNewLabel_3);
		
		JPanel panel_sample_sample = new JPanel();
		panel_sample_sample.setBorder(new TitledBorder(null, "Sample", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_sample_sample.setBackground(Color.WHITE);
		panel_sample_sample.setBounds(21, 48, 530, 72);
		panel_sample_first.add(panel_sample_sample);
		panel_sample_sample.setLayout(null);
		
		JLabel lblSampleReferenceId = new JLabel("Sample Reference ID:");
		lblSampleReferenceId.setBounds(23, 27, 126, 16);
		panel_sample_sample.add(lblSampleReferenceId);
		
		JComboBox comboBox_sample_tempID = new JComboBox();
		comboBox_sample_tempID.setBounds(147, 22, 83, 26);
		panel_sample_sample.add(comboBox_sample_tempID);
		
		JLabel lbl_sample_msg = new JLabel("No accepted samples with pending submission.");
		lbl_sample_msg.setForeground(Color.RED);
		lbl_sample_msg.setBounds(244, 27, 266, 16);
		panel_sample_sample.add(lbl_sample_msg);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Collection Point", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(21, 123, 530, 196);
		panel_sample_first.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setBounds(24, 28, 55, 16);
		panel_6.add(lblName_2);
		
		textField_sample_cname = new JTextField();
		textField_sample_cname.setBounds(72, 22, 159, 28);
		panel_6.add(textField_sample_cname);
		textField_sample_cname.setColumns(10);
		
		JLabel label_1 = new JLabel("Street");
		label_1.setBounds(24, 61, 55, 16);
		panel_6.add(label_1);
		
		textField_sample_cstreet = new JTextField();
		textField_sample_cstreet.setColumns(10);
		textField_sample_cstreet.setBounds(72, 56, 422, 28);
		panel_6.add(textField_sample_cstreet);
		
		JLabel label_2 = new JLabel("City");
		label_2.setBounds(24, 95, 55, 16);
		panel_6.add(label_2);
		
		textField_sample_city = new JTextField();
		textField_sample_city.setColumns(10);
		textField_sample_city.setBounds(72, 89, 183, 28);
		panel_6.add(textField_sample_city);
		
		JLabel label_4 = new JLabel("Postcode");
		label_4.setBounds(267, 96, 55, 16);
		panel_6.add(label_4);
		
		textField_sample_cpostcode = new JTextField();
		textField_sample_cpostcode.setColumns(10);
		textField_sample_cpostcode.setBounds(344, 89, 150, 28);
		panel_6.add(textField_sample_cpostcode);
		
		String[] countries = Locale.getISOCountries();
		String[] countryName = new String[countries.length];
		
		for(int i =0; i<countries.length;i++){
			String country = countries[i];
            Locale locale = new Locale("FR", country);
            countryName[i] = locale.getDisplayCountry();
		}
		
		JComboBox comboBox_sample_ccountry = new JComboBox(countryName);
		comboBox_sample_ccountry.setBounds(72, 118, 183, 26);
		panel_6.add(comboBox_sample_ccountry);
		
		JLabel label_6 = new JLabel("Country");
		label_6.setBounds(24, 123, 55, 16);
		panel_6.add(label_6);
		
		JDateChooser dateChooser_sample_cdate = new JDateChooser();
		dateChooser_sample_cdate.setBounds(344, 118, 150, 28);
		panel_6.add(dateChooser_sample_cdate);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(267, 124, 55, 16);
		panel_6.add(lblDate);
		
		JSpinner spinner_sample_ctime = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner_sample_ctime, "HH:mm:ss");
		spinner_sample_ctime.setEditor(timeEditor);
		spinner_sample_ctime.setValue(new Date());
		spinner_sample_ctime.setBounds(72, 150, 109, 28);
		panel_6.add(spinner_sample_ctime);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(24, 156, 55, 16);
		panel_6.add(lblTime);
		
		JLabel lblCourierFirm = new JLabel("Courier firm");
		lblCourierFirm.setBounds(267, 156, 77, 16);
		panel_6.add(lblCourierFirm);
		
		textField_sample_ccourierfirm = new JTextField();
		textField_sample_ccourierfirm.setBounds(344, 150, 150, 28);
		panel_6.add(textField_sample_ccourierfirm);
		textField_sample_ccourierfirm.setColumns(10);
		
		JButton btnSubmit_sample_1st = new JButton("Submit");
		
		btnSubmit_sample_1st.setBounds(563, 395, 90, 28);
		panel_sample_first.add(btnSubmit_sample_1st);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBorder(new TitledBorder(null, "Payment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(21, 331, 530, 100);
		panel_sample_first.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblCardType = new JLabel("Card Type");
		lblCardType.setBounds(18, 24, 73, 16);
		panel_9.add(lblCardType);
		
		JComboBox comboBox_sample_card = new JComboBox();
		comboBox_sample_card.setModel(new DefaultComboBoxModel(new String[] {"MasterCard", "Visa"}));
		comboBox_sample_card.setBounds(103, 19, 105, 26);
		panel_9.add(comboBox_sample_card);
		
		JLabel lblNewLabel_4 = new JLabel("Card Number");
		lblNewLabel_4.setBounds(226, 24, 86, 16);
		panel_9.add(lblNewLabel_4);
		
		textField_sample_cardNo = new JTextField();
		textField_sample_cardNo.setBounds(307, 18, 184, 28);
		panel_9.add(textField_sample_cardNo);
		textField_sample_cardNo.setColumns(10);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setBounds(18, 52, 83, 16);
		panel_9.add(lblExpirationDate);
		
		JDateChooser dateChooser_sample_cardExp = new JDateChooser();
		dateChooser_sample_cardExp.setBounds(103, 52, 144, 28);
		panel_9.add(dateChooser_sample_cardExp);
		
		JLabel lblPaymentPlan = new JLabel("Payment Plan");
		lblPaymentPlan.setBounds(259, 52, 86, 16);
		panel_9.add(lblPaymentPlan);
		
		JComboBox comboBox_sample_pplan = new JComboBox();
		comboBox_sample_pplan.setModel(new DefaultComboBoxModel(new String[] {"Full Payment", "4 Instalments"}));
		comboBox_sample_pplan.setBounds(341, 47, 150, 26);
		panel_9.add(comboBox_sample_pplan);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane_sample_new.addTab("Submit 2nd Sample", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblndSample = new JLabel("2nd Sample");
		lblndSample.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblndSample.setBounds(6, 6, 114, 30);
		panel_5.add(lblndSample);
		
		JLabel lblYouCanSubmit = new JLabel("You can submit second sample after six months of first sample submission.");
		lblYouCanSubmit.setBounds(6, 36, 699, 46);
		panel_5.add(lblYouCanSubmit);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null, "Sample", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(6, 94, 530, 72);
		panel_5.add(panel_7);
		
		JLabel lblFirstSampleId = new JLabel("First Sample ID:");
		lblFirstSampleId.setBounds(23, 27, 126, 16);
		panel_7.add(lblFirstSampleId);
		
		JComboBox comboBox_sample_2sampleId = new JComboBox();
		comboBox_sample_2sampleId.setBounds(114, 22, 228, 26);
		panel_7.add(comboBox_sample_2sampleId);
		
		JLabel lbl_sample_2msg = new JLabel("No existing samples.");
		lbl_sample_2msg.setForeground(Color.RED);
		lbl_sample_2msg.setBounds(357, 27, 153, 16);
		panel_7.add(lbl_sample_2msg);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "Collection Point", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(6, 178, 530, 196);
		panel_5.add(panel_8);
		
		JLabel label_10 = new JLabel("Name");
		label_10.setBounds(24, 28, 55, 16);
		panel_8.add(label_10);
		
		textField_sample_2name = new JTextField();
		textField_sample_2name.setColumns(10);
		textField_sample_2name.setBounds(72, 22, 159, 28);
		panel_8.add(textField_sample_2name);
		
		JLabel label_11 = new JLabel("Street");
		label_11.setBounds(24, 61, 55, 16);
		panel_8.add(label_11);
		
		textField_sample_2street = new JTextField();
		textField_sample_2street.setColumns(10);
		textField_sample_2street.setBounds(72, 56, 422, 28);
		panel_8.add(textField_sample_2street);
		
		JLabel label_12 = new JLabel("City");
		label_12.setBounds(24, 95, 55, 16);
		panel_8.add(label_12);
		
		textField_sample_2city = new JTextField();
		textField_sample_2city.setColumns(10);
		textField_sample_2city.setBounds(72, 89, 183, 28);
		panel_8.add(textField_sample_2city);
		
		JLabel label_13 = new JLabel("Postcode");
		label_13.setBounds(267, 96, 55, 16);
		panel_8.add(label_13);
		
		textField_sample_2postcode = new JTextField();
		textField_sample_2postcode.setColumns(10);
		textField_sample_2postcode.setBounds(344, 89, 150, 28);
		panel_8.add(textField_sample_2postcode);
		
		
		JComboBox comboBox_sample_2country = new JComboBox(countryName);
		comboBox_sample_2country.setBounds(72, 118, 183, 26);
		panel_8.add(comboBox_sample_2country);
		
		JLabel label_14 = new JLabel("Country");
		label_14.setBounds(24, 123, 55, 16);
		panel_8.add(label_14);
		
		JDateChooser dateChooser_sample_2date = new JDateChooser();
		dateChooser_sample_2date.setBounds(344, 118, 150, 28);
		panel_8.add(dateChooser_sample_2date);
		
		JLabel label_15 = new JLabel("Date");
		label_15.setBounds(267, 124, 55, 16);
		panel_8.add(label_15);
		
		JSpinner spinner_sample_2time = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor de_spinner_sample_2time = new JSpinner.DateEditor(spinner_sample_2time, "HH:mm:ss");
		spinner_sample_2time.setEditor(de_spinner_sample_2time);
		spinner_sample_2time.setValue(new Date());
		spinner_sample_2time.setBounds(72, 150, 109, 28);
		panel_8.add(spinner_sample_2time);
		
		JLabel label_16 = new JLabel("Time");
		label_16.setBounds(24, 156, 55, 16);
		panel_8.add(label_16);
		
		JLabel label_17 = new JLabel("Courier firm");
		label_17.setBounds(267, 156, 77, 16);
		panel_8.add(label_17);
		
		textField_sample_2cfirm = new JTextField();
		textField_sample_2cfirm.setColumns(10);
		textField_sample_2cfirm.setBounds(344, 150, 150, 28);
		panel_8.add(textField_sample_2cfirm);
		
		JButton button_sample_2submit = new JButton("Submit");
		
		button_sample_2submit.setBounds(446, 386, 90, 28);
		panel_5.add(button_sample_2submit);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane_sample_new.addTab("View Samples", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnViewMySamples = new JButton("View My Samples");
		btnViewMySamples.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewMySamples.setBounds(25, 16, 126, 28);
		panel_2.add(btnViewMySamples);
		
		JScrollPane scrollPane_sample_view = new JScrollPane();
		scrollPane_sample_view.setBounds(25, 72, 699, 144);
		panel_2.add(scrollPane_sample_view);
		
		table_allSamples = new JTable();
		scrollPane_sample_view.setViewportView(table_allSamples);
		
		JPanel panel_payment = new JPanel();
		tabbedPane.addTab("Payment", null, panel_payment, null);
		panel_payment.setLayout(null);
		
		JTabbedPane tabbedPane_payment_sub = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_payment_sub.setBounds(6, 6, 878, 466);
		panel_payment.add(tabbedPane_payment_sub);
		
		JPanel panel_payment_details = new JPanel();
		panel_payment_details.setBackground(Color.WHITE);
		tabbedPane_payment_sub.addTab("View Payment Details", null, panel_payment_details, null);
		panel_payment_details.setLayout(null);
		
		JLabel lblViewPaymentDetails = new JLabel("View Payment Details");
		lblViewPaymentDetails.setBounds(30, 23, 197, 23);
		lblViewPaymentDetails.setFont(new Font("SansSerif", Font.BOLD, 17));
		panel_payment_details.add(lblViewPaymentDetails);
		
		JButton btnPaymentDetails = new JButton("Payment Details");
		
		btnPaymentDetails.setBounds(40, 58, 118, 28);
		panel_payment_details.add(btnPaymentDetails);
		
		JScrollPane scrollPane_payment_details = new JScrollPane();
		scrollPane_payment_details.setBounds(6, 113, 724, 125);
		panel_payment_details.add(scrollPane_payment_details);
		
		table_paymentDetails = new JTable();
		scrollPane_payment_details.setViewportView(table_paymentDetails);
		
		JPanel panel_payment_invoices = new JPanel();
		panel_payment_invoices.setBackground(Color.WHITE);
		tabbedPane_payment_sub.addTab("View Invoices", null, panel_payment_invoices, null);
		//tabbedPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel_dashboard, panel_myAccount, btnLogout, panel, label, lblAccountDetails, lblYouCurrentAccount, panel_1, panel_Settings, panel_support, scrollPane, tabbedPane_2, panel_newSupport, lblOpenTicket, lblNewLabel, lblName, txt_new_sup_name, lblEmail, txt_new_sup_email, lblSubject, txt_new_sup_subject, lblDepartment, comboBox_newsup_dept, lblNewLabel_1, comboBox_newsup_rsample, lblPriority, comboBox_newsup_priority, lblNewLabel_2, textArea_newsup_msg, btn_newsup_Submit, btn_newsup_Clear, panel_viewTicket, panel_sentItems, panel_requestCancel, panel_payment, panel_sample, tabbedPane_sample_new, panel_6, lblNewLabel_3, lblNewLabel_4, panel_5, panel_2}));
		
		JPanel panel_support = new JPanel();
		tabbedPane.addTab("Support", null, panel_support, null);
		panel_support.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(442, 5, 6, 6);
		panel_support.add(scrollPane);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_2.setBackground(Color.WHITE);
		tabbedPane_2.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane_2.setBounds(6, 20, 862, 446);
		panel_support.add(tabbedPane_2);
		
		JPanel panel_newSupport = new JPanel();
		panel_newSupport.setBackground(Color.WHITE);
		tabbedPane_2.addTab("New Support Ticket", null, panel_newSupport, null);
		panel_newSupport.setLayout(null);
		
		JLabel lblOpenTicket = new JLabel("Open Ticket");
		lblOpenTicket.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblOpenTicket.setBounds(26, 17, 112, 31);
		panel_newSupport.add(lblOpenTicket);
		
		JLabel lblNewLabel = new JLabel("If you can't find a solution to your problems, you can submit a ticket by selecting the appropriate options below.");
		lblNewLabel.setBounds(26, 52, 610, 16);
		panel_newSupport.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName.setBounds(26, 90, 55, 16);
		panel_newSupport.add(lblName);
		
		txt_new_sup_name = new JTextField();
		txt_new_sup_name.setBounds(26, 107, 217, 28);
		panel_newSupport.add(txt_new_sup_name);
		txt_new_sup_name.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEmail.setBounds(366, 90, 55, 16);
		panel_newSupport.add(lblEmail);
		
		txt_new_sup_email = new JTextField();
		txt_new_sup_email.setBounds(366, 107, 205, 28);
		panel_newSupport.add(txt_new_sup_email);
		txt_new_sup_email.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSubject.setBounds(26, 147, 55, 16);
		panel_newSupport.add(lblSubject);
		
		txt_new_sup_subject = new JTextField();
		txt_new_sup_subject.setBounds(26, 164, 344, 28);
		panel_newSupport.add(txt_new_sup_subject);
		txt_new_sup_subject.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDepartment.setBounds(26, 207, 86, 16);
		panel_newSupport.add(lblDepartment);
		
		JComboBox comboBox_newsup_dept = new JComboBox();
		comboBox_newsup_dept.setModel(new DefaultComboBoxModel(new String[] {"Payment Related", "General Enquiry", "Need any other Help"}));
		comboBox_newsup_dept.setBounds(26, 225, 173, 26);
		panel_newSupport.add(comboBox_newsup_dept);
		
		JLabel lblNewLabel_1 = new JLabel("Related Sample");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1.setBounds(282, 207, 99, 16);
		panel_newSupport.add(lblNewLabel_1);
		
		JComboBox comboBox_newsup_rsample = new JComboBox();
		comboBox_newsup_rsample.setBounds(282, 225, 157, 26);
		panel_newSupport.add(comboBox_newsup_rsample);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPriority.setBounds(505, 207, 55, 16);
		panel_newSupport.add(lblPriority);
		
		JComboBox comboBox_newsup_priority = new JComboBox();
		comboBox_newsup_priority.setModel(new DefaultComboBoxModel(new String[] {"High", "Medium", "Low"}));
		comboBox_newsup_priority.setBounds(505, 225, 78, 26);
		panel_newSupport.add(comboBox_newsup_priority);
		
		JLabel lblNewLabel_2 = new JLabel("Message");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_2.setBounds(26, 271, 112, 16);
		panel_newSupport.add(lblNewLabel_2);
		
		JTextArea textArea_newsup_msg = new JTextArea();
		textArea_newsup_msg.setBounds(26, 290, 459, 138);
		panel_newSupport.add(textArea_newsup_msg);
		
		JButton btn_newsup_Submit = new JButton("Submit");
		btn_newsup_Submit.setBounds(505, 290, 90, 28);
		panel_newSupport.add(btn_newsup_Submit);
		
		JButton btn_newsup_Clear = new JButton("Clear");
		btn_newsup_Clear.setBounds(505, 322, 90, 28);
		panel_newSupport.add(btn_newsup_Clear);
		
		JPanel panel_viewTicket = new JPanel();
		panel_viewTicket.setBackground(Color.WHITE);
		tabbedPane_2.addTab("View Tickets", null, panel_viewTicket, null);
		
		JPanel panel_sentItems = new JPanel();
		panel_sentItems.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Sent Items", null, panel_sentItems, null);
		
		JPanel panel_requestCancel = new JPanel();
		panel_requestCancel.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Request Cancelation", null, panel_requestCancel, null);
		tabbedPane_2.setForegroundAt(3, Color.RED);
		tabbedPane_2.setBackgroundAt(3, Color.BLACK);
		
		JPanel panel_Settings = new JPanel();
		tabbedPane.addTab("Settings", null, panel_Settings, null);
		panel_Settings.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(445, 5, 0, 0);
		panel_Settings.add(tabbedPane_1);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_3.setBounds(6, 6, 878, 462);
		panel_Settings.add(tabbedPane_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		tabbedPane_3.addTab("General", null, panel_10, null);
		panel_10.setLayout(null);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setBounds(40, 32, 74, 16);
		panel_10.add(lblLanguage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"English", "Spanish", "Mandarin"}));
		comboBox.setBounds(103, 27, 157, 26);
		panel_10.add(comboBox);
		
		JButton btnChange = new JButton("Change");
		btnChange.setBounds(113, 72, 90, 28);
		panel_10.add(btnChange);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
		);
		
		
		JPanel panel_myAccount = new JPanel();
		panel_myAccount.setEnabled(false);
		tabbedPane.addTab("My Account", null, panel_myAccount, null);
		panel_myAccount.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(19, 27, 850, 117);
		panel_myAccount.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UI_Customer.class.getResource("/img/avatarn.png")));
		label.setBounds(17, 6, 100, 100);
		panel.add(label);
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		lblAccountDetails.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblAccountDetails.setBounds(145, 17, 152, 29);
		panel.add(lblAccountDetails);
		
		JLabel lblYouCurrentAccount = new JLabel("You current account details are listed below.");
		lblYouCurrentAccount.setBounds(145, 46, 282, 16);
		panel.add(lblYouCurrentAccount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(19, 146, 850, 304);
		panel_myAccount.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "General Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(6, 6, 684, 139);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTitle.setBounds(21, 27, 55, 16);
		panel_3.add(lblTitle);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_5.setBounds(21, 72, 72, 16);
		panel_3.add(lblNewLabel_5);
		
		lbl_ad_title.setBounds(105, 27, 55, 16);
		panel_3.add(lbl_ad_title);
		
		JLabel label_3 = new JLabel("*****");
		label_3.setBounds(105, 72, 72, 16);
		panel_3.add(label_3);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName_1.setBounds(325, 27, 55, 16);
		panel_3.add(lblName_1);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPhone.setBounds(325, 49, 55, 16);
		panel_3.add(lblPhone);
		
		lbl_ad_name.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbl_ad_name.setBounds(406, 27, 247, 16);
		panel_3.add(lbl_ad_name);
		
		
		lbl_ad_phone.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbl_ad_phone.setBounds(406, 49, 155, 16);
		panel_3.add(lbl_ad_phone);
		
		JLabel lblUsername = new JLabel("User ID");
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblUsername.setBounds(21, 49, 72, 16);
		panel_3.add(lblUsername);
		
		lbl_ad_userID.setBounds(105, 49, 84, 16);
		panel_3.add(lbl_ad_userID);
		
		JButton btn_ad_changePass = new JButton("Change Password");
		btn_ad_changePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UI_PasswordChange().setVisible(true);
			}
		});
		btn_ad_changePass.setBounds(104, 88, 131, 28);
		panel_3.add(btn_ad_changePass);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAge.setBounds(325, 72, 55, 16);
		panel_3.add(lblAge);
		
		JLabel lbl_ad_age = new JLabel("Age");
		lbl_ad_age.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbl_ad_age.setBounds(406, 72, 55, 16);
		panel_3.add(lbl_ad_age);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Contact Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(6, 157, 684, 120);
		panel_1.add(panel_4);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAddress.setBounds(21, 27, 55, 16);
		panel_4.add(lblAddress);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		label_5.setBounds(21, 49, 55, 16);
		panel_4.add(label_5);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPostcode.setBounds(21, 72, 72, 16);
		panel_4.add(lblPostcode);
		
		lbl_ad_address.setBounds(105, 27, 178, 16);
		panel_4.add(lbl_ad_address);
		
		lbl_ad_email.setBounds(105, 49, 178, 16);
		panel_4.add(lbl_ad_email);
		
		lbl_ad_postcode.setBounds(105, 72, 87, 16);
		panel_4.add(lbl_ad_postcode);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCity.setBounds(325, 27, 55, 16);
		panel_4.add(lblCity);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCountry.setBounds(325, 49, 55, 16);
		panel_4.add(lblCountry);
		
		lbl_ad_city.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbl_ad_city.setBounds(406, 27, 153, 16);
		panel_4.add(lbl_ad_city);
		
		lbl_ad_country.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lbl_ad_country.setBounds(406, 49, 153, 16);
		panel_4.add(lbl_ad_country);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseAll();
				UI_Login.run();
			}
		});
		btnLogout.setBounds(737, 269, 95, 25);
		panel_1.add(btnLogout);
		getContentPane().setLayout(groupLayout);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedIndex() == 5 ){
					
					try {
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						customer = (CustomerInterface) Client.getLookup().lookup("customer");
						customer = customer.newCustomer();
						
						address=  (AddressInterface) Client.getLookup().lookup("address");
						address= address.newAdddress();
						
						customer = database.getCustomer(userID);
						address = customer.getAddress();
						
						lbl_ad_title.setText( customer.getTitle() );
						lbl_ad_name.setText( customer.getName() );
						lbl_ad_userID.setText( userID );
						lbl_ad_phone.setText( customer.getPhoneNo() );
						lbl_ad_address.setText( address.getStreet());
						lbl_ad_city.setText( address.getCity() );
						lbl_ad_postcode.setText( address.getPostcode() );
						lbl_ad_country.setText( address.getCountry() );
						lbl_ad_email.setText(customer.getEmail() );
						
						Client.getLookup().release(customer);
						Client.getLookup().release(database);
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		tabbedPane_sample_new.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				String sampleID = null;
				if( tabbedPane_sample_new.getSelectedIndex() == 1){
					try {
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						sampleID = database.getSamples(userID, "transit", 1);
						Client.getLookup().release(database);
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						e1.printStackTrace();
					}
					if(!(sampleID == null)){
						if(comboBox_sample_tempID.getItemCount() == 0)
							comboBox_sample_tempID.addItem(sampleID);
						lbl_sample_msg.setVisible(false);
					}
				}
				
				if( tabbedPane_sample_new.getSelectedIndex() == 2){
					try{
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						sampleID = database.getSamples(userID, "storage", 1);
						Client.getLookup().release(database);
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						e1.printStackTrace();
					}
					if(!(sampleID == null) ){
						if(comboBox_sample_tempID.getItemCount() == 0)
							comboBox_sample_2sampleId.addItem(sampleID);
						lbl_sample_2msg.setVisible(false);
					}
				}
				
			}
		});
		
		btnSubmit_sample_1st.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String sampleID = String.valueOf(comboBox_sample_tempID.getSelectedItem());
				String name = textField_sample_cname.getText();
				String street = textField_sample_cstreet.getText();
				String city = textField_sample_city.getText();
				String postcode = textField_sample_city.getText();
				String country = String.valueOf(comboBox_sample_ccountry.getSelectedItem());
				Date date = dateChooser_sample_cdate.getDate();
				SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
				String time = f.format(spinner_sample_ctime.getValue());
				String courierFirm = textField_sample_ccourierfirm.getText();
				
				String cardType = String.valueOf(comboBox_sample_card.getSelectedItem());
				String cardNo = textField_sample_cardNo.getText();
				Date expDate = dateChooser_sample_cardExp.getDate();
				String plan = String.valueOf(comboBox_sample_pplan.getSelectedItem());
				
				int result = 0;
				
				try {
					collectionPoint = (CollectionPointInterface) Client.getLookup().lookup("collectionPoint");
					collectionPoint = collectionPoint.newCollectionPoint();
					payment = (PaymentInterface) Client.getLookup().lookup("payment");
					payment = payment.newPayment();
					
					collectionPoint.setName(name);
					collectionPoint.setAddress(street, city, postcode, country);
					collectionPoint.setDate(date);
					collectionPoint.setTime(time);
					collectionPoint.setCourierFirm(courierFirm);
					
					payment.setCardNo(cardNo);
					payment.setCardType(cardType);
					payment.setExpDate(expDate);
					payment.setPaymentPlan(plan);
					
					result = collectionPoint.savetoDB(sampleID) + payment.savetoDB(userID);
					
					Client.getLookup().release(collectionPoint);
					Client.getLookup().release(payment);
					
				} catch (UnknownHostException | LookupFailedException
						| EstablishConnectionFailed e1) {
					
					e1.printStackTrace();
				}
				
				if(result == 2)
					JOptionPane.showMessageDialog(UI_Customer.this, "Your sample details are added.", "Success", JOptionPane.INFORMATION_MESSAGE);
					
				
			}
		});
		
		button_sample_2submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( comboBox_sample_2sampleId.getItemCount() == 0){
					
				}
				else
				{
					System.out.println(userID);
					String sampleID = "temp" + userID;
					String name = textField_sample_2name.getText();
					String street = textField_sample_2street.getText();
					String city = textField_sample_2city.getText();
					String postcode = textField_sample_2postcode.getText();
					String country = String.valueOf(comboBox_sample_2country.getSelectedItem());
					Date date = dateChooser_sample_2date.getDate();
					SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
					String time = f.format(spinner_sample_2time.getValue());
					String courierFirm = textField_sample_2cfirm.getText();
					
					int result = 0;
					
					try {
						collectionPoint = (CollectionPointInterface) Client.getLookup().lookup("collectionPoint");
						collectionPoint = collectionPoint.newCollectionPoint();
						database = (DatabaseInterface) Client.getLookup().lookup("database");
						database = database.newDatabase();
						
						
						collectionPoint.setName(name);
						collectionPoint.setAddress(street, city, postcode, country);
						collectionPoint.setDate(date);
						collectionPoint.setTime(time);
						collectionPoint.setCourierFirm(courierFirm);
						
						result = database.insertTempSample(userID, 2) + collectionPoint.savetoDB(sampleID);
					} catch (UnknownHostException | LookupFailedException
							| EstablishConnectionFailed e1) {
						
						e1.printStackTrace();
					}
					
					if(result == 2)
						JOptionPane.showMessageDialog(UI_Customer.this, "Your 2nd sample details are added.", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		
		btnPaymentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					database = (DatabaseInterface) Client.getLookup().lookup("database");
					database = database.newDatabase();
				
					table_paymentDetails.setModel(database.getAllPaymentDetails(userID));
					
					Client.getLookup().release(database);
				} catch (UnknownHostException | LookupFailedException
						| EstablishConnectionFailed e1) {
					e1.printStackTrace();
				}
			}
		});
		
		tabbedPane.setSelectedIndex(0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		

	}
	
	public static UI_Customer run(){
		return new UI_Customer();
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
