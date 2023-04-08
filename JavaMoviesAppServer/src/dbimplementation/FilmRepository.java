/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbimplementation;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import db.DBConnection;
import java.sql.*;
import dbrepository.Repository;
import domain.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class FilmRepository implements Repository<Film> {

    @Override
    public List<Film> getAll() {
                      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public void add(Film param) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            String query = "INSERT INTO film(naziv,datumIzlaska, trajanjeFilma, drzavaPorekla, korisnikID, zanrID, reziserID) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, param.getNaziv());
            preparedStatement.setDate(2, new Date(param.getDatumIzlaska().getTime()));
            preparedStatement.setInt(3, param.getTrajajanjeFilma());
            preparedStatement.setString(4, param.getDrzavaPorekla());
            preparedStatement.setLong(5, param.getKorisnik().getId());
            preparedStatement.setLong(6, param.getZanr().getId());
            preparedStatement.setLong(7, param.getReziser().getId());
            preparedStatement.executeUpdate();
           connection.commit();
        }catch(Exception e){
            e.printStackTrace();
            connection.rollback();
            throw new Exception("Neuspešno čuvanje novog filma!");
        }
    }
        @Override
        public void update
        (Film param) throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void delete
        (Film param) throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        public List<Film> findAllByReziser(Reziser reziser,Korisnik korisnik){
            List<Film> filmovi=new ArrayList<>();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String query="SELECT f.filmID, f.naziv, f.datumIzlaska,f.trajanjeFilma,f.drzavaPorekla,z.zanrID,z.nazivZanra FROM film AS f JOIN zanr AS z ON f.reziserID=z.zanrID WHERE f.reziserID="+reziser.getId()+" AND f.korisnikID="+korisnik.getId()+" ORDER BY f.naziv";
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Zanr zanr=new Zanr(rs.getLong("z.zanrID"),rs.getString("z.nazivZanra"));
                Film film=new Film(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), korisnik, zanr, reziser);
                filmovi.add(film);
                
            }
            return filmovi;
        } catch (Exception ex) {
            Logger.getLogger(FilmRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
          public List<Film> findAllByZanr(Zanr zanr,Korisnik korisnik){
                List<Film> filmovi=new ArrayList<>();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String query="SELECT f.filmID,f.naziv,f.datumIzlaska,f.trajanjeFilma,f.drzavaPorekla,r.reziserID,r.imePrezime,r.datumRodjenja,r.drzavaPorekla FROM film AS f JOIN reziser AS r ON f.reziserID=r.reziserID WHERE f.zanrID="+zanr.getId()+" AND f.korisnikID="+korisnik.getId()+" ORDER BY f.naziv";
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Reziser reziser=new Reziser(rs.getLong("r.reziserID"), rs.getString("r.imePrezime"), rs.getDate("r.datumRodjenja"), rs.getString("r.drzavaPorekla"));
                Film film=new Film(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), korisnik, zanr, reziser);
                filmovi.add(film);
                
            }
            return filmovi;
        } catch (Exception ex) {
            Logger.getLogger(FilmRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }

    @Override
    public List<Film> getAllByKorisnik(Korisnik korisnik) {
           List<Film> filmovi=new ArrayList<>();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String query="SELECT f.filmID,f.naziv,f.datumIzlaska,f.trajanjeFilma,f.drzavaPorekla,r.reziserID,r.imePrezime,r.datumRodjenja,r.drzavaPorekla,z.zanrID,z.nazivZanra FROM film AS f JOIN reziser AS r ON f.reziserID=r.reziserID JOIN zanr AS z ON z.zanrID=f.zanrID WHERE korisnikID="+korisnik.getId()+" ORDER BY f.naziv";
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Zanr zanr=new Zanr(rs.getLong("z.zanrID"),rs.getString("z.nazivZanra"));
                Reziser reziser=new Reziser(rs.getLong("r.reziserID"), rs.getString("r.imePrezime"), rs.getDate("r.datumRodjenja"), rs.getString("r.drzavaPorekla"));
                Film film=new Film(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), korisnik, zanr, reziser);
                filmovi.add(film);
                
            }
            return filmovi;
        } catch (Exception ex) {
            Logger.getLogger(FilmRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public List<Film> findAllByNaziv(String naziv,Korisnik korisnik){
                List<Film> filmovi=new ArrayList<>();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String query="SELECT f.filmID,f.naziv,f.datumIzlaska,f.trajanjeFilma,f.drzavaPorekla,r.reziserID,r.imePrezime,r.datumRodjenja,r.drzavaPorekla,z.zanrID,z.nazivZanra FROM film AS f JOIN reziser AS r ON f.reziserID=r.reziserID JOIN zanr AS z ON z.zanrID=f.zanrID WHERE f.naziv='"+naziv+"' AND f.korisnikID="+korisnik.getId();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Zanr zanr=new Zanr(rs.getLong("z.zanrID"),rs.getString("z.nazivZanra"));
                Reziser reziser=new Reziser(rs.getLong("r.reziserID"), rs.getString("r.imePrezime"), rs.getDate("r.datumRodjenja"), rs.getString("r.drzavaPorekla"));
                Film film=new Film(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), korisnik, zanr, reziser);
                filmovi.add(film);
                
            }
            return filmovi;
        } catch (Exception ex) {
            Logger.getLogger(FilmRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
}