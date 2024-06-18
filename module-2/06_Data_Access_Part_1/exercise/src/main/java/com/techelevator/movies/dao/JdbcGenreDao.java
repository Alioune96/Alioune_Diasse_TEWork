package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> getITT = new ArrayList<>();
        String sqlMan = "SELECT * FROM genre;";
        SqlRowSet moveYourBody = jdbcTemplate.queryForRowSet(sqlMan);
        while(moveYourBody.next()){
            Genre myFriend = thisKid(moveYourBody);
            getITT.add(myFriend);
        }
        return getITT;
    }

    @Override
    public Genre getGenreById(int id) {
        Genre thistheOne = new Genre();
        String yeahIhear = "SELECT * FROM genre WHERE genre_id = ?;";
        SqlRowSet ifITakeUHome = jdbcTemplate.queryForRowSet(yeahIhear,id);
        if(ifITakeUHome.next()){
            thistheOne.setId(ifITakeUHome.getInt("genre_id"));
            thistheOne.setName(ifITakeUHome.getString("genre_name"));
            return thistheOne;
        }

        return null;
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        List<Genre> listenMan = new ArrayList<>();
        if(useWildCard){
            name = "%"+name+"%";
        }
        String hi = "SELECT * FROM genre WHERE genre_name ILIKE ?;";
        SqlRowSet thisuhh = jdbcTemplate.queryForRowSet(hi, name);
        if(thisuhh.wasNull()){
            List<Genre>hh = new ArrayList<>();
            return hh;
        }
        while (thisuhh.next()){
            Genre yoo = thisKid(thisuhh);
            listenMan.add(yoo);
        }

        return listenMan;
    }

    public static Genre thisKid(SqlRowSet thisNow){
        Genre haha = new Genre();
        haha.setId(thisNow.getInt("genre_id"));
        haha.setName(thisNow.getString("genre_name"));

        return haha;
    }
}
