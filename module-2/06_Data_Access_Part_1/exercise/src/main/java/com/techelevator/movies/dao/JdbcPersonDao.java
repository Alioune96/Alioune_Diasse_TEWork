package com.techelevator.movies.dao;

import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> kitKat = new ArrayList<>();
        String jjJeff = "SELECT * FROM person;";
        SqlRowSet cheapOne = jdbcTemplate.queryForRowSet(jjJeff);

        while (cheapOne.next()){
            Person oneMan = createrHer(cheapOne);
            kitKat.add(oneMan);
        }

        return kitKat;
    }

    @Override
    public Person getPersonById(int id) {
        Person thatGuy;
        String sql = "SELECT * FROM person WHERE person_id = ?;";
        SqlRowSet nowThen = jdbcTemplate.queryForRowSet(sql,id);
        if(nowThen.next()){
            if(!nowThen.wasNull()){
                thatGuy = createrHer(nowThen);
return thatGuy;
            }
        }



        return null;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        if(useWildCard){
            name = "%"+name+"%";
        }
        List<Person>waitWhat = new ArrayList<>();
        String sqlStuff = "SELECT * FROM person WHERE person_name ILIKE ?;";
        SqlRowSet listenMoon = jdbcTemplate.queryForRowSet(sqlStuff, name);
        while (listenMoon.next()){
            Person oneKning = createrHer(listenMoon);
            waitWhat.add(oneKning);
        }


        return waitWhat;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        if(useWildCard){
            collectionName = "%"+collectionName+"%";
        }
        Person tagHold;
        List<Person> thatWay = new ArrayList<>();
        String comMand = "SELECT DISTINCT p.person_id ,p.person_name, p.birthday, p.deathday, p.biography, p.profile_path,p.home_page FROM person as p \n" +
                "JOIN movie_actor AS ma ON p.person_id = ma.actor_id\n" +
                "JOIN movie AS m ON ma.movie_id = m.movie_id\n" +
                "JOIN collection AS c ON m.collection_id = c.collection_id\n" +
                "WHERE c.collection_name ILIKE ?\n" +
                "ORDER BY person_name;";
        SqlRowSet tryThishaha = jdbcTemplate.queryForRowSet(comMand,collectionName);

        if(tryThishaha.wasNull()){
            return new ArrayList<>();
        }

            while (tryThishaha.next()){
            tagHold = createrHer(tryThishaha);
            thatWay.add(tagHold);
        }



        return thatWay;
    }

    public static Person createrHer(SqlRowSet james){
        Person yMeTho = new Person();
        yMeTho.setId(james.getInt("person_id"));
        yMeTho.setName(james.getString("person_name"));
        if(james.getDate("birthday")!=null){
            yMeTho.setBirthday(james.getDate("birthday").toLocalDate());
        }
        if(james.getDate("deathday")!=null){
            yMeTho.setDeathDate(james.getDate("deathday").toLocalDate());
        }
        if(james.getString("biography")!=null){
            yMeTho.setBiography(james.getString("biography"));
        }
        if(james.getString("profile_path")!=null){
            yMeTho.setProfilePath(james.getString("profile_path"));
        }

        if(james.getString("home_page")!=null){
            yMeTho.setHomePage(james.getString("home_page"));
        }


        return yMeTho;
    }
}
