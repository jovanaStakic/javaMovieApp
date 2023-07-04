/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationRecenzija;
import dbrepository.Repository;
import domain.Korisnik;
import domain.Recenzija;
import operation.AbstractGenericOperation;
/**
 *
 * @author Administrator
 */
public class SaveRecenizijaSO extends AbstractGenericOperation{
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Recenzija))
            throw new Exception("Neispravan objekat Recenzije!");
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add(param);
    }
    
}
