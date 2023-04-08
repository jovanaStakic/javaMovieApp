/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Korisnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class KorisnikTableModel extends AbstractTableModel{
    String[] columns=new String[]{"Ime","Prezime","Korisničko ime"};
    List<Korisnik> korisnici;
    
    public KorisnikTableModel(){
        korisnici=new ArrayList<>();
    }

    public KorisnikTableModel(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
    
    
    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
 public void refresh(List<Korisnik> korisnici){
       this.korisnici=korisnici;
       fireTableDataChanged();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik korisnik=korisnici.get(rowIndex);
        
       switch (columnIndex) {
            case 0: return korisnik.getIme();
            case 1: return korisnik.getPrezime();
            case 2: return korisnik.getKorisnickoIme();
            default:
              return "N/A";
        }
        
        
    }
   
}
