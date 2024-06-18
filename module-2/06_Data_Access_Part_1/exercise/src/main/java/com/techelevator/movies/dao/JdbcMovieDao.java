package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie>returnMEE = new ArrayList<>();
        String letGO = "SELECT * FROM movie;";
        SqlRowSet thisTime = jdbcTemplate.queryForRowSet(letGO);
        while (thisTime.next()){
            Movie hello = comeOnMan(thisTime);
            returnMEE.add(hello);

        }
        return returnMEE;
    }

    @Override
    public Movie getMovieById(int id) {
        Movie kepthem = new Movie();
        String search = "SELECT * FROM movie WHERE movie_id = ?;";
        SqlRowSet theMKid = jdbcTemplate.queryForRowSet(search,id);

       while (theMKid.next()) {

           kepthem = comeOnMan(theMKid);
           return kepthem;
       }



        return null;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        if(useWildCard){
            title = "%"+title+"%";
        }
        List<Movie>theKingman = new ArrayList<>();
        String listenKid = "SELECT * FROM movie WHERE title ILIKE ?;";
        SqlRowSet myKind = jdbcTemplate.queryForRowSet(listenKid,title);
        if(myKind.wasNull()){
            List<Movie>nothing = new ArrayList<>();
            return nothing;
        }
        while(myKind.next()){
            Movie eachOne = comeOnMan(myKind);
            theKingman.add(eachOne);
        }



        return theKingman;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear,
                                                              int endYear, boolean useWildCard) {

        if(useWildCard){
            directorName = "%"+directorName+"%";
        }
        List<Movie>yolo = new ArrayList<>();
        String thisForMe = "SELECT * from movie as m\n" +
                "JOIN person as p ON p.person_id = m.director_id\n" +
                "WHERE p.person_name ILIKE ?" +" AND m.release_date BETWEEN ? AND ?;\n";

        Date myCase = new Date(startYear);
        Date secondCase = new Date(endYear);



        SqlRowSet getEm = jdbcTemplate.queryForRowSet(thisForMe,directorName,myCase,secondCase);
        if(getEm.wasNull()){
            return new ArrayList<>();
        }
        while(getEm.next()){
            Movie firstOfThem = comeOnMan(getEm);
            yolo.add(firstOfThem);
        }






        return yolo;
    }

    public static Movie comeOnMan(SqlRowSet keeper){
        Movie keepthemaway = new Movie();
        keepthemaway.setId(keeper.getInt("movie_id"));
        keepthemaway.setTitle(keeper.getString("title"));
        if(keeper.getString("overview")!=null){
            keepthemaway.setOverview(keeper.getString("overview"));
        }
        if(keeper.getString("tagline")!=null){
        keepthemaway.setTagline(keeper.getString("tagline"));
        }
        if(keeper.getString("poster_path")!=null) {
            keepthemaway.setPosterPath(keeper.getString("poster_path"));
        }
        if(keeper.getString("home_page")!=null) {
            keepthemaway.setHomePage(keeper.getString("home_page"));
        }
        if(keeper.getDate("release_date")!=null){
            keepthemaway.setReleaseDate(keeper.getDate("release_date").toLocalDate());
        }
        keepthemaway.setLengthMinutes(keeper.getInt("length_minutes"));
        if(keeper.getInt("director_id")!=0) {
            keepthemaway.setDirectorId(keeper.getInt("director_id"));
        }
        if(keeper.getInt("collection_id")!=0){
            keepthemaway.setCollectionId(keeper.getInt("collection_id"));
        }

        return keepthemaway;
    }


}
