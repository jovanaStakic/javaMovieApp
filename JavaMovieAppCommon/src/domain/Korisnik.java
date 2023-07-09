/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Korisnik implements Serializable,GenericEntity{
    private Long id;
    private String korisnickoIme;
    private String sifra;
    private String ime;
    private String prezime;

    public Korisnik() {
    }

    public Korisnik(Long id, String korisnickoIme, String sifra, String ime, String prezime) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "korisnickoIme: " + korisnickoIme + ", sifra: " + sifra + ", ime: " + ime + ", prezime: " + prezime + '}';
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public String getInsertColumns() {
        return "korisnickoIme, sifra, ime, prezime";
    }

    @Override
    public String getInsertValues() {
        return "'"+korisnickoIme+"', '"+sifra+"', '"+korisnickoIme+"', '"+ime+"', '"+prezime+"'";
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public Long getIdOfEntity() {
        return id;
    }

    @Override
    public List<GenericEntity> resultSetToList(ResultSet rs) {
        List<GenericEntity> korisnici=new ArrayList<>();
        try{
            while(rs.next()){
                Korisnik korisnik=new Korisnik(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                korisnici.add(korisnik);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return korisnici;
    }

    @Override
    public String getJoinTables() {
        return "";
    }

    @Override
    public String getAgregateFunctions() {
        return "";
    }

    @Override
    public String getSpecaialQueryEndings() {
        return "";
    }

    @Override
    public String getKorisnikIdentification() {
        return "";
    }

    @Override
    public Map<String, String> getSearchCriteria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void afterInsert(Connection connection, Long id) throws Exception {
    }

    @Override
    public void deleteRelatedEntities(Connection connection) throws Exception {
    }

    @Override
    public String getUpdateText() {
        return "";
    }
    
    
}
