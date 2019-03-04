package com.sony.league.beans;

import static com.sony.league.util.Sorting.sort;

import java.util.List;

import com.sony.league.LeagueTableGenerator;

/**
 * @author tanerBasli
 */
public class LeagueTable {

    private List<LeagueTableEntry> tableEntries;

    public LeagueTable(final List<Match> matches) throws Exception {
	LeagueTableGenerator generator = new LeagueTableGenerator(matches);
	generator.populateLeagueTableEntries();
	setTableEntries(generator.getLeagueTableEntries());
    }

    public List<LeagueTableEntry> getTableEntries() {
	return sort(tableEntries);
    }

    public void setTableEntries(List<LeagueTableEntry> leagueTableEntries) {
	this.tableEntries = leagueTableEntries;
    }
}
