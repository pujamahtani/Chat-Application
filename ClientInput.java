

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientInput extends Thread{
    /******************************DATA MEMBERS******************************/
	private Socket socket;
    private Message messageObject;
    /******************************CONSTRUCTOR*******************************/
    /*
    * @param: The Socket of the current client.
    * */
	ClientInput(Socket socket){
		this.socket=socket;
	}
    /***********************************METHODS******************************/
    /*
    * This is the run method
    * @param: Nothing.
    * @return: Nothing
    * */
    public void run(){
    	try{
            System.out.println("Inside input ka run");
    		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            System.out.println("Stream banay");
    		while(true){
                System.out.println("While me aaya");
    			messageObject = (Message)input.readObject();
			    System.out.println("I got this from "+messageObject.getSender()+":"+messageObject.getMessage());
    			if(messageObject.getMessage().equals("exit")){
    				break;
    			}

    		}
    	}
    	catch(IOException e){
    		System.out.println("Issue from client input IO : "+e);
    	}
    	catch(Exception e){
    		System.out.println("Issue from input general: "+e);
    	}
    	finally{
			try{
				socket.close();
			}catch(IOException e){
				System.out.println("Issue from input finally ka catch: "+e);
			}

		}
			
    }
}
