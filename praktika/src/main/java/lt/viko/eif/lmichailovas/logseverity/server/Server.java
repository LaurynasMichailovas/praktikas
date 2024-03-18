/**
 * The Server class represents a simple file server that sends a file to a client upon connection.
 * It listens for incoming client connections on a specified port and sends the requested file to the client.
 */
package lt.viko.eif.lmichailovas.logseverity.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private OutputStream out;

    /**
     * Starts the server and listens for incoming client connections on the specified port.
     * Upon connection, sends the specified file to the client.
     * @param port The port on which the server listens for incoming connections.
     * @param file The path to the file to be sent to the client.
     */
    public void start(int port, String file) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();

            out = clientSocket.getOutputStream();
            sendFile(file);

            System.out.println("File sent");
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            stop();
        }
    }

    private void sendFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(bytes, 0, bytes.length);

        out.write(bytes, 0, bytes.length);
        out.flush();
        bis.close();
    }

    /**
     * Stops the server and closes associated sockets.
     */
    public void stop() {
        try {
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}