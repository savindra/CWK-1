import java.rmi.*;

public class MyRemoteClient{

	public static void main(String[] args){
		MyRemoteClient client = new MyRemoteClient();
		client.go();
	}
	
	public void go(){
		String target = "//46.105.103.149/remotehello";
		try{
			MyRemote service = (MyRemote) Naming.lookup( target );
			String s = service.sayHello();
			
			System.out.println(s);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
