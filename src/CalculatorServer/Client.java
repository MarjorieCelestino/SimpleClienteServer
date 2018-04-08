package CalculatorServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author marge
 */
public class Client {

	/**
	 * @param args
	 * userInput - used for reading data from the console
	 * in - used for reading data from the socket's input stream
	 * out - used to send data to the server
	 */
	public static void main(String[] args) throws Exception{

		System.out.println("Client started");
		Socket soc = new Socket("localhost", 9806);
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

		//Menu displayed to the user
		int option = 0;
		int num1 = 0;
		int num2 = 0;
		String result = "";

		do {
			System.out.println("Choose an operation:");
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Exit");
			System.out.println("Enter an option:");
			option = Integer.parseInt(userInput.readLine());

			if(option != 5) {

				System.out.println("Enter first number:");
				num1 = Integer.parseInt(userInput.readLine());

				System.out.println("Enter second number:");
				num2 = Integer.parseInt(userInput.readLine());

				//sends data to the server
				out.println(option + ":" + num1 + ":" + num2);

				//capture server result
				result = in.readLine();
				System.out.println("\n" + result);
			}else {

				out.println(option+":0:0");
				break;
			}

		} while (true);

		System.out.println("Client terminated");
	}

}
