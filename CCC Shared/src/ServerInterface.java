public interface ServerInterface {

   public SessionInterface login(String user, ClientCallbackInterface clientCallback);
   public String login(String username, String password);
   public ServerInterface newServer();
   
}