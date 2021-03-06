import java.util.Date;

import de.root1.simon.annotation.SimonRemote;


@SimonRemote(value = {RegistrationInterface.class})
public class Registration implements RegistrationInterface {
	
	private UserAccount user;
	private Customer customer;

	public void setUser(String userID, String password, String salt, String role) {
		user = new UserAccount();
		user.setUserID(userID);
		user.setPassword(password);
		user.setSalt(salt);
		user.setRole(role);
	}
	
	public void setCustomer(String title, String name, String street, String city,String postcode,String country,String email,Date dob, String gender,String phoneNo) {
		customer = new Customer();
		customer.setTitle(title);
		customer.setName(name);
		customer.setAddress(street, city, postcode, country);
		customer.setEmail(email);
		customer.setDob(dob);
		customer.setGender(gender);
		customer.setPhoneNo(phoneNo);
	}

	public RegistrationInterface newRegistration(){
		return new Registration();
	}
	
	public String execute(){
		Database d = new Database();
		return d.newCustomerRegistration(user, customer);
	}
}
