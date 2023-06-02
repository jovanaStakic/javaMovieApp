/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Recenzija implements Serializable,GenericEntity{
    
    private Long id;
    private Date datumKreiranja;
    private int ocenaFilma;
    private String utisak;
    private Korisnik korisnik;
    private Film film;

    public Recenzija() {
    }

    public Recenzija(Long id, Date datumKreiranja, int ocenaFilma, String utisak, Korisnik korisnik, Film film) {
        this.id = id;
        this.datumKreiranja = datumKreiranja;
        this.ocenaFilma = ocenaFilma;
        this.utisak = utisak;
        this.korisnik = korisnik;
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public int getOcenaFilma() {
        return ocenaFilma;
    }

    public void setOcenaFilma(int ocenaFilma) {
        this.ocenaFilma = ocenaFilma;
    }

    public String getUtisak() {
        return utisak;
    }

    public void setUtisak(String utisak) {
        this.utisak = utisak;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.datumKreiranja);
        hash = 53 * hash + this.ocenaFilma;
        hash = 53 * hash + Objects.hashCode(this.utisak);
        hash = 53 * hash + Objects.hashCode(this.korisnik);
        hash = 53 * hash + Objects.hashCode(this.film);
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
        final Recenzija other = (Recenzija) obj;
        if (this.ocenaFilma != other.ocenaFilma) {
            return false;
        }
        if (!Objects.equals(this.utisak, other.utisak)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datumKreiranja, other.datumKreiranja)) {
            return false;
        }
        if (!Objects.equals(this.korisnik, other.korisnik)) {
            return false;
        }
        return Objects.equals(this.film, other.film);
    }

    @Override
    public String toString() {
        String kratki;
        if(utisak!=null && utisak.length()>15){
            kratki=utisak.substring(0, 15);
        }else
            kratki=utisak;
        return film.getNaziv()+" "+ datumKreiranja+" ocenaFilma: "+ocenaFilma+ " utisak: "+kratki+"...";
        
    }

    @Override
    public String getTableName() {
        return "recenzija";
    }

    @Override
    public String getInsertColumns() {
        return "datumKreiranja, ocenaFilma, utisak, korisnikID, filmID";
    }

    @Override
    public String getInsertValues() {
       return "'" + new java.util.Date() + "'," + ocenaFilma + ",'" +utisak + "', " + korisnik.getId() + ", " + film.getId();
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public List<GenericEntity> resultSetToTable(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinTables() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getAgregateFunctions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSpecaialQueryEndings() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
