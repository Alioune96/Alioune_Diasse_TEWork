package com.techelevator;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public interface DOA<T> {

    T get(int id) throws SQLException;
    List<T> getAll() throws SQLException;

    int save(T t) throws SQLException;
    int insert(String name, String lastname, String account_handle,int age, String address) throws SQLException;

    int update(String change,String again, String againtwo,int ann, String againthree,int id) throws SQLException;

    int delete (T t) throws SQLException;
}
