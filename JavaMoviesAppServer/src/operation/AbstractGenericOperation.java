package operation;

import db.DbRepository;

import dbimplementation.RepositoryDBGeneric;
import domain.Korisnik;

/**
 * @author Administrator
*/
public abstract class AbstractGenericOperation {

    protected final DbRepository repository;

    public AbstractGenericOperation() {
        this.repository = new RepositoryDBGeneric();
    }

    public final void execute(Object param,Korisnik korisnik) throws Exception {
        try {
            preconditions(param);
            startTransaction();
            executeOperation(param,korisnik);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        } finally {
            disconnect();
        }
    }

   
    protected abstract void preconditions(Object param) throws Exception;

    private void startTransaction() throws Exception {
        repository.connect();
    }

  
    protected abstract void executeOperation(Object param,Korisnik korisnik) throws Exception;

    private void commitTransaction() throws Exception {
        System.out.println("komituje");
        repository.commit();
    }

    private void rollbackTransaction() throws Exception {
        repository.rollback();
    }

    private void disconnect() throws Exception {
       repository.disconnect();
    }

}
