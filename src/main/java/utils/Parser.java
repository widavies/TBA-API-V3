package utils;

import jdk.nashorn.internal.scripts.JO;
import models.other.APIStatus;
import models.other.events.Webcast;
import models.other.teams.District;
import models.other.teams.Robot;
import models.simple.SEvent;
import models.simple.STeam;
import models.standard.Event;
import models.standard.Match;
import models.standard.Team;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Converts the data received from the server into the models found in models/
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class Parser {

    public APIStatus parseStatus(Object object) {
        APIStatus status = new APIStatus();
        HashMap hash = (HashMap) object;
        status.setCurrentSeason((long)hash.get("current_season"));
        status.setMaxSeason((long)hash.get("max_season"));
        status.setDatafeedDown((boolean)hash.get("is_datafeed_down"));
        JSONArray downEvents = (JSONArray)hash.get("down_events");
        status.setDownEvents(Arrays.asList(downEvents.toArray()).toArray(new String[downEvents.size()]));
        status.setAndroidMinAppVersion((long) ((JSONObject) hash.get("android")).get("min_app_version"));
        status.setAndroidLatestAppVersion((long) ((JSONObject) hash.get("android")).get("latest_app_version"));
        status.setIosMinAppVersion((long) ((JSONObject) hash.get("ios")).get("min_app_version"));
        status.setIosLatestAppVersion((long) ((JSONObject) hash.get("ios")).get("latest_app_version"));
        return status;
    }

    public Team parseTeam(Object object) {
        Team team = new Team();
        HashMap hash = (HashMap) object;
        team.setKey((String)hash.get("key"));
        team.setTeamNumber((long)hash.get("team_number"));
        team.setNickname((String)hash.get("nickname"));
        team.setName((String)hash.get("name"));
        team.setCity((String)hash.get("city"));
        team.setStateProv((String)hash.get("state_prov"));
        team.setCountry((String)hash.get("country"));
        team.setAddress((String)hash.get("address"));
        team.setPostalCode((String)hash.get("postal_code"));
        team.setGMAPSPlaceID((String)hash.get("gmaps_place_id"));
        team.setGMAPURL((String)hash.get("gmaps_url"));
        team.setLatitude(Utils.cleanDouble(hash.get("lat")));
        team.setLongitude(Utils.cleanDouble(hash.get("lng")));
        team.setLocationName((String)hash.get("location_name"));
        team.setWebsite((String)hash.get("website"));
        team.setRookieYear(Utils.cleanLong(hash.get("rookie_year")));
        team.setMotto((String)hash.get("motto"));
        return team;
    }

    public STeam parseSTeam(Object object) {
        STeam team = new STeam();
        HashMap hash = (HashMap) object;
        team.setKey((String)hash.get("key"));
        team.setTeamNumber((long)hash.get("team_number"));
        team.setNickname((String)hash.get("nickname"));
        team.setName((String)hash.get("name"));
        team.setCity((String)hash.get("city"));
        team.setStateProv((String)hash.get("state_prov"));
        team.setCountry((String)hash.get("country"));
        return team;
    }

    public District[] parseDistrictList(Object object) {
        JSONArray districtsList = (JSONArray) object;
        District[] districts = new District[districtsList.size()];
        for(int i = 0; i < districtsList.size(); i++) {
            District d = new District();
            JSONObject o = (JSONObject) districtsList.get(i);
            d.setDisplayName((String)o.get("display_name"));
            d.setYear(Utils.cleanLong(o.get("year")));
            d.setAbbreviation((String)o.get("abbreviation"));
            d.setKey((String)o.get("key"));
            districts[i] = d;
        }
        return districts;
    }

    public Robot[] parseRobots(Object object) {
        JSONArray robotsList = (JSONArray) object;
        Robot[] robots = new Robot[robotsList.size()];
        for(int i = 0; i < robotsList.size(); i++) {
            Robot r = new Robot();
            JSONObject o = (JSONObject) robotsList.get(i);
            r.setYear(Utils.cleanLong(o.get("year")));
            r.setRobotName((String)o.get("robot_name"));
            r.setKey((String)o.get("key"));
            r.setTeamKey((String)o.get("team_key"));
            robots[i] = r;
        }
        return robots;
    }

    public Event parseEvent(Object object) {
        Event e = new Event();
        HashMap hash = (HashMap) object;
        e.setKey((String)hash.get("key"));
        e.setName((String)hash.get("name"));
        e.setEventCode((String)hash.get("event_code"));
        e.setEventType(Utils.cleanLong(hash.get("event_type")));
        e.setCity((String)hash.get("city"));
        e.setStateProv((String)hash.get("state_prov"));
        e.setCountry((String)hash.get("country"));
        e.setStartDate((String)hash.get("start_date"));
        e.setEndDate((String)hash.get("end_Date"));
        e.setYear(Utils.cleanLong(hash.get("year")));
        e.setShortName((String)hash.get("short_name"));
        e.setEventTypeString((String)hash.get("event_type_string"));
        e.setWeek(Utils.cleanLong(hash.get("week")));
        e.setAddress((String)hash.get("address"));
        e.setPostalCode((String)hash.get("postal_code"));
        e.setGMAPSPlaceID((String)hash.get("gmaps_place_id"));
        e.setGMAPSURL((String)hash.get("gmaps_url"));
        e.setLongitude(Utils.cleanDouble(hash.get("lng")));
        e.setLatitude(Utils.cleanDouble(hash.get("lat")));
        e.setLocationName((String)hash.get("location_name"));
        e.setTimezone((String)hash.get("timezone"));
        e.setWebsite((String)hash.get("website"));
        e.setFirstEventID(Utils.cleanLong(hash.get("first_event_id")));
        e.setParentEventkey((String)hash.get("parent_event_key"));
        e.setPlayoffType(Utils.cleanLong(hash.get("playoff_type")));
        e.setPlayoffTypeString((String)hash.get("playoff_type_string"));
        e.setDistrictsList(parseDistrictList(hash.get("district")));
        JSONArray keys = (JSONArray) hash.get("division_keys");
        e.setDivisonKeys(Arrays.asList(keys.toArray()).toArray(new String[keys.size()]));
        JSONArray webcasts = (JSONArray) hash.get("webcasts");
        Webcast[] casts = new Webcast[webcasts.size()];
        for(int i = 0; i < webcasts.size(); i++) {
            Webcast w = new Webcast();
            JSONObject o = (JSONObject) webcasts.get(i);
            w.setChannel((String)o.get("channel"));
            w.setType((String)o.get("type"));
            w.setFile((String)o.get("file"));
            casts[i] = w;
        }
        e.setWebcasts(casts);
        return e;
    }

    private SEvent parseSEvent(Object object) {
        SEvent e = new SEvent();
        HashMap hash = (HashMap) object;
        e.setKey((String)hash.get("key"));
        e.setName((String)hash.get("name"));
        e.setEventCode((String)hash.get("event_code"));
        e.setEventType(Utils.cleanLong(hash.get("event_type")));
        e.setStateProv((String)hash.get("state_prov"));
        e.setCountry((String)hash.get("country"));
        e.setStartDate((String)hash.get("start_date"));
        e.setEndDate((String)hash.get("end_Date"));
        e.setYear(Utils.cleanLong(hash.get("year")));
        e.setDistrictsList(parseDistrictList(hash.get("district")));
        return e;
    }

    private Match parseMatch(Object object) {
        Match m = new Match();
        HashMap hash = (HashMap) object;
        m.setKey((String)hash.get("key"));
        m.setCompLevel((String)hash.get("comp_level"));
        m.setSetNumber(Utils.cleanLong(hash.get("set_number")));
        m.setMatchNumber(Utils.cleanLong(hash.get("match_number")));
        m.setWinningAlliance((String)hash.get("winning_alliance"));
        m.setEventKey((String)hash.get("event_key"));
        m.setTime(Utils.cleanLong(hash.get("time")));
        m.setActualTime(Utils.cleanLong(hash.get("actual_time")));
        m.setPredictedTime(Utils.cleanLong(hash.get("predicted_time")));
        m.setPostResultTime(Utils.cleanLong(hash.get("post_result_time")));
        JSONObject allies = (JSONObject) hash.get("alliance");
        return null;


    }

}
