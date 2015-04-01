import java.awt.HeadlessException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultEditorKit.CutAction;

import de.root1.simon.annotation.SimonRemote;

@SimonRemote(value = {DatabaseInterface.class})
public class Database implements DatabaseInterface {
	
	private final String DATABASE_URL = "jdbc:mysql://localhost:3306/ccc";
	private final String dbuser = "root";
	private final String dbpass = "";
	private Connection conn = null;
	
	private PreparedStatement userLogin = null;
	private PreparedStatement userRegister = null;
	private PreparedStatement customerRegister = null;
	private PreparedStatement getLastUserID = null;
	private PreparedStatement getCustomer = null;
	private PreparedStatement insertSample = null;
	private PreparedStatement getSamples = null;
	private PreparedStatement insertCollectionPoint = null;
	private PreparedStatement insertPayment = null;
	private PreparedStatement insertInvoice = null;
	private PreparedStatement getSamplesByStatusandNo = null;
	private PreparedStatement getAllCustomers = null;
	private PreparedStatement updateSampleID = null;
	private PreparedStatement updateCollectionPointSampleID = null;
	private PreparedStatement deleteCustomer = null;
	private PreparedStatement editCustomer = null;
	private PreparedStatement getSampleByStatus = null;
	private PreparedStatement getAllPaymentDetails = null;
	
