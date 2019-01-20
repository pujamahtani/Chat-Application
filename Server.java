import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String args[]){
        int i=0;
    	try(ServerSocket serverSocket = new ServerSocket(8766)){
    		while(true){
    			Socket clientSocket = serverSocket.accept();
    			ServerInput si = new ServerInput(clientSocket);
                ServerOutput so = new ServerOutput(clientSocket);
                OperationHandler operationObj = new OperationHandler(so, si, clientSocket, "Client"+ i);
                i++;
                Connection connObj = new Connection();
                connObj.addConnection(operationObj);
                operationObj.start();
    		}
    	}catch(IOException e){
    		System.out.println("Issue : "+e);
    	}
    }
}

