import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static int count=0;

    public static void main(String args[]){
    	try{	
				Socket socket = new Socket("localhost",8766);
                System.out.println("Input chalu kar raha hu");
                ClientInput ci = new ClientInput(socket);
                ci.start();
                System.out.println("output chalu kar raha hu");
    			ClientOutput co = new ClientOutput(socket);
    			co.start();
    	}
    	catch(IOException e){
    		System.out.println("Issue from catch client main IO: "+e);
    	}catch(Exception e){
    		System.out.println("Issue from catch client main general: "+e);
    	}
    }
}

