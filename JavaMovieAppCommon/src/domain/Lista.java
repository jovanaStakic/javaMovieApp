/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Objects;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Administrator
 */
public class Lista implements Serializable,GenericEntity{
    
    private Long id;
    private String nazivListe;
    private Date datumKreiranja;
    private Korisnik korisnik;
    private List<Film> filmovi;
    
    public Lista() {
    }

    public Lista(Long id, String nazivListe, Date datumKreiranja, Korisnik korisnik,List<Film> filmovi) {
        this.id = id;
        this.nazivListe = nazivListe;
        this.datumKreiranja = datumKreiranja;
        this.korisnik = korisnik;
        this.filmovi=filmovi;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivListe() {
        return nazivListe;
    }

    public void setNazivListe(String nazivListe) {
        this.nazivListe = nazivListe;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.nazivListe);
        hash = 71 * hash + Objects.hashCode(this.datumKreiranja);
        hash = 71 * hash + Objects.hashCode(this.korisnik);
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
        final Lista other = (Lista) obj;
        if (!Objects.equals(this.nazivListe, other.nazivListe)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datumKreiranja, other.datumKreiranja)) {
            return false;
        }
        return Objects.equals(this.korisnik, other.korisnik);
    }

    @Override
    public String toString() {
        return "Lista{" + "nazivListe=" + nazivListe + ", datumKreiranja=" + datumKreiranja + ", korisnik=" + korisnik + '}';
    }

    public List<Film> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(List<Film> filmovi) {
        this.filmovi = filmovi;
    }

    @Override
    public String getTableName() {
        return "lista";
    }

    @Override
    public String getInsertColumns() {
        return "nazivListe,datumKreiranja,korisnikID";
    }

    @Override
    public String getInsertValues() {
        return "'"+nazivListe+"','"+new java.sql.Date(datumKreiranja.getTime())+"',"+korisnik.getId();
    }

    @Override
    public void setId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> resultSetToList(ResultSet rs) {
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

    @Override
    public String getKorisnikIdentification() {
         return  "HAVING korisnikID="+korisnik.getId();
    }

    @Override
    public Map<String, String> getSearchCriteria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
