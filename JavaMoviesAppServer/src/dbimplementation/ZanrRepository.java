/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbimplementation;

import domain.*;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ZanrRepository implements dbrepository.Repository<Zanr>{

    
    public List<Zanr> getAll() {
        List<Zanr> zanrovi=new ArrayList<>();
        try {
            String query="SELECT * FROM zanr ORDER BY nazivZanra";
            Connection connection=db.DBConnectionFactory.getInstance().getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                Zanr zanr=new Zanr(rs.getLong(1), rs.getString(2));
                zanrovi.add(zanr);
            }
            return zanrovi;
        } catch (Exception ex) {
           ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void add(Zanr param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Zanr param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Zanr param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public List<Zanr> getAll(Zanr param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Zanr> getAllByKorisnik(Zanr param, Korisnik korisnik) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
