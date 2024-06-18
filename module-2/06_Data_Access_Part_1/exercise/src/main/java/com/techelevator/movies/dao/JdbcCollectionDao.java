package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection>haha = new ArrayList<>();
        String everything = "SELECT * FROM collection;";
        SqlRowSet forFun = jdbcTemplate.queryForRowSet(everything);

        while(forFun.next()){
//            int forPeace = forFun.getInt("collection_id");
//            String forKeep = forFun.getString("collection_name");
            Collection placeThis = getCollect(forFun);
            haha.add(placeThis);

        }
        return haha;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection returnBaby = new Collection();
        String statememtBaby = "SELECT * FROM collection WHERE collection_id = ? LIMIT 1;";
        SqlRowSet forCause = jdbcTemplate.queryForRowSet(statememtBaby, id);
        if(forCause.next()){
            if(forCause.getString("collection_name") != null){
                returnBaby.setName(forCause.getString("collection_name"));
                returnBaby.setId(forCause.getInt("collection_id"));
                return returnBaby;
            }
        }

        return null;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        if(useWildCard){
            name = "%"+name+"%";
        }
        List<Collection> tacataBro = new ArrayList<>();
        String keepHer = "SELECT * FROM collection WHERE collection_name ILIKE ?;";
        SqlRowSet thatMe = jdbcTemplate.queryForRowSet(keepHer,name);
        while(thatMe.next()){
           Collection hiaa = getCollect(thatMe);
           tacataBro.add(hiaa);
        }



        return tacataBro;
    }

    public Collection getCollect(SqlRowSet keepHer){
        Collection playerCuz = new Collection();
        playerCuz.setId(keepHer.getInt("collection_id"));
        playerCuz.setName(keepHer.getString("collection_name"));

        return playerCuz;
    }

}
