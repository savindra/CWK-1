
import de.root1.simon.Lookup;
import de.root1.simon.exceptions.EstablishConnectionFailed;

import java.io.IOException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import de.root1.simon.Simon;
import de.root1.simon.exceptions.LookupFailedException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UnsupportedLookAndFeelException;

public class Client {
	
	static Lookup nameLookup;
	static ServerInterface server;
	
	static ClientCallbackImpl clientCallbackImpl = new ClientCallbackImpl();
	static SessionInterface session;

    public static void main(String[] args) throws IOException, LookupFailedException, EstablishConnectionFailed, NoSuchAlgorithmException {

        // create a callback object
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }   catch (InstantiationException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
         

        // 'lookup' the server object
//        Lookup nameLookup = Simon.createNameLookup("127.0.0.1", 44444);
//        ServerInterface server = (ServerInterface) nameLookup.lookup("server");
        //UI_Registration.run();
        createLoginUI(true);
         //UI_Employee.run();
         //UI_Customer.run();

        // use the serverobject as it would exist on your local machine
       // SessionInterface session = server.login("DonaldDuck", clientCallbackImpl);
//
//        session.doSomething();
        
        CustomerInterface customer = (CustomerInterface) nameLookup.lookup("customer");
        
        RegistrationInterface registration = (RegistrationInterface) nameLookup.lookup("registration");
        registration = registration.newRegistration();
        
        
//        String salt = getSalt();
//        String pass = get_SHA_256_SecurePassword("cus123", salt);
//        registration.setUser("customer", pass, salt, "User");
//        
//        System.out.println( registration.execute() );
        
  
        
        // do some more stuff
        // ...

        // and finally 'release' the serverobject to release to connection to the server
        //nameLookup.release(server);
        //nameLookup.release(customer);
    }
    
    
    public static void createLoginUI(boolean b){
    	if(b)
    		UI_Login.run();
    	else
    		UI_Login.run().dispose();
    }
    
    public static void createCustomerUI(boolean b){
    	if(b)
    		UI_Customer.run();
    	
    }
    
    public static Lookup getLookup() throws UnknownHostException{
    	Lookup nameLookup = Simon.createNameLookup("127.0.0.1", 44444);
    	return nameLookup;
    }
    
    public static String createServer(String userID, String password) throws UnknownHostException, LookupFailedException, EstablishConnectionFailed{
    	server = (ServerInterface) Client.getLookup().lookup("server");
    	server = server.newServer();
		return server.login(userID, password);
    }
    
    public static void createSession(String userID){
    	session = server.login(userID, clientCallbackImpl);
    }
    
    public static void callBackServer(String message){
    	session.doSomething(message);
    }
}