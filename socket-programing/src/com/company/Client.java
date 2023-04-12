package com.company;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
//            Socket s=new Socket("localhost",6666);
//            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
//            dout.writeUTF("Hello Server");
//            dout.flush();
//            dout.close();
//            s.close();
            Socket s = new Socket("localhost", 3333);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                System.out.println("Server says: " + str2);
            }
            dout.close();
            s.close();
        } catch (Exception exception) {
            System.out.println("Exception: " + exception);
        }

    }
}

