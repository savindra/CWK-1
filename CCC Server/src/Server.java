import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import de.root1.simon.Registry;
import de.root1.simon.Simon;
import de.root1.simon.exceptions.NameBindingException;

public class Server {

    public static void main(String[] args)
            throws UnknownHostException, IOException, NameBindingException, SQLException {

        // create the serverobject
        ServerInterfaceImpl serverImpl = new ServerInterfaceImpl();
        Customer customer = new Customer();
        Registration registration = new Registration();
        Database database = new Database();
        Payment payment = new Payment();
        CollectionPoint collectionPoint = new CollectionPoint();
        Sample sample = new Sample();
        Address address = new Address();
        Invoice invoice = new Invoice();
        

        // create the server's registry ...
        Registry registry = Simon.createRegistry(44444);

        // ... where we can bind the serverobject to
        registry.bind("server", serverImpl);
        registry.bind("customer", customer);
        registry.bind("registration", registration);
        registry.bind("database", database);
        registry.bind("payment", payment);
        registry.bind("collectionPoint", collectionPoint);
        registry.bind("sample", sample);
        registry.bind("address", address);
        registry.bind("invoice", invoice);

        System.out.println("Server up and running!");

        // some mechanism to shutdown the server should be placed here
        // this should include the following command:
        // registry.unbind("server");
        // registry.stop();
    }
}