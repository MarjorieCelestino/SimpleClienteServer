package BasicClientServerExample;

import java.net.Socket;

/**
 * @author marge
 */
public class Client {

	/**
	 * @param args
	 * soc takes two paramethers: IP adress and port number
	 */
	public static void main(String[] args) {

		try {
			System.out.println("Client started");
			Socket soc = new Socket("localhost", 9800);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}