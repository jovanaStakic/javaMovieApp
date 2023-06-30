/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFilm;

import domain.GenericEntity;
import domain.Glumac;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Administrator
 */
public class GetGlumciSO extends AbstractGenericOperation{
    List<GenericEntity> glumci;
    @Override
    protected void preconditions(Object param) throws Exception {
             if (!(param instanceof Glumac)) {
            throw new Exception("Neispravan glumac objekat!");
        }
        Glumac film = (Glumac) param;
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        glumci=repository.getAll(param);
    }
    public List<GenericEntity> getGlumci() {
        return glumci;
    }
}
