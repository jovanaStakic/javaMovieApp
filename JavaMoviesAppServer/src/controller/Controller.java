/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbimplementation.FilmRepository;
import dbimplementation.KorisnikRepository;
import dbimplementation.ListaRepository;
import dbimplementation.RecenzijaRepository;
import dbimplementation.ReziserRepository;
import dbimplementation.ZanrRepository;
import domain.*;
import java.util.List;
import operation.AbstractGenericOperation;
import operationFilm.FindMoviesSO;
import operationFilm.GetGlumciSO;
import operationFilm.GetMoviesSO;
import operationFilm.GetReziseriSO;
import operationFilm.GetZanroviSO;
import operationFilm.SaveMovieSO;
import operationFilm.SaveRecenizijaSO;

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

    private Controller() {
        korisnikRepository = new KorisnikRepository();
        filmRepository = new FilmRepository();
        zanrRepository = new ZanrRepository();
        reziserRepository = new ReziserRepository();
        recenzijaRepository = new RecenzijaRepository();
        listaRepository = new ListaRepository();

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

    public void saveFilm(Film film, Korisnik korisnik) throws Exception {
        AbstractGenericOperation saveMovie = new SaveMovieSO();
        saveMovie.execute(film);

    }

    public List<GenericEntity> getZanrovi() throws Exception {
        AbstractGenericOperation getAll = new GetZanroviSO();
        getAll.execute(new Zanr());
        return ((GetZanroviSO) getAll).getZanrovi();
    }

    public List<GenericEntity> getReziseri() throws Exception {
        AbstractGenericOperation getAll = new GetReziseriSO();
        getAll.execute(new Reziser());
        return ((GetReziseriSO) getAll).getReziseri();
    }
    
    public List<GenericEntity> findMovies(Film film) throws Exception{
        AbstractGenericOperation findAll = new FindMoviesSO();
        findAll.execute(film);
        return ((FindMoviesSO) findAll).getMovies();
    }
    
   

//    public List<GenericEntity> getAllFilmoviByKorisnik(Korisnik korisnik) throws Exception {
//        AbstractGenericOperation getAll=new GetMoviesSO();
//        getAll.execute(new Film());
//        return ((GetMoviesSO)getAll).getMovies();
//    }
    
    public List<GenericEntity> getAll(Film film) throws Exception {
        AbstractGenericOperation getAll = new GetMoviesSO();
        getAll.execute(film);
        return ((GetMoviesSO) getAll).getMovies();
    }

    public void saveRecenzija(Recenzija recezija, Korisnik korisnik) throws Exception {
        AbstractGenericOperation saveRecenzija = new SaveRecenizijaSO();
        saveRecenzija.execute(recezija);
    }

    public List<Recenzija> getRecenzijaByKorisnik(Korisnik korisnik) {
        return recenzijaRepository.getAllByKorisnik(korisnik);
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        recenzijaRepository.delete(recenzija);
    }

    public void addLista(Lista lista) throws Exception {
        listaRepository.add(lista);
    }

    public Object getGlumci() throws Exception {
        AbstractGenericOperation getAll=new GetGlumciSO();
        getAll.execute(new Glumac());
        return ((GetGlumciSO)getAll).getGlumci();
    }
}
