package com.sony.league.beans;

/**
 * @author tanerBasli
 */
public class Match {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public Match(final String homeTeam, final String awayTeam, final int homeScore, final int awayScore) {

	this.homeTeam = homeTeam;
	this.awayTeam = awayTeam;
	this.homeScore = homeScore;
	this.awayScore = awayScore;
    }

    public String getHomeTeam() {
	return homeTeam;
    }

    public String getAwayTeam() {
	return awayTeam;
    }

    public int getHomeScore() {
	return homeScore;
    }

    public int getAwayScore() {
	return awayScore;
    }

    @Override
    public String toString() {
	return "Match [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", homeScore=" + homeScore + ", awayScore="
		+ awayScore + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + awayScore;
	result = prime * result + ((awayTeam == null) ? 0 : awayTeam.hashCode());
	result = prime * result + homeScore;
	result = prime * result + ((homeTeam == null) ? 0 : homeTeam.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Match other = (Match) obj;
	if (awayScore != other.awayScore)
	    return false;
	if (awayTeam == null) {
	    if (other.awayTeam != null)
		return false;
	} else if (!awayTeam.equals(other.awayTeam))
	    return false;
	if (homeScore != other.homeScore)
	    return false;
	if (homeTeam == null) {
	    if (other.homeTeam != null)
		return false;
	} else if (!homeTeam.equals(other.homeTeam))
	    return false;
	return true;
    }
}