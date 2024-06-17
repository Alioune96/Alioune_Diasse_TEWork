package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class ParkDOA {

    private final JdbcTemplate forParkTable;

    public ParkDOA(BasicDataSource table) {
        forParkTable = new JdbcTemplate(table);

    }


}
