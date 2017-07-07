package utils;

import models.other.APIStatus;
import models.simple.STeam;
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
        team.setLatitude((Double)hash.get("lat"));
        team.setLongitude((Double)hash.get("lng"));
        team.setLocationName((String)hash.get("location_name"));
        team.setWebsite((String)hash.get("website"));
        team.setRookieYear((long)hash.get("rookie_year"));
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

}
