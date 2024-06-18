package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Park;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int parkCount = 0;
        String sql = "SELECT COUNT(*) AS count FROM park;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		if (results.next()) {
			parkCount = results.getInt("count");
		} 
        return parkCount;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();
        String sql = "SELECT park_name FROM park ORDER by park_name ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parkNames.add(results.getString("park_name"));
        }
        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park ORDER BY RANDOM() LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE has_camping = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " +
                     "FROM park p " +
                     "JOIN park_state ps ON p.park_id = ps.park_id " +
                     "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park createPark(Park park) {

        String sql = "INSERT INTO park (park_name, date_established, area, has_camping) " +
                     "VALUES (?, ?, ?, ?) RETURNING park_id;";
        try {
            int newParkId = jdbcTemplate.queryForObject(sql, int.class,
                    park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping());

            return getParkById(newParkId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Couldn't find the database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
    }

    @Override
    public Park updatePark(Park park) {

        // UPDATE table SET col1 = ?, col2 = ?, col3 = ?.... WHERE primary_key = ?;
        String sql = "UPDATE park SET park_name = ?, date_established = ?, area = ?, has_camping = ? " +
                     "WHERE park_id = ?;";
        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping(), park.getParkId());

            if (rowsAffected == 0) {
                throw new DaoException("Couldn't find Park with park_id = " + park.getParkId());
            } else {
                return getParkById(park.getParkId());
            }
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("You messed up", e);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("System is down", e);
        }
    }

    @Override
    public int deleteParkById(int parkId) {

        // Remove associations before removing entity
        String removeAssociations = "DELETE FROM park_state WHERE park_id = ?;";

        // DELETE FROM table WHERE primary_key = ?
        String removeEntity = "DELETE FROM park WHERE park_id = ?;";

        String letsTryIt = "DELETE FROM park_state WHERE park_id = ? ; DELETE FROM park WHERE park_id = ? ;";

        try {
            int whoKnows = jdbcTemplate.update(letsTryIt, parkId, parkId);
            System.out.println(whoKnows + " rows affected!");
//            int rowsAffectedByAssociations = jdbcTemplate.update(removeAssociations, parkId);
//            int rowsAffectedByEntity = jdbcTemplate.update(removeEntity, parkId);

            return whoKnows;
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Have some integrity!", e);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Couldn't connect!", e);
        }
    }

    @Override
    public void linkParkState(int parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state (park_id, state_abbreviation) " +
                     "VALUES (?, ?);";

        try {
            jdbcTemplate.update(sql, parkId, stateAbbreviation);
        } catch(DataIntegrityViolationException e) {
            throw new DaoException("That park is already in that state!", e);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Database not found!", e);
        }
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));
        return park;
    }
}
