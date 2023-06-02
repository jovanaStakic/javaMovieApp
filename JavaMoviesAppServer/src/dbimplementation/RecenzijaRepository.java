/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbimplementation;
import db.DBConnectionFactory;
import domain.Film;
import domain.Korisnik;
import domain.Recenzija;
import domain.Reziser;
import domain.Zanr;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class RecenzijaRepository implements dbrepository.Repository<Recenzija>{

    
    
    public List<Recenzija> getAllByKorisnik(Korisnik korisnik) {
        List<Recenzija> recenzije=new ArrayList<>();
        try {
            Connection connection=DBConnectionFactory.getInstance().getConnection();
            String query="SELECT r.recenzijaID,r.datumKreiranja,r.ocenaFilma,r.utisak,\n" +
"f.filmID,f.naziv,f.datumIzlaska,f.trajanjeFilma,f.drzavaPorekla,zanr.zanrID, zanr.nazivZanra,rez.reziserID,\n" +
"rez.imePrezime,rez.datumRodjenja,\n" +
"rez.drzavaPorekla\n" +
" FROM recenzija AS r \n" +
" INNER JOIN film AS f ON r.filmID=f.filmID \n" +
" INNER JOIN zanr ON f.zanrID=zanr.zanrID\n" +
" INNER JOIN reziser AS rez ON f.reziserID=rez.reziserID";
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Zanr zanr=new Zanr(rs.getLong("zanr.zanrID"),rs.getString("zanr.nazivZanra"));
                Reziser reziser=new Reziser(rs.getLong("rez.reziserID"), rs.getString("rez.imePrezime"), rs.getDate("rez.datumRodjenja"), rs.getString("rez.drzavaPorekla"));
               // Film film=new Film(rs.getLong("f.filmID"), rs.getString("f.naziv"), rs.getDate("f.datumIzlaska"), rs.getInt("f.trajanjeFilma"), rs.getString("f.drzavaPorekla"), korisnik, zanr, reziser);
               // Recenzija recenzija=new Recenzija(rs.getLong("r.recenzijaID"), rs.getDate("r.datumKreiranja"), rs.getInt("r.ocenaFilma"), rs.getString("r.utisak"), korisnik, film);
                //recenzije.add(recenzija);
                
            }
            
            return recenzije;
        } catch (Exception ex) {
            Logger.getLogger(FilmRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(Recenzija param) throws Exception {
       try{
           String query="INSERT INTO recenzija(datumKreiranja,ocenaFilma,utisak,korisnikID,filmID) VALUES(?,?,?,?,?)";
      Connection connection=db.DBConnectionFactory.getInstance().getConnection();
        PreparedStatement statement=connection.prepareStatement(query); 
        statement.setDate(1, new Date(param.getDatumKreiranja().getTime()));
       statement.setInt(2, param.getOcenaFilma());
        statement.setString(3, param.getUtisak());
        statement.setLong(4, param.getKorisnik().getId());
        statement.setLong(5, param.getFilm().getId());
       statement.executeUpdate();
       
       statement.close();
       connection.commit();
       }catch(Exception e){
           throw new Exception("Recenzija nije uspešno sačuvana!");
       }
    }

    @Override
    public void update(Recenzija param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Recenzija param) throws Exception {
        try{
            String query="DELETE FROM recenzija WHERE recenzijaID="+param.getId();
        Connection connection=DBConnectionFactory.getInstance().getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        connection.commit();
        }catch(Exception e){
            e.printStackTrace();
           throw new Exception("Recenzija nije uspešno obrisana!");
       }
        
    }

    @Override
    public List<Recenzija> getAll(Recenzija param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Recenzija> getAllByKorisnik(Recenzija param, Korisnik korisnik) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
