/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Lista extends SearchingEntity implements Serializable {

    private Long id;
    private String nazivListe;
    private Date datumKreiranja;
    private Korisnik korisnik;
    private List<Film> filmovi;

    public Lista() {
    }

    public Lista(Long id, String nazivListe, Date datumKreiranja, Korisnik korisnik, List<Film> filmovi) {
        this.id = id;
        this.nazivListe = nazivListe;
        this.datumKreiranja = datumKreiranja;
        this.korisnik = korisnik;
        this.filmovi = filmovi;
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
        return "Lista{" + "nazivListe=" + nazivListe + ", datumKreiranja=" + datumKreiranja ;
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
        return "'" + nazivListe + "','" + new java.sql.Date(datumKreiranja.getTime()) + "'," + korisnik.getId();
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    @Override
    public List<GenericEntity> resultSetToList(ResultSet rs) {
        Map<Long, Lista> liste = new HashMap<>();
try{
    while (rs.next()) {
        Long listaId = rs.getLong("id");

        // Ako lista već postoji u mapi, preuzmite je
        // Inače, kreirajte novu listu i dodajte je u mapu
        Lista lista = liste.getOrDefault(listaId, null);
        if (lista == null) {
            lista = new Lista(listaId, rs.getString("nazivListe"), rs.getDate("datumKreiranja")
                    , korisnik, new ArrayList<>());
            
            liste.put(listaId, lista);
        }

     
        Zanr zanr=new Zanr(rs.getLong("zanrID"),null);
        Reziser reziser=new Reziser(rs.getLong("reziserID"),null,null,null);
        
        Film film = new Film(rs.getLong("film.id"), rs.getString("naziv"), rs.getDate("datumIzlaska"), 
                rs.getInt("trajanjeFilma"), rs.getString("drzavaPorekla"), korisnik, zanr, reziser, new ArrayList<>());
        
        lista.getFilmovi().add(film);
    }}catch(Exception e){
        e.printStackTrace();
    }

    return new ArrayList<>(liste.values());
    }

    @Override
    public String getJoinTables() {
        return " LEFT JOIN lf ON lista.id = lf.listaID " +
"LEFT JOIN Film  ON lf.FilmID = film.id ";
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
        return " HAVING lista.korisnikID=" + korisnik.getId();
    }

   

    @Override
    public Long getIdOfEntity() {
        return this.id;
    }

    @Override
    public void afterInsert(Connection connection, Long id) throws Exception {
        System.out.println(getFilmovi());
          for (Film film : getFilmovi()) { 
            String query = "INSERT INTO LF (ListaID, FilmID) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
           
            statement.setLong(1, id);
            statement.setLong(2, film.getId());
            System.out.println(query); 
            statement.executeUpdate();
              
        }
    }

    @Override
    public void setSearchCriteria() {
        if(nazivListe!=null){
            searchCriteria.put("nazivListe","'"+nazivListe+"'");
        }
            
    }

    @Override
    public void deleteRelatedEntities(Connection connection) throws Exception {
        String query = "DELETE FROM lf WHERE ListaID ="+id;
        Statement statement=connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
        }

    @Override
    public String getUpdateText() {
         return "nazivListe = '" + nazivListe + "'";
    }

   
    
  
}



