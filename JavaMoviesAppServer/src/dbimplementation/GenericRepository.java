/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbimplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import domain.GenericEntity;
import db.DBConnectionFactory;
import domain.Korisnik;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Cartman
 */
public class GenericRepository implements db.DbRepository<GenericEntity> {

    @Override
    public void add(GenericEntity entity) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getInsertColumns()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();

            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();

            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                entity.setId(id);
                System.out.println(id);
            }

            rsKey.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity param) throws Exception {
        Connection connection = DBConnectionFactory.getInstance().getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ").append(param.getTableName()).append(" WHERE id=").append(param);
    }

    @Override
    public void update(GenericEntity param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity param) throws Exception {
        List<GenericEntity> entityList;
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT *").append(param.getAgregateFunctions()).append(" FROM ").
                    append(param.getTableName()).append(param.getJoinTables()).
                    append(param.getSpecaialQueryEndings()).
                    append(param.getKorisnikIdentification());
            //param.getJoinTables()

            String query = stringBuilder.toString();
            System.out.println(query);
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            entityList = param.resultSetToList(rs);
            return entityList;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    //Promena configuracije
//ne moze korisnik, Hash Map kao naziv parametra i kljuc, prosledi kao parametar
    @Override
    public List<GenericEntity> getAllByKorisnik(GenericEntity param, Korisnik korisnik) throws Exception {
        List<GenericEntity> entityList = new ArrayList<>();
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT *").append(param.getAgregateFunctions()).append(" FROM ").
                    append(param.getTableName()).append(param.getJoinTables()).
                    append(param.getSpecaialQueryEndings()).append(" HAVING korisnikID=")
                    .append(korisnik.getId());
            //param.getJoinTables()

            String query = stringBuilder.toString();
            System.out.println(query);
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            entityList = param.resultSetToList(rs);
            return entityList;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    @Override
    public List<GenericEntity> find(GenericEntity param) throws Exception {
        List<GenericEntity> foundEntities;
        try {
            Map<String, String> criteria = param.getSearchCriteria();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();

            Map.Entry<String, String> entry = criteria.entrySet().iterator().next();
            String field = entry.getKey();
            String value = entry.getValue();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT *").append(param.getAgregateFunctions()).append(" FROM ").
                    append(param.getTableName()).append(param.getJoinTables()).
                    append(param.getSpecaialQueryEndings()).
                    append(param.getKorisnikIdentification()).
                    append(" AND ").
                    append(field).append(" = ").append(value);

            String query=stringBuilder.toString();
            ResultSet resultSet = statement.executeQuery(query);
            foundEntities = param.resultSetToList(resultSet);
            return foundEntities;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

}