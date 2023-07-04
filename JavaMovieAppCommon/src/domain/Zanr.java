/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Zanr implements Serializable,GenericEntity
{
    private Long id;
    private String nazivZanra;

    public Zanr() {
    }

    
    public Zanr(Long id, String nazivZanra) {
        this.id = id;
        this.nazivZanra = nazivZanra;
    }

    public String getNazivZanra() {
        return nazivZanra;
    }

    public void setNazivZanra(String nazivZanra) {
        this.nazivZanra = nazivZanra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nazivZanra);
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
        final Zanr other = (Zanr) obj;
        if (!Objects.equals(this.nazivZanra, other.nazivZanra)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return nazivZanra ;
    }

    @Override
    public String getTableName() {
        return "zanr";
    }

    @Override
    public String getInsertColumns() {
        return "nazivZanra";
    }

    @Override
    public String getInsertValues() {
        return "'"+nazivZanra+"'";
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public List<GenericEntity> resultSetToList(ResultSet rs) {
        List<GenericEntity> zanrovi=new ArrayList<>();
        try {
            while(rs.next()){
                Zanr z=new Zanr(rs.getLong(1), rs.getString(2));
                zanrovi.add(z);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Zanr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zanrovi;
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
