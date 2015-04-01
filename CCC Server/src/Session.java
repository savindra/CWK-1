
import de.root1.simon.SimonUnreferenced;
import de.root1.simon.annotation.SimonRemote;
import java.io.Serializable;

@SimonRemote(value = {SessionInterface.class})
public class Session implements SessionInterface,  SimonUnreferenced, Serializable {

    private final String user;
    private final ServerInterfaceImpl server;

	public Session(String user, ServerInterfaceImpl server) {
        this.user = user;
        this.server = server;
    }
   
    @Override
    public void doSomething(String message) {
        System.out.println("User "+user+ " " + message);
    }

    @Override
    public void unreferenced() {
        System.out.println("Unreferenced: "+user+"@"+this);
        server.removeUserSession(this);
    }

    public String getUsername(){
        return user;
    }

}