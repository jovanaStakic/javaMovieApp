/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;



import domain.*;
import java.util.List;
import operation.AbstractGenericOperation;
import operationLista.DeleteListaSO;
import operationRecenzija.DeleteRecenzijaSO;
import operationLista.FindListaSO;
import operationFilm.FindFilmoviSO;
import operationFilm.GetGlumciSO;
import operationLista.GetListeSO;
import operationFilm.GetFilmoviSO;
import operationRecenzija.GetRecenzijeSO;
import operationFilm.GetReziseriSO;
import operationFilm.GetZanroviSO;
import operationLista.SaveListaSO;
import operationFilm.SaveFilmSO;
import operationKorisnik.GetKorisniciSO;
import operationRecenzija.SaveRecenizijaSO;
import operationLista.UpdateListaSO;

/**
 *
 * @author Administrator
 */
public class Controller {

    private static Controller instance;
   
    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Korisnik login(Korisnik korisnik) throws Exception {
        AbstractGenericOperation getAll=new GetKorisniciSO();
        getAll.execute(new Korisnik());
        List<GenericEntity> korisnici = ((GetKorisniciSO)getAll).getKorisnici();     
        for (GenericEntity genericEntity : korisnici) {
            Korisnik korisnik1=(Korisnik) genericEntity;
            if (korisnik1.getKorisnickoIme().equals(korisnik.getKorisnickoIme()) && korisnik1.getSifra().equals(korisnik.getSifra())) {
                return korisnik1;
            }
        }
        throw new Exception("Pogrešno korisničko ime i/ili lozinka!");
    }

    public void saveFilm(Film film) throws Exception {
        AbstractGenericOperation saveMovie = new SaveFilmSO();
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

    public List<GenericEntity> findMovies(Film film) throws Exception {
        AbstractGenericOperation findAll = new FindFilmoviSO();
        findAll.execute(film);
        return ((FindFilmoviSO) findAll).getMovies();
    }

    public List<GenericEntity> getAll(Film film) throws Exception {
        AbstractGenericOperation getAll = new GetFilmoviSO();
        getAll.execute(film);
        return ((GetFilmoviSO) getAll).getMovies();
    }

    public void saveRecenzija(Recenzija recezija) throws Exception {
        AbstractGenericOperation saveRecenzija = new SaveRecenizijaSO();
        saveRecenzija.execute(recezija);
    }

    public List<GenericEntity> getRecenzije(Recenzija recenzija) throws Exception {
        AbstractGenericOperation getAll = new GetRecenzijeSO();
        getAll.execute(recenzija);
        return ((GetRecenzijeSO) getAll).getRecenzije();
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        AbstractGenericOperation delete = new DeleteRecenzijaSO();
        delete.execute(recenzija);
    }

    public void addLista(Lista lista) throws Exception {
        AbstractGenericOperation saveLista = new SaveListaSO();
        saveLista.execute(lista);
    }

    public Object getGlumci() throws Exception {
        AbstractGenericOperation getAll = new GetGlumciSO();
        getAll.execute(new Glumac());
        return ((GetGlumciSO) getAll).getGlumci();
    }

    public List<GenericEntity> findListe(Lista lista) throws Exception {
        AbstractGenericOperation find = new FindListaSO();
        find.execute(lista);
        return ((FindListaSO) find).getListe();
    }

    public void deleteLista(Lista lista) throws Exception {
        AbstractGenericOperation delete = new DeleteListaSO();
        delete.execute(lista);
    }

    public List<GenericEntity> getListe(Lista lista) throws Exception {
        AbstractGenericOperation getAll = new GetListeSO();
        getAll.execute(lista);
        return ((GetListeSO) getAll).getListe();
    }

    public void updateLista(Lista lista) throws Exception {
        AbstractGenericOperation update = new UpdateListaSO();
        update.execute(lista);
    }
}
