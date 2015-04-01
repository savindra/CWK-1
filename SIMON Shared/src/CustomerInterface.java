import de.root1.simon.SimonRemote;


@SuppressWarnings("deprecation")
public interface CustomerInterface extends SimonRemote {
	
	public String getName();
	public void setName(String name);
	public String getId();
	public void setId(String id);
	public String toString();
	public void print();

}
