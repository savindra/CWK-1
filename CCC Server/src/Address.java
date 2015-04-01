import de.root1.simon.annotation.SimonRemote;

@SimonRemote(value = {AddressInterface.class})
public class Address implements AddressInterface {
	
	private String street;
	private String city;
	private String postcode;
	private String country;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return street + ", " + city + ", " + postcode + ", " + country;
	}
	
	public AddressInterface newAdddress(){
		return new Address();
	}
}


