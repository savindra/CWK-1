import de.root1.simon.SimonRemote;
import de.root1.simon.exceptions.SimonRemoteException;

@SuppressWarnings("deprecation")
public interface ServerInterface extends SimonRemote {

	   public void login(ClientCallbackInterface clientCallback) throws SimonRemoteException;
	   public void sayHello(String tex) throws SimonRemoteException;

}