	public Database(){
		
		try{
			
			conn = DriverManager.getConnection(DATABASE_URL,dbuser,dbpass);
			
			userLogin = conn.prepareStatement("Select * from userlogin where user_ID=?");
			
			userRegister = conn.prepareStatement("Insert into userlogin values (NULL, ?, ?, ?)");
			
			customerRegister = conn.prepareStatement("Insert into customer values(?,?,?,?,?,?,?,?,?,?,?)");
			
			getLastUserID = conn.prepareStatement("SELECT user_ID FROM userlogin ORDER BY `user_ID` DESC LIMIT 1");
			
			getCustomer = conn.prepareStatement("Select * from customer where userID=?");
			
			insertSample = conn.prepareStatement("Insert into sample values(NULL, ?, ? , ? ,?,?,?,?)");
			
			getSamples = conn.prepareStatement("Select * from sample where userID=? AND status=? AND sampleNo=?");
			
			insertCollectionPoint = conn.prepareStatement("Insert into collectionpoint values(NULL, ?, ?, ?, ?, ?, ?)");
			
			insertPayment = conn.prepareStatement("Insert into payment values(?,?, ?, ?, ?)");
			
			insertInvoice = conn.prepareStatement("Insert into invoice values(NULL, ?, ?, ?,?,?,?)");
			
			getSamplesByStatusandNo = conn.prepareStatement("Select sampleID from sample where status=? and sampleNo=?");
			
			getAllCustomers = conn.prepareStatement("SELECT * from customer");
			
			updateCollectionPointSampleID = conn.prepareStatement("UPDATE collectionPoint SET sampleID=? where sampleID=?");
			
			updateSampleID = conn.prepareStatement("Update sample SET sampleID=?, storedDate=?, endDate=?, status=?, certifiedBy=? where sampleID=?");
			
			deleteCustomer = conn.prepareStatement("DELETE from customer where userID=?");
			
			editCustomer = conn.prepareStatement("update customer set title=?, name=?, street=?, city=?, postcode=?, country=?, email=?,dob=?, gender=?, phoneNo=? where userID=?");
		
			getSampleByStatus = conn.prepareStatement("Select sampleID from sample where status=?");
			
			getAllPaymentDetails = conn.prepareStatement("Select * from payment where clientID=?");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error!", "Database failure", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public DefaultTableModel getAllPaymentDetails(String clientID){
		ResultSet rs = null;
		
		try{
			getAllPaymentDetails.setString(1, clientID);
			rs = getAllPaymentDetails.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }
			
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			while(rs.next()){
				Vector<Object> vector = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(rs.getObject(columnIndex));
		        }
		        data.add(vector);
			}
			
			return new DefaultTableModel(data, columnNames);
		}catch(SQLException | HeadlessException e){
		}
		return null;
	}
	
	public String[] getSampleByStatus(String status){
		
		ResultSet rs = null;
		List<String> list = new ArrayList();
		try{
			getSampleByStatus.setString(1, status);
			rs = getSampleByStatus.executeQuery();
			
			while(rs.next()){
				list.add(rs.getString("sampleID"));
			}
			
		}catch(SQLException | HeadlessException e){
			}	
		String [] arr = new String[list.size()];
		arr = list.toArray(arr);
		return arr;
		
	}
	
	public int editCustomer(Customer customer, String userID){
		int result = 0;
		
		try{
			editCustomer.setString(1, customer.getTitle() );
			editCustomer.setString(2, customer.getName() );
			editCustomer.setString(3, customer.getAddress().getStreet() );
			editCustomer.setString(4, customer.getAddress().getCity() );
			editCustomer.setString(5, customer.getAddress().getPostcode() );
			editCustomer.setString(6, customer.getAddress().getCountry() );
			editCustomer.setString(7, customer.getEmail() );
			editCustomer.setDate(8, convert2sql( customer.getDob() ) );
			editCustomer.setString(9, customer.getGender() );
			editCustomer.setString(10, customer.getPhoneNo() );
			editCustomer.setString(11, userID);
			
			result = editCustomer.executeUpdate();
		}catch(SQLException | HeadlessException e){
		}
		return result;
	}
	
	public int deleteCustomer(String userID){
		int result = 0;
		try{
			deleteCustomer.setString(1, userID);
			
			result = deleteCustomer.executeUpdate();
		}catch(SQLException | HeadlessException e){
		}
		return result;
	}
	
	public int updateSampleID(Sample sample, String sampleIDOld){
		
		int result = 0;
		try{
			updateSampleID.setString(1, sample.getSampleID());
			updateSampleID.setDate(2, convert2sql(sample.getStorageDate()) );
			updateSampleID.setDate(3, convert2sql(sample.getEndDate()) );
			updateSampleID.setString(4, sample.getStatus());
			updateSampleID.setString(5, sample.getCertifiedBy());
			updateSampleID.setString(6, sampleIDOld);
			
			result = updateSampleID.executeUpdate();
		}catch(SQLException | HeadlessException e){
		}
		return result;
	}
	
	public int updateCollectionPointSampleID(String sampleIDNew, String sampleIDOld){
		int result = 0;
		
		try{
			updateCollectionPointSampleID.setString(1, sampleIDNew);
			updateCollectionPointSampleID.setString(2, sampleIDOld);
			
			result = updateCollectionPointSampleID.executeUpdate();
		}catch(SQLException | HeadlessException e){
		}
		return result;
	}
	//Employee --> Client --> View All
	public DefaultTableModel getAllCustomers(){
		ResultSet rs = null;
		
		try{
			rs = getAllCustomers.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }
			
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			while(rs.next()){
				Vector<Object> vector = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(rs.getObject(columnIndex));
		        }
		        data.add(vector);
			}
			
			return new DefaultTableModel(data, columnNames);
		}catch(SQLException | HeadlessException e){
		}
		return null;
	}
	
	public String[] getSampleStatus(String status, int sampleNo){
		ResultSet rs = null;
		List<String> list = new ArrayList();
		try{
			getSamplesByStatusandNo.setString(1, status);
			getSamplesByStatusandNo.setInt(2, sampleNo);
			rs = getSamplesByStatusandNo.executeQuery();
			
			while(rs.next()){
				list.add(rs.getString("sampleID"));
			}
			
		}catch(SQLException | HeadlessException e){
			}	
		String [] arr = new String[list.size()];
		arr = list.toArray(arr);
		return arr;
	}
	
	public int insertInvoice(String clientID, Invoice invoice, String sampleID){
		int result = 0;
		try{
			insertInvoice.setString(1, clientID);
			insertInvoice.setString(2, sampleID);
			insertInvoice.setDate(3, convert2sql(invoice.getInovoiceDate()) );
			insertInvoice.setDate(4, convert2sql( invoice.getDueDate() ));
			insertInvoice.setDouble(5, invoice.getTotal() );
			insertInvoice.setString(6, invoice.getStatus() );
			
			result = insertInvoice.executeUpdate();
			
		}catch(SQLException | HeadlessException e){
			}
		return result;
	}
	
	
	
	public int insertPayment(String clientID, Payment payment){
		int result = 0;
		try{
			insertPayment.setString(1, clientID);
			insertPayment.setString(2, payment.getCardType());
			insertPayment.setString(3, payment.getCardNo());
			insertPayment.setDate(4, convert2sql(payment.getExpDate() ) );
			insertPayment.setString(5, payment.getPaymentPlan() );
			
			result = insertPayment.executeUpdate();
			
		}catch(SQLException | HeadlessException e){
			}
		return result;
	}
	
	public int insertCollectionPoint(CollectionPoint collectionPoint, String sampleID){
		int result = 0;
		String address = collectionPoint.getAddress().toString();
		try{
			insertCollectionPoint.setString(1,sampleID );
			insertCollectionPoint.setString(2, collectionPoint.getName());
			insertCollectionPoint.setString(3, address);
			insertCollectionPoint.setDate(4, convert2sql(collectionPoint.getDate()) );
			insertCollectionPoint.setString(5, collectionPoint.getTime() );
			insertCollectionPoint.setString(6, collectionPoint.getCourierFirm());
			
			result = insertCollectionPoint.executeUpdate();
		}catch(SQLException | HeadlessException e){
			}
		return result;
	}
	
	public DatabaseInterface newDatabase(){
		return new Database();
	}
	
	public String loginCheck(String userid, String password){
		
		String role = "0";
		try{
			ResultSet rs = null;
			String hashedPass = null;
			String passSalt;
			String userDefinedPass = null;
			String userDefinedUserID = null;
			
			userLogin.setString(1, userid);
			rs = userLogin.executeQuery();
			
			while(rs.next()){
				userDefinedUserID= rs.getString("user_ID");
				userDefinedPass = rs.getString("HashedPassword");
				passSalt = rs.getString("Salt");
				hashedPass = get_SHA_256_SecurePassword(password, passSalt);
				role = rs.getString("role");
			}
			
			if(userid.equals(userDefinedUserID) && hashedPass.equals(userDefinedPass))
				return role;
		}
		catch(SQLException | HeadlessException e){
		}
		return role;
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
	
	public String newCustomerRegistration(UserAccount user, Customer customer){
		int result = 0;
		String userID = null;
		try{
			userRegister.setString(1, user.getPassword());
			userRegister.setString(2, user.getSalt());
			userRegister.setString(3, user.getRole());
			
			result += userRegister.executeUpdate();
			
			userID = getLastUserID();
			customerRegister.setString(1, userID );
			customerRegister.setString(2, customer.getTitle() );
			customerRegister.setString(3, customer.getName() );
			customerRegister.setString(4, customer.getAddress().getStreet() );
			customerRegister.setString(5, customer.getAddress().getCity() );
			customerRegister.setString(6, customer.getAddress().getPostcode() );
			customerRegister.setString(7, customer.getAddress().getCountry() );
			customerRegister.setString(8, customer.getEmail() );
			customerRegister.setDate(9, convert2sql( customer.getDob() ) );
			customerRegister.setString(10, customer.getGender() );
			customerRegister.setString(11, customer.getPhoneNo() );
			
			result += customerRegister.executeUpdate();
			if(result != 2)
				return null;
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return userID;		
	}
	
	public String getLastUserID(){
		String userID = null;
		
		ResultSet rs = null;
		try{
			rs = getLastUserID.executeQuery();
			
			while(rs.next()){
				userID = rs.getString("user_ID");
			}
		}
		catch(SQLException | HeadlessException e){
		}
		return userID;		
	}
	
	public CustomerInterface getCustomer(String userID){
		Customer c = new Customer();
		ResultSet rs = null;
		
		try{
			getCustomer.setString(1, userID);
			rs = getCustomer.executeQuery();
			
			while(rs.next()){
				c.setTitle( rs.getString("title") );
				c.setName( rs.getString("name") );
				c.setAddress(rs.getString("street"), rs.getString("city"), rs.getString("postcode"), rs.getString("country"));
				c.setEmail( rs.getString("email") );
				c.setDob( rs.getDate("dob"));
				c.setGender( rs.getString("gender"));
				c.setPhoneNo( rs.getString("phoneNo" ));
			}
		}
		catch(SQLException | HeadlessException e){
		}
		return c;
		
	}
	
	public int insertTempSample(String clientID, int sampleNo){
		int result = 0;
		
		try {
			insertSample.setString(1, "temp" + clientID );
			insertSample.setString(2, clientID);
			insertSample.setDate(3, null);
			insertSample.setDate(4, null);
			insertSample.setString(5, "transit");
			insertSample.setString(6, null);
			insertSample.setInt(7, sampleNo);
			
			result = insertSample.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int userRegister(String password, String salt, String role){
		int result = 0;
		
		try{
			userRegister.setString(1, password);
			userRegister.setString(2, salt);
			userRegister.setString(3, role);
			
			result = userRegister.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public String getSamples(String userID, String status, int sampleNo){
		ResultSet rs = null;
		String sampleID = null;
		
		try{
			getSamples.setString(1, userID);
			getSamples.setString(2, status);
			getSamples.setInt(3, sampleNo);
			
			rs = getSamples.executeQuery();
			
			while(rs.next()){
				sampleID = rs.getString("sampleID");
			}
		}catch(SQLException | HeadlessException e){
		}
	return sampleID;	
	}
	
	public java.sql.Date convert2sql(java.util.Date uDate)
	{
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;

	}

}
