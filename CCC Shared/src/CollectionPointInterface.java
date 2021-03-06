import java.util.Date;


public interface CollectionPointInterface {
	
	public String getName();
	public void setName(String name);
	public AddressInterface getAddress();
	public void setAddress(String street, String city, String postcode,String country);
	public Date getDate();
	public void setDate(Date date);
	public String getTime();
	public void setTime(String time);
	public String getCourierFirm();
	public void setCourierFirm(String courierFirm);
	public int savetoDB(String sampleID);
	public CollectionPointInterface newCollectionPoint();

}
