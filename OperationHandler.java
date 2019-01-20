import java.net.Socket;
import java.util.Vector;

public class OperationHandler extends Thread
{   /******************************DATA MEMBERS***************************/
	ServerOutput so;
	ServerInput si;
	Socket clientSocket;
	String name;

	private Message mo;

    /***************************CONSTRUCTORS**************************/
    /*
    * @param: It accepts the object of ServerOutput class which handles the output strem of the Server.
    * @param: It accepts the object of ServerInput class which handles the input stream of Server.
    * @param: It accepts the client which is connected
    * @param: It accepts the name of the client.
    * *//
	OperationHandler(ServerOutput so, ServerInput si, Socket clientSocket, String name){
		this.so = so;
		this.si = si;
		this.clientSocket = clientSocket;
		this.name = name;
	}
      /***********************************METHODS******************************/
    /*
    * This is the run method
    * @param: Nothing.
    * @return: Nothing
    * */
	public void run(){
		try{
			while(true){
			mo = (Message)si.input.readObject();
			System.out.println("Accepting the message:"+mo.getMessage());
			Vector records = Connection.getRecords();
			System.out.println(records.size());
			for(int i=0; i<records.size();i++)
			{
				System.out.println("inside for printing names");
				OperationHandler obj = (OperationHandler)records.elementAt(i);
				System.out.println(obj.name);
				if(obj.name.equals(mo.getReceiver())){
					obj.so.output.writeObject(mo);
				}
			}
			System.out.println("For ke baad");
		}
		}
		catch(Exception ioe)
		{
			System.out.println("IOE:"+ioe);
		}
	}
}