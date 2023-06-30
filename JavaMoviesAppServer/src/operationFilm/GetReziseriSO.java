/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFilm;

import domain.GenericEntity;
import domain.Reziser;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class GetReziseriSO extends AbstractGenericOperation{
    List<GenericEntity> reziseri;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Reziser))
            throw new Exception("Nije reziser objekat!");
        Reziser reziser=(Reziser)param;
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        reziseri=repository.getAll(param);
    }
    public List<GenericEntity> getReziseri(){
        return reziseri;
    }
}
