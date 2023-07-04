/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dbrepository;


import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface Repository<T> {
    List<T> getAll(T param) throws Exception;
    void add(T param) throws Exception;
    void update(T param) throws Exception;
    void delete(T param) throws Exception;
    List<T> find(T param) throws Exception;
}
