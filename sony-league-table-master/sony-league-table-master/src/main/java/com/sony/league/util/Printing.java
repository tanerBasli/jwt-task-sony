package com.sony.league.util;

import java.util.List;

import com.sony.league.beans.LeagueTableEntry;

/**
 * @author tanerBasli
 */
public class Printing {

    /**
     * Prints the list passed as a table.
     * 
     * @param leagueTableEntries
     */
    public static void print(List<LeagueTableEntry> leagueTableEntries) {

	System.out.println("SPAIN  ***    La Liga Table     ***");
	System.out.println("*************");

	int[] i = { 0 };
	leagueTableEntries.forEach(leagueTableEntry -> {
	    System.out.format("------", ++i[0], leagueTableEntry.getTeamName(), leagueTableEntry.getPlayed(),
		    leagueTableEntry.getWon(), leagueTableEntry.getDrawn(), leagueTableEntry.getLost(),
		    leagueTableEntry.getGoalsFor(), leagueTableEntry.getGoalsAgainst(),
		    leagueTableEntry.getGoalDifference(), leagueTableEntry.getPoints());
	});
    }
}
