/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationRecenzija;

import domain.Film;
import domain.GenericEntity;
import domain.Recenzija;
import java.util.List;
import java.util.Map;
import operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class GetRecenzijeSO extends AbstractGenericOperation{
   List<GenericEntity> recenzije;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Recenzija)) {
            throw new Exception("Neispravan recenzija objekat!");
        }
        Recenzija recenzija = (Recenzija) param;
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        recenzije=repository.getAll(param);
    }
    
    public List<GenericEntity> getRecenzije(){
        return recenzije;
    }
}
