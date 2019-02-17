package com.cpjd.requests;

import com.cpjd.main.TBA;
import com.cpjd.models.events.Award;
import com.cpjd.models.events.Media;
import com.cpjd.models.teams.Robot;
import com.cpjd.models.events.SEvent;
import com.cpjd.models.matches.SMatch;
import com.cpjd.models.teams.STeam;
import com.cpjd.models.events.Event;
import com.cpjd.models.matches.Match;
import com.cpjd.models.teams.Team;
import org.json.simple.JSONArray;
import com.cpjd.utils.IO;
import com.cpjd.utils.Parser;
import com.cpjd.utils.Utils;
import com.cpjd.utils.exceptions.DataNotFoundException;

/**
 * In an attempt to keep this API organized, if you look at the blue alliance v3 documentation, all calls that start with /teams/ or /team/
 * will be accessed from this class.
 *
 * API calls not implemented yet:
 * /team/{team_key}/event/{event_key}/status
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class TeamRequest extends Parser {

    /**
     * Mirror of: /teams/{page_num}
     *
     * Gets a list of Team objects, paginated in groups of 500.
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of Team objects (full team models)
     */
    public Team[] getTeams(int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+pageNum);
        if(teams == null) throw new DataNotFoundException("No teams were found with pageNum: "+pageNum);
        Team[] toGet = new Team[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseTeam(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /teams/{page_num}/simple
     *
     * Gets a list of STeam objects, paginated in groups of 500.
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return list of STeam objects (simple team models)
     */
    public STeam[] getSTeams(int pageNum) {
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+pageNum+"/simple");
        if(teams == null) throw new DataNotFoundException("No simple teams were found with pageNum: "+pageNum);
        STeam[] toGet = new STeam[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseSTeam(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /teams/{page_num}/keys
     *
     * Gets a list of Team keys, paginated in groups of 500. (Note, each page will not have 500 teams, but will include the teams within that range of 500.)
     * @param pageNum the page number, eg: 0 for the first 500, 1 for the second 500, etc.
     * @return String[] of team keys in the format 'frc254'
     */
    public String[] getTeamKeys(int pageNum) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/"+pageNum+"/keys");
        if(keys == null) throw new DataNotFoundException("No team key was found with pageNum: "+pageNum);
        return Utils.jsonArrayToStringArray(keys);
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
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum);
        if(teams == null) throw new DataNotFoundException("No teams were found with pageNum: "+pageNum+", year: "+year);
        Team[] toGet = new Team[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseTeam(teams.get(i));
        TBA.sort(toGet);
        return toGet;
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
        JSONArray teams = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum+"/simple");
        if(teams == null) throw new DataNotFoundException("No simple teams were found with pageNum: "+pageNum+", year: "+year);
        STeam[] toGet = new STeam[teams.size()];
        for(int i = 0; i < toGet.length; i++) toGet[i] = parseSTeam(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /team/{year}/{page_num}/keys
     *
     * Gets a list Team Keys that competed in the given year, paginated in groups of 500.
     * @param year the year to get teams from
     * @return String[] of team keys in format 'frc254'
     */
    public String[] getTeamKeys(int year, int pageNum) {
        JSONArray keys = (JSONArray) IO.doRequest("teams/"+year+"/"+pageNum+"/keys");
        if(keys == null) throw new DataNotFoundException("No team keys were found with pageNum: "+pageNum+", year: "+year);
        return Utils.jsonArrayToStringArray(keys);
    }

    /**
     * Mirror of: /team/{team_key}
     *
     * Gets the specified team (full team model)
     * @param number the team's frc number
     * @return Team object (full model)
     */
    public Team getTeam(int number) {
        Team team = parseTeam(IO.doRequest("team/frc"+number));
        if(team == null) throw new DataNotFoundException("No team found with number: "+number);
        return team;
    }

    /**
     * Mirror of: /team{team_key}/simple
     *
     * Gets the specified team (simple team model)
     * @param number the team's frc number
     * @return STeam object (simple model)
     */
    public STeam getSTeam(int number) {
        STeam team = parseSTeam(IO.doRequest("team/frc"+number));
        if(team == null) throw new DataNotFoundException("No simple team found with number: "+number);
        return team;
    }

    /**
     * Mirror of: /team/{team_key}/years_participated
     *
     * Returns an array containing the years that a particular team participated in FRC events
     * @param number the team's frc number
     * @return long[] containing years participated
     */
    public long[] getYearsParticipated(int number) {
        JSONArray keys = (JSONArray) IO.doRequest("team/frc"+number+"/years_participated");
        if(keys == null) throw new DataNotFoundException("Couldn't find years participated for team with number: "+number);
        String[] data = Utils.jsonArrayToStringArray(keys);
        long[] years = new long[data.length];
        for(int i = 0; i < years.length; i++) {
            years[i] = Long.parseLong(data[i]);
        }
        return years;
    }

    /**
     * Mirror of: /team/{team_key}/districts
     *
     * Gets the districts this team was in, empty array if none
     * @param number the team's frc number
     * @return District[] containing a District object for each district this team was in
     */
    public String[] getTeamDistricts(int number) {
        JSONArray keys = (JSONArray) IO.doRequest("team/frc"+number+"/districts");
        if(keys == null) throw new DataNotFoundException("Couldn't find any district keys for team with number: "+number);
        return Utils.jsonArrayToStringArray(keys);
    }

    /**
     * Mirror of: /team{team_key}/robots
     *
     * Gets the robots that this team has had
     * @param number the team's frc number
     * @return Robot[] containing a Robot object for each robot this team has built
     */
    public Robot[] getRobots(int number) {
        Robot[] robots = parseRobots(IO.doRequest("team/frc"+number+"/robots"));
        if(robots == null) throw new DataNotFoundException("Couldn't robots for team with number: "+number);
        TBA.sort(robots);
        return robots;
    }

    /**
     * Mirror of: /team/{team_key}/events
     *
     * Gets a list of all events this team has competed at.
     * @param number the team's frc number
     * @return Event[] containing an Event object for each event this team was in
     */
    public Event[] getTeamEvents(int number) {
        JSONArray events = (JSONArray) IO.doRequest("team/frc"+number+"/events");
        if(events == null) throw new DataNotFoundException("Couldn't find any events for team with number: "+number);
        Event[] toGet = new Event[events.size()];
        for(int i = 0; i < events.size(); i++) {
            toGet[i] = parseEvent(events.get(i));
        }
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /team/{team_key}/events/simple
     *
     * Gets a list of all events this team has competed at.
     * @param number the team's frc number
     * @return SEvent[] containing an Event object for each event this team was in (simple model)
     */
    public SEvent[] getTeamSEvents(int number) {
        JSONArray events = (JSONArray) IO.doRequest("team/frc"+number+"/events/simple");
        if(events == null) throw new DataNotFoundException("Couldn't find any simple events for team with number: "+number);
        SEvent[] toGet = new SEvent[events.size()];
        for(int i = 0; i < events.size(); i++) {
            toGet[i] = parseSEvent(events.get(i));
        }
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /team/{team_key}/events_keys
     *
     * Gets a list of the event keys for all events this team has competed at.
     * @param number the team's frc number
     * @return String[] containg all the event keys for events this team is in
     */
    public String[] getTeamEventKeys(int number) {
        JSONArray keys = (JSONArray) IO.doRequest("team/frc"+number+"/events/keys");
        if(keys == null) throw new DataNotFoundException("Couldn't find any event keys for team with number: "+number);
        return Utils.jsonArrayToStringArray(keys);
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
        JSONArray events = (JSONArray) IO.doRequest("team/frc"+number+"/events/"+year);
        if(events == null) throw new DataNotFoundException("Couldn't find any events for team with number: "+number+", year: "+year);
        Event[] toGet = new Event[events.size()];
        for(int i = 0; i < events.size(); i++) {
            toGet[i] = parseEvent(events.get(i));
        }
        TBA.sort(toGet);
        return toGet;
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
        JSONArray events = (JSONArray) IO.doRequest("team/frc"+number+"/events/"+year+"/simple");
        if(events == null) throw new DataNotFoundException("Couldn't find any simple events for team with number: "+number+", year: "+year);
        SEvent[] toGet = new SEvent[events.size()];
        for(int i = 0; i < events.size(); i++) {
            toGet[i] = parseSEvent(events.get(i));
        }
        TBA.sort(toGet);
        return toGet;
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
        JSONArray keys = (JSONArray) IO.doRequest("team/frc"+number+"/events/"+year+"/keys");
        if(keys == null) throw new DataNotFoundException("Couldn't find any event keys for team with number: "+number+", year: "+year);
        return Utils.jsonArrayToStringArray(keys);
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
        JSONArray matches = (JSONArray) IO.doRequest("team/frc"+number+"/event/"+eventKey+"/matches");
        if(matches == null) throw new DataNotFoundException("Couldn't find any matches for team with number: "+number+", event key: "+eventKey);
        Match[] toGet = new Match[matches.size()];
        for(int i = 0; i < matches.size(); i++) {
            toGet[i] = parseMatch(matches.get(i));
        }
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/matches/simple
     *
     * Gets a short-form list of matches for the given team and event.
     * @param number the team's frc number
     * @param eventKey the event's key code (example: '2016nytr')
     * @return SMatch[] containing a match for each match this team was in in the specified event (simple model)
     */
    public SMatch[] getTeamEventSMatches(int number, String eventKey) {
        JSONArray matches = (JSONArray) IO.doRequest("team/frc"+number+"/event/"+eventKey+"/matches/simple");
        if(matches == null) throw new DataNotFoundException("Couldn't find any simple matches for team with number: "+number+", event key: "+eventKey);
        SMatch[] toGet = new SMatch[matches.size()];
        for(int i = 0; i < matches.size(); i++) {
            toGet[i] = parseSMatch(matches.get(i));
        }
        TBA.sort(toGet);
        return toGet;
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
        JSONArray keys = (JSONArray) IO.doRequest("team/frc"+number+"/event/"+eventKey+"/matches/keys");
        if(keys == null) throw new DataNotFoundException("Couldn't find any matche keys for team with number: "+number+", event key: "+eventKey);
        return Utils.jsonArrayToStringArray(keys);
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
        JSONArray awards = (JSONArray) IO.doRequest("team/frc"+number+"/event/"+eventKey+"/awards");
        if(awards == null) throw new DataNotFoundException("Couldn't find any awards for team with number: "+number+", event key: "+eventKey);
        Award[] toGet= new Award[awards.size()];
        for(int i = 0; i < awards.size(); i++) toGet[i] = parseAward(awards.get(i));
        return toGet;
    }

    /**
     * Mirror of: /team/{team_key}/awards
     *
     * Gets a list of awards the given team has won.
     * @param number the team's frc number
     * @return Award[] containing all the awards this team has won
     */
    public Award[] getTeamAwards(int number) {
        JSONArray awards = (JSONArray) IO.doRequest("team/frc"+number+"/awards");
        if(awards == null) throw new DataNotFoundException("Couldn't find any awards for team with number: "+number);
        Award[] toGet= new Award[awards.size()];
        for(int i = 0; i < awards.size(); i++) toGet[i] = parseAward(awards.get(i));
        return toGet;
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
        JSONArray awards = (JSONArray) IO.doRequest("team/frc"+number+"/awards/"+year);
        if(awards == null) throw new DataNotFoundException("Couldn't find any awards for team with number: "+number+", year: "+year);
        Award[] toGet= new Award[awards.size()];
        for(int i = 0; i < awards.size(); i++) toGet[i] = parseAward(awards.get(i));
        return toGet;
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
        JSONArray matches = (JSONArray) IO.doRequest("team/frc"+number+"/matches/"+year);
        if(matches == null)  throw new DataNotFoundException("Couldn't find any matches for team with number: "+number+", year: "+year);
        Match[] toGet = new Match[matches.size()];
        for(int i = 0; i < matches.size(); i++) toGet[i] = parseMatch(matches.get(i));
        TBA.sort(toGet);
        return toGet;
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
        JSONArray matches = (JSONArray) IO.doRequest("team/frc"+number+"/matches/"+year+"/simple");
        if(matches == null) throw new DataNotFoundException("Couldn't find any simple matches for team with number: "+number+", year: "+year);
        SMatch[] toGet = new SMatch[matches.size()];
        for(int i = 0; i < matches.size(); i++) toGet[i] = parseSMatch(matches.get(i));
        TBA.sort(toGet);
        return toGet;
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
        JSONArray keys = (JSONArray) IO.doRequest("team/frc"+number+"/matches/"+year+"/keys");
        if(keys == null) throw new DataNotFoundException("Couldn't find any match keys for team with number: "+number+", year: "+year);
        return Utils.jsonArrayToStringArray(keys);
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
        JSONArray medias = (JSONArray) IO.doRequest("team/frc"+number+"/media/"+year);
        if(medias == null) throw new DataNotFoundException("Couldn't find any media for team with number: "+number+", year: "+year);
        Media[] toGet = new Media[medias.size()];
        for(int i = 0; i < medias.size(); i++) toGet[i] = parseMedia(medias.get(i));
        return toGet;
    }

    /**
     * Mirror of: /team/{team_key}/social_media
     *
     * Gets a list of Media (social media) for the given team.
     * @param number the team's frc number
     * @return Media[] containing all social media associated with this team
     */
    public Media[] getTeamSocialMedia(int number) {
        JSONArray medias = (JSONArray) IO.doRequest("team/frc"+number+"/social_media");
        if(medias == null) throw new DataNotFoundException("Couldn't find any social media for team with number: "+number);
        Media[] toGet = new Media[medias.size()];
        for(int i = 0; i < medias.size(); i++) toGet[i] = parseMedia(medias.get(i));
        return toGet;
    }
}
