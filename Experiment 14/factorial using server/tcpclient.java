import java.io.*;
import java.net.*;
import java.util.*;

class tcpclient {

    public static void main(String args[]) {
        try {
            // Connect to the server using its IP address and port
            Socket s1 = new Socket("10.1.4.194", 1520);

            // Set up input/output streams
            DataInputStream dis = new DataInputStream(s1.getInputStream());
            DataOutputStream dos = new DataOutputStream(s1.getOutputStream());

            Scanner sc = new Scanner(System.in);

            // Get two numbers from the user
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Send both numbers to server
            dos.writeInt(num1);
            dos.writeInt(num2);
            System.out.println("Numbers sent to server");

            // Receive and display the sum from server
            int result = dis.readInt();
            System.out.println("Sum received from server: " + result);

            // Close all connections
            dis.close();
            dos.close();
            s1.close();

        } catch (Exception e) {
            e.printStackTrace(); // Print error for debugging
        }
    }
}
