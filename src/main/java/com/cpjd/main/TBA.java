package com.cpjd.main;

import com.cpjd.models.APIStatus;
import com.cpjd.models.districts.District;
import com.cpjd.models.events.*;
import com.cpjd.models.teams.Robot;

import com.cpjd.models.matches.SMatch;
import com.cpjd.models.teams.STeam;
import com.cpjd.models.matches.Match;
import com.cpjd.models.teams.Team;
import com.cpjd.requests.*;
import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;
import com.cpjd.utils.IO;
import com.cpjd.utils.exceptions.DataNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;

/**
 * This is the com.cpjd.main interface for the API, let's talk about that.
 *
 * The actual API calls are organized by the type of request (district, event, match, team, other), which can be found
 * in the com.cpjd.requests package. Essentially, TBA is a single class that allows you to call every single method without having
 * to worry about what type it is. However, for debugging, it's nice to keep the actual API code organized by type.
 * You'll notice that TBA doesn't have any getters/setters/constructors for parameters, even though only a couple parameters are
 * shared across the entire API. There are several reasons for this, 1) to keep the Java implementation more consistent with the
 * online API 2) if you need to change parameters or input different ones for each method calls, it's nice to avoid having to
 * manually setting them with setters and the like. However, if you'd like a constructor/setter/getter implementation, check out the CTBA class.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@SuppressWarnings("unused")
public class TBA {

    private DistrictRequest dr;
    private EventRequest er;
    private MatchRequest mr;
    private OtherRequest or;
    private TeamRequest tr;

    public TBA() {
        dr = new DistrictRequest();
        er = new EventRequest();
        mr = new MatchRequest();
        or = new OtherRequest();
        tr = new TeamRequest();
    }

    /**
     * Sets the authentication token for the API, required for all calls!
     * Obtain an auth token from your account page on thebluealliance.com
     * @param authToken the auth token to set
     */
    public static void setAuthToken(String authToken) {
        Constants.AUTH_TOKEN = authToken;
    }

    /*
     * Sorting functions
     */

    public static <T extends Sortable> void sort(T[] array, SortingType type, boolean ascending) {
        Arrays.sort(array, (o1, o2) -> ascending ? o1.sort(type, ascending, o2) : o2.sort(type, ascending, o1));
    }

    public static <T extends Sortable> void sort(T[] array) {
        sort(array, SortingType.DEFAULT, true);
    }

    public static <T extends Sortable> void sort(T[] array, SortingType type) {
        sort(array, type, true);
    }

    /**
     * Mirror of: /district/{district_key}/teams
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return Team[] including a Team object for every team in the specified district
     */
    public Team[] getDistrictTeams(String districtKey) {
        return dr.getDistrictTeams(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/teams/simple
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return STeam[] including a STeam object for every team in the specified district (simple model)
     */
    public STeam[] getDistrictSTeams(String districtKey) {
        return dr.getDistrictSTeams(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/teams/keys
     * <p>
     * Gets a list of Team objects that competed in events in the given district.
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return String[] containing all the team keys in this district
     */
    public String[] getDistrictTeamKeys(String districtKey) {
        return dr.getDistrictTeamKeys(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/events
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return Event[] including an Event object for every event in the specified district
     */
    public Event[] getDistrictEvents(String districtKey) {
        return dr.getDistrictEvents(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/events/simple
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return SEvent[] including an SEvent object for every event in the specified district (simple model)
     */
    public SEvent[] getDistrictSEvents(String districtKey) {
        return dr.getDistrictSEvents(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/events/keys
     * <p>
     * Gets a list of Team objects that competed in events in the given district.
     *
     * @param districtKey TBA District Key, eg 2016fim
     * @return String[] containing all the team keys in this district
     */
    public String[] getDistrictEventKeys(String districtKey) {
        return dr.getDistrictEventKeys(districtKey);
    }

    /**
     * Mirror of: /districts/{year}
     * <p>
     * Gets a list of districts and their corresponding district key, for the given year.
     *
     * @param year Competition Year (or Season). Must be 4 digits.
     * @return District[] containing a District for each active district in the specified year
     */
    public District[] getDistricts(int year) {
        return dr.getDistricts(year);
    }

    /**
     * Mirror of: /event/{event_key}/teams
     * <p>
     * Gets a list of Team objects that competed in the given event.
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return the Team[] array that this event includes
     */
    public Team[] getEventTeams(String eventKey) {
        return er.getEventTeams(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/teams/simple
     * <p>
     * Gets a list of Team objects that competed in the given event.
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return the STeam[] array that this event includes (simple model)
     */
    public STeam[] getSEventTeams(String eventKey) {
        return er.getSEventTeams(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/teams/keys
     * <p>
     * Gets a list of Team keys that competed in the given event.
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return String[] containing all the team keys in this event
     */
    public String[] getTeamKeys(String eventKey) {
        return er.getTeamKeys(eventKey);
    }

    /**
     * Mirror of: /events/{year}
     * <p>
     * Gets a list of events in the given year.
     *
     * @param year Competition Year (or Season). Must be 4 digits.
     * @return Event[] containing all the events in the specified year
     */
    public Event[] getEvents(int year) {
        return er.getEvents(year);
    }

    /**
     * Mirror of: /events/{year}/simple
     * <p>
     * Gets a list of events in the given year.
     *
     * @param year Competition Year (or Season). Must be 4 digits.
     * @return SEvent[] containing all the events in the specified year
     */
    public SEvent[] getSEvents(int year) {
        return er.getSEvents(year);
    }

    /**
     * Mirror of: /events/{year}/keys
     * <p>
     * Gets a list of event keys in the given year.
     *
     * @param year Competition Year (or Season). Must be 4 digits.
     * @return String[] containing event keys for the specified year
     */
    public String[] getEventKeys(int year) {
        return er.getEventKeys(year);
    }

    /**
     * Mirror of: /event/{event_key}
     * <p>
     * Gets an Event.
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Event model representing the event associated with the event key
     */
    public Event getEvent(String eventKey) {
        return er.getEvent(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/simple
     * <p>
     * Gets an Event.
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Event model representing the event associated with the event key
     */
    public SEvent getSEvent(String eventKey) {
        return er.getSEvent(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/oprs
     *
     * Gets a set of Event OPRs (including OPR, DPR, and CCWM) for the given Event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return EventOPR[] containing an EventOPR for each team
     */
    public EventOPR[] getOprs(String eventKey) {
        return er.getOprs(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/predictions
     *
     * Gets information on TBA-generated predictions for the given Event. Contains year-specific information. WARNING This endpoint is currently under development and may change at any time.
     *
     * Not stable! No official model for this yet.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return JSON String containing prediction information
     */
    public String getPredictions(String eventKey) {
        return er.getPredictions(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/matches
     *
     * Gets a list of matches for the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Match[] containing a Match object for each match in the specified event
     */
    public Match[] getMatches(String eventKey) {
        return er.getMatches(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/matches/simple
     *
     * Gets a list of matches for the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Match[] containing a Match object for each match in the specified event
     */
    public SMatch[] getSMatches(String eventKey) {
        return er.getSMatches(eventKey);
    }


    /**
     * Mirror of: /event/{event_key}/matches/keys
     *
     * GGets a list of match keys for the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return String[] containing matches keys for the specified event
     */
    public String[] getMatchKeys(String eventKey) {
        return er.getMatchKeys(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/awards
     *
     * Gets a list of awards from the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Award[] containing all the awards won in this event
     */
    public Award[] getEventAwards(String eventKey) {
        return er.getEventAwards(eventKey);
    }

    /**
     * Mirror of: /match/{match_key}
     *
     * Gets a Match object for the given match key.
     * @param matchKey TBA Match Key, eg 2016nytr_qm1
     * @return Match object represented by the match key
     */
    public Match getMatch(String matchKey) {
        return mr.getMatch(matchKey);
    }

    /**
     * Mirror of: /match/{match_key}/simple
     *
     * Gets a Match object for the given match key.
     * @param matchKey TBA Match Key, eg 2016nytr_qm1
     * @return SMatch object represented by the match key (simple model)
     */
    public SMatch getSMatch(String matchKey) {
        return mr.getSMatch(matchKey);
    }

    /**
     * Returns API status, and TBA status information.
     * @return APIStatus representing the state of the TBA API interface
     */
    public APIStatus getStatus() {
        return or.getStatus();
    }

    /**
     * Makes a custom call to the URL
     * @param URL the URL suffix to make a call to, this API automatically fills in Constants.URL for you, so an example parameter here might be 'teams/{page_num}'
     * @return an Object (json formatted), representing the data received from the server
     */
    public Object customCall(String URL) {
        return or.customCall(URL);
    }

    /**
     * Mirror of: /teams/{page_num}
     *
     * Gets a list of Team objects, paginated in groups of 500.
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (full team models)
     */
    public Team[] getTeams(int pageNum) {
        return tr.getTeams(pageNum);
    }

    /**
     * Mirror of: /teams/{page_num}/simple
     *
     * Gets a list of STeam objects, paginated in groups of 500.
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of STeam objects (simple team models)
     */
    public STeam[] getSTeams(int pageNum) {
        return tr.getSTeams(pageNum);
    }

    /**
     * Mirror of: /teams/{page_num}/keys
     *
     * Gets a list of Team keys, paginated in groups of 500. (Note, each page will not have 500 teams, but will include the teams within that range of 500.)
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return String[] of team keys in the format 'frc254'
     */
    public String[] getTeamKeys(int pageNum) {
        return tr.getTeamKeys(pageNum);
    }

    /**
     * Mirror of: /teams/{year}/{page_num}
     *
     * Gets a list of Team objects that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (full models)
     */
    public Team[] getTeams(int year, int pageNum) {
        return tr.getTeams(year, pageNum);
    }

    /**
     * Mirror of: /teams/{year}/{page_num}/simple
     *
     * Gets a list of Team objects that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (simple models)
     */
    public STeam[] getSTeams(int year, int pageNum) {
        return tr.getSTeams(year, pageNum);
    }

    /**
     * Mirror of: /team/{year}/{page_num}/keys
     *
     * Gets a list Team Keys that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @return String[] of team keys in format 'frc254'
     */
    public String[] getTeamKeys(int year, int pageNum) {
        return tr.getTeamKeys(year, pageNum);
    }

    /**
     * Mirror of: /team/{team_key}
     *
     * Gets the specified team (full team model)
     * @param number the team's frc number
     * @return Team object (full model)
     */
    public Team getTeam(int number) {
        return tr.getTeam(number);
    }

    /**
     * Mirror of: /team{team_key}/simple
     *
     * Gets the specified team (simple team model)
     * @param number the team's frc number
     * @return STeam object (simple model)
     */
    public STeam getSTeam(int number) {
        return tr.getSTeam(number);
    }

    /**
     * Mirror of: /team/{team_key}/years_participated
     *
     * Returns an array containing the years that a particular team participated in FRC events
     * @param number the team's frc number
     * @return long[] containing years participated
     */
    public long[] getYearsParticipated(int number) {
        return tr.getYearsParticipated(number);
    }

    /**
     * Mirror of: /team/{team_key}/districts
     *
     * Gets the districts this team was in, empty array if none
     * @param number the team's frc number
     * @return District[] containing a District object for each district this team was in
     */
    public String[] getTeamDistricts(int number) {
        return tr.getTeamDistricts(number);
    }

    /**
     * Mirror of: /team{team_key}/robots
     *
     * Gets the robots that this team has had
     * @param number the team's frc number
     * @return Robot[] containing a Robot object for each robot this team has built
     *
     *
     */
    public Robot[] getRobots(int number) {
        return tr.getRobots(number);
    }

    /**
     * Mirror of: /team/{team_key}/events
     *
     * Gets a list of all events this team has competed at.
     * @param number the team's frc number
     * @return Event[] containing an Event object for each event this team was in
     */
    public Event[] getTeamEvents(int number) {
        return tr.getTeamEvents(number);
    }

    /**
     * Mirror of: /team/{team_key}/events/simple
     *
     * Gets a list of all events this team has competed at.
     * @param number the team's frc number
     * @return SEvent[] containing an Event object for each event this team was in (simple model)
     */
    public SEvent[] getTeamSEvents(int number) {
        return tr.getTeamSEvents(number);
    }

    /**
     * Mirror of: /team/{team_key}/events_keys
     *
     * Gets a list of the event keys for all events this team has competed at.
     * @param number the team's frc number
     * @return String[] containg all the event keys for events this team is in
     */
    public String[] getTeamEventKeys(int number) {
        return tr.getTeamEventKeys(number);
    }

    /**
     * Mirror of: /team/{team_key}/events/{year}
     *
     * Gets a list of events this team has competed at in the given year.
     * @param number the team's frc number
     * @param year the year to get events from
     * @return Event[] containing an Event object for each event this team was in the specified year (full model)
     */
    public Event[] getEvents(int number, int year) {
        return tr.getEvents(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/events/{year}/simple
     *
     * Gets a short-form list of events this team has competed at in the given year.
     * @param number the team's frc number
     * @param year the year to get events from
     * @return Event[] containing an Event object for each event this team was in the specified year (simple model)
     */
    public SEvent[] getSEvents(int number, int year) {
        return tr.getSEvents(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/events/{year}/keys
     *
     * Gets a list of the event keys for events this team has competed at in the given year.
     * @param number the team's frc number
     * @param year the year to get events from
     * @return String[] containing an event key for each event this team has participated in
     */
    public String[] getEventKeys(int number, int year) {
        return tr.getEventKeys(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/matches
     *
     * Gets a list of matches for the given team and event.
     * @param number the team's frc number
     * @param eventKey the event's key code (example: '2016nytr')
     * @return Match[] containing a match for each match this team was in in the specified event
     */
    public Match[] getTeamEventMatches(int number, String eventKey) {
        return tr.getTeamEventMatches(number, eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/rankings
     * @param eventKey the event's key code (example: '2016nytr')
     * @return EventRanking[] containing rankings of teams in this event
     */
    public EventRanking[] getEventRankings(String eventKey) {return er.getEventRankings(eventKey); }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/matches/simple
     *
     * Gets a short-form list of matches for the given team and event.
     * @param number the team's frc number
     * @param eventKey the event's key code (example: '2016nytr')
     * @return SMatch[] containing a match for each match this team was in in the specified event (simple model)
     */
    public SMatch[] getTeamEventSMatches(int number, String eventKey) {
        return tr.getTeamEventSMatches(number, eventKey);
    }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/matches/keys
     *
     * Gets a list of the event keys for events this team has competed at in the given year.
     * @param number the team's frc number
     * @param eventKey the event's key code (example: '2016nytr')
     * @return String[] containing an event key for each event this team has participated in
     */
    public String[] getMatchKeys(int number, String eventKey) {
        return tr.getMatchKeys(number, eventKey);
    }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/awards
     *
     * Gets a list of awards the given team won at the given event.
     * @param number the team's frc number
     * @param eventKey the event's key code (example: '2016nytr')
     * @return Award[] containing n award object for each award this team won in the specified event
     */
    public Award[] getTeamEventAwards(int number, String eventKey) {
        return tr.getTeamEventAwards(number, eventKey);
    }

    /**
     * Mirror of: /team/{team_key}/awards
     *
     * Gets a list of awards the given team has won.
     * @param number the team's frc number
     * @return Award[] containing all the awards this team has won
     */
    public Award[] getTeamAwards(int number) {
        return tr.getTeamAwards(number);
    }

    /**
     * Mirror of: /team/{team_key}/awards/{year}
     *
     * Gets a list of awards the given team has won.
     * @param number the team's frc number
     * @param year the year
     * @return Award[] containing all the awards this team has won
     */
    public Award[] getTeamAwards(int number, int year) {
        return tr.getTeamAwards(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/matches/{year}
     *
     * Gets a list of matches for the given team and year.
     * @param number the team's frc number
     * @param year the year
     * @return Match[] containing all the matches the specified team was in for the specified year
     */
    public Match[] getTeamMatches(int number, int year) {
        return tr.getTeamMatches(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/matches/{year}/simple
     *
     * Gets a list of matches for the given team and year.
     * @param number the team's frc number
     * @param year the year
     * @return SMatch[] containing all the matches the specified team was in for the specified year (simple models)
     */
    public SMatch[] getTeamSMatches(int number, int year) {
        return tr.getTeamSMatches(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/matches/{year}/keys
     *
     * Gets a list of match keys for matches for the given team and year.
     * @param number the team's frc number
     * @param year the year to get match keys from
     * @return String[] containing match string keys for each match
     */
    public String[] getTeamMatchKeys(int number, int year) {
        return tr.getTeamMatchKeys(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/media/{year}
     *
     * Gets a list of Media (videos / pictures) for the given team and year.
     * @param number the team's frc number
     * @param year the year
     * @return Media[] containing all the media associated with this team for the specified year
     */
    public Media[] getTeamMedia(int number, int year) {
        return tr.getTeamMedia(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/social_media
     *
     * Gets a list of Media (social media) for the given team.
     * @param number the team's frc number
     * @return Media[] containing all social media associated with this team
     */
    public Media[] getTeamSocialMedia(int number) {
        return tr.getTeamSocialMedia(number);
    }

    /**
     * Mirror of: /event/{event_key}/alliances
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return List of all alliances in this event
     */
    public Alliance[] getEventAlliances(String eventKey) {
        return er.getEventAlliances(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/insights
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Insights for this event
     */
    public Insight getEventInsights(String eventKey) {
        return er.getEventInsights(eventKey);
    }
}