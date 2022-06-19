package br.com.up.projeto.socket.server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

import javax.swing.*;

public class ServidorSocket {

    public void listenClients() throws Exception{
        JOptionPane.showInputDialog(null, "Mensagem para o cliente", "servidor", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("servidor iniciado");
        ServerSocket socketServidor = new ServerSocket(5000);
        Socket socketCliente = socketServidor.accept();
        PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        EscutaThread escuta = new EscutaThread(in);
        escuta.start();
        String entrada = "";
        while (true) {
            entrada = JOptionPane.showInputDialog(null, "Mensagem para o cliente", "servidor", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Servidor: " + entrada);
            out.println(entrada);
        }
//
//        System.out.println(message);
//
//
//        ServerSocket serverSocket = new ServerSocket(1234) ;
//
//        Socket socket = serverSocket.accept();
//
//        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//
//        while(socket.isConnected()){
//
//            String message = IOUtils.toString(socket.getInputStream(), "UTF-8");
//            System.out.println(message);
//
//            output.writeUTF("Olá cliente");
//            output.flush();
//
//
//        }
//
//        socket.close();
    }
}
