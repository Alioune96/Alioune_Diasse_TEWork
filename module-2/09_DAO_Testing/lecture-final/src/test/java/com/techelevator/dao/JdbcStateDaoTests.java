package com.techelevator.dao;

import com.techelevator.model.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcStateDaoTests extends BaseDaoTests {

    // Java objects to represent what's in the mock data
    private static final State STATE_A = new State("AA", "State A");
    private static final State STATE_B = new State("BB", "State B");
    private static final State STATE_C = new State("CC", "State C");

    private JdbcStateDao sut;

    @Before
    public void setup() {
        sut = new JdbcStateDao(dataSource); // ARRANGE
    }

    @Test
    public void getStateByAbbreviation_with_valid_abbreviation_returns_correct_state() {
        State state = sut.getStateByAbbreviation("AA");  // ACT
        assertStatesMatch(STATE_A, state); // ASSERT

        state = sut.getStateByAbbreviation("BB");
        assertStatesMatch(STATE_B, state);

        state = sut.getStateByAbbreviation("CC");
        assertStatesMatch(STATE_C, state);
    }

    @Test
    public void getStateByAbbreviation_with_invalid_abbreviation_returns_null_state() {
        State state = sut.getStateByAbbreviation("XX");
        Assert.assertNull(state);
    }

    @Test
    public void getStateByCapital_with_valid_city_returns_correct_state() {
        State state = sut.getStateByCapital(1);
        assertStatesMatch(STATE_A, state);

        state = sut.getStateByCapital(2);
        assertStatesMatch(STATE_B, state);

        state = sut.getStateByCapital(3);
        assertStatesMatch(STATE_C, state);
    }

    @Test
    public void getStateByCapital_with_invalid_city_returns_null_state() {
        State state = sut.getStateByCapital(99); // not in table
        Assert.assertNull(state);

        state = sut.getStateByCapital(-1); // not a valid primary key
        Assert.assertNull(state);

        state = sut.getStateByCapital(4); // in table, but not capital
        Assert.assertNull(state);
    }

    @Test
    public void getStates_returns_correct_states() {
        List<State> states = sut.getStates();  // ACT

        Assert.assertNotNull(states); // make sure you CAN run .size()
        Assert.assertEquals(3, states.size());  // Size of list should be 3

        assertStatesMatch(STATE_A, states.get(0));
        assertStatesMatch(STATE_B, states.get(1));
        assertStatesMatch(STATE_C, states.get(2));
    }

    private void assertStatesMatch(State expected, State actual) {
        Assert.assertEquals(expected.getStateAbbreviation(), actual.getStateAbbreviation());
        Assert.assertEquals(expected.getStateName(), actual.getStateName());
    }
}
