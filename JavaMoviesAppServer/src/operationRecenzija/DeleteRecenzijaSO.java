/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationRecenzija;

import domain.Recenzija;
import operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class DeleteRecenzijaSO extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
            if (!(param instanceof Recenzija)) {
            throw new Exception("Neispravan recenzija objekat!");
        }
        Recenzija recenzija = (Recenzija) param;
        if(recenzija.getId()<0)
            throw new Exception("Neispravan id recenzije koja se brise!");
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete(param);
    }
    
}
