/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Reziser implements Serializable,GenericEntity{
    private Long id;
    private String imePrezime;
    private Date datumRodjenja;
    private String drzavaPorekla;

    public Reziser() {
    }

    public Reziser(Long id, String imePrezime, Date datumRodjenja, String drzavaPorekla) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.datumRodjenja = datumRodjenja;
        this.drzavaPorekla = drzavaPorekla;
    }

    public String getDrzavaPorekla() {
        return drzavaPorekla;
    }

    public void setDrzavaPorekla(String drzavaPorekla) {
        this.drzavaPorekla = drzavaPorekla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.imePrezime);
        hash = 29 * hash + Objects.hashCode(this.datumRodjenja);
        hash = 29 * hash + Objects.hashCode(this.drzavaPorekla);
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
        final Reziser other = (Reziser) obj;
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        if (!Objects.equals(this.drzavaPorekla, other.drzavaPorekla)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.datumRodjenja, other.datumRodjenja);
    }

    @Override
    public String toString() {
        SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy");
        return imePrezime + "( datumRodjenja: " + format.format(datumRodjenja) + ", drzavaPorekla: " + drzavaPorekla +" )" ;
    }

    @Override
    public String getTableName() {
        return "reziser";
    }

    @Override
    public String getInsertColumns() {
        return "imePrezime, datumRodjenja, drzavaPorekla";
    }

    @Override
    public String getInsertValues() {
        return "'"+imePrezime+"', '"+new java.sql.Date(datumRodjenja.getTime())+"', "+drzavaPorekla;
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public List<GenericEntity> resultSetToList(ResultSet rs) {
        List<GenericEntity> reziseri=new ArrayList<>();
        try {
            while(rs.next()){
                Reziser r=new Reziser(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getString(4));
                reziseri.add(r);
            }
        } catch (Exception e) {
        }
        return reziseri;
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
    public Long getIdForDelete() {
        return id;
    }
      @Override
    public void afterInsert(Connection connection, Long id) throws Exception{
    }

    @Override
    public void deleteRelatedEntities(Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
