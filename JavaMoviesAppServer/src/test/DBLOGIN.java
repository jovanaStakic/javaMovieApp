/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import dbimplementation.RecenzijaRepository;
import domain.Korisnik;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class DBLOGIN {
    public static void main(String[] args) {
        RecenzijaRepository rs=new RecenzijaRepository();
        Korisnik korisnik=new Korisnik(1l, "jovana123", "jovana123", "Jovana", "Stakic");
        rs.getAllByKorisnik(korisnik);
    }
}
