package br.com.up.projeto.socket.client;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import br.com.up.projeto.socket.server.EscutaThread;
import org.apache.commons.io.IOUtils;

import javax.swing.*;

public class ClienteSocket {

    public void conectarServidor() throws Exception{
        System.out.println("Cliente iniciado...");
        Socket socket = new Socket("localhost", 5000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        EscutaThread escuta = new EscutaThread(in);
        escuta.start();
        String entrada = "";
        while (true) {
            entrada = JOptionPane.showInputDialog(null, "Mensagem para o servidor", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            out.println(entrada);
            System.out.println("Cliente: " + entrada);
        }



//        String ipHost = "localhost";
//        Socket socket = new Socket(ipHost, 5000);
//        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//
//        while(socket.isConnected()){
//
//            output.writeUTF("Olá Servidor");
//            output.flush();
//
//            String message = IOUtils.toString(socket.getInputStream(), "UTF-8");
//            System.out.println(message);
//        }
//
//        System.out.println("nao mais conectado");
//
//        socket.close();
    }
}
