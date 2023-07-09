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
import clientThread.HandleClients;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class Server extends Thread{
    ServerSocket ssoket;
    static List<HandleClients> clients;
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
    
  
    public static List<Korisnik> getAktivniKorisnici(){
        List<Korisnik> korisnici=new ArrayList<>();
        for (HandleClients client : clients) {
            korisnici.add(client.getKorisnik());
        }
        return korisnici;
    }
    public static void removeKorisnik(Socket client){
        List<HandleClients> copy=new ArrayList<>(clients);
        Iterator<HandleClients> iterator = copy.iterator();
       while(iterator.hasNext()) {
            HandleClients next = iterator.next();
            if(next.getClientSocket()==client) 
                clients.remove(next);
        }
    }
}
