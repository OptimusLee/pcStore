package za.ac.cput.cuanlee.services;

import za.ac.cput.cuanlee.domain.PC.RAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by CuanL on 10/08/2016.
 */
public interface Service <E, ID>{
    //Adds a new Record
    E add(E entity);

    //Updates A Record
    E update(E entity);

    //Gets A Single Record
    E getById(ID id);

    //Gets All -Default
    List<E> getAll();

    //GetAll Active STock
    List<E> getAllActive();

    //Gets a Total Stock
    int getTotalStock();

    //Deletes A Record
    void delete(E entity);

    //Delete All Records
    void deleteAll();
}
