package com.techelevator;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

public interface CITYDOA {

    CityFORTEST get(int id) throws SQLException;
    List<CITYDOA> getAll() throws SQLException;

    int save(CityFORTEST cityForEach) throws SQLException;
    int insert(CityFORTEST cityForEach) throws SQLException;

    int update(CityFORTEST cityForEach) throws SQLException;

    int delete (CityFORTEST cityForEach) throws SQLException;
}
