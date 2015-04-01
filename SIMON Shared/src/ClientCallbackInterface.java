import de.root1.simon.SimonRemote;
import de.root1.simon.exceptions.SimonRemoteException;

@SuppressWarnings("deprecation")
public interface ClientCallbackInterface extends SimonRemote {

	public void callback(String text) throws SimonRemoteException;
	public String reply(ServerInterface s) throws SimonRemoteException;

}
