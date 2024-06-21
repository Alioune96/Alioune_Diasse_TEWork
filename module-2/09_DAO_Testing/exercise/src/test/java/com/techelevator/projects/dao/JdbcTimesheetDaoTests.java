package com.techelevator.projects.dao;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {
        Timesheet myGirl = dao.getTimesheetById(TIMESHEET_1.getTimesheetId());
        assertTimesheetsMatch(myGirl,TIMESHEET_1);
        Timesheet whereWeAre  = dao.getTimesheetById(TIMESHEET_2.getTimesheetId());
        assertTimesheetsMatch(TIMESHEET_2,whereWeAre);
        Timesheet nowListenUp  = dao.getTimesheetById(TIMESHEET_3.getTimesheetId());
        assertTimesheetsMatch(TIMESHEET_3,nowListenUp);
        Timesheet kitKat = dao.getTimesheetById(TIMESHEET_4.getTimesheetId());
        assertTimesheetsMatch(TIMESHEET_4,kitKat);



//        Assert.fail();
    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        int n = 5;
        Timesheet forLaughts = null;
        while(n<10){
            Assert.assertNull(dao.getTimesheetById(n));
            n++;
        }
        assertEquals(forLaughts,dao.getTimesheetById(8));



    }

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {


        List<Timesheet>keepUp = dao.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(2,keepUp.size());
        List<Timesheet>cuzlistenUphereaStory = dao.getTimesheetsByEmployeeId(TIMESHEET_3.getEmployeeId());

        assertEquals(2,cuzlistenUphereaStory.size());
//       assertTimesheetsMatch(TIMESHEET_2,keepUp.get(0));



    }

    @Test
    public void getTimesheetsByEmployeeId_with_invalid_employee_id_returns_empty_list_of_timesheets() {
        List<Timesheet> asdsa = new ArrayList<>();
Assert.assertEquals(asdsa,dao.getTimesheetsByEmployeeId(5));
int b = 6;
while (b<10){
    Assert.assertEquals(asdsa,dao.getTimesheetsByEmployeeId(b));
    b++;
}
        Assert.assertNotNull(asdsa);

    }

    @Test
    public void getTimesheetsByProjectId_with_valid_project_id_returns_list_of_all_timesheets_for_project() {
        List<Timesheet>sdas = dao.getTimesheetsByProjectId(2);
        List<Timesheet>imReallyquickCallmeflash = dao.getTimesheetsByProjectId(TIMESHEET_1.getTimesheetId());

        assertEquals(1,sdas.size());
        assertEquals(3,imReallyquickCallmeflash.size());



    }

    @Test
    public void getTimesheetsByProjectId_with_invalid_project_id_returns_empty_list_of_timesheets() {
        List<Timesheet>pickItup = new ArrayList<>();
        List<Timesheet>doyoureallywantProblem = dao.getTimesheetsByProjectId(6);
        Assert.assertTrue(doyoureallywantProblem.size()==0);
        Assert.assertEquals(pickItup,doyoureallywantProblem);




    }

    @Test
    public void createTimesheet_creates_timesheet() {
        Timesheet listUp = new Timesheet(5, 2, 1,
                LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
        Timesheet hushMoney;

        hushMoney = dao.createTimesheet(listUp);
        assertNotNull(hushMoney);

        int myMoney = hushMoney.getTimesheetId();
        Assert.assertTrue(myMoney==5);
        Timesheet keepItReal = dao.getTimesheetById(myMoney);
        assertTimesheetsMatch(hushMoney,keepItReal);




    }

    @Test
    public void updateTimesheet_updates_timesheet() {
      TIMESHEET_2.setProjectId(1);

      TIMESHEET_2.setBillable(true);
      Timesheet myBad = dao.updateTimesheet(TIMESHEET_2);
      Timesheet whyMee = dao.getTimesheetById(TIMESHEET_2.getTimesheetId());
      Assert.assertNotNull(whyMee);
      assertTimesheetsMatch(myBad,whyMee);



    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        Timesheet youKnowWhatINeed =dao.getTimesheetById(TIMESHEET_1.getTimesheetId());
        int iLikeFun = dao.deleteTimesheetById(youKnowWhatINeed.getTimesheetId());
        Timesheet youThoughItWasSafe = dao.getTimesheetById(TIMESHEET_1.getTimesheetId());
        Assert.assertNull(youThoughItWasSafe);
        Assert.assertTrue(iLikeFun==1);
        Assert.assertEquals(0,dao.deleteTimesheetById(youKnowWhatINeed.getTimesheetId()));
        Timesheet keepItgoing = dao.getTimesheetById(TIMESHEET_2.getTimesheetId());
        int whatYourWorth = dao.deleteTimesheetById(keepItgoing.getTimesheetId());
        Assert.assertEquals(1,whatYourWorth);
    }

    @Test
    public void getBillableHours_returns_correct_total() {

        double billstuffIGUESS = dao.getBillableHours(TIMESHEET_1.getEmployeeId(),TIMESHEET_1.getProjectId());
        assertEquals(2.5,billstuffIGUESS,0.01);

        double justForFun = dao.getBillableHours(TIMESHEET_4.getEmployeeId(),TIMESHEET_4.getProjectId());
        assertEquals(0.0,justForFun,0.01);

        double howmanyMore = dao.getBillableHours(TIMESHEET_3.getEmployeeId(),TIMESHEET_3.getProjectId());
        assertEquals(.25,howmanyMore,0.01);



    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
