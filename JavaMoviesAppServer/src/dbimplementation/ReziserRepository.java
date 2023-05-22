/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbimplementation;

import dbrepository.Repository;
import domain.Korisnik;
import domain.Reziser;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class ReziserRepository implements Repository<Reziser>{

   
    public List<Reziser> getAll() {
        List<Reziser> reziseri=new ArrayList<>();
        try {
            Connection connection=db.DBConnectionFactory.getInstance().getConnection();
            String query="SELECT * FROM reziser ORDER BY imePrezime";
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Reziser reziser=new Reziser(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getString(4));
                reziseri.add(reziser);
            }
            return reziseri;
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(ReziserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void add(Reziser param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Reziser param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Reziser param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public List<Reziser> getAll(Reziser param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Reziser> getAllByKorisnik(Reziser param, Korisnik korisnik) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
