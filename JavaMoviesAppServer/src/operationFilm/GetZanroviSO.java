/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFilm;

import domain.Film;
import domain.GenericEntity;
import domain.Korisnik;
import domain.Zanr;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class GetZanroviSO extends AbstractGenericOperation{
    List<GenericEntity> zanrovi;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Zanr)) {
            throw new Exception("Neispravan zanr objekat!");
        }
        Zanr zanr = (Zanr) param;
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        zanrovi=repository.getAll(param);
    }
      public List<GenericEntity> getZanrovi() {
        return zanrovi;
    }
}
