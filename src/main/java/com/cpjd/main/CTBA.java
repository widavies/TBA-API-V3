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

/**
 * This is an alternative to the TBA class. It allows you to use constructors/getters/setters. For more information on this,
 * read the javadoc header for the TBA class.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@SuppressWarnings("unused")
public class CTBA {

    /**
     * TBA District Key, eg 2016fim
     */
    private String districtKey;
    /**
     * TBA Team Key, eg frc254
     */
    private int number;
    /**
     * Page number of results to return, zero-indexed
     */
    private int pageNum;
    /**
     * TBA Event Key, eg 2016nytr
     */
    private String eventKey;
    /**
     * TBA Match Key, eg 2016nytr_qm1
     */
    private String matchKey;
    /**
     * Competition Year (or Season). Must be 4 digits.
     */
    private int year;

    private DistrictRequest dr;
    private EventRequest er;
    private MatchRequest mr;
    private OtherRequest or;
    private TeamRequest tr;

    public CTBA() {
        dr = new DistrictRequest();
        er = new EventRequest();
        mr = new MatchRequest();
        or = new OtherRequest();
        tr = new TeamRequest();
    }

    /**
     * Mirror of: /district/{district_key}/teams
     *
     * @return Team[] including a Team object for every team in the specified district
     */
    public Team[] getDistrictTeams() {
        return dr.getDistrictTeams(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/teams/simple
     *
     * @return STeam[] including a STeam object for every team in the specified district (simple model)
     */
    public STeam[] getDistrictSTeams() {
        return dr.getDistrictSTeams(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/teams/keys
     * <p>
     * Gets a list of Team objects that competed in events in the given district.
     *
     * @return String[] containing all the team keys in this district
     */
    public String[] getDistrictTeamKeys() {
        return dr.getDistrictTeamKeys(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/events
     *
     * @return Event[] including an Event object for every event in the specified district
     */
    public Event[] getDistrictEvents() {
        return dr.getDistrictEvents(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/events/simple
     *
     * @return SEvent[] including an SEvent object for every event in the specified district (simple model)
     */
    public SEvent[] getDistrictSEvents() {
        return dr.getDistrictSEvents(districtKey);
    }

    /**
     * Mirror of: /district/{district_key}/events/keys
     * <p>
     * Gets a list of Team objects that competed in events in the given district.
     *
     * @return String[] containing all the team keys in this district
     */
    public String[] getDistrictEventKeys() {
        return dr.getDistrictEventKeys(districtKey);
    }

    /**
     * Mirror of: /districts/{year}
     * <p>
     * Gets a list of districts and their corresponding district key, for the given year.
     *
     * @return District[] containing a District for each active district in the specified year
     */
    public District[] getDistricts() {
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
    public String[] getEventTeamKeys(String eventKey) {
        return er.getTeamKeys(eventKey);
    }

    /**
     * Mirror of: /events/{year}
     * <p>
     * Gets a list of events in the given year.
     *
     * @return Event[] containing all the events in the specified year
     */
    public Event[] getEvents() {
        return er.getEvents(year);
    }

    /**
     * Mirror of: /event/{event_key}/rankings
     * <p>
     * @return EventRanking[] containing rankings of teams in this event
     */
    public EventRanking[] getEventRankings() { return er.getEventRankings(eventKey); }

    /**
     * Mirror of: /events/{year}/simple
     * <p>
     * Gets a list of events in the given year.
     *
     * @return SEvent[] containing all the events in the specified year
     */
    public SEvent[] getSEvents() {
        return er.getSEvents(year);
    }

    /**
     * Mirror of: /events/{year}/keys
     * <p>
     * Gets a list of event keys in the given year.
     *
     * @return String[] containing event keys for the specified year
     */
    public String[] getEventKeys() {
        return er.getEventKeys(year);
    }

    /**
     * Mirror of: /event/{event_key}
     * <p>
     * Gets an Event.
     *
     * @return Event model representing the event associated with the event key
     */
    public Event getEvent() {
        return er.getEvent(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/simple
     * <p>
     * Gets an Event.
     *
     * @return Event model representing the event associated with the event key
     */
    public SEvent getSEvent() {
        return er.getSEvent(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/oprs
     *
     * Gets a set of Event OPRs (including OPR, DPR, and CCWM) for the given Event.
     * @return EventOPR[] containing an EventOPR for each team
     */
    public EventOPR[] getOprs() {
        return er.getOprs(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/predictions
     *
     * Gets information on TBA-generated predictions for the given Event. Contains year-specific information. WARNING This endpoint is currently under development and may change at any time.
     *
     * Not stable! No official model for this yet.
     * @return JSON String containing prediction information
     */
    public String getPredictions() {
        return er.getPredictions(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/matches
     *
     * Gets a list of matches for the given event.
     * @return Match[] containing a Match object for each match in the specified event
     */
    public Match[] getMatches() {
        return er.getMatches(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/matches/simple
     *
     * Gets a list of matches for the given event.
     * @return Match[] containing a Match object for each match in the specified event
     */
    public SMatch[] getSMatches() {
        return er.getSMatches(eventKey);
    }


    /**
     * Mirror of: /event/{event_key}/matches/keys
     *
     * GGets a list of match keys for the given event.
     * @return String[] containing matches keys for the specified event
     */
    public String[] getMatchKeys() {
        return er.getMatchKeys(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/awards
     *
     * Gets a list of awards from the given event.
     * @return Award[] containing all the awards won in this event
     */
    public Award[] getEventAwards() {
        return er.getEventAwards(eventKey);
    }

    /**
     * Mirror of: /match/{match_key}
     *
     * Gets a Match object for the given match key.
     * @return Match object represented by the match key
     */
    public Match getMatch() {
        return mr.getMatch(matchKey);
    }

    /**
     * Mirror of: /match/{match_key}/simple
     *
     * Gets a Match object for the given match key.
     * @return SMatch object represented by the match key (simple model)
     */
    public SMatch getSMatch() {
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
     * @return list of Team objects (full team models)
     */
    public Team[] getTeams() {
        return tr.getTeams(pageNum);
    }

    /**
     * Mirror of: /teams/{page_num}/simple
     *
     * Gets a list of STeam objects, paginated in groups of 500.
     * @return list of STeam objects (simple team models)
     */
    public STeam[] getSTeams() {
        return tr.getSTeams(pageNum);
    }

    /**
     * Mirror of: /teams/{page_num}/keys
     *
     * Gets a list of Team keys, paginated in groups of 500. (Note, each page will not have 500 teams, but will include the teams within that range of 500.)
     * @return String[] of team keys in the format 'frc254'
     */
    public String[] getTeamKeys() {
        return tr.getTeamKeys(pageNum);
    }

    /**
     * Mirror of: /teams/{year}/{page_num}
     *
     * Gets a list of Team objects that competed in the given year, paginated in groups of 500.
     * @return list of Team objects (full models)
     */
    public Team[] getTeamsByPage() {
        return tr.getTeams(pageNum);
    }

    /**
     * Mirror of: /teams/{year}/{page_num}/simple
     *
     * Gets a list of Team objects that competed in the given year, paginated in groups of 500.
     * @return list of Team objects (simple models)
     */
    public STeam[] getSTeamsByPage() {
        return tr.getSTeams(year, pageNum);
    }

    /**
     * Mirror of: /team/{year}/{page_num}/keys
     *
     * Gets a list Team Keys that competed in the given year, paginated in groups of 500.
     * @return String[] of team keys in format 'frc254'
     */
    public String[] getTeamKeysByPage() {
        return tr.getTeamKeys(year, pageNum);
    }

    /**
     * Mirror of: /team/{team_key}
     *
     * Gets the specified team (full team model)
     * @return Team object (full model)
     */
    public Team getTeam() {
        return tr.getTeam(number);
    }

    /**
     * Mirror of: /team{team_key}/simple
     *
     * Gets the specified team (simple team model)
     * @return STeam object (simple model)
     */
    public STeam getSTeam() {
        return tr.getSTeam(number);
    }

    /**
     * Mirror of: /team/{team_key}/years_participated
     *
     * Returns an array containing the years that a particular team participated in FRC events
     * @return long[] containing years participated
     */
    public long[] getYearsParticipated() {
        return tr.getYearsParticipated(number);
    }

    /**
     * Mirror of: /team/{team_key}/districts
     *
     * Gets the districts this team was in, empty array if none
     * @return District[] containing a District object for each district this team was in
     */
    public String[] getTeamDistricts() {
        return tr.getTeamDistricts(number);
    }

    /**
     * Mirror of: /team{team_key}/robots
     *
     * Gets the robots that this team has had
     * @return Robot[] containing a Robot object for each robot this team has built
     */
    public Robot[] getRobots() {
        return tr.getRobots(number);
    }

    /**
     * Mirror of: /team/{team_key}/events
     *
     * Gets a list of all events this team has competed at.
     * @return Event[] containing an Event object for each event this team was in
     */
    public Event[] getTeamEvents() {
        return tr.getTeamEvents(number);
    }

    /**
     * Mirror of: /team/{team_key}/events/simple
     *
     * Gets a list of all events this team has competed at.
     * @return SEvent[] containing an Event object for each event this team was in (simple model)
     */
    public SEvent[] getTeamSEvents() {
        return tr.getTeamSEvents(number);
    }

    /**
     * Mirror of: /team/{team_key}/events_keys
     *
     * Gets a list of the event keys for all events this team has competed at.
     * @return String[] containg all the event keys for events this team is in
     */
    public String[] getTeamEventKeys() {
        return tr.getTeamEventKeys(number);
    }

    /**
     * Mirror of: /team/{team_key}/events/{year}
     *
     * Gets a list of events this team has competed at in the given year.
     * @return Event[] containing an Event object for each event this team was in the specified year (full model)
     */
    public Event[] getTeamEventsByYear() {
        return tr.getEvents(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/events/{year}/simple
     *
     * Gets a short-form list of events this team has competed at in the given year.
     * @return Event[] containing an Event object for each event this team was in the specified year (simple model)
     */
    public SEvent[] getTeamSEventsByYear() {
        return tr.getSEvents(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/events/{year}/keys
     *
     * Gets a list of the event keys for events this team has competed at in the given year.
     * @return String[] containing an event key for each event this team has participated in
     */
    public String[] getTeamEventKeysByYear() {
        return tr.getEventKeys(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/matches
     *
     * Gets a list of matches for the given team and event.
     * @return Match[] containing a match for each match this team was in in the specified event
     */
    public Match[] getTeamEventMatches() {
        return tr.getTeamEventMatches(number, eventKey);
    }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/matches/simple
     *
     * Gets a short-form list of matches for the given team and event.
     * @return SMatch[] containing a match for each match this team was in in the specified event (simple model)
     */
    public SMatch[] getTeamEventSMatches() {
        return tr.getTeamEventSMatches(number, eventKey);
    }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/matches/keys
     *
     * Gets a list of the event keys for events this team has competed at in the given year.
     * @return String[] containing an event key for each event this team has participated in
     */
    public String[] getTeamMatchKeysByEvent() {
        return tr.getMatchKeys(number, eventKey);
    }

    /**
     * Mirror of: /team/{team_key}/event/{event_key}/awards
     *
     * Gets a list of awards the given team won at the given event.
     * @return Award[] containing n award object for each award this team won in the specified event
     */
    public Award[] getTeamEventAwards() {
        return tr.getTeamEventAwards(number, eventKey);
    }

    /**
     * Mirror of: /team/{team_key}/awards
     *
     * Gets a list of awards the given team has won.
     * @return Award[] containing all the awards this team has won
     */
    public Award[] getTeamAwardsByNumber() {
        return tr.getTeamAwards(number);
    }

    /**
     * Mirror of: /team/{team_key}/awards/{year}
     *
     * Gets a list of awards the given team has won.
     * @return Award[] containing all the awards this team has won
     */
    public Award[] getTeamAwards() {
        return tr.getTeamAwards(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/matches/{year}
     *
     * Gets a list of matches for the given team and year.
     * @return Match[] containing all the matches the specified team was in for the specified year
     */
    public Match[] getTeamMatches() {
        return tr.getTeamMatches(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/matches/{year}/simple
     *
     * Gets a list of matches for the given team and year.
     * @return SMatch[] containing all the matches the specified team was in for the specified year (simple models)
     */
    public SMatch[] getTeamSMatches() {
        return tr.getTeamSMatches(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/matches/{year}/keys
     *
     * Gets a list of match keys for matches for the given team and year.
     * @return String[] containing match string keys for each match
     */
    public String[] getTeamMatchKeys() {
        return tr.getTeamMatchKeys(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/media/{year}
     *
     * Gets a list of Media (videos / pictures) for the given team and year.
     * @return Media[] containing all the media associated with this team for the specified year
     */
    public Media[] getTeamMedia() {
        return tr.getTeamMedia(number, year);
    }

    /**
     * Mirror of: /team/{team_key}/social_media
     *
     * Gets a list of Media (social media) for the given team.
     * @return Media[] containing all social media associated with this team
     */
    public Media[] getTeamSocialMedia() {
        return tr.getTeamSocialMedia(number);
    }

    /**
     * Mirror of: /event/{event_key}/alliances
     *
     * @return List of all alliances in this event
     */
    public Alliance[] getEventAlliances() {
        return er.getEventAlliances(eventKey);
    }

    /**
     * Mirror of: /event/{event_key}/insights
     *
     * @return Insights for this event
     */
    public Insight getEventInsights() {
        return er.getEventInsights(eventKey);
    }

    public void setDistrictKey(String districtKey) {
        this.districtKey = districtKey;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDr(DistrictRequest dr) {
        this.dr = dr;
    }

    public void setEr(EventRequest er) {
        this.er = er;
    }

    public void setMr(MatchRequest mr) {
        this.mr = mr;
    }

    public void setOr(OtherRequest or) {
        this.or = or;
    }

    public void setTr(TeamRequest tr) {
        this.tr = tr;
    }

    public String getDistrictKey() {
        return districtKey;
    }

    public int getNumber() {
        return number;
    }

    public int getPageNum() {
        return pageNum;
    }

    public String getEventKey() {
        return eventKey;
    }

    public String getMatchKey() {
        return matchKey;
    }

    public int getYear() {
        return year;
    }

    public DistrictRequest getDr() {
        return dr;
    }

    public EventRequest getEr() {
        return er;
    }

    public MatchRequest getMr() {
        return mr;
    }

    public OtherRequest getOr() {
        return or;
    }

    public TeamRequest getTr() {
        return tr;
    }
}
