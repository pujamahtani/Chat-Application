import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientOutput extends Thread{
    /********************************DATA MEMBERS*********************************/
    private Socket socket;
    private ObjectOutputStream oos ;
    private Message messageToBeSent ;
    Connection connection;
    BufferedReader br;
    String msg;
    /********************************CONSTRUCTOR**********************************/
    /*
    * @param: The Socket of the current client. 
    * */
	ClientOutput(Socket socket){
		this.socket=socket;
      br = new BufferedReader(new InputStreamReader(System.in));
        try{
            oos = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(Exception ioe){
            System.out.println(ioe);
        }
	}
    /*********************METHODS************************/
    /*
    * This is the run method.
    * @param: Nothing.
    * @return: Nothing.
    * */
    public void run(){
    	try{
		    System.out.println("inside run ");
            while(true)
                {   System.out.println("senders name:");
	                String sender = br.readLine();
	                System.out.println("enter receivers name:");
	                String receiver = br.readLine();
                    System.out.println("Enter the message you want to sent:");
                    msg = br.readLine();
                    messageToBeSent = new Message(sender,receiver, msg);
                    oos.writeObject(messageToBeSent);
                }
           
    	}
    	
    	catch(Exception e){
    		System.out.println("Issue uske bahar ka op: "+e);
    	}
    	finally{
			try{
                oos.close();
				socket.close();
			}catch(IOException e){
				System.out.println("Issue from finally op : "+e);
			}

		}
			
    }
}
