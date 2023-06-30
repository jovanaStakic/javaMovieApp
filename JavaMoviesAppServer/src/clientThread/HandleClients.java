/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientThread;

import communication.Reciever;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Film;
import domain.GenericEntity;
import domain.Korisnik;
import domain.Lista;
import domain.Recenzija;
import domain.Reziser;
import domain.Zanr;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;


/**
 *
 * @author Administrator
 */
public class HandleClients extends Thread{
    Socket client;
    Sender sender;
    Reciever reciever;
    Korisnik prijavljenKorisnik;
    
    public HandleClients(Socket client) {
        this.client = client;
        sender=new Sender(client);
        reciever =new Reciever(client);
    }

    @Override
    public void run() {
        while(!client.isClosed()){
            try {
                Request request=(Request) reciever.recieve();
                Response response=new Response();
                try{
                    switch (request.getOperation()) {
                    case LOGIN:
                        Korisnik korisnik=(Korisnik) request.getArgument();
                        korisnik=controller.Controller.getInstance().login(korisnik.getKorisnickoIme(), korisnik.getSifra());
                        response.setResult(korisnik);
                        prijavljenKorisnik=korisnik;
                        break;
                    case SAVE_MOVIE:
                        controller.Controller.getInstance().saveFilm((Film) request.getArgument(),prijavljenKorisnik);
                        break;
                    case GET_ZANROVI:
                        response.setResult(controller.Controller.getInstance().getZanrovi());
                        break;
                    case GET_REZISERI:
                        response.setResult(controller.Controller.getInstance().getReziseri());
                        break;
                    case GET_GLUMCI:
                        response.setResult(controller.Controller.getInstance().getGlumci());
                        break;
                    case FIND_MOVIES:
                        Film film=(Film) request.getArgument();
                        film.setKorisnik(prijavljenKorisnik);
                        response.setResult(controller.Controller.getInstance().findMovies(film));
                        break;
                    case GET_FILMOVI:
                        response.setResult(controller.Controller.getInstance().getAll(new Film(Long.MIN_VALUE, null, null, Integer.MIN_VALUE, null, prijavljenKorisnik, null, null, null)));
                        break;
                    case SAVE_RECENZIJA:
                        controller.Controller.getInstance().saveRecenzija((Recenzija) request.getArgument(),prijavljenKorisnik);
                        break;
                    case GET_RECENZIJE:
                        response.setResult(controller.Controller.getInstance().getRecenzijaByKorisnik(prijavljenKorisnik));
                        break;
                    case DELETE_RECENZIJA:
                        controller.Controller.getInstance().deleteRecenzija((Recenzija) request.getArgument());
                        break;
                    case KREIRAJ_LISTU:
                        controller.Controller.getInstance().addLista((Lista) request.getArgument());
                        break;
                    }
                }catch (Exception e) {
                   // e.printStackTrace();
                    response.setException(e);
                }
                
                sender.send(response);
            } catch (Exception ex) {
                try {
                    client.close();
                    
                } catch (IOException ex1) {
                    Logger.getLogger(HandleClients.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
            }
            
        }
    }
    
    public Korisnik getKorisnik(){
        return prijavljenKorisnik;
    }
    
    public Socket getClientSocket(){
        return client;
        
    }
}
