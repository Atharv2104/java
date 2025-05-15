import java.io.*;
import java.net.*;

class tcpserver {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(1520);
            System.out.println("Server is waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Get streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read two integers
            int num1 = dis.readInt();
            int num2 = dis.readInt();

            System.out.println("Received numbers: " + num1 + " and " + num2);

            // Perform sum
            int sum = num1 + num2;
            System.out.println("Sending sum: " + sum);

            // Send result back to client
            dos.writeInt(sum);

            // Close everything
            dis.close();
            dos.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
