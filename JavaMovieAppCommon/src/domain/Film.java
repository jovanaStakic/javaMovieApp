/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Film implements Serializable, GenericEntity{
    private Long id;
    private String naziv;
    private Date datumIzlaska;
    private int trajajanjeFilma;
    private String drzavaPorekla;
    private Korisnik korisnik;
    private Zanr zanr;
    private Reziser reziser;
    private List<Glumac> glumac;
            
    public Film() {
    }

    public Film(Long id, String naziv, Date datumIzlaska, int trajajanjeFilma, String drzavaPorekla, Korisnik korisnik, Zanr zanr, Reziser reziser) {
        this.id = id;
        this.naziv = naziv;
        this.datumIzlaska = datumIzlaska;
        this.trajajanjeFilma = trajajanjeFilma;
        this.drzavaPorekla = drzavaPorekla;
        this.korisnik = korisnik;
        this.zanr = zanr;
        this.reziser = reziser;
    }

    public Reziser getReziser() {
        return reziser;
    }

    public void setReziser(Reziser reziser) {
        this.reziser = reziser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumIzlaska() {
        return datumIzlaska;
    }

    public void setDatumIzlaska(Date datumIzlaska) {
        this.datumIzlaska = datumIzlaska;
    }

    public int getTrajajanjeFilma() {
        return trajajanjeFilma;
    }

    public void setTrajajanjeFilma(int trajajanjeFilma) {
        this.trajajanjeFilma = trajajanjeFilma;
    }

    public String getDrzavaPorekla() {
        return drzavaPorekla;
    }

    public void setDrzavaPorekla(String drzavaPorekla) {
        this.drzavaPorekla = drzavaPorekla;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.naziv);
        hash = 73 * hash + Objects.hashCode(this.datumIzlaska);
        hash = 73 * hash + this.trajajanjeFilma;
        hash = 73 * hash + Objects.hashCode(this.drzavaPorekla);
        hash = 73 * hash + Objects.hashCode(this.korisnik);
        hash = 73 * hash + Objects.hashCode(this.zanr);
        hash = 73 * hash + Objects.hashCode(this.reziser);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        if (this.trajajanjeFilma != other.trajajanjeFilma) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) 
            return false;
        
//        if (!Objects.equals(this.drzavaPorekla, other.drzavaPorekla)) {
//            return false;
//        }
////        if (!Objects.equals(this.id, other.id)) {
////            return false;
////        }
//       if (!Objects.equals(this.datumIzlaska, other.datumIzlaska)) {
//            return false;
//       }
//        if (!Objects.equals(this.korisnik, other.korisnik)) {
//            return false;
//        }
//        if (!Objects.equals(this.zanr, other.zanr)) {
//            return false;
//        }
//        return Objects.equals(this.reziser, other.reziser);
return true;
    }

    @Override
    public String toString() {
        return  naziv + " ( datumIzlaska: " + datumIzlaska + ", trajajanjeFilma:" + trajajanjeFilma + ", drzavaPorekla: " + drzavaPorekla +  ", zanr: " + zanr + ", reziser: " + reziser.getImePrezime() +" )";
    }

    @Override
    public String getTableName() {
        return "film";
    }

    @Override
    public String getInsertColumns() {
        return "naziv, datumIzlaska, trajanjeFilma, drzavaPorekla, korisnikID, zanrID, reziserID";
    }

    @Override
    public String getInsertValues() {
        
        return "'" + naziv + "','" + new java.sql.Date(datumIzlaska.getTime()) + "'," + trajajanjeFilma + ",'" + drzavaPorekla + "'," + korisnik.getId() + ","+ zanr.getId() + ","+ reziser.getId();

    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public List<GenericEntity> resultSetToTable(ResultSet rs) {
        List<GenericEntity> filmovi=new ArrayList<>();
        try{
        while (rs.next()) {            
            Zanr zanr=new Zanr(rs.getLong("z.zanrID"),rs.getString("z.nazivZanra"));
                Reziser reziser=new Reziser(rs.getLong("r.reziserID"), rs.getString("r.imePrezime"), rs.getDate("r.datumRodjenja"), rs.getString("r.drzavaPorekla"));
                Film film=new Film(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), korisnik, zanr, reziser);
                filmovi.add(film);
        }}catch(Exception e){
            e.printStackTrace();
        }
        return filmovi;
    }
    
    
}
