/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.*;
import java.util.List;
import java.net.Socket;


/**
 *
 * @author Administrator
 */
public class Communication {
    private static Communication instance;
    Socket socket;
    Sender sender;
    Reciever reciever;
    
    
    private Communication() throws Exception {
       
            socket=new Socket("127.0.0.1", 9000);
            sender=new Sender(socket);
            reciever=new Reciever(socket);
       
    
    }
    
    public static Communication getInstance() throws Exception{
        if(instance==null)
            instance=new Communication();
        return instance;
    }
    
    public Korisnik login(String korisnickoIme, String sifra) throws Exception {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnickoIme);
        korisnik.setSifra(sifra);
        Request request = new Request(korisnik, Operation.LOGIN);
        sender.send(request);
        Response response = (Response) reciever.recieve();

        if (response.getException() == null) {
            return (Korisnik) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void saveFilm(Film film) throws Exception {
        Request request = new Request(film, Operation.SAVE_MOVIE);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public List<Reziser> getReziseri() throws Exception {
        Request request = new Request(null, Operation.GET_REZISERI);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {
            return (List<Reziser>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Glumac> getGlumci() throws Exception {
        Request request = new Request(null, Operation.GET_GLUMCI);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {
            return (List<Glumac>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Zanr> getZanrovi() throws Exception {
        Request request = new Request(null, Operation.GET_ZANROVI);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {
            return (List<Zanr>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Film> findMovies(Film film) throws Exception {
        Request request = new Request(film, Operation.FIND_MOVIES);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {
            return (List<Film>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Film> getFilmovi() throws Exception {
        Request request = new Request(null, Operation.GET_FILMOVI);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {
            return (List<Film>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void saveRecenzija(Recenzija recenzija) throws Exception {
        Request request = new Request(recenzija, Operation.SAVE_RECENZIJA);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public List<Recenzija> getRecenzije() throws Exception {
        Request request = new Request(null, Operation.GET_RECENZIJE);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {
            return (List<Recenzija>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        Request request = new Request(recenzija, Operation.DELETE_RECENZIJA);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public void addLista(Lista lista) throws Exception {
        Request request = new Request(lista, Operation.KREIRAJ_LISTU);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }
    
    public List<Lista> getListe() throws Exception{
        Request request=new Request(null, Operation.GET_LISTE);
        sender.send(request);
        Response response=(Response) reciever.recieve();
        if(response.getException()==null){
            return (List<Lista>) response.getResult();
        }else{
            throw response.getException();
        }
    }
    
     public List<Lista> findListe(Lista lista) throws Exception {
        Request request = new Request(lista, Operation.FIND_LISTE);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {
            return (List<Lista>) response.getResult();
        } else {
            throw response.getException();
        }
    }
     
      public void deleteLista(Lista lista) throws Exception {
        Request request = new Request(lista, Operation.DELETE_LISTA);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }
       public void updateLista(Lista lista) throws Exception {
        Request request = new Request(lista, Operation.UPDATE_LISTA);
        sender.send(request);
        Response response = (Response) reciever.recieve();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }
}
