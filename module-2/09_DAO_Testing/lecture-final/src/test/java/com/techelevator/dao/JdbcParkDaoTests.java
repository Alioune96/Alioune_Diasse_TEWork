package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getParkById_with_valid_id_returns_correct_park() {
        Park output = sut.getParkById(1);
        Assert.assertNotNull(output);
        assertParksMatch(PARK_1, output);

        output = sut.getParkById(2);
        Assert.assertNotNull(output);
        assertParksMatch(PARK_2, output);

        output = sut.getParkById(3);
        Assert.assertNotNull(output);
        assertParksMatch(PARK_3, output);
    }

    @Test
    public void getParkById_with_invalid_id_returns_null_park() {
        Park output = sut.getParkById(99);
        Assert.assertNull(output);

        output = sut.getParkById(-99);
        Assert.assertNull(output);
    }

    @Test
    public void getParksByState_with_valid_state_returns_correct_parks() {
        List<Park> output = sut.getParksByState("AA");
        Assert.assertNotNull(output);
        Assert.assertEquals(2, output.size());
        assertParksMatch(PARK_1, output.get(0));
        assertParksMatch(PARK_3, output.get(1));


        output = sut.getParksByState("BB");
        Assert.assertNotNull(output);
        Assert.assertEquals(1, output.size());
        assertParksMatch(PARK_2, output.get(0));


        output = sut.getParksByState("CC");
        Assert.assertNotNull(output);
        Assert.assertEquals(1, output.size());
        assertParksMatch(PARK_3, output.get(0));
    }

    @Test
    public void getParksByState_with_invalid_state_returns_empty_list() {
        List<Park> output = sut.getParksByState("ZZ");
        Assert.assertNotNull(output);
        Assert.assertEquals(0, output.size());
    }

    @Test
    public void createPark_creates_park() {
        // 2 jobs! 1. primary key (inside the object), 2. actually put it in the database
        Park newPark = new Park(-1,"Park 13", LocalDate.parse("2020-06-15"), 1300, true );

        Park output = sut.createPark(newPark); // ACT

        Assert.assertNotNull(output);
        int newParkId = output.getParkId();
        Assert.assertTrue(newParkId > 0);

        Park retrievedPark = sut.getParkById(newParkId);
        assertParksMatch(output, retrievedPark);
    }

    @Test
    public void updatePark_updates_park() {
        // BEFORE:
        Park parkToUpdate = sut.getParkById(1);

        // Mess with it:
        parkToUpdate.setArea(999);
        parkToUpdate.setHasCamping(!parkToUpdate.getHasCamping());
        parkToUpdate.setParkName("Park 13");
        parkToUpdate.setDateEstablished(LocalDate.of(2020, 12, 14));

        Park output = sut.updatePark(parkToUpdate);  // ACT
        Assert.assertNotNull(output);

        // AFTER:
        Park retrievedPark = sut.getParkById(1);

        assertParksMatch(output, retrievedPark);
    }

    @Test
    public void deleteParkById_deletes_park() {
        // DELETE IT!
        int rowsAffected = sut.deleteParkById(1);
        Assert.assertEquals(1, rowsAffected); // Prove that one row was affected

        Park output = sut.getParkById(1); // try to find it
        Assert.assertNull(output);   // prove that it's actually gone now


        rowsAffected = sut.deleteParkById(2);
        Assert.assertEquals(1, rowsAffected);
        Assert.assertNull(sut.getParkById(2));


        Assert.assertEquals(1, sut.deleteParkById(3));
        Assert.assertNull(sut.getParkById(3));
    }

    @Test
    public void linkParkState_adds_park_to_list_of_parks_in_state() {
        // BEFORE:
        int preLinkCount = sut.getParksByState("CC").size();

        sut.linkParkState(1, "CC"); // ACT

        // AFTER:
        List<Park> output = sut.getParksByState("CC");
        Assert.assertNotNull(output);
        int postLinkCount = output.size();

        Assert.assertEquals(preLinkCount + 1, postLinkCount);

        assertParksMatch(PARK_1, output.get(0));
        assertParksMatch(PARK_3, output.get(1));
    }

    @Test
    public void unlinkParkState_removes_park_from_list_of_parks_in_state() {
        // BEFORE
        int preUnlinkCount = sut.getParksByState("AA").size();

        sut.unlinkParkState(1, "AA"); // ACT

        // AFTER
        List<Park> output = sut.getParksByState("AA");

        Assert.assertEquals(preUnlinkCount - 1, output.size());
        assertParksMatch(PARK_3, output.get(0));
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
