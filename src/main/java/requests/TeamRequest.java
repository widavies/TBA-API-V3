package requests;

import models.other.Award;
import models.other.teams.District;
import models.other.teams.Robot;
import models.simple.SEvent;
import models.simple.SMatch;
import models.simple.STeam;
import models.standard.Event;
import models.standard.Match;
import models.standard.Team;
import org.json.simple.JSONArray;
import utils.IO;
import utils.Parser;

import java.util.Arrays;

/**
 * TeamRequest manages all the API calls, in order, as listed on https://www.thebluealliance.com/apidocs/v3 under
 * the 'teams' section.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@SuppressWarnings("unused")
public class TeamRequest extends Parser {

    /**
     * Gets a list of Team objects, paginated in groups of 500.
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (full team models)
     */
    public Team[] getTeams(int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+pageNum);
        if(teams == null) return null;
        Team[] toGet = new Team[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseTeam(teams.get(i));
        return toGet;
    }

    /**
     * Gets a list of STeam objects, paginated in groups of 500.
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of STeam objects (simple team models)
     */
    public STeam[] getSTeams(int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+pageNum+"/simple");
        if(teams == null) return null;
        STeam[] toGet = new STeam[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseSTeam(teams.get(i));
        return toGet;
    }

    /**
     * Gets a list of Team keys, paginated in groups of 500. (Note, each page will not have 500 teams, but will include the teams within that range of 500.)
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return String[] of team keys in the format 'frc254'
     */
    public String[] getTeamKeys(int pageNum) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/"+pageNum+"/keys");
        return Arrays.asList(keys.toArray()).toArray(new String[keys.size()]);
    }

    /**
     * Gets a list of Team objects that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (full models)
     */
    public Team[] getTeams(int year, int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum);
        if(teams == null) return null;
        Team[] toGet = new Team[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseTeam(teams.get(i));
        return toGet;
    }

    /**
     * Gets a list of Team objects that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (simple models)
     */
    public STeam[] getSTeams(int year, int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum+"/simple");
        if(teams == null) return null;
        STeam[] toGet = new STeam[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseSTeam(teams.get(i));
        return toGet;
    }

    /**
     * Gets a list Team Keys that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @return String[] of team keys in format 'frc254'
     */
    public String[] getTeamKeys(int year, int pageNum) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum+"/keys");
        return Arrays.asList(keys.toArray()).toArray(new String[keys.size()]);
    }

    /**
     * Gets the specified team (full team model)
     * @param number the team's frc number
     * @return Team object (full model)
     */
    public Team getTeam(int number) {
        return parseTeam(IO.doRequest("teams/frc"+number));
    }

    /**
     * Gets the specified team (simple team model)
     * @param number the team's frc number
     * @return STeam object (simple model)
     */
    public STeam getSTeam(int number) {
        return parseSTeam(IO.doRequest("teams/frc"+number+"/simple"));
    }

    /**
     * Returns an array containing the years that a particular team participated in FRC events
     * @param number the team's frc number
     * @return long[] containing years participated
     */
    public long[] getYearsParticipated(int number) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/frc"+number+"/years_participated");
        if(keys == null) return null;
        String[] data = Arrays.asList(keys.toArray()).toArray(new String[keys.size()]);
        long[] years = new long[data.length];
        for(int i = 0; i < years.length; i++) {
            years[i] = Long.parseLong(data[i]);
        }
        return years;
    }

    /**
     * Gets the districts this team was in, empty array if none
     * @param number the team's frc number
     * @return District[] containing a District object for each district this team was in
     */
    public District[] getDistricts(int number) {
        return parseDistrictList(IO.doRequest("teams/frc"+number+"/districts"));
    }

    /**
     * Gets the robots that this team has had
     * @param number the team's frc number
     * @return Robot[] containing a Robot object for each robot this team has built
     */
    public Robot[] getRobots(int number) {
        return parseRobots(IO.doRequest("teams/frc"+number+"/robots"));
    }

    /**
     * Gets a list of all events this team has competed at.
     * @param number the team's frc number
     * @return Event[] containing an Event object for each event this team was in
     */
    public Event[] getEvents(int number) {
        JSONArray events = (JSONArray) IO.doRequest("teams/frc"+number+"/events");
        if(events == null) return null;
        Event[] toGet = new Event[events.size()];
        for(int i = 0; i < events.size(); i++) {
            toGet[i] = parseEvent(events.get(i));
        }
        return toGet;
    }

    /**
     * Gets a list of all events this team has competed at.
     * @param number the team's frc number
     * @return SEvent[] containing an Event object for each event this team was in (simple model)
     */
    public SEvent[] getSEvents(int number) {
        JSONArray events = (JSONArray) IO.doRequest("teams/frc"+number+"/events/simple");
        if(events == null) return null;
        SEvent[] toGet = new SEvent[events.size()];
        for(int i = 0; i < events.size(); i++) {
            toGet[i] = parseSEvent(events.get(i));
        }
        return toGet;
    }

    /**
     * Gets a list of events this team has competed at in the given year.
     * @param number the team's frc number
     * @param year the year to get events from
     * @return Event[] containing an Event object for each event this team was in the specified year (full model)
     */
    public Event[] getEvents(int number, int year) {
        JSONArray events = (JSONArray) IO.doRequest("teams/frc"+number+"/events/"+year);
        if(events == null) return null;
        Event[] toGet = new Event[events.size()];
        for(int i = 0; i < events.size(); i++) {
            toGet[i] = parseEvent(events.get(i));
        }
        return toGet;
    }

    /**
     * Gets a short-form list of events this team has competed at in the given year.
     * @param number the team's frc number
     * @param year the year to get events from
     * @return Event[] containing an Event object for each event this team was in the specified year (simple model)
     */
    public SEvent[] getSEvents(int number, int year) {
        JSONArray events = (JSONArray) IO.doRequest("teams/frc"+number+"/events/"+year+"/simple");
        if(events == null) return null;
        SEvent[] toGet = new SEvent[events.size()];
        for(int i = 0; i < events.size(); i++) {
            toGet[i] = parseSEvent(events.get(i));
        }
        return toGet;
    }

    /**
     * Gets a list of the event keys for events this team has competed at in the given year.
     * @param number the team's frc number
     * @param year the year to get events from
     * @return String[] containing an event key for each event this team has participated in
     */
    public String[] getEventKeys(int number, int year) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/frc"+number+"/events/"+year+"/keys");
        return Arrays.asList(keys.toArray()).toArray(new String[keys.size()]);
    }

    /**
     * Gets a list of matches for the given team and event.
     * @param number the team's frc number
     * @param eventKey the event's key code (example: '2016nytr')
     * @return Match[] containing a match for each match this team was in in the specified event
     */
    public Match[] getTeamEventMatches(int number, String eventKey) {
        JSONArray matches = (JSONArray) IO.doRequest("teams/frc"+number+"/event/"+eventKey+"/matches");
        if(matches == null) return null;
        Match[] toGet = new Match[matches.size()];
        for(int i = 0; i < matches.size(); i++) {
            toGet[i] = parseMatch(matches.get(i));
        }
        return toGet;
    }

    /**
     * Gets a short-form list of matches for the given team and event.
     * @param number the team's frc number
     * @param eventKey the event's key code (example: '2016nytr')
     * @return SMatch[] containing a match for each match this team was in in the specified event (simple model)
     */
    public SMatch[] getTeamEventSMatches(int number, String eventKey) {
        JSONArray matches = (JSONArray) IO.doRequest("teams/frc"+number+"/event/"+eventKey+"/matches/simple");
        if(matches == null) return null;
        SMatch[] toGet = new SMatch[matches.size()];
        for(int i = 0; i < matches.size(); i++) {
            toGet[i] = parseSMatch(matches.get(i));
        }
        return toGet;
    }

    /**
     * Gets a list of the event keys for events this team has competed at in the given year.
     * @param number the team's frc number
     * @param eventKey the event's key code (example: '2016nytr')
     * @return String[] containing an event key for each event this team has participated in
     */
    public String[] getMatchKeys(int number, String eventKey) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/frc"+number+"/event/"+eventKey+"/matches/keys");
        return Arrays.asList(keys.toArray()).toArray(new String[keys.size()]);
    }

    /**
     * Gets a list of awards the given team won at the given event.
     * @param number the team's frc number
     * @param eventKey
     * @return Award[] containing n award object for each award this team won in the specified event
     */
    public Award[] getTeamEventAwards(int number, String eventKey) {
        JSONArray awards = (JSONArray) IO.doRequest("team/frc"+number+"/event/"+eventKey+"/awards");
        if(awards == null) return null;
        Award[] toGet= new Award[awards.size()];
        for(int i = 0; i < awards.size(); i++) {
            toGet[i] = parseAward(awards.get(i));
        }
        return toGet;
    }



}
