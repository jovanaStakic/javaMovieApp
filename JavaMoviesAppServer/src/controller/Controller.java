/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbimplementation.FilmRepository;
import dbimplementation.KorisnikRepository;
import dbimplementation.ListaRepository;
import dbimplementation.RecenzijaRepository;
import dbimplementation.RepositoryDBGeneric;
import dbimplementation.ReziserRepository;
import dbimplementation.ZanrRepository;
import domain.*;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Controller {

    private static Controller instance;
    private final KorisnikRepository korisnikRepository;
    private final FilmRepository filmRepository;
    private final ZanrRepository zanrRepository;
    private final ReziserRepository reziserRepository;
    private final RecenzijaRepository recenzijaRepository;
    private final ListaRepository listaRepository;
    private final RepositoryDBGeneric genericRepository;
    
    private Controller() {
        korisnikRepository = new KorisnikRepository();
        filmRepository = new FilmRepository();
        zanrRepository = new ZanrRepository();
        reziserRepository = new ReziserRepository();
        recenzijaRepository = new RecenzijaRepository();
        listaRepository= new ListaRepository();
        genericRepository=new RepositoryDBGeneric();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Korisnik login(String korisnickoIme, String sifra) throws Exception {
        List<Korisnik> korisnici = korisnikRepository.getAll();
        for (Korisnik korisnik1 : korisnici) {
            if (korisnik1.getKorisnickoIme().equals(korisnickoIme) && korisnik1.getSifra().equals(sifra)) {
                return korisnik1;
            }

        }
        throw new Exception("Pogrešno korisničko ime i/ili lozinka!");
    }

    public void saveFilm(Film film) throws Exception {
        genericRepository.add(film);
        
    }

    public List<Zanr> getZanrovi() {
        return zanrRepository.getAll();
    }

    public List<Reziser> getReziseri() {
        return reziserRepository.getAll();
    }

    public List<Film> findByReziser(Reziser reziser, Korisnik korisnik) {
        return filmRepository.findAllByReziser(reziser, korisnik);
    }

    public List<Film> findByZanr(Zanr zanr, Korisnik korisnik) {
        return filmRepository.findAllByZanr(zanr, korisnik);
    }

    public List<Film> findByNaziv(String naziv, Korisnik korisnik) {
        return filmRepository.findAllByNaziv(naziv, korisnik);
    }

    public List<Film> getFilmoviByKorisnik(Korisnik korisnik) {
        return filmRepository.getAllByKorisnik(korisnik);
    }

    public void saveRecenzija(Recenzija recezija) throws Exception {
        recenzijaRepository.add(recezija);
    }

    public List<Recenzija> getRecenzijaByKorisnik(Korisnik korisnik) {
        return recenzijaRepository.getAllByKorisnik(korisnik);
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        recenzijaRepository.delete(recenzija);
    }
    public void addLista(Lista lista) throws Exception{
        listaRepository.add(lista);
    }
}
