/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Film;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class FilmTableModel extends AbstractTableModel{
    List<Film> filmovi;
    String[] columns=new String[]{"Naziv", "DatumIzlaska", "TrajanjeFilma", "DrzavaPorekla"};
    
    public FilmTableModel(){
        filmovi=new ArrayList<>();
    }
    
    public FilmTableModel(List<Film> filmovi){
        this.filmovi=filmovi;
    }
    
    @Override
    public int getRowCount() {
        return filmovi.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Film film=filmovi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return film.getNaziv();
            case 1:
                return film.getDatumIzlaska();
            case 2:
                return film.getTrajajanjeFilma();
            case 3:
                return film.getDrzavaPorekla();
            default:
                return "N/A";
        }
    }
    public void delete(Film film){
        filmovi.remove(film);
        System.out.println("Delelte: "+film.getId());
        fireTableDataChanged();
    }
    
    public void add(Film film){
        filmovi.add(film);
        System.out.println("Add: "+film.getId());
        fireTableDataChanged();
        
    }
    
    public Film getFilm(int row){
        return filmovi.get(row);
    }
    
    public List<Film> getFilmovi(){
        System.out.println("IZ TABLE: \n"+filmovi.toString()+"\n");
        return filmovi;
    }
}
