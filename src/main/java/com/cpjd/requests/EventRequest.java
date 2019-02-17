package com.cpjd.requests;

import com.cpjd.main.TBA;
import com.cpjd.models.events.*;
import com.cpjd.models.matches.SMatch;
import com.cpjd.models.teams.STeam;
import com.cpjd.models.matches.Match;
import com.cpjd.models.teams.Team;
import org.json.simple.JSONArray;
import com.cpjd.utils.IO;
import com.cpjd.utils.Parser;
import com.cpjd.utils.Utils;
import com.cpjd.utils.exceptions.DataNotFoundException;
import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * In an attempt to keep this API organized, if you look at the blue alliance v3 documentation, all calls that start with /events/ or /event/
 * will be accessed from this class.
 *
 * API calls not implemented yet:
 * /event/{event_key}/district_points
 * /event/{event_key}/alliances
 * /event/{event_key}/insights
 * /event/{event_key}/rankings
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class EventRequest extends Parser {

    /**
     * Mirror of: /event/{event_key}/teams
     *
     * Gets a list of Team objects that competed in the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return the Team[] array that this event includes
     */
    public Team[] getEventTeams(String eventKey) {
        JSONArray teams = (JSONArray) IO.doRequest("event/"+eventKey+"/teams");
        if(teams == null) throw new DataNotFoundException("Couldn't find any teams in event with key: "+eventKey);
        Team[] toGet = new Team[teams.size()];
        for(int i = 0; i < teams.size(); i++) toGet[i] = parseTeam(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /event/{event_key}/teams/simple
     *
     * Gets a list of Team objects that competed in the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return the STeam[] array that this event includes (simple model)
     */
    public STeam[] getSEventTeams(String eventKey) {
        JSONArray teams = (JSONArray) IO.doRequest("event/"+eventKey+"/teams/simple");
        if(teams == null) throw new DataNotFoundException("Couldn't find any simple teams in event with key: "+eventKey);
        STeam[] toGet = new STeam[teams.size()];
        for(int i = 0; i < teams.size(); i++) toGet[i] = parseSTeam(teams.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /event/{event_key}/teams/keys
     *
     * Gets a list of Team keys that competed in the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return String[] containing all the team keys in this event
     */
    public String[] getTeamKeys(String eventKey) {
        JSONArray keys = (JSONArray) IO.doRequest("event/"+eventKey+"/teams/keys");
        if(keys == null) throw new DataNotFoundException("Couldn't find any team keys in event with key: "+eventKey);
        return Utils.jsonArrayToStringArray(keys);
    }

    /**
     * Mirror of: /events/{year}
     *
     * Gets a list of events in the given year.
     * @param year Competition Year (or Season). Must be 4 digits.
     * @return Event[] containing all the events in the specified year
     */
    public Event[] getEvents(int year) {
        JSONArray events = (JSONArray) IO.doRequest("events/"+year);
        if(events == null) throw new DataNotFoundException("Couldn't find any events in year: "+year);
        Event[] toGet = new Event[events.size()];
        for(int i = 0; i < events.size(); i++) toGet[i] = parseEvent(events.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /events/{year}/simple
     *
     * Gets a list of events in the given year.
     * @param year Competition Year (or Season). Must be 4 digits.
     * @return SEvent[] containing all the events in the specified year
     */
    public SEvent[] getSEvents(int year) {
        JSONArray events = (JSONArray) IO.doRequest("events/"+year+"/simple");
        if(events == null) throw new DataNotFoundException("Couldn't find any simple events in year: "+year);
        SEvent[] toGet = new SEvent[events.size()];
        for(int i = 0; i < events.size(); i++) toGet[i] = parseSEvent(events.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /events/{year}/keys
     *
     * Gets a list of event keys in the given year.
     * @param year Competition Year (or Season). Must be 4 digits.
     * @return String[] containing event keys for the specified year
     */
    public String[] getEventKeys(int year) {
        JSONArray keys = (JSONArray) IO.doRequest("events/"+year+"/keys");
        if(keys == null) throw new DataNotFoundException("Couldn't find any event keys in year: "+year);
        return Utils.jsonArrayToStringArray(keys);
    }

    /**
     * Mirror of: /event/{event_key}
     *
     * Gets an Event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Event model representing the event associated with the event key
     */
    public Event getEvent(String eventKey) {
        Event event = parseEvent(IO.doRequest("event/"+eventKey));
        if(event == null) throw new DataNotFoundException("No event found with key: "+eventKey);
        return event;
    }

    /**
     * Mirror of: /event/{event_key}/simple
     *
     * Gets an Event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Event model representing the event associated with the event key
     */
    public SEvent getSEvent(String eventKey) {
        SEvent event = parseSEvent(IO.doRequest("event/"+eventKey+"/simple"));
        if(event == null) throw new DataNotFoundException("No simple event found with key: "+eventKey);
        return event;
    }

    /**
     * Mirror of: /event/{event_key}/alliances
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return List of all alliances in this event
     */
    public Alliance[] getEventAlliances(String eventKey) {
        JSONArray alliances = (JSONArray) IO.doRequest("event/"+eventKey+"/alliances");
        if(alliances == null) throw new DataNotFoundException("No alliances found for event with key: "+eventKey);
        Alliance[] toGet = new Alliance[alliances.size()];
        for(int i = 0; i < alliances.size(); i++) toGet[i] = parseEventAlliance(alliances.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /event/{event_key}/insights
     *
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Insights for this event
     */
    public Insight getEventInsights(String eventKey) {
        JSONObject insights = (JSONObject) IO.doRequest("event/"+eventKey+"/insights");
        Insight toReturn = parseInsight(insights);
        if(toReturn == null) throw new DataNotFoundException("No insights found for event with key: "+eventKey);
        return toReturn;
    }

    /**
     * Mirror of: /event/{event_key}/oprs
     *
     * Gets a set of Event OPRs (including OPR, DPR, and CCWM) for the given Event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return EventOPR[] containing an EventOPR for each team
     */
    public EventOPR[] getOprs(String eventKey) {
        EventOPR[] oprs = parseOPRs(IO.doRequest("event/"+eventKey+"/oprs"));
        if(oprs == null) throw new DataNotFoundException("No oprs found for event with key: "+eventKey);
        TBA.sort(oprs);
        return oprs;
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
        String s =  (String) IO.doRequest("event/"+eventKey+"predictions");
        if(s == null) throw new DataNotFoundException("No predictions found for event with key: "+eventKey);
        return s;
    }

    /**
     * Mirror of: /event/{event_key}/matches
     *
     * Gets a list of matches for the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Match[] containing a Match object for each match in the specified event
     */
    public Match[] getMatches(String eventKey) {
        JSONArray matches = (JSONArray) IO.doRequest("event/"+eventKey+"/matches");
        if(matches == null) throw new DataNotFoundException("No matches found for event with key: "+eventKey);
        Match[] toGet = new Match[matches.size()];
        for(int i = 0; i < matches.size(); i++) toGet[i] = parseMatch(matches.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /event/{event_key}/matches/simple
     *
     * Gets a list of matches for the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Match[] containing a Match object for each match in the specified event
     */
    public SMatch[] getSMatches(String eventKey) {
        JSONArray matches = (JSONArray) IO.doRequest("event/"+eventKey+"/matches/simple");
        if(matches == null) throw new DataNotFoundException("No simple matches found for event with key: "+eventKey);
        SMatch[] toGet = new SMatch[matches.size()];
        for(int i = 0; i < matches.size(); i++) toGet[i] = parseSMatch(matches.get(i));
        TBA.sort(toGet);
        return toGet;
    }

    /**
     * Mirror of: /event/{event_key}/matches/keys
     *
     * GGets a list of match keys for the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return String[] containing matches keys for the specified event
     */
    public String[] getMatchKeys(String eventKey) {
        JSONArray keys = (JSONArray) IO.doRequest("event/"+eventKey+"/matches/keys");
        if(keys == null) throw new DataNotFoundException("No match keys found for event with key: "+eventKey);
        return Utils.jsonArrayToStringArray(keys);
    }

    /**
     * Mirror of: /event/{event_key}/awards
     *
     * Gets a list of awards from the given event.
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return Award[] containing all the awards won in this event
     */
    public Award[] getEventAwards(String eventKey) {
        JSONArray array = (JSONArray) IO.doRequest("event/"+eventKey+"/awards");
        if(array == null)  throw new DataNotFoundException("No awards found for event with key: "+eventKey);
        Award[] toReturn = new Award[array.size()];
        for(int i = 0; i < array.size(); i++) toReturn[i] = parseAward(array.get(i));
        return toReturn;
    }

    /**
     * Mirror of: /event/{event_key}/rankings
     * @param eventKey TBA Event Key, eg 2016nytr
     * @return EventRanking[] containing rankings of teams in this event
     */
    public EventRanking[] getEventRankings(String eventKey) {
        JSONObject ranking = (JSONObject) (IO.doRequest("event/"+eventKey+"/rankings"));

        if(ranking == null)  throw new DataNotFoundException("No rankings found for event with key: "+eventKey);
        JSONArray rankings = (JSONArray) ranking.get("rankings");
        EventRanking[] toGet = new EventRanking[rankings.size()];
        for(int i = 0; i < rankings.size(); i++) toGet[i] = parseEventRanking(rankings.get(i));
        TBA.sort(toGet);
        return toGet;
    }

}
