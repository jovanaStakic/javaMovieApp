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
public class Glumac implements Serializable,GenericEntity{
    private Long id;
    private String imePrezime;
    

    public Glumac() {
    }

    public Glumac(Long id, String imePrezime) {
        this.id = id;
        this.imePrezime = imePrezime;
       
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.imePrezime);
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
        final Glumac other = (Glumac) obj;
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return imePrezime ;
    }

    @Override
    public String getTableName() {
        return "glumac";
    }

    @Override
    public String getInsertColumns() {
        return "imePrezime";
    }
    

    @Override
    public String getInsertValues() {
        return "'"+imePrezime+"'";
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public List<GenericEntity> resultSetToList(ResultSet rs) {
        List<GenericEntity> glumci=new ArrayList<>();
        try{
            while(rs.next()){
                Glumac glumac=new Glumac(rs.getLong(1), rs.getString(2));
                glumci.add(glumac);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return glumci;
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
    public Long getIdOfEntity() {
        return id;
    }


     @Override
    public void afterInsert(Connection connection, Long id) throws Exception{
    }

    @Override
    public void deleteRelatedEntities(Connection connection) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
}
