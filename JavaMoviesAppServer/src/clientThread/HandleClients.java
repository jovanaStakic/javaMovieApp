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
import domain.Korisnik;
import domain.Lista;
import domain.Recenzija;
import java.io.IOException;
import java.net.Socket;


/**
 *
 * @author Administrator
 */
public class HandleClients extends Thread {

    Socket client;
    Sender sender;
    Reciever reciever;
    Korisnik prijavljenKorisnik;

    public HandleClients(Socket client) {
        this.client = client;
        sender = new Sender(client);
        reciever = new Reciever(client);
    }

    @Override
    public void run() {
        while (!client.isClosed()) {
            try {
                Request request = (Request) reciever.recieve();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            Korisnik korisnik = controller.Controller.getInstance().login((Korisnik) request.getArgument());
                            response.setResult(korisnik);
                            prijavljenKorisnik = korisnik;
                            break;
                        case SAVE_FILM:
                            Film f = (Film) request.getArgument();
                            f.setKorisnik(prijavljenKorisnik);
                            controller.Controller.getInstance().saveFilm(f);
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
                        case FIND_FILMOVI:
                            Film film = (Film) request.getArgument();
                            film.setKorisnik(prijavljenKorisnik);
                            response.setResult(controller.Controller.getInstance().findMovies(film));
                            break;
                        case GET_FILMOVI:
                            response.setResult(controller.Controller.getInstance().getAll(new Film(Long.MIN_VALUE, null, null, Integer.MIN_VALUE, null, prijavljenKorisnik, null, null, null)));
                            break;
                        case SAVE_RECENZIJA:
                            Recenzija recenzija1 = (Recenzija) request.getArgument();
                            recenzija1.setKorisnik(prijavljenKorisnik);
                            controller.Controller.getInstance().saveRecenzija(recenzija1);
                            break;
                        case GET_RECENZIJE:
                            Recenzija recenzija = new Recenzija();
                            recenzija.setKorisnik(prijavljenKorisnik);
                            response.setResult(controller.Controller.getInstance().getRecenzije(recenzija));
                            break;
                        case DELETE_RECENZIJA:
                            controller.Controller.getInstance().deleteRecenzija((Recenzija) request.getArgument());
                            break;
                        case SAVE_LISTA:
                            Lista lista = (Lista) request.getArgument();
                            lista.setKorisnik(prijavljenKorisnik);
                            controller.Controller.getInstance().addLista(lista);
                            break;
                        case DELETE_LISTA:
                            Lista lista1 = (Lista) request.getArgument();
                            lista1.setKorisnik(prijavljenKorisnik);
                            controller.Controller.getInstance().deleteLista(lista1);
                            break;
                        case FIND_LISTE:
                            Lista lista2 = (Lista) request.getArgument();
                            lista2.setKorisnik(prijavljenKorisnik);
                            response.setResult(controller.Controller.getInstance().findListe(lista2));
                            break;
                        case GET_LISTE:
                            Lista lista3 = new Lista();
                            lista3.setKorisnik(prijavljenKorisnik);
                            response.setResult(controller.Controller.getInstance().getListe(lista3));
                            break;
                        case UPDATE_LISTA:
                            Lista lista4 = (Lista) request.getArgument();
                            lista4.setKorisnik(prijavljenKorisnik);
                            controller.Controller.getInstance().updateLista(lista4);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }

                sender.send(response);
            } catch (Exception ex) {
                try {
                    client.close();
                    server.Server.removeKorisnik(client);
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }

            }

        }
    }

    public Korisnik getKorisnik() {
        return prijavljenKorisnik;
    }

    public Socket getClientSocket() {
        return client;

    }
}
