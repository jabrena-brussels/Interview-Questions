package org.trares.challenges.phoneagenda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class PhoneAgendaTest {

    final String[] originalPartyList = {
            "George",
            "Gregory",
            "Hugo",
            "James",
            "Julia",
            "Lara",
            "Noah",
            "Pamela",
            "Paul",
            "Pauline",
            "Sandra",
            "Salima",
            "Tudor",
            "Adam", //<--> switching point
            "Alesia",
            "Bridget",
            "Charlie",
            "Celine",
            "Diane",
            "Fabio" };

    @Test
    public void getChaningPointTest(){

        final String[] partyList = {
        "George",
        "Gregory",
        "Hugo",
        "James",
        "Julia",
        "Lara",
        "Noah",
        "Pamela",
        "Paul",
        "Pauline",
        "Salima",
        "Sandra",
        "Tudor",
        "Adam", //<--> switching point
        "Alesia",
        "Bridget",
        "Charlie",
        "Celine",
        "Diane",
        "Fabio" };

        final PhoneAgenda phoneAgenda = new PhoneAgendaImpl(partyList);
        final int index = phoneAgenda.getChangingPoint();

        assertThat(index, is(13));
        assertThat(partyList[index], is("Adam"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullListTest(){

        final String[] partyList = null;

        final PhoneAgenda phoneAgenda = new PhoneAgendaImpl(partyList);
    }

}
