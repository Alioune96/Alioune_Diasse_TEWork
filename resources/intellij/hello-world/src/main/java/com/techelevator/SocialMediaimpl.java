package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;
import java.util.List;

public class SocialMediaimpl implements SocialMediaDOA{

    private final JdbcTemplate changeToTemplate;


    public SocialMediaimpl(BasicDataSource currentDatasource){
        this.changeToTemplate= new JdbcTemplate(currentDatasource);
    }



    @Override
    public SocialMediaDOA get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<SocialMediaDOA> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(SocialMediaDOA socialMediaDOA) throws SQLException {
        return 0;
    }

    @Override
    public int insert(String firstname,String lastname, String account_handle,int age, String address) throws SQLException {
        int count = 0;
        String forSake = "INSERT INTO userinformation(first_name, last_name, account_handle, age, address) \n" +
                "VALUES \n" +
                "( ? , ? , ?, ?, ?);";
        try {
            int howmany = changeToTemplate.update(forSake,firstname,lastname,account_handle,age,address);
            count = howmany;
        }catch(RuntimeException e){
            System.out.println("this is not working" + e);
        }



        return count;
    }

    @Override
    public int update( String change,String again, String againtwo,int ann, String againthree,int id) throws SQLException {
        int count = 0;
        String sqlStuff = "UPDATE userinformation SET first_name = ?, last_name = ?, account_handle = ?, age = ?, address = ? WHERE person_id = ?;";
        try {
            int mycase = changeToTemplate.update(sqlStuff,change,again,againtwo,ann,againthree, id);
            count = mycase;

        }catch(CannotGetJdbcConnectionException e) {
            boolean sorry=true;
            while(sorry){
                System.out.println("your in hell!!!!!");
            }
        }



        return count;
    }

    @Override
    public int delete(SocialMediaDOA socialMediaDOA) throws SQLException {
        return 0;
    }
}
