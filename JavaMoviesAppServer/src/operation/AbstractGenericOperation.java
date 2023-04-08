/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import db.DbRepository;

import dbimplementation.RepositoryDBGeneric;

/**
 *
 * @author Cartman
 */
public abstract class AbstractGenericOperation {

    protected final DbRepository repository;

    public AbstractGenericOperation() {
        this.repository = new RepositoryDBGeneric();
    }

    public final void execute(Object param) throws Exception {
        try {
            preconditions(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        } finally {
            disconnect();
        }
    }

    // Operation-specific method
    protected abstract void preconditions(Object param) throws Exception;

    private void startTransaction() throws Exception {
        repository.connect();
    }

    // Operation-specific method
    protected abstract void executeOperation(Object param) throws Exception;

    private void commitTransaction() throws Exception {
        repository.commit();
    }

    private void rollbackTransaction() throws Exception {
        repository.rollback();
    }

    private void disconnect() throws Exception {
       repository.disconnect();
    }

}
