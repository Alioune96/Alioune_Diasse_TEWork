package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Candy;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcCandyDao implements CandyDao {
    private BasicDataSource dataSource;
    private JdbcTemplate jdbc;

    public JdbcCandyDao() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/candy");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public int getNumberOfCandyCompetitors() {

        String sql = "SELECT COUNT(*) AS candyCount FROM candy;";

        try {
            SqlRowSet result = jdbc.queryForRowSet(sql);
            if (result.next()) {
                return result.getInt("candyCount");
            }

            throw new DaoException("Could not count the number of candy items, for some reason...");

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Bad connection string!", e);
        }
    }

    @Override
    public Candy getCandyWithHighestWinPercentage() {
        String sql = "SELECT * FROM candy ORDER BY winpercent DESC LIMIT 1;";

        try {
            SqlRowSet result = jdbc.queryForRowSet(sql);
            result.next();

            Candy c = new Candy();
            // MAPPING FROM ROWSET TO EMPTY OBJECT (using Setters on the Object and Getters on the SqlRowSet)
            c.setCompetitorName(result.getString("competitorname"));
            // ... etc etc etc etc etc ad nauseam
            return c;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Bad connection string!", e);
        }
    }
}
