/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbimplementation;

import db.DBConnection;
import domain.Korisnik;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class KorisnikRepository implements dbrepository.Repository<Korisnik>{

    @Override
    public List<Korisnik> getAll() {
        try {
            List<Korisnik> korisnici=new ArrayList<>();
            Connection connection=DBConnection.getInstance().getConnection();
            String query="SELECT * FROM korisnik";
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Korisnik k=new Korisnik(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                korisnici.add(k);
            }
            rs.close();
            statement.close();
            
            return korisnici;
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void add(Korisnik param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Korisnik param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Korisnik param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Korisnik> getAllByKorisnik(Korisnik korisnik) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
