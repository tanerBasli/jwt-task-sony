package com.sony.league;

import static com.sony.league.util.Sorting.sort;
import static com.sony.league.util.Summarizing.filterMatchesByTeam;
import static com.sony.league.util.Summarizing.getClubs;
import static com.sony.league.util.Summarizing.getGoalsAgainst;
import static com.sony.league.util.Summarizing.getGoalsFor;
import static com.sony.league.util.Summarizing.getTotalDrawn;
import static com.sony.league.util.Summarizing.getTotalLost;
import static com.sony.league.util.Summarizing.getTotalWon;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.sony.league.beans.LeagueTableEntry;
import com.sony.league.beans.Match;

/**
 * @author tanerBasli
 */
public class LeagueTableTest {

    @Test
    public void getClubsTest() throws Exception {

	List<Match> matches = Arrays.asList(new Match("Sevilla", "Villareal", 2, 3),
		new Match("Barcelona", "Sevilla", 3, 3), new Match("Barcelona", "Real Socieadad", 1, 0));
	Set<String> expected = Arrays.asList("Villareal", "Sevilla", "Real Socieadad", "Barcelona").stream()
		.collect(toSet());
	Set<String> actual = getClubs(matches);
	assertThat(actual, is(expected));
    }

    @Test
    public void filterMatchesByTeamTest() throws Exception {
	List<Match> matches = Arrays.asList(new Match("Sevilla", "Villareal", 2, 3),
		new Match("Barcelona", "Sevilla", 3, 3), new Match("Barcelona", "Real Socieadad", 1, 0));
	List<Match> expected = Arrays.asList(new Match("Barcelona", "Sevilla", 3, 3),
		new Match("Barcelona", "Real Socieadad", 1, 0));
	List<Match> actual = filterMatchesByTeam("Barcelona", matches);
	assertThat(actual, is(expected));
    }

    @Test
    public void getTotalWonTest() throws Exception {

	List<Match> matches = Arrays.asList(new Match("Sevilla", "Villareal", 2, 3),
		new Match("Sevilla", "Barcelona", 3, 3), new Match("Sevilla", "Real Socieadad", 1, 0));
	int actual = getTotalWon("Sevilla", matches);
	assertEquals(actual, 1);

    }

    @Test
    public void getTotalDrawnTest() throws Exception {

	List<Match> matches = Arrays.asList(new Match("Sevilla", "Villareal", 2, 3),
		new Match("Sevilla", "Barcelona", 3, 3), new Match("Sevilla", "Real Socieadad", 1, 0));
	int actual = getTotalDrawn("Sevilla", matches);
	assertEquals(actual, 1);
    }

    @Test
    public void getTotalLostTest() throws Exception {

	List<Match> matches = Arrays.asList(new Match("Sevilla", "Villareal", 2, 3),
		new Match("Sevilla", "Barcelona", 3, 3), new Match("Sevilla", "Real Socieadad", 1, 0));
	int actual = getTotalLost("Sevilla", matches);
	assertEquals(actual, 1);
    }

    @Test
    public void getGoalsForTest() throws Exception {

	List<Match> matches = Arrays.asList(new Match("Sevilla", "Villareal", 2, 3),
		new Match("Sevilla", "Barcelona", 3, 3), new Match("Sevilla", "Real Socieadad", 1, 0));
	int actual = getGoalsFor("Sevilla", matches);
	assertEquals(actual, 5);
    }

    @Test
    public void getGoalsAgainstTest() throws Exception {

	List<Match> matches = Arrays.asList(new Match("Sevilla", "Villareal", 2, 3),
		new Match("Sevilla", "Barcelona", 3, 3), new Match("Sevilla", "Real Socieadad", 1, 0));
	int actual = getGoalsAgainst("Sevilla", matches);
	assertEquals(actual, 5);
    }

    @Test
    public void sortTest() throws Exception {

	List<LeagueTableEntry> list = new ArrayList<LeagueTableEntry>();

	LeagueTableEntry SevillaEntry = new LeagueTableEntry("Sevilla", 3, 3, 0, 0, 5, 3, 2, 9);
	LeagueTableEntry BarcelonaEntry = new LeagueTableEntry("Barcelona", 3, 3, 0, 0, 3, 0, 3, 9);
	LeagueTableEntry VillarealEntry = new LeagueTableEntry("Villareal", 3, 2, 1, 0, 3, 0, 3, 7);

	list.add(VillarealEntry);
	list.add(BarcelonaEntry);
	list.add(SevillaEntry);

	// Ensure Correct order
	assertThat(sort(list), contains(SevillaEntry, BarcelonaEntry, VillarealEntry));
    }
}
