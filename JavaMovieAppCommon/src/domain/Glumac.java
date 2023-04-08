/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Glumac implements Serializable{
    private Long id;
    private String imePrezime;
    private Date datumRodjenja;
    private String drzavaPorekla;

    public Glumac() {
    }

    public Glumac(Long id, String imePrezime, Date datumRodjenja, String drzavaPorekla) {
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
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.imePrezime);
        hash = 83 * hash + Objects.hashCode(this.datumRodjenja);
        hash = 83 * hash + Objects.hashCode(this.drzavaPorekla);
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
        return imePrezime + ", datumRodjenja: " + format.format(datumRodjenja) + ", drzavaPorekla: " + drzavaPorekla + '}';
    }
    
    
}
