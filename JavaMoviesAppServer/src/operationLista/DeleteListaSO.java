/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationLista;

import domain.Lista;
import operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class DeleteListaSO extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Lista)) {
            throw new Exception("Neispravan recenzija objekat!");
        }
        Lista lista=(Lista) param;
        if(lista.getId()<0)
            throw new Exception("Neispravan id liste koja se brise!");
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete(param);
    }
    
}
