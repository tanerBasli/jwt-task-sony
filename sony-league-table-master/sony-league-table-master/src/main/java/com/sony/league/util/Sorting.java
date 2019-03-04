package com.sony.league.util;

import static java.util.Comparator.comparing;

import java.util.List;

import com.sony.league.beans.LeagueTableEntry;

/**
 * @author tanerBasli
 */
public class Sorting {

    /**
     * Return a sorted list 1- points (descending), 2-goal difference, 3-goals for 4- team names.
     * 
     * @param List<LeagueTableEntry>
     * @return List<LeagueTableEntry>
     */

    public static List<LeagueTableEntry> sort(List<LeagueTableEntry> leagueTableEntries) {
	leagueTableEntries.sort(
		comparing(LeagueTableEntry::getPoints).reversed().thenComparing(LeagueTableEntry::getGoalDifference)
			.thenComparing(LeagueTableEntry::getGoalsFor).thenComparing(LeagueTableEntry::getTeamName));
	return leagueTableEntries;
    }
}
