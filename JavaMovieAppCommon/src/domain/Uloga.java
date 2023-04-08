/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Uloga implements Serializable{
    private Glumac glumac;
    private Film film;
    private String nazivUloge;

    public Uloga() {
    }

    public Uloga(Glumac glumac, Film film, String nazivUloge) {
        this.glumac = glumac;
        this.film = film;
        this.nazivUloge = nazivUloge;
    }

    public String getNazivUloge() {
        return nazivUloge;
    }

    public void setNazivUloge(String nazivUloge) {
        this.nazivUloge = nazivUloge;
    }

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.glumac);
        hash = 97 * hash + Objects.hashCode(this.film);
        hash = 97 * hash + Objects.hashCode(this.nazivUloge);
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
        final Uloga other = (Uloga) obj;
        if (!Objects.equals(this.nazivUloge, other.nazivUloge)) {
            return false;
        }
        if (!Objects.equals(this.glumac, other.glumac)) {
            return false;
        }
        return Objects.equals(this.film, other.film);
    }

    @Override
    public String toString() {
        return "Uloga{" + "glumac=" + glumac + ", film=" + film + ", nazivUloge=" + nazivUloge + '}';
    }
    
    
            
}
