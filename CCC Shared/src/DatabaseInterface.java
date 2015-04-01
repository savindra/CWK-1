import javax.swing.table.DefaultTableModel;

public interface DatabaseInterface {
	
	public CustomerInterface getCustomer(String userID);
	
	public String getLastUserID();
	
	public DatabaseInterface newDatabase();
	
	public int userRegister(String password, String salt, String role);
	
	public DefaultTableModel getAllCustomers();
	
	public int updateCollectionPointSampleID(String sampleIDNew, String sampleIDOld);
	
	public int insertTempSample(String clientID, int sampleNo);
	
	public String[] getSampleStatus(String status, int sampleNo);
	
	public String getSamples(String userID, String status, int sampleNo);
	
	public int deleteCustomer(String userID);
	
	public String[] getSampleByStatus(String status);
	
	public DefaultTableModel getAllPaymentDetails(String clientID);

}
