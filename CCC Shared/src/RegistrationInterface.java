import java.util.Date;


public interface RegistrationInterface {
	
	public void setCustomer(String title, String name, String street, String city,String postcode,String country,String email,Date dob, String gender,String phoneNo);
	
	public void setUser(String username, String password, String salt, String role);
	
	public RegistrationInterface newRegistration();
	
	public String execute();

}
