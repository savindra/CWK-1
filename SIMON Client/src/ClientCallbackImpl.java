import de.root1.simon.exceptions.SimonRemoteException;

public class ClientCallbackImpl implements ClientCallbackInterface {

   private static final long serialVersionUID = 1L;

   public void callback(String text) throws SimonRemoteException {

      System.out.println("This message was received from the server: "+text);

   }

@Override
public String reply(ServerInterface s) throws SimonRemoteException {
	s.sayHello("Client logged in");
	return null;
	
}
}
