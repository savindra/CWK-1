
import java.io.IOException;

import de.root1.simon.Simon;
import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;
import de.root1.simon.exceptions.SimonRemoteException;

public class Client {

   @SuppressWarnings("deprecation")
public static void main(String[] args) throws IOException, LookupFailedException {

      // create a callback object
      ClientCallbackImpl clientCallbackImpl = new ClientCallbackImpl();

      // 'lookup' the server object
      ServerInterface server;
      CustomerInterface customer;
	try {
		server = (ServerInterface) Simon.lookup("46.105.103.149", 22222, "server");
		server.login(clientCallbackImpl);
		//String s = server.sayHello(clientCallbackImpl);
		//System.out.println(s);
		//clientCallbackImpl.reply(server);
		
		
		customer = (CustomerInterface) Simon.lookup("46.105.103.149", 22222, "customermethods");
		customer.setName("Savindra");
		customer.setId("123");
		
		System.out.println(customer.getId());
		System.out.println(customer.getName());
		customer.print();
		
		
		Simon.release(server);
	} catch (SimonRemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (EstablishConnectionFailed e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      // use the serverobject as it would exist on your local machine
      //server.login(clientCallbackImpl);

      // do some more stuff
      // ...

      // and finally 'release' the serverobject to release to connection to the server
      //Simon.release(server);
   }
}