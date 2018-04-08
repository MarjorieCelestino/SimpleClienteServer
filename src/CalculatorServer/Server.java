package CalculatorServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author marge
 */
public class Server {

	/**
	 * @param args
	 * in - used for reading data from the socket's input stream
	 * out - used for sending data to the socket's output stream
	 * PrintWriter: true means it won't keep data into its internal buffer
	 */
	public static void main(String[] args) throws Exception{


		ServerSocket ss = new ServerSocket(9806);
		System.out.println("Waiting on client...");
		Socket soc = ss.accept();
		System.out.println("Connection established");
		BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

		//waits for incoming data from the client
		int option = 0;
		int num1 = 0;
		int num2 = 0;
		String result = "";

		while(true) {
			//reads data from the client 
			String str[] = in.readLine().split(":");
			option = Integer.parseInt(str[0]);
			num1 = Integer.parseInt(str[1]);
			num2 = Integer.parseInt(str[2]);

			switch (option) {
			case 1:
				result = "Addition is: " + (num1+num2);
				break;
			case 2:
				result = "Subtraction is: " + (num1-num2);
				break;
			case 3:
				result = "Multiplication is: " + (num1*num2);
				break;
			case 4:
				result = "Division is: " + (num1/num2);
				break;

			default:
				break;
			}

			//sends result back to client
			out.println(result);
		}

	}

}
