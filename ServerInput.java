import java.io.*;
import java.net.Socket;
public class ServerInput extends Thread{
  /******************************DATA MEMBERS******************************/
    private Socket clientSocket;
    ObjectInputStream input;
   /******************************CONSTRUCTOR*******************************/
   /*
    * @param: The Socket of the current client.
    * */
	ServerInput(Socket socket){
		this.clientSocket=socket;
        try{
            input = new ObjectInputStream(clientSocket.getInputStream());
        }catch(Exception e){
            System.out.println("Exception in creating the stream:"+e);
        }
	}

	 //  public void run(){
  //   	try{
  //               String cName = (String)input.readObject();
  //               Connection serverObject = new Connection();
  //               // System.out.println(serverObject.records.size());
  //               serverObject.addConnection(cName,clientSocket);
  //               Connection.display();
  //               Message m =(Message)input.readObject();
  //               int receiver = m.getReceiver();
  //   	}
    	
  //   	catch(Exception e){
  //   		System.out.println("Issue from catch : "+e);
  //   	}
  //   	finally{
		// 	try{
		// 		clientSocket.close();
		// 	}catch(IOException e){
		// 		System.out.println("Issue from finally: "+e);
		// 	}

		// }
			
  //   }

}
