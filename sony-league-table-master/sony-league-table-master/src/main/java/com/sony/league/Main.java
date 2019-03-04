package com.sony.league;

import static com.sony.league.util.Printing.print;

import java.util.Arrays;
import java.util.List;

import com.sony.league.beans.LeagueTable;
import com.sony.league.beans.LeagueTableEntry;
import com.sony.league.beans.Match;

/**
 * @author tanerBasli
 */
public class Main {
    public static final List<Match> matches = Arrays.asList(new Match("Valencia", "Barcelona", 3, 2),
	    new Match("Villarreal", "Valencia", 3, 2), new Match("Real Madrid", "Barcelona", 3, 2),
	    new Match("Real Madrid", "Valencia", 3, 2), new Match("Espanyol", "Real Sociedad", 3, 2),
	    new Match("Espanyol", "Barcelona", 3, 2), new Match("Atletico Madrid", "Sevilla", 3, 2),
	    new Match("Atletico Madrid", "Espanyol", 3, 2), new Match("Atletico Madrid", "Valencia", 3, 2));

    public static void main(String[] args) throws Exception {

	LeagueTable table = new LeagueTable(matches);
	List<LeagueTableEntry> list = table.getTableEntries();
	print(list);
    }
}
