package BasicClientServerExample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author marge
 */
public class Server {

	/**
	 * @param args
	 * Server binded to port 9800
	 * ss - used to accept incoming client connections
	 * accept() - returns a socket object when a connection is accepted
	 * soc - captures the returned object (used for communication)
	 */
	public static void main(String[] args) {

		try {
			System.out.println("Waiting for client...");
			ServerSocket ss = new ServerSocket(9800);
			Socket soc = ss.accept();
			System.out.println("Connection established");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
