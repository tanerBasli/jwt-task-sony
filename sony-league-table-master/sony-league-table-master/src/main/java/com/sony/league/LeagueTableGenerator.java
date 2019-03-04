package com.sony.league;

import static com.sony.league.util.Summarizing.getClubs;
import static com.sony.league.util.Summarizing.getGoalsAgainst;
import static com.sony.league.util.Summarizing.getGoalsFor;
import static com.sony.league.util.Summarizing.getTotalDrawn;
import static com.sony.league.util.Summarizing.getTotalLost;
import static com.sony.league.util.Summarizing.getTotalWon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.sony.league.beans.LeagueTableEntry;
import com.sony.league.beans.Match;
import com.sony.league.exception.LeagueTableException;

/**
 * @author tanerBasli
 */
public class LeagueTableGenerator {

    private List<Match> matches;
    private List<LeagueTableEntry> leagueTableEntries = new ArrayList<LeagueTableEntry>();

    public LeagueTableGenerator(final List<Match> matches) throws Exception {
	if (isNullOrEmpty(matches)) {
	    throw new LeagueTableException("Please write correct input!!");
	}
	this.matches = matches;
    }

    public void populateLeagueTableEntries() {

	Set<String> teams = getClubs(matches);
	((Object) teams)
		.forEach(team -> addLeagueTableEntry(createNewLeagueEntry(team, filterMatchesByTeam(team, matches))));
    }

    public LeagueTableEntry createNewLeagueEntry(final String team, final List<Match> matchesByTeam) {

	int played = matchesByTeam.size();
	int won = getTotalWon(team, matchesByTeam);
	int drawn = getTotalDrawn(team, matchesByTeam);
	int lost = getTotalLost(team, matchesByTeam);
	int goalsFor = getGoalsFor(team, matchesByTeam);
	int goalsAgainst = getGoalsAgainst(team, matchesByTeam);
	int goalDifference = goalsFor - goalsAgainst;
	int points = (won * 3) + (drawn * 1);
	return new LeagueTableEntry(team, played, won, drawn, lost, goalsFor, goalsAgainst, goalDifference, points);
    }

    public void addLeagueTableEntry(final LeagueTableEntry leagueTableEntry) {
	leagueTableEntries.add(leagueTableEntry);
    }

    public List<LeagueTableEntry> getLeagueTableEntries() {
	return leagueTableEntries;
    }

    private static boolean isNullOrEmpty(final Collection<?> c) {
	return c == null || c.isEmpty();
    }
}
