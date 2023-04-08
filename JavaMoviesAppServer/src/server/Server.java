/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import domain.Korisnik;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import clientThread.HandleClients;

/**
 *
 * @author Administrator
 */
public class Server extends Thread{
    ServerSocket ssoket;
    List<HandleClients> clients;
    public Server() throws IOException {
        ssoket=new ServerSocket(9000);
        clients=new ArrayList<>();
    }
    
    
    
    @Override
    public void run() {
        while (!ssoket.isClosed()) {            
            try {
                System.out.println("Server čeka na konekciju...");
                Socket client=ssoket.accept();
                System.out.println("Klijent se povezao!");
                HandleClients processClientRequests=new HandleClients(client);
                clients.add(processClientRequests);
                processClientRequests.start();
            } catch (IOException ex) {
                System.err.println("Server je ugasen!");
            }
        }
    }
    public void stopServer(){
        if(ssoket!=null && !ssoket.isClosed()){
            try {
                ssoket.close();
            } catch (IOException ex) {
                System.out.println("Neuspešno gašenje servera!");
            }
        }
    }
    
    private void removeClients(){
        for (HandleClients client : clients) {
            try {
                client.getClientSocket().close();
                clients.remove(client);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    public List<Korisnik> getAktivniKorisnici(){
        List<Korisnik> korisnici=new ArrayList<>();
        for (HandleClients client : clients) {
            korisnici.add(client.getKorisnik());
        }
        return korisnici;
    }
    public void removeClient(Socket client){
        for (HandleClients client1 : clients) {
            if(client1.getClientSocket()==client)
                clients.remove(client1);
        }
    }
}
