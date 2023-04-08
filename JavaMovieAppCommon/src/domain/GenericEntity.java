/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author student2
 */
public interface GenericEntity extends Serializable {

    String getTableName();

    String getInsertColumns();

    String getInsertValues();

    void setId(long id);

}
