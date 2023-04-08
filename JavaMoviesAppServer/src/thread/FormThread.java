/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import domain.Korisnik;
import form.ServerForm;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KorisnikTableModel;

/**
 *
 * @author Administrator
 */
public class FormThread extends Thread{
    
    boolean signal;
    List<Korisnik> korisnici;
    KorisnikTableModel model;
    server.Server server;
    
    public FormThread(server.Server server,KorisnikTableModel model) {
       
        signal=false;
       this.model=model;
       this.server=server;
    }

    @Override
    public void run() {
        while (!signal) {            
            try {
                List<Korisnik> korisnici=server.getAktivniKorisnici();
                model.refresh(korisnici);
                
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FormThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void stopThread(){
        signal=true;
    }
    
}
