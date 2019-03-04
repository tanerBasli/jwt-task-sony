package com.sony.league.util;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.sony.league.beans.Match;

/**
 * @author tanerBasli
 */
public class Summarizing {

    /**
     * Returns all the league clubs from matches.
     * 
     * @param matches
     * @return clubs
     */
    public static Set<String> getClubs(final List<Match> matches) {
	return Stream.concat(matches.stream().map(Match::getHomeTeam), matches.stream().map(Match::getAwayTeam))
		.collect(toSet());
    }

    /**
     * Returns the matches filtered by team.
     * 
     * @param team
     * @param matches
     * @return matches
     */
    public static List<Match> filterMatchesByTeam(final String team, final List<Match> matches) {
	return matches.stream().filter(match -> match.getHomeTeam().equals(team) || match.getAwayTeam().equals(team))
		.collect(toList());
    }

    /**
     * Returns the number of wins filtered by clubs
     * 
     * @param team
     * @param matches
     * @return integer
     */
    public static int getTotalWon(final String team, final List<Match> matches) {
	return matches.stream().filter(match -> {
	    boolean isHomeMatch = match.getHomeTeam().equals(team);
	    if (isHomeMatch) {
		return match.getHomeScore() > match.getAwayScore();
	    }
	    return match.getAwayScore() > match.getHomeScore();
	}).collect(toList()).size();
    }

    /**
     * Returns the number of draws filtered by clubs
     * 
     * @param team
     * @param matches
     * @return integer
     */
    public static int getTotalDrawn(final String team, final List<Match> matches) {
	return matches.stream().filter(match -> {
	    return match.getHomeScore() == match.getAwayScore();
	}).collect(toList()).size();
    }

    /**
     * Returns the number of losses filtered by clubs
     * 
     * @param team
     * @param matches
     * @return integer
     */
    public static int getTotalLost(final String team, final List<Match> matches) {
	return matches.stream().filter(match -> {
	    boolean isHomeMatch = match.getHomeTeam().equals(team);
	    if (isHomeMatch) {
		return match.getHomeScore() < match.getAwayScore();
	    }
	    return match.getAwayScore() < match.getHomeScore();
	}).collect(toList()).size();
    }

    /**
     * Returns how many goals for filtered by clubs
     * 
     * @param team
     * @param matches
     * @return integer
     */
    public static int getGoalsFor(final String team, final List<Match> matches) {
	return matches.stream().map(match -> {
	    boolean isHomeMatch = match.getHomeTeam().equals(team);
	    return (isHomeMatch) ? match.getHomeScore() : match.getAwayScore();
	}).reduce(0, Integer::sum);
    }

    /**
     * Returns how many goals against filtered by clubs
     * 
     * @param team
     * @param matches
     * @return integer
     */
    public static int getGoalsAgainst(final String team, final List<Match> matches) {
	return matches.stream().map(match -> {
	    boolean isHomeMatch = match.getHomeTeam().equals(team);
	    return (isHomeMatch) ? match.getAwayScore() : match.getHomeScore();
	}).reduce(0, Integer::sum);
    }
}
