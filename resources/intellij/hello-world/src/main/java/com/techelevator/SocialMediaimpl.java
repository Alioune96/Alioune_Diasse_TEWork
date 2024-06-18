package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public int insert(SocialMediaDOA socialMediaDOA) throws SQLException {
        return 0;
    }

    @Override
    public int update(SocialMediaDOA socialMediaDOA) throws SQLException {
        return 0;
    }

    @Override
    public int delete(SocialMediaDOA socialMediaDOA) throws SQLException {
        return 0;
    }
}
