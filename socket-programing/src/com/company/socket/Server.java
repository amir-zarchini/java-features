package com.company.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
//            ServerSocket serverSocket = new ServerSocket(6666);
//            Socket socket = serverSocket.accept();
//            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//            String strDataInput = (String) dataInputStream.readUTF();
//            System.out.println("message: " + strDataInput);
//            serverSocket.close();
            ServerSocket ss = new ServerSocket(3333);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = din.readUTF();
                System.out.println("client says: " + str);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();
        } catch (Exception exception) {
            System.out.println("Exception: " + exception);
        }
    }
}
