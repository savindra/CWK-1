import java.util.Date;


public interface CustomerInterface {
	
	public String getTitle();
	public void setTitle(String title);
	
	public String getName();
	public void setName(String name);
	
	public AddressInterface getAddress();
	public void setAddress(String street, String city, String postcode,String country);
	
	public String getEmail();
	public void setEmail(String email);
	
	public int getAge();
	public void setAge(int age);
	
	public Date getDob();
	public void setDob(Date dob);
	
	public String getGender();
	public void setGender(String gender);
	
	public String getPhoneNo();
	public void setPhoneNo(String phoneNo);
	
	public CustomerInterface newCustomer();
	
	public int editCustomerDB(String userID);

}
