 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbimplementation;

import java.sql.*;
import dbrepository.Repository;
import domain.Korisnik;
import domain.Lista;
import domain.Film;
import domain.GenericEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class ListaRepository implements Repository<Lista>{

  

    @Override
    public void add(Lista param) throws Exception {
        Connection connection=db.DBConnectionFactory.getInstance().getConnection();
        String query="INSERT INTO lista(nazivListe,datumKreiranja,korisnikID) VALUES (?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, param.getNazivListe());
        preparedStatement.setDate(2, new Date(param.getDatumKreiranja().getTime()));
        preparedStatement.setLong(3, param.getKorisnik().getId());
        preparedStatement.executeUpdate();
        ResultSet rs=preparedStatement.getGeneratedKeys();
        List<Long> keys=new ArrayList<>();
        if(rs.next()){
            Long idListe=rs.getLong(1);
            query="INSERT INTO film(naziv,datumIzlaska, trajanjeFilma, drzavaPorekla, korisnikID, zanrID, reziserID) VALUES (?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            List<GenericEntity> filmovi=controller.Controller.getInstance().getAllFilmoviByKorisnik(param.getKorisnik());

            for (Film film : param.getFilmovi()) {
                keys.add(film.getId());
                if(!filmovi.contains(film)){
            
                    
            preparedStatement.setString(1, film.getNaziv());
            preparedStatement.setDate(2, new Date(film.getDatumIzlaska().getTime()));
            preparedStatement.setInt(3, film.getTrajajanjeFilma());
            preparedStatement.setString(4, film.getDrzavaPorekla());
            preparedStatement.setLong(5, film.getKorisnik().getId());
            preparedStatement.setLong(6, film.getZanr().getId());
            preparedStatement.setLong(7, film.getReziser().getId());
            preparedStatement.executeUpdate();
            rs=preparedStatement.getGeneratedKeys();
            
            if(rs.next())
                keys.add(rs.getLong(1));
                }
            }
            connection.commit();
           String queryLF="INSERT INTO lf VALUES (?,?)"; 
           preparedStatement=connection.prepareStatement(queryLF);
            for (Long key : keys) {
                preparedStatement.setLong(1, idListe);
                preparedStatement.setLong(2, key);
                preparedStatement.executeUpdate();
            }
        }
        
             connection.commit();
    }

    @Override
    public void update(Lista param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lista param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Lista> getAll(Lista param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Lista> getAllByKorisnik(Lista param, Korisnik korisnik) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
