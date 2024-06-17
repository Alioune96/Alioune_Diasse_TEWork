package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;
import java.util.List;

public class CityDOAImpl implements CityDOA{
    private JdbcTemplate changeConnection;

    public CityDOAImpl(BasicDataSource handOver){
        changeConnection = new JdbcTemplate(handOver);
    }

    public void printEver(){
        String sqlQuerytest = "SELECT * FROM city";
        SqlRowSet manthis = changeConnection.queryForRowSet(sqlQuerytest);
        while(manthis.next()){
            int cityid = manthis.getInt("city_id");
            System.out.println(cityid);
        }
    }

    public void tryME(){
        printEver();
    }

    @Override
    public CityDOA get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<CityDOA> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(CityDOA city) throws SQLException {
        return 0;
    }

    @Override
    public int insert(CityDOA city) throws SQLException {
        return 0;
    }

    @Override
    public int update(CityDOA city) throws SQLException {
        return 0;
    }

    @Override
    public int delete(CityDOA city) throws SQLException {
        return 0 ;
    }
}
