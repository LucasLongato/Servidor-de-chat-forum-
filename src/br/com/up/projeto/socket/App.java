package br.com.up.projeto.socket;

import br.com.up.projeto.socket.client.ClienteSocket;

public class App {
    public static void main(String[] args) throws Exception {
        ClienteSocket clienteSocket = new ClienteSocket();
        clienteSocket.conectarServidor();
    }
}